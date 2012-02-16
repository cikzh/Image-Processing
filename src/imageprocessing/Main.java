package imageprocessing;

/**
 * 
 * Simple program to test out different 
 * image processing algorithms
 * 
 * TODO: Improve Save Image GUI
 * TODO: Support for RGB images
 * TODO: Load external kernels
 * TODO: Improve GUI
 * TODO: Make image panel scrollable
 *  
 * @author Marlon Peeters
 * 
 */

import imageprocessing.image.operations.AddOp;
import imageprocessing.image.operations.EqualizeOp;
import imageprocessing.image.operations.ExpOp;
import imageprocessing.image.operations.InvertOp;
import imageprocessing.image.operations.LinearOp;
import imageprocessing.utils.IntervalTimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.pearsoneduc.ip.op.Histogram;
import com.pearsoneduc.ip.op.HistogramException;

public class Main implements ActionListener, ChangeListener
{
	private IntervalTimer timer;
	private BufferedImage image;
	private GUI gui;
	private int minValue = 0, maxValue = 255;
	
	public Main()
	{
		timer = new IntervalTimer();
		gui = new GUI(this);
	}
	
	private void loadNewImage(String path)
	{
		
		ImageLoader imageLoader = new ImageLoader(path);
		image = imageLoader.getImage();
		gui.imageCanvas.setImage(image);
		gui.imageCanvas.paint((BufferedImageOp)null);
	}
	
	private void updateImage()
	{
		Operations operation = (Operations) gui.opChooser.getSelectedItem();
		timer.start();
		switch(operation)
		{
			case INVERT:
				InvertOp io = new InvertOp();
				gui.imageCanvas.paint(io);
				break;
				
			case LINEAR_MAP:
				LinearOp lo = new LinearOp(minValue, maxValue);
				gui.imageCanvas.paint(lo);
				break;
			
			case EXP:
				ExpOp eo = new ExpOp(minValue, maxValue);
				gui.imageCanvas.paint(eo);
				break;
				
			case EQUALIZE:
				try
				{
					Histogram histogram = new Histogram(image);
					EqualizeOp eqop = new EqualizeOp(histogram);
					gui.imageCanvas.paint(eqop);
				}
				catch (HistogramException e) { e.printStackTrace(); };
				break;
				
			case BLUR:
				// declare size of kernel
				int ks = Integer.parseInt(gui.kernelSizeTxt.getText());
				
				int width = ks;
				int height = ks;
				float[] coeff = new float[width*height];
				
				//Normalize the coefficient
				for (int i = 0; i < coeff.length; i++)
					coeff[i] = 1.0f / coeff.length;
				
				Kernel kernel = new Kernel(width, height, coeff);
				ConvolveOp co = new ConvolveOp(kernel);
				gui.imageCanvas.paint(co);
				break;
				
			case ADD:
				AddOp ao = new AddOp(10);
				gui.imageCanvas.paint(ao);
				break;
				
			case EDGE_DETECTION:
				
				int kernelWidth = 3;
				int kernelHeight = 3;
				
				float[] coeffs = {-1.0f , 0.0f , 1.0f , 
								 -1.0f , 0.0f , 1.0f ,
								 -1.0f , 0.0f , 1.0f
								 };
				
				//ConvolutionOp edge_op = new ConvolutionOp(coeffs);
				
				Kernel edge_kernel = new Kernel(kernelWidth, kernelHeight, coeffs);
				ConvolveOp edge_op = new ConvolveOp(edge_kernel);
				
				gui.imageCanvas.paint(edge_op);
				break;
				
			case NONE:
				TestOp to = new TestOp();
				gui.imageCanvas.paint(to);
				gui.imageCanvas.paint((BufferedImageOp)null);
				break;
			default:
				System.err.println("Invalid or undeclared image operation!");
		}
		System.out.println("Execution time: " + timer.stop());
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "load")
		{
			int returnVal = gui.fc.showOpenDialog(gui);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = gui.fc.getSelectedFile();
				loadNewImage(file.getPath());
			}
		}
		else if(e.getActionCommand() == "save")
		{
			if(image == null)
			{
				JOptionPane.showConfirmDialog(gui.getContentPane(), 
						"No image loaded, please load an image first.", 
						"No Image Loaded", 
						JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				int returnVal = gui.fc.showSaveDialog(gui);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = gui.fc.getSelectedFile();
					gui.imageCanvas.saveImage(file);
				}
			}
		}
		else if (e.getActionCommand() == "magic")
		{
			if(image == null)
			{
				JOptionPane.showConfirmDialog(gui.getContentPane(), 
						"No image loaded, please load an image first.", 
						"No Image Loaded", 
						JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				updateImage();
			}
		}
		else if (e.getActionCommand() == "op")
		{
			if(gui.opChooser.getSelectedItem() == Operations.LINEAR_MAP 
					|| gui.opChooser.getSelectedItem() == Operations.EXP)
			{
				gui.minSlider.setVisible(true);
				gui.maxSlider.setVisible(true);
			}
			else
			{
				gui.minSlider.setVisible(false);
				gui.maxSlider.setVisible(false);
			}
			gui.imageCanvas.paint((BufferedImageOp)null);
		}
		else if (e.getActionCommand() == "quit")
		{
			gui.dispose();
			System.exit(0);
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = (JSlider)e.getSource();
		if (source.getName() == "min")
		{
			if(source.getValue() >= maxValue)
			{
				source.setValue(maxValue - 1);
			}
			else
			{
				minValue = (int) source.getValue();
				updateImage();
			}
		}
		else if (source.getName() == "max")
		{
			maxValue = (int) source.getValue();
			updateImage();
		}
	}

	public static void main(String[] argv)
	{
		Main main = new Main();
		main.gui.setVisible(true);
	}
}
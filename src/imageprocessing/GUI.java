package imageprocessing;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JPopupMenu.Separator;

public class GUI extends JFrame
{
	private static final long	serialVersionUID	= -1529314284065504722L;
	private static final String FRAME_TITLE = 		"Image Processor";
	private static final String STARTING_DIR = 		"/Users/marlonp33/Pictures/";
	
	// GUI Components
		protected final JFileChooser 	fc = new JFileChooser(STARTING_DIR);
		protected	JMenuItem	saveButton, loadButton, quitButton;
		protected	ImageCanvas	imageCanvas;
		protected 	JSlider		minSlider, maxSlider;
		protected 	JComboBox 	opChooser;
		protected 	JTextField	kernelSizeTxt;
		private		JButton		magicButton;
		private 	JMenuBar	menuBar;
		private 	JMenu		fileMenu;
		private 	Separator	fileMenuSeparator;
	
	public GUI(Main master)
	{
		super(FRAME_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		imageCanvas = new ImageCanvas();
        magicButton = new javax.swing.JButton();
        minSlider = new javax.swing.JSlider();
        maxSlider = new javax.swing.JSlider();
        opChooser = new javax.swing.JComboBox();
        kernelSizeTxt = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadButton = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        quitButton = new javax.swing.JMenuItem();

        org.jdesktop.layout.GroupLayout imageCanvasLayout = new org.jdesktop.layout.GroupLayout(imageCanvas);
        imageCanvas.setLayout(imageCanvasLayout);
        imageCanvasLayout.setHorizontalGroup(
            imageCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1206, Short.MAX_VALUE)
        );
        imageCanvasLayout.setVerticalGroup(
            imageCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 610, Short.MAX_VALUE)
        );		
		
        magicButton.setText("Do Magic");
        magicButton.setActionCommand("magic");
        magicButton.addActionListener(master);
        
        minSlider.setMaximum(255);
        minSlider.setValue(0);
        minSlider.setName("min");
        minSlider.addChangeListener(master);
        minSlider.setVisible(false);

        maxSlider.setMaximum(255);
        maxSlider.setValue(255);
        maxSlider.setName("max");
        maxSlider.addChangeListener(master);
        maxSlider.setVisible(false);

        //TODO: Give ComboBox nicer text
        opChooser.setModel(new javax.swing.DefaultComboBoxModel(Operations.values()));
        
        opChooser.setActionCommand("op");
        opChooser.addActionListener(master);

        kernelSizeTxt.setText("3");
        
        fileMenu.setText("File");

        loadButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        loadButton.setText("Load...");
        loadButton.setActionCommand("load");
        loadButton.addActionListener(master);
        fileMenu.add(loadButton);

        saveButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        saveButton.setText("Save...");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(master);
        fileMenu.add(saveButton);
        
        fileMenu.add(fileMenuSeparator);

        quitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        quitButton.setText("Quit");
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(master);
        fileMenu.add(quitButton);
        
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(magicButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(opChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(kernelSizeTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(91, 91, 91)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(maxSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(minSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(imageCanvas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(minSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(magicButton)
                        .add(opChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(kernelSizeTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(maxSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(imageCanvas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();   
	}
}

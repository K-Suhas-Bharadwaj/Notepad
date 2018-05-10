import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notepad1 extends JFrame {

	/**
	 * Launch the application.
	 */
	
	static int flag = 0;
	private JPanel contentPane;		
	public JEditorPane editorPane = new JEditorPane();
	File f;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad1 Suhas = new Notepad1();
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					Suhas.setSize(d);
					Suhas.setLocation(5, 5);
					Suhas.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Notepad1() {
		
		Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
		int h = d1.height;
		int w = d1.width;
		
		//JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(0, 28, 1366 , 774);
		getContentPane().add(editorPane);
		
		setTitle("New Text Document(1).txt");
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 28);
		getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		mnFile.setBackground(Color.WHITE);
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Untitled");
				editorPane.setText("");
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open_file();
			}
		});
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag == 0)
				{	
					saveas_file();
				}
				else
				{
					save_file();
				}
				
			}
		});
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveas_file();
			}
		});
		mnFile.add(mntmSaveAs);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmPageSetup = new JMenuItem("Page Setup...\r\n");
		mnFile.add(mntmPageSetup);

		JMenuItem mntmPrint = new JMenuItem("Print...");
		mntmPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnFile.add(mntmPrint);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(mnEdit);

		JMenuItem mntmNewMenuItem = new JMenuItem("Undo\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnEdit.add(mntmNewMenuItem);

		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cut\r\n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.cut();
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Copy\r\n");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.copy();
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Paste\r\n");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.paste();
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmNewMenuItem_3);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnEdit.add(mntmDelete);

		JSeparator separator_4 = new JSeparator();
		mnEdit.add(separator_4);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Select All");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.selectAll();
			}
		});
		mnEdit.add(mntmNewMenuItem_4);

		JMenu mnNewMenu = new JMenu("Format\r\n");
		mnNewMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(mnNewMenu);

		JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mnNewMenu.add(mntmWordWrap);

		JMenuItem mntmFont = new JMenuItem("Font\r\n");
		mnNewMenu.add(mntmFont);

		JMenu mnView = new JMenu("View");
		mnView.setMnemonic(KeyEvent.VK_V);
		menuBar.add(mnView);

		JMenuItem mntmStatusBar = new JMenuItem("Status Bar");
		mnView.add(mntmStatusBar);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnHelp);

		JMenuItem mntmViewHelp = new JMenuItem("View Help");
		mnHelp.add(mntmViewHelp);

		JSeparator separator_3 = new JSeparator();
		mnHelp.add(separator_3);

		JMenuItem mntmAboutNotepad = new JMenuItem("About Notepad");
		mnHelp.add(mntmAboutNotepad);
		
	}

	protected void save_file() {
		
		try 
		{
			PrintStream psave = new PrintStream(f.getAbsoluteFile());
			psave.print(editorPane.getText());
		} 
		catch (IOException e) 
		{   
			
			e.printStackTrace();
		}
		
	}

	protected void saveas_file() {
		JFileChooser fp = new JFileChooser();
		
		flag = 1;
		
		if(fp.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
		{
				 f = fp.getSelectedFile();
				
				try
				{
					PrintStream ps = new PrintStream(fp.getSelectedFile());
					ps.print(editorPane.getText());
					
					setTitle(fp.getSelectedFile().getName());
					
				}
				catch(Exception es)
				{
					es.printStackTrace();
				}
				
		}
		
	}

	protected void open_file() {
		
		JFileChooser fc = new JFileChooser();
		
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			String fname =fc.getSelectedFile().getName();
			setTitle(fname);
		
		try
		{
			FileInputStream fis = new FileInputStream(fc.getSelectedFile());
			int length = fis.available();
			byte b[] = new byte[length];
			fis.read(b,0,b.length);
			String str = new String(b);
			editorPane.setText(str);
		}
	
		 catch(Exception ex)
		{
			 ex.printStackTrace();
		}
		
	}
	
  }
		
}

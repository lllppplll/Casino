package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Swing implements ActionListener {

//	Random r;
//
//	int slotA;
//	int slotB;
//	int slotC;
//
	JFrame window = new JFrame("Swing Practice");
	
	JLabel label = new JLabel();
	ImageIcon img = new ImageIcon("car.png");
	
	JPanel redPanel = new JPanel();
	JPanel greenPanel = new JPanel();
	JPanel bluePanel = new JPanel();
	
	
//	JLabel labela = new JLabel();
//	JLabel labelb = new JLabel();
//	JLabel labelc = new JLabel();
//	JLabel text = new JLabel();
//	JButton clickme = new JButton("Spin");
//	String msg = "";

	public Swing() {

		//labelb.setText("Welcome");

		init();
	}

	public void init() {
		BorderLayout layout = new BorderLayout();
		layout.setHgap(100);
		
		Border textBorder = BorderFactory.createLineBorder(Color.green,3);

		window.setLayout(layout);
//		window.add(clickme, BorderLayout.PAGE_END);
//		window.add(labela, BorderLayout.LINE_START);
//		window.add(labelb, BorderLayout.CENTER);
//		window.add(labelc, BorderLayout.LINE_END);
//		window.add(text, BorderLayout.PAGE_START);

		// clickme.setBounds(200, 50, 100, 50);
		//clickme.addActionListener(this);

		window.setSize(300, 200); // set size of frame
		window.setLocation(1000, 200); // set location on screen
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window
		//window.setResizable(false); // cannot reszie window
		window.setVisible(true); // See frame
		
		ImageIcon image = new ImageIcon("casino.jpg"); // set image on corner
		window.setIconImage(image.getImage());
		
		//window.getContentPane().setBackground(Color.green);// set background colour
//		window.getContentPane().setBackground(new Color(230,250,250));// set background colour

//		label.setText("hello");// set text of label
//		label.setIcon(img);// add image
//		label.setHorizontalTextPosition(JLabel.CENTER);// text on top of image
//		label.setVerticalTextPosition(JLabel.TOP);// text on top
//		label.setForeground(new Color(123,50,250));//set text colour
//		label.setFont(new Font("MV Boli",Font.PLAIN, 20));// text font
//		label.setIconTextGap(25);//gap from image
		
		label.setBackground(Color.black);//background of text
		label.setOpaque(true);//background of text
		
		label.setBorder(textBorder);
		label.setVerticalAlignment(JLabel.CENTER);//VERTICAL
		label.setHorizontalAlignment(JLabel.CENTER);//HORIZONTAL
		

		window.add(label);// add text
		
		label.setBounds(100,100,250,250);//set position x and y and width and height
		window.setLayout(null);
		//window.pack();// stop setLayout and setSize methods first before use
		//window.add(image);
		
		//red panel
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,250,250);
		window.add(redPanel);
		//blue panel
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250,0,250,250);
		window.add(bluePanel);
		//green panel
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,250,500,250);
		window.add(greenPanel);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getActionCommand() == clickme.getActionCommand()) {
//
//			// random values for slots
//			r = new Random();
//			slotA = r.nextInt(3);
//			slotB = r.nextInt(3);
//			slotC = r.nextInt(3);
//
//			// print out win or lose - win all three the same number
//			if (slotA == slotB && slotA == slotC) {
////					System.out.println("Jackpot");
////					System.out.println(slotA);
////					System.out.println(slotB);
////					System.out.println(slotC);
//				labela.setText("" + slotA);
//				labelb.setText("" + slotB);
//				labelc.setText("" + slotC);
//				text.setText("Jackpot");
//			} else {
////					System.out.println("try again");	
////					System.out.println(slotA);
////					System.out.println(slotB);
////					System.out.println(slotC);
//				labela.setText("" + slotA);
//				labelb.setText("" + slotB);
//				labelc.setText("" + slotC);
//				text.setText("Try Again");
//			}
//		}
//
//	}

}

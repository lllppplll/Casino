package Main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Slots implements ActionListener {
	
	HashMap<Integer, JLabel> nudgeSymbolPI = new HashMap<Integer, JLabel>();
	HashMap<Integer, JLabel> randomNudgeMap = new HashMap<Integer, JLabel>();
	HashMap<Integer, JLabel> randomPercentMap = new HashMap<Integer, JLabel>();
	HashMap<Integer, JLabel> winLoseMap = new HashMap<Integer, JLabel>();
	
	//decimal form of cash
	DecimalFormat df = new DecimalFormat("0.00");
	//random number
	Random random = new Random();
	Random randomSlotFirst = new Random();
	Random randomPercent = new Random();
	
	//Variables
	
	//number of spins
	int spinCount;
	int nudgeCount = 0;
	float cashInCount;
	int ranSlotA = 0;
	int ranSlotB = 0;
	int ranSlotC = 0;
	int ranNudge;
	int nudgeStartCount = 0;
	int nudgeSymbolCount = 0;
	int[] slotArray = {1,0};
	double priceLine = 0.00f;
	int ranPercent;
	double percentOutcome = 0.00f;
	int winLoseCount = 0;
	int winLoseArray[] = {0,1,2,3,4,5,6,7,8,8,7,6,5,4,3,2,1,0};
	int endOfAllSlotsA = 1;
	int endOfAllSlotsB = 1;
	int endOfAllSlotsC = 1;
	
	double tBets = 0.00f;
	double totalProfit = 0.00f;
	double totalBets = 0.00f;
	double totalPayAdding = 0.00f;
	
	//DISABLE SPIN BUTTON
	int disableSpinA = 1;
	int disableSpinB = 1;
	int disableSpinC = 1;
	//DISABLE GAME BUTTON
	int disableGameButtonA = 1;
	int disableGameButtonB = 1;
	int disableGameButtonC = 1;
	//Disable Buttons
	int headsDisable = 1;
	int tailsDisable = 1;
	int percentDisable = 1;
	int winLoseDisable = 1;
	//Disable Nudge
	int nudgeDisableA = 1;
	int nudgeDisableB = 1;
	int nudgeDisableC = 1;
	
	//GAME BUTTON ON OFF WITH NUDGES
	int nudgeGameButtonOnOffA = 1;
	int nudgeGameButtonOnOffB = 1;
	int nudgeGameButtonOnOffC = 1;
	
	//only have one timer on nudges with price of 2 or more
	int firstTimeTwoCount = 0;
		
	int slotFirst = -650;//starting 1st slot position
	int slotSecond = -650;//starting 1st slot position
	int slotThird = -650;//starting 1st slot position 
	
	Timer timerSlotFirst;
	Timer timerSlotSecond;
	Timer timerSlotThird;
	Timer timerFiveNudges;
	
	Timer timerGamePlay;
	Timer timerHeadsOrTails;
	Timer timerPercent;
	Timer timerWinOrLose;
	
	Timer timerNudgeA;
	Timer timerNudgeB;
	Timer timerNudgeC;
	
	boolean flashGamePlayButton = true;
	boolean spinCoin = true;
	
	boolean coinHeads;
	boolean coinTails;
	boolean successOrFail;
	
	//frame
	JFrame frame = new JFrame();
	
	//panels
	JPanel titlePanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel slotsPanel = new JPanel();
	JPanel firstSlot = new JPanel();
	JPanel secondSlot = new JPanel();
	JPanel thirdSlot = new JPanel();
	JPanel buttonPanel = new JPanel();

	//button - add (implements ActionListener)
	JButton addButton = new JButton();
	JButton spinButton = new JButton();
	JButton collectButton = new JButton();
	JButton nudgeA = new JButton();
	JButton nudgeB = new JButton();
	JButton nudgeC = new JButton();
	JButton nudgeSpin = new JButton();
	JButton percentButton = new JButton();
	JButton headsButton = new JButton();
	JButton tailsButton = new JButton();
	JButton winLoseButton = new JButton();
	JButton obstaclesButton = new JButton();
	
	//labels
	JLabel titleText = new JLabel();
	JLabel spinText = new JLabel();
	JLabel numberOfSpins = new JLabel();
	JLabel cashText = new JLabel();
	JLabel cashIn = new JLabel();
	JLabel winText = new JLabel();
	JLabel win = new JLabel();
	JLabel totalPayText = new JLabel();
	JLabel totalPay = new JLabel();
	JLabel nudgeText = new JLabel();
	JLabel nudgeCounter = new JLabel();
	//nudge random
	JLabel nudgeCounterA = new JLabel();
	JLabel nudgeCounterB = new JLabel();
	JLabel nudgeCounterC = new JLabel();
	JLabel nudgeCounterD = new JLabel();
	JLabel nudgeCounterE = new JLabel();
	//pi nudge
	JLabel nudgePI0 = new JLabel();
	JLabel nudgePI1 = new JLabel();
	JLabel nudgePI2 = new JLabel();

	
	//obstacles
	ImageIcon hOrTImage = new ImageIcon("HeadsOrTails.png");
	JLabel headsOrTailsText = new JLabel();
	JLabel headsOrTailsImage = new JLabel(hOrTImage);
	JLabel headsOrTailsBox = new JLabel();
	JLabel cross = new JLabel();
	JLabel tick = new JLabel();
	
	JLabel percentText = new JLabel();
	JLabel percent100 = new JLabel();
	JLabel percent80 = new JLabel();
	JLabel percent60 = new JLabel();
	JLabel percent40 = new JLabel();
	JLabel percent20 = new JLabel();
	JLabel percentIn = new JLabel();
	JLabel percentOut = new JLabel();
	
	JLabel winOrLoseText = new JLabel();
	JLabel winOrLosel9 = new JLabel();
	JLabel winOrLosel8 = new JLabel();
	JLabel winOrLosel7 = new JLabel();
	JLabel winOrLosel6 = new JLabel();
	JLabel winOrLosel5 = new JLabel();
	JLabel winOrLosel4 = new JLabel();
	JLabel winOrLosel3 = new JLabel();
	JLabel winOrLosel2 = new JLabel();
	JLabel winOrLosel1 = new JLabel();
	
//	JLabel slotA = new JLabel();
//	JLabel slotB = new JLabel();
//	JLabel slotC = new JLabel();
	
	//images
	//ImageIcon slotImage = new ImageIcon("slots100.png");
	ImageIcon slotImageA = new ImageIcon("slotsAP.png");
	ImageIcon slotImageB = new ImageIcon("slotsBP.png");
	ImageIcon slotImageC = new ImageIcon("slotsCP.png");
	ImageIcon slotsPayImage = new ImageIcon("slotsPays.png");
	
	//ImageIcon barSImage = new ImageIcon("barS.png");
	//ImageIcon newImage = slotImage.getScaledInstance(300, 300, ImageIcon.SCALE_DEFAULT);
	
	//ImageIcon icon = new ImageIcon("slotBox.jpg");
	//Image scaleImage = icon.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
	
	JLabel slotFirstImg = new JLabel(slotImageA);
	JLabel slotSecondImg = new JLabel(slotImageB);
	JLabel slotThirdImg = new JLabel(slotImageC);
	JLabel slotsPay = new JLabel(slotsPayImage);
	//JLabel barImage = new JLabel(barSImage);
	
	
	//constructor
	public Slots()  {
		
		
		
		init();
	}
	
	
	//loads code
	public void init() {
		
//		headsButton.setEnabled(false);
//		tailsButton.setEnabled(false);
//		percentButton.setEnabled(false);
//		winLoseButton.setEnabled(false);
		
		//PUT DATA INTO HASHMAP
		//NUDGE PI SYMBOLS
		nudgeSymbolPI.put(0, nudgePI0);
		nudgeSymbolPI.put(1, nudgePI1);
		nudgeSymbolPI.put(2, nudgePI2);
		//FIVE LIGHTS
		randomNudgeMap.put(0, nudgeCounterE);
		randomNudgeMap.put(1, nudgeCounterD);
		randomNudgeMap.put(2, nudgeCounterC);
		randomNudgeMap.put(3, nudgeCounterB);
		randomNudgeMap.put(4, nudgeCounterA);
		//PERCENT
		randomPercentMap.put(1, percent20);
		randomPercentMap.put(2, percent40);
		randomPercentMap.put(3, percent60);
		randomPercentMap.put(4, percent80);
		randomPercentMap.put(5, percent100);
		//WIN LOSE
		winLoseMap.put(0, winOrLosel1);
		winLoseMap.put(1, winOrLosel2);
		winLoseMap.put(2, winOrLosel3);
		winLoseMap.put(3, winOrLosel4);
		winLoseMap.put(4, winOrLosel5);
		winLoseMap.put(5, winOrLosel6);
		winLoseMap.put(6, winOrLosel7);
		winLoseMap.put(7, winOrLosel8);
		winLoseMap.put(8, winOrLosel9);
		//lines around panels
		Border lineBorder = BorderFactory.createLineBorder(Color.gray,3);
		//border
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		Border whiteBorder = BorderFactory.createLineBorder(Color.white, 5);
		
		frame.setTitle("Slots");//set title
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close window
		frame.setSize(719,743);//size of window
		frame.setLocationRelativeTo(null);//center of screen
		
		ImageIcon image = new ImageIcon("casino.jpg"); // set image on corner
		frame.setIconImage(image.getImage());
		
		frame.setVisible(true);//show window
		frame.setLayout(null);//no layout
		
		//panels
		//top
		titlePanel.setBackground(Color.red);
		titlePanel.setBounds(0,0,701,100);
		titlePanel.setBorder(lineBorder);
		titlePanel.setLayout(null);
		frame.add(titlePanel);
		//left
		infoPanel.setBackground(Color.yellow);
		infoPanel.setBounds(501,101,200,500);
		infoPanel.setBorder(lineBorder);
		infoPanel.setLayout(null);
		frame.add(infoPanel);
		//right
		slotsPanel.setBackground(Color.blue);
		slotsPanel.setBounds(0,101,500,500);
		slotsPanel.setBorder(lineBorder);
		slotsPanel.setLayout(null);
		frame.add(slotsPanel);
		//bottom
		buttonPanel.setBackground(Color.green);
		buttonPanel.setBounds(0,602,701,100);
		buttonPanel.setBorder(lineBorder);
		buttonPanel.setLayout(null);
		frame.add(buttonPanel);
		//first slot
		firstSlot.setBackground(Color.black);
		firstSlot.setBounds(100,10,100,200);
		firstSlot.setBorder(lineBorder);
		firstSlot.setLayout(null);
		slotsPanel.add(firstSlot);
		
		//second slot
		secondSlot.setBackground(Color.black);
		secondSlot.setBounds(200,10,100,200);
		secondSlot.setBorder(lineBorder);
		secondSlot.setLayout(null);
		slotsPanel.add(secondSlot);
		
		//third slot
		thirdSlot.setBackground(Color.black);
		thirdSlot.setBounds(300,10,100,200);
		thirdSlot.setBorder(lineBorder);
		thirdSlot.setLayout(null);
		slotsPanel.add(thirdSlot);
		
		
		
		//buttons
		addButton.setBounds(5, 100, 190, 40);
		addButton.setText("BET");//add text to button
		//addButton.setFocusable(false);//removes line around text
		addButton.addActionListener(this);
		infoPanel.add(addButton);
		
		spinButton.setBounds(350, 14, 280, 70);
		spinButton.setText("SPIN");//add text to button
		spinButton.addActionListener(this);
		buttonPanel.add(spinButton);
		
		collectButton.setBounds(70, 14, 280, 70);
		collectButton.setText("COLLECT");//add text to button
		collectButton.addActionListener(this);
		buttonPanel.add(collectButton);
		
		nudgeA.setBounds(101, 220, 98, 30);
		nudgeA.setText("NUDGE");//add text to button
		nudgeA.addActionListener(this);
		slotsPanel.add(nudgeA);
		
		nudgeB.setBounds(201, 220, 98, 30);
		nudgeB.setText("NUDGE");//add text to button
		nudgeB.addActionListener(this);
		slotsPanel.add(nudgeB);
		
		nudgeC.setBounds(301, 220, 98, 30);
		nudgeC.setText("NUDGE");//add text to button
		nudgeC.addActionListener(this);
		slotsPanel.add(nudgeC);
		
		nudgeSpin.setBounds(7, 220, 90, 30);
		nudgeSpin.setText("N-SPIN");//add text to button
		nudgeSpin.addActionListener(this);
		slotsPanel.add(nudgeSpin);
		
		headsButton.setBounds(28, 450, 80, 30);
		headsButton.setText("HEADS");//add text to button
		headsButton.addActionListener(this);
		slotsPanel.add(headsButton);
		
		tailsButton.setBounds(110, 450, 80, 30);
		tailsButton.setText("TAILS");//add text to button
		tailsButton.addActionListener(this);
		slotsPanel.add(tailsButton);
		
		percentButton.setBounds(240, 450, 80, 30);
		percentButton.setText("P-SPIN");//add text to button
		percentButton.addActionListener(this);
		slotsPanel.add(percentButton);
		
		winLoseButton.setBounds(370, 450, 80, 30);
		winLoseButton.setText("W-SPIN");//add text to button
		winLoseButton.addActionListener(this);
		slotsPanel.add(winLoseButton);
		
		obstaclesButton.setBounds(408, 100, 80, 30);
		obstaclesButton.setText("GAME");//add text to button
		obstaclesButton.addActionListener(this);
		slotsPanel.add(obstaclesButton);
		
		
		//labels
		titleText.setBounds(230, 20, 300, 50);
		titleText.setText("Spins of Chaos");
		titleText.setFont(new Font("Serif", Font.BOLD, 40));
//		titleText.setHorizontalAlignment(JLabel.CENTER);
//	    titleText.setVerticalAlignment(JLabel.CENTER);
		titlePanel.add(titleText);
		
		spinText.setBounds(101, 0, 80, 50);
		spinText.setText("Spins");
		spinText.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(spinText);
		
		numberOfSpins.setBounds(101, 42, 90, 40);
		numberOfSpins.setText(" 0");
		numberOfSpins.setBorder(blackBorder);
		numberOfSpins.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(numberOfSpins);
		
		cashText.setBounds(5, 0, 80, 50);
		cashText.setText("Cash");
		cashText.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(cashText);
		
		cashIn.setBounds(5, 42, 90, 40);
		cashIn.setText(" £0.00");
		cashIn.setBorder(blackBorder);
		cashIn.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(cashIn);
		
		slotsPay.setBounds(5, 150, 190, 140);
		slotsPay.setBorder(blackBorder);
		infoPanel.add(slotsPay);
		
		winText.setBounds(5, 300, 190, 50);
		winText.setText("Win");
		winText.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(winText);
		
		win.setBounds(5, 342, 190, 40);
		win.setText(" £0.00");
		win.setBorder(blackBorder);
		win.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(win);
		
		totalPayText.setBounds(5, 400, 190, 50);
		totalPayText.setText("Total Win");
		totalPayText.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(totalPayText);
		
		totalPay.setBounds(5, 442, 190, 40);
		totalPay.setText(" £0.00");
		totalPay.setBorder(blackBorder);
		totalPay.setFont(new Font("Serif", Font.BOLD, 20));
		infoPanel.add(totalPay);
		
		nudgeText.setBounds(10, 6, 100, 20);
		nudgeText.setText("NUDGES");
		nudgeText.setForeground(Color.white);
		//totalPay.setBorder(blackBorder);
		nudgeText.setFont(new Font("Serif", Font.BOLD, 20));
		slotsPanel.add(nudgeText);
		
		nudgeCounter.setBounds(25, 36, 50, 80);
		nudgeCounter.setText(" " + nudgeStartCount);
		nudgeCounter.setForeground(Color.yellow);
		nudgeCounter.setBorder(whiteBorder);
		nudgeCounter.setFont(new Font("Serif", Font.BOLD, 40));
		slotsPanel.add(nudgeCounter);
		
		nudgeCounterA.setBounds(25, 160, 50, 10);
		nudgeCounterA.setBorder(blackBorder);
		nudgeCounterA.setBackground(Color.gray);
		nudgeCounterA.setOpaque(true);
		slotsPanel.add(nudgeCounterA);
		
		nudgeCounterB.setBounds(25, 171, 50, 10);
		nudgeCounterB.setBorder(blackBorder);
		nudgeCounterB.setBackground(Color.gray);
		nudgeCounterB.setOpaque(true);
		slotsPanel.add(nudgeCounterB);
		
		nudgeCounterC.setBounds(25, 182, 50, 10);
		nudgeCounterC.setBorder(blackBorder);
		nudgeCounterC.setBackground(Color.gray);
		nudgeCounterC.setOpaque(true);
		slotsPanel.add(nudgeCounterC);
		
		nudgeCounterD.setBounds(25, 193, 50, 10);
		nudgeCounterD.setBorder(blackBorder);
		nudgeCounterD.setBackground(Color.gray);
		nudgeCounterD.setOpaque(true);
		slotsPanel.add(nudgeCounterD);
		
		nudgeCounterE.setBounds(25, 204, 50, 10);
		nudgeCounterE.setBorder(blackBorder);
		nudgeCounterE.setBackground(Color.gray);
		nudgeCounterE.setOpaque(true);
		slotsPanel.add(nudgeCounterE);
		
		nudgePI0.setBounds(10, 114, 40, 40);
		nudgePI0.setText("\u03C0");
		nudgePI0.setFont(new Font("Serif", Font.BOLD, 38));
		nudgePI0.setForeground(Color.gray);
		slotsPanel.add(nudgePI0);
		
		nudgePI1.setBounds(40, 114, 40, 40);
		nudgePI1.setText("\u03C0");
		nudgePI1.setFont(new Font("Serif", Font.BOLD, 38));
		nudgePI1.setForeground(Color.gray);
		slotsPanel.add(nudgePI1);
		
		nudgePI2.setBounds(70, 114, 40, 40);
		nudgePI2.setText("\u03C0");
		nudgePI2.setFont(new Font("Serif", Font.BOLD, 38));
		nudgePI2.setForeground(Color.gray);
		slotsPanel.add(nudgePI2);
		
		///////////////////////OBSTACLES////////////////////////////////////////
		headsOrTailsImage.setBounds(0, -1, 80, 160);//-1 heads -80 tails
		headsOrTailsBox.add(headsOrTailsImage);
		
		headsOrTailsText.setBounds(64, 256, 100, 30);
		headsOrTailsText.setText("HEADS OR TAILS");
		headsOrTailsText.setForeground(Color.white);
		slotsPanel.add(headsOrTailsText);
		
		headsOrTailsBox.setBounds(70, 286, 80, 80);
		headsOrTailsBox.setBorder(blackBorder);
		slotsPanel.add(headsOrTailsBox);
		
		tick.setBounds(60, 376, 100, 30);
		tick.setBorder(blackBorder);
		tick.setText("Success");
		tick.setHorizontalAlignment(JLabel.CENTER);
		tick.setVerticalAlignment(JLabel.CENTER);
		tick.setForeground(Color.gray);
		tick.setOpaque(true);
		slotsPanel.add(tick);
		
		cross.setBounds(60, 410, 100, 30);
		cross.setBorder(blackBorder);
		cross.setText("Bad Luck");
		cross.setHorizontalAlignment(JLabel.CENTER);
		cross.setVerticalAlignment(JLabel.CENTER);
		cross.setForeground(Color.gray);
		cross.setOpaque(true);
		slotsPanel.add(cross);
		
		percentText.setBounds(240, 256, 100, 30);
		percentText.setText("PERCENTAGE %");
		percentText.setForeground(Color.white);
		slotsPanel.add(percentText);
		
		percentIn.setBounds(250, 290, 60, 26);
		percentIn.setText("£0.00 ");
		percentIn.setBorder(blackBorder);
		percentIn.setHorizontalAlignment(JLabel.CENTER);
		percentIn.setVerticalAlignment(JLabel.CENTER);
		percentIn.setForeground(Color.white);
		slotsPanel.add(percentIn);
		
		percentOut.setBounds(250, 412, 60, 26);
		percentOut.setText("£0.00 ");
		percentOut.setBorder(blackBorder);
		percentOut.setHorizontalAlignment(JLabel.CENTER);
		percentOut.setVerticalAlignment(JLabel.CENTER);
		percentOut.setForeground(Color.white);
		slotsPanel.add(percentOut);
		
		percent20.setBounds(280, 378, 50, 24);
		percent20.setBorder(blackBorder);
		percent20.setText("20");
		percent20.setHorizontalAlignment(JLabel.CENTER);
		percent20.setVerticalAlignment(JLabel.CENTER);
		percent20.setForeground(Color.black);
		slotsPanel.add(percent20);
		
		percent40.setBounds(228, 378, 50, 24);
		percent40.setBorder(blackBorder);
		percent40.setText("40");
		percent40.setHorizontalAlignment(JLabel.CENTER);
		percent40.setVerticalAlignment(JLabel.CENTER);
		percent40.setForeground(Color.black);
		slotsPanel.add(percent40);
		
		percent60.setBounds(280, 324, 50, 24);
		percent60.setBorder(blackBorder);
		percent60.setText("60");
		percent60.setHorizontalAlignment(JLabel.CENTER);
		percent60.setVerticalAlignment(JLabel.CENTER);
		percent60.setForeground(Color.black);
		slotsPanel.add(percent60);
		
		percent80.setBounds(228, 324, 50, 24);
		percent80.setBorder(blackBorder);
		percent80.setText("80");
		percent80.setHorizontalAlignment(JLabel.CENTER);
		percent80.setVerticalAlignment(JLabel.CENTER);
		percent80.setForeground(Color.black);
		slotsPanel.add(percent80);
		
		percent100.setBounds(244, 351, 70, 24);
		percent100.setBorder(blackBorder);
		percent100.setText("100");
		percent100.setHorizontalAlignment(JLabel.CENTER);
		percent100.setVerticalAlignment(JLabel.CENTER);
		percent100.setForeground(Color.black);
		slotsPanel.add(percent100);
		
		winOrLoseText.setBounds(376, 256, 100, 26);
		winOrLoseText.setText("WIN OR LOSE");
		winOrLoseText.setForeground(Color.white);
		slotsPanel.add(winOrLoseText);
		
		winOrLosel1.setBounds(386, 430, 50, 16);
		winOrLosel1.setBorder(blackBorder);
		winOrLosel1.setText("L");
		winOrLosel1.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel1.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel1.setBackground(Color.gray);
		winOrLosel1.setOpaque(true);
		slotsPanel.add(winOrLosel1);
		
		winOrLosel2.setBounds(386, 412, 50, 16);
		winOrLosel2.setBorder(blackBorder);
		winOrLosel2.setText("L");
		winOrLosel2.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel2.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel2.setBackground(Color.gray);
		winOrLosel2.setOpaque(true);
		slotsPanel.add(winOrLosel2);
		
		winOrLosel3.setBounds(386, 394, 50, 16);
		winOrLosel3.setBorder(blackBorder);
		winOrLosel3.setText("L");
		winOrLosel3.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel3.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel3.setBackground(Color.gray);
		winOrLosel3.setOpaque(true);
		slotsPanel.add(winOrLosel3);
		
		winOrLosel4.setBounds(386, 376, 50, 16);
		winOrLosel4.setBorder(blackBorder);
		winOrLosel4.setText("L");
		winOrLosel4.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel4.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel4.setBackground(Color.gray);
		winOrLosel4.setOpaque(true);
		slotsPanel.add(winOrLosel4);
		
		winOrLosel5.setBounds(386, 358, 50, 16);
		winOrLosel5.setBorder(blackBorder);
		winOrLosel5.setText("L");
		winOrLosel5.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel5.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel5.setBackground(Color.gray);
		winOrLosel5.setOpaque(true);
		slotsPanel.add(winOrLosel5);
		
		winOrLosel6.setBounds(386, 340, 50, 16);
		winOrLosel6.setBorder(blackBorder);
		winOrLosel6.setText("L");
		winOrLosel6.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel6.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel6.setBackground(Color.gray);
		winOrLosel6.setOpaque(true);
		slotsPanel.add(winOrLosel6);
		
		winOrLosel7.setBounds(386, 322, 50, 16);
		winOrLosel7.setBorder(blackBorder);
		winOrLosel7.setText("W");
		winOrLosel7.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel7.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel7.setBackground(Color.gray);
		winOrLosel7.setOpaque(true);
		slotsPanel.add(winOrLosel7);
		
		winOrLosel8.setBounds(386, 304, 50, 16);
		winOrLosel8.setBorder(blackBorder);
		winOrLosel8.setText("W");
		winOrLosel8.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel8.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel8.setBackground(Color.gray);
		winOrLosel8.setOpaque(true);
		slotsPanel.add(winOrLosel8);
		
		winOrLosel9.setBounds(386, 286, 50, 16);
		winOrLosel9.setBorder(blackBorder);
		winOrLosel9.setText("W");
		winOrLosel9.setHorizontalAlignment(JLabel.CENTER);
		winOrLosel9.setVerticalAlignment(JLabel.CENTER);
//		winOrLosel9.setBackground(Color.gray);
		winOrLosel9.setOpaque(true);
		slotsPanel.add(winOrLosel9);
		

		

//		barImage.setBounds(5, 400, 190, 50);
//		barImage.setText("Total Win");
//		//barImage.setFont(new Font("Serif", Font.BOLD, 20));
//		slotsPanel.add(barImage);
		
//		slotA.setBounds(100, 0, 80, 50);
//		slotA.setText("0");
//		slotsPanel.add(slotA);
//		slotB.setBounds(200, 0, 80, 50);
//		slotB.setText("0");
//		slotsPanel.add(slotB);
//		slotC.setBounds(300, 0, 80, 50);
//		slotC.setText("0");
//		slotsPanel.add(slotC);
		
		//label images
		slotFirstImg.setBounds(0, 100, 100, 900);
		firstSlot.add(slotFirstImg);

		slotSecondImg.setBounds(0, 100, 100, 900);
		secondSlot.add(slotSecondImg);

		slotThirdImg.setBounds(0, 100, 100, 900);
		thirdSlot.add(slotThirdImg);
		
		//slotFirstImg.setBounds(0, -646, 100, 900);//594 = one loop
		//slotSecondImg.setBounds(0, -650, 100, 900);
		//slotThirdImg.setBounds(0, -650, 100, 900);
		

		//100/550 - cherry
		//200/450 - lemon
		//300/350 - raspberry
	    //400/250 - seven
		//500/150 - water melon
		//600/50 - diamond
		
		slotFirstImg.setBounds(0, -650, 100, 900);
		slotSecondImg.setBounds(0, -650, 100, 900);
		slotThirdImg.setBounds(0, -650, 100, 900);
		
		// first slot
		timerSlotFirst = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				slotFirst = slotFirst + 10;
				slotFirstImg.setBounds(0, slotFirst, 100, 900);
				
				if(slotFirst == (-50 + -(ranSlotA * 100)) ) {
					timerSlotFirst.stop();
					//END OF ALL SLOTS
					endOfAllSlotsA = 0;
					ResetAllObstacleLights();

					//enable spin button if no money on line - nudges come first before money line
					if(priceLine != 0 && nudgeSymbolCount != 3) { disableSpinA = 0; disableGameButtonA = 0;
							LightUpGameButton(priceLine); } else { disableSpinA = 1; }
				}
				//////////////////
				//light up pi symbol
				ShowPiSymbols(nudgeSymbolCount);
//				System.out.println("nudgeSymbol = " + nudgeSymbolCount);
				if(priceLine != 0) { firstTimeTwoCount = 1; }else {firstTimeTwoCount = 0;}
				//loops back around
				if(slotFirst == -50) { slotFirst = -650; }
				
			}
			
		});
		
		//second slot
		timerSlotSecond = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				slotSecond = slotSecond + 10;
				slotSecondImg.setBounds(0, slotSecond, 100, 900);
				
				if(slotSecond == -50 + -(ranSlotB * 100)) {
					timerSlotSecond.stop();
					//END OF ALL SLOTS
					endOfAllSlotsB = 0;
					ResetAllObstacleLights();
					//////////////////

					//enable spin button if no money on line
					if(priceLine != 0 && nudgeSymbolCount != 3) { disableSpinB = 0; disableGameButtonB = 0;
							LightUpGameButton(priceLine); } else { disableSpinB = 1; }
		
				}
				//light up pi symbol
				ShowPiSymbols(nudgeSymbolCount);
//				System.out.println("nudgeSymbol = " + nudgeSymbolCount);
				if(priceLine != 0) { firstTimeTwoCount = 1; }else {firstTimeTwoCount = 0;}
				//loops back around
				if(slotSecond == -50) { slotSecond = -650; }	
			}
			
		});
		
		//third slot
		timerSlotThird = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				slotThird = slotThird + 10;
				slotThirdImg.setBounds(0, slotThird, 100, 900);
				
				if(slotThird == -50 + -(ranSlotC * 100)) {
					timerSlotThird.stop();
					//END OF ALL SLOTS
					endOfAllSlotsC = 0;
					ResetAllObstacleLights();
					//////////////////

					//enable spin button if no money on line - if money light up game button
					if(priceLine != 0 && nudgeSymbolCount != 3) { disableSpinC = 0; disableGameButtonC = 0;
							LightUpGameButton(priceLine); } else { disableSpinC = 1; }
					

				}
				//light up pi symbol
				ShowPiSymbols(nudgeSymbolCount);
//				System.out.println("nudgeSymbol = " + nudgeSymbolCount);
				
				if(priceLine != 0) { firstTimeTwoCount = 1; }else {firstTimeTwoCount = 0;}
				//loops back around
				if(slotThird == -50) { slotThird = -650; }
				
			}
			
		});

}

	
	//BUTTONS
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//BET BUTTON
		//count up when BET button is pressed
		if (e.getSource() == addButton)
	        {
			
			//bet sound
			Sounds("bet.wav");
	
			spinCount++;
			numberOfSpins.setText(" " + spinCount);
			
			cashInCount = cashInCount + 0.25f;
			totalBets = totalBets + 0.25f;
			cashIn.setText(" £" + df.format(cashInCount));
			

        }
		
		//SPIN BUTTON
		//count down when SPIN button is pressed, until zero
        if (e.getSource() == spinButton && spinCount != 0 && disableSpinA == 1 && disableSpinB == 1 && disableSpinC == 1 )
        {
			//ResetToZeroNudgesWhenNoMoreBets();
			Sounds("slot.begin.wav");
        	//decrease number of spins
			spinCount--;
			numberOfSpins.setText(" " + spinCount);
			//decrease cash in
			cashInCount = cashInCount - 0.25f;
			cashIn.setText(" £" + df.format(cashInCount));
				
			//random number - 0 - 500
			ranSlotA = randomSlotFirst.nextInt(6);
			ranSlotB = randomSlotFirst.nextInt(6);
			ranSlotC = randomSlotFirst.nextInt(6);
			
//			System.out.println("A = " + ranSlotA);
//			System.out.println("B = " + ranSlotB);
//			System.out.println("C = " + ranSlotC);
			
			//disable button
			//spinButton.setEnabled(false);
			
			//disable button on slot animation
			disableSpinA = 0;
			disableSpinB = 0;
			disableSpinC = 0;
			//Eenable end of slots
			endOfAllSlotsA = 1;
			endOfAllSlotsB = 1;
			endOfAllSlotsC = 1;
			
			//start timers
			timerSlotFirst.start();
			timerSlotSecond.start();
			timerSlotThird.start();
			
			//how many pi symbols collected
			NudgeSymbol(ranSlotA, ranSlotB, ranSlotC);
			//THREE OR TWO OF A KIND SLOT LINE
			SlotsThreeOrTwoOfAKind(ranSlotA, ranSlotB, ranSlotC);
			//get price of winning line
			PriceOfWinningLine(slotArray[0], slotArray[1]);	
			//first time two on price line
			if(priceLine != 0) { firstTimeTwoCount = 1; }else {firstTimeTwoCount = 0;}
			//reset nudges when no more bets

        }
        
        //N-SPIN BUTTON
        if(e.getSource() == nudgeSpin && nudgeCount == 1) { 
        	//put number in nudge box
        	nudgeStartCount = (ranNudge + 1);
        	nudgeCounter.setText(" " + nudgeStartCount);
        	//nudge pi symbol to zero and turn off lights
        	nudgeSymbolCount = 0;
        	nudgePI0.setForeground(Color.gray);
        	nudgePI1.setForeground(Color.gray);
        	nudgePI2.setForeground(Color.gray);
        	//light up nudge button
        	nudgeA.setBackground(Color.yellow);
        	nudgeB.setBackground(Color.yellow);
        	nudgeC.setBackground(Color.yellow);
        	//enable spin button
    		disableSpinA = 1;
    		disableSpinB = 1;
    		disableSpinC = 1;
    		//enable all 3 nudge buttons -- disable n-spin button
    		nudgeCount = 0;
        	//stop timer
        	timerFiveNudges.stop();
        	
        	//check price line///////////////////////
			//enable spin button if no money on line - if money light up game button
			if(priceLine != 0) { 
				//DISABLE SPIN BUTTON
				disableSpinA = 0; 
				disableSpinB = 0; 
				disableSpinC = 0; 
				//ENABLE GAME BUTTON
				disableGameButtonA = 0;
				disableGameButtonB = 0;
				disableGameButtonC = 0;
				LightUpGameButton(priceLine); 
				if(priceLine != 0) { firstTimeTwoCount = 1; }else {firstTimeTwoCount = 0;}
				} 
			else 
			{ 
				//ENABLE SPIN BUTTON
			    disableSpinA = 1;
				disableSpinB = 1; 
			    disableSpinC = 1; 
			    }
        	///////////////////////////////////////////
		}
        
        ////////////////////////////NUDGES/////////////////////////////////////
        //SLOT A
        if(e.getSource() == nudgeA && nudgeStartCount != 0 && nudgeDisableA == 1) { 
        	
			Sounds("slot.begin.wav");
        	
        	ranSlotA--; if(ranSlotA < 0) { ranSlotA = 5; } 
    		timerNudgeA.start(); //------------------------------------ NEW TIMER
        	
        	//decrese nudge counter and lights by 1
        	nudgeStartCount--;
        	nudgeCounter.setText(" " + nudgeStartCount);
        	randomNudgeMap.get(nudgeStartCount).setBackground(Color.gray);
        	//when nudge counter goes to zero turn off button light
        	if(nudgeStartCount == 0) { 
        		nudgeA.setBackground(UIManager.getColor("Button.background")); 
        		nudgeB.setBackground(UIManager.getColor("Button.background"));
        		nudgeC.setBackground(UIManager.getColor("Button.background")); 
        		}
        	System.out.println("first time two = " + firstTimeTwoCount);
        	//ResetToZeroNudgesWhenNoMoreBets();
        	}
        //SLOT B
        if(e.getSource() == nudgeB && nudgeStartCount != 0 && nudgeDisableB == 1) { 
        	
			Sounds("slot.begin.wav");
        	
        	ranSlotB--; if(ranSlotB < 0) { ranSlotB = 5; } 
    		timerNudgeB.start(); 
        	
        	//decrese nudge counter and lights by 1
        	nudgeStartCount--;
        	nudgeCounter.setText(" " + nudgeStartCount);
        	randomNudgeMap.get(nudgeStartCount).setBackground(Color.gray);
        	//when nudge counter goes to zero turn off button light
        	if(nudgeStartCount == 0) { 
        		nudgeA.setBackground(UIManager.getColor("Button.background")); 
        		nudgeB.setBackground(UIManager.getColor("Button.background"));
        		nudgeC.setBackground(UIManager.getColor("Button.background")); 
        		}
        	System.out.println("first time two = " + firstTimeTwoCount);
        	//ResetToZeroNudgesWhenNoMoreBets();
        }
        
        //SLOT C
        if(e.getSource() == nudgeC && nudgeStartCount != 0 && nudgeDisableC == 1) { 
        	
			Sounds("slot.begin.wav");
        	
        	ranSlotC--; if(ranSlotC < 0) { ranSlotC = 5; } 
    		timerNudgeC.start(); 
        	
        	//decrese nudge counter and lights by 1
        	nudgeStartCount--;
        	nudgeCounter.setText(" " + nudgeStartCount);
        	randomNudgeMap.get(nudgeStartCount).setBackground(Color.gray);
        	//when nudge counter goes to zero turn off button light
        	if(nudgeStartCount == 0) { 
        		nudgeA.setBackground(UIManager.getColor("Button.background")); 
        		nudgeB.setBackground(UIManager.getColor("Button.background"));
        		nudgeC.setBackground(UIManager.getColor("Button.background"));  
        		}
        	System.out.println("first time two = " + firstTimeTwoCount);
        	//ResetToZeroNudgesWhenNoMoreBets();
        }
        ////////////////////////////////////////////////////////////////////////
        //TIMERS NUDGE
		timerNudgeA = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				slotFirst = slotFirst + 10;
				slotFirstImg.setBounds(0, slotFirst, 100, 900);
				
				
//				System.out.println("SLOT FIRST" + slotFirst);
//				System.out.println("ANUDGE = " + ranSlotA);
//				System.out.println("BNUDGE = " + ranSlotB);
//				System.out.println("CNUDGE = " + ranSlotC);
				
				if(slotFirst == (-50 + -(ranSlotA * 100)) ) {
					//timerNudgeA.stop();
					 ((Timer) e.getSource()).stop();
					 ////////////////////////////////
					 //check nudge pi symbol - only when all nudges are gone
					 if(nudgeStartCount == 0) { 
							//how many pi symbols collected
							NudgeSymbol(ranSlotA, ranSlotB, ranSlotC);
							ShowPiSymbols(nudgeSymbolCount);
					 }
					 //price 
					 //uncheck game button if nudged away from price
						//THREE OR TWO OF A KIND SLOT LINE
						SlotsThreeOrTwoOfAKind(ranSlotA, ranSlotB, ranSlotC);
						//get price of winning line
						PriceOfWinningLine(slotArray[0], slotArray[1]);	
						System.out.println("slotArray = " + slotArray[0]);
						System.out.println("nudge buttonA = " + nudgeGameButtonOnOffA);
						if(slotArray[0] == 2) { firstTimeTwoCount = firstTimeTwoCount + 1; }
						if(priceLine != 0 && slotArray[0] != 3 && firstTimeTwoCount == 1) {
							Sounds("twoOrThree.wav");
							//enable game button
							disableGameButtonA = 0;
							disableGameButtonB = 0;
							disableGameButtonC = 0;
							//disable spin button
						    disableSpinA = 0;
							disableSpinB = 0;
							disableSpinC = 0;
							if(nudgeGameButtonOnOffA == 1) { TimerStartGamePlay(); nudgeGameButtonOnOffA = 0; }
						}
						if(priceLine == 0){
							//enable game button
							disableGameButtonA = 1;
							disableGameButtonB = 1;
							disableGameButtonC = 1;
							//disable spin button
						    disableSpinA = 1;
							disableSpinB = 1;
							disableSpinC = 1;
							//reset
							firstTimeTwoCount = 0;
							
							if(nudgeGameButtonOnOffA == 0) { 
								TimerStopGamePlay(); 
							
								obstaclesButton.setBackground(UIManager.getColor("Button.background"));
								nudgeGameButtonOnOffA = 1; }	
						}
				}
				//loops back around
				if(slotFirst == -50) { slotFirst = -650; }
			}		
		});

		
		timerNudgeB = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				slotSecond = slotSecond + 10;
				slotSecondImg.setBounds(0, slotSecond, 100, 900);
				
				if(slotSecond == (-50 + -(ranSlotB * 100)) ) {
					//timerNudgeB.stop();
					((Timer) e.getSource()).stop();
					
					 //check nudge pi symbol - only when all nudges are gone
					 if(nudgeStartCount == 0) { 
							//how many pi symbols collected
							NudgeSymbol(ranSlotA, ranSlotB, ranSlotC);
							ShowPiSymbols(nudgeSymbolCount);
					 }
					 //price 
					 //uncheck game button if nudged away from price
						//THREE OR TWO OF A KIND SLOT LINE
						SlotsThreeOrTwoOfAKind(ranSlotA, ranSlotB, ranSlotC);
						//get price of winning line
						PriceOfWinningLine(slotArray[0], slotArray[1]);	
						System.out.println("slotArray = " + slotArray[0]);
						System.out.println("nudge buttonB = " + nudgeGameButtonOnOffB);
						if(slotArray[0] == 2) { firstTimeTwoCount = firstTimeTwoCount + 1; }
						if(priceLine != 0 && slotArray[0] != 3 && firstTimeTwoCount == 1) {
							Sounds("twoOrThree.wav");
							//enable game button
							disableGameButtonA = 0;
							disableGameButtonB = 0;
							disableGameButtonC = 0;
							//disable spin button
						    disableSpinA = 0;
							disableSpinB = 0;
							disableSpinC = 0;
							if(nudgeGameButtonOnOffB == 1) { TimerStartGamePlay(); nudgeGameButtonOnOffB = 0; }
						}
						if(priceLine == 0){
							//enable game button
							disableGameButtonA = 1;
							disableGameButtonB = 1;
							disableGameButtonC = 1;
							//disable spin button
						    disableSpinA = 1;
							disableSpinB = 1;
							disableSpinC = 1;
							//reset
							firstTimeTwoCount = 0;
							
							if(nudgeGameButtonOnOffB == 0) { 
								TimerStopGamePlay(); 
								obstaclesButton.setBackground(UIManager.getColor("Button.background"));
								nudgeGameButtonOnOffB = 1; }
							
						}
				}
				//loops back around
				if(slotSecond == -50) { slotSecond = -650; }
			}		
		});
		
		timerNudgeC = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				slotThird = slotThird + 10;
				slotThirdImg.setBounds(0, slotThird, 100, 900);
				
				if(slotThird == -50 + -(ranSlotC * 100)) {
					//timerNudgeC.stop();
					((Timer) e.getSource()).stop();
					/////////////////
					 //check nudge pi symbol - only when all nudges are gone
					 if(nudgeStartCount == 0) { 
							//how many pi symbols collected
							NudgeSymbol(ranSlotA, ranSlotB, ranSlotC);
							ShowPiSymbols(nudgeSymbolCount);
					 }
					 //price 
					 //uncheck game button if nudged away from price
						//THREE OR TWO OF A KIND SLOT LINE
						SlotsThreeOrTwoOfAKind(ranSlotA, ranSlotB, ranSlotC);
						//get price of winning line
						PriceOfWinningLine(slotArray[0], slotArray[1]);	
						System.out.println("slotArray = " + slotArray[0]);
						System.out.println("nudge buttonC = " + nudgeGameButtonOnOffC);
						if(slotArray[0] == 2) { firstTimeTwoCount = firstTimeTwoCount + 1; }
						if(priceLine != 0 && slotArray[0] != 3 && firstTimeTwoCount == 1) {
							Sounds("twoOrThree.wav");
							//enable game button
							disableGameButtonA = 0;
							disableGameButtonB = 0;
							disableGameButtonC = 0;
							//disable spin button
						    disableSpinA = 0;
							disableSpinB = 0;
							disableSpinC = 0;
							if(nudgeGameButtonOnOffC == 1) { TimerStartGamePlay(); nudgeGameButtonOnOffC = 0; }
						
						}
						if(priceLine == 0){
							//enable game button
							disableGameButtonA = 1;
							disableGameButtonB = 1;
							disableGameButtonC = 1;
							//disable spin button
						    disableSpinA = 1;
							disableSpinB = 1;
							disableSpinC = 1;
							//reset
							firstTimeTwoCount = 0;
							
							if(nudgeGameButtonOnOffC == 0) {
								TimerStopGamePlay(); 
								obstaclesButton.setBackground(UIManager.getColor("Button.background"));
								nudgeGameButtonOnOffC = 1; }
							
						}

				}

				//loops back around
				if(slotThird == -50) { slotThird = -650; }
			}		
		});
        ////////////////////////////////////////////////////////////////////////
        
        //////////////////////OBSTACLE BUTTONS//////////////////////////////////
        //GAME BUTTON
        if(e.getSource() == obstaclesButton && disableGameButtonA == 0 && disableGameButtonB == 0 && disableGameButtonC == 0) {
        	ObstacleGameButtonPlay();
        	//System.out.println("GAME BUTTON");
        } 
        //HEADS
        if(e.getSource() == headsButton && headsDisable == 0) {
        	coinHeads = false;
        	HeadsOrTailsObstacle(coinHeads);
        }
        //TAILS
        if(e.getSource() == tailsButton && tailsDisable == 0) {
        	coinTails = true;
        	HeadsOrTailsObstacle(coinTails);
        }
        //PERCENT
        if(e.getSource() == percentButton && percentDisable == 0) {
        	PercentObstacle();
        }
        //WIN OR LOSE
        if(e.getSource() == winLoseButton && winLoseDisable == 0) {
        	TimerStopWinOrLose();
        	WinOrLoseObstacle();
        }
        ////////////////////////////////////////////////////////////////////////
        //COLLECT BUTTON
        if(e.getSource() == collectButton) { 
        	
        	Collect(totalBets, totalPayAdding, spinCount);
        	NewFrameOnCollectButtonClick(totalBets, totalPayAdding, totalProfit);
        	//set total bets to zero
        	totalBets = 0;
        	}
        ////////////////////////////////////////////////////////////////////////
        
	}
	
	public int NudgeSymbol(int slota, int slotb, int slotc) {
		
		if(slota == 1 && nudgeStartCount == 0) { nudgeSymbolCount++; }
		if(slotb == 5 && nudgeStartCount == 0) { nudgeSymbolCount++; }
		if(slotc == 3 && nudgeStartCount == 0) { nudgeSymbolCount++; }
		
		//in case of too many nudges
		if(nudgeSymbolCount == 4 || nudgeSymbolCount == 5 || nudgeSymbolCount == 6) { nudgeSymbolCount = 3; }
		
		return nudgeSymbolCount;
	}
	
	public void ShowPiSymbols(int showPiCount) {
		
		//show pi symbol light up with nudge symbol count
		for(int x = 0; x < showPiCount; x++) {
		
		 nudgeSymbolPI.get(x).setForeground(Color.yellow);
		}
		//PI COUNT ON 3 - all slots finish 
		if(showPiCount == 3 && disableSpinA == 1 && disableSpinB == 1 && disableSpinC == 1 && nudgeStartCount == 0) { StartRandomNudgeSelect(showPiCount); }
	}
	
	//RANDOM 5 LIGHTS
	public void StartRandomNudgeSelect(int nudge) {
		
		//disable spin
		disableSpinA = 0;
		disableSpinB = 0;
		disableSpinC = 0;
		
		
		//start random selector 5 lights
		timerFiveNudges = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Sounds("multiple.wav");
				//enable N-SPIN BUTTON
	    		nudgeCount = 1;
				
				//random number
				ranNudge = random.nextInt(5);
				//System.out.println("random nudge = " + ranNudge);
				
				//turn all grey
				nudgeCounterA.setBackground(Color.gray);
				nudgeCounterB.setBackground(Color.gray);
				nudgeCounterC.setBackground(Color.gray);
				nudgeCounterD.setBackground(Color.gray);
				nudgeCounterE.setBackground(Color.gray);
				
				//loop number of random nudges - light up - turn yellow
				for(int x = 0; x <= ranNudge; x++) {
					randomNudgeMap.get(x).setBackground(Color.yellow);
				}

			}
			
		});
		
		//start timer
		timerFiveNudges.start();
		
		//light up nudge buttons and enable nudge buttons
		
	}
	
	//return array - how many of x number
	public int[] SlotsThreeOrTwoOfAKind(int aSlotLine, int bSlotLine, int cSlotLine) {
		
//		System.out.println("AS = " + ranSlotA);
//		System.out.println("BS = " + ranSlotB);
//		System.out.println("CS = " + ranSlotC);
		
		int twoOfAKind;
        //CHECK IF A OR B IS MAIN NUMBER
        if(aSlotLine == bSlotLine) { 
        	twoOfAKind = bSlotLine;}
        else { 
        	twoOfAKind = cSlotLine;}
			
	    HashSet<Integer> set = new HashSet<Integer>();  
	    //add first number
        set.add(aSlotLine);    
        //add second number
        set.add(bSlotLine);
        if(set.size() == 1) {slotArray[0] = 2; slotArray[1] = bSlotLine;}
        if(set.size() == 2) {slotArray[0] = 1; slotArray[1] = 0;}
        //add third number
        set.add(cSlotLine);   
        if(set.size() == 1) {slotArray[0] = 3; slotArray[1] = cSlotLine;}
        if(set.size() == 2) {slotArray[0] = 2; slotArray[1] = twoOfAKind;}
        if(set.size() == 3) {slotArray[0] = 1; slotArray[1] = 0;}
		
//		System.out.println(slotArray[0]);
//		System.out.println(slotArray[1]);

		return slotArray;
	}
	
	//goto to game with price of line
	public Double PriceOfWinningLine(int HowManyLine, int PriceLine) {
		
		
		if(HowManyLine == 1) {  priceLine = 0.0; }
		
		//5 - cherry
		//4 - lemon
		//3 - raspberry
	    //2 - seven
		//1 - water melon
		//0 - diamond
		
		if(HowManyLine == 2) {
			
			switch(PriceLine) {
			
			  case 0:
				  priceLine = 0.2;
			    break;		    
			  case 1:
				  priceLine = 0.2;
			    break;		    
			  case 2:
				  priceLine = 0.8;
			    break;		    
			  case 3:
				  priceLine = 0.6;
			    break;		    
			  case 4:
				  priceLine = 0.4;
			    break;			    
			  case 5:
				  priceLine = 0.2;
			    break;
			  default:
			}	
		}
		
		if(HowManyLine == 3) {
			
			switch(PriceLine) {
			
			  case 0:
				  priceLine = 1.0;
			    break;		    
			  case 1:
				  priceLine = 1.0;
			    break;		    
			  case 2:
				  priceLine = 4.0;
			    break;		    
			  case 3:
				  priceLine = 3.0;
			    break;		    
			  case 4:
				  priceLine = 2.0;
			    break;			    
			  case 5:
				  priceLine = 1.0;
			    break;
			  default:
			}
		}
		
		
		return priceLine;
	}
	
	public void LightUpGameButton(double price) {
		//light up when all slots have finished spinning
		if(price != 0.0 && disableGameButtonA == 0 && disableGameButtonB == 0 && disableGameButtonC == 0) {
			TimerStartGamePlay();
			 Sounds("twoOrThree.wav");
			}
	}
	
	////////////////////////////////////OBSTACLES//////////////////////////////////////////
	public void ObstacleGameButtonPlay() {
		//disable nudges
    	nudgeDisableA = 0;
    	nudgeDisableB = 0;
    	nudgeDisableC = 0;
		//stop flashing light
    	TimerStopGamePlay();
		//start heads or tails spin
    	TimerStartHeadsOrTails();
    	//nudge game play button reset
    	nudgeGameButtonOnOffA = 1;
    	nudgeGameButtonOnOffB = 1;
    	nudgeGameButtonOnOffC = 1;
    	//enable heads and tails button
    	headsDisable = 0;
    	tailsDisable = 0;
    	//disable game button
    	disableGameButtonA = 1;
    	disableGameButtonB = 1;
    	disableGameButtonC = 1;
		//reset
		firstTimeTwoCount = 0;
    	//gray out box
    	obstaclesButton.setBackground(UIManager.getColor("Button.background"));
    	
	}
	
	public void HeadsOrTailsObstacle(boolean coin) {
		
		//stop coin image on random number when button pressed
		TimerStopHeadsOrTails();
		//take what button was pressed compare coin and player selection
		SuccessOrBadLuck(coin);
		//disable heads and tails button
    	headsDisable = 1;
    	tailsDisable = 1;
		//if success or fail spin
		if(successOrFail == true) {
			Sounds("win.wav");
			//start percent timer
			TimerStartPercent();
			//put price in box
			percentIn.setText("£" + df.format(priceLine));
			percentDisable = 0;
		}else { 
			Sounds("lose.wav");
//			cross.setBackground(UIManager.getColor("Button.background"));
			AutomaticSpinReset(); 
			}
	}
	public void SuccessOrBadLuck(boolean coin) {
		//light up outcome block - success or bad luck
		if(spinCoin == coin) {
			successOrFail = true;
			tick.setBackground(Color.yellow);	

		}else {
			
			Sounds("lose.wav");
			
			successOrFail = false;
			cross.setBackground(Color.yellow);
		}
	}
	
	
	public void PercentObstacle() {		
		Sounds("win.wav");
		//calculate percentage when button pressed and place at bottom
		percentOutcome = (priceLine/100) * (ranPercent*20);
		percentOut.setText("£" + df.format(percentOutcome));
		//stop timer percent
		TimerStopPercent();
		//disable percent button
		percentDisable = 1;
		//run win lose time
		TimerStartWinOrLose();
		//enable win lose button
		winLoseDisable = 0;
	}
	//public 
	
	public void WinOrLoseObstacle() {
		//make light go up and down
		TimerStopWinOrLose();
		// if win put money in WIN BOX - if not spin
		if(winLoseCount >= 6 && winLoseCount <= 11) {
			//WIN
			win.setText("£" + df.format(percentOutcome));
			totalPayAdding = totalPayAdding + percentOutcome;
			totalPay.setText("£" + df.format(totalPayAdding));
			AutomaticSpinReset();
			
			Sounds("success.wav");
			
		}else {
			
			Sounds("lose.wav");
			
		AutomaticSpinReset();
		}
		//reset counter to zero
		winLoseCount = 0;
	}
	
	//AUTOMATIC SPIN - BACK TO START
	public void AutomaticSpinReset() {
		
		Sounds("slot.begin.wav");
		
		//automatic spin
		ranSlotA = randomSlotFirst.nextInt(6);
		ranSlotB = randomSlotFirst.nextInt(6);
		ranSlotC = randomSlotFirst.nextInt(6);		

		//start timers
		timerSlotFirst.start();
		timerSlotSecond.start();
		timerSlotThird.start();
		//how many pi symbols collected
		NudgeSymbol(ranSlotA, ranSlotB, ranSlotC);
		//THREE OR TWO OF A KIND SLOT LINE
		SlotsThreeOrTwoOfAKind(ranSlotA, ranSlotB, ranSlotC);
		//get price of winning line
		PriceOfWinningLine(slotArray[0], slotArray[1]);
		//nudges enable
    	nudgeDisableA = 1;
    	nudgeDisableB = 1;
    	nudgeDisableC = 1;
		//when bets are zero reset nudges
    	//ResetToZeroNudgesWhenNoMoreBets();
	}
	
	public void ResetAllObstacleLights() {
		//gray out and white out boxes
		if(endOfAllSlotsA == 0 && endOfAllSlotsB == 0 && endOfAllSlotsC == 0) {
		tick.setBackground(Color.blue);
		cross.setBackground(Color.blue);
		percentIn.setText("£0.00");
		percentOut.setText("£0.00");
		percent20.setBackground(Color.blue);
		percent40.setBackground(Color.blue);
		percent60.setBackground(Color.blue);
		percent80.setBackground(Color.blue);
		percent100.setBackground(Color.blue);
		winOrLosel1.setBackground(Color.white);
		winOrLosel2.setBackground(Color.white);
		winOrLosel3.setBackground(Color.white);
		winOrLosel4.setBackground(Color.white);
		winOrLosel5.setBackground(Color.white);
		winOrLosel6.setBackground(Color.white);
		winOrLosel7.setBackground(Color.white);
		winOrLosel8.setBackground(Color.white);
		winOrLosel9.setBackground(Color.white);
		}
	}
	
	
	//TIMERS START
	public void TimerStartGamePlay() {
		
		timerGamePlay = new Timer(400, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//FLASHING GAME BUTTON
				if (flashGamePlayButton == true) {
					obstaclesButton.setBackground(Color.yellow);
					}
				else {
					obstaclesButton.setBackground(UIManager.getColor("Button.background")); 
				}
				
				flashGamePlayButton = !flashGamePlayButton;
			}
			});		
		timerGamePlay.start();
		}
	
	
	public void TimerStartHeadsOrTails() {
		
		timerHeadsOrTails = new Timer(200, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//FLASHING GAME BUTTON
				if (spinCoin == true) {
					//heads
					headsOrTailsImage.setBounds(0, -1, 80, 160);
					}
				else {//tails
					headsOrTailsImage.setBounds(0, -80, 80, 160);
				}
				
				spinCoin = !spinCoin;//false = heads true = tails
			}
			});
		timerHeadsOrTails.start();
		}
	
	
	public void TimerStartPercent() {
		
		timerPercent = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//random number
				ranPercent = randomPercent.nextInt(5)+1;
				//grey out all boxes
				percent20.setBackground(Color.blue);
				percent40.setBackground(Color.blue);
				percent60.setBackground(Color.blue);
				percent80.setBackground(Color.blue);
				percent100.setBackground(Color.blue);
				percent20.setOpaque(true);
				percent40.setOpaque(true);
				percent60.setOpaque(true);
				percent80.setOpaque(true);
				percent100.setOpaque(true);
				//System.out.println("ran = " + ranPercent);
				randomPercentMap.get(ranPercent).setBackground(Color.yellow);
				
				//nudgeCounterC.setOpaque(true);
				//light up box with random number
			}
			});
		timerPercent.start();
		}
	
	
	public void TimerStartWinOrLose() {
		
		timerWinOrLose = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//first 6 goes to white
				if(winLoseCount <= 5) {
					winLoseMap.get(winLoseArray[winLoseCount]).setBackground(Color.yellow);
					}
				//last 3 goes to red
				if(winLoseCount >= 6 && winLoseCount <= 8) {
					winLoseMap.get(winLoseArray[winLoseCount]).setBackground(Color.green);
					}
				//last 3 goes back to white
				if(winLoseCount >= 9 && winLoseCount <= 11) {
					winLoseMap.get(winLoseArray[winLoseCount]).setBackground(Color.white);
					}
				//last 6 goes back to white
				if(winLoseCount >= 12 && winLoseCount <= 17) {
					winLoseMap.get(winLoseArray[winLoseCount]).setBackground(Color.white);
					}
				
				winLoseCount++;
				
				if(winLoseCount == 18) { winLoseCount = 0; }
				
			}
			});
		timerWinOrLose.start();
		}
	
	
	//TIMERS STOP
	public void TimerStopGamePlay() {
		timerGamePlay.stop();
		}
	
	public void TimerStopHeadsOrTails() {
		timerHeadsOrTails.stop();
		}
	
	public void TimerStopPercent() {
		timerPercent.stop();
		}
	
	public void TimerStopWinOrLose() {
		timerWinOrLose.stop();
		}
	
	
	public double Collect(double howMuchPlayerBetted, double howMuchPlayerWon, int spinCount) {
	
		//get total profit
		if(howMuchPlayerBetted < howMuchPlayerWon) {
			totalProfit = Math.abs((howMuchPlayerBetted - ((double)spinCount * 0.25)) - howMuchPlayerWon);
		}
		else {
		
			totalProfit = -((howMuchPlayerBetted - ((double)spinCount * 0.25)) - howMuchPlayerWon);
		}
		
		//reset to zero - win and total win, bets
		win.setText(" £0.00");
		totalPay.setText(" £0.00");
		numberOfSpins.setText(" 0");
		cashIn.setText(" £0.00");
		//
		 nudgePI0.setForeground(Color.gray);
		 nudgePI1.setForeground(Color.gray);
		 nudgePI2.setForeground(Color.gray);
		 
		 //COLLECT SOUND
		 Sounds("collect.wav");
		
		return totalProfit;
	}
	
	public void ResetToZeroNudgesWhenNoMoreBets() {
		
		//check if bets is zero
		if(spinCount == 0 && priceLine == 0 && nudgeSymbolCount < 3 && nudgeStartCount == 0) {
		//reset nudges to zero
//			nudgeStartCount = 0;
//			nudgeCounter.setText(" " + nudgeStartCount);
			//nudge random colour to grey
			//
//			 nudgeSymbolPI.get(0).setForeground(Color.gray);
//			 nudgeSymbolPI.get(1).setForeground(Color.gray);
//			 nudgeSymbolPI.get(2).setForeground(Color.gray);
//			 nudgeSymbolCount = 0;
//			 nudgePI0.setForeground(Color.gray);
//			 nudgePI1.setForeground(Color.gray);
//			 nudgePI2.setForeground(Color.gray);
			 
			 //
//			nudgeCounterA.setBackground(Color.gray);
//			nudgeCounterB.setBackground(Color.gray);
//			nudgeCounterC.setBackground(Color.gray);
//			nudgeCounterD.setBackground(Color.gray);
//			nudgeCounterE.setBackground(Color.gray);
			//disable nudge buttons
			nudgeDisableA = 0;
			nudgeDisableB = 0;
	        nudgeDisableC = 0;
	        System.out.println("reset");
		}
	}
	
	public void NewFrameOnCollectButtonClick(double totalBets, double totalPayAdding, double totalProfit) {
		//frame
		JFrame frame2 = new JFrame();
		frame2.setTitle("Collect Money");//set title
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close window
		frame2.setSize(600,200);//size of window
		frame2.setLocationRelativeTo(null);//center of screen
		
		ImageIcon image = new ImageIcon("casino.jpg"); // set image on corner
		frame2.setIconImage(image.getImage());
		
		frame2.setVisible(true);//show window
		frame2.setLayout(null);//no layout
		
		//lines around panels
		Border lineBorder = BorderFactory.createLineBorder(Color.gray,3);
		
		//panels
		JPanel mainPanel = new JPanel();
		
		//labels
		JLabel totalBetsLabel = new JLabel();
		JLabel totalWinningsLabel = new JLabel();
		JLabel totalProfitLabel = new JLabel();
		
		mainPanel.setBackground(Color.yellow);
		mainPanel.setBounds(0,0,582,160);
		mainPanel.setBorder(lineBorder);
		mainPanel.setLayout(null);
		frame2.add(mainPanel);
		double tBets = (totalBets - ((double)spinCount * 0.25));
		totalBetsLabel.setBounds(10, 10, 150, 30);
		totalBetsLabel.setText("Total Bets = £" + df.format(tBets));
		//totalBetsLabel.setForeground(Color.white);
		mainPanel.add(totalBetsLabel);
		
		totalWinningsLabel.setBounds(10, 50, 150, 30);
		totalWinningsLabel.setText("Total Winnings = £" + df.format(totalPayAdding));
		
		//totalWinningsLabel.setForeground(Color.white);
		mainPanel.add(totalWinningsLabel);
		
		totalProfitLabel.setBounds(10, 90, 150, 30);
		totalProfitLabel.setText("Total Profit = £" + df.format(totalProfit));
		//totalProfitLabel.setForeground(Color.white);
		mainPanel.add(totalProfitLabel);
	}
	
	
	//SOUNDS
	public void Sounds(String sound) {
		//slot begin sound
		String soundName = sound;    
		AudioInputStream audioInputStream = null;
		Clip clip = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}
	
//	public void SlotSpinSound() {}
//	public void SlotEndSound() {}
	public void TwoOrThreeSound() {}
	public void WinSound() {}
	public void CollectSound() {}
	
	
}

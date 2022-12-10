package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Obstacles {
	
	Slots slotMachine = new Slots();
	
//	Timer timerGamePlay;
//	Timer timerHeadsOrTails;
//	Timer timerPercent;
//	Timer timerWinOrLose;
//	
//	boolean flashGamePlayButton = true;
//	
//	public void ObstacleGameButtonPlay() {
//		
//	}
//	
//	public int HeadsOrTailsObstacle() {
//		return 0;
//		
//	}
//	
//	public int PercentObstacle() {
//		return 0;
//		
//	}
//	
//	public int WinOrLoseObstacle() {
//		return 0;
//	}
//	
//	
//	//TIMERS START
//	public void TimerStartGamePlay() {
//		
//		System.out.println("inside");
//		
//		timerGamePlay = new Timer(10, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				//FLASHING GAME BUTTON
//				if (flashGamePlayButton == true) {
//					slotMachine.obstaclesButton.setForeground(Color.yellow);
//					}
//				else {
//					slotMachine.obstaclesButton.setBackground(UIManager.getColor("Button.background")); 
//				}
//				
//				flashGamePlayButton = !flashGamePlayButton;
//			}
//			});
//		
//		timerGamePlay.start();
//		}
//	
//	
//	public void TimerStartHeadsOrTails() {
//		
//		timerHeadsOrTails.start();
//		
//		timerHeadsOrTails = new Timer(10, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//			});
//		}
//	
//	public void TimerStartPercent() {
//		
//		timerPercent.start();
//		
//		timerPercent = new Timer(10, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//			});
//		}
//	
//	public void TimerStartWinOrLose() {
//		
//		timerWinOrLose.start();
//		
//		timerWinOrLose = new Timer(10, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//			});
//		}
//	
//	//TIMERS STOP
//	public void TimerStopGamePlay() {
//		timerGamePlay.stop();
//		}
//	
//	public void TimerStopHeadsOrTails() {
//		timerHeadsOrTails.stop();
//		}
//	
//	public void TimerStopPercent() {
//		timerPercent.stop();
//		}
//	
//	public void TimerStopWinOrLose() {
//		timerWinOrLose.stop();
//		}

}


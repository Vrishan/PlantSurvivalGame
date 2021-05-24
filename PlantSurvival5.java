// Vrishan Inukollu
// 5/22/21
// Plant Survival5.java

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Image;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;	


public class PlantSurvival5
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("PLANT SURVIVAL");
		frame.setLayout(new BorderLayout());
		CardPanel5 panel5 = new CardPanel5();
		frame.add(panel5, BorderLayout.CENTER);
		frame.setSize(1000, 1000);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	//this class sets yup the main panel and adds a frame to it. It also 
	// adds all the other panels onto this main panel.
	class CardPanel5 extends JPanel
	{
			private CardLayout cardsList;//cardlayout 
			private PlayerData5 data;
			
			public CardPanel5 ( )
			{
			data = new PlayerData5();
			
			setBackground(Color.blue);
			setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			cardsList = new CardLayout();
			setLayout(cardsList);
			
			HomePanel5 first = new HomePanel5(data,cardsList, this);
			add(first, "1");
			
			InstructionsPanel5 third = new InstructionsPanel5(data,cardsList, this);
			add(third, "3");
			
			LevelPanel5 second = new LevelPanel5(data,cardsList, this);
			add(second, "2");
			
		
			PlayingPanel5 fourth = new PlayingPanel5(data,cardsList, this);
			add(fourth, "4");
			
			ScoresPanel5 fifth = new ScoresPanel5(data,cardsList, this);
			add(fifth, "5");
			
			GameOverPanel5 sixth = new GameOverPanel5(data,cardsList, this);
			add(sixth, "6");
		}
	}
	// this is the main home page where all the navigation takes place.
	// This is where the user inputs their name and goes to play the game,
	// goes to instructions or goes to view the leaderboard.
	class HomePanel5 extends JPanel implements ActionListener
	{
		private PlayerData5 data;
		private CardLayout cardsList;
		private CardPanel5 mainPanel;//object of the CardPanel 
		private InstructionsPanel5 instructionsPanel;// object of the InstructionsPanel
		private JButton play, instructions, leaderboard;// vars for the buttons
		private JTextField nameField;// textfield variable
		
		public HomePanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
		{
			data = d;
			cardsList = c;
			mainPanel = m;
			
			setLayout(null);
			setBackground(Color.green);
			Font myFont = new Font("Serif", Font.BOLD, 45);
			
			JPanel panelCard = new JPanel();
			panelCard.setBackground(Color.white);
			panelCard.setLayout(null);
			add(panelCard);
		
		
			JLabel titleName = new JLabel("Plant Survival");
			titleName.setFont(myFont);
			add(titleName);
			
			nameField = new JTextField("Enter your Name ");
			nameField.setMargin(new Insets(10,10,10,10));
			nameField.setFont(myFont);
			add(nameField);
			
			 play = new JButton("PLAY");
			 play.addActionListener(this);
			 add(play); 
			 
			 instructions = new JButton("Instructions");
			 instructions.addActionListener(this);
			 add(instructions);
			 
			 leaderboard = new JButton("Leaderboard");
			 leaderboard.addActionListener(this);
			 add(leaderboard);
			 
			 titleName.setBounds(350,0,600,300);
			 nameField.setBounds(330,330,400,50);
			 play.setBounds(420,440,170,40);
			 instructions.setBounds(420,500,170,40);
			 leaderboard.setBounds(420,560,170,40);
			
			
		}
	
		// this method lets the user go to the Instruction panel and 
		// learn how to play the game.
		public void actionPerformed(ActionEvent evt) 
		{
			String command = evt.getActionCommand();
			
			if(command.equals("Instructions") )
			{
				data.setName(nameField.getText());
				cardsList.next(mainPanel);
				
			}
			
			else if(command.equals("PLAY") )
			{
				data.setName(nameField.getText());
				cardsList.show(mainPanel, "2");
				
			}
			
			
			else if(command.equals("Leaderboard") )
			{
				
				data.setName(nameField.getText());
				cardsList.show(mainPanel, "5");
				data.getMyHighScores();
				
			}
		
		}
	}	
	
	
	// This class is where there is a JTextArea that has all the instructions on it. 
	// It uses a borderlayout that sets the text in the center with the 
	// title on the top and the button on the botton. The button allows
	// the user to go back to the home page.
	class InstructionsPanel5 extends JPanel implements ActionListener
	{
			private JButton backToHome;// button to go back to home page
			private JScrollPane instructionsScroll;
			private CardLayout cardsList;// cardlayout
			private CardPanel5 mainPanel;//the home page
			private PlayerData5 data;
			
			public InstructionsPanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
			{
				
				data = d;
				cardsList = c;
				mainPanel = m;
				
				
				setLayout(new BorderLayout(40, 40));
				setBackground(Color.green);
				Font myFont = new Font("Serif", Font.BOLD, 45);
				Font instructionsFont = new Font("Serif", Font.BOLD, 25);
				JPanel instructionsPanel = new JPanel();
				instructionsPanel.setLayout(new BorderLayout(40, 40) );
				instructionsPanel.setBackground(Color.pink);
				
				JLabel title = new JLabel("Instructions");
				title.setFont(myFont);
				instructionsPanel.add(title);
				add(instructionsPanel, BorderLayout.NORTH);
				
				
				String gameInstructions = new String("\t\tWelcome to Plant Survival.\n"
				+ "  This is the Instructions panel which will teach you how to play the game."
				+ " When the user clicks on the PLAY button it will go to another"
				+ " panel that will prompt the user to select a level of difficulty."
				+ " Once selected the user presses play and will start the game."
				+ " The goal of the game is the keep your plant alive for as"
				+ " long as possible without killing it. Once you enter the game"
				+ " panel, you will see a menu bar and 4 buttons. The menu bar on the top left"
				+ " allows the user to select the type of background they want."
				+ " The buttons are used to give food and nutrients to keep the plant alive."
				+ "\n\n  There are 3 health bars that will keep your plant alive."
				+ " The health bars are water, food and sun which are blue, red, yellow. "
				+ " If one of your health bar's is running low then you need to"
				+ " press the right button to increase the bar. There is a "
				+ " start game button which must be pressed to start the game."
				+ " On the right side there is a timer which tells the player "
				+ " how long their plant has survived for. After a certain "
				+ " amount of time there will be an enemie(insect) which will "
				+ " start to appear at random times and at different speeds."
				+ " In order to kill the insect the player needs to click"
				+ " on the insect to make it disappear. \n\n  The game ends when"
				+ " 2 of the 3 health bars reaches 0. Once it reaches 0"
				+ " the user will be taken to a game over screen with 2"
				+ " buttons. One is play again which allows the user to"
				+ " choose their level and play again. The 2nd button is"
				+ " the refresh button which updates the scores to show the latest one"
				+ " The third button is the Leaderboard button which"
				+ " allows the user to see the top 5 scores and see if their"
				+ " score made it into the top 5. \n\n  Hope you enjoy my game :) ");
			
				JTextArea instructions = new JTextArea(gameInstructions);
				instructions.setLineWrap(true);
				instructions.setWrapStyleWord(true);
				instructions.setEditable(false);
				add(instructions, BorderLayout.CENTER);
				instructions.setBounds(250,300,600,450);
				instructions.setFont(instructionsFont);
				instructionsScroll = new JScrollPane(instructions);
				this.add(instructionsScroll);
				JPanel emptyPanel1 = new JPanel();
				emptyPanel1.setLayout(null);
				emptyPanel1.setBackground(Color.gray);
				add(emptyPanel1, BorderLayout.EAST);
				
				JPanel emptyPanel2 = new JPanel();
				emptyPanel2.setLayout(null);
				emptyPanel2.setBackground(Color.gray);
				add(emptyPanel2, BorderLayout.WEST);
				
				JPanel buttonHolder = new JPanel();
				buttonHolder.setLayout(new BorderLayout(40,40) );
				buttonHolder.setBackground(Color.magenta);
				backToHome = new JButton("Back to Home");
				backToHome.addActionListener(this);
				
				add(buttonHolder, BorderLayout.SOUTH);
				buttonHolder.add(backToHome, BorderLayout.SOUTH);
				
			
			}
			// This method allows the user to press the home button and
			// goes back to the home navigation page.
			public void actionPerformed(ActionEvent evt) 
			{
				String command = evt.getActionCommand();
			
				if(command.equals("Back to Home"))
				{
				
				cardsList.first(mainPanel);
				}
		
			}
	
	}
	// This class makes 3 radio buttons which sets the levels for the 
	// player to play. The 3 levels are easy,medium, and hard. Each
	// level will make the game harder by making the healthbars decrease
	// faster and the enemy attacking more frequently and faster.
	class LevelPanel5 extends JPanel implements ActionListener
	{
		private CardLayout cardsList;// cardlayout
		private CardPanel5 mainPanel;//the home page
		private JRadioButton [] levels;// the 3 different levels
		private JButton startButton;
		private ButtonGroup bgGroup;
		private PlayerData5 data;
		
		
		public LevelPanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
		{
			data = d;
			cardsList = c;
			mainPanel = m;
			levels = new JRadioButton[3];
			
			setLayout(new BorderLayout(40,40));
			setBackground(Color.white);
			Font myFont = new Font("Serif", Font.BOLD, 45);
			
			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0) );
			titlePanel.setBackground(Color.white);
			
			JLabel levelTitle = new JLabel("Please select a level and press START");
			levelTitle.setFont(myFont);
			titlePanel.add(levelTitle);
			add(titlePanel, BorderLayout.NORTH);
			
			JPanel rbButtonPanel = new JPanel();
			rbButtonPanel.setLayout(new GridLayout(3,1));
			rbButtonPanel.setBackground(Color.pink);
			
			JRadioButton choice1 = new JRadioButton("Easy");
			rbButtonPanel.add(choice1);
			choice1.addActionListener(this);
			choice1.setSelected(true);
			choice1.setActionCommand("Easy");
			
			JRadioButton choice2 = new JRadioButton("Medium");
			rbButtonPanel.add(choice2);
			choice2.addActionListener(this);
			choice2.setActionCommand("Medium");
			
			JRadioButton choice3 = new JRadioButton("Hard");
			rbButtonPanel.add(choice3);
			choice3.addActionListener(this);
			choice3.setActionCommand("Hard");
			
			
			bgGroup = new ButtonGroup();
			bgGroup.add(choice1);
			bgGroup.add(choice2);
			bgGroup.add(choice3);
			
			add(rbButtonPanel,BorderLayout.CENTER);
			
			
			startButton = new JButton("START");
			startButton.addActionListener(this);
			add(startButton, BorderLayout.SOUTH);
		
		}
		
		public void actionPerformed(ActionEvent evt) 
		{
			String command = evt.getActionCommand();
			
				if(command.equals("START"))
				{
					String t = bgGroup.getSelection().getActionCommand();
					if(t != null)
					{
						data.setLevel(t);
						cardsList.next(mainPanel);
					}
				}
		}
	}
	// This class is the maingame class where the game is played. On the north
	// of the panel there will be the 3 buttons and the background menu
	// There will be a timer running in the east and in the west there
	// will be 3 health bars. In the center panel the plant and enemies
	// will be shows.
		class PlayingPanel5 extends JPanel implements MouseListener
		{
			private CardLayout cardsList;// cardlayout
			private CardPanel5 mainPanel;//the home page
			private PlayerData5 data;
			private TimeHandler5 tih;
			private Image image, bg1,bg2,bg3;// pictures and background
			private Image seed, sprout, tree, deadPlant, enemy;// game images
			private String seedName, sproutName, treeName, deadPlantName, enemyName;
			private String imageName, bg1Name, bg2Name, bg3Name;// name of pictures
			private Font myFont, font;
			private JButton water,food,sun;// buttons for food
			private JMenuBar sceneryBar;
			private JMenu scenery;
			private JMenuItem sunny, cloudy, hills;
			private Timer timer;
			private int tenthSec;// seconds for timer
			private int elapsedMinutes;// total time
			private double secondsDecimal, secondsDisplay;
			private boolean running;// if timer is running then timer is on, if not then false
			private JPanel imagePanel;
			private int backgroundCounter;
			private ProgressBarHandler5 waterBar,sunBar,foodBar;
			private EnemyHandler5 eh;
			private int plantCounter;
			
			public PlayingPanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
			{
				beginningValues();
				tih = new TimeHandler5();
				timer = new Timer(100, tih);
				data = d;
				cardsList = c;
				mainPanel = m;
				plantCounter = 0;
				
				
				setLayout(new BorderLayout(40,40));
				setBackground(Color.white);
				Font myFont = new Font("Serif", Font.BOLD, 45);
				Font font = new Font("Serif", Font.BOLD, 30);
				ButtonHandler5 bh = new ButtonHandler5();
				reset();
				
				addMouseListener(this);
				JPanel menuButtonPanel = new JPanel();//panel for the north which will hold the JMenu and buttons
				menuButtonPanel.setLayout(new BorderLayout(40,40) );
				menuButtonPanel.setBackground(Color.green);
				add(menuButtonPanel, BorderLayout.NORTH);
				
				JPanel menuPanel = new JPanel();//panel for adding the menubar to the west
				menuPanel.setLayout(new FlowLayout() );
				menuPanel.setBackground(Color.green);
				
				
				JMenuBar sceneryBar = new JMenuBar();//menuBar 
				sceneryBar.setBackground(Color.white);
				
				JMenu scenery = new JMenu("Scenery");// JMenu which is added to the menuBar
				scenery.setFont(myFont);
				scenery.setBackground(Color.white);
				
				JMenuItem sunny = new JMenuItem("Sunny");//menuItem
				sunny.setFont(myFont);
				JMenuItem cloudy = new JMenuItem("Cloudy");// menuItem
				cloudy.setFont(myFont);
				JMenuItem hills = new JMenuItem("Hills");// menuItem
				hills.setFont(myFont);
				
				sunny.addActionListener(bh);
				cloudy.addActionListener(bh);
				hills.addActionListener(bh);
				
				scenery.add(sunny);
				scenery.add(cloudy);
				scenery.add(hills);
				
				
				sceneryBar.add(scenery);
				menuPanel.add(sceneryBar, BorderLayout.CENTER);
				menuButtonPanel.add(menuPanel, BorderLayout.WEST);
				
				JPanel nutrientsPanel = new JPanel();//panel to add the buttons
				nutrientsPanel.setLayout(new GridLayout(1,3,10,10));
				nutrientsPanel.setBackground(Color.magenta);
				
				water = new JButton("water");// water button
				water.addActionListener(bh);
				sun = new JButton("sun");// sun button
				sun.addActionListener(bh);
				food = new JButton("food");// food button
				food.addActionListener(bh);
				
				nutrientsPanel.add(water);
				nutrientsPanel.add(sun);
				nutrientsPanel.add(food);
				
				menuButtonPanel.add(nutrientsPanel, BorderLayout.CENTER);
				
				JPanel emptyEastPanel = new JPanel();// empty panel for formatting
				emptyEastPanel.setLayout(new FlowLayout());
				emptyEastPanel.setBackground(Color.green);
				menuButtonPanel.add(emptyEastPanel, BorderLayout.EAST);
				
				JButton starter = new JButton("START GAME");//start Button for timer
				starter.addActionListener(bh);
				emptyEastPanel.add(starter);
				
				bg1 = null;
				bg2 = null;
				bg3 = null;
				seed = null;
				sprout = null;
				tree = null;
				deadPlant = null;
				enemy = null;
				
				
				bg1Name = "sunny.jpeg";
				bg2Name = "cloudy.png";
				bg3Name = "hills.jpeg";
				seedName = "seed.png";
				sproutName = "sprout.png";
				treeName = "tree.png";
				deadPlantName = "deadPlant.png";
				enemyName = "enemy.png";
				
				
				getMyImage();
				
				backgroundCounter = 0;
			}
			
			
		// sets the initials values 
		public void beginningValues()
		{
			tenthSec = elapsedMinutes = 0;
			secondsDecimal = secondsDisplay = 0.0;
			running = false;
		}
		
		// resets all values to its original values. It will also reset
		// the background to the original and reset the health bars to full.
		// resets the timer and plant images to original.
		public void reset()
		{
			waterBar = new ProgressBarHandler5(395,data.getLevel().getWaterSpeed(), data.getLevel().getWaterTime());
			sunBar = new ProgressBarHandler5(395,data.getLevel().getSunSpeed(), data.getLevel().getSunTime());
			foodBar = new ProgressBarHandler5(395,data.getLevel().getFoodSpeed(), data.getLevel().getFoodTime());
			eh = new EnemyHandler5();
			
			beginningValues();
			tih = new TimeHandler5();
			timer = new Timer(100, tih);
			plantCounter = 0;
			backgroundCounter = 0;
			
		}
		
		
		// sets the logic of the timer and sets the words to show the timer.
		// draws the background images based on users selection.
		public void paintComponent ( Graphics g )   
		{
			super.paintComponent ( g );
			g.setColor ( Color.BLACK );
			g.setFont (font);
			
			secondsDecimal = tenthSec / 10.0;
			secondsDisplay = secondsDecimal % 60; 
			elapsedMinutes = (int)secondsDecimal / 60;
			
			g.drawString ( "Time Elapsed:  " + elapsedMinutes + " minutes " + 
			String.format("%.1f", secondsDisplay) + " seconds" , 730, 85);
			
		
			if(backgroundCounter == 0)
			{
				g.drawRect(0,100,1000,700);
				setBackground(Color.pink);
				g.setFont(myFont);
				g.drawString(" Please select a scenery using the Scenery Bar" , 350, 300);
			}
			else if(backgroundCounter == 1)
			{
				g.drawImage(bg1, 0,100,1000,700, this);
			}
			else if(backgroundCounter == 2)
			{
				g.drawImage(bg2, 0,100,1000,700, this);
			}
			else if(backgroundCounter == 3)
			{
				g.drawImage(bg3, 0,100,1000,700, this);
			}
			if(backgroundCounter != 0)
			{
				double t = getTimeInSec();
				if(t <= 3.0)
					g.drawImage(seed, 450, 640, 100,100,this);
				else if(t <= 6.0)
					g.drawImage(sprout, 450,640, 100, 100,this);
				else
					g.drawImage(tree, 450,640, 100, 100, this);
					
				healthBars(g);
			
			}
			
		}
		// draws the healthbars and sets them to decrease based on the time
		// and also sets how fast they need to decrease. Draws the enemy 
		// and sets the speed and how frequent it shows up.
		public void healthBars(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(20,100,400,20);
			g.fillRect(20,121,400,20);
			g.fillRect(20,142,400,20);
			Levels5 barData = data.getLevel();
			
			int numOfZeroBars = 0;
			
			double timeInSec = getTimeInSec();
			if(timeInSec - waterBar.getTime() >= barData.getWaterTime() && waterBar.getLength() > 0)
            {
                waterBar.setLength(waterBar.getLength()- barData.getWaterSpeed() );
            }
            if(timeInSec - sunBar.getTime() >= barData.getSunTime() && sunBar.getLength() > 0)
            {
                sunBar.setLength(sunBar.getLength()- barData.getSunSpeed() );
            }
            if(timeInSec - foodBar.getTime() >= barData.getSunTime() && foodBar.getLength() > 0 && sunBar.getLength() > 0)
            {
                foodBar.setLength(foodBar.getLength()-barData.getFoodSpeed() );
            }
			
			g.setColor(Color.blue);
			g.fillRect(25,105,waterBar.getLength(),10);
			g.setColor(Color.red);
			g.fillRect(25,126,sunBar.getLength(),10);
			g.setColor(Color.yellow);
			g.fillRect(25,147,foodBar.getLength(),10);
			
			if(tih.getMovement() > 0 && tih.getX() >= 450)
			{
				
				tih.setMovement(0);
				eh.setTime(timeInSec);
				tih.setX(1200);
				waterBar.setLength(waterBar.getLength() - 80);
				sunBar.setLength(sunBar.getLength() - 60);
				foodBar.setLength(foodBar.getLength() - 50);
				
			
			}
			else if(tih.getMovement() == 0 && timeInSec - eh.getTime() >= eh.getRandom())
			{
				eh.resetRandom();
				tih.setMovement(barData.getEnemySpeed() );
				tih.setX(10);
			}
			g.drawImage(enemy, tih.getX(), 640, 100, 100, this);
			
			
			if(waterBar.getLength() == 0)
			{
				numOfZeroBars++;
			}
			if(sunBar.getLength() == 0)
			{
				numOfZeroBars++;
			}
			if(foodBar.getLength() == 0)
			{
				numOfZeroBars++;
			}
			
			if(numOfZeroBars == 2)
			{
				data.saveHighScores(getTimeInSec() );
				reset();
				cardsList.show(mainPanel, "6");
				
			}
		}
		
		
		// if start game button is pressed then the timer is on and its 
		// starts to run forever. It checks if the timer is running then
		// it runs it.
		class ButtonHandler5 implements ActionListener 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				String command = evt.getActionCommand();
				
				if ( command != null )   
				{
					if ( command.equals("START GAME") && backgroundCounter != 0 )
					{
						running = true;
						timer.start();
						
						repaint();
					}

				}
				repaint( );
				if(command.equals("Sunny") )
				{
					
					backgroundCounter = 1;
					repaint();
				}
				else if(command.equals("Cloudy") )
				{
					backgroundCounter = 2;
					repaint();
				}
				else if(command.equals("Hills") )
				{
					backgroundCounter = 3;
					repaint();
				}
				else if(command.equals("water") )
				{
					waterBar.setLength(waterBar.getLength()+40);
					waterBar.setTime(getTimeInSec());
				}
				else if(command.equals("sun") )
				{
					sunBar.setLength(sunBar.getLength()+30);
					sunBar.setTime(getTimeInSec());
				}
				else if(command.equals("food") )
				{
					foodBar.setLength(foodBar.getLength()+20);
					foodBar.setTime(getTimeInSec());
				}
			}
		}
		
		public double getTimeInSec()
		{
			return elapsedMinutes* 60 + secondsDisplay;
		}
		
		//This class sets the maximum length of the bar and how much the 
		// bar can decrease till. This also return the speed, delayRate
		// and time for the healthbars.
		class ProgressBarHandler5
		{
			private int barLength;
			private int speed;
			private double delayTime;
			private double lastTime;
			
			public ProgressBarHandler5(int bar, int s, double t)
			{
				barLength = bar;
				speed = s;
				delayTime = t;
				lastTime = 0.0;
				
			}
			public double getTime()
			{
				return lastTime;
			}
			public void setTime(double time)
			{
				lastTime = time;
			}
			public int getLength()
			{
				return barLength;
			}
			public void setLength(int l)
			{
				barLength = l;
				if(l > 395)
				{
					barLength = 395;
				}
				else if(l < 0)
				{
					barLength = 0;
				}
			}
			public int getSpeed()
			{
				return speed;
			}
			public double getDelayTime()
			{
				return delayTime;
			}
		}	
		
		
		// This class sets a random time at which the enemy will spawn.
		class EnemyHandler5
		{
			private double lastTime;
			private double random;
			private int xpos,ypos;
			
			public EnemyHandler5()
			{
				lastTime = 0.0;
				 
				resetRandom();	
			}
			public double getTime()
			{
				return lastTime;
			}
			public void setTime(double time)
			{
				lastTime = time;
			}
			public void resetRandom()
			{
				random = 0 + Math.random()*data.getLevel().getEnemyTime();	
			}
			public double getRandom()
			{
				return random;
			}
	
		}
		
		public void mousePressed( MouseEvent evt){}
		public void mouseReleased( MouseEvent evt) {}
		// this lets the user click on the enemy to make it disappear, so
		// the plant doesn't lose health.
		public void mouseClicked( MouseEvent evt) 
		{
			if(evt.getX() >= tih.getX() && evt.getX() <= tih.getX() + 100 && evt.getY() >= 640 && evt.getY() <= 740)
			{
				tih.setMovement(0);
				eh.setTime(getTimeInSec());
				tih.setX(1200);
			}
		}
		public void mouseEntered( MouseEvent evt) {}
		public void mouseExited( MouseEvent evt) {}
	
		
		// This class handler checks if the timer is running then increments
		// the seconds.
		class TimeHandler5 implements ActionListener
		{
			private int x;
			private int movement;
			public int getMovement()
			{
				return movement;
			}
			public void setMovement(int m)
			{
				movement = m;
			}
			public int getX()
			{
				return x;
			}
			public void setX(int tempX)
			{
				x = tempX;
			}
			public TimeHandler5()
			{
				x = 1200;
				movement = 0;
			}
			public void actionPerformed(ActionEvent evt) 
			{
				String command = evt.getActionCommand();
				if ( running )
				{
					tenthSec++;
					x+= movement;
				
				
					repaint( );
				
				}	
	
			}
		}

			// uses try-catch blocks to load all the images used for the game.
			public void getMyImage() 
			{
				// Create a try-catch block for loading the image
			
				try
				{
					bg1 = ImageIO.read(new File("sunny.jpeg"));
					bg2 = ImageIO.read(new File("cloudy.png"));
					bg3 = ImageIO.read(new File("hills.jpeg"));
					seed = ImageIO.read(new File("seed.png"));
					sprout = ImageIO.read(new File("sprout.png"));
					tree = ImageIO.read(new File("tree.png"));
					deadPlant = ImageIO.read(new File("deadPlant.png"));
					enemy = ImageIO.read(new File("enemy.png"));
					
				}
				catch(IOException e)
				{
					
					System.err.println("\n\n\nFile can't be found.\n\n\n");
					e.printStackTrace();
				}
		
			}

		}
		
		//This class shows the highest times survived on a JTextArea
		// which is divided up equally by a 4x3 grid. It shows the user
		// name, time survived and number.
		class ScoresPanel5 extends JPanel implements ActionListener
		{
			
			private CardLayout cardsList;// cardlayout
			private CardPanel5 mainPanel;//the home page
			private PlayerData5 data;
			private JButton homeButton, quitButton, refreshButton;
			private JTextArea highScoresArea;
			private String[] userNames;// the array that gets the high scores
			// from the getResult method.
			private double[] scores;
			public ScoresPanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
			{
				data = d;
				cardsList = c;
				mainPanel = m;
				
				setLayout(new BorderLayout(40,40));
				setBackground(Color.white);
				Font myFont = new Font("Serif", Font.BOLD, 45);
				
				JPanel leaderboardPanel = new JPanel();
				leaderboardPanel.setLayout(new BorderLayout(40,40) );
				leaderboardPanel.setBackground(Color.white);
				
				JLabel scoresTitle = new JLabel("Leaderboard");
				scoresTitle.setFont(myFont);
				leaderboardPanel.add(scoresTitle);
				add(leaderboardPanel, BorderLayout.NORTH);
				
				
				highScoresArea = new JTextArea("---------------------------------\n| # | Name                | Score |", 10, 20);
				highScoresArea.setFont(myFont);
				highScoresArea.setLineWrap(true);
				highScoresArea.setWrapStyleWord(true);
				highScoresArea.setOpaque(false);
				highScoresArea.setEditable(false);
				highScoresArea.setMargin(new Insets(10,10,10,10));
				add(highScoresArea, BorderLayout.CENTER);
				setHighScores();
				
								
				JPanel buttonsPanels = new JPanel();
				buttonsPanels.setLayout(new GridLayout(1,3,0,0));
				buttonsPanels.setBackground(Color.yellow);
				
				homeButton = new JButton("Back to Home");
				homeButton.addActionListener(this);
				quitButton = new JButton("Quit");
				quitButton.addActionListener(this);
				refreshButton = new JButton("Refresh");
				refreshButton.addActionListener(this);
				
			
				add(buttonsPanels, BorderLayout.SOUTH);
				buttonsPanels.add(homeButton);
				buttonsPanels.add(quitButton);
				buttonsPanels.add(refreshButton);
			
				
			}
			public void setHighScores()
			{
				userNames = data.getNames();
				scores = data.getScores();
				String text = "----------------------------------------\n| # | Name                | Score |";
				for(int i = 0; i < userNames.length; i++)
				{
					text += "\n" + "----------------------------------------";
					text += "\n" + " " + (i+1) + " " + userNames[i] + "      " + (int)(scores[i]/60) + " min : " + (int)(scores[i] % 60 + 0.5) + " sec";
				}
				text += "\n----------------------------------------\n";
				highScoresArea.setText(text);
			}
			
			public void actionPerformed(ActionEvent evt) 
			{
				
				String command = evt.getActionCommand();
			
				if(command.equals("Back to Home"))
				{
					cardsList.first(mainPanel);
				}
				
				else if(command.equals("Quit"))
				{
					System.exit(0);
				}
				else if(command.equals("Refresh") )
				{
					data.getMyHighScores();
					setHighScores();
				}
				
			}
			
		}
	// This class reads in the Scores.txt file and returns the values to
	// the main game class. This will also update any new high scores 
	// the player has made. It will record the name and their highest 
	// time.	
	class PlayerData5
	{
		private String name;
		private String [] userNames;// array which holds the scores and names
		private double [] scores;
		private Levels5 levelChoice;
		private int length;
	
		
		public PlayerData5()
		{
			name = "";
			levelChoice = new Levels5();
			
		}
		// This method gets the high scores froma txt file and the result
		// will be stored into an array. The array will be returned and 
		// then printed into the textField.
		public void getMyHighScores()
		{
			
			String fileName = "Scores.txt";
			Scanner inFile = null;
			try 
			{
				inFile = new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				System.err.println("\n\n\n" + fileName + " can't be found.\n\n\n");
				e.printStackTrace();
				System.exit(1);
			}
			int counter = 0;
			while(inFile.hasNext()) 
			{ 
				inFile.nextLine(); 
				counter++; 
				if(counter == 5)
					break;
			}
			inFile.close();
			length = counter;
			userNames = new String[length];
			scores = new double[length];
			// first last score
			try 
			{
				inFile = new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				System.err.println("\n\n\n" + fileName + " can't be found.\n\n\n");
				e.printStackTrace();
			}
			String temp = "";
			counter = 0;
			while(inFile.hasNext() && counter < 5)
			{
				temp = inFile.next();
				userNames[counter] = temp;
				double tempTime = inFile.nextDouble();
				scores[counter] = tempTime;
				counter++;
				
			}
			inFile.close();
		}
		
			
			public void setName(String f)
			{
				name = f;
				
			}
	
			public void saveHighScores( double score)
            {
                getMyHighScores();
            
                String [] tempNames = new String [length + 1];
                double [] tempScores = new double [length + 1];
                int l = -1;
                for(int i = 0; i < userNames.length; i++)
                {
                    if(score > scores[i])
                    {
                        l = i;
                        tempScores[l] = score;
                        tempNames[l] = name;
                        break;
                    }
                    else
                    {
                        tempScores[i] = scores[i];
                        tempNames[i] = userNames[i];
                    }
                }
                if(l != -1)
                {
                    for(int i = l + 1; i < 5; i++)
                    {
                        tempScores[i] = scores[i-1];
                        tempNames[i] = userNames[i-1];
                    }
                }
                scores = tempScores;
                userNames = tempNames;
                
                PrintWriter pr = null;
                String fileName = "Scores.txt";
                try
                {
                    pr = new PrintWriter(new File(fileName));
                }
                catch(IOException e)
                {
                    System.err.println("\n\n\n" + fileName + " can't be found.\n\n\n");
                    e.printStackTrace();
                }
                for(int i = 0; i < length; i++)
                {
                    pr.println(userNames[i] + " " + scores[i]);
                }
                pr.close();
            
            }
			// This just calls high scores and return the array
			public String[] getNames()
			{
				getMyHighScores();
				return userNames;
			}
			public double[] getScores()
			{
				
				return scores;
			}
			public void setLevel(String l)
			{
				levelChoice.set(l);
			}
			public Levels5 getLevel()
			{
				return levelChoice;
			}
			
		}

// This class only is used when the player loses the game. The player loses
// the game when 2 of the 3 health bars reaches 0. It shows a game over 
// screen and has 2 buttons. One is play again which resets the score
// and allows user to play again. The other is the leaderboard. Which
// allows the user to see all high scores and see if the user made it
// into the top 5 scores.
class GameOverPanel5 extends JPanel implements ActionListener
{
	private CardLayout cardsList;
	private CardPanel5 mainPanel;//object of the CardPanel 
	private PlayerData5 data;
	private Image gameOverImage;
	private String gameOver;
	private JButton scoreBoard, playAgain;
	
	public GameOverPanel5(PlayerData5 d, CardLayout c, CardPanel5 m)
	{
		data = d;
		cardsList = c;
		mainPanel = m;
		
		setLayout(null);
		setBackground(Color.yellow);
		Font myFont = new Font("Serif", Font.BOLD, 45);
	
		gameOverImage = null;
		gameOver = "GameOver.png";
		
		try
		{
			gameOverImage = ImageIO.read(new File("GameOver.png"));
		}
		catch(IOException e)
		{
				
			System.err.println("\n\n\n" + gameOver + " can't be found.\n\n\n");
			e.printStackTrace();
		}
		
		scoreBoard = new JButton("ScoreBoard");
		scoreBoard.addActionListener(this);
		playAgain = new JButton("Play Again");
		playAgain.addActionListener(this);
		add(scoreBoard);
		add(playAgain);
		
		scoreBoard.setBounds(300,550,150,70);
		playAgain.setBounds(500,550, 150 ,70);
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent ( g );
		g.drawImage(gameOverImage, 0,100,1000,450,this);
	}
	
	public void actionPerformed( ActionEvent evt)
	{
		String command = evt.getActionCommand();
		
		if(command.equals("ScoreBoard") )
		{
			data.getMyHighScores();
			cardsList.show(mainPanel, "5");
		}
		else if(command.equals("Play Again") )
		{
			cardsList.show(mainPanel, "2");
		}
	}
}
// end of class

		
	
		
		
		



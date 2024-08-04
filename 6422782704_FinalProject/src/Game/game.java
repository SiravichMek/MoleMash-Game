package Game;
import Component.Gameover;
import Component.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Component.RandomMole;
import Component.Regame;

public class game extends JPanel implements ActionListener,MouseMotionListener,MouseListener{
 
	public static JFrame frame = new JFrame("Mole Mash!!!");
		public static JPanel main_panel = new JPanel();
			private JPanel above_bar = new JPanel();
				protected static String time_str = ("30");
				protected static int time = Integer.parseInt(time_str);
				protected static JLabel l_time = new JLabel("Time: "+time_str);
				private JLabel l_free = new JLabel(" <---------------- Mole Mash!!! ----------------> ");	
				protected static String point_str = ("0");
				protected static int point = Integer.parseInt(point_str);
				protected static JLabel l_score=new JLabel("Score: "+point_str);
			private JPanel below_bar = new JPanel();
				protected JLabel health_bar= new JLabel("Life: ");	
			public static JButton retrybt = new JButton("Retry!!");
	public static boolean visible= false;	
	protected Color bg_color=new Color(0 ,153, 0);
	private Timer time_random=new Timer(2000,this);
	private Timer time_stopwatch = new Timer(1000,this);
	private Timer time_molegone = new Timer(3000,this);
	private int a;
	private int b;
	private boolean click;
	public static int i =0;	
	private Font myfont = 	new Font("Monospaced",Font.BOLD,20);
	private Font myfont2 = new Font("Monospaced",Font.BOLD,100);
	static JLabel [] notclick = new JLabel[6];
	public static int t;  
	public static ArrayList<Integer>index_list = new ArrayList<Integer>();
	private ArrayList<Integer>time_list = new ArrayList<Integer>();
	static int old_time;
 
public game(){
 		//call classes from Component package
 		new RandomMole();
 		
 		frame.setSize(1000, 800);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main_panel);
		
		main_panel.setLayout(new BorderLayout());
		main_panel.add(above_bar,BorderLayout.NORTH);
		main_panel.add(this,BorderLayout.CENTER);// panel of mole mash game
		main_panel.add(below_bar,BorderLayout.SOUTH);
		
		above_bar.setLayout(new FlowLayout());
		above_bar.add(l_time);
		above_bar.add(l_free);
		above_bar.add(l_score);
		above_bar.setBackground(new Color(51,51, 51));
		l_time.setForeground(new Color(255,102, 0));  l_time.setFont(myfont);
		l_free.setForeground(new Color(255,102, 0));  l_free.setFont(myfont);
		l_score.setForeground(new Color(255,102, 0));  l_score.setFont(myfont);
		//add heart
		below_bar.setLayout(new FlowLayout());
		below_bar.add(health_bar);
		below_bar.add(Image.heart_label[0]);
		below_bar.add(Image.heart_label[1]);
		below_bar.add(Image.heart_label[2]);
		below_bar.add(Image.heart_label[3]);
		below_bar.add(Image.heart_label[4]);
		below_bar.setBackground(new Color(51,51, 51));
		health_bar.setForeground(new Color(255,102, 0));
		health_bar.setFont(myfont);
		//set layout of class
		this.setLayout(null);
		//add missing text
		notclick[0]= new JLabel("!");notclick[0].setVisible(visible);
			notclick[0].setBounds(200+20,220-20,100, 67);notclick[0].setFont(myfont2);
			this.add(notclick[0]);
		notclick[1]= new JLabel("!");notclick[1].setVisible(visible);
				notclick[1].setBounds(450+20,220-20,100, 67);notclick[1].setFont(myfont2);
				this.add(notclick[1]);
		notclick[2]= new JLabel("!");notclick[2].setVisible(visible);
				notclick[2].setBounds(700+20,220-20,100, 67);notclick[2].setFont(myfont2);
				this.add(notclick[2]);			
		notclick[3]= new JLabel("!");notclick[3].setVisible(visible);
				notclick[3].setBounds(200+20,550-20,100, 67);notclick[3].setFont(myfont2);
				this.add(notclick[3]);			
		notclick[4]= new JLabel("!");notclick[4].setVisible(visible);
				notclick[4].setBounds(450+20,550-20,100, 67);notclick[4].setFont(myfont2);
				this.add(notclick[4]);			
		notclick[5]= new JLabel("!");notclick[5].setVisible(visible);
				notclick[5].setBounds(700+20,550-20,100, 67);notclick[5].setFont(myfont2);
				this.add(notclick[5]);
		//set retry button		
		retrybt.setBounds(frame.getWidth()/2-50,frame.getHeight()/2,100,50);//set location of retry button
				this.add(retrybt);
				retrybt.setVisible(visible);//invisible retry button
				retrybt.setForeground(Color.red);
				retrybt.setBackground(new Color(153,153,153));
		
		//insert mole image 
		Image.mole_bt[0].setBounds(200,220,100, 67);
				this.add(Image.mole_bt[0]);
				Image.mole_bt[0].setVisible(visible);
		Image.mole_bt[1].setBounds(450,220,100, 67);
				this.add(Image.mole_bt[1]);
				Image.mole_bt[1].setVisible(visible);
		Image.mole_bt[2].setBounds(700,220,100, 67);
				this.add(Image.mole_bt[2]);
				Image.mole_bt[2].setVisible(visible);
		Image.mole_bt[3].setBounds(200,550,100, 67);
				this.add(Image.mole_bt[3]);
				Image.mole_bt[3].setVisible(visible);
		Image.mole_bt[4].setBounds(450,550,100, 67);
				this.add(Image.mole_bt[4]);
				Image.mole_bt[4].setVisible(visible);
		Image.mole_bt[5].setBounds(700,550,100, 67);
				this.add(Image.mole_bt[5]);
				Image.mole_bt[5].setVisible(visible);
		
		//add listener
		retrybt.addActionListener(this);
		Image.mole_bt[0].addActionListener(this);
		Image.mole_bt[1].addActionListener(this);
		Image.mole_bt[2].addActionListener(this);
		Image.mole_bt[3].addActionListener(this);
		Image.mole_bt[4].addActionListener(this);
		Image.mole_bt[5].addActionListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
 }
 	//method for plus point
 	protected static void plusPoint() {
 		point++;
 		point_str = Integer.toString(point);
 		l_score.setText("Score: "+point_str);
 	}
 	
 	protected static void timeCount() {
 		time--;
 		time_str = Integer.toString(time);
 		l_time.setText("Time: "+time_str);
 	}
 	
 	protected static void life() {
 		if(!Image.heart_label[4-i].isVisible()) {
 				i++;
 			}
 	}
 	
 	protected  void startTime() {
 		time_random.start();
		time_stopwatch.start();
		time_molegone.start();
		if (time==0) {
			time_stopwatch.stop();
			time_random.stop();
			time_molegone.stop();
			Image.mole_bt[0].setVisible(false);
			Image.mole_bt[1].setVisible(false);
			Image.mole_bt[2].setVisible(false);
			Image.mole_bt[3].setVisible(false);
			Image.mole_bt[4].setVisible(false);
			Image.mole_bt[5].setVisible(false);
			retrybt.setVisible(true);
			bg_color=Color.black;}
 	}
 	
 	
 	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		startTime();
 		this.setBackground(bg_color);
 		//draw pole
 		g.setColor(new Color(102,51, 0));
 		g.fillOval(200, 250,100 , 50);
 		g.fillOval(450, 250,100 , 50);
 		g.fillOval(700, 250,100 , 50);
 		g.fillOval(200, 580,100 , 50);
 		g.fillOval(450, 580,100 , 50);
 		g.fillOval(700, 580,100 , 50);
 		//write "Your score: " that will be shown when game finished
 		g.setColor(new Color(0 ,153, 0));
 		g.setFont(new Font("Monospaced",Font.BOLD,50));
 		g.drawString("Your score: "+ point_str, frame.getWidth()/2-200, frame.getHeight()/2-40);
 		//draw Hammer
 		g.setColor(Color.orange);
 		if(click) {
 			g.fillRect(0+a, 0+b, 50, 30);
			g.setColor(Color.red);
			g.fillRect(0+a+20, 0+b-10, 10, 10);
			g.fillRect(0+a+20, 0+b+30, 10, 40);
			//show text miss when click miss
			g.setColor(Color.red);
			g.setFont(new Font("Monospaced",Font.BOLD,20));
			g.drawString("Miss!!", 0+a-20, 0+b-20);
		}
		else {
			g.fillRect(0+a, 0+b, 50, 30);
			g.setColor(Color.red);
			g.fillRect(0+a+20, 0+b-10, 10, 10);
			g.fillRect(0+a+20, 0+b+30, 10, 40);
		}
 	
 	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==retrybt) {
			
			main_panel.removeAll();
			
			point_str="0"; time_str="30"; point=0; time=30;
			l_score=new JLabel("Score: "+point_str);
			l_time=new JLabel("Time: "+time_str);
			i=0;t=0;
			bg_color= new Color(0 ,153, 0);
			
			new Regame();
			
		}
		if(e.getSource()==Image.mole_bt[0]) {
			Image.mole_bt[0].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==Image.mole_bt[1]) {
			Image.mole_bt[1].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==Image.mole_bt[2]) {
			Image.mole_bt[2].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==Image.mole_bt[3]) {
			Image.mole_bt[3].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==Image.mole_bt[4]) {
			Image.mole_bt[4].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==Image.mole_bt[5]) {
			Image.mole_bt[5].setVisible(false);
			plusPoint();
		}
		if(e.getSource()==time_random) {
			
			t++;
			RandomMole.RandomInt();
			index_list.add(RandomMole.index);
			RandomMole.Select();
			RandomMole.mole_bt[RandomMole.index].setVisible(true);
			time_list.add(time);
			
			if(t<2) {
				old_time=time_list.get(0);
				RandomMole.index_old=index_list.get(0);
				if(time==old_time-3) {
					if(RandomMole.mole_bt[RandomMole.index_old].isVisible()) {
						RandomMole.mole_bt[RandomMole.index_old].setVisible(false);
						Image.heart_label[4-i].setVisible(false);
						notclick[RandomMole.index_old].setVisible(true);
						life();
						if(!Image.heart_label[0].isVisible() && !Image.heart_label[1].isVisible()&&!Image.heart_label[2].isVisible()&&!Image.heart_label[3].isVisible()&&!Image.heart_label[4].isVisible()) {
							time_stopwatch.stop();
							time_random.stop();
							time_molegone.stop();
							new Gameover();
						}
					}
				}
			}
			if(t>=2) {
				old_time=time_list.get(time_list.size()-2);
				RandomMole.index_old=index_list.get(index_list.size()-2);
				if(RandomMole.mole_bt[RandomMole.index_old].isVisible()) {
					if(time==old_time-3) {
						RandomMole.mole_bt[RandomMole.index_old].setVisible(false);
						Image.heart_label[4-i].setVisible(false);
						notclick[RandomMole.index_old].setVisible(true);
						life();
						if(!Image.heart_label[0].isVisible() && !Image.heart_label[1].isVisible()&&!Image.heart_label[2].isVisible()&&!Image.heart_label[3].isVisible()&&!Image.heart_label[4].isVisible()) {
							time_stopwatch.stop();
							time_random.stop();
							time_molegone.stop();
							new Gameover();
						}
					}
				}
			}
		}	
		
			
		if(e.getSource()==time_stopwatch) {
			timeCount();
			if(notclick[0].isVisible()) {
				notclick[0].setVisible(false);
			}
			if(notclick[1].isVisible()) {
				notclick[1].setVisible(false);
			}
			if(notclick[2].isVisible()) {
				notclick[2].setVisible(false);
			}
			if(notclick[3].isVisible()) {
				notclick[3].setVisible(false);
			}
			if(notclick[4].isVisible()) {
				notclick[4].setVisible(false);
			}
			if(notclick[5].isVisible()) {
				notclick[5].setVisible(false);
			}
			
			if (time==0) {
				
				time_stopwatch.stop();
				time_random.stop();
				Image.mole_bt[0].setVisible(false);
				Image.mole_bt[1].setVisible(false);
				Image.mole_bt[2].setVisible(false);
				Image.mole_bt[3].setVisible(false);
				Image.mole_bt[4].setVisible(false);
				Image.mole_bt[5].setVisible(false);
				retrybt.setVisible(true);
				setBackground(Color.black);
				
			}
			if(RandomMole.mole_bt[RandomMole.index_old].isVisible()) {
				if(time==old_time-3) {
					RandomMole.mole_bt[RandomMole.index_old].setVisible(false);
					Image.heart_label[4-i].setVisible(false);
					notclick[RandomMole.index_old].setVisible(true);
					life();
					if(!Image.heart_label[0].isVisible() && !Image.heart_label[1].isVisible()&&!Image.heart_label[2].isVisible()&&!Image.heart_label[3].isVisible()&&!Image.heart_label[4].isVisible()) {
						time_stopwatch.stop();
						time_random.stop();
						time_molegone.stop();
						new Gameover();
					}
				}
			}
		}
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		click=false;
		a= e.getX();
		b=e.getY();
		repaint();
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		click=true;
		a= e.getX();
		b=e.getY();
		repaint();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		click=false;
		Image.heart_label[4-i].setVisible(false);
		repaint();
		life();
		if(!Image.heart_label[0].isVisible() && !Image.heart_label[1].isVisible()&&!Image.heart_label[2].isVisible()&&!Image.heart_label[3].isVisible()&&!Image.heart_label[4].isVisible()) {
			time_stopwatch.stop();
			time_random.stop();
			new Gameover();
 		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
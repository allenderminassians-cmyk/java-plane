package photo;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ph  extends JComponent{

	private JFrame frame;
	private int x = 100, y=100, x1=5, y1=550, red=0, blue=0, green=0;
	Timer tm;
	Random rd = new Random();
	
	int seconds = 0;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ph window = new ph();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ph() {
		initialize();
	}
	
	protected void paintComponent(Graphics g)
	
	{
		super.paintComponent(g);
		Color col = new Color(red,blue,green);
		g.setColor(col);
		g.fillOval(x, y, 180, 180);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		lblNewLabel= new JLabel("0");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LAB D-11\\Downloads\\plane-removebg-preview.png"));
		lblNewLabel.setBounds(0, 194, 284, 113);
		frame.getContentPane().add(lblNewLabel);
		
		tm = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				x1+=5;y1-=5;
				x+=10; y+=10;
				int ballSize = 180;
				if(x < 0 || x + ballSize >getWidth()) {
					x = 1; y = 1;
				}
				if(y < 0|| y + ballSize > getHeight()) {
					y = 1; x = 1;
				}
				red = rd.nextInt(0,255);
				blue = rd.nextInt(0,255);
				green = rd.nextInt(0,255);
				seconds +=2;
				
				lblNewLabel.setLocation(x1,y1);
				repaint();
				
			}
		});
		
		tm.start();
	}
}

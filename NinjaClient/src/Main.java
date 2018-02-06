import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
	
	
	ObjectInputStream in=null;
	ObjectOutputStream out=null;
	MainPanel mainPanel;
	RoginPanel roginPanel;
	ArrayList<User> userList;
	
	Image img_icon;
	int icon_x,icon_y,icon_w,icon_h;
	Image img_bg;
	
	int width,height;
	
	
	
	public Main() {
		
		File path=new File("data");
		if(!path.isDirectory())path.mkdir();
		
		//저장될 경로와 파일명 합치기
		
		setTitle("Ninja Game");
		setSize(600, 800);
		setLocation(300, 100);
		//setLayout(null);
		
		mainPanel=new MainPanel();
		mainPanel.setLayout(null);
		
		roginPanel=new RoginPanel();
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		img_icon=toolkit.getImage("images/ninja_red.png");
		img_icon=img_icon.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		icon_w=64;
		icon_h=64;
		
		userList= new ArrayList<>();
		
		mainPanel.add(roginPanel);
		add(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();

	}
	
	class MainPanel extends JPanel{
		
		
		
		@Override
		protected void paintComponent(Graphics g) {
			if(width==0||height==0) {
				width=getWidth();
				height=getHeight();
				
				
			}
			
			g.drawImage(img_icon, width/2-icon_w, 150,this);
		}
		
	}
	
	class RoginPanel extends JPanel{
		
		JLabel id,psw;
		JTextField tf_id;
		JPasswordField tf_psw;
		JButton signIn,login;
		
		
		public RoginPanel() {
			setLayout(new GridLayout(5, 0));
			setBounds(170,300,250,200);
			//setBackground(Color.YELLOW);
			setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			
			id=new JLabel("   ID ");
			//id.setBounds(100, 50, 40, 20);
			id.setFont(id.getFont().deriveFont(15.0F));
			add(id);
			
			JPanel tmp=new JPanel();
			
			tf_id=new JTextField(20);
			tmp.add(tf_id);
			add(tmp);
			
			psw=new JLabel("   PASSWORD ");
			psw.setFont(psw.getFont().deriveFont(15.0F));
			add(psw);
			
			tmp=new JPanel();
			tf_psw=new JPasswordField(20);
			tmp.add(tf_psw);
			add(tmp);
			
			
			tmp=new JPanel();
			signIn=new JButton("Sign in");
			signIn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new SigninFrame(userList);
					
				}
			});
			tmp.add(signIn);
			JLabel blank=new JLabel("     ");
			tmp.add(blank);
			login=new JButton("Log in");
			tmp.add(login);
			add(tmp);
			//tmp.setBounds(arg0, arg1, arg2, arg3);
			
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
}

class User{
	int userNum;
	String id;
	String psw;
	
	int playedTimes;
	int won;
	int lost;
	double winRate;
	
	int Ranking;
	
	public User(String id,String psw) {
		this.id=id;
		this.psw=psw;
		
	}
	
	public String getID() {
		
		return id;
	}
	
}


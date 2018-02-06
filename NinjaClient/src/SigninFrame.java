import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





public class SigninFrame extends JFrame {
	
	SigninPanel signinPanel;
	ArrayList<User> userList;
	
	
	public SigninFrame(ArrayList<User> userList) {
		setTitle("Sign In");
		setSize(400, 300);
		setLocation(400, 300);
		setLayout(null);
		this.userList=userList;
		
		
		signinPanel=new SigninPanel();
		
		
		
		
		add(signinPanel);
		setVisible(true);
	}
	
	class SigninPanel extends JPanel{
		
		JLabel id,psw;
		JTextField tf_id;
		JPasswordField tf_psw;
		JButton back,signin;
		
		public SigninPanel() {
			setLayout(new GridLayout(5, 0));
			setBounds(70,35,250,200);
			setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			
			id=new JLabel("   ID ");
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
			back=new JButton("Reset");
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tf_id.setText("");
					tf_psw.setText("");
					
					
				}
			});
			tmp.add(back);
			JLabel blank=new JLabel("     ");
			tmp.add(blank);
			signin=new JButton("Sign in");
			signin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(tf_id.getText().length()==0||tf_psw.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "입력칸이 빈칸입니다.");
						return;
					}
					
					String id=tf_id.getText();
					String psw=tf_psw.getText();
					if(userList.size()==0) {
						
						User user=new User(id,psw);
						userList.add(user);
						JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.");
						tf_id.setText("");
						tf_psw.setText("");
						return;
	
					}else {
						for(int i=0;i<userList.size();i++) {
							if(id.equals(userList.get(i).getID())) {
								JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
								tf_id.setText("");
								return;
							}
						}
						JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.");
						tf_id.setText("");
						tf_psw.setText("");
						return;
						
					}
					
				}
			});
			
			tmp.add(signin);
			add(tmp);
			
		}
		
		
		
	}

}

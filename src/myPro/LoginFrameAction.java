package myPro;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


@SuppressWarnings("all")
class LoginFrame extends JFrame {
	
	ImageIcon backimage = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\back.jpg");
	public static JTextField t1;
	public static JPasswordField t2;

	public LoginFrame() {
		
	JPanel lp = new JPanel() {
		
		public void paintComponent(Graphics g) {
			
		Dimension d = getSize();
		g.drawImage(backimage.getImage(), 0, 0, d.width, d.height, null);
	    setOpaque(false);
	    super.paintComponent(g);
	    
	   }
		
	  };
	  
	Font lf = new Font("MS Mincho", Font.BOLD, 20);
	
    lp.setLayout(null);
	
	JLabel l1 = new JLabel("映画予約システム");
	l1.setBounds(160, 30, 200, 30);
    l1.setFont(lf);
    l1.setForeground(Color.black);
	JLabel l2 = new JLabel("アイディー");
	l2.setBounds(155, 85, 70, 50);
	JLabel l3 = new JLabel("パスワード");
	l3.setBounds(155, 135, 70, 50);

	
	t1 = new JTextField(10);
	t1.setBounds(230, 95, 100, 30);
	t2 = new JPasswordField(10);
	t2.setBounds(230, 145, 100, 30);
	t2.addActionListener(new LoginListener());
	
	JButton logbutton = new JButton("ログイン");
	logbutton.setBounds(190, 210, 100, 40);
	logbutton.addActionListener(new LoginListener());

	add(lp);
	lp.add(l1); lp.add(l2); lp.add(l3);
	lp.add(t1); lp.add(t2);
	lp.add(logbutton);
	
	t1.setText("kanehara");
	t2.setText("0319");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	}
	
	}
	
@SuppressWarnings("all")	
class LoginListener extends JFrame implements ActionListener {
	
	public void actionPerformed (ActionEvent e) {
		
		String name = LoginFrame.t1.getText();
		MainFrame.name = LoginFrame.t1.getText();
			
		if (LoginFrame.t1.getText().equals("kanehara") && new String (LoginFrame.t2.getPassword()).equals("0319")) 
			
		{
	         JOptionPane.showMessageDialog(null, "     "+name+" 様,  ようこそ。","お知らせ",JOptionPane.INFORMATION_MESSAGE);
			 LoginFrameAction.lf.dispose();
			 MainFrame mf = new MainFrame();
			 
			 } 
			
		else
			
		{
	         JOptionPane.showMessageDialog(null, "      ログインに失敗しました。"	,"お知らせ", JOptionPane.WARNING_MESSAGE);
		}
	
		}
	
		}


@SuppressWarnings("all")
public class LoginFrameAction {
	
	public static JFrame lf;

	public static void main(String[] args) {

		lf = new LoginFrame();
		lf.setSize(500,330);
	    lf.setResizable(false);
		lf.setTitle("ログイン");
		lf.setLocationRelativeTo(null);
		lf.setVisible(true);

		
	}

}
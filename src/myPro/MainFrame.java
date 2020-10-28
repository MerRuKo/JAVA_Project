package myPro;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("all")
class MainFrame extends JFrame {
	
	public static JButton cb, rb, sb;
	public static JTextField sf;
	public static String name;
	public static JComboBox dc,tc;
	public static JLabel dl3,tl3,sl3,pol;
	public static JPanel p3;
	public static ImageIcon loveletter = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\loveletter.jpg");
	public static ImageIcon joze = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\joze.jpg");
	public static ImageIcon gokuhaku = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\gokuhaku.jpg");
	public static ImageIcon imaaini = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\imaaini.jpg");
	public static ImageIcon soredemo = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\soredemo.jpg");
	
	public MainFrame() {
		
		
	Date d = new Date();
    SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
    ImageIcon infoimage = new ImageIcon("C:\\workspace\\JAVA_Project\\src\\myPro\\info.jpg");
    
	setSize(1000,700);
    setResizable(false);
	setTitle("映画予約システム");	
	
	
	JPanel p1 = new JPanel();
    JLabel sl = new JLabel(infoimage,JLabel.CENTER);
	JLabel nl = new JLabel("名前 : "+name);
	JLabel dl = new JLabel("今日 : "+a.format(d));
	add(p1); p1.add(sl); p1.add(nl); p1.add(dl);

	JPanel p2 = new JPanel();
	JLabel dl2 = new JLabel("日時");
	dc = new JComboBox();
	dc.setModel(new DefaultComboBoxModel(new String[] {"2017/03/01 月","2017/03/02 火","2017/03/03 水","2017/03/04 木","2017/03/05 金"} ));
	JLabel tl2 = new JLabel("題名");
	tc = new JComboBox();
	tc.setModel(new DefaultComboBoxModel(new String[] {" ラブレター"," ジョゼと虎と魚たち"," 告白"," 今, 会いに行きます"," それでも僕はやってない"} ));
	JLabel sl2 = new JLabel("座席");
    sf = new JTextField(10);
    sf.setEditable(false);
	cb = new JButton("チェック");
	cb.addActionListener(new CheckListener());
	rb = new JButton("予約");
	rb.addActionListener(new ReserveListener());
	rb.setEnabled(false);
	sb = new JButton("やり直す");
	sb.addActionListener(new ResetListener());
	sb.setEnabled(false);
	add(p2); p2.add(dl2); p2.add(dc); p2.add(tl2); p2.add(tc); p2.add(sl2); p2.add(sf); p2.add(cb); p2.add(rb); p2.add(sb);

	
	p3 = new JPanel();
	
	dl3 = new JLabel("");
	tl3 = new JLabel("");
	sl3 = new JLabel("");
	add(p3); p3.add(dl3); p3.add(tl3); p3.add(sl3);
	
	
	TitledBorder info;
	info = BorderFactory.createTitledBorder("  情報　  ");
    info.setTitleJustification(TitledBorder.CENTER);
    p1.setBorder(info);
	p1.setLayout(null);
	p1.setSize(400,250);
	p1.setLocation(15,10);
	sl.setBounds(115,30,161,148);
	nl.setBounds(145,175,100,50);
	dl.setBounds(146,200,100,50);
	
	TitledBorder check;
	check = BorderFactory.createTitledBorder("  予約   ");
    Font lf = new Font("MS Mincho", Font.PLAIN, 20);   
    p2.setBorder(check);
	p2.setLayout(null);
	p2.setSize(400,390);
	p2.setLocation(15,270);
	dl2.setBounds(90,50,50,50); dl2.setFont(lf);
	dc.setBounds(150,50,150,50);
	tl2.setBounds(90,130,50,50); tl2.setFont(lf);
	tc.setBounds(150,130,200,50);
	sl2.setBounds(90,210,50,50); sl2.setFont(lf);
	sf.setBounds(150,210,100,50);
	cb.setBounds(40,310,100,50);
	rb.setBounds(150,310,100,50);
	sb.setBounds(260,310,100,50);
	
	TitledBorder ticket;
	Border redline;
    redline = BorderFactory.createLineBorder(Color.red);
	ticket = BorderFactory.createTitledBorder(redline,"           チケット           ");
	ticket.setTitleJustification(TitledBorder.CENTER);
    p3.setBorder(ticket);
	p3.setLayout(null);
	p3.setSize(525,650);
	p3.setLocation(450,10);
	dl3.setBounds(180,470,200,50);
	tl3.setBounds(180,520,350,50);
	sl3.setBounds(210,570,150,50);

    setLayout(null);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);

	}
	
	public static void getting(String a, String b, String c) {
		
	Font lf = new Font(null, Font.ITALIC, 20);

	
	dl3.setFont(lf);
	tl3.setFont(lf);
	sl3.setFont(lf);
	
	if (b.equals(" ラブレター")) {
		pol = new JLabel(loveletter);
		p3.add(pol);
	    pol.setSize(300,400);
	    pol.setLocation(120,50); }
	else if (b.equals(" ジョゼと虎と魚たち")) {
	       pol = new JLabel(joze);
	       p3.add(pol);
           pol.setSize(300,400);
           pol.setLocation(120,50); }
	else if (b.equals(" 告白")) {
		   pol = new JLabel(gokuhaku);
		   p3.add(pol);
	       pol.setSize(300,400);
	       pol.setLocation(120,50);}
	else if (b.equals(" 今, 会いに行きます")) {
		   pol = new JLabel(imaaini);
		   p3.add(pol);
	       pol.setSize(300,400);
	       pol.setLocation(120,50);}
	else if (b.equals(" それでも僕はやってない")) {
		   pol = new JLabel(soredemo);
		   p3.add(pol);
	       pol.setSize(300,400);
	       pol.setLocation(120,50);}
	
	
	dl3.setText("日時 : "+a);
	tl3.setText("題名 :"+b);
	sl3.setText("座席 :"+c);
		
	}
	
}



class CheckListener implements ActionListener {
	
	public static JFrame sf;

	public void actionPerformed (ActionEvent e) {
		
		sf = new SeatFrame();
	
}

}


@SuppressWarnings("all")
class ReserveListener implements ActionListener {

	public void actionPerformed (ActionEvent e) {
		
	    Font lf = new Font("MS Mincho", Font.PLAIN, 18); 
	    
	    String date = MainFrame.dc.getSelectedItem().toString();
	    String title = MainFrame.tc.getSelectedItem().toString();
	    String seat = MainFrame.sf.getText();
	    
		MainFrame.getting(date, title, seat);
		MainFrame.dc.setEnabled(false);
		MainFrame.tc.setEnabled(false);
		MainFrame.cb.setEnabled(false);
		MainFrame.rb.setEnabled(false);
		MainFrame.sb.setEnabled(true);
	
}

}


class ResetListener implements ActionListener {

	public void actionPerformed (ActionEvent e) {

		MainFrame.p3.remove(MainFrame.pol);
		MainFrame.p3.repaint();
		MainFrame.dl3.setText("");
		MainFrame.tl3.setText("");
		MainFrame.sl3.setText("");
		
		MainFrame.dc.setEnabled(true);
		MainFrame.tc.setEnabled(true);
		MainFrame.cb.setEnabled(true);
		MainFrame.rb.setEnabled(true);
		MainFrame.sb.setEnabled(false);
	
}

}


class SeatListener implements ActionListener {

	public void actionPerformed (ActionEvent e) {
		
	    Font lf = new Font("MS Mincho", Font.PLAIN, 18); 
		
		JButton b = (JButton)e.getSource();
		String s = b.getText();
		
		MainFrame.rb.setEnabled(true);
		MainFrame.sf.setText(" "+s);
		MainFrame.sf.setFont(lf);
		
		JOptionPane.showMessageDialog(null, "     "+s+"  座席で予約しました。","お知らせ",JOptionPane.INFORMATION_MESSAGE);
		CheckListener.sf.dispose();
	
}

}

@SuppressWarnings("all")
class SeatFrame extends JFrame {
	
	public JButton sa1,sa2,sa3,sa4,sa5,sa6,sa7,sa8,sa9,sa10,
	               sb1,sb2,sb3,sb4,sb5,sb6,sb7,sb8,sb9,sb10,
	               sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10,
	               sd1,sd2,sd3,sd4,sd5,sd6,sd7,sd8,sd9,sd10,scb;
	
	public SeatFrame() {
		
	setSize(610,400);
    setResizable(false);
	setTitle("座席表");
	
	JPanel sep = new JPanel();
	JPanel sep2 = new JPanel();
	JPanel scbp = new JPanel();
	
	sa1 = new JButton("A1");sa2 = new JButton("A2");sa3 = new JButton("A3");sa4 = new JButton("A4");sa5 = new JButton("A5");sa6 = new JButton("A6");sa7 = new JButton("A7");sa8 = new JButton("A8");sa9 = new JButton("A9");sa10 = new JButton("A10");
    sb1 = new JButton("B1");sb2 = new JButton("B2");sb3 = new JButton("B3");sb4 = new JButton("B4");sb5 = new JButton("B5");sb6 = new JButton("B6");sb7 = new JButton("B7");sb8 = new JButton("B8");sb9 = new JButton("B9");sb10 = new JButton("B10");
    sc1 = new JButton("C1");sc2 = new JButton("C2");sc3 = new JButton("C3");sc4 = new JButton("C4");sc5 = new JButton("C5");sc6 = new JButton("C6");sc7 = new JButton("C7");sc8 = new JButton("C8");sc9 = new JButton("C9");sc10 = new JButton("C10");
    sd1 = new JButton("D1");sd2 = new JButton("D2");sd3 = new JButton("D3");sd4 = new JButton("D4");sd5 = new JButton("D5");sd6 = new JButton("D6");sd7 = new JButton("D7");sd8 = new JButton("D8");sd9 = new JButton("D9");sd10 = new JButton("D10");
    scb = new JButton("スクリーン");
    
    sa1.addActionListener(new SeatListener());sa2.addActionListener(new SeatListener());sa3.addActionListener(new SeatListener());sa4.addActionListener(new SeatListener());sa5.addActionListener(new SeatListener());sa6.addActionListener(new SeatListener());sa7.addActionListener(new SeatListener());sa8.addActionListener(new SeatListener());sa9.addActionListener(new SeatListener());sa10.addActionListener(new SeatListener());
    sb1.addActionListener(new SeatListener());sb2.addActionListener(new SeatListener());sb3.addActionListener(new SeatListener());sb4.addActionListener(new SeatListener());sb5.addActionListener(new SeatListener());sb6.addActionListener(new SeatListener());sb7.addActionListener(new SeatListener());sb8.addActionListener(new SeatListener());sb9.addActionListener(new SeatListener());sb10.addActionListener(new SeatListener());
    sc1.addActionListener(new SeatListener());sc2.addActionListener(new SeatListener());sc3.addActionListener(new SeatListener());sc4.addActionListener(new SeatListener());sc5.addActionListener(new SeatListener());sc6.addActionListener(new SeatListener());sc7.addActionListener(new SeatListener());sc8.addActionListener(new SeatListener());sc9.addActionListener(new SeatListener());sc10.addActionListener(new SeatListener());
    sd1.addActionListener(new SeatListener());sd2.addActionListener(new SeatListener());sd3.addActionListener(new SeatListener());sd4.addActionListener(new SeatListener());sd5.addActionListener(new SeatListener());sd6.addActionListener(new SeatListener());sd7.addActionListener(new SeatListener());sd8.addActionListener(new SeatListener());sd9.addActionListener(new SeatListener());sd10.addActionListener(new SeatListener());
    
    add(sep); add(sep2); add(scbp);
    sep2.add(sa1);sep2.add(sa2);sep2.add(sa3);sep2.add(sa4);sep2.add(sa5);sep.add(sa6);sep.add(sa7);sep.add(sa8);sep.add(sa9);sep.add(sa10);
    sep2.add(sb1);sep2.add(sb2);sep2.add(sb3);sep2.add(sb4);sep2.add(sb5);sep.add(sb6);sep.add(sb7);sep.add(sb8);sep.add(sb9);sep.add(sb10);
    sep2.add(sc1);sep2.add(sc2);sep2.add(sc3);sep2.add(sc4);sep2.add(sc5);sep.add(sc6);sep.add(sc7);sep.add(sc8);sep.add(sc9);sep.add(sc10);
    sep2.add(sd1);sep2.add(sd2);sep2.add(sd3);sep2.add(sd4);sep2.add(sd5);sep.add(sd6);sep.add(sd7);sep.add(sd8);sep.add(sd9);sep.add(sd10);
    scbp.add(scb);
    
    
	sep2.setSize(280,300);
	sep2.setLocation(12,60);
	sep2.setLayout(new GridLayout(4,5));
	
	sep.setSize(280,300);
	sep.setLocation(310,60);
	sep.setLayout(new GridLayout(4,5));
	
    scb.setEnabled(false);
    scbp.setLocation(12,10);
    scbp.setSize(580,50);
	
	setLayout(null);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);


	}
	
}
package OtherFunction;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DB.ATMDataBase;
import Jiemian.MainFrame;

@SuppressWarnings("serial")
public class QueryMoney extends JFrame implements ActionListener{
	private JLabel userName;
	private JLabel userNameContent;
	private JLabel ID;
	private JLabel IDContent;
	private JLabel money;
	private JLabel Moneynumber;
	private JButton btnReturn;
	
	private String name;
	private String allContent;
	
	public QueryMoney(String name){
		this.name = name;
        this.setTitle("”‡∂Ó≤È—Ø");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, 400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        ATMDataBase db = new ATMDataBase();
        allContent = db.Find(this.name);
        init();
	}

	public void init() {
		// TODO Auto-generated method stub
		Container con = this.getContentPane();
		userName = new JLabel("”√ªß√˚:");
		userName.setBounds(30, 80, 100, 20);
		userNameContent = new JLabel("’≈œÕ¡¡");
		userNameContent.setBounds(190, 80, 100, 20);
		ID = new JLabel("ø®∫≈:");
		ID.setBounds(30, 120, 100, 20);
		IDContent = new JLabel("034945823043854");
		IDContent.setBounds(190, 120, 100, 20);
		money = new JLabel("”‡∂Ó");
		money.setBounds(30, 160, 100, 20);
		Moneynumber = new JLabel("10000");
		Moneynumber.setBounds(190, 160, 100, 20);
		btnReturn = new JButton("∑µªÿ");
		btnReturn.setBounds(30,200,100,20);
		con.add(userName);
		con.add(userNameContent);
		con.add(ID);
		con.add(IDContent);
		con.add(money);
		con.add(Moneynumber);
		con.add(btnReturn);
		btnReturn.addActionListener(this);
		userNameContent.setText(allContent.split(",")[0]);
		IDContent.setText(allContent.split(",")[1]);
		Moneynumber.setText(allContent.split(",")[2]);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnReturn){
			this.dispose();
			new MainFrame(name);
		}
	}
}

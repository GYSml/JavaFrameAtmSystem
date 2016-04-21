package OtherFunction;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DB.ATMDataBase;
import Jiemian.MainFrame;
import Jiemian.TestFrame;

@SuppressWarnings("serial")
public class GetMoney extends JFrame implements ActionListener{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	
	private JButton exit;
	private JButton back;
	
	private String name;
	public GetMoney(String name) {
		this.name = name;
        this.setTitle("取款界面");
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, 400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
	}
	private void init() {
		// TODO Auto-generated method stub
		Container con = this.getContentPane();
		btn1 = new JButton("100");
		btn1.setBounds(30, 80, 100, 20);
		btn2 = new JButton("200");
		btn2.setBounds(30, 120, 100, 20);	
		btn3 = new JButton("500");
		btn3.setBounds(190, 80, 100, 20);
		btn4 = new JButton("1000");
		btn4.setBounds(190, 120, 100, 20);
		btn5 = new JButton("5000");
		btn5.setBounds(190, 160, 100, 20);
		btn6 = new JButton("其他金额");
		btn6.setBounds(30, 160, 100, 20);
		
		exit = new JButton("退出");
		exit.setBounds(30, 200, 100, 20);
		back = new JButton("返回");
		back.setBounds(190, 200, 100, 20);
		
		con.add(btn1);
		con.add(btn2);
		con.add(btn3);
		con.add(btn4);
		con.add(btn5);
		con.add(btn6);
		con.add(back);
		con.add(exit);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		back.addActionListener(this);
		exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			String content = btn1.getText();
			CalMoney(content);
		}else if(e.getSource()==btn2){
			String content = btn2.getText();
			CalMoney(content);
		}else if(e.getSource()==btn3){
			String content = btn3.getText();
			CalMoney(content);
		}else if(e.getSource()==btn4){
			String content = btn4.getText();
			CalMoney(content);
		}else if(e.getSource()==btn5){
			String content = btn5.getText();
			CalMoney(content);
		}else if(e.getSource()==btn6){
			JOptionPane.showMessageDialog(null, "暂不开放......","error", JOptionPane.WARNING_MESSAGE);
		}else if(e.getSource()==back){
			this.dispose();
			new MainFrame(name);
		}else if(e.getSource()==exit){
			this.dispose();
			new TestFrame();
		}
	}
	public void CalMoney(String content)
	{
		ATMDataBase db = new ATMDataBase();
		String value = db.Find(name);
		double  sum = Double.parseDouble(value.split(",")[2])-Double.parseDouble(content);
		if(sum>=0){
			db.UpdateMoney(name, sum);
			JOptionPane.showMessageDialog(null, "正在取款，请稍等.....","error", JOptionPane.WARNING_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "余额不足","error", JOptionPane.WARNING_MESSAGE);
		}
	}
}

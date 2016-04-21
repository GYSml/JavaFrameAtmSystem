package Jiemian;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import OtherFunction.GetMoney;
import OtherFunction.QueryMoney;
import OtherFunction.TransAccount;
import OtherFunction.UpdatePassWord;
import OtherFunction.increMoney;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	
	private JLabel hintMessage;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private String name;
	
	public MainFrame(String name){
		this.name = name;
		System.out.println(this.name);
        this.setTitle("Main");
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, 400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
	}
	
	private void init() {
		Container con = this.getContentPane();
		hintMessage = new JLabel("请选择交易");
		hintMessage.setBounds(130, 10, 100, 20);
		
		btn1 = new JButton("查询余额");
		btn1.setBounds(30, 80, 100, 20);
		btn2 = new JButton("转账");
		btn2.setBounds(30, 120, 100, 20);	
		btn3 = new JButton("取款");
		btn3.setBounds(190, 80, 100, 20);
		btn4 = new JButton("修改密码");
		btn4.setBounds(190, 120, 100, 20);
		btn5 = new JButton("取消");
		btn5.setBounds(190, 160, 100, 20);
		btn6 = new JButton("存款");
		btn6.setBounds(30, 160, 100, 20);
		con.add(btn1);
		con.add(btn2);
		con.add(btn3);
		con.add(btn4);
		con.add(btn5);
		con.add(btn6);
		con.add(hintMessage);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1){
			//查询余额
			this.dispose();
			new QueryMoney(name);
		}else if(e.getSource()==btn2){
			//转账
			this.dispose();
			new TransAccount(name);
		}else if(e.getSource()==btn3){
			//取款
			this.dispose();
			new GetMoney(name);
		}else if(e.getSource()==btn4){
			//修改密码
			this.dispose();
			new UpdatePassWord(name);
			System.out.println(name);
		}else if(e.getSource()==btn5){
			//取消功能
			this.dispose();
			new TestFrame();
		}else if(e.getSource()==btn6){
			//存款功能
			this.dispose();
			new increMoney(name);
		}
	}
	
}

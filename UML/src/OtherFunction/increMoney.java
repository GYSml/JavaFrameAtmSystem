package OtherFunction;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DB.ATMDataBase;
import Jiemian.MainFrame;

public class increMoney extends JFrame implements ActionListener{
	private JLabel hintMessage;
	private JLabel dispMoney;
	private JButton confirm;
	private JButton concel;
	private String name;
	public increMoney(String name){
		this.name = name;
        this.setTitle("密码修改");
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
		hintMessage = new JLabel("正在扫描，请稍候.........");
		dispMoney = new JLabel("0");
		confirm = new JButton("确认");
		concel = new JButton("取消");
		hintMessage.setBounds(30, 60, 180, 20);
		dispMoney.setBounds(30, 100, 100, 20);
		confirm.setBounds(30, 140, 100, 20);
		concel.setBounds(30, 180, 100, 20);
		Container con = this.getContentPane();
		con.add(hintMessage);
		con.add(dispMoney);
		con.add(confirm);
		con.add(concel);
		confirm.addActionListener(this);
		concel.addActionListener(this);
		int a = (int)(Math.random()*1000)/100*1000;
		dispMoney.setText(a+"");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==confirm){
			CalMoney(dispMoney.getText());
			this.dispose();
			new MainFrame(name);
		}else if(e.getSource()==concel){
			this.dispose();
			new MainFrame(name);
		}
	}
	public void CalMoney(String content)
	{
		ATMDataBase db = new ATMDataBase();
		String value = db.Find(this.name);
		double sum = Double.parseDouble(value.split(",")[2])+Double.parseDouble(content);
		db.UpdateMoney(this.name, sum);
	}
	
	
}

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
import javax.swing.JTextField;

import DB.ATMDataBase;
import Jiemian.MainFrame;
import Jiemian.TestFrame;

@SuppressWarnings("serial")
public class UpdatePassWord extends JFrame implements ActionListener{

	private JLabel oldPsw;
	private JLabel newPsw;
	private JTextField oldEdt;
	private JTextField newEdt;
	private JButton confirmBtn;
	private JButton concel;
	private String name;

	
	public UpdatePassWord(String name){
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
		Container con = this.getContentPane();
		oldPsw = new JLabel("旧密码");
		oldPsw.setBounds(30, 80, 100, 20);
		oldEdt = new JTextField();
		oldEdt.setBounds(190, 80, 100, 20);
		newPsw = new JLabel("新密码");
		newPsw.setBounds(30, 120, 100, 20);
		newEdt = new JTextField();
		newEdt.setBounds(190, 120, 100, 20);
		confirmBtn = new JButton("确认");
		confirmBtn.setBounds(30, 160, 100, 20);
		concel = new JButton("取消");
		concel.setBounds(190, 160, 100, 20);
		con.add(oldPsw);
		con.add(oldEdt);
		con.add(newPsw);
		con.add(newEdt);
		con.add(confirmBtn);
		con.add(concel);
		confirmBtn.addActionListener(this);
		concel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if(e.getSource()==confirmBtn){
			ATMDataBase db = new ATMDataBase();
			db.UpdatePassWord(this.name, oldEdt.getText());
			JOptionPane.showMessageDialog(null, "密码修改成功，请重新登录!","error", JOptionPane.WARNING_MESSAGE);
			new TestFrame();
			this.dispose();
		}else if(e.getSource()==concel){
			this.dispose();
			new MainFrame(name);
		}
	}
}

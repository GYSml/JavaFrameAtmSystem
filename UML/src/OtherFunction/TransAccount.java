package OtherFunction;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.ATMDataBase;
import Jiemian.MainFrame;

@SuppressWarnings("serial")
public class TransAccount extends JFrame implements ActionListener{
	private JLabel ID;
	private JTextField IDNumber;
	private JLabel money;
	private JTextField moneyNuber;
	private JButton confirm;
	private JButton concel;
	private String name;
	public TransAccount(String name){
		this.name = name;
        this.setTitle("转账功能");
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
		ID = new JLabel("对方账户");
		ID.setBounds(30, 80, 100, 20);
		IDNumber = new JTextField();
		IDNumber.setBounds(190, 80, 100, 20);
		money = new JLabel("金额");
		money.setBounds(30, 120, 100, 20);
		moneyNuber = new JTextField();
		moneyNuber.setBounds(190, 120, 100, 20);
		confirm = new JButton("确认转账");
		confirm.setBounds(30, 160, 100, 20);
		concel = new JButton("取消");
		concel.setBounds(190, 160, 100, 20);
		Container con = this.getContentPane();
		con.add(ID);
		con.add(IDNumber);
		con.add(money);
		con.add(moneyNuber);
		con.add(concel);
		con.add(confirm);
		concel.addActionListener(this);
		confirm.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==confirm){
			ATMDataBase db = new ATMDataBase();
			boolean item = db.JudegIDIsDistens(IDNumber.getText());
			if(item){
				String itself = db.Find(this.name);
				String itemID = db.Find(IDNumber.getText());
				if(itemID.split(",")[0].equals(IDNumber.getText())){
					JOptionPane.showMessageDialog(null, "不能自身转账","error", JOptionPane.WARNING_MESSAGE);
					IDNumber.setText("");
					moneyNuber.setText("");
				}else{
					double selfmoney = Double.parseDouble(itself.split(",")[2]);
					double sum = selfmoney - Double.parseDouble(moneyNuber.getText());
					if(sum>=0){
						db.UpdateMoney(itself.split(",")[0], sum);
						db.UpdateMoney(itemID.split(",")[0], 
								Double.parseDouble(itemID.split(",")[2])+Double.parseDouble(moneyNuber.getText()));
						JOptionPane.showMessageDialog(null, "转账成功","success", JOptionPane.WARNING_MESSAGE);
						IDNumber.setText("");
						moneyNuber.setText("");
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "账户不存在，请重新输入","error", JOptionPane.WARNING_MESSAGE);
				IDNumber.setText("");
				moneyNuber.setText("");
			}
		}else if(e.getSource()==concel){
			this.dispose();
			new MainFrame(name);
		}
	}
}

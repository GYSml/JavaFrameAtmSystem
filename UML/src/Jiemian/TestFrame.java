package Jiemian;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.ATMDataBase;
 
@SuppressWarnings("serial")
public class TestFrame extends JFrame implements ActionListener{

    private JTextField username;
    private JPasswordField password;
    // 小容器
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JButton bu1;
    private JButton bu3;
    
    public TestFrame() {
        // 设置窗口标题
        this.setTitle("欢迎来到**银行");
        // 窗体组件初始化
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置布局方式为绝对定位
        this.setLayout(null);
        this.setBounds(0, 0, 400, 300);      
        // 窗体大小不能改变
        this.setResizable(false);      
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void init() {
        // 创建一个容器
        Container con = this.getContentPane();
        jl1 = new JLabel();
        jl1.setBounds(0, 0, 400, 300);
        jl2 = new JLabel();
        jl2.setBounds(40, 95, 50, 60);
        username = new JTextField();
        username.setBounds(100, 100, 150, 20);
        jl3 = new JLabel("账号");
        jl3.setBounds(60, 100, 70, 20);
        password = new JPasswordField();
        password.setBounds(100, 130, 150, 20);
        jl4 = new JLabel("密码:");
        jl4.setBounds(60, 130, 70, 20);

        bu1 = new JButton("登录");
        bu1.setBounds(180, 180, 65, 20);
        bu3 = new JButton("取消");
        bu3.setBounds(100, 180, 65, 20);

        jl1.add(jl2);
        jl1.add(jl3);
        jl1.add(jl4);
        jl1.add(bu1);
        jl1.add(bu3);
        con.add(jl1);
        con.add(username);
        con.add(password);
        bu1.addActionListener(this);
        bu3.addActionListener(this);
    }

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==bu1){
			ATMDataBase db = new ATMDataBase();
			String data = db.Find(username.getText());
			String []item = data.split(",");
				if(username.getText().equals(item[0])&&password.getText().equals(item[1])){
						new MainFrame(username.getText());
						this.dispose();
				
			}else if(username.getText().isEmpty()||password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "账户或者密码不能为空","error", JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "账户或者密码错误","error", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource()==bu3){
			this.dispose();
		}
	}
 
}
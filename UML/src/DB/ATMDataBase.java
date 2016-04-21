package DB;

import java.sql.*;

public class ATMDataBase {

	public Connection Conn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/atmdatabase";
		String user = "root"; 
		String password = "123456";
		Connection conn=null;
			try {
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed()) 
		             System.out.println("Succeeded connecting to the Database!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return conn;
	}
	public void SelectAllMessage(){
				Connection conn = Conn();
				String sql = "select * from message";
				ResultSet rs;
				Statement statement = null;
				try {
					statement = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					rs = statement.executeQuery(sql);
		            System.out.println("-----------------");
		            System.out.println("执行结果如下所示:");
		            System.out.println("-----------------");
		            System.out.println(" 卡号" + "\t" + " 密码" + "\t" + "金额");
		            System.out.println("-----------------");
		            
		            String name = null;
		            while(rs.next()){
		            	name = rs.getString("IDCard");
		            	System.out.println(rs.getString("IDCard") + "\t" + rs.getString("password")+"\t" +rs.getDouble("money"));
		            }
		            rs.close();
		            conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	} 
	public void UpdatePassWord(String IDCard,String psw){
		String updatesql = "update message set password=? where IDCard=?";
		Connection conn = Conn();
		try {
			PreparedStatement preStmt =conn.prepareStatement(updatesql);
			preStmt.setString(2,IDCard);
			preStmt.setString(1, psw);
			preStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UpdateMoney(String IDCard,double money){
		String updatesql = "update message set money=? where IDCard=?";
		Connection conn = Conn();
		try {
			PreparedStatement preStmt =conn.prepareStatement(updatesql);
			preStmt.setString(2,IDCard);
			preStmt.setDouble(1, money);
			preStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean JudegIDIsDistens(String name){
		String updatesql = "select * from message where IDCard ="+"'"+name+"'";
		Connection conn = Conn();
		boolean pass  = false;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(updatesql);
			if(rs.next()){
				pass = true;
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return pass;
	}
	public String Find(String name){
		
		String updatesql = "select * from message where IDCard ="+"'"+name+"'";
		Connection conn = Conn();
		String pass=null;
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(updatesql);
				if(rs.next()){
					pass =rs.getString(1)+","+ rs.getString(2)+","+rs.getDouble(3);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return pass;
	}
}

package TraderServer.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {
	public static int login(String username, String password){
		int result = -1;
		try{
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/trader_system";
			String user = "root";
			String dbPassword = "lzk5658665";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, dbPassword);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			PreparedStatement ps = conn.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				result = rs.getInt("ID");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return result;
	}
}

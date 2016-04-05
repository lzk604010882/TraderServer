package TraderServer.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetStockBean {
	public static int GetStock(int userID, String commodity, String period){
		try{
			UpdateDataBean.updateData(userID);
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/trader_system";
			String user = "root";
			String dbPassword = "lzk5658665";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, dbPassword);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			PreparedStatement ps = conn.prepareStatement("select sum(dealtQty) from orders where userID = ? and commodityName = ?"
					+ "and type = \"buy\" and period = ?");
			ps.setInt(1, userID);
			ps.setString(2, commodity);
			ps.setString(3, period);
			
			ResultSet rs = ps.executeQuery();
			
			int bought = 0;
			int selling = 0;
			if(rs.next()){
				bought = rs.getInt(1);
			}
			PreparedStatement ps2 = conn.prepareStatement("select sum(initQty - dealtQty) from orders where userID = ? and commodityName = ?"
					+ "and type = \"sell\" and period = ?");
			ps2.setInt(1, userID);
			ps2.setString(2, commodity);
			ps2.setString(3, period);
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()){
				selling = rs.getInt(1);
			}
			
			return bought - selling;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}

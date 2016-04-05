package TraderServer.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class UpdateDataBean {
	public static void updateData(int traderID){
		try{
			String driver = "com.mysql.jdbc.Driver";
			String dburl = "jdbc:mysql://localhost:3306/trader_system";
			String user = "root";
			String dbPassword = "lzk5658665";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, user, dbPassword);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			List<String>agencys = GetBrokerAgencyBean.getAllAgency();
			for(int i = 0; i < agencys.size(); i++){
				String url = agencys.get(i);
				url += "/getTraderDeals?traderID=";
				url += traderID;
				HttpClient client = new HttpClient();
				GetMethod method = new GetMethod(url);
				client.executeMethod(method);
				String rs = method.getResponseBodyAsString();
				JSONArray deals = JSONArray.fromObject(rs);
				for(int j = 0; j < deals.size(); j++){
					JSONObject deal = deals.getJSONObject(j);
					int qty = deal.getInt("qty");
					double price = deal.getDouble("price");
					int orderID = deal.getInt("orderID");
					String time = deal.getString("dealTime");
					System.out.println(time);
					String commodityName = deal.getString("commodityName");
					String period = deal.getString("period");
					Timestamp ts = Timestamp.valueOf(time);
					int brokerID = deal.getInt("brokerID");
					PreparedStatement ps = conn.prepareStatement("insert into deals(qty, price, orderID, time, brokerID, commodityName, period) values(?, ?, ?, ?, ?, ?, ?)");
					ps.setInt(1, qty);
					ps.setDouble(2, price);
					ps.setInt(3, orderID);
					ps.setTimestamp(4, ts);
					ps.setInt(5, brokerID);
					ps.setString(6, commodityName);
					ps.setString(7, period);
					ps.executeUpdate();
					ps = conn.prepareStatement("select initQty, dealtQty from orders where ID = ?");
					ps.setInt(1, orderID);
					ResultSet re = ps.executeQuery();
					re.next();
					int initQty = re.getInt(1);
					int dealtQty = re.getInt(2);
					int remainQty = initQty - dealtQty;
					int status = 0;
					if(remainQty == qty){
						status = 2;
					}
					else if(remainQty > qty){
						status = 1;
					}
					
					ps = conn.prepareStatement("update orders set status=? , dealtQty = ? where ID = ? ");
					ps.setInt(1, status);
					ps.setInt(2, qty + dealtQty);
					System.out.println("newqty:" + (qty+dealtQty));
					ps.setInt(3, orderID);
					System.out.println(orderID);
					ps.executeUpdate();
				}
				//update deals in database
				
				//update orders in database(status and dealt quantity)
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

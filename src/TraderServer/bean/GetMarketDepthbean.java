package TraderServer.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetMarketDepthbean {
	public static List<Double> GetMarketDepth(String commodityName){
		try{
			System.out.println("commodity:" + commodityName);
			List<String>agencys = GetBrokerAgencyBean.getAllAgency();
			List<Double>prices = new ArrayList<Double>();
			for(int k = 0; k < 12; k++){
				prices.add((double) 0);
			}
			
			
			
			
			for(int j = 1; j < 13 ; j++){
				String period = GetPeriodBean.getPeriod(j);
				System.out.println("period:"+period);
				Timestamp ts = Timestamp.valueOf("2010-01-01 00:00:00");
				
				for(int i = 0; i < agencys.size(); i++){
					String url = agencys.get(i);
					url += "/getLatestDeal?commodityName=";
					url += commodityName;
					url += "&period=";
					url += period;
					HttpClient client = new HttpClient();
					GetMethod method = new GetMethod(url);
					client.executeMethod(method);
					String rs = method.getResponseBodyAsString();
					JSONObject rsJson = JSONObject.fromObject(rs);
					System.out.println("json:" + rsJson.toString());
					String time = rsJson.getString("dealTime");
					System.out.println("time2:" + time);
					if(!time.equals("")){
						Timestamp cts = Timestamp.valueOf(time);
						if(cts.after(ts)){
							prices.set(j-1, rsJson.getDouble("price"));
							ts = cts;
						}
					}
					
					
				}
				System.out.println("prices:" + prices.toString());
				
			}
			return prices;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}

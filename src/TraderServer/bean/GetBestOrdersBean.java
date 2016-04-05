package TraderServer.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import TraderServer.model.Order;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetBestOrdersBean {
	public static JSONObject getBestOrders(String commodityName){
		try{
			List<String>agencys = new ArrayList<String>();
			JSONArray buyOrders = new JSONArray();
			JSONArray sellOrders = new JSONArray();
			List<Order> buyOrderslist = new ArrayList<Order>();
			List<Order> sellOrderslist = new ArrayList<Order>();
			for(int i = 0; i < agencys.size(); i++){
				String url = agencys.get(i);
				String url2 = url;
				url += "/getBestBuyOrders?commodityName=";
				url += commodityName;
				url2 += "/getBestSellOrders?commodityName=";
				url2+= commodityName;
				HttpClient client = new HttpClient();
				GetMethod method = new GetMethod(url);
				String rs = method.getResponseBodyAsString();
				HttpClient client2 = new HttpClient();
				GetMethod method2 = new GetMethod(url2);
				String rs2 = method2.getResponseBodyAsString();
				JSONArray rsBuy = JSONArray.fromObject(rs);
				JSONArray rsSell = JSONArray.fromObject(rs2);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}

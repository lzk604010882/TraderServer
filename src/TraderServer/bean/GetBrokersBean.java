package TraderServer.bean;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetBrokersBean {
	public static String getBrokers(){
		try{
			List<String>agencys = new ArrayList<String>();
			agencys = GetBrokerAgencyBean.getAllAgency();
			JSONArray brokers = new JSONArray();
			for(int i = 0; i < agencys.size(); i++){
				String url = agencys.get(i);
				url += "/RESTGetBroker";
				HttpClient client = new HttpClient();
				GetMethod method = new GetMethod(url);
				client.executeMethod(method);
				String brokersJson = method.getResponseBodyAsString();
				JSONArray bjson = JSONArray.fromObject(brokersJson);
				for(int j = 0; j < bjson.size(); j++){
					JSONObject broker = bjson.getJSONObject(j);
					brokers.add(broker);
				}
			}
			return brokers.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}

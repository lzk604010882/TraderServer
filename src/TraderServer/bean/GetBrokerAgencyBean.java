package TraderServer.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetBrokerAgencyBean {
	public static String getBrokerAgency(int brokerID){
		try{
			SAXReader saxReader =new SAXReader();
			Document d = saxReader.read(new File("D:\\Java projects\\TraderServer\\BrokerAgencyInfo.xml"));
			Element root = d.getRootElement();
			Iterator<Element>agencys = root.elementIterator("broker-agency");
			while(agencys.hasNext()){
				Element e = agencys.next();
				int low = Integer.parseInt(e.elementTextTrim("brokerID-low"));
				int up = Integer.parseInt(e.elementTextTrim("brokerID-up"));
				if(brokerID >= low && brokerID <= up){
					System.out.println(e.elementTextTrim("url"));
					return e.elementTextTrim("url");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "illegal ID.";
	}
	
	public static List<String> getAllAgency(){
		List<String>rs = new ArrayList<String>();
		try{
			SAXReader saxReader =new SAXReader();
			Document d = saxReader.read(new File("D:\\Java projects\\TraderServer\\BrokerAgencyInfo.xml"));
			Element root = d.getRootElement();
			Iterator<Element>agencys = root.elementIterator("broker-agency");
			while(agencys.hasNext()){
				Element e = agencys.next();
				rs.add(e.elementTextTrim("url"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rs;
	}
}

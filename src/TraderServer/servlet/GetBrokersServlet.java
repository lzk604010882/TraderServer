package TraderServer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import TraderServer.bean.GetBrokerAgencyBean;

/**
 * Servlet implementation class GetBrokersServlet
 */
@WebServlet("/GetBrokersServlet")
public class GetBrokersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBrokersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<String> agencys = new ArrayList<String>();
    	String commodityName = request.getParameter("commodityName");
    	agencys = GetBrokerAgencyBean.getAllAgency();
    	for(int i = 0; i < agencys.size(); i++){
    		String url = agencys.get(i);
    		url += "/getBrokers?";
    		url += "commodityName=";
    		url += commodityName;
    		HttpClient client = new HttpClient();
    		GetMethod method = new GetMethod(url);
    		client.executeMethod(method);
    		String rs = method.getResponseBodyAsString();
    	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

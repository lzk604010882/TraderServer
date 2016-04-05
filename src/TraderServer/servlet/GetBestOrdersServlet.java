package TraderServer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Servlet implementation class GetBestOrdersServlet
 */
@WebServlet("/GetBestOrdersServlet")
public class GetBestOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBestOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String commodity = "gold";
    	HttpClient bclient = new HttpClient();
    	GetMethod bmethod = new GetMethod("http://localhost:8080/BrokerServer/services/getFiveOrder?commodityName="+commodity +"&type=0");
    	HttpClient sclient = new HttpClient();
    	GetMethod smethod = new GetMethod("http://localhost:8080/BrokerServer/services/getFiveOrder?commodityName="+commodity +"&type=1");
    	bclient.executeMethod(bmethod);
    	sclient.executeMethod(smethod);
    	String buyOrders = bmethod.getResponseBodyAsString();
    	String sellOrders = smethod.getResponseBodyAsString();
    	System.out.println(buyOrders);
    	System.out.println(sellOrders);
    	request.setAttribute("buyOrders", buyOrders);
    	request.setAttribute("sellOrders", sellOrders);
    	RequestDispatcher rd = request.getRequestDispatcher("FillOrders.jsp");
		rd.forward(request, response);
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

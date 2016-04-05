package TraderServer.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import TraderServer.bean.GetBrokerAgencyBean;
import TraderServer.model.Order;

/**
 * Servlet implementation class SendOrderServlet
 */
@WebServlet("/SendOrderServlet")
public class SendOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try{
	    	String commodityName = request.getParameter("commodityName");
	    	String period = request.getParameter("period");
	    	int brokerID = Integer.parseInt(request.getParameter("broker"));
	    	int initQty = Integer.parseInt(request.getParameter("qty"));
	    	int type = Integer.parseInt(request.getParameter("type"));
	    	double price = Double.parseDouble(request.getParameter("price"));
	    	String url = GetBrokerAgencyBean.getBrokerAgency(brokerID);
	    	HttpSession ses = request.getSession();
	    	int traderID = (int)ses.getAttribute("userID");
	    	
	    	
	    	String driver = "com.mysql.jdbc.Driver";
			String dburl = "jdbc:mysql://localhost:3306/trader_system";
			String user = "root";
			String dbPassword = "lzk5658665";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, user, dbPassword);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
	    	
			PreparedStatement ps = conn.prepareStatement("insert into orders(commodityName, period, brokerID, initQty, status, type, price, userID) values(?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, commodityName);
			ps.setString(2, period);
			ps.setInt(3, brokerID);
			ps.setInt(4, initQty);
			ps.setInt(5, -1);
			ps.setInt(6, type);
			ps.setDouble(7, price);
			ps.setInt(8, traderID);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int orderID = rs.getInt(1);
			Order order = new Order(type, period, brokerID, traderID, initQty, commodityName, price, orderID);
			JSONObject orderJson = new JSONObject();
	    	orderJson = JSONObject.fromObject(order);
			System.out.print(type);
	    	if(type == 0){
	    		url += "/dealBuyOrder?";
	    	}
	    	else{
	    		url += "/dealSellOrder?";
	    	}
	    	
	    	
	    	
	    	url += "order=";
	    	url += orderJson.toString();
	    	System.out.println(url);
	    	HttpClient client = new HttpClient();
	    	GetMethod method = new GetMethod(url);
	    	
	    	client.executeMethod(method);
	    	
	    	String result = method.getResponseBodyAsString();
	    	
	    	if(result.equals("SUCCESS")){
	    		PreparedStatement ps2 = conn.prepareStatement("update orders set status=\"0\" where ID=?");
	    		
	    		ps2.setInt(1, orderID);
	    		ps2.executeUpdate();
	    		System.out.println("updated");
	    		RequestDispatcher rd = request.getRequestDispatcher("NewBuyOrder.jsp");
	    		rd.forward(request, response);
	    	}
	    	else{
	    		PreparedStatement ps2 = conn.prepareStatement("delete from orders where ID = ?");
	    		ps2.setInt(1, orderID);
	    		ps2.executeUpdate();
		    	RequestDispatcher rd = request.getRequestDispatcher("NewBuyOrder.jsp");
				rd.forward(request, response);
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
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

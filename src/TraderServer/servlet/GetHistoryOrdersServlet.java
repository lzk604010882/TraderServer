package TraderServer.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import TraderServer.bean.GetBrokerAgencyBean;
import TraderServer.bean.UpdateDataBean;
import TraderServer.model.Order;

/**
 * Servlet implementation class GetHistoryOrdersServlet
 */
@WebServlet("/GetHistoryOrdersServlet")
public class GetHistoryOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistoryOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try{
	    	HttpSession ses = request.getSession();
	    	int userID = (int)ses.getAttribute("userID");
	    	UpdateDataBean.updateData(userID);
	    	String driver = "com.mysql.jdbc.Driver";
			String dburl = "jdbc:mysql://localhost:3306/trader_system";
			String user = "root";
			String dbPassword = "lzk5658665";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, user, dbPassword);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			PreparedStatement ps = conn.prepareStatement("select * from orders where userID = ?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			List<Order>orders = new ArrayList<Order>();
			
			while(rs.next()){
				Order order = new Order();
				order.setBrokerID(rs.getInt("brokerID"));
				order.setCommodityName(rs.getString("commodityName"));
				order.setDealtQty(rs.getInt("dealtQty"));
				order.setInitQty(rs.getInt("initQty"));
				order.setPeriod(rs.getString("period"));
				order.setPrice(rs.getDouble("price"));
				order.setType(Integer.parseInt(rs.getString("type")));
				order.setStatus(rs.getInt("status"));
				order.setTraderID(userID);
				orders.add(order);
			}
			System.out.println(orders.size());
			request.setAttribute("orders", orders);
			RequestDispatcher rd = request.getRequestDispatcher("HistoryOrders.jsp");
	    	rd.forward(request, response);
			
			
			
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

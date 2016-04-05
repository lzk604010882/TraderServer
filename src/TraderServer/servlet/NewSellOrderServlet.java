package TraderServer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import TraderServer.bean.GetBrokersBean;
import TraderServer.bean.GetPeriodBean;
import TraderServer.bean.GetStockBean;

/**
 * Servlet implementation class NewSellOrderServlet
 */
@WebServlet("/NewSellOrderServlet")
public class NewSellOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSellOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String commodity = request.getParameter("commodityName");
    	int month = Integer.parseInt(request.getParameter("month"));
    	String period = GetPeriodBean.getPeriod(month);
    	HttpSession ses = request.getSession();
    	int userID = (int)ses.getAttribute("userID");
    	System.out.println("sellorder:" + commodity);
    	System.out.println("sellorder:" + period);
    	//int stock = GetStockBean.GetStock(userID, commodity, period);
    	int stock = 5;
    	
    	//String brokers = GetBrokersBean.getBrokers();
    	//JSONArray brokersJson = JSONArray.fromObject(brokers);
    	
    	//request.setAttribute("brokers", brokersJson.toString());
    	request.setAttribute("stock", stock);
    	request.setAttribute("commodityName", commodity);
    	request.setAttribute("period", period);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("FinishSellOrder.jsp");
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

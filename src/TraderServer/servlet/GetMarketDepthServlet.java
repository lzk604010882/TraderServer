package TraderServer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TraderServer.bean.GetMarketDepthbean;

/**
 * Servlet implementation class GetMarketDepthServlet
 */
@WebServlet("/GetMarketDepthServlet")
public class GetMarketDepthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMarketDepthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String commodityName = request.getParameter("commodityName");
    	List<Double>prices = new ArrayList<Double>();
    	if(commodityName == null){
    		prices = GetMarketDepthbean.GetMarketDepth(commodityName);
    	}
    	prices = GetMarketDepthbean.GetMarketDepth(commodityName);
    	request.setAttribute("prices", prices);
    	System.out.println("servlet:" + prices.size());
    	RequestDispatcher rd = request.getRequestDispatcher("MarketDepth.jsp");
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

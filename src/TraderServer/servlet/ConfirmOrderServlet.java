package TraderServer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TraderServer.bean.GetPeriodBean;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String commodityName = request.getParameter("commodityName");
    	String price = request.getParameter("price");
    	String qty = request.getParameter("qty");
    	String broker = request.getParameter("broker");
    	String period = request.getParameter("period");
    	int type = Integer.parseInt(request.getParameter("type"));
    	System.out.println(commodityName);
    	System.out.println(period);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("ConfirmOrder.jsp");
    	request.setAttribute("commodityName", commodityName);
    	request.setAttribute("price", price);
    	request.setAttribute("qty", qty);
    	request.setAttribute("broker", broker);
    	request.setAttribute("period", period);
    	request.setAttribute("type", type);
    	
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

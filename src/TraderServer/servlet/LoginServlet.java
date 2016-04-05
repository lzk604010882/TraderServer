package TraderServer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import TraderServer.bean.LoginBean;
import TraderServer.bean.UpdateDataBean;
import TraderServer.model.Order;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession ses = request.getSession();
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	int ID = LoginBean.login(username, password);
    	/*HttpClient client = new HttpClient();
    	GetMethod method = new GetMethod("http://localhost:8080/BrokerServer/services/getTraderDeals?traderID=1");
    	client.executeMethod(method);
    	String res = method.getResponseBodyAsString();
    	System.out.println(res);*/
    	
    	if(ID != -1){
    		
    		ses.setAttribute("username", username);
    		ses.setAttribute("userID", ID);
    		UpdateDataBean.updateData(ID);
    		response.sendRedirect("NewBuyOrder.jsp");
    	}
    	else{
    		response.sendRedirect("NewBuyOrder.jsp");
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

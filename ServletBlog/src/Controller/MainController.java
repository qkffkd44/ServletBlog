package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.ServiceForward;
import Interface.ServiceInterface;
import Service.MainService;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
    System.out.println("MainController : init");

    String cmd = request.getParameter("cmd");
    System.out.println("MainController : 분기 명령어 : " + cmd);
	  
	  
	  ServiceForward forward = null;
	  ServiceInterface service = null;
	  
	  if(cmd.equals("order")){
	  service = new MainService();
	  forward = service.excute(request, response);
	  
	  response.setCharacterEncoding("UTF-8");
	  PrintWriter pw = response.getWriter();
	  String result_json = ""+request.getAttribute("Boardlist");
	  System.out.println(result_json);
	  pw.write(result_json);
	  return;
	  
	  }else if(cmd.equals("view")){
	    int id = Integer.parseInt(request.getParameter("id"));
	    System.out.println(id);
	    
	  }
    if (forward != null) {
      if (forward.isRedirect()) { // redirect
        response.sendRedirect(forward.getPath());
      } else { // forward
        RequestDispatcher dispathcer = request.getRequestDispatcher(forward.getPath());
        dispathcer.forward(request, response);
      }
    }
	}

}

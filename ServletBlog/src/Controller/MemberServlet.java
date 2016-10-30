package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.ServiceForward;
import Interface.ServiceInterface;
import Service.JoinService;
import Service.LoginService;
import Service.LogoutService;

public class MemberServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("MemberServlet : init");

    request.setCharacterEncoding("UTF-8");

    String cmd = request.getParameter("cmd");
    System.out.println("MemberServlet : 분기 명령어 : " + cmd);

    ServiceForward forward = null;
    ServiceInterface service = null;

    if (cmd.equals("login")) {
      service = new LoginService();
      
      forward = service.excute(request, response);

    }
    
    if(cmd.equals("logout")){
      service = new LogoutService();
      
      forward = service.excute(request, response);
    }
    
    if(cmd.equals("Join")){
      service = new JoinService();
      forward = service.excute(request, response);
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

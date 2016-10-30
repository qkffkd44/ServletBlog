package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.ServiceForward;
import Interface.ServiceInterface;
import Service.BoardEditService;
import Service.BoardPageService;
import Service.BoardRegisterService;
import Service.LoginService;
import Service.LogoutService;

@WebServlet("/board.do")
public class boardController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    System.out.println("boardController : init");

    String cmd = request.getParameter("cmd");
    System.out.println("boardController :  분기 명령어 : " + cmd);

    ServiceForward forward = null;
    ServiceInterface service = null;

    if (cmd.equals("page")) {
      service = new BoardPageService();
      //service.excute 하면 서비스 페이지로 이동
      forward = service.excute(request, response);
    }else if(cmd.equals("register")){
      service = new BoardRegisterService();
      forward = service.excute(request, response);
    }else if(cmd.equals("edit")){
      service = new BoardEditService();
      forward = service.excute(request, response);
    }

    if (forward != null) {
      if (forward.isRedirect()) { // redirect
        response.sendRedirect(forward.getPath());
        System.out.println("redirect");
      } else { // forward
        RequestDispatcher dispathcer = request.getRequestDispatcher(forward.getPath());
        dispathcer.forward(request, response);
        System.out.println("forward");
      }
    }

  }
}

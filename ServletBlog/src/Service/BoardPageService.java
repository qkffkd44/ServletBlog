package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MemberDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class BoardPageService implements ServiceInterface{

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    
    System.out.println("BoardPageService : init");
    
    ServiceForward forward = new ServiceForward();
    forward.setRedirect(true);
    
    HttpSession session = request.getSession();
    
    MemberDTO member = (MemberDTO)session.getAttribute("Member");
    
    if(member!=null){
      forward.setPath("./PagePost.jsp");
    }else if(member == null){
      forward.setPath("./PageLogin.jsp");
    }
    
    return forward;
  }
  

}

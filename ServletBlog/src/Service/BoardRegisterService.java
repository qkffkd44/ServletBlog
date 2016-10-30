package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class BoardRegisterService implements ServiceInterface {

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    
    System.out.println("BoardRegisterService : init");
    
    ServiceForward forward = new ServiceForward();
    forward.setRedirect(true);
    forward.setPath("./PageHome.jsp");
    
    BoardDTO dto = new BoardDTO();
    dto.setTitle(request.getParameter("title"));
    dto.setContent(request.getParameter("content"));   
    dto.setMember_id(1);
    
    HttpSession session = request.getSession();
    MemberDTO member = (MemberDTO)session.getAttribute("Member");
    
    dto.setAuthor(member.getId());
    dto.setPassword(member.getPwd());
    
    BoardDAO dao = new BoardDAO();
    dao.create(dto);
    
    
    return forward;
  }
  

}

package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class BoardEditService implements ServiceInterface {

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    ServiceForward forward = new ServiceForward();
    forward.setRedirect(true);
    forward.setPath("main.do?cmd=order");
    
    System.out.println("BoardEditService init");
    
    BoardDTO dto = new BoardDTO();
    dto.setTitle(request.getParameter("title_edit"));
    dto.setContent(request.getParameter("content_edit"));   
    dto.setMember_id(1);
    
    HttpSession session = request.getSession();
    MemberDTO member = (MemberDTO)session.getAttribute("Member");
    
    dto.setAuthor(member.getId());
    dto.setPassword(member.getPwd());
    
    BoardDAO dao = new BoardDAO();
    dao.update(dto);
    
    
   
    return forward;
  }

}

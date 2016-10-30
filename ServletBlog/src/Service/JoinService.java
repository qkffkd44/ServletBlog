package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DTO.MemberDTO;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class JoinService implements ServiceInterface {

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    System.out.println("JoinService : init");
    
    ServiceForward forward = new ServiceForward();
    forward.setRedirect(true);
    forward.setPath("./PageHome.jsp");
    
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String location = request.getParameter("location");
    
    MemberDTO dto = new MemberDTO();
    dto.setId(id);
    dto.setPwd(pwd);
    dto.setName(name);
    dto.setAge(age);
    dto.setEmail(email);
    dto.setLocation(location);
    
    boolean b = new MemberDAO().join(dto);
    
    if(b){ //회원가입 성공했을때
      System.out.println("회원가입 성공");
    }else{
      System.out.println("회원가입 실패");
    }

    
    return forward;
  }
  

}

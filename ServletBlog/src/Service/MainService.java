package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.BoardDAO;
import DTO.BoardDTO;
import Interface.BoardPage;
import Interface.ServiceForward;
import Interface.ServiceInterface;

public class MainService implements ServiceInterface{

  @Override
  public ServiceForward excute(HttpServletRequest request, HttpServletResponse response) {
    
    System.out.println("MainService : init");
    
    ServiceForward forward = new ServiceForward();
    forward.setPath("./PageHome.jsp");
    forward.setRedirect(false);
    
    //페이지를 가져오는것을 페이징처리
    int listCount = Integer.parseInt(request.getParameter("listCount"));
    System.out.println(listCount);
    
    BoardPage page = new BoardPage(3, listCount );
    
    
    BoardDAO dao = new BoardDAO();
    ArrayList<BoardDTO> list = dao.getList(page);
    
    String json = new Gson().toJson(list);
    System.out.println(json);
    
    request.setAttribute("Boardlist", json);
    return forward;
  }
  

}

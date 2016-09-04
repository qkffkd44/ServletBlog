package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DBManager;
import DTO.MemberDTO;

//DAO는 디비에 접근하는
public class MemberDAO {

  public boolean login(MemberDTO dto) {
    boolean b = false;

    Connection con = DBManager.getConnection();
    PreparedStatement pstmt = null;
    String sql = "Select * from member where mid=? and mpwd=?";

    System.out.println(dto.getId());
    System.out.println(dto.getPwd());
    
    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getId());
      pstmt.setString(2, dto.getPwd());
   
      ResultSet rs = pstmt.executeQuery();
      
      int count = 0;
      
      while(rs.next()){
        count++;
      }
      
      System.out.println(count);
      if(count >0)
        b = true;
      
      rs.close();
      pstmt.close();
      con.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return b;
  }

}

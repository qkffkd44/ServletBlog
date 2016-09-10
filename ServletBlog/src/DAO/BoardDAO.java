package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBManager.DBManager;
import DTO.BoardDTO;

public class BoardDAO {
  public ArrayList<BoardDTO> getList(){
    ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
    String sql = "SELECT * from board where LIMIT 3";
    
    Connection conn  = DBManager.getConnection();
    
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      
      ResultSet result = pstmt.executeQuery();
      
      while(result.next()){
        BoardDTO dto = new BoardDTO();
        
        dto.setId(result.getInt("id"));
        dto.setTitle(result.getString("title"));
        dto.setContent(result.getString("content"));
        dto.setCreated_at(result.getDate("created_id"));
        dto.setMember_id(result.getInt("menber_id"));
        dto.setAuthor(result.getString("author"));
        dto.setPassword(result.getString("password"));
        list.add(dto);     
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    
    return list;
  }
  public boolean create(BoardDTO dto){
    boolean b = false;
    
    Connection conn = DBManager.getConnection();
   
    
    String sql = "Insert into board ('title', 'content', 'created_at', 'member_id', 'author', 'password')" 
                  + "values (?,?,now(),?,?,?);";
    
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setDate(3, dto.getCreated_at());
      pstmt.setInt(4, dto.getMember_id());
      pstmt.setString(5, dto.getAuthor());
      pstmt.setString(6, dto.getPassword());
      
      int index = pstmt.executeUpdate();
      
      if(index>0){
        b=true;
      }else{
        b=false;
      }
      // 자원반납 잊지말기
      pstmt.close();
      conn.close();
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    
    return b;
  }

}

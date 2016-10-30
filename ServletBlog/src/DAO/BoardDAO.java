package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBManager.DBManager;
import DTO.BoardDTO;
import Interface.BoardPage;

public class BoardDAO {
  public ArrayList<BoardDTO> getList(BoardPage page){
    ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
    String sql = "SELECT * from board order by id desc, created_at desc limit ?, ?";
    
    Connection conn  = DBManager.getConnection();
    
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, page.getIndex());
      pstmt.setInt(2, page.getCount());
      
      ResultSet result = pstmt.executeQuery();
      
      while(result.next()){
        BoardDTO dto = new BoardDTO();
        
        dto.setId(result.getInt("id"));
        dto.setTitle(result.getString("title"));
        dto.setContent(result.getString("content"));
        dto.setCreated_at(result.getDate("created_at"));
        dto.setMember_id(result.getInt("member_id"));
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
   
    
    String sql = "Insert into board (title, content, created_at, member_id, author, password)" 
                  + "values (?,?,now(),?,?,?);";
    
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setInt(3, dto.getMember_id());
      pstmt.setString(4, dto.getAuthor());
      pstmt.setString(5, dto.getPassword());
      
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

  public boolean update(BoardDTO dto){
    boolean b = false;
    
    Connection conn = DBManager.getConnection();
   
    
    String sql = "Update board set title=?, content=?, author=?, password=? " 
                  + "where id=?;";
    
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setString(3, dto.getAuthor());
      pstmt.setString(4, dto.getPassword());
      pstmt.setInt(5, dto.getId());
      
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

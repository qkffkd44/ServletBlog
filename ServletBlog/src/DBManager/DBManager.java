package DBManager;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB연결을 담당하는 클래스
//이거는 계속 복사해서 쓸수있다.
public class DBManager {

  private static DataSource ds = null;

  public DBManager() {
    init();
  }

  private void init(){
 // dbcp 를 통해  datasource 받아오기
    Context init = null;
    try 
    {
       init = new InitialContext();
       ds = (DataSource) init.lookup("java:comp/env/jdbc/booksystem");
    } 
    catch (NamingException e){e.printStackTrace();}
  }
  
  //singleton 방식
  public static Connection getConnection(){
    Connection con = null;
    
    //초기화가 필요할때 초기화
    if(ds == null){
      new DBManager();
    }
    // DB Connection받아오기
    try{
      con = ds.getConnection();
      System.out.println("DB 연결 성공");
    }catch(SQLException e) {
      e.printStackTrace();
    }
    
    return con;
  }

}

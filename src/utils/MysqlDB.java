package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MysqlDB {
	 static Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Statement stat=null;

	public static Connection getconn(){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String  url="jdbc:mysql://localhost:3306/qsgl";
		    conn=DriverManager.getConnection(url, "root", "root");
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	  //≤È—Ø
    public ResultSet getResult(String sql,String []args){
   	 rs=null;
   	 if(conn==null){
   		 conn=this.getconn();
   	 }
   	 try{
   		 pstmt=conn.prepareStatement(sql);
   		 for(int i=0;i<args.length;i++){
   			 pstmt.setString(i+1, args[i]);
   		 }
   		 rs=pstmt.executeQuery();
   	 }catch(SQLException e){
   		 e.printStackTrace();
   	 }
   	 return rs;
    }
    public ResultSet getResult(String sql){
   	 rs=null;
   	 if(conn==null){
   		 conn=this.getconn();
   	 }
   	 try{
   		 stat=conn.createStatement();
   		 rs=stat.executeQuery(sql);
   	 }catch(SQLException e){
   		 e.printStackTrace();
   	 }
   	 return rs;
    }
    public static void main(String []args){
   	 MysqlDB db=new MysqlDB();
   	 ResultSet rs=db.getResult("select * from user where username=? and password=?;",
   	 new String[]{"ws","123"});
   	 try{
   		 while(rs.next()){
   			 System.out.println(rs.getString("username"));
   			 System.out.println(rs.getString("password"));
   		 }
   	 }catch(SQLException e){
   		 e.printStackTrace();
   	 }
    }
}
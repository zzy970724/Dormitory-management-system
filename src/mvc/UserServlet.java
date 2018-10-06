package mvc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

import dao.UserDAO;
import daoimpl.UserDAOImpl;

import utils.MysqlDB;





@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session1 = request.getSession();
		 //创建DAO
        UserDAO ud=new UserDAOImpl();
       //创建实体类
        User u=new User();
        
        String str=request.getParameter("flag");
		   HttpSession session=request.getSession();
		   
		  //注册
		   if("add".equals(str)){
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   System.out.println(username);
		   System.out.println(password);
		   
		   u.setUsername(username);
		   u.setPassword(password);
		   
		   boolean b1=ud.addUser(u);
		   System.out.println("注册成功");
		   
		  response.sendRedirect("login.html");
		   }
		   
		   
		   if("login".equals(str)){
		MysqlDB md = new MysqlDB();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ResultSet rs=md.getResult("select * from user where username=? and password=?;", new String[]{username,password});
	      try{
	    	  if(rs.next()){
	    		  System.out.println("登陆成功");
	    		  session1.setAttribute("username","passowrd");

	    		  request.getRequestDispatcher("index.html").forward(request, response);
	    	  }else{
	    		  System.out.println("登陆失败");
	    		  request.getRequestDispatcher("login.html").forward(request, response);

	    	  }
	      }catch (SQLException e1){
	    	  e1.printStackTrace();
	      }
	   
		}

		}

	}

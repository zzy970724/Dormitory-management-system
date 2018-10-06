package mvc;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.student;



import dao.StudentDAO;
import daoimpl.StudentDAOImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//创建DAO   
		StudentDAO sd=new StudentDAOImpl();
		//创建实体类
		student s =new student();
		String str=request.getParameter("flag");
		HttpSession session=request.getSession();
		 //添加
		if(str.equals("add")){
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String stype=request.getParameter("stype");
			String snum=request.getParameter("snum");
			String sic=request.getParameter("sic");
			String steacher=request.getParameter("steacher");
			String sqsmh=request.getParameter("sqsmh");
			String sqsld=request.getParameter("sqsld");
			
			s.setSid(Integer.parseInt(sid));
			s.setSname(sname);
			s.setStype(stype);
			s.setSnum(Integer.parseInt(snum));
			s.setSic(Integer.parseInt(sic));
			s.setSteacher(steacher);
			s.setSqsmh(Integer.parseInt(sqsmh));
			s.setSqsld(Integer.parseInt(sqsld));
			
			boolean bol	=sd.addStudent(s);
			System.out.println(bol);
			  response.sendRedirect("branchmanage/index.jsp");
			
		}
		//修改
		if(str.equals("upd")){
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String stype=request.getParameter("stype");
			String snum=request.getParameter("snum");
			String sic=request.getParameter("sic");
			String steacher=request.getParameter("steacher");
			String sqsmh=request.getParameter("sqsmh");
			String sqsld=request.getParameter("sqsld");
			
			s.setSname(sname);
			s.setStype(stype);
			s.setSnum(Integer.parseInt(snum));
			s.setSic(Integer.parseInt(sic));
			s.setSteacher(steacher);
			s.setSqsmh(Integer.parseInt(sqsmh));
			s.setSqsld(Integer.parseInt(sqsld));
			s.setSid(Integer.parseInt(sid));
			
			boolean bol	=sd.update(s);
			System.out.println(bol);
			  response.sendRedirect("branchmanage/index.jsp");
			
		}
		//查询
		if(str.equals("find")){
			String sname = request.getParameter("sname");
			String sid = request.getParameter("sid");
			String sqsld = request.getParameter("sqsld");
			
			if("null".equals(sname)&&sname.length()==0){
				response.sendRedirect("branchmanage/index.jsp");
			}else{
				List list = sd.findStudentByLike(sname, Integer.parseInt(sid), Integer.parseInt(sqsld));
				session.setAttribute("list", list);
				response.sendRedirect("branchmanage/index.jsp");
			}
		}
	}

}

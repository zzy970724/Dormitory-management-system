package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import pojo.student;
import utils.MysqlDB;
import dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO{

	Connection conn=MysqlDB.getconn();
	ResultSet rs=null;
	@Override
	public boolean addStudent(student s) {
		boolean flag=false;
		String sql="insert into student(sid,sname,stype,snum,sic,steacher,sqsmh,sqsld)values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, s.getSid());
			pstmt.setString(2, s.getSname());
			pstmt.setString(3, s.getStype());
			pstmt.setInt(4, s.getSnum());
			pstmt.setInt(5, s.getSic());
			pstmt.setString(6, s.getSteacher());
			pstmt.setInt(7, s.getSqsmh());
			pstmt.setInt(8, s.getSqsld());
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean dalStudent(int sid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(student s) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update student set sname=?,stype=?,snum=?,sic=?,steacher=?,sqsmh=?,sqsld=? where sid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, s.getSname());
			pstmt.setString(2, s.getStype());
			pstmt.setInt(3, s.getSnum());
			pstmt.setInt(4, s.getSic());
			pstmt.setString(5, s.getSteacher());
			pstmt.setInt(6, s.getSqsmh());
			pstmt.setInt(7, s.getSqsld());
			pstmt.setInt(8, s.getSid());
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List findAllStudent() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sql = "select * from student";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				student s = new student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setStype(rs.getString("stype"));
				s.setSnum(rs.getInt("snum"));
				s.setSic(rs.getInt("sic"));
				s.setSteacher(rs.getString("steacher"));
				s.setSqsmh(rs.getInt("sqsmh"));
				s.setSqsld(rs.getInt("sqsld"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List findStudentByLike(String sname,int sid,int sqsld){
		List list = new ArrayList();
		String sql = "select * from student where sname like ? and sid like ? and sqsld like ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sname+"%");
			pstmt.setString(2, "%"+sid+"%");
			pstmt.setString(3, "%"+sqsld+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				student s = new student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setStype(rs.getString("stype"));
				s.setSnum(rs.getInt("snum"));
				s.setSic(rs.getInt("sic"));
				s.setSteacher(rs.getString("steacher"));
				s.setSqsmh(rs.getInt("sqsmh"));
				s.setSqsld(rs.getInt("sqsld"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

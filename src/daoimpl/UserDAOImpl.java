package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.User;

import utils.MysqlDB;

import dao.UserDAO;



public class UserDAOImpl implements UserDAO{

	Connection conn=MysqlDB.getconn();
	ResultSet rs=null;
	@Override
	//登录
	public boolean login(User u){
		boolean flag=false;
		try {
		conn=MysqlDB.getconn();
		String sql="select * from user where username=? and password=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	//添加
	public boolean addUser(User u) {
		boolean flag=false;
		String sql="insert into user(username,password)values(?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	//删除
	public boolean dalUser(int userid) {
		boolean flag=false;
		String sql="delete from user where userid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	//修改
	public boolean update(User u) {
		boolean flag=false;
		String sql="update  user set username=?,password=? where userid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setInt(3, u.getUserid());
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	@Override
   //查询所有
	public List findAllUser() {
		List list=new ArrayList();
		String sql="select * from user";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				User user =new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	//id查询
	public User findUserById(int id) {
		User u=new User();
		String sql="select * from user where userid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()){
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	@Override
	//模糊查询
	public List findUserBylike(String str) {
		List list=new ArrayList();
		String sql="select * from user where username like ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				User user =new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
}

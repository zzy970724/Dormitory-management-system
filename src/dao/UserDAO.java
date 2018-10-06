package dao;

import java.util.List;

import pojo.User;



public interface UserDAO {
	public boolean login(User u);//登录
	public boolean addUser(User u);//添加
	public boolean dalUser(int userid);//删除
	public boolean update(User u);//修改
	public List findAllUser();//查询所有
	public User findUserById(int id);//按ID查询
	public List findUserBylike(String str);//模糊查询
}

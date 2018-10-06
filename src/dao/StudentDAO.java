package dao;

import java.util.List;

import pojo.student;



public interface StudentDAO {
	public boolean addStudent(student s);//添加
	public boolean dalStudent(int sid);//删除
	public boolean update(student s);//修改
	public List findAllStudent();//查询所有
	public List findStudentByLike(String sname,int sid,int sqsld);//模糊查询

}

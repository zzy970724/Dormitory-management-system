package dao;

import java.util.List;

import pojo.student;



public interface StudentDAO {
	public boolean addStudent(student s);//���
	public boolean dalStudent(int sid);//ɾ��
	public boolean update(student s);//�޸�
	public List findAllStudent();//��ѯ����
	public List findStudentByLike(String sname,int sid,int sqsld);//ģ����ѯ

}

package dao;

import java.util.List;

import pojo.User;



public interface UserDAO {
	public boolean login(User u);//��¼
	public boolean addUser(User u);//���
	public boolean dalUser(int userid);//ɾ��
	public boolean update(User u);//�޸�
	public List findAllUser();//��ѯ����
	public User findUserById(int id);//��ID��ѯ
	public List findUserBylike(String str);//ģ����ѯ
}

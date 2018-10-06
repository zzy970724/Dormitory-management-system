package Test;

import java.util.Iterator;
import java.util.List;

import dao.StudentDAO;
import daoimpl.StudentDAOImpl;
import pojo.student;

public class test {

	public static void main(String[] args) {
		student st = new student();
		StudentDAO  sd = new StudentDAOImpl();
		
//		st.setSid(2);
//		st.setSname("ws");
//		st.setSnum(32);
//		st.setSteacher("po");
//		st.setStype("s");
//		st.setSqsld(1);
//		st.setSqsmh(2);
//		st.setSic(2);
//		boolean b = sd.addStudent(st);
//		System.out.println(b);
		
//		
//		st.setSid(2);
//		st.setSname("ws");
//		st.setSnum(32);
//		st.setSteacher("ÍõÈü");
//		st.setStype("s");
//		st.setSqsld(8);
//		st.setSqsmh(2);
//		st.setSic(2);
//		boolean b = sd.update(st);
//		System.out.println(b);
		
		List list = sd.findStudentByLike("Íõ", 9, 1);
		Iterator it = list.iterator();
		while(it.hasNext()){
			student s = (student)it.next();
			System.out.println(s.getSid());
			System.out.println(s.getSname());
			System.out.println(s.getSnum());
			System.out.println(s.getStype());
			System.out.println(s.getSic());
			System.out.println(s.getSteacher());
			System.out.println(s.getSqsmh());
			System.out.println(s.getSqsld());
		}
	}
}

package cn.zhku.jsj144.ssh.action;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.zhku.jsj144.ssh.entity.User;

public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add() {
		System.out.println("daoImpl...................add....");
		User user=new User();
		user.setUser_name("����");
		user.setUser_password("123");
		hibernateTemplate.save(user);//��Ӷ���
		
		System.out.println("daoImpl...................get....");
		//get��ѯ
		User user3 = hibernateTemplate.get(User.class,2l );
		System.out.println(user3.getUser_name());
		
		System.out.println("daoImpl...................find....");
		//find��ѯ
		List<User> list=(List<User>) hibernateTemplate.find("from User");
		for (User user2 : list) {
			System.out.println(user2.getUser_name());
		}
		
		System.out.println("daoImpl...................find.condition...");
		//find������ѯ
		List<User> list2 = (List<User>) hibernateTemplate.find("from User where user_name=?", "����");
		for (User user2 : list2) {
			System.out.println(user2.getUser_name());
		}
	}

}

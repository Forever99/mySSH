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
		user.setUser_name("张三");
		user.setUser_password("123");
		hibernateTemplate.save(user);//添加对象
		
		System.out.println("daoImpl...................get....");
		//get查询
		User user3 = hibernateTemplate.get(User.class,2l );
		System.out.println(user3.getUser_name());
		
		System.out.println("daoImpl...................find....");
		//find查询
		List<User> list=(List<User>) hibernateTemplate.find("from User");
		for (User user2 : list) {
			System.out.println(user2.getUser_name());
		}
		
		System.out.println("daoImpl...................find.condition...");
		//find条件查询
		List<User> list2 = (List<User>) hibernateTemplate.find("from User where user_name=?", "张三");
		for (User user2 : list2) {
			System.out.println(user2.getUser_name());
		}
	}

}

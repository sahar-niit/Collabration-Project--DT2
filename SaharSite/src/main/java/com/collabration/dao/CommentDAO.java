package com.collabration.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collabration.model.Blogs;
import com.collabration.model.Comments;


@Repository
public class CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ){
		this.sessionFactory = sessionFactory;
	}

	

	public Comments get(String id) {
		return this.sessionFactory.getCurrentSession().get(Comments.class, id);
	}


	public List<Comments> getComments(String blogId) {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Comments WHERE blogId=? ORDER BY commentedAt DESC").setParameter(0, blogId).list();
	}


	public void add(Comments comment) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}


	public void remove(Comments comment) {
		this.sessionFactory.getCurrentSession().remove(comment);
	}

}

package com.org.register.dao;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.register.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public RegisterDAOImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public Serializable save(RegisterEntity entity) {
		System.out.println("Invoking save method from DAOImpl");
		Session session = null;
		try {

			System.out.println("Session created");
			session = factory.openSession();
			System.out.println("Transaction begun");
			session.beginTransaction();
			System.out.println("Saving Entity...");
			session.save(entity);
			System.out.println("Commiting....");
			session.getTransaction().commit();
			System.out.println("Data saved in DATABASE SUCCESSFULLY.");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("Resources closed.");
			}

		}

		return entity;

	}

	public RegisterEntity fetchByEmail(String email) {
		System.out.println("Invoked fetchByEmail() ....");
		Session session = null;
		try {

			session = factory.openSession();

			System.out.println("fetching email from DB");
			String hql = "SELECT re from RegisterEntity re where email='" + email + "'";
			Query query = session.createQuery(hql);
			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("Email already Exits");
				RegisterEntity entity = (RegisterEntity) result;
				return entity;

			} else {
				System.out.println("Email is not duplicate,Will save.");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("Resources Closed.");
			}

		}
		return null;
	}

	public RegisterEntity fetchByNameAndPassword(String userName,String password) {
		Session session = null;
		try {
			session = factory.openSession();
			System.out.println("Invoked fetchBymailAndName()...");
			Query query = session.getNamedQuery("mailAndUserName");
			query.setParameter("n", userName);
			query.setParameter("e", password);
			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("Entity found:"+userName);
				RegisterEntity entity = (RegisterEntity) result;
				return entity;
			} else {
				System.out.println("Entity not found");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

}

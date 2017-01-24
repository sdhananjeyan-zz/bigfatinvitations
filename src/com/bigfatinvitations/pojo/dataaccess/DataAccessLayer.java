package com.bigfatinvitations.pojo.dataaccess;

import java.util.*;


import org.hibernate.Criteria;
import org.hibernate.Session;

public class DataAccessLayer<T> {
	
	public DataAccessLayer(Class<T> clazz,Session hbSession){
		session = hbSession;
		this.clazz = clazz;
	}
	
	Class<T> clazz;
	Session session;
	
	
	public boolean add(T obj){
		boolean result=true;
		try{
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
			result = false;
			session.getTransaction().rollback();
		}
		return result;
	}
	public boolean update(T obj){
		boolean result=true;
		try{
		
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = false;
			session.getTransaction().rollback();
		}
		return result;
	}
	public boolean remove(T obj){
		boolean result=true;
		try{
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			result = false;
		}
		return result;
	}
	public List<T> list(){
		List<T> result=new ArrayList<T>();
		try{
			session.beginTransaction();
			Criteria cr = session.createCriteria(Class.forName(clazz.getName()));
			result = cr.list();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = null;
			session.getTransaction().rollback();
		}
		return result;
	}
	
	public T retrive(Object id){
		
		T result=null;
		try{
			session.beginTransaction();
			if(id instanceof String)
				result = (T) session.load(Class.forName(clazz.getName()), id+"");
			else if(id instanceof Integer)
				result = (T) session.load(Class.forName(clazz.getName()), (Integer)id);
			else if(id instanceof Long)
				result = (T) session.load(Class.forName(clazz.getName()), (Long)id);
			else 
				result = null;
			
			session.getTransaction().commit();
			return result;
		}catch (Exception e) {
			result = null;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

}

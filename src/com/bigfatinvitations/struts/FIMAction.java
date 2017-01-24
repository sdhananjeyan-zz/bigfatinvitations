package com.bigfatinvitations.struts;

import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class FIMAction<T> extends ActionSupport implements SessionAware,ModelDriven<T>{

	/**
	 * Session Attributes as a Hash Map
	 */
	protected Map<String,Object> session;
	protected static final String FAILURE = "failure";
	protected static final String CAPTCHA = "captcha";
	protected T logic = (T)getLogic();
	/**
	 * should return the Model Object
	 * @return
	 */
	protected abstract T getLogic();
	
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
	public T getModel() {
		return logic;
	}
	@Override
	public String execute(){
		FIMInterface logic = (FIMInterface)this.logic;
		logic.setSession(session);
		logic.validate();
		if(logic.getMessages().size()>0){
			Iterator<String> it = logic.getMessages().iterator();
			while(it.hasNext())
				addActionError(it.next());
			return INPUT;
		}
		if(logic.execute()){
			session=logic.getSession();
			Iterator<String> it = logic.getMessages().iterator();
			while(it.hasNext())
				addActionMessage(it.next());
			return SUCCESS;
		} else {
			session = logic.getSession();
			Iterator<String> it = logic.getMessages().iterator();
			while(it.hasNext())
				addActionError(it.next());
			return FAILURE;
		}
	}
	/**
	 * To set the value of unique variable on request parameter
	 *  created for making browser not to catch the request
	 * @param unique
	 */
	public void setUnique(String unique){}

}

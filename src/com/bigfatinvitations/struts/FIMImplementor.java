package com.bigfatinvitations.struts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FIMImplementor {
	/**
	 * Message to be added on Action Error or Action Message
	 */
	protected List<String> messages = new ArrayList<String>();
	/**
	 * Jsp session as hash map
	 */
	protected Map<String,Object> session;
	
	/**
	 * Default execute method always returns true 
	 * @return
	 */
	public boolean execute() {
		return true;
	}

	//getters
	public Map<String, Object> getSession() {
		return session;
	}
	public List<String> getMessages() {
		return messages;
	}
	
	//setters
	public void setSession(Map<String, Object> session) {
		this.session  = session;
		
	}
	
	
	/**
	 * Default validate method, Do nothing 
	 */
	public void validate(){
		
	}
	
}

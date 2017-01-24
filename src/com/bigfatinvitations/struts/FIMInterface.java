package com.bigfatinvitations.struts;

import java.util.List;
import java.util.Map;

public interface FIMInterface {

	public static final String DEFAULT_ERROR = "something went wrong please try again ! ";
	public Map<String,Object> getSession();
	public void setSession(Map<String,Object> session);
	
	public void validate();
	public boolean execute();
	
	public List<String> getMessages();
	
}

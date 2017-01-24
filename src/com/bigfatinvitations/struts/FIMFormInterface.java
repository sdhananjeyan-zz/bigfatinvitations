package com.bigfatinvitations.struts;

public interface FIMFormInterface extends FIMInterface {
	
	public void validate();
	public void setRecaptchaResponse(String s);

}

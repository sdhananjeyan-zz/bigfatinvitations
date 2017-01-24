package com.bigfatinvitations.messages.actions;

import com.bigfatinvitations.messages.implementors.Adder;
import com.bigfatinvitations.messages.interfaces.Addable;
import com.bigfatinvitations.struts.FIMAction;

public class Add extends FIMAction<Addable>{

	@Override
	protected Addable getLogic() {
		return new Adder();
	}

}

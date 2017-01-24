package com.bigfatinvitations.messages.actions;

import com.bigfatinvitations.messages.implementors.Loader;
import com.bigfatinvitations.messages.interfaces.Loadable;
import com.bigfatinvitations.struts.FIMAction;

public class Load extends FIMAction<Loadable>{

	@Override
	protected Loadable getLogic() {
		return new Loader();
	}

}

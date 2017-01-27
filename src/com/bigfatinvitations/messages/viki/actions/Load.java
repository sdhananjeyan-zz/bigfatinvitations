package com.bigfatinvitations.messages.viki.actions;

import com.bigfatinvitations.messages.viki.implementors.Loader;
import com.bigfatinvitations.messages.viki.interfaces.Loadable;
import com.bigfatinvitations.struts.FIMAction;

public class Load extends FIMAction<Loadable>
{

    @Override
    protected Loadable getLogic()
    {
        return new Loader();
    }

}

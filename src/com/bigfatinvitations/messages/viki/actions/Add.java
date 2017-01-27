package com.bigfatinvitations.messages.viki.actions;

import com.bigfatinvitations.messages.viki.implementors.Adder;
import com.bigfatinvitations.messages.viki.interfaces.Addable;
import com.bigfatinvitations.struts.FIMAction;

public class Add extends FIMAction<Addable>
{

    @Override
    protected Addable getLogic()
    {
        return new Adder();
    }

}

package com.bigfatinvitations.messages.viki.interfaces;

import java.util.List;

import com.bigfatinvitations.pojo.MessageViki;
import com.bigfatinvitations.struts.FIMInterface;

public interface Loadable extends FIMInterface
{
    public List<List<MessageViki>> getWishes();
}

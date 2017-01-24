package com.bigfatinvitations.messages.interfaces;

import java.util.List;

import com.bigfatinvitations.pojo.Message;
import com.bigfatinvitations.struts.FIMInterface;

public interface Addable extends FIMInterface
{

    public List<List<Message>> getWishes();

    public void setMessage(Message message);
}

package com.bigfatinvitations.messages.implementors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.bigfatinvitations.hibernateutil.FactoryGenerator;
import com.bigfatinvitations.messages.interfaces.Addable;
import com.bigfatinvitations.pojo.Message;
import com.bigfatinvitations.pojo.dataaccess.DataAccessLayer;
import com.bigfatinvitations.pojo.dataaccess.MessagesDataAccess;
import com.bigfatinvitations.struts.FIMImplementor;

public class Adder extends FIMImplementor implements Addable
{

    private boolean result = true;

    private List<List<Message>> wishes = new ArrayList<List<Message>>();

    private Message message;

    @Override
    public List<List<Message>> getWishes()
    {
        return wishes;
    }

    @Override
    public boolean execute()
    {
        Session hbSession = FactoryGenerator.sessionFactory.openSession();
        try
        {
            DataAccessLayer<Message> oDc = new DataAccessLayer<Message>(Message.class, hbSession);
            oDc.add(message);
            MessagesDataAccess mDataAccess = new MessagesDataAccess();
            List<Message> msgs = mDataAccess.getAllMessages();
            Collections.sort(msgs);
            for (int i = 0; i < msgs.size();)
            {
                List<Message> messages = new ArrayList<>();
                try
                {
                    for (int j = 1; j <= 4; j++)
                    {
                        messages.add(msgs.get(i));
                        i++;
                    }
                    wishes.add(messages);
                }
                catch (IndexOutOfBoundsException e)
                {
                    wishes.add(messages);
                    break;
                }
            }

        }
        catch (Exception e)
        {
            result = false;
            e.printStackTrace();
        }
        finally
        {
            if (hbSession.isOpen())
            {
                hbSession.close();
            }
        }
        return result;
    }

    @Override
    public void setMessage(Message message)
    {
        this.message = message;
    }

}

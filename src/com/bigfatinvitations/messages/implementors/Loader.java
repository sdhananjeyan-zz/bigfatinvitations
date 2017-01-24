package com.bigfatinvitations.messages.implementors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.bigfatinvitations.hibernateutil.FactoryGenerator;
import com.bigfatinvitations.messages.interfaces.Loadable;
import com.bigfatinvitations.pojo.Message;
import com.bigfatinvitations.pojo.dataaccess.MessagesDataAccess;
import com.bigfatinvitations.struts.FIMImplementor;

public class Loader extends FIMImplementor implements Loadable
{

    private List<List<Message>> wishes = new ArrayList<List<Message>>();

    @Override
    public boolean execute()
    {
        Session hbSession = FactoryGenerator.sessionFactory.openSession();
        try
        {
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
            e.printStackTrace();
        }
        finally
        {
            if (hbSession.isOpen())
            {
                hbSession.close();
            }
        }
        return true;
    }

    @Override
    public List<List<Message>> getWishes()
    {
        return wishes;
    }
}

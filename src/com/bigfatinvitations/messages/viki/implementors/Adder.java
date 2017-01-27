package com.bigfatinvitations.messages.viki.implementors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.bigfatinvitations.hibernateutil.FactoryGenerator;
import com.bigfatinvitations.messages.viki.interfaces.Addable;
import com.bigfatinvitations.pojo.MessageViki;
import com.bigfatinvitations.pojo.dataaccess.DataAccessLayer;
import com.bigfatinvitations.pojo.dataaccess.MessageVikiDataAccess;
import com.bigfatinvitations.struts.FIMImplementor;

public class Adder extends FIMImplementor implements Addable
{

    private boolean result = true;

    private List<List<MessageViki>> wishes = new ArrayList<List<MessageViki>>();

    private MessageViki message;

    @Override
    public List<List<MessageViki>> getWishes()
    {
        return wishes;
    }

    @Override
    public boolean execute()
    {
        Session hbSession = FactoryGenerator.sessionFactory.openSession();
        try
        {
            DataAccessLayer<MessageViki> oDc = new DataAccessLayer<MessageViki>(MessageViki.class, hbSession);
            oDc.add(message);
            MessageVikiDataAccess mDataAccess = new MessageVikiDataAccess();
            List<MessageViki> msgs = mDataAccess.getAllMessages();
            Collections.sort(msgs);
            for (int i = 0; i < msgs.size();)
            {
                List<MessageViki> messages = new ArrayList<>();
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
    public void setMessage(MessageViki message)
    {
        this.message = message;
    }

}

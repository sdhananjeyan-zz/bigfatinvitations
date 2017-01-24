package com.bigfatinvitations.pojo.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bigfatinvitations.hibernateutil.FactoryGenerator;
import com.bigfatinvitations.pojo.Message;

public class MessagesDataAccess
{

    public List<Message> getAllMessages()
    {
        List messages = null;
        Session hbSession = FactoryGenerator.sessionFactory.openSession();
        hbSession.beginTransaction();
        try
        {
            Criteria cr = hbSession.createCriteria(Message.class);
            messages = cr.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            messages = null;
        }
        finally
        {
            hbSession.getTransaction().commit();
            hbSession.close();
        }
        return messages;
    }
}

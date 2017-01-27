package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bigfatinvitations.hibernateutil.FactoryGenerator;
import com.bigfatinvitations.pojo.MessageViki;
import com.bigfatinvitations.pojo.dataaccess.DataAccessLayer;
import com.bigfatinvitations.pojo.dataaccess.MessageVikiDataAccess;

public class Test
{

    public static void main(String args[])
    {
        Session hbSession = FactoryGenerator.sessionFactory.openSession();
        List<List<MessageViki>> wishes = new ArrayList<List<MessageViki>>();
        try
        {
            MessageViki message = new MessageViki();
            message.setName("Sakthi");
            message.setSubject("test wish");
            message.setId(1);
            message.setMessage("congratzzzzzz sandy from db");
            DataAccessLayer<MessageViki> oDc = new DataAccessLayer<MessageViki>(MessageViki.class, hbSession);
            oDc.add(message);
            MessageVikiDataAccess mDataAccess = new MessageVikiDataAccess();
            List<MessageViki> msgs = mDataAccess.getAllMessages();
            System.out.println(msgs);
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
            System.out.println(wishes);

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
    }
}

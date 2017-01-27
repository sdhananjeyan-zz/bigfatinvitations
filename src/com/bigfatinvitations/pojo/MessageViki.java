package com.bigfatinvitations.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_viki")
public class MessageViki implements Comparable
{

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String subject;
    private String message;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public int compareTo(Object o)
    {
        return Long.valueOf(((MessageViki) o).getId()).compareTo(Long.valueOf(id));
    }

}

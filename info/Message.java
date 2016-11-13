package fr.unice.iut.info;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class Message extends Observable implements Serializable
{
    final private String content;
    final private Date date;
    
    public Message (String Content)
    {
        content = Content;
        date = new Date();
    }
    
    public boolean equals (Object o)
    {
        return (o instanceof String) && content.equalsIgnoreCase((String) o);
    }
    
    public String toString ()
    {
        return "Message from " + date + " : " + content;
    }
}

package fr.unice.iut.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class Box extends Observable implements Serializable
{
    final private String name;
    final private ArrayList<Message> messageArrayList;
    
    public Box (String Name)
    {
        name = Name;
        messageArrayList = new ArrayList<Message>();
    }
    
    public Boolean contains (Object o)
    {
        for (Message m : messageArrayList)
        {
            if(m.equals(o))
            {
                return true;
            }
        }
        return false;
    }
    
    public Boolean emit (String newMessageContent)
    {
        if(this.contains(newMessageContent))
        {
            return false;
        }
        messageArrayList.add(new Message(newMessageContent));
        return true;
    }
    
    public Collection<Message> getAllMessages ()
    {
        return new ArrayList<Message>(messageArrayList);
    }
    
    public String toString ()
    {
        String nl = "\n";
        
        String res = "Box : " + name + nl;
        
        if(messageArrayList.isEmpty())
        {
            res += "> empty";
        }
        else
        {
            for (Message m : messageArrayList)
            {
                res += "> " + m + nl;
            }
        }
        
        return res;
    }
    
}

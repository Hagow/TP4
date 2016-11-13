package fr.unice.iut.info;

import java.io.Serializable;
import java.util.*;

public class Bus extends Observable implements Serializable
{
    final private String name;
    final private HashMap<String, Box> boxHashMap;
    
    public Bus (String Name)
    {
        name = Name;
        boxHashMap = new HashMap<String, Box>();
        boxHashMap.put("default", new Box("default"));
    }
    
    public Boolean createBox (String newBoxName)
    {
        if(boxHashMap.containsKey(newBoxName))
        {
            return false;
        }
        boxHashMap.put(newBoxName, new Box(newBoxName));
        return true;
    }
    
    public Boolean emit (String newMessageContent)
    {
        return boxHashMap.get("default").emit(newMessageContent);
    }
    
    public Boolean emit (String boxName, String newMessageContent)
    {
        if(!boxHashMap.containsKey(boxName))
        {
            return false;
        }
        return boxHashMap.get(boxName).emit(newMessageContent);
    }
    
    public Set<String> getBoxNames ()
    {
        return boxHashMap.keySet();
    }
    
    public Collection<Message> getAllMessages ()
    {
        ArrayList<Message> res = new ArrayList<Message>();
        for (Box b : boxHashMap.values())
        {
            res.addAll(b.getAllMessages());
        }
        return res;
    }
    
    public Collection<Message> getAllMessages (String boxName)
    {
        if(boxHashMap.containsKey(boxName))
        {
            return boxHashMap.get(boxName).getAllMessages();
        }
        return null;
    }
   
    public String toString ()
    {
        String nl = "\n";
        
        String res = "Bus : " + name + nl;
        
        if(boxHashMap.isEmpty())
        {
            res += "-> empty" + nl;
        }
        else
        {
            for (Box b : boxHashMap.values())
            {
                res += "-> " + b + nl;
            }
        }
        
        return res;
    }
    
}

package fr.unice.iut.info;

import java.io.Serializable;
import java.util.*;

public class BusManager extends Observable implements Serializable
{
    final private HashMap<String, Bus> busHashMap;
    
    public BusManager ()
    {
        busHashMap = new HashMap<String, Bus>();
        setChanged();
        notifyObservers();
    }
    
    public void Start()
    {
        setChanged();
        notifyObservers();
    }
    
    public Boolean createBus (String busName)
    {
        if(hasExistingBus(busName))
        {
            return false;
        }
        busHashMap.put(busName, new Bus(busName));
        
        setChanged();
        notifyObservers();
        
        return true;
    }
    
    public Boolean createBox (String busName, String newBoxName)
    {
        if(!busHashMap.containsKey(busName))
        {
            return false;
        }
        Boolean reussi = busHashMap.get(busName).createBox(newBoxName);
        
        setChanged();
        notifyObservers();
        
        return reussi;
    }
    
    public Boolean emit (String busName, String newMessageContent)
    {
        if(!busHashMap.containsKey(busName))
        {
            return false;
        }
        
        Boolean reussi = busHashMap.get(busName).emit(newMessageContent);
        
        setChanged();
        notifyObservers();
        
        return reussi;
    }
    
    public Boolean emit (String busName, String boxName, String newMessageContent)
    {
        if(!busHashMap.containsKey(busName))
        {
            return false;
        }
        
        Boolean reussi = busHashMap.get(busName).emit(boxName, newMessageContent);
        
        setChanged();
        notifyObservers();
        
        return reussi;
    }
    
    public Boolean hasExistingBus (String busName)
    {
        return busHashMap.containsKey(busName);
    }
    
    public Boolean hasExistingBox (String busName, String boxName)
    {
        return getAllBoxNames(busName).contains(boxName);
    }
    
    public Collection<Bus> getAllBus ()
    {
        return new ArrayList<Bus>(busHashMap.values());
    }
    
    public Set<String> getAllBusNames ()
    {
        return busHashMap.keySet();
    }
    
    public Set<String> getAllBoxNames (String busName)
    {
        if(hasExistingBus(busName))
        {
            return ((Bus) busHashMap.get(busName)).getBoxNames();
        }
        
        return null;
    }
    
    public Collection<Message> getAllMessages ()
    {
        ArrayList<Message> messageArrayList = new ArrayList<Message>();
        
        for (Bus bus : getAllBus())
        {
            messageArrayList.addAll(bus.getAllMessages());
        }
        return messageArrayList;
    }
    
    public Collection<Message> getAllMessages (String busName)
    {
        if(busHashMap.containsKey(busName))
        {
            return busHashMap.get(busName).getAllMessages();
        }
        return null;
    }
    
    public Collection<Message> getAllMessages (String busName, String boxName)
    {
        if(busHashMap.containsKey(busName))
        {
            return busHashMap.get(busName).getAllMessages(boxName);
        }
        return null;
    }
    
    public String toString ()
    {
        String nl = System.lineSeparator();
        
        String res = "";
        
        if(busHashMap.isEmpty())
        {
            res += "\n--> empty" + nl;
        }
        else
        {
            for (Bus b : busHashMap.values())
            {
                res += "\n--> " + b;
            }
        }
        
        return res + "\n===============\n\n";
    }
}
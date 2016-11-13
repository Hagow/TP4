package fr.unice.iut.info;

import java.io.*;

public class SerializationClass
{
    public void save (Object o, String fileName)
    {
        ObjectOutputStream oos = null;
        try
        {
            final FileOutputStream fichier = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(o);
            oos.flush();
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(oos != null)
                {
                    oos.flush();
                    oos.close();
                }
            }
            catch (final IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public Object read (String fileName)
    {
        ObjectInputStream ois = null;
        Object o = null;
        try
        {
            final FileInputStream fichier = new FileInputStream(fileName);
            ois = new ObjectInputStream(fichier);
            o = ois.readObject();
            System.out.println(o);
        }
        catch (final java.io.FileNotFoundException e)
        {
            System.out.println("Pas de précédentes sauvegarde");
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
        catch (final ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(ois != null)
                {
                    ois.close();
                }
            }
            catch (final IOException ex)
            {
                ex.printStackTrace();
                
            }
        }
        return o;
    }
}
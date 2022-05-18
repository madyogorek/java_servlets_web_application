
import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;


public class Log {

    //warning is thrown because of readObject()
    @SuppressWarnings("unchecked")
    public Vector<User> ReadObjectFromFile()
    {
        Vector<User> userv = null;
        try
        {

            FileInputStream fi = new FileInputStream("logfile.txt");

            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            userv = (Vector<User>) oi.readObject();

            oi.close();
            fi.close();
         }
        catch (FileNotFoundException e)
        {
  			     System.out.println("File not found");
  		  }
        catch (Exception ex)
        {

            ex.printStackTrace();

        }
        return userv;

    }

    public void WriteObjectToFile(Object serObj) {

        try
        {

            FileOutputStream fileOut = new FileOutputStream("logfile.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.flush();
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

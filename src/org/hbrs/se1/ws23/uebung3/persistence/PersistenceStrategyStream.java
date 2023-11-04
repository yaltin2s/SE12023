package org.hbrs.se1.ws23.uebung3.persistence;

import java.util.*;
import  java.io.*;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void openConnection() throws PersistenceException {

        try {

            fileInputStream= new FileInputStream(location);
            objectInputStream = new ObjectInputStream(fileInputStream);


            fileOutputStream= new FileOutputStream(location);
            objectOutputStream= new ObjectOutputStream(fileOutputStream);
            
        } catch (FileNotFoundException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,
                   "File not found!!!" );

        } catch (IOException e) {

            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,
                    "Not able to open Stream!!!!");

        }

    }

    @Override
    public void closeConnection() throws PersistenceException {

        try {
            if(fileInputStream!=null){fileInputStream.close();
            if(fileOutputStream != null){fileOutputStream.close();}
            if(objectInputStream != null){objectOutputStream.close();}
            if(objectOutputStream != null){objectOutputStream.close();}
            }
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Can not close the Stream!!!");
        }


    }

    @Override
    public void save(List<E> member) throws PersistenceException  {
        try{

            openConnection();
            objectOutputStream.writeObject(member);
            closeConnection();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,
                    "Can not save Stream!!!");
        }


    }

    @Override
    public List<E> load() throws PersistenceException  {
        // Some Coding hints ;-)

        ObjectInputStream ois = null;
        FileInputStream fis = null;
        List newListe =  null;

        try{
            fis = new FileInputStream(location);
            ois= new ObjectInputStream(fis);
        } catch (FileNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Error Loading File!!!");
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Error Opining the stream!!!");
        }

        Object object= null;
        try{
            object = objectInputStream.readObject();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Strategy is not set!!!!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found!!!",e);
        }
        if (object instanceof List<?>) {
            newListe = (List) object;
        }
        closeConnection();
        return newListe;
    }

    @Override
    public void save(ArrayList<E> memberList) {

    }
}

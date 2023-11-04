package org.hbrs.se1.ws23.uebung3.persistence;

import java.util.List;
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
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
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
    /**
     * Method for closing the connections to a stream
     */
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
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
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
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        // Some Coding hints ;-)

        ObjectInputStream ois = null;
        FileInputStream fis = null;
        List<E> newListe =  null;

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
        return null;
    }
}

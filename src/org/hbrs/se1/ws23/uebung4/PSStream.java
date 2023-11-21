package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceStrategyStream;

import java.io.*;
import java.util.List;

public class PSStream {

    PersistenceStrategyStream <UserStory> ss = new PersistenceStrategyStream<>();

    public void save(List<UserStory> l) throws PersistenceException {
        ss.openConnection();
        ss.save(l);
        ss.closeConnection();
    }

    /*
    public List<UserStory> loade () throws PersistenceException, IOException {

        ss.openConnection();
        List<UserStory> l = ss.load();
        //ss.closeConnection();
        return l;
     */

    public void close() throws PersistenceException {
        ss.closeConnection();
    }



    public List<UserStory> laden() throws PersistenceException, IOException {
        // Load the objects from stream
        List <UserStory> lesen = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("Users.ser"));
            // Create Streams here instead using "this.openConnection();"
            // Workaround!
            // fis = new FileInputStream( LOCATION );
            // ois = new ObjectInputStream( fis );

            // Auslesen der Liste
            Object obj = os.readObject();
            if (obj instanceof List<?>) {
                lesen = (List) obj;
            }
            System.out.println("LOG: Es wurden " + lesen.size() + " User Stories erfolgreich reingeladen!");
            return lesen;
        }
        catch (IOException e) {
            // Sup-Optimal, da Exeception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
            System.out.println(e.getMessage());

            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei!");
        }
        catch (ClassNotFoundException e) {
            // Chain of Responsbility erfuellt, durch Throw der Exceotion kann UI
            // benachrichtigt werden!
            System.out.println(e.getMessage());
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei! Class not found!");
        }
    }
}
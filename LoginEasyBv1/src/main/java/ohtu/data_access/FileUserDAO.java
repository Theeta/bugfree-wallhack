
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {
    
    private Scanner lukija;
    private File tiedosto;
    private List<User> users;
    
    public FileUserDAO(String filename){
        this.tiedosto = new File(filename);
        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            System.out.println("ei oo");
        }
        
        this.users = new ArrayList<User>();
        if (this.lukija == null) {
            return;
        }
        
        
        while (lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" ");
            users.add(new User(osat[0], osat[1]));
        }
    }

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.append(user.getUsername()+ " " + user.getPassword() + "\n");
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("jotain meni pieleen");
        }
        users.add(user);
    }
    
}

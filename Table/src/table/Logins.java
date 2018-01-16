package table;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dmitry
 */
public class Logins implements Serializable {

    public static String getCurrentLogin() {
        return currentLogin;
    }

    private ArrayList<String> login = new ArrayList<>();
    private ArrayList<String> password = new ArrayList<>();
    private String filename = "logins";
    private static String currentLogin = null;

    public static void setCurrentLogin(String login) {
        currentLogin = login;
    }

    private Logins() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            login = (ArrayList<String>) ois.readObject();
            password = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("consrtuctor File not found");
        } catch (IOException ex) {
            Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static boolean isAuth(String login, String password) {
        Logins INSTANCE = new Logins();
        int x = 0;
        boolean isLoginFound = false;
        for (int i = 0; i < INSTANCE.login.size(); i++) {
            if (login.equals(INSTANCE.login.get(i))) {
                x = i;
                isLoginFound = !isLoginFound;
                break;
            }
        }
        if (isLoginFound) {
            if (password.equals(INSTANCE.password.get(x))) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "User not found");
        return false;
    }

    public static void newUser(String login, String password) {
        if (isNewUser(login)) {
            Logins INSTANCE = new Logins();
            INSTANCE.login.add(login);
            INSTANCE.password.add(password);
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(INSTANCE.filename);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(INSTANCE.login);
                oos.writeObject(INSTANCE.password);
                JOptionPane.showMessageDialog(null, "User create");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Logins.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "User already create");
        }
    }

    public static boolean isNewUser(String login) {
        Logins INSTANCE = new Logins();
        for (int i = 0; i < INSTANCE.login.size(); i++) {
            if (login.equals(INSTANCE.login.get(i))) {
                return false;
            }
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author dmitry
 */
public class GUI {
    
    private static final Login LOGIN = new Login();
    private static final Registration REGISTRATION = new Registration();
    
    public static void setLoginVisible(boolean b){
        LOGIN.setVisible(b);
    }
    
    public static void setRegistrationVisible(boolean b){
        REGISTRATION.setVisible(b);
    }
}

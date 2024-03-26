/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadi;

import Connetction.dbconnect;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.First_view;


/**
 *
 * @author Nowar
 */
public class SHADI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        First_view f=new First_view();
        f.setVisible(true);
                }
    
}

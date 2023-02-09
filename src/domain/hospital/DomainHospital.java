/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domain.hospital;

import javax.swing.JFrame;

/**
 *
 * @author Tamar
 */
public class DomainHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                LoginUI login = new LoginUI();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setVisible(true);
            }
        });        
    }
    
}

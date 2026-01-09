/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygame;

/**
 *
 * @author yesho
 */
public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player player = new Player("Bai Yuechu");
        Partner partner = new Partner("Tu Shan Susu");
        
        System.out.println("Story begins...");
        System.out.println(player.getName() + " starts the journey.");
    }
    
}

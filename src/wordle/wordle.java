/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author athar
 */
public class wordle {
    static HashSet<String> set = new HashSet<>(); 
    static Scanner sc = new Scanner(System.in);
    
    boolean gameOver = false;
    int counter = 0;
    String wotd;
    
    public static void main(String[] args) {
        try{
            File myObj = new File("words.txt");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine())
                    set.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }
    
        wordle game = new wordle();
        
        game.wotd = set.iterator().next();
        System.out.println(game.wotd);
        while(game.counter != 6 && !game.gameOver){
            String a = sc.nextLine();
            if(a.length() != 5){
                System.out.println("5 letter words only!");
            }
            else if(!set.contains(a)){
                System.out.println("Not an actual word!");
            }
            else if(a.equals(game.wotd)){
                System.out.println("You win!");
                game.gameOver = true;
                break;
            }
            else{
                System.out.println("Close...");
            }
            game.counter++;
        }
        
        if(game.counter == 6 && !game.gameOver)
            System.out.println("Oops");
    }
}

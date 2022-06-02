/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pegSolitaire;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author athar
 */
public class ps {
    static boolean board[][] = new boolean[7][7];
    static HashSet<Integer> arr = new HashSet<>();
    
    public static void main(String[] args){
        arr.add(0);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        
        for (boolean[] row: board) 
            Arrays.fill(row, true);

        board[3][3] = false;
        
        ps game = new ps();
        game.display();
    }
    
    boolean check(int i, int j){
        return (arr.contains(i) && arr.contains(j));
    }
    
    void display(){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                if(check(i,j))
                    System.out.print("  ");
                else
                    System.out.print((board[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        System.out.println();    
    }
}

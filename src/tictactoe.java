import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class tictactoe {

	static char[] symbols = {' ', 'x', 'o'};
	static byte totalMoves = 0;
	static boolean pwin = false;
	static boolean cwin = false;
	static byte[] board = {1,1,1,1,1,1,1,1,1};
	static Integer[] moves = {0,1,2,3,4,5,6,7,8};
	static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		printBoard();
	    int inp;

	    while(true){
	    	System.out.print( "Press 1 to vs Player, 2 to vs Comp, 3 for help, 4 to quit: ");
	        inp = cin.nextInt();

	        switch(inp){
                    case 1:
                        initialize();
                        pGame();
                        break;
	            case 2:
	                initialize();
	                start();
	                break;
	            case 3:
	                help();
	                break;
	            case 4:
	                System.exit(0);
	            default:
	                System.out.print("Invalid input! Try again.\n");
	                break;
	        }
	    }
	}
	
        public static void pGame(){
            boolean turn = true;
            while(totalMoves <= 9 && !(pwin || cwin)){
	        printBoard();

	        int inp;
	        System.out.print("Enter box no.: ");
	        inp = cin.nextInt();

	        if(inp == 99)
	            return;
	        else if(inp < 0 || inp > 9 || board[inp] != 1){
	            System.out.print("Invalid input. Enter again!");
	        }
	        else{
	            board[inp] = (byte)(turn ? 2 : 3);
	            totalMoves++;
                    
                    turn = !turn;
                    
                    if(totalMoves >= 5){
                        int score = eval();
                        if(score == -10)
                            cwin = true;
                        else if(score == 10)
                            pwin = true;
                    }
	        }
	    }
            
            printBoard();

	    if(pwin)
	        System.out.print("\tPlayer 1 Wins!\n");
	    else if(cwin)
	        System.out.print("\tPlayer 2 Wins!\n");
	    else
	        System.out.print("\t    DRAW!\n");
        }	
	
	public static void initialize() {
            for(int i=0; i<9; i++)
	        board[i] = 1;

	    totalMoves = 0;
	    pwin = false;
	    cwin = false;
	    printBoard();
		
	}

	public static void printBoard() {        
        System.out.print("\n       Tic Tac Toe Game\n\t");
        System.out.print("+---+---+---+\n\t");
        for(int i=0; i<9; i++){
        	System.out.print("| " + symbols[board[i]-1] + " ");
            if((i+1) % 3 == 0)
            	System.out.print("|\n\t+---+---+---+\n\t");
        }
        System.out.println();
	}
	
	public static void help() {
		System.out.print("\nTic Tac Toe is a 2-player game where first player starts off with X followed by O by another player.\nThe positions on board are marked by numbers 0 to 8 starting from left corner as such -\n\t");
	    System.out.print("+---+---+---+\n\t");
	    for(int i=0; i<9; i++){
	        System.out.print("| "+ i + " ");
	        if((i+1) % 3 == 0)
	            System.out.print("|\n\t+---+---+---+\n\t");
	    }
	    System.out.println();
	}

	public static void start(){
	    while(totalMoves <= 9 && !(pwin || cwin)){
	        printBoard();

	        int inp;
	        System.out.print("Enter box no.: ");
	        inp = cin.nextInt();

	        if(inp == 99)
	            return;
	        else if(inp < 0 || inp > 9 || board[inp] != 1){
	            System.out.print("Invalid input. Enter again!");
	        }
	        else{
	            board[inp] = 2;
	            totalMoves++;

	            if(totalMoves >= 5){
                        int score = eval();
                        if(score == -10)
                            cwin = true;
                        else if(score == 10)
                            pwin = true;
                    }

	            if(!pwin && totalMoves <= 9){
	                pcMove();
	                totalMoves++;
	            }
	        }
	    }

	    printBoard();

	    if(pwin)
	        System.out.print("\tPlayer Wins!\n");
	    else if(cwin)
	        System.out.print("\tComputer Wins!\n");
	    else
	        System.out.print("\t    DRAW!\n");
	}

	public static void pcMove(){
	    int min_score = 999;
	    int box_no = 99;
	    
	    List<Integer> intList = Arrays.asList(moves);
		Collections.shuffle(intList);
		intList.toArray(moves);

	    for(int i : moves){
	        if(board[i] == 1){
	            board[i] = 3;
	            int score = minimax(totalMoves+1, true);
	            board[i] = 1;

	            if(score < min_score){
	                box_no = i;
	                min_score = score;
	            }
	        }
	    }

	    if(box_no != 99)
	    	board[box_no] = 3;

	    int check = eval();
	    if(check == -10)
	        cwin = true;
	    else if(check == 10)
	        pwin = true;
	}

	public static int minimax(int depth, boolean MaxPlayer){
	    int value = eval();
	    if(value == 10) return 10;
	    else if(value == -10) return -10;

	    if(depth == 9)
	        return value;

	    if(MaxPlayer){
	        int score = -999;

	        for(int i : moves){
	            if(board[i] == 1){
	                board[i] = 2;
	                score = Math.max(score, minimax(depth+1, false));
	                board[i] = 1;
	            }
	        }

	        return score;
	    }
	    else{
	        int score = 999;

	        for(int i : moves){
	            if(board[i] == 1){
	                board[i] = 3;
	                score = Math.min(score, minimax(depth+1, true));
	                board[i] = 1;
	            }
	        }

	        return score;
	    }
	}

	public static int eval(){
	    int x;
	    //row
	    for(int i=0; i<7; i += 3){
	        x = board[i] * board[i+1] * board[i+2];
	        if(x == 27){
	            return -10;
	        }
	        else if(x == 8){
	            return 10;
	        }
	    }

	    //column
	    for(int i=0; i<3; i++){
	        x = board[i] * board[i+3] * board[i+6];
	        if(x == 27){
	            return -10;
	        }
	        else if(x == 8){
	            return 10;
	        }
	    }

	    //diagonal
	    x = board[0] * board[4] * board[8];
	    if(x == 27){
	        return -10;
	    }
	    else if(x == 8){
	        return 10;
	    }

	    x = board[2] * board[4] * board[6];
	    if(x == 27){
	        return -10;
	    }
	    else if(x == 8){
	        return 10;
	    }

	    return 0;
	}
	
}

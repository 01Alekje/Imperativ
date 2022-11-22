import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        char[] board = createBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);



        while (!isFull(board)) {
            // -- Input ----------
            int input = getPlayerSelection(p1);
            // --- Process ----------
            board[input] = p1.mark;

            // check winner
            // -- Output --------
            plotBoard(board);
            if (checkWin(board, input, p1.mark)) {
                out.print("Someone won!");
                break;
            }

            if (isFull(board)) {
                break;
            }
        }

        out.println("Game over!");
        plotBoard(board);

        /*
        if (winner != null) {
            out.println("Winner is " + current.name);
        } else {
            out.println("Draw");
        }*/
    }


    // ---------- Methods  ----------------
    char[] createBoard(){
        char[] board = {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY};
        return board;
    }

    boolean isFull(char[] board){
        return false;   // For now return false
    }

    // ---------- IO Methods  ----------------

    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    boolean checkWin(char[] board, int input, char mark) {
        for (int i = 0; i < 6; i+=3) {
            int rowCount = 0;
            for (int j = 1; j < (board.length-i); j++) {
                if ((input >= j) && (board[input-j] == mark)) {
                    rowCount++;
                    if (rowCount == 3) {
                        return true; // should find all horizontal wins
                    }
                }
            }
        }

        return false;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String n, char m) {
            name = n;
            mark = m;
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);


        exit(0);
    }
}
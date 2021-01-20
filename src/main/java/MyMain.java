import java.util.*;

public class MyMain {
    // This method returns true/false if there 
    // was a boat the specified coordinates. This
    // method also prints out an appropriate message
    public static boolean hit(boolean[][] board, int row, int col) { 
        //two variables that show up in the board for the battleship game
        boolean T = true;
        boolean f = false;
        //setting as true for now but can be changed if no hit
        boolean x = true; 
        //if statements to check if coordinates given land on a T
        if (board[col][row] == T) {
            //return true;
            x = true;
        }
        if (board[col][row] == f) {
            //return false;
            x = false;
        }
        //returning x, could be true or false
        return x;
    }


    // Places a boat onto the board
    // The top-left piece of the board is located at (row, col)
    // The remaining pieces are placed in the direction given
    // by the direction input
    public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength, int row, int col) { 
        // YOUR CODE HERE
        //boolean values that will be placed, f is not necessary to make
        boolean T = true;
        //boolean f = false;
        
        board[row][col] = T;
        // 2 cases, 2 possible direction inputs, slight variation between both
        if (direction.equals("right")) {
            for (int i = 0; i < boatLength; i++) {
                board[row][col + i] = T;
            }
        }
        if (direction.equals("down")) {
            for (int i = 0; i < boatLength; i++) {
                board[row + i][col] = T;
            }
        }
        //returning altered board
        return board;
    }

    // Returns true if the every row in the 2D array
    // is in both alphabetical order and in order of 
    // increasing length
    // You may assume that all Strings are lowercase 
    public static boolean inOrder(String[][] words) { 
        //finding how many rows i will need to have in my for loop
        int row = words.length;
        int cols = words[0].length;
        //making a list to check if rows are longer or shorter
        List<Boolean> rows = new ArrayList<Boolean>();
        for (int i = 0; i < row; i++) {
            int col = words[i].length;
            for (int j = 0; j < col; j++) {
                if (words[i][j].length() > words[i+1][j].length()) {
                    rows.add(true);
                }
                else {
                    rows.add(false);
                }
            }
        }
        //making arrays for later
        String[][] xx = words;
        boolean[] arr = new boolean[row*cols];
        boolean[] arr2 = new boolean[row*cols];
        //making list for alphabetical order
        List<Boolean> alphabet = new ArrayList<Boolean>();
        for (int i = 0; i < row; i++){
            int col = words[i].length;
            //making it add true or false if they match
            for (int j = 0; j < col; j++) {
                Arrays.sort(xx[i]);
                if (words[i].equals(xx[i])) {
                    alphabet.add(true);
                }
                else {
                    alphabet.add(false);
                }
            }
        }
        boolean x = true;
        //making into array
        for (int i = 0; i < arr.length; i++) {
            boolean bou = alphabet.get(i);
            arr[i] = bou;  
        }
        for (int i = 0; i < arr.length; i++) {
            boolean bou = rows.get(i);
            arr2[i] = bou;  
        }
        //checking to see if they r equal
        for (int i = 0; i < row * cols; i++) {
            //boolean x = true;
            if (arr[i] = true) {
                x = true;
            }
            else {
                x = false;
            }
        }
        for (int i = 0; i < row * cols; i++) {
            //boolean x = true;
            if (arr2[i] = true) {
                x = true;
            }
            else {
                x = false;
            }
        }
        // YOUR CODE HERE
        return x;
    }

    public static void main(String[] args) {
        // You can test your code here
        int row = 2;
        int col = 2;
        int boatLength = 3;
        String direction = "right";
        boolean[][] board = { {true, true, false, false},
                            {false, true, false, false} };
        System.out.println(placeBoat(board, direction, boatLength, row, col));
        System.out.println(hit(board, row, col));
    }
}

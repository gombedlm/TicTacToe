import java.util.Scanner;

public class TicTacToe {

    //Declaration
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String [ROW][COL];

    // Utilities for the game
    private static void clearBoard()// Sets all board elements to a space
    {
        for(int row=0; row<ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()// Shows the Tic Tac Toe game used as part of the prompt for the users move choice
    {
        for(int row=0; row<ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                System.out.print("["+board[row][col] + "]");
            }
            System.out.println();
        }
    }

    // Check valid moves
    private static boolean isValidMove(int row, int col)// returns true if there is a space at the given proposed move coordinates which means it is a legal move
    {
        return board[row][col].equals(" ");
    }

    // Check valid wins
    private static boolean isWin(String player) // checks to see if there is a win state on the current board for the specified player X or O this method in turn calls three additional methods that break down the 3 kinds of wins that are possible
    {
        return (isColWin(player) || isRowWin(player) || isDiagonalWin(player));
    }

    // Check valid Column win
    private static boolean isColWin(String player)// checks for a col win for a specified player
    {
        if(board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        if(board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player))
        {
            return true;
        }
        if(board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        return false;
    }

    // Check valid Row win
    private static boolean isRowWin(String player)// checks for a row win for a specified player
    {

        if(board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)){
            return true;
        }
        if(board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)){
            return true;
        }
        if(board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)){
            return true;
        }
        return false;
    }

    // Check valid Diagonal win
    private static boolean isDiagonalWin(String player)// checks for a diagonal win for a specified player
    {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if(board[1][1].equals(player) && board[0][2].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)// main method of the class
    {
	    //Declaration
        Scanner in = new Scanner(System.in);
        int row;
        int col;
        boolean endChoice;

        // Main loop for restarting the game
        while(true)
        {
            String player;
            endChoice = SafeInput.getYNConfirm(in,"Would you like to play?");
            System.out.println();

            // If the user chooses to play
            if(endChoice)
            {
                player = "X";
                int moves = 0;
                int watcher;
                clearBoard();
                System.out.println();
                System.out.println("\nHello and Welcome!\n\nYou may return to the main menu at any time by typing \"quit\" Enjoy!\n");
                System.out.println();


                // Game loop
                while(true)
                {
                    // Show the board
                    System.out.println();
                    display();
                    System.out.println();
                    System.out.print("\nCurrent Player: "+player);
                    System.out.println();

                    // Input

                    // Get input for the row and check for and end statement
                    row = SafeInput.getRangedInt(in, "\nPlease enter which row you would like to select (Up-Down)", 1,3);
                    watcher = row;
                    if(watcher == -1)
                    {
                        break;
                    }

                    // Get input for the column and check for and end statement
                    col = SafeInput.getRangedInt(in, "\nPlease enter which column you would like to select (Left-Right)", 1,3);
                    watcher = col;
                    if(watcher == -1)
                    {
                        break;
                    }

                    // Correct the move to coincide with the boards coordinates
                    row = row - 1;
                    col = col - 1;


                    // Processing and Output

                    // Check if a valid move was made by either player
                    if(isValidMove(row,col))
                    {

                        System.out.println("\nValid Move");

                        // Check which player made the move
                        if(player.equals("O"))
                        {
                            board[row][col] = player;
                            // Check for win conditions
                            if (moves >= 4)
                            {

                                if (isWin(player))
                                {
                                    display();
                                    System.out.println("\nWinner!: "+player);
                                    break;
                                }
                            }

                            // Check for win conditions
                            if (moves >= 7)
                            {

                                if (!isWin(player))
                                {
                                    display();
                                    System.out.println("\nTie!");
                                    break;
                                }
                                else
                                {
                                    display();
                                    System.out.println("\nWinner!: "+player);
                                    break;
                                }

                            }

                            player = "X";
                            moves++;
                        }
                        // Check which player made the move
                        else
                        {
                            board[row][col] = player;

                            // Check for win conditions
                            if (moves >= 4)
                            {
                                if (isWin(player))
                                {
                                    display();
                                    System.out.println("\nWinner!: "+player);
                                    break;
                                }
                            }

                            // Check for win conditions
                            if (moves >= 7)
                            {
                                if (!isWin(player))
                                {
                                    display();
                                    System.out.println("\nTie!");
                                    break;
                                }
                                else
                                {
                                    display();
                                    System.out.println("\nWinner!: "+player);
                                    break;
                                }
                            }
                            player = "O";
                            moves++;
                        }
                    }
                    else
                    {
                        System.out.println("\nInvalid Move:");
                    }
                }
            }

            // exit the game if the play chooses to do so and display a message for them
            else
            {
                System.out.println("\n\nThank you for playing come again!\n\n");
                break;
            }
        }
    }
}
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Check if the position is valid
            if (row < 0 || col < 0 || row > 2 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
            } else {
                board[row][col] = currentPlayer;
                printBoard();

                // Check if the game is over
                if (hasWon(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    // Switch player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean hasWon(char player) {
        // Rows, Columns, and Diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}

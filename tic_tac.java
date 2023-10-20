import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    static char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode;
        System.out.println("1. Computer VS Player");
        System.out.println("2. Player VS Player");
        System.out.println("Select game mode");
        mode = scanner.nextInt();
        switch (mode) {
            case 1:
                computerVsPlayer();
                break;
            case 2:
                playerVsPlayer();
                break;
            default:
                System.out.println("Please select a valid game mode");
                break;
        }
        scanner.close();
    }

    public static void computerVsPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String player_name = scanner.next();
        while (true) {
            clearScreen();
            showBoard();
            if (countBoard('X') == countBoard('O')) {
                System.out.println(player_name + "'s turn.");
                getXPlayerChoice();
            } else {
                getComputerChoice();
            }

            char winner = checkWinner();
            if (winner == 'X') {
                clearScreen();
                showBoard();
                System.out.println(player_name + " Won the game.");
                break;
            } else if (winner == 'O') {
                clearScreen();
                showBoard();
                System.out.println("Computer won the game.");
                break;
            } else if (winner == 'D') {
                System.out.println("Game is Draw.");
                break;
            }
        }
        scanner.close();
    }

    public static void playerVsPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter X player name: ");
        String x_player_name = scanner.next();
        System.out.print("Enter O player name: ");
        String o_player_name = scanner.next();
        while (true) {
            clearScreen();
            showBoard();
            if (countBoard('X') == countBoard('O')) {
                System.out.println(x_player_name + "'s turn.");
                getXPlayerChoice();
            } else {
                System.out.println(o_player_name + "'s turn.");
                getOPlayerChoice();
            }
            char winner = checkWinner();
            if (winner == 'X') {
                clearScreen();
                showBoard();
                System.out.println(x_player_name + " Won the game.");
                break;
            } else if (winner == 'O') {
                clearScreen();
                showBoard();
                System.out.println(o_player_name + " Won the game.");
                break;
            } else if (winner == 'D') {
                System.out.println("Game is Draw.");
                break;
            }
        }
        scanner.close();
    }

    public static void getComputerChoice() {
        Random random = new Random();
        int choice;
        do {
            choice = random.nextInt(9);
        } while (board[choice] != ' ');
        board[choice] = 'O';
    }

    public static void getXPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select your position (1-9):");
            int choice = scanner.nextInt();
            choice--;
            if (choice < 0 || choice > 8) {
                System.out.println("Please select your choice from (1-9).");
            } else if (board[choice] != ' ') {
                System.out.println("Please select an empty position.");
            } else {
                board[choice] = 'X';
                break;
            }
        }
        scanner.close();
    }

    public static void getOPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select your position (1-9):");
            int choice = scanner.nextInt();
            choice--;
            if (choice < 0 || choice > 8) {
                System.out.println("Please select your choice from (1-9).");
            } else if (board[choice] != ' ') {
                System.out.println("Please select an empty position.");
            } else {
                board[choice] = 'O';
                break;
            }
        }
        scanner.close();
    }

    public static int countBoard(char symbol) {
        int total = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == symbol) {
                total++;
            }
        }
        return total;
    }

    public static char checkWinner() {
        if (board[0] == board[1] && board[1] == board[2] && board[0] != ' ') return board[0];
        if (board[3] == board[4] && board[4] == board[5] && board[3] != ' ') return board[3];
        if (board[6] == board[7] && board[7] == board[8] && board[6] != ' ') return board[6];
        if (board[0] == board[3] && board[3] == board[6] && board[0] != ' ') return board[0];
        if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ') return board[1];
        if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ') return board[2];
        if (board[0] == board[4] && board[4] == board[8] && board[0] != ' ') return board[0];
        if (board[2] == board[4] && board[4] == board[6] && board[2] != ' ') return board[2;
        if (countBoard('X') + countBoard('O') < 9) return 'C';
        else return 'D';
    }

    public static void showBoard() {
        System.out.println("     |     |     ");
        System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
        System.out.println("     |     |     \n");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

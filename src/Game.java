import java.util.Scanner;
import java.io.IOException;

public class Game {

    static boolean[][] board = new boolean[7][6];


    public static void displayBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static boolean isOccupied(int x, int y) {
        return board[x][y];
    }

    public static void addTokenToCell(int x, int y) {
        board[x][y] = true;
    }

    public static void dropToken(int x) {
        boolean top = isOccupied(x, 0);
        if (top) return;
        int curr = 0;
        for (int i = 1; i < 6; i++) {
            if (isOccupied(x, i)) {
                addTokenToCell(x, curr);
                return;
            }
            curr++;
        }
        addTokenToCell(x, 5);
    }

    public static void main(String[] arg) {
        Game game = new Game();
        game.start();
    }

    private static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("GAME STARTED!");
        System.out.println();
        displayBoard();
        System.out.println("Enter the row (0-6): ");
        int x = sc.nextInt();
        clearScreen();
        displayBoard();

    }


}

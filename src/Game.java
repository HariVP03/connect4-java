import java.util.Scanner;

public class Game {

    static int[][] board = new int[7][6];
    static int player = 1;

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
        return board[x][y] != 0;
    }

    public static void addTokenToCell(int x, int y) {
        if (player != 1 && player != 2)
            return;
        board[x][y] = player;
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

    private static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private static void displayMenu() {
        if (player == 1)
            System.out.println("Enter the row (0-6) for player 1 or enter 9 to exit: ");
        else if (player == 2)
            System.out.println("Enter the row (0-6) for player 2 or enter 9 to exit: ");
        else
            System.out.println("Wrong Player");
    }

    private static void togglePlayer() {
        player = player == 1 ? 2 : 1;
    }

    public static void main(String[] arg) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            clearScreen();
            displayBoard();
            displayMenu();

            int c = sc.nextInt();
            System.out.println(c);
            if (c >= 0 && c <= 6) {
                System.out.println("dropped token");
                dropToken(c);
                System.out.println(board[0][5]);
            } else if (c == 9) {
                break;
            } else
                System.out.println("Invalid Input");
            togglePlayer();
        }
    }
}

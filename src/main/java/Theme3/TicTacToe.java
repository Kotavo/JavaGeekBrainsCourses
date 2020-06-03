package Theme3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /*
    Game settings block
     */
    private static char[][] map;    // matrix of the game
    private static int size = 3;     // field dimension

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public TicTacToe() {
    }


    public void gameRun() {
        int x = 0;
        System.out.println("Choose game mode: " + '\n' +
            "1) Easy" + "\n" +
            "2) Hard ");
        do {
            x = scanner.nextInt();

        } while (x != 1 && x != 2);

        initMap();
        printMap();

        if (x == 1) {
            while (true) {

                humanTurn();
                if (isEndGame(DOT_X)) {
                    break;
                }

                simpleComputerTurn();
                if (isEndGame(DOT_O)) {
                    break;
                }

            }
        } else {
            while (true) {

                humanTurn();
                if (isEndGame(DOT_X)) {
                    break;
                }

                hardComputerTurn();
                if (isEndGame(DOT_O)) {
                    break;
                }

            }
        }

        System.out.println("Game over");
    }


    /*
    Initialization of the playing field
     */
    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /*
    Print game field to console
     */
    private static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    Logic for human turn
     */
    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Enter the coordinates");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /*
    Method for validating input coordinates
     */
    private static boolean isCellValid(int x, int y) {
        boolean flag = true;

        if (x < 0 || x >= size || y < 0 || y >= size) {
            flag = false;
        }
        if (map[y][x] != DOT_EMPTY) {
            flag = false;
        }
        return flag;
    }

    /*
    Method to check games end
     */

    private static boolean isEndGame(char symbol) {
        boolean flag = false;

        printMap();

        // Checking the need for the next turn
        if (checkWin(symbol)) {
            System.out.println(symbol + " Won");
            flag = true;
        }

        if (isMapFull()) {
            System.out.println("friendship won )");
            flag = true;
        }
        return flag;
    }

    /*
    Checking the fullness of the playing field
     */
    private static boolean isMapFull() {
        boolean flag = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean checkWin(char symbol) {
        boolean flag = false;

        if (
            (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) ||
                (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) ||
                (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) ||
                (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) ||
                (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) ||
                (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) ||
                (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) ||
                (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol)
        ) {
            flag = true;
        }
        return flag;
    }

    /*
    Logic for simple computer turn
     */
    private static void simpleComputerTurn() {
        int x = -1;
        int y = -1;

        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        }
        while (!isCellValid(x, y));

        System.out.println("Computer put O into ( " + (y + 1) + " " + (x + 1) + " )");
        map[y][x] = DOT_O;
    }

    /*
    Method to hard mode computer turn
     */
    private static void hardComputerTurn() {
        int x = -1;
        int y = -1;
        int[] turn = new int[2];
        turn = iCanIWin();
        if (turn[0] != -1 && turn[1] != -1) {
            x = turn[0];
            y = turn[1];
            System.out.println("Computer put O into ( " + (x + 1) + " " + (y + 1) + " )");
            map[x][y] = DOT_O;
        } else {
            turn = iCanLose();
            if (turn[0] != -1 && turn[1] != -1) {
                x = turn[0];
                y = turn[1];
                System.out.println("Computer put O into ( " + (x + 1) + " " + (y + 1) + " )");
                map[x][y] = DOT_O;
            } else {
                if (map[1][1] == DOT_EMPTY) {
                    System.out.println("Computer put O into ( " + 2 + " " + 2 + " )");
                    map[1][1] = DOT_O;
                } else {
                    if (map[0][0] == DOT_EMPTY) {
                        System.out.println("Computer put O into ( " + 1 + " " + 1 + " )");
                        map[0][0] = DOT_O;
                    } else {
                        if (map[2][2] == DOT_EMPTY) {
                            System.out.println("Computer put O into ( " + 3 + " " + 3 + " )");
                            map[2][2] = DOT_O;
                        } else {
                            if (map[0][2] == DOT_EMPTY) {
                                System.out.println("Computer put O into ( " + 1 + " " + 3 + " )");
                                map[0][2] = DOT_O;
                            } else {
                                if (map[2][0] == DOT_EMPTY) {
                                    System.out.println("Computer put O into ( " + 3 + " " + 1 + " )");
                                    map[2][0] = DOT_O;
                                } else {
                                    do {
                                        x = random.nextInt(size);
                                        y = random.nextInt(size);
                                    }
                                    while (!isCellValid(x, y));
                                    System.out.println("Computer put O into ( " + (y + 1) + " " + (x + 1) + " )");
                                    map[y][x] = DOT_O;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    Checking can the computer win right now?
     */
    private static int[] iCanIWin() {
        int[] turn = new int[2];
        turn[0] = -1;
        turn[1] = -1;

        if (map[0][0] == DOT_O && map[0][1] == DOT_O && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        if (map[0][1] == DOT_O && map[0][2] == DOT_O && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][0] == DOT_O && map[0][2] == DOT_O && map[0][1] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 1;
            return turn;
        }

        if (map[1][0] == DOT_O && map[1][1] == DOT_O && map[1][2] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 2;
            return turn;
        }

        if (map[1][1] == DOT_O && map[1][2] == DOT_O && map[1][0] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 0;
            return turn;
        }

        if (map[1][0] == DOT_O && map[1][2] == DOT_O && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][0] == DOT_O && map[2][1] == DOT_O && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[2][1] == DOT_O && map[2][2] == DOT_O && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[2][0] == DOT_O && map[2][2] == DOT_O && map[2][1] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 1;
            return turn;
        }

        if (map[0][0] == DOT_O && map[1][0] == DOT_O && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[0][0] == DOT_O && map[2][0] == DOT_O && map[1][0] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 0;
            return turn;
        }

        if (map[2][0] == DOT_O && map[1][0] == DOT_O && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][1] == DOT_O && map[1][1] == DOT_O && map[2][1] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 1;
            return turn;
        }

        if (map[0][1] == DOT_O && map[2][1] == DOT_O && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][1] == DOT_O && map[1][1] == DOT_O && map[0][1] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 1;
            return turn;
        }

        if (map[0][2] == DOT_O && map[1][2] == DOT_O && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[0][2] == DOT_O && map[2][2] == DOT_O && map[1][2] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 2;
            return turn;
        }

        if (map[2][2] == DOT_O && map[1][2] == DOT_O && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        if (map[0][0] == DOT_O && map[1][1] == DOT_O && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[0][0] == DOT_O && map[2][2] == DOT_O && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][2] == DOT_O && map[1][1] == DOT_O && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][2] == DOT_O && map[1][1] == DOT_O && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[2][2] == DOT_O && map[2][0] == DOT_O && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[1][1] == DOT_O && map[2][0] == DOT_O && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        return turn;
    }

    /*
    Checking can the computer lose right now?
     */
    private static int[] iCanLose() {
        int[] turn = new int[2];
        turn[0] = -1;
        turn[1] = -1;

        if (map[0][0] == DOT_X && map[0][1] == DOT_X && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        if (map[0][1] == DOT_X && map[0][2] == DOT_X && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][0] == DOT_X && map[0][2] == DOT_X && map[0][1] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 1;
            return turn;
        }

        if (map[1][0] == DOT_X && map[1][1] == DOT_X && map[1][2] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 2;
            return turn;
        }

        if (map[1][1] == DOT_X && map[1][2] == DOT_X && map[1][0] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 0;
            return turn;
        }

        if (map[1][0] == DOT_X && map[1][2] == DOT_X && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][0] == DOT_X && map[2][1] == DOT_X && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[2][1] == DOT_X && map[2][2] == DOT_X && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[2][0] == DOT_X && map[2][2] == DOT_X && map[2][1] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 1;
            return turn;
        }

        if (map[0][0] == DOT_X && map[1][0] == DOT_X && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[0][0] == DOT_X && map[2][0] == DOT_X && map[1][0] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 0;
            return turn;
        }

        if (map[2][0] == DOT_X && map[1][0] == DOT_X && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][1] == DOT_X && map[1][1] == DOT_X && map[2][1] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 1;
            return turn;
        }

        if (map[0][1] == DOT_X && map[2][1] == DOT_X && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][1] == DOT_X && map[1][1] == DOT_X && map[0][1] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 1;
            return turn;
        }

        if (map[0][2] == DOT_X && map[1][2] == DOT_X && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[0][2] == DOT_X && map[2][2] == DOT_X && map[1][2] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 2;
            return turn;
        }

        if (map[2][2] == DOT_X && map[1][2] == DOT_X && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        if (map[0][0] == DOT_X && map[1][1] == DOT_X && map[2][2] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 2;
            return turn;
        }

        if (map[0][0] == DOT_X && map[2][2] == DOT_X && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[2][2] == DOT_X && map[1][1] == DOT_X && map[0][0] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 0;
            return turn;
        }

        if (map[0][2] == DOT_X && map[1][1] == DOT_X && map[2][0] == DOT_EMPTY) {
            turn[0] = 2;
            turn[1] = 0;
            return turn;
        }

        if (map[0][2] == DOT_X && map[2][0] == DOT_X && map[1][1] == DOT_EMPTY) {
            turn[0] = 1;
            turn[1] = 1;
            return turn;
        }

        if (map[1][1] == DOT_X && map[2][0] == DOT_X && map[0][2] == DOT_EMPTY) {
            turn[0] = 0;
            turn[1] = 2;
            return turn;
        }

        return turn;
    }
}







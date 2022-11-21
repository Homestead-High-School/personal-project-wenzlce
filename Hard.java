import java.util.*;

public class Hard {
    private String[][] board = new String[9][9];
    private String[][] checkB = new String[9][9];
    Map<String, ArrayList<String>> notes = new HashMap<String, ArrayList<String>>();
    private String[][] finalB = { { " 6 ", " 7 ", " 9 ", " 3 ", " 8 ", " 4 ", " 5 ", " 1 ", " 2 " },
            { " 8 ", " 3 ", " 1 ", " 2 ", " 5 ", " 7 ", " 6 ", " 4 ", " 9 " },
            { " 5 ", " 4 ", " 2 ", " 9 ", " 6 ", " 1 ", " 8 ", " 3 ", " 7 " },
            { " 4 ", " 2 ", " 5 ", " 8 ", " 7 ", " 3 ", " 9 ", " 6 ", " 1 " },
            { " 7 ", " 6 ", " 3 ", " 4 ", " 1 ", " 9 ", " 2 ", " 8 ", " 5 " },
            { " 9 ", " 1 ", " 8 ", " 6 ", " 2 ", " 5 ", " 3 ", " 4 ", " 7 " },
            { " 1 ", " 9 ", " 7 ", " 5 ", " 3 ", " 8 ", " 4 ", " 2 ", " 6 " },
            { " 3 ", " 5 ", " 6 ", " 7 ", " 4 ", " 2 ", " 1 ", " 9 ", " 8 " },
            { " 2 ", " 8 ", " 4 ", " 1 ", " 9 ", " 6 ", " 7 ", " 5 ", " 3 " } };
    // int fails = 0;

    public Hard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " _ ";
            }
        }
        board[0][1] = " 7 ";
        board[0][5] = " 4 ";
        board[0][6] = " 5 ";
        board[1][2] = " 1 ";
        board[1][3] = " 2 ";
        board[1][5] = " 7 ";
        board[2][1] = " 4 ";
        board[2][4] = " 6 ";
        board[2][6] = " 8 ";
        board[3][2] = " 5 ";
        board[3][4] = " 7 ";
        board[3][7] = " 6 ";
        board[4][3] = " 4 ";
        board[4][5] = " 9 ";
        board[5][0] = " 9 ";
        board[5][3] = " 6 ";
        board[5][7] = " 7 ";
        board[5][8] = " 4 ";
        board[6][2] = " 7 ";
        board[6][4] = " 3 ";
        board[6][6] = " 4 ";
        board[7][0] = " 3 ";
        board[7][8] = " 8 ";
        board[8][0] = " 2 ";
        board[8][2] = " 4 ";
        board[8][6] = " 7 ";
        board[8][7] = " 5 ";
        board[8][8] = " 3 ";

        for (int i = 0; i < checkB.length; i++) {
            for (int j = 0; j < checkB[i].length; j++) {
                checkB[i][j] = " _ ";
            }
        }
        checkB[0][1] = " 7 ";
        checkB[0][5] = " 4 ";
        checkB[0][6] = " 5 ";
        checkB[1][2] = " 1 ";
        checkB[1][3] = " 2 ";
        checkB[1][5] = " 7 ";
        checkB[2][1] = " 4 ";
        checkB[2][4] = " 6 ";
        checkB[2][6] = " 8 ";
        checkB[3][2] = " 5 ";
        checkB[3][4] = " 7 ";
        checkB[3][7] = " 6 ";
        checkB[4][3] = " 4 ";
        checkB[4][5] = " 9 ";
        checkB[5][0] = " 9 ";
        checkB[5][3] = " 6 ";
        checkB[5][7] = " 7 ";
        checkB[5][8] = " 4 ";
        checkB[6][2] = " 7 ";
        checkB[6][4] = " 3 ";
        checkB[6][6] = " 4 ";
        checkB[7][0] = " 3 ";
        checkB[7][8] = " 8 ";
        checkB[8][0] = " 2 ";
        checkB[8][2] = " 4 ";
        checkB[8][6] = " 7 ";
        checkB[8][7] = " 5 ";
        checkB[8][8] = " 3 ";

    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {

            if (i == 3 || i == 6) {
                System.out.println("   _________|_________|_________");
            }
            if (i == 0) {
                System.out.println("              COL             ");
                System.out.println("    0  1  2   3  4  5   6  7  8 ");
            }

            for (int j = 0; j < board[i].length; j++) {
                if (i == 3 && j == 0) {
                    System.out.print("R ");
                } else if (i == 4 && j == 0) {
                    System.out.print("O ");
                } else if (i == 5 && j == 0) {
                    System.out.print("W ");
                } else if (j == 0) {
                    System.out.print("  ");
                }
                if (j == 0) {
                    // System.out.print(" ");
                    System.out.print(+i);
                }

                if (j == 3 || j == 6) {
                    System.out.print("|");
                }
                System.out.print(board[i][j]);

            }
            System.out.println();
            // System.out.println("_");
        }
        System.out.println();
    }

    public void printOriginalBoard() {
        for (int i = 0; i < checkB.length; i++) {

            if (i == 3 || i == 6) {
                System.out.println("   _________|_________|_________");
            }
            if (i == 0) {
                System.out.println("              COL             ");
                System.out.println("    0  1  2   3  4  5   6  7  8 ");
            }

            for (int j = 0; j < checkB[i].length; j++) {
                if (i == 3 && j == 0) {
                    System.out.print("R ");
                } else if (i == 4 && j == 0) {
                    System.out.print("O ");
                } else if (i == 5 && j == 0) {
                    System.out.print("W ");
                } else if (j == 0) {
                    System.out.print("  ");
                }
                if (j == 0) {
                    // System.out.print(" ");
                    System.out.print(+i);
                }

                if (j == 3 || j == 6) {
                    System.out.print("|");
                }
                System.out.print(checkB[i][j]);

            }
            System.out.println();
            // System.out.println("_");
        }
        System.out.println();
    }

    public void insertVal(int r, int c, String n, int trys) {
        if (board[r][c].equals(" _ ")) {
            if (isValid(r, c, n) == true) {
                board[r][c] = " " + n + " ";
            }
        } else {
            System.out.println("Number already here! ");
        }
        printBoard();
    }

    public void replaceVal(String cn, int ro, int co, int tys) {
        if (checkB[ro][co].equals(" _ ") && isValid(ro, co, cn) == true) {
            // if(isValid(ro, co, cn))
            board[ro][co] = " " + cn + " ";
        } else {
            System.out.println("Unreplaceable");
        }
    }

    public boolean isValid(int r, int c, String n) {

        boolean ret = true;
        Set<String> checkC = new HashSet<String>();
        Set<String> checkR = new HashSet<String>();
        Set<String> checkS = new HashSet<String>();

        for (int f = 0; f < board.length; f++) {
            checkR.add(board[r][f]);
        }
        if (checkR.contains(" " + n + " ")) {
            ret = false;
        }
        for (int i = 0; i < board.length; i++) {
            checkC.add(board[i][c]);
        }
        if (checkC.contains(" " + n + " ")) {
            ret = false;
        }
        int g = 0;
        int k = 0;
        if (r >= 0 && r < 3) {
            g = 0;
        } else if (r > 2 && r < 6) {
            g = 3;
        } else if (r > 5 && r < 9) {
            g = 6;
        }

        if (c >= 0 && c < 3) {
            k = 0;
            ;
        } else if (c > 2 && c < 6) {
            k = 3;
        } else if (c > 5 && c < 9) {
            k = 6;
        }

        // check fro every check in insert and tell where wrong

        for (int o = 0; o < 3; o++) {
            for (int h = 0; h < 3; h++) {
                checkS.add(board[g + o][k + h]);
            }
        }
        if (checkS.contains(" " + n + " ")) {
            ret = false;
        }
        return ret;
    }

    public boolean finishedBoard() {
        boolean r = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" _ ")) {
                    r = false;
                }
            }
        }
        return r;
    }

    public ArrayList<String> MakeNotes(String combined, String note) {

        // Map<String, ArrayList<String>> notes = new HashMap<String,
        // ArrayList<String>>();
        if (notes.containsKey(combined)) {
            // notes.add(combined,note)
            notes.get(combined).add(note);
        } else if (!note.equals("1") || !note.equals("2") || !note.equals("3") || !note.equals("4") || !note.equals("5")
                || !note.equals("6") || !note.equals("7") || !note.equals("8") || !note.equals("9")) {
            System.out.println("Invalid note number! ");
        } else {
            notes.put(combined, new ArrayList<String>());
            notes.get(combined).add(note);
        }
        return notes.get(combined);

    }

    public ArrayList<String> RemoveNotes(String roww, String coll, String nnote) {

        // Map<String, ArrayList<String>> notes = new HashMap<String,

        String comb = roww + coll;
        if (notes.containsKey(comb)) {
            // notes.add(combined,note)
            notes.get(comb).remove(nnote);
        }
        return notes.get(comb);

    }

    public void PrintNotes() {

        for (String d : notes.keySet()) {
            System.out.println(d + ": " + notes.get(d));
        }

    }

}

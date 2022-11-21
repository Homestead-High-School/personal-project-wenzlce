import java.util.Scanner;

class Sudoko {
  public static void main(String[] args) {
    System.out.println(
        "\n\nWelcome to Sudoko!\nThis is a commonly played game that anyone can play\nThe goal of the game is to fill up the entire board with numbers\nTo do this you have to insert and replace numbers so that the number placed in does not have \n   1) the number already in its row \n   2) the number already in its column \n   3) the number already in its 3x3 square\nYou only have 3 mistakes allowed so make sure you do not insert an incorrect value!\n ");
    String next = " ";

    Scanner iput = new Scanner(System.in);
    while (!next.equals("EG")) {
      /*
       * if (next.equals("EG") || tries == 3) {
       * System.out.println("What would you like to play? easy/medium/hard: ");
       * ans = iput.nextLine();
       * }
       */

      System.out.println("What would you like to play? easy/medium/hard: ");

      String ans = iput.nextLine();
      int tries = 0;

      if (ans.equals("easy")) {

        // Scanner input = new Scanner(System.in);
        Easy easy = new Easy();
        easy.printBoard();
        String num = " ";
        boolean con = false;

        while (!next.equals("EG")) {
          if (easy.finishedBoard() == true) {
            System.out.println("You won the easy game!!!");
            break;
          }
          if (tries == 3) {
            break;
          }
          Scanner pt = new Scanner(System.in);
          System.out.println(
              "What would you like to do? \nInsert Value (IV)\nReplace Value (RV)\nEnd game (EG)\nSee Original Board (SOB)\nMake note (MN)\nRemove note (RN)\nSee all notes (SAN)  ");
          next = pt.nextLine();

          if (next.equals("RV")) {
            System.out.println("Enter number to replace with: ");
            String cnn = pt.nextLine();
            System.out.println("Enter row to replace: ");
            int rr = pt.nextInt();
            System.out.println("Enter column to replace: ");
            int rc = pt.nextInt();
            // hihfihe
            easy.replaceVal(cnn, rr, rc, tries);

            easy.printBoard();
          } else if (next.equals("IV")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number: ");
            num = input.nextLine();
            while (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")
                && !num.equals("6") && !num.equals("7") && !num.equals("8") && !num.equals("9")) {
              System.out.println("Enter a number: ");
              num = input.nextLine();
            }
            System.out.println("Enter a row: ");
            int row = input.nextInt();
            while (row > 8) {
              System.out.println("Enter a row: ");
              row = input.nextInt();
            }
            System.out.println("Enter a column: ");
            int col = input.nextInt();
            while (col > 8) {
              System.out.println("Enter a column: ");
              col = input.nextInt();
            }
            con = easy.isValid(row, col, num);
            while (con != true) {
              Scanner put = new Scanner(System.in);
              System.out.println("Incorrect");
              tries += 1;
              System.out.println("You have " + tries + "/3 mistakes ");

              if (tries == 3) {
                System.out.println("You failed lol");
                break;

              }
              easy.printBoard();
              System.out.println("Enter a number: ");
              num = put.nextLine();
              System.out.println("Enter a row: ");
              row = put.nextInt();
              while (row > 8) {
                System.out.println("Enter a row: ");
                row = put.nextInt();
              }
              System.out.println("Enter a column: ");
              col = input.nextInt();
              while (col > 8) {
                System.out.println("Enter a column: ");
                col = input.nextInt();
              }
              con = easy.isValid(row, col, num);
            }
            easy.insertVal(row, col, num, tries);
            // break;
          } else if (next.equals("SOB")) {
            easy.printOriginalBoard();
          }
          // insert in other classes
          else if (next.equals("MN")) {
            System.out.println("Here you can make notes for each spot on the board");
            Scanner ipt = new Scanner(System.in);
            System.out.println("Enter row of note");
            String rw = ipt.nextLine();
            System.out.println("Enter column of note");
            String cm = ipt.nextLine();
            String combined = rw + cm;
            // remove spaces with what we have learned??
            System.out.println("Enter note to be added");
            String note = ipt.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(easy.MakeNotes(combined, note));

          } else if (next.equals("RN")) {
            System.out.println("Here you can remove notes from board spaces");
            Scanner idk = new Scanner(System.in);
            System.out.println("Enter row of note");
            String roww = idk.nextLine();
            System.out.println("Enter column of note");
            String coll = idk.nextLine();

            // remove spaces with what we have learned??
            System.out.println("Enter note to be removed");
            String nnote = idk.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(easy.RemoveNotes(roww, coll, nnote));

          } else if (next.equals("SAN")) {
            easy.PrintNotes();
            System.out.println();

          }

        }

        // break;

        /*
         * while (con != true && tries < 4) {
         * tries += 1;
         * System.out.print("Incorrect");
         * }
         * 
         * 
         * if (tries == 3) {
         * System.out.println("You're done");
         * 
         * }
         * //easy.insertVal(row, col, num, tries);
         */

      } else if (ans.equals("medium")) {
        Medium med = new Medium();
        med.printBoard();
        String num = " ";
        boolean con = false;

        while (!next.equals("EG")) {
          if (med.finishedBoard() == true) {
            System.out.println("You won the easy game!!!");
            break;
          }
          if (tries == 3) {
            break;
          }
          Scanner pt = new Scanner(System.in);
          System.out.println(
              "What would you like to do? \nInsert Value (IV)\nReplace Value (RV)\nEnd game (EG)\nSee Original Board (SOB)\nMake note (MN)\nRemove note (RN)\nSee all notes (SAN)  ");
          next = pt.nextLine();

          if (next.equals("RV")) {
            System.out.println("Enter number to replace with: ");
            String cnn = pt.nextLine();
            System.out.println("Enter row to replace: ");
            int rr = pt.nextInt();
            System.out.println("Enter column to replace: ");
            int rc = pt.nextInt();
            // hihfihe
            med.replaceVal(cnn, rr, rc, tries);

            med.printBoard();
          } else if (next.equals("IV")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number: ");
            num = input.nextLine();
            while (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")
                && !num.equals("6") && !num.equals("7") && !num.equals("8") && !num.equals("9")) {
              System.out.println("Enter a number: ");
              num = input.nextLine();
            }
            System.out.println("Enter a row: ");
            int row = input.nextInt();
            while (row > 8) {
              System.out.println("Enter a row: ");
              row = input.nextInt();
            }
            System.out.println("Enter a column: ");
            int col = input.nextInt();
            while (col > 8) {
              System.out.println("Enter a column: ");
              col = input.nextInt();
            }
            con = med.isValid(row, col, num);
            while (con != true) {
              Scanner put = new Scanner(System.in);
              System.out.println("Incorrect");
              tries += 1;
              System.out.println("You have " + tries + "/3 mistakes ");

              if (tries == 3) {
                System.out.println("You failed lol");
                break;

              }
              med.printBoard();
              System.out.println("Enter a number: ");
              num = put.nextLine();
              System.out.println("Enter a row: ");
              row = put.nextInt();
              while (row > 8) {
                System.out.println("Enter a row: ");
                row = put.nextInt();
              }
              System.out.println("Enter a column: ");
              col = input.nextInt();
              while (col > 8) {
                System.out.println("Enter a column: ");
                col = input.nextInt();
              }
              con = med.isValid(row, col, num);
            }
            med.insertVal(row, col, num, tries);
            // break;
          } else if (next.equals("SOB")) {
            med.printOriginalBoard();
          } else if (next.equals("MN")) {
            System.out.println("Here you can make notes for each spot on the board");
            Scanner ipt = new Scanner(System.in);
            System.out.println("Enter row of note");
            String rw = ipt.nextLine();
            System.out.println("Enter column of note");
            String cm = ipt.nextLine();
            String combined = rw + cm;
            // remove spaces with what we have learned??
            System.out.println("Enter note to be added");
            String note = ipt.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(med.MakeNotes(combined, note));

          } else if (next.equals("RN")) {
            System.out.println("Here you can remove notes from board spaces");
            Scanner idk = new Scanner(System.in);
            System.out.println("Enter row of note");
            String roww = idk.nextLine();
            System.out.println("Enter column of note");
            String coll = idk.nextLine();

            // remove spaces with what we have learned??
            System.out.println("Enter note to be removed");
            String nnote = idk.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(med.RemoveNotes(roww, coll, nnote));

          } else if (next.equals("SAN")) {
            med.PrintNotes();
            System.out.println();

          }

        }
      } else if (ans.equals("hard")) {
        Hard hard = new Hard();
        hard.printBoard();
        String num = " ";
        boolean con = false;

        while (!next.equals("EG")) {
          if (hard.finishedBoard() == true) {
            System.out.println("You won the easy game!!!");
            break;
          }
          if (tries == 3) {
            break;
          }
          Scanner pt = new Scanner(System.in);
          System.out.println(
              "What would you like to do? \nInsert Value (IV)\nReplace Value (RV)\nEnd game (EG)\nSee Original Board (SOB)\nMake note (MN)\nRemove note (RN)\nSee all notes (SAN)  ");
          next = pt.nextLine();

          if (next.equals("RV")) {
            System.out.println("Enter number to replace with: ");
            String cnn = pt.nextLine();
            System.out.println("Enter row to replace: ");
            int rr = pt.nextInt();
            System.out.println("Enter column to replace: ");
            int rc = pt.nextInt();
            // hihfihe
            hard.replaceVal(cnn, rr, rc, tries);

            hard.printBoard();
          } else if (next.equals("IV")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number: ");
            num = input.nextLine();
            while (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")
                && !num.equals("6") && !num.equals("7") && !num.equals("8") && !num.equals("9")) {
              System.out.println("Enter a number: ");
              num = input.nextLine();
            }
            System.out.println("Enter a row: ");
            int row = input.nextInt();
            while (row > 8) {
              System.out.println("Enter a row: ");
              row = input.nextInt();
            }
            System.out.println("Enter a column: ");
            int col = input.nextInt();
            while (col > 8) {
              System.out.println("Enter a column: ");
              col = input.nextInt();
            }
            con = hard.isValid(row, col, num);
            while (con != true) {
              Scanner put = new Scanner(System.in);
              System.out.println("Incorrect");
              tries += 1;
              System.out.println("You have " + tries + "/3 mistakes ");
              if (tries == 3) {
                System.out.println("You failed lol");
                break;

              }
              hard.printBoard();
              System.out.println("Enter a number: ");
              num = put.nextLine();
              System.out.println("Enter a row: ");
              row = put.nextInt();
              while (row > 8) {
                System.out.println("Enter a row: ");
                row = put.nextInt();
              }
              System.out.println("Enter a column: ");
              col = input.nextInt();
              while (col > 8) {
                System.out.println("Enter a column: ");
                col = input.nextInt();
              }
              con = hard.isValid(row, col, num);
            }
            hard.insertVal(row, col, num, tries);
            // break;
          } else if (next.equals("SOB")) {
            hard.printOriginalBoard();
          } else if (next.equals("MN")) {
            System.out.println("Here you can make notes for each spot on the board");
            Scanner ipt = new Scanner(System.in);
            System.out.println("Enter row of note");
            String rw = ipt.nextLine();
            System.out.println("Enter column of note");
            String cm = ipt.nextLine();
            String combined = rw + cm;
            // remove spaces with what we have learned??
            System.out.println("Enter note to be added");
            String note = ipt.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(hard.MakeNotes(combined, note));

          } else if (next.equals("RN")) {
            System.out.println("Here you can remove notes from board spaces");
            Scanner idk = new Scanner(System.in);
            System.out.println("Enter row of note");
            String roww = idk.nextLine();
            System.out.println("Enter column of note");
            String coll = idk.nextLine();

            // remove spaces with what we have learned??
            System.out.println("Enter note to be removed");
            String nnote = idk.nextLine();
            System.out.println("Now the notes for this row/column are: ");
            System.out.println(hard.RemoveNotes(roww, coll, nnote));

          } else if (next.equals("SAN")) {
            hard.PrintNotes();
            System.out.println();

          }

        }
      } else {
        System.out.println("Enter valid game");
      }
      // easy.printBoard();
      next = " ";
    }

  }
}
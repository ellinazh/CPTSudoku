
// The "GraphicsScrabb" class.
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import hsa.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadyTest {

    static Console c;           // The output console
//private Scanner s;
    // The "2" class.
    // The output console
    //import java.util.Scanner;

    /**
     *
     * @author e.ruiya
     *
     *
     *
     */
    /**
     * @param args the command Diction arguments
     */
    public static void main(String[] args) {
        ArrayList<String> Diction = new ArrayList<>();
        //FileReader fr = new FileReader("english3.txt");

        try {

            Scanner s = new Scanner(new File("english3.txt"));
            for (int i = 0; i < Diction.size(); i++) {
                while (s.hasNextLine()) {

                    Diction.add(s.nextLine().toUpperCase());
                    //System.out.println(line.get(i));
                }
                s.close();
            }
        } catch (IOException e) {
            System.out.println("error");
        }
        //System.out.println(Diction.get(300));

        //Notes
        //Fix the using other letters from ValidMove2
        //Dictionary issues...--> Bring up with Morrison, dictionary has length of 0 therefore no terms present
        //Currently skiping dictionary check...
        //Also probably have to check ValidMove4..fixed with UseOtherLetters
        //Blank tile function....Mostly done
        //Print out points on the side --> refer to Musty's code
        //If have time put an end screen
        //Idk how to print anything on console so just tell M to do it
        c = new Console(100, 100);
        c.print("Hello");
        Color background = new Color(204, 0, 0);
        Color tilecolor = new Color(255, 255, 204);
        Color tilecolor2 = new Color(255, 255, 153);
        String[] gameinfo = new String[3];
        String name1 = "";
        String name2 = "";
        String word_1;
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        String[] Letters = Alphabet.split("");

        String[][] board = new String[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = ".";
            }
        }
        //Triple Word Squares
        board[0][0] = "9";
        board[7][0] = "9";
        board[14][0] = "9";
        board[0][7] = "9";
        board[0][14] = "9";
        board[7][14] = "9";
        board[14][7] = "9";
        board[14][14] = "9";

        //Double Word Squares
        Color DoubleWord = new Color(255, 102, 102);
        c.setColor(DoubleWord);
        board[7][7] = "1";
        board[1][1] = "8";
        board[1][13] = "8";
        board[2][2] = "8";
        board[2][12] = "8";
        board[3][3] = "8";
        board[3][11] = "8";
        board[4][4] = "8";
        board[4][10] = "8";
        board[10][4] = "8";
        board[10][10] = "8";
        board[11][3] = "8";
        board[11][11] = "8";
        board[12][2] = "8";
        board[12][12] = "8";
        board[13][1] = "8";
        board[13][13] = "8";
        //board [112] [470] = "8";

        //Triple Letter Squares
        Color TripleLetter = new Color(0, 0, 153);
        c.setColor(TripleLetter);
        board[1][5] = "7";
        board[1][9] = "7";
        board[13][5] = "7";
        board[13][9] = "7";
        board[5][1] = "7";
        board[9][1] = "7";
        board[5][13] = "7";
        board[9][13] = "7";
        board[5][5] = "7";
        board[9][9] = "7";
        board[9][5] = "7";
        board[5][9] = "7";
        //board [223] [470] = "7";

        //Double Letter Squares
        Color DoubleLetter = new Color(51, 204, 255);
        c.setColor(DoubleLetter);
        board[3][0] = "6";
        board[11][0] = "6";
        board[3][14] = "6";
        board[11][14] = "6";
        board[0][3] = "6";
        board[0][11] = "6";
        board[14][3] = "6";
        board[14][11] = "6";
        board[3][7] = "6";
        board[11][7] = "6";
        board[7][3] = "6";
        board[7][11] = "6";
        board[2][6] = "6";
        board[12][6] = "6";
        board[6][2] = "6";
        board[6][12] = "6";
        board[2][8] = "6";
        board[12][8] = "6";
        board[8][2] = "6";
        board[8][12] = "6";
        board[6][6] = "6";
        board[8][8] = "6";
        board[8][6] = "6";
        board[6][8] = "6";
        //board [334] [470] = "6";
        /*String[] array = */
        introduction(board);

        /*if(!array[0].equals("1"))
         {
         name1 = array[0];
         name2 = array[1];
         turn = Integer.parseInt(array[2].toString());
         }
         c.print(array[0]);*/
        int xcoordinate = 0;
        int ycoordinate = 0;
        int coordination = 0;
        int[] Letter_num = {9, 2, 2, 3, 15, 2, 2, 2, 8, 1, 1, 5, 3, 6, 6, 2, 1, 6, 6, 6, 6, 2, 1, 1, 1, 1, 1};
        int[] Letter_value = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10, 10, 10, 10, 0};
        //Loop
        int Player_1_points = 0;
        int Player_2_points = 0;
        int start = -1;
        ArrayList Player_1_rack = new ArrayList();
        ArrayList Player_2_rack = new ArrayList();
        int turns = 0;
        String[] word_3 = new String[0];
        String word_4 = "";
        Player_1_rack = Racks(Letter_num, Letters, Player_1_rack, turns, word_4, Diction, xcoordinate, ycoordinate, coordination, word_3, start, board); //int[] letters_num, String[] letters, ArrayList RackLetters, int turns,String word2,ArrayList Diction,int xcoordinate,int ycoordinate,int coordination,,String[] word) {
        Player_2_rack = Racks(Letter_num, Letters, Player_2_rack, turns, word_4, Diction, xcoordinate, ycoordinate, coordination, word_3, start, board);
        turns = 1;
        //c.print ("");
        //c.println ("Enter number of total turns");

        int ans = 0;
        int turn = 0;
        char answer;
        start = 0;

        c.setColor(Color.white);
        c.setTextBackgroundColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Number of Turns: ", 470, 490);
        c.setCursor(29, 77);
        turn = c.readInt();
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.setColor(Color.black);

        player1tiles(Player_1_rack, Letters, Letter_value);
        player2tiles(Player_2_rack, tilecolor2, Letter_value, Letters);

        while (turns <= turn) {

            /*
             c.print ("");
             c.print ("Enter placement of the first letter of the word");
             c.print ("x-coordinate(how many spaces to the right)");
             */
            //Might have to split based on Player to satisfy the graphics
            /*
             xcoordinate = c.readInt ();
             //c.print ("y-coordinate(how many spaces down");
             ycoordinate = c.readInt ();
             //c.print ("Is the word horizontal of vertical");
             //c.print ("1-Horizontal");
             //c.print ("2-Vertical");
             coordination = c.readInt ();
             //c.print ("Enter word");
             word_1 = c.readLine ();
             String[] word_2 = word_1.split ("");
             */
            //Empty letter --> go find past code on gmail or something
            if ((turns % 2) == 1) {
                turns = Player_1_turn(tilecolor2, turns, Player_1_rack, Diction, start, board, Letter_num, Letters, Player_2_rack, Letter_value, Player_1_points, Player_2_points);
            }
            if (turns % 2 == 0) {
                turns = Player_2_turn(tilecolor2, turns, Player_1_rack, Diction, start, board, Letter_num, Letters, Player_2_rack, Letter_value, Player_2_points, Player_1_points);
            }

        }
        if (Player_1_points > Player_2_points) {
            //c.print ("Congatulations Player 1 wins!");
        } else if (Player_1_points < Player_2_points) {
            //c.print ("Congratulations Player 2 wins!");
        } else {
            //c.print ("It's a tie!");
        }
    }

    public static int Player_1_turn(Color tilecolor2, int turns, ArrayList Player_1_rack, ArrayList Diction, int start, String[][] board, int[] Letter_num, String[] Letters, ArrayList Player_2_rack, int[] Letter_value, int Player_1_points, int Player_2_points) {
        char ans;
        ans = redraw1(tilecolor2);
        if (ans == 'Y') {
            Player_1_rack = Redrawletters(Letter_num, Letters, Player_1_rack, turns);
            //int[] letters_num, String[] letters, ArrayList RackLetters, int turns
            player1tiles(Player_1_rack, Letters, Letter_value);
            turns++;

            Player_2_turn(tilecolor2, turns, Player_1_rack, Diction, start, board, Letter_num, Letters, Player_2_rack, Letter_value, Player_2_points, Player_1_points);
            return turns;
        } else {
            String[] info = Word1(tilecolor2);
            int coordination;
            int ycoordinate;
            int xcoordinate;
            String COORDINATION = info[0];
            if (COORDINATION.equals("H")) {
                coordination = 1;
            } else {
                coordination = 2;
            }
            String word_1;
            word_1 = WORD1();
            String[] word_2 = word_1.split("");
            xcoordinate = Integer.parseInt(info[1].toString());
            ycoordinate = Integer.parseInt(info[2].toString());
            String NewLetter = "";
            if (EmptyLetter(word_2)) {
                //c.print ("What letter do you want the blank square to be");
                NewLetter = Empty1();
                for (int i = 0; i < word_2.length; i++) {
                    if (word_2[i].equals("_")) {
                        word_2[i] = NewLetter;
                        word_1 = Arrays.toString(word_2);
                        word_2[i] = "_";
                    }
                }

            }

            if (ValidMove(xcoordinate, ycoordinate, coordination, word_2, turns, Player_1_rack, Diction, word_1, start, board)) { //int xcoordinate, int ycoordinate, int coordination, String[] word,ValidMove2(ArrayListRack,String[] word,ArrayListDiction,String word2)
                //
                for (int i = 0; i < word_2.length; i++) {
                    if (word_2[i].equals("_")) {
                        word_2[i] = NewLetter;
                    }
                }
                Player_1_rack = Racks(Letter_num, Letters, Player_1_rack, turns, word_1, Diction, xcoordinate, ycoordinate, coordination, word_2, start, board);
                Player_2_rack = Racks(Letter_num, Letters, Player_2_rack, turns, word_1, Diction, xcoordinate, ycoordinate, coordination, word_2, start, board);
                //Statements to add points onto the two players score continuously
                Player_1_points = Player_1_points + Points(Letter_value, Letters, Player_1_points, word_2, xcoordinate, ycoordinate, coordination, start, board);
                //Points_Drawing1(Player_1_points);
                System.out.println("Player 1 Points:" + Player_1_points);
                //Adding points up to here
                for (int i = 0; i < word_2.length; i++) {
                    if (coordination == 1) {
                        board[(ycoordinate - 1)][(xcoordinate + i - 1)] = word_2[i];
                    } else {
                        board[(ycoordinate + i - 1)][(xcoordinate - 1)] = word_2[i];
                    }
                }
                board_placement2(word_2, COORDINATION, xcoordinate * 30, ycoordinate * 30, tilecolor2);

                player1tiles(Player_1_rack, Letters, Letter_value);
                turns++;
                start++;
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid input", 510, 485);
                turns++;
            }
        }
        return turns;
    }

    public static int Player_2_turn(Color tilecolor2, int turns, ArrayList Player_1_rack, ArrayList Diction, int start, String[][] board, int[] Letter_num, String[] Letters, ArrayList Player_2_rack, int[] Letter_value, int Player_2_points, int Player_1_points) {
        char ans;
        ans = redraw2(tilecolor2);
        if (ans == 'Y') {
            Player_2_rack = Redrawletters(Letter_num, Letters, Player_1_rack, turns);
            //int[] letters_num, String[] letters, ArrayList RackLetters, int turns
            player2tiles(Player_2_rack, tilecolor2, Letter_value, Letters);
            turns++;

            Player_1_turn(tilecolor2, turns, Player_1_rack, Diction, start, board, Letter_num, Letters, Player_2_rack, Letter_value, Player_1_points, Player_2_points);
            return turns;
        } else {
            String[] info = Word2(tilecolor2);
            int coordination;
            int ycoordinate;
            int xcoordinate;
            String COORDINATION = info[0];
            if (COORDINATION.equals("H")) {
                coordination = 1;
            } else {
                coordination = 2;
            }
            String word_1;
            word_1 = WORD2();
            String[] word_2 = word_1.split("");
            xcoordinate = Integer.parseInt(info[1].toString());
            ycoordinate = Integer.parseInt(info[2].toString());
            String NewLetter = "";
            if (EmptyLetter(word_2)) {
                //c.print ("What letter do you want the blank square to be");
                NewLetter = Empty2();
                for (int i = 0; i < word_2.length; i++) {
                    if (word_2[i].equals("_")) {
                        word_2[i] = NewLetter;
                        word_1 = Arrays.toString(word_2);
                        word_2[i] = "_";
                    }
                }

            }
//System.out.println(ValidMove(xcoordinate, ycoordinate, coordination, word_2, turns, Player_2_rack, Diction, word_1, start, board)+ "*******");
            if (ValidMove(xcoordinate, ycoordinate, coordination, word_2, turns, Player_2_rack, Diction, word_1, start, board)) { //int xcoordinate, int ycoordinate, int coordination, String[] word,ValidMove2(ArrayListRack,String[] word,ArrayListDiction,String word2)
                //Note: Make sure there is only oen blank tile
                for (int i = 0; i < word_2.length; i++) {
                    if (word_2[i].equals("_")) {
                        word_2[i] = NewLetter;
                    }
                }
                //
                Player_1_rack = Racks(Letter_value, Letters, Player_1_rack, turns, word_1, Diction, xcoordinate, ycoordinate, coordination, word_2, start, board);
                Player_2_rack = Racks(Letter_value, Letters, Player_2_rack, turns, word_1, Diction, xcoordinate, ycoordinate, coordination, word_2, start, board);
                //Statements to add points onto the two players score continuously
                Player_2_points = Player_2_points + Points(Letter_value, Letters, Player_2_points, word_2, xcoordinate, ycoordinate, coordination, start, board);
                System.out.println("Player 2 Points: " + Player_2_points);
                //Points_Drawing2(Player_2_points);
                //Adding points up to here
                for (int i = 0; i < word_2.length; i++) {
                    if (coordination == 1) {
                        board[(ycoordinate)][(xcoordinate + i)] = word_2[i];
                    } else {
                        board[(ycoordinate + i)][(xcoordinate)] = word_2[i];
                    }
                }
                board_placement2(word_2, COORDINATION, xcoordinate * 30, ycoordinate * 30, tilecolor2);

                player2tiles(Player_1_rack, tilecolor2, Letter_value, Letters);
                turns++;
                start++;
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid input", 510, 485);
                turns++;
            }
        }
        return turns;
    }

    public static int Points(int[] points, String[] letters, int point, String[] word, int xcoordinate, int ycoordinate, int coordination, int turns, String[][] board) {
        int count = 0;
        ArrayList indexes = new ArrayList(); //Integer
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if ((word[i]).equalsIgnoreCase(letters[j])) { //Takes the indexes of the letters in the alphabet correponding to letters in the word
                    indexes.add(Integer.toString(j));
                }
            }
        }
        if (turns == 0) {
            count = 2 * SpecialLetter(word, ycoordinate, xcoordinate, coordination, letters, points, indexes, board);
        } else {
            count = SpecialLetter(word, ycoordinate, xcoordinate, coordination, letters, points, indexes, board);
        }
        return count;

    }

    public static int SpecialLetter(String[] word, int ycoord, int xcoord, int coordination, String[] letters, int[] points, ArrayList indexes, String[][] board) {
        int i;
        int doubleletter = 0;
        int tripleletter = 0;
        int totalword = 0;
        for (i = 0; i < indexes.size(); i++) {
            totalword = totalword + points[Integer.parseInt(indexes.get(i).toString())]; //Adding all points
        } //Total points of word without doubling tripling
        ArrayList DL = new ArrayList();
        ArrayList TL = new ArrayList();
        for (i = 0; i < word.length; i++) {
            if (coordination == 1) {
                if ((board[(ycoord)][(xcoord + i)]).equals("6")) {

                    DL.add(word[i]);
                    ArrayList Index = DoubleLetter(DL, letters); //Integer
                    for (i = 0; i < Index.size(); i++) {
                        for (int j = 0; j < points.length; j++) {
                            if (Integer.parseInt(Index.get(i).toString()) == j) {
                                doubleletter = points[j] + doubleletter;
                            }

                        }
                    }
                    totalword = totalword + doubleletter;
                    break;
                } else if ((board[(ycoord)][(xcoord + i)]).equals("7")) {
                    TL.add(word[i]);
                    ArrayList Index = TripleLetter(TL, letters);
                    for (i = 0; i < Index.size(); i++) {
                        for (int j = 0; j < points.length; j++) {
                            if (Integer.parseInt(Index.get(i).toString()) == j) {
                                tripleletter = 2 * points[j] + tripleletter;
                            }
                        }
                    }
                    totalword = totalword + tripleletter;
                    break;
                }
            } else {
                if (board[ycoord + i][xcoord].equals("6")) {
                    DL.add(word[i]);
                    ArrayList Index = DoubleLetter(DL, letters); //Integer
                    for (i = 0; i < Index.size(); i++) {
                        for (int j = 0; j < points.length; j++) {
                            if (Integer.parseInt(Index.get(i).toString()) == j) {
                                doubleletter = points[j] + doubleletter;
                            }
                        }
                    }
                    totalword = totalword + doubleletter;
                } else if (board[ycoord + i][xcoord].equals("7")) {
                    TL.add(word[i]);
                    ArrayList Index = TripleLetter(TL, letters); //Integer
                    for (i = 0; i < Index.size(); i++) {
                        for (int j = 0; j < points.length; j++) {
                            if (Integer.parseInt(Index.get(i).toString()) == j) {
                                tripleletter = 2 * points[j] + tripleletter;
                            }
                        }
                    }
                    totalword = totalword + tripleletter;

                }
            }

            //Double Word Triple Word
            for (i = 0; i < word.length; i++) {
                if (coordination == 1) {
                    if ((board[ycoord][xcoord + i]).equals("8")) {
                        totalword = 2 * totalword;
                    } else if ((board[ycoord][xcoord + i]).equals("9")) {
                        totalword = 3 * totalword;
                    }
                } else {
                    if (board[ycoord + i][xcoord].equals("8")) {
                        totalword = 2 * totalword;

                    } else if (board[ycoord + i][xcoord].equals("9")) {
                        totalword = 3 * totalword;

                    }
                }

            }
            return totalword;
        }
        return totalword;
    }

    public static ArrayList DoubleLetter(ArrayList array, String[] letters) { //returns integer
        int i;
        ArrayList Index = new ArrayList();
        for (i = 0; i < array.size(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (array.get(i).equals(letters[j])) {
                    Index.add(Integer.toString(j));
                }
            }
        }
        return Index;

    }

    public static ArrayList TripleLetter(ArrayList array, String[] letters) { //returns integer
        int i;
        ArrayList Index = new ArrayList(); //integer
        for (i = 0; i < array.size(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if ((array.get(i)).equals(letters[j])) {
                    Index.add(Integer.toString(j));
                }
            }
        }
        return Index;
    }
//This method checks for whether or not on the first turn the word is placed on the first tile, and afterwards whether the word goes off the grid

    public static boolean ValidMove(int xcoordinate, int ycoordinate, int coordination, String[] word, int turns, ArrayList Rack, ArrayList Diction, String word2, int start, String[][] board) {

        if (start == 0) {
            for (int i = 0; i < word.length; i++) {
                if (coordination == 1) {
                    if (board[ycoordinate][xcoordinate + i].equals("1")) {
                        if ((xcoordinate) <= 15 && (ycoordinate) <= 15) {
                            if (xcoordinate + word.length - 1 <= 15) {
                                return ValidMove2(Rack, Diction, word, word2, ycoordinate, xcoordinate, coordination, board, start);   //ValidMove2(ArrayListRack,String[] word,ArrayListDiction,String word2)
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < word.length; i++) {
                if (coordination == 2) {
                    if (board[ycoordinate + i][xcoordinate].equals("1")) {
                        if ((xcoordinate) <= 15 && (ycoordinate) <= 15) {
                            if (ycoordinate + word.length - 1 <= 15) {
                                return ValidMove2(Rack, Diction, word, word2, ycoordinate, xcoordinate, coordination, board, start);
                            }
                        }
                    }
                }
            }
        } else {

            if ((xcoordinate) <= 15 && (ycoordinate) <= 15) {
                if (coordination == 1) {
                    if (xcoordinate + word.length - 1 <= 15) {
                        return ValidMove2(Rack, Diction, word, word2, ycoordinate, xcoordinate, coordination, board, start);
                    }
                } else {
                    if (ycoordinate + word.length - 1 <= 15) {
                        return ValidMove2(Rack, Diction, word, word2, ycoordinate, xcoordinate, coordination, board, start);
                    }
                }
            }

        }

        return false;
    }

    //Thsi method checks overall whether all the letters used are letters from the rack, and if other letters are being used made sure to exclude those from the chekcing to not always get an error
    public static boolean ValidMove2(ArrayList Rack, ArrayList Diction, String[] word2, String word, int ycoordinate, int xcoordinate, int coordination, String[][] board, int start) { //Checks for whether words are used from rack; The one time the real word will be used...
//Note although this checks for whether or not other letters are used not using other letters doensn't result in an immediate error
        //The checking now works for whenever NO other letters are used....
        System.out.println(UseOtherLetters(word2, xcoordinate, ycoordinate, coordination, board));
        System.out.println("--------");
        if (UseOtherLetters(word2, xcoordinate, ycoordinate, coordination, board) == false) // public static boolean UseOtherLetters(String[] word,String[][] int xcoord, int ycoord,int coordination){
        {
            //See if word2 is a subset of the rack letters
            int i = 0;
            int j = 0;
            for (i = 0; i < word2.length; i++) {
                for (j = 0; j < Rack.size(); j++) {
                    if (word2[i].equals(Rack.get(j))) {

                        break;
                    }
                }
                // If the above inner loop was not broken at all then word2[i] is not present in Rack[]
                if (j == Rack.size()) {
                    System.out.println("Not all letters are from rack");
                    return false;
                }
            }

            // If we reach here then all elements of word2 are present in the rack
            System.out.println("The letters are from the rack");
            return true;//return ValidMove3(word, word2, Diction, coordination, ycoordinate, xcoordinate, board);
        } else {
            ArrayList X = new ArrayList(); //Integer
            int[] Y = new int[word2.length];
            ArrayList Index = new ArrayList(); //Integer
            ArrayList Word = new ArrayList();
            if (coordination == 1) {
                for (int i = 0; i < word2.length; i++) {
                    for (int j = 0; j < Rack.size(); j++) {
                        if (!board[ycoordinate][xcoordinate + i].equals("8") && !board[ycoordinate][xcoordinate + i].equals("9") && !board[ycoordinate][xcoordinate + i].equals("6") && !board[ycoordinate][xcoordinate + i].equals("7") && !board[ycoordinate][xcoordinate + i].equals(Rack.get(j))) {
                            X.add(Integer.toString(i));
                        }
                    }
                }
            } else {
                for (int i = 0; i < word2.length; i++) {
                    for (int j = 0; j < Rack.size(); j++) {
                        if (!board[ycoordinate + i][xcoordinate].equals("8") && !board[ycoordinate + i][xcoordinate].equals("9") && !board[ycoordinate + i][xcoordinate].equals("6") && !board[ycoordinate + i][xcoordinate].equals("7") && !board[ycoordinate + i][xcoordinate].equals(Rack.get(j))) {
                            X.add(Integer.toString(i));

                        }
                    }
                }
            }
            for (int i = 0; i < word2.length; i++) {
                if (i != Integer.parseInt(X.get(i).toString())) {
                    Y[i]++;
                }

            }
            for (int i = 0; i < Y.length; i++) {
                if (Y[i] == 1) {
                    Index.add(Integer.toString(i));
                }
            }
            for (int i = 0; i < Index.size(); i++) {
                Word.add(word2[i]);
            }
            int i = 0;
            int j = 0;
            for (i = 0; i < Word.size(); i++) {
                for (j = 0; j < Rack.size(); j++) {
                    if (Word.get(i).equals(Rack.get(j))) {
                        break;
                    }
                }

                // If the above inner loop was not broken at all then word2[i] is not present in Rack[]
                if (j == Rack.size()) {
                    System.out.println("Not all letters are from rack*");
                    return false;
                }
            }

            System.out.println("The letters are from the rack*");// If we reach here then all elements of word2 are present in the rack
            return true; //ValidMove3 (word, word2, Diction, coordination, ycoordinate, xcoordinate, board);
        }

    }

    public static boolean ValidMove3(String word, String[] word2, ArrayList Diction, int coordination, int ycoordinate, int xcoordinate, String[][] board, int start) {
        //check for dictionary terms
        //The one time the word will actually be used
        for (int i = 0; i < Diction.size(); i++) {
            if (word.equals(Diction.get(i))) {
                System.out.println("IS A WORD IN DICTIONARY");
                return true;//return ValidMove4(word2, coordination, ycoordinate, xcoordinate, board);
            }
        }
        System.out.println("NOT a word in the dictionary....");
        return false;
    }

    public static boolean ValidMove4(String[] word, int coordination, int ycoordinate, int xcoordinate, String[][] board, int start) {
        if (start == 1) {
            return true;
        } else {
            if (UseOtherLetters(word, xcoordinate, ycoordinate, coordination, board)) {//If true then other letters are being used
                return true;
            } else {
                return false;
            }
        }
    }

    public static ArrayList Racks(int[] letters_num, String[] letters, ArrayList RackLetters, int turns, String word2, ArrayList Diction, int xcoordinate, int ycoordinate, int coordination, String[] word, int start, String[][] board) {
        int count = 0;
        if (turns == 0) {
            while (count < 7) {
                int x = (int) ((27) * Math.random());
                if (letters_num[x] > 0) {
                    RackLetters.add(letters[x]);
                    letters_num[x]--;
                    count++;
                }
            }

        } else {
            if (ValidMove(xcoordinate, ycoordinate, coordination, word, turns, RackLetters, Diction, word2, start, board)) { //int xcoordinate, int ycoordinate, int coordination, String[] word, int turns, String[][] ArrayList Rack, ArrayList Diction, String word2
                for (int i = 0; i < word.length; i++) {
                    for (int j = 0; j < RackLetters.size(); j++) {

                        //String testLetter = RackLetters.toString(j);
                        if (word[i].equals(RackLetters.get(j).toString())) {

                            RackLetters.set(j, "$");
                        }
                    }
                }
            }
            for (int i = 0; i < RackLetters.size(); i++) {
                while (RackLetters.get(i).equals("$")) {
                    int x = (int) ((27) * Math.random());
                    if (letters_num[x] > 0) {
                        RackLetters.set(i, letters[x]);
                        letters_num[x]--;
                    }
                }
            }

        }
        return RackLetters;
    }

    public static boolean UseOtherLetters(String[] word, int xcoord, int ycoord, int coordination, String[][] board) {
        ArrayList X = new ArrayList(); //Integer
        ArrayList Y = new ArrayList(); //Integer
        if (coordination == 1) {
            for (int i = 0; i < word.length; i++) {
                if (!board[ycoord ][xcoord + i ].equals("8") && !board[ycoord ][xcoord + i].equals("9") && !board[ycoord][xcoord + i].equals("7") && !board[ycoord][xcoord + i].equals("6")) {
                    X.add(Integer.toString(xcoord + i ));
                    Y.add(Integer.toString(ycoord ));
                }
            }
        } else {
            for (int i = 0; i < word.length; i++) {
                if (!board[ycoord + i ][xcoord].equals("8") && !board[ycoord + i][xcoord].equals("9") && !board[ycoord + i ][xcoord].equals("7") && !board[ycoord + i][xcoord].equals("6")) {
                    X.add(Integer.toString(xcoord ));
                    Y.add(Integer.toString(ycoord + i ));
                }
            }
        }
        return X.isEmpty();//If returns false then no other letters are used
//If X is an empty set, meaning that no additional letters were used from the board(should only really happen on first move anyways returns true)
    }

    public static boolean EmptyLetter(String[] word) {
        for (int i = 0; i < word.length; i++) {
            if (word[i].equals("_")) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList Redrawletters(int[] letters_num, String[] letters, ArrayList RackLetters, int turns) {
        int count = 0;
        //Reinput letters into "bag"
        for (int i = 0; i < RackLetters.size(); i++) {
            for (int j = 0; j < letters_num.length; j++) {
                if (RackLetters.equals(letters[j])) {
                    letters_num[j]++;
                }
            }
        }
        //Drawing new letters
        while (count < 7) {
            int x = (int) ((27) * Math.random());
            if (letters_num[x] > 0) {
                RackLetters.set(count, letters[x]);
                letters_num[x]--;
                count++;
            }
        }

        return RackLetters;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void introduction(String[][] board) {
        //c = new Console();
        char option = ' ';
        String[] array = new String[3];
        do {
            Color background = new Color(204, 0, 0);
            c.setColor(background);
            c.fillRect(0, 0, 1000, 1000);

            Color tilecolor = new Color(255, 255, 204);
            c.setColor(tilecolor);
            c.fillRect(85, 150, 50, 50);
            c.fillRect(145, 150, 50, 50);
            c.fillRect(205, 150, 50, 50);
            c.fillRect(265, 150, 50, 50);
            c.fillRect(325, 150, 50, 50);
            c.fillRect(385, 150, 50, 50);
            c.fillRect(445, 150, 50, 50);
            c.fillRect(505, 150, 50, 50);
            c.fillRect(255, 250, 130, 50);
            c.fillRect(255, 330, 130, 50);

            c.setColor(Color.black);
            c.drawRect(85, 150, 50, 50);
            c.drawRect(145, 150, 50, 50);
            c.drawRect(205, 150, 50, 50);
            c.drawRect(265, 150, 50, 50);
            c.drawRect(325, 150, 50, 50);
            c.drawRect(385, 150, 50, 50);
            c.drawRect(445, 150, 50, 50);
            c.drawRect(505, 150, 50, 50);
            c.drawRect(255, 250, 130, 50);
            c.drawRect(255, 330, 130, 50);

            c.setFont(new Font("Ariel", Font.PLAIN, 40));
            c.drawString("S", 97, 187);
            c.drawString("C", 155, 187);
            c.drawString("R", 215, 187);
            c.drawString("A", 276, 187);
            c.drawString("B", 335, 187);
            c.drawString("B", 396, 187);
            c.drawString("L", 459, 187);
            c.drawString("E", 516, 187);
            c.setFont(new Font("Ariel", Font.PLAIN, 20));
            c.drawString("PLAY (P)", 280, 280);
            c.drawString("CREDITS (C)", 260, 360);
            c.drawString("WELCOME TO", 252, 130);
            c.setFont(new Font("Ariel", Font.PLAIN, 10));
            c.drawString("1", 125, 195);
            c.drawString("3", 185, 195);
            c.drawString("1", 245, 195);
            c.drawString("1", 305, 195);
            c.drawString("3", 365, 195);
            c.drawString("3", 425, 195);
            c.drawString("1", 485, 195);
            c.drawString("1", 545, 195);

            option = c.getChar();
            c.clear();
            if (option == 'P' || option == 'C') {
                /*array = */
                heading(background, tilecolor, option, board);
            }
        } while (option != 'P' && option != 'C');
        c.print(array[0]);
        //return array;

    }

    public static void heading(Color background, Color tilecolor, char option, String[][] board) {
        c.setColor(background);
        c.fillRect(0, 0, 1000, 1000);
        String[] array = {"1", "1", "1"};
        c.setColor(tilecolor);
        c.fillRect(85, 60, 50, 50);
        c.fillRect(145, 60, 50, 50);
        c.fillRect(205, 60, 50, 50);
        c.fillRect(265, 60, 50, 50);
        c.fillRect(325, 60, 50, 50);
        c.fillRect(385, 60, 50, 50);
        c.fillRect(445, 60, 50, 50);
        c.fillRect(505, 60, 50, 50);

        c.setColor(Color.black);
        c.drawRect(85, 60, 50, 50);
        c.drawRect(145, 60, 50, 50);
        c.drawRect(205, 60, 50, 50);
        c.drawRect(265, 60, 50, 50);
        c.drawRect(325, 60, 50, 50);
        c.drawRect(385, 60, 50, 50);
        c.drawRect(445, 60, 50, 50);
        c.drawRect(505, 60, 50, 50);

        c.setFont(new Font("Ariel", Font.PLAIN, 40));
        c.drawString("S", 97, 97);
        c.drawString("C", 155, 97);
        c.drawString("R", 215, 97);
        c.drawString("A", 276, 97);
        c.drawString("B", 335, 97);
        c.drawString("B", 396, 97);
        c.drawString("L", 459, 97);
        c.drawString("E", 516, 97);

        c.setFont(new Font("Ariel", Font.PLAIN, 10));
        c.drawString("1", 125, 105);
        c.drawString("3", 185, 105);
        c.drawString("1", 245, 105);
        c.drawString("1", 305, 105);
        c.drawString("3", 365, 105);
        c.drawString("3", 425, 105);
        c.drawString("1", 485, 105);
        c.drawString("1", 545, 105);

        if (option == 'P') {
            instructions(background, tilecolor, option, board);
        }
        if (option == 'C') {
            credits(background, tilecolor, option, board);
        }
        if (option == 'N') {
            /*array = */
            gameinfo(background, board);
            // c.print(array[0]);

        }
        //return array;
    }

    public static void credits(Color background, Color tilecolor, char option, String[][] board) {
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 25));
            c.drawString("Created by Ellina Zhang and Mustansir Pindwarawala", 15, 250);

            c.setColor(tilecolor);
            c.fillRect(255, 330, 130, 50);
            c.setColor(Color.black);
            c.drawRect(255, 330, 130, 50);
            c.setFont(new Font("Ariel", Font.PLAIN, 20));
            c.drawString("RETURN (R)", 264, 360);
            option = c.getChar();
            c.clear();
            if (option == 'R') {
                introduction(board);
            }
        } while (option != 'R');

    }

    public static void instructions(Color background, Color tilecolor, char option, String[][] board) {
        String[] array = new String[3];
        do {
            c.setColor(Color.black);
            c.setFont(new Font("TimesRoman", Font.BOLD, 25));
            c.drawString("INSTRUCTIONS", 230, 150);
            c.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            c.drawString("Please Read the Following Guidelines Very Carefully: ", 110, 180);
            c.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            c.drawString(" - This is a 2 player Scrabble game with the basic gameplay rules. On the following screen please enter the", 0, 200);
            c.drawString("   number of turns you would like in total for the entire match. ", 0, 220);
            c.drawString(" - The game is played on a 450 units x 450 units board. When asked for the position of your word, please", 0, 240);
            c.drawString("   enter a multiple of 30 between 0 (furthest left and up) to 450 (furthest right and down). ", 0, 260);
            c.drawString(" - Make sure to use ONLY capital letters for decisions and entering letters. ", 0, 280);
            c.drawString(" - When asked for the tiles in your word, enter the letter you would like to use one by one and press enter. ", 0, 300);
            c.drawString(" - For a blank letter tile, use an underscore ( _ ) after which you will be asked to enter the letter you want. ", 0, 320);
            c.drawString(" - To use a letter that is already on the board in your word, enter a double underscore ( __ ) and after, the", 0, 340);
            c.drawString("   specific letter you are using. ", 0, 360);
            c.drawString(" - There is a message board in the bottom right corner that will display all console messages. ", 0, 380);
            c.drawString(" - Good luck and have fun!", 0, 400);
            c.setColor(tilecolor);
            c.fillRect(255, 420, 130, 50);
            c.setColor(Color.black);
            c.drawRect(255, 420, 130, 50);
            c.setFont(new Font("Ariel", Font.PLAIN, 20));
            c.drawString("NEXT (N)", 280, 450);
            option = c.getChar();
            c.clear();

            if (option == 'N') {
                /*return*/
                heading(background, tilecolor, option, board);
            }
        } while (option != 'N');
        //return array;
    }

    public static void gameinfo(Color background, String[][] board) {

        c.setColor(Color.black);
        c.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        c.drawString("Player 1 Name:", 20, 200);
        c.drawString("Player 2 Name:", 20, 302);
        //c.drawString ("Number of Turns:", 20, 395);
        c.setTextBackgroundColor(background);
        c.setCursor(12, 20);
        String name1 = c.readLine();
        c.setCursor(18, 20);
        String name2 = c.readLine();
        /*int turns = 0;
         int count = 0;
         do
         {
         c.setCursor (20, 22);
         turns = c.readInt ();
         }
         while (turns % 2 != 0 || turns == 0);
         c.clear ();
         String[] gameinfo = {name1, name2, Integer.toString (turns) };*/
        game(name1, name2);
        //1return gameinfo;

    }

    public static void game(String name1, String name2) {
        String[][] board = new String[450][450];
        c.setColor(Color.white);
        c.fillRect(0, 0, 1000, 1000);
        c.setColor(Color.black);
        for (int i = 0; i < board.length; i += 30) {
            for (int j = 0; j < board.length; j += 30) {
                c.drawRect(i, j, 30, 30);

            }
        }

        //Triple Word Squares
        for (int i = 1; i < board.length; i += 210) {
            for (int j = 1; j < board.length; j += 210) {
                Color TripleWord = new Color(153, 0, 0);
                c.setColor(TripleWord);
                c.fillRect(i, j, 29, 29);
            }
        }

        c.fillRect(1, 470, 19, 19);

        //Double Word Squares
        Color DoubleWord = new Color(255, 102, 102);
        c.setColor(DoubleWord);
        c.fillRect(211, 211, 29, 29);
        c.fillRect(31, 31, 29, 29);
        c.fillRect(31, 391, 29, 29);
        c.fillRect(61, 61, 29, 29);
        c.fillRect(61, 361, 29, 29);
        c.fillRect(91, 91, 29, 29);
        c.fillRect(91, 331, 29, 29);
        c.fillRect(121, 121, 29, 29);
        c.fillRect(121, 301, 29, 29);
        c.fillRect(301, 121, 29, 29);
        c.fillRect(301, 301, 29, 29);
        c.fillRect(331, 91, 29, 29);
        c.fillRect(331, 331, 29, 29);
        c.fillRect(361, 61, 29, 29);
        c.fillRect(361, 361, 29, 29);
        c.fillRect(391, 31, 29, 29);
        c.fillRect(391, 391, 29, 29);
        c.fillRect(112, 470, 19, 19);

        //Triple Letter Squares
        Color TripleLetter = new Color(0, 0, 153);
        c.setColor(TripleLetter);
        c.fillRect(31, 151, 29, 29);
        c.fillRect(31, 271, 29, 29);
        c.fillRect(391, 151, 29, 29);
        c.fillRect(391, 271, 29, 29);
        c.fillRect(151, 31, 29, 29);
        c.fillRect(271, 31, 29, 29);
        c.fillRect(151, 391, 29, 29);
        c.fillRect(271, 391, 29, 29);
        c.fillRect(151, 151, 29, 29);
        c.fillRect(271, 271, 29, 29);
        c.fillRect(271, 151, 29, 29);
        c.fillRect(151, 271, 29, 29);
        c.fillRect(223, 470, 19, 19);

        //Double Letter Squares
        Color DoubleLetter = new Color(51, 204, 255);
        c.setColor(DoubleLetter);
        c.fillRect(91, 1, 29, 29);
        c.fillRect(331, 1, 29, 29);
        c.fillRect(91, 421, 29, 29);
        c.fillRect(331, 421, 29, 29);
        c.fillRect(1, 91, 29, 29);
        c.fillRect(1, 331, 29, 29);
        c.fillRect(421, 91, 29, 29);
        c.fillRect(421, 331, 29, 29);
        c.fillRect(91, 211, 29, 29);
        c.fillRect(331, 211, 29, 29);
        c.fillRect(211, 91, 29, 29);
        c.fillRect(211, 331, 29, 29);
        c.fillRect(61, 181, 29, 29);
        c.fillRect(361, 181, 29, 29);
        c.fillRect(181, 61, 29, 29);
        c.fillRect(181, 361, 29, 29);
        c.fillRect(61, 241, 29, 29);
        c.fillRect(361, 241, 29, 29);
        c.fillRect(241, 61, 29, 29);
        c.fillRect(241, 361, 29, 29);
        c.fillRect(181, 181, 29, 29);
        c.fillRect(241, 241, 29, 29);
        c.fillRect(241, 181, 29, 29);
        c.fillRect(181, 241, 29, 29);
        c.fillRect(334, 470, 19, 19);

        //Legend
        c.setColor(Color.black);
        c.drawRect(1, 470, 19, 19);
        c.drawRect(112, 470, 19, 19);
        c.drawRect(223, 470, 19, 19);
        c.drawRect(334, 470, 19, 19);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("3x Word", 27, 485);
        c.drawString("2x Word", 138, 485);
        c.drawString("3x Letter", 249, 485);
        c.drawString("2x Letter", 360, 485);

        //Scoreboard
        int Player_1_points = 0;
        int Player_2_points = 0;
        c.drawRect(457, 27, 400, 1);
        c.drawRect(457, 267, 400, 1);
        c.setFont(new Font("Ariel", Font.PLAIN, 17));
        c.drawString("" + (name1), 465, 20);
        c.drawString(" " + (Player_1_points), 605, 20);
        c.drawString("" + (name2), 465, 260);
        c.drawString(" " + (Player_2_points), 605, 260);

    }

    public static void Points_Drawing1(int points) {
        c.setFont(new Font("Ariel", Font.PLAIN, 17));
        c.setColor(Color.white);
        c.drawRect(580, 27, 400, 1);
        c.fillRect(580, 27, 400, 1);
        c.drawString(" " + (points), 605, 20);
    }

    public static void Points_Drawing2(int points) {
        c.setFont(new Font("Ariel", Font.PLAIN, 17));
        c.setColor(Color.white);
        c.drawRect(580, 27, 400, 1);
        c.fillRect(580, 267, 400, 1);
        c.drawString(" " + (points), 605, 260);
    }

    public static void player1tiles(ArrayList rack, String[] Letters, int[] letter_value) {
        int[] Rack = new int[7];
        for (int i = 0; i < Rack.length; i++) {
            for (int j = 0; j < Letters.length; j++) {
                if (rack.get(i).equals(Letters[j])) {
                    Rack[i] = j;//Saves the index numbers of the letters that are in the rack as they are present in the alphabet
                }
            }
        }

        //player 1 rack
        c.setColor(Color.black);
        c.drawRect(460, 35, 30, 30);
        c.drawRect(494, 35, 30, 30);
        c.drawRect(528, 35, 30, 30);
        c.drawRect(562, 35, 30, 30);
        c.drawRect(596, 35, 30, 30);
        c.drawRect(460, 69, 30, 30);
        c.drawRect(494, 69, 30, 30);

        Color tilecolor2 = new Color(255, 255, 153);
        c.setColor(tilecolor2);

        c.fillRect(461, 36, 29, 29);
        c.fillRect(495, 36, 29, 29);
        c.fillRect(529, 36, 29, 29);
        c.fillRect(563, 36, 29, 29);
        c.fillRect(597, 36, 29, 29);
        c.fillRect(461, 70, 29, 29);
        c.fillRect(495, 70, 29, 29);

        c.setColor(Color.black);
        for (int i = 1; i < 8; i++) {
            if (i == 1) {
                //Wherever there is an alpha replace with Letters
                //replace rack1[] with rack.get
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(0).equals("Q")) {
                    c.drawString("" + (rack.get(0)), 465, 55);
                } else if (rack.get(0).equals("W") || (rack.get(0).equals("M"))) {
                    c.drawString("" + (rack.get(0)), 465, 53);
                } else if ((rack.get(0)) == "I" || (rack.get(0)) == "J") {
                    c.drawString("" + (rack.get(0)), 471, 55);
                } else {
                    c.drawString("" + (rack.get(0)), 467, 55);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[0]] - 10) != 0) //////////////////////////////////
                {
                    c.drawString("" + letter_value[Rack[0]], 480, 62);
                } else {
                    c.drawString("" + letter_value[Rack[0]], 475, 62);
                }
            }
            if (i == 2) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(1).equals("Q")) {
                    c.drawString("" + (rack.get(1)), 499, 54);
                } else if (rack.get(1).equals("W") || (rack.get(1).equals("M"))) {
                    c.drawString("" + (rack.get(1)), 499, 54);
                } else if ((rack.get(1)).equals("I") || (rack.get(1)).equals("J")) {
                    c.drawString("" + (rack.get(1)), 505, 55);
                } else {
                    c.drawString("" + (rack.get(1)), 501, 55);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[1]] - 10) != 0) {
                    c.drawString("" + letter_value[Rack[1]], 514, 62);
                } else {
                    c.drawString("" + letter_value[Rack[1]], 509, 62);
                }
            }
            if (i == 3) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if ((rack.get(2)).equals("Q")) {
                    c.drawString("" + (rack.get(2)), 535, 54);
                } else if ((rack.get(2)).equals("W") || (rack.get(2)).equals("M")) {
                    c.drawString("" + (rack.get(2)), 535, 54);
                } else if ((rack.get(2)).equals("I") || (rack.get(2)).equals("J")) {
                    c.drawString("" + (rack.get(2)), 539, 55);
                } else {
                    c.drawString("" + (rack.get(2)), 535, 55);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[2]] - 10) != 0) {
                    c.drawString("" + letter_value[Rack[2]], 547, 62);
                } else {
                    c.drawString("" + letter_value[Rack[2]], 543, 62);
                }
            }
            if (i == 4) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if ((rack.get(3)).equals("Q")) {
                    c.drawString("" + (rack.get(3)), 567, 54);
                } else if ((rack.get(3)).equals("W") || (rack.get(3)).equals("M")) {
                    c.drawString("" + (rack.get(3)), 567, 54);
                } else if ((rack.get(3)).equals("I") || (rack.get(3)).equals("J")) {
                    c.drawString("" + (rack.get(3)), 573, 55);
                } else {
                    c.drawString("" + (rack.get(3)), 569, 55);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[3]] - 10) != 0) {
                    c.drawString("" + letter_value[Rack[3]], 581, 62);
                } else {
                    c.drawString("" + letter_value[Rack[3]], 577, 62);
                }
            }
            if (i == 5) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if ((rack.get(4)).equals("Q")) {
                    c.drawString("" + (rack.get(4)), 601, 54);
                } else if ((rack.get(4)).equals("W") || (rack.get(4)).equals("M")) {
                    c.drawString("" + (rack.get(4)), 601, 54);
                } else if ((rack.get(4)).equals("I") || (rack.get(4)).equals("J")) {
                    c.drawString("" + (rack.get(4)), 607, 55);
                } else {
                    c.drawString("" + (rack.get(4)), 603, 55);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[4]] - 10) != 0) {
                    c.drawString("" + letter_value[Rack[4]], 615, 62);
                } else {
                    c.drawString("" + letter_value[Rack[4]], 611, 62);
                }
            }
            if (i == 6) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if ((rack.get(5)).equals("Q")) {
                    c.drawString("" + (rack.get(5)), 465, 89);
                } else if ((rack.get(5)).equals("W") || (rack.get(5)).equals("M")) {
                    c.drawString("" + (rack.get(5)), 465, 87);
                } else if ((rack.get(5)).equals("I") || (rack.get(5)).equals("J")) {
                    c.drawString("" + (rack.get(5)), 471, 89);
                } else {
                    c.drawString("" + (rack.get(5)), 467, 89);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[5]] - 10) != 0) {
                    c.drawString("" + (letter_value[Rack[5]]), 480, 96);
                } else {
                    c.drawString("" + (letter_value[Rack[5]]), 475, 96);
                }
            }
            if (i == 7) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if ((rack.get(6)).equals("Q")) {
                    c.drawString("" + (rack.get(6)), 499, 88);
                } else if ((rack.get(6)).equals("W") || (rack.get(6)).equals("M")) {
                    c.drawString("" + (rack.get(4)), 499, 88);
                } else if ((rack.get(6)).equals("I") || (rack.get(6)).equals("J")) {
                    c.drawString("" + (rack.get(6)), 505, 89);
                } else {
                    c.drawString("" + (rack.get(6)), 501, 89);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[6]] - 10) != 0) {
                    c.drawString("" + (letter_value[Rack[6]]), 514, 96);
                } else {
                    c.drawString("" + (letter_value[Rack[6]]), 509, 96);
                }
            }

        }

    }

    public static void player2tiles(ArrayList rack, Color tilecolor2, int[] letter_value, String[] Letters) {

        int[] Rack = new int[7];
        for (int i = 0; i < Rack.length; i++) {
            for (int j = 0; j < Letters.length; j++) {
                if (rack.get(i).equals(Letters[j])) {
                    Rack[i] = j;
                }
            }
        }

        //player 2 rack
        c.setColor(Color.black);
        c.drawRect(460, 275, 30, 30);
        c.drawRect(494, 275, 30, 30);
        c.drawRect(528, 275, 30, 30);
        c.drawRect(562, 275, 30, 30);
        c.drawRect(596, 275, 30, 30);
        c.drawRect(460, 309, 30, 30);
        c.drawRect(494, 309, 30, 30);

        c.setColor(tilecolor2);
        c.fillRect(461, 276, 29, 29);
        c.fillRect(495, 276, 29, 29);
        c.fillRect(529, 276, 29, 29);
        c.fillRect(563, 276, 29, 29);
        c.fillRect(597, 276, 29, 29);
        c.fillRect(461, 310, 29, 29);
        c.fillRect(495, 310, 29, 29);

        c.setColor(Color.black);
        for (int i = 1; i < 8; i++) {
            if (i == 1) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(0).equals("Q")) {
                    c.drawString(" " + (rack.get(0)), 460, 295);
                } else if (rack.get(0).equals("W") || rack.get(0).equals("M")) {
                    c.drawString(" " + (rack.get(0)), 460, 293);
                } else if (rack.get(0).equals("I") || rack.get(0).equals("J")) {
                    c.drawString(" " + (rack.get(0)), 466, 295);
                } else {
                    c.drawString(" " + (rack.get(0)), 462, 295);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[0]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[0]]), 480, 302);
                } else {
                    c.drawString(" " + (letter_value[Rack[0]]), 475, 302);
                }
            }

            if (i == 2) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(1).equals("Q")) {
                    c.drawString(" " + (rack.get(1)), 494, 294);
                } else if (rack.get(1).equals("W") || rack.get(1).equals("M")) {
                    c.drawString(" " + (rack.get(1)), 494, 294);
                } else if (rack.get(1).equals("I") || rack.get(1).equals("J")) {
                    c.drawString(" " + (rack.get(1)), 500, 295);
                } else {
                    c.drawString(" " + (rack.get(1)), 496, 295);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[1]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[1]]), 514, 302);
                } else {
                    c.drawString(" " + (letter_value[Rack[1]]), 509, 302);
                }
            }
            if (i == 3) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(2).equals("Q")) {
                    c.drawString(" " + (rack.get(2)), 530, 294);
                } else if (rack.get(2).equals("W") || rack.get(2).equals("M")) {
                    c.drawString(" " + (rack.get(2)), 530, 294);
                } else if (rack.get(2).equals("I") || rack.get(2).equals("J")) {
                    c.drawString(" " + (rack.get(2)), 534, 295);
                } else {
                    c.drawString(" " + (rack.get(2)), 530, 295);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[2]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[2]]), 547, 302);
                } else {
                    c.drawString(" " + (letter_value[Rack[2]]), 543, 302);
                }
            }
            if (i == 4) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(3).equals("Q")) {
                    c.drawString(" " + (rack.get(3)), 562, 294);
                } else if (rack.get(3).equals("W") || rack.get(3).equals("M")) {
                    c.drawString(" " + (rack.get(3)), 562, 294);
                } else if (rack.get(3).equals("I") || rack.get(3).equals("J")) {
                    c.drawString(" " + (rack.get(3)), 568, 295);
                } else {
                    c.drawString(" " + (rack.get(3)), 564, 295);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[3]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[3]]), 581, 302);
                } else {
                    c.drawString(" " + (letter_value[Rack[3]]), 577, 302);
                }
            }
            if (i == 5) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(4).equals("Q")) {
                    c.drawString(" " + (rack.get(4)), 596, 294);
                } else if (rack.get(4).equals("W") || rack.get(4).equals("M")) {
                    c.drawString(" " + (rack.get(4)), 596, 294);
                } else if (rack.get(4).equals("I") || rack.get(4).equals("J")) {
                    c.drawString(" " + (rack.get(4)), 602, 295);
                } else {
                    c.drawString(" " + (rack.get(4)), 598, 295);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[4]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[4]]), 614, 302);
                } else {
                    c.drawString(" " + (letter_value[Rack[4]]), 611, 302);
                }
            }
            if (i == 6) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(5).equals("Q")) {
                    c.drawString(" " + (rack.get(5)), 460, 329);
                } else if (rack.get(5).equals("W") || rack.get(5).equals("M")) {
                    c.drawString(" " + (rack.get(5)), 460, 327);
                } else if (rack.get(5).equals("I") || rack.get(5).equals("J")) {
                    c.drawString(" " + (rack.get(5)), 466, 329);
                } else {
                    c.drawString(" " + (rack.get(5)), 462, 329);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[5]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[5]]), 480, 336);
                } else {
                    c.drawString(" " + (letter_value[Rack[5]]), 475, 336);
                }
            }
            if (i == 7) {
                c.setFont(new Font("Ariel", Font.PLAIN, 20));
                if (rack.get(6).equals("Q")) {
                    c.drawString(" " + (rack.get(6)), 494, 328);
                } else if (rack.get(6).equals("W") || rack.get(6).equals("M")) {
                    c.drawString(" " + (rack.get(0)), 494, 328);
                } else if (rack.get(6).equals("I") || rack.get(6).equals("J")) {
                    c.drawString(" " + (rack.get(6)), 500, 329);
                } else {
                    c.drawString(" " + (rack.get(6)), 496, 329);
                }

                c.setFont(new Font("Ariel", Font.PLAIN, 10));
                if ((letter_value[Rack[6]] - 10) != 0) {
                    c.drawString(" " + (letter_value[Rack[6]]), 514, 336);
                } else {
                    c.drawString(" " + (letter_value[Rack[6]]), 509, 336);
                }
            }

        }

    }


    /*public static void letter_check ()
     {
     }
     */
    public static String Empty1() {
        c.setColor(Color.white);
        c.fillRect(460, 350, 200, 100);
        c.fillRect(460, 450, 200, 100);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Which Letter would you like?", 460, 130);
        c.setCursor(8, 83);
        String Empty_Letter = c.readLine();
        c.setColor(Color.white);
        c.drawRect(460, 145, 75, 40);
        c.fillRect(460, 450, 200, 150);
        return Empty_Letter;
    }

    public static String Empty2() {
        c.setColor(Color.white);
        c.fillRect(460, 110, 200, 100);
        c.fillRect(460, 450, 200, 100);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Which Letter would you like?", 460, 370);
        c.setCursor(22, 83);
        String Empty_Letter = c.readLine();
        c.setColor(Color.white);
        c.drawRect(460, 385, 75, 40);
        c.fillRect(460, 450, 200, 150);
        return Empty_Letter;
    }

    public static char redraw1(Color tilecolor2) {
        char answer = ' ';
        do {
            c.setColor(Color.black);
            c.setTextBackgroundColor(Color.white);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            //c.drawString ("" + (name1) + "'s Turn", 510, 485);
            c.setColor(tilecolor2);
            c.fillRect(461, 146, 74, 39);
            c.fillRect(556, 146, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Redraw all letters?", 490, 130);
            c.drawString("YES (Y)", 473, 170);
            c.drawString("NO (N)", 570, 170);
            c.drawRect(460, 145, 75, 40);
            c.drawRect(555, 145, 75, 40);
            answer = c.getChar();

            if (answer == 'Y') {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Yes Selected", 510, 485);

            }
            if (answer == 'N') {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.fillRect(460, 110, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("No Selected", 510, 485);

            }

        } while (answer != 'Y' && answer != 'N');
        return answer;
    }

    public static String[] Word1(Color tilecolor2) {
        char answer2 = ' ';
        do {
            c.setColor(tilecolor2);
            c.fillRect(461, 146, 74, 39);
            c.fillRect(556, 146, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Word Orientation?", 490, 130);
            c.setFont(new Font("Ariel", Font.PLAIN, 10));
            c.drawString("HORIZONTAL", 465, 170);
            c.drawString("(H)", 490, 180);
            c.drawString("VERTICAL (V)", 560, 170);
            c.drawRect(460, 145, 75, 40);
            c.drawRect(555, 145, 75, 40);
            answer2 = c.getChar();
            if (answer2 == 'H') {
                c.setColor(Color.white);
                c.fillRect(460, 110, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Horizontal Selected", 495, 485);
            }
            if (answer2 == 'V') {
                c.setColor(Color.white);
                c.fillRect(460, 110, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Vertical Selected", 500, 485);
            }
        } while (answer2 != 'H' && answer2 != 'V');

        int spaces_right1 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces to the right?", 460, 150);
            c.setCursor(9, 77);
            spaces_right1 = c.readInt();
            if (((spaces_right1) % 30 != 0) || (spaces_right1) < 0 || (spaces_right1) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(450, 450, 300, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 13));
                c.drawString((spaces_right1) + " spaces to the right saved", 460, 485);
            }
        } while (((spaces_right1) % 30 != 0) || (spaces_right1) < 0 || (spaces_right1) > 420);

        int spaces_down1 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces down?", 460, 198);
            c.setCursor(12, 77);
            spaces_down1 = c.readInt();
            if (((spaces_down1) % 30 != 0) || (spaces_down1) < 0 || (spaces_down1) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString((spaces_down1) + " spaces down saved", 470, 485);
            }
        } while (((spaces_down1) % 30 != 0) || (spaces_down1) < 0 || (spaces_down1) > 420);
        String[] info = {String.valueOf(answer2), Integer.toString(spaces_right1 / 30), Integer.toString(spaces_down1 / 30)};
        return info;

    }

    public static String WORD1() {

        String word1 = "";
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 110, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Enter your word: ", 460, 150);
        c.setCursor(9, 74);
        word1 = c.readLine();

        return word1;

    }

    public static void word1(int z, Color tilecolor2, int turns, int[] rack1, int[] rack2, String[] alpha, String name1, String name2, int count) {
        char answer2 = ' ';
        do {
            c.setColor(tilecolor2);
            c.fillRect(461, 146, 74, 39);
            c.fillRect(556, 146, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Word Orientation?", 490, 130);
            c.setFont(new Font("Ariel", Font.PLAIN, 10));
            c.drawString("HORIZONTAL", 465, 170);
            c.drawString("(H)", 490, 180);
            c.drawString("VERTICAL (V)", 560, 170);
            c.drawRect(460, 145, 75, 40);
            c.drawRect(555, 145, 75, 40);
            answer2 = c.getChar();
            if (answer2 == 'H') {
                c.setColor(Color.white);
                c.fillRect(460, 110, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Horizontal Selected", 495, 485);
            }
            if (answer2 == 'V') {
                c.setColor(Color.white);
                c.fillRect(460, 110, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Vertical Selected", 500, 485);
            }
        } while (answer2 != 'H' && answer2 != 'V');

        int spaces_right1 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces to the right?", 460, 155);
            c.setCursor(8, 77);
            spaces_right1 = c.readInt();
            if (((spaces_right1) % 30 != 0) || (spaces_right1) < 0 || (spaces_right1) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(450, 450, 300, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 13));
                c.drawString((spaces_right1) + " spaces to the right saved", 460, 485);
            }
        } while (((spaces_right1) % 30 != 0) || (spaces_right1) < 0 || (spaces_right1) > 420);

        int spaces_down1 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces down?", 460, 195);
            c.setCursor(10, 77);
            spaces_down1 = c.readInt();
            if (((spaces_down1) % 30 != 0) || (spaces_down1) < 0 || (spaces_down1) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString((spaces_down1) + " spaces down saved", 470, 485);
            }
        } while (((spaces_down1) % 30 != 0) || (spaces_down1) < 0 || (spaces_down1) > 420);

        int word_length1 = 0;
        do {
            c.setColor(Color.white);
            c.fillRect(460, 110, 200, 100);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Length of word?", 460, 155);
            c.setCursor(8, 77);
            word_length1 = c.readInt();
            if ((word_length1) < 0 || (word_length1) > 7) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid input", 510, 485);
            }
            if (answer2 == 'H') {
                if (((word_length1) * 30) + spaces_right1 > 450) {
                    c.setColor(Color.white);
                    c.fillRect(460, 450, 200, 100);
                    c.setColor(Color.black);
                    c.setFont(new Font("Ariel", Font.PLAIN, 15));
                    c.drawString("Word is off the board", 480, 485);
                }
            }
            if (answer2 == 'V') {
                if (((word_length1) * 30) + spaces_down1 > 450) {
                    c.setColor(Color.white);
                    c.fillRect(460, 450, 200, 100);
                    c.setColor(Color.black);
                    c.setFont(new Font("Ariel", Font.PLAIN, 15));
                    c.drawString("Word is off the board", 480, 485);
                }
            }
        } while ((word_length1) < 0 || (word_length1) > 7 || ((word_length1) * 30) + spaces_right1 > 450 || ((word_length1) * 30) + spaces_down1 > 450);
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 110, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Length of " + (word_length1) + " saved", 495, 485);

        String[] word_letters1 = new String[word_length1];
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        //DO WHILE LOOP NEEDED
        for (int i = 0; i < word_length1; i++) {
            c.setColor(Color.white);
            c.fillRect(460, 110, 200, 100);
            c.setColor(Color.black);
            c.drawString("Enter tile number " + (i + 1), 460, 155);
            c.setCursor(8, 77);
            word_letters1[i] = c.readLine();
            if (word_letters1[i].equals("_")) {
                c.setColor(Color.white);
                c.fillRect(460, 160, 200, 50);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 11));
                c.drawString("What letter would you like?", 460, 195);
                c.setCursor(10, 77);
                String special_letter1 = c.readLine();
                word_letters1[i] = special_letter1;
            } else if (word_letters1[i].equals(alpha[rack1[0]]) || word_letters1[i].equals(alpha[rack1[1]]) || word_letters1[i].equals(alpha[rack1[2]]) || word_letters1[i].equals(alpha[rack1[3]]) || word_letters1[i].equals(alpha[rack1[4]]) || word_letters1[i].equals(alpha[rack1[5]]) || word_letters1[i].equals(alpha[rack1[6]])) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("" + (word_letters1[i]) + " saved", 530, 485);
            } else //if (word_letters1 [i] != alpha [rack1 [0]] && word_letters1 [i] != alpha [rack1 [1]] && word_letters1 [i] != alpha [rack1 [2]] && word_letters1 [i] != alpha [rack1 [3]] && word_letters1 [i] != alpha [rack1 [4]] && word_letters1 [i] != alpha [rack1 [5]] && word_letters1 [i] != alpha [rack1 [6]])
            {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("You do not have this letter", 465, 485);
            }
        }

        String word1 = "";
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 110, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Enter your word: ", 460, 155);
        c.setCursor(8, 74);
        word1 = c.readLine();

    }

    public static char redraw2(Color tilecolor2) {
        c.setColor(Color.white);
        c.fillRect(460, 110, 200, 100);
        c.fillRect(460, 450, 200, 100);
        char reply = ' ';
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            //c.drawString ("" + (name2) + "'s Turn", 510, 485);
            c.setColor(tilecolor2);
            c.fillRect(461, 386, 74, 39);
            c.fillRect(556, 386, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Redraw all letters?", 490, 370);
            c.drawString("YES (Y)", 473, 410);
            c.drawString("NO (N)", 570, 410);
            c.drawRect(460, 385, 75, 40);
            c.drawRect(555, 385, 75, 40);
            reply = c.getChar();
            if (reply == 'Y') {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.fillRect(460, 350, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Yes Selected", 510, 485);

            }
            if (reply == 'N') {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.fillRect(460, 350, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("No Selected", 510, 485);

            }
        } while (reply != 'Y' && reply != 'N');
        return reply;
    }

    public static String[] Word2(Color tilecolor2) {
        char reply2 = ' ';
        do {
            c.setColor(tilecolor2);
            c.fillRect(461, 386, 74, 39);
            c.fillRect(556, 386, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Word Orientation?", 490, 370);
            c.setFont(new Font("Ariel", Font.PLAIN, 10));
            c.drawString("HORIZONTAL", 465, 410);
            c.drawString("(H)", 490, 420);
            c.drawString("VERTICAL (V)", 560, 410);
            c.drawRect(460, 385, 75, 40);
            c.drawRect(555, 385, 75, 40);
            reply2 = c.getChar();
            if (reply2 == 'H') {
                c.setColor(Color.white);
                c.fillRect(460, 350, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Horizontal Selected", 495, 485);
            }
            if (reply2 == 'V') {
                c.setColor(Color.white);
                c.fillRect(460, 350, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Vertical Selected", 500, 485);
            }
        } while (reply2 != 'H' && reply2 != 'V');

        int spaces_right2 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces to the right?", 460, 388);
            c.setCursor(23, 77);
            spaces_right2 = c.readInt();
            if (((spaces_right2) % 30 != 0) || (spaces_right2) < 0 || (spaces_right2) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(450, 450, 300, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 13));
                c.drawString((spaces_right2) + " spaces to the right saved", 460, 485);
            }
        } while (((spaces_right2) % 30 != 0) || (spaces_right2) < 0 || (spaces_right2) > 420);

        int spaces_down2 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces down?", 460, 438);
            c.setCursor(26, 77);
            spaces_down2 = c.readInt();
            if (((spaces_down2) % 30 != 0) || (spaces_down2) < 0 || (spaces_down2) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString((spaces_down2) + " spaces down saved", 470, 485);
            }
        } while (((spaces_down2) % 30 != 0) || (spaces_down2) < 0 || (spaces_down2) > 420);
        String[] info = {String.valueOf(reply2), Integer.toString(spaces_right2 / 30), Integer.toString(spaces_down2 / 30)};
        return info;

    }

    public static String WORD2() {
        String word2 = "";
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 350, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Enter your word: ", 460, 387);
        c.setCursor(23, 74);
        word2 = c.readLine();
        return word2;
    }

    public static void word2(int z, Color tilecolor2, int turns, int[] rack1, int[] rack2, String[] alpha, String name1, String name2, int count) {
        char reply2 = ' ';
        do {
            c.setColor(tilecolor2);
            c.fillRect(461, 386, 74, 39);
            c.fillRect(556, 386, 74, 39);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Word Orientation?", 490, 370);
            c.setFont(new Font("Ariel", Font.PLAIN, 10));
            c.drawString("HORIZONTAL", 465, 410);
            c.drawString("(H)", 490, 420);
            c.drawString("VERTICAL (V)", 560, 410);
            c.drawRect(460, 385, 75, 40);
            c.drawRect(555, 385, 75, 40);
            reply2 = c.getChar();
            if (reply2 == 'H') {
                c.setColor(Color.white);
                c.fillRect(460, 350, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Horizontal Selected", 495, 485);
            }
            if (reply2 == 'V') {
                c.setColor(Color.white);
                c.fillRect(460, 350, 200, 100);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Vertical Selected", 500, 485);
            }
        } while (reply2 != 'H' && reply2 != 'V');

        int spaces_right2 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces to the right?", 460, 395);
            c.setCursor(20, 77);
            spaces_right2 = c.readInt();
            if (((spaces_right2) % 30 != 0) || (spaces_right2) < 0 || (spaces_right2) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(450, 450, 300, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 13));
                c.drawString((spaces_right2) + " spaces to the right saved", 460, 485);
            }
        } while (((spaces_right2) % 30 != 0) || (spaces_right2) < 0 || (spaces_right2) > 420);

        int spaces_down2 = 0;
        do {
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Spaces down?", 460, 435);
            c.setCursor(22, 77);
            spaces_down2 = c.readInt();
            if (((spaces_down2) % 30 != 0) || (spaces_down2) < 0 || (spaces_down2) > 420) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid Selection", 500, 485);
            } else {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString((spaces_down2) + " spaces down saved", 470, 485);
            }
        } while (((spaces_down2) % 30 != 0) || (spaces_down2) < 0 || (spaces_down2) > 420);

        int word_length2 = 0;
        do {
            c.setColor(Color.white);
            c.fillRect(460, 350, 200, 100);
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 15));
            c.drawString("Length of word?", 460, 395);
            c.setCursor(20, 77);
            word_length2 = c.readInt();
            if ((word_length2) < 0 || (word_length2) > 7) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("Invalid input", 510, 485);
            }
            if (reply2 == 'H') {
                if (((word_length2) * 30) + spaces_right2 > 450) {
                    c.setColor(Color.white);
                    c.fillRect(460, 450, 200, 100);
                    c.setColor(Color.black);
                    c.setFont(new Font("Ariel", Font.PLAIN, 15));
                    c.drawString("Word is off the board", 480, 485);
                }
            }
            if (reply2 == 'V') {
                if (((word_length2) * 30) + spaces_down2 > 450) {
                    c.setColor(Color.white);
                    c.fillRect(460, 450, 200, 100);
                    c.setColor(Color.black);
                    c.setFont(new Font("Ariel", Font.PLAIN, 15));
                    c.drawString("Word is off the board", 480, 485);
                }
            }
        } while ((word_length2) < 0 || (word_length2) > 7 || ((word_length2) * 30) + spaces_right2 > 450 || ((word_length2) * 30) + spaces_down2 > 450);
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 350, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Length of " + (word_length2) + " saved", 495, 485);

        String[] word_letters2 = new String[word_length2];
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        for (int i = 0; i < word_length2; i++) {
            c.setColor(Color.white);
            c.fillRect(460, 350, 200, 100);
            c.setColor(Color.black);
            c.drawString("Enter tile number " + (i + 1), 460, 395);
            c.setCursor(20, 77);
            word_letters2[i] = c.readLine();
            if ((word_letters2[i]) == "_") {
                c.setColor(Color.white);
                c.fillRect(460, 400, 200, 50);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("What letter would you like?", 460, 435);
                c.setCursor(22, 77);
                String special_letter2 = c.readLine();
                word_letters2[i] = special_letter2;
            } else if (word_letters2[i] == alpha[rack1[0]] || word_letters2[i] == alpha[rack1[1]] || word_letters2[i] == alpha[rack1[2]] || word_letters2[i] == alpha[rack1[3]] || word_letters2[i] == alpha[rack1[4]] || word_letters2[i] == alpha[rack1[5]] || word_letters2[i] == alpha[rack1[6]]) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("" + (word_letters2[i]) + " saved", 530, 485);
            } else if (word_letters2[i] != alpha[rack1[0]] && word_letters2[i] != alpha[rack1[1]] && word_letters2[i] != alpha[rack1[2]] && word_letters2[i] != alpha[rack1[3]] && word_letters2[i] != alpha[rack1[4]] && word_letters2[i] != alpha[rack1[5]] && word_letters2[i] != alpha[rack1[6]]) {
                c.setColor(Color.white);
                c.fillRect(460, 450, 200, 100);
                c.setColor(Color.black);
                c.setFont(new Font("Ariel", Font.PLAIN, 15));
                c.drawString("You do not have this letter", 465, 485);
            }

        }

        String word2 = "";
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 350, 200, 100);
        c.setColor(Color.black);
        c.setFont(new Font("Ariel", Font.PLAIN, 15));
        c.drawString("Enter your word: ", 460, 395);
        c.setCursor(20, 74);
        word2 = c.readLine();

    }

    public static void board_placement2(String[] word_letters2, String reply2, int spaces_right2, int spaces_down2, Color tilecolor2) {
        c.setColor(Color.white);
        c.fillRect(460, 450, 200, 100);
        c.fillRect(460, 350, 200, 100);
        c.setColor(Color.black);
        int word_board2 = word_letters2.length * 30;
        if (reply2.equals("H")) {
            int horizontal_board2 = spaces_right2 + word_board2;
            for (int i = ((spaces_right2) + 1); i < ((horizontal_board2) + 1); i += 30) {
                c.setColor(tilecolor2);
                c.fillRect(i, ((spaces_down2) + 1), 29, 29);
            }
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 20));
            for (int x = 0; x < word_letters2.length; x++) {
                if (x == 0) {
                    if (word_letters2[0].equals("Q")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 7), (spaces_down2 + 19));
                    } else if (word_letters2[0].equals("W") || word_letters2[0].equals("M")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 7), (spaces_down2 + 19));
                    } else if (word_letters2[0].equals("I") || word_letters2[0].equals("J")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 9), (spaces_down2 + 20));
                    }
                }
                if (x == 1) {
                    if (word_letters2[1].equals("Q")) {
                        c.drawString("" + (word_letters2[1]), ((spaces_right2 + 30) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[1].equals("W") || word_letters2[1].equals("M")) {
                        c.drawString("" + (word_letters2[1]), ((spaces_right2 + 30) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[1].equals("I") || word_letters2[1].equals("J")) {
                        c.drawString("" + (word_letters2[1]), ((spaces_right2 + 30) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[1]), ((spaces_right2 + 30) + 9), (spaces_down2 + 20));
                    }
                } else if (x == 2) {
                    if (word_letters2[2].equals("Q")) {
                        c.drawString("" + (word_letters2[2]), ((spaces_right2 + 60) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[2].equals("W") || word_letters2[2].equals("M")) {
                        c.drawString("" + (word_letters2[2]), ((spaces_right2 + 60) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[2].equals("I") || word_letters2[2].equals("J")) {
                        c.drawString("" + (word_letters2[2]), ((spaces_right2 + 60) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[2]), ((spaces_right2 + 60) + 9), (spaces_down2 + 20));
                    }
                } else if (x == 3) {
                    if (word_letters2[3].equals("Q")) {
                        c.drawString("" + (word_letters2[3]), ((spaces_right2 + 90) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[3].equals("W") || word_letters2[3].equals("M")) {
                        c.drawString("" + (word_letters2[3]), ((spaces_right2 + 90) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[3].equals("I") || word_letters2[3].equals("J")) {
                        c.drawString("" + (word_letters2[3]), ((spaces_right2 + 90) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[3]), ((spaces_right2 + 90) + 9), (spaces_down2 + 20));
                    }
                } else if (x == 4) {
                    if (word_letters2[4].equals("Q")) {
                        c.drawString("" + (word_letters2[4]), ((spaces_right2 + 120) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[4].equals("W") || word_letters2[4].equals("M")) {
                        c.drawString("" + (word_letters2[4]), ((spaces_right2 + 120) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[4].equals("I") || word_letters2[4].equals("J")) {
                        c.drawString("" + (word_letters2[4]), ((spaces_right2 + 120) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[4]), ((spaces_right2 + 120) + 9), (spaces_down2 + 20));
                    }
                } else if (x == 5) {
                    if (word_letters2[5].equals("Q")) {
                        c.drawString("" + (word_letters2[5]), ((spaces_right2 + 150) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[5].equals("W") || word_letters2[5].equals("M")) {
                        c.drawString("" + (word_letters2[5]), ((spaces_right2 + 150) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[5].equals("I") || word_letters2[5].equals("J")) {
                        c.drawString("" + (word_letters2[5]), ((spaces_right2 + 150) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[5]), ((spaces_right2 + 150) + 9), (spaces_down2 + 20));
                    }
                } else if (x == 6) {
                    if (word_letters2[6].equals("Q")) {
                        c.drawString("" + (word_letters2[6]), ((spaces_right2 + 180) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[6].equals("W") || word_letters2[6].equals("M")) {
                        c.drawString("" + (word_letters2[6]), ((spaces_right2 + 180) + 7), (spaces_down2 + 19));
                    } else if (word_letters2[6].equals("I") || word_letters2[6].equals("J")) {
                        c.drawString("" + (word_letters2[6]), ((spaces_right2 + 180) + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[6]), ((spaces_right2 + 180) + 9), (spaces_down2 + 20));
                    }
                }

            }
            /*
             c.setFont(new Font ("Ariel", Font.PLAIN, 10));
             if((letter_value [rack2 [6]] - 10) != 0)
             {
             c.drawString (" " + (letter_value [rack2 [6]]), 514, 336);
             }
             else
             {
             c.drawString (" " + (letter_value [rack2 [6]]), 509, 336);
             }
             points ();*/
        }

        if (reply2.equals("V")) {
            int vertical_board2 = spaces_down2 + word_board2;
            for (int i = ((spaces_down2) + 1); i < ((vertical_board2) + 1); i += 30) {
                c.setColor(tilecolor2);
                c.fillRect(((spaces_right2) + 1), i, 29, 29);
            }
            c.setColor(Color.black);
            c.setFont(new Font("Ariel", Font.PLAIN, 20));
            for (int x = 0; x < word_letters2.length; x++) {
                if (x == 0) {
                    if (word_letters2[0].equals("Q")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 7), (spaces_down2 + 19));
                    } else if (word_letters2[0].equals("W") || word_letters2[0].equals("M")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 7), (spaces_down2 + 19));
                    } else if (word_letters2[0].equals("I") || word_letters2[0].equals("J")) {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 13), (spaces_down2 + 20));
                    } else {
                        c.drawString("" + (word_letters2[0]), (spaces_right2 + 9), (spaces_down2 + 20));
                    }
                } else if (x == 1) {
                    if (word_letters2[1].equals("Q")) {
                        c.drawString("" + (word_letters2[1]), (spaces_right2 + 7), ((spaces_down2 + 30) + 19));
                    } else if (word_letters2[1].equals("W") || word_letters2[1].equals("M")) {
                        c.drawString("" + (word_letters2[1]), (spaces_right2 + 7), ((spaces_down2 + 30) + 19));
                    } else if (word_letters2[1].equals("I") || word_letters2[1].equals("J")) {
                        c.drawString("" + (word_letters2[1]), (spaces_right2 + 13), ((spaces_down2 + 30) + 20));
                    } else {
                        c.drawString("" + (word_letters2[1]), ((spaces_right2) + 9), ((spaces_down2 + 30) + 20));
                    }
                } else if (x == 2) {
                    if (word_letters2[2].equals("Q")) {
                        c.drawString("" + (word_letters2[2]), (spaces_right2 + 7), ((spaces_down2 + 60) + 19));
                    } else if (word_letters2[2].equals("W") || word_letters2[2].equals("M")) {
                        c.drawString("" + (word_letters2[2]), (spaces_right2 + 7), ((spaces_down2 + 60) + 19));
                    } else if (word_letters2[2].equals("I") || word_letters2[2].equals("J")) {
                        c.drawString("" + (word_letters2[2]), (spaces_right2 + 13), ((spaces_down2 + 60) + 20));
                    } else {
                        c.drawString("" + (word_letters2[2]), ((spaces_right2) + 9), ((spaces_down2 + 60) + 20));
                    }
                } else if (x == 3) {
                    if (word_letters2[3].equals("Q")) {
                        c.drawString("" + (word_letters2[3]), (spaces_right2 + 7), ((spaces_down2 + 90) + 19));
                    } else if (word_letters2[3].equals("W") || word_letters2[3].equals("M")) {
                        c.drawString("" + (word_letters2[3]), (spaces_right2 + 7), ((spaces_down2 + 90) + 19));
                    } else if (word_letters2[3].equals("I") || word_letters2[3].equals("J")) {
                        c.drawString("" + (word_letters2[3]), (spaces_right2 + 13), ((spaces_down2 + 90) + 20));
                    } else {
                        c.drawString("" + (word_letters2[3]), ((spaces_right2) + 9), ((spaces_down2 + 90) + 20));
                    }
                } else if (x == 4) {
                    if (word_letters2[4].equals("Q")) {
                        c.drawString("" + (word_letters2[4]), (spaces_right2 + 7), ((spaces_down2 + 120) + 19));
                    } else if (word_letters2[4].equals("W") || word_letters2[4].equals("M")) {
                        c.drawString("" + (word_letters2[4]), (spaces_right2 + 7), ((spaces_down2 + 120) + 19));
                    } else if (word_letters2[4].equals("I") || word_letters2[4].equals("J")) {
                        c.drawString("" + (word_letters2[4]), (spaces_right2 + 13), ((spaces_down2 + 120) + 20));
                    } else {
                        c.drawString("" + (word_letters2[4]), ((spaces_right2) + 9), ((spaces_down2 + 120) + 20));
                    }
                } else if (x == 5) {
                    if (word_letters2[5].equals("Q")) {
                        c.drawString("" + (word_letters2[5]), (spaces_right2 + 7), ((spaces_down2 + 150) + 19));
                    } else if (word_letters2[5].equals("W") || word_letters2[5].equals("M")) {
                        c.drawString("" + (word_letters2[5]), (spaces_right2 + 7), ((spaces_down2 + 150) + 19));
                    } else if (word_letters2[5].equals("I") || word_letters2[5].equals("J")) {
                        c.drawString("" + (word_letters2[5]), (spaces_right2 + 13), ((spaces_down2 + 150) + 20));
                    } else {
                        c.drawString("" + (word_letters2[5]), ((spaces_right2) + 9), ((spaces_down2 + 150) + 20));
                    }
                } else if (x == 6) {
                    if (word_letters2[6].equals("Q")) {
                        c.drawString("" + (word_letters2[6]), (spaces_right2 + 7), ((spaces_down2 + 180) + 19));
                    } else if (word_letters2[6].equals("W") || word_letters2[6].equals("M")) {
                        c.drawString("" + (word_letters2[6]), (spaces_right2 + 7), ((spaces_down2 + 180) + 19));
                    } else if (word_letters2[6].equals("I") || word_letters2[6].equals("J")) {
                        c.drawString("" + (word_letters2[6]), (spaces_right2 + 13), ((spaces_down2 + 180) + 20));
                    } else {
                        c.drawString("" + (word_letters2[6]), ((spaces_right2) + 9), ((spaces_down2 + 180) + 20));
                    }
                }
                /*
                 points ();*/

            }
        }

    }
}

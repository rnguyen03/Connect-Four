package connectfour;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**<p>Output and prompts class<p>
 */
public class TextUI{
    //Class Name
    private String toString = "TextUI";
    //Number of turns passed
    private int turn;
    //Holds Win Bool
    private char winner;
    //Declares symbol for printing
    private char localSymbol;
    //Exception variable declaration
    private ArrayIndexOutOfBoundsException printExcept;
    //Column Label For Players
    private ArrayList<Character> boardLabel= 
            new ArrayList<>(Arrays.asList('-','-','-','-','-','-','-','-','-','-','-','-','-','\n',
                                           '1','|','2','|','3','|','4','|','5','|','6','|','7','\n'));
    //Board for TextUI
    private ArrayList<List<Character>> textBoardArr = new ArrayList<>(Arrays.asList(
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'), //0
        Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'), //1
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'), //2
        Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'), //3
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'), //4
        Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'), //5
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'), //6
        Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'), //7
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'), //8
        Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'), //9
        Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0') //10
                           //0   1   2   3   4   5   6   7   8   9  10  11  12
    ));

    /**<p>Generates a string to the class<p>
     * @param none
     * @return String
     */
    public String toString(){
        return toString;
    }

    /**<p>Prints the board<p>
     * @param ArrayList<List<Character>> printBoard
     * @return NULL
     */
    private void printBoard(ArrayList<List<Character>> printBoard) {
        //Prints every element in array list (prints board)
        for (List<Character> row : printBoard) {
            for (char tile : row) {
                System.out.print(tile); 
            }
            System.out.println();
         } 

        for (int i = 0; i < boardLabel.size(); i++) {
            //Prints element
            System.out.print(boardLabel.get(i));
        }
    }

    /**<p>Prints tie statement<p>
     * @param ArrayList<List<Character>> printBoard
     * @return NULL
     */
    private void printTie() {
        System.out.println("The game was a Tie!");
    }

    /**<p>Prompts user input and calls the prompt method<p>
     * @param int turnCount
     * @return playInput
     */
    private int promptPrint(int turnCount) {
        //Declare Player turn
        System.out.println("Turn = " + (turnCount + 1));
        //Prompt Player
        System.out.println("Enter Desired Column between 1 and 7, or press 8 to save ");
        int playInput = playerInput() - 1;
        return playInput;
    }

    /**<p>Prompts user illegal move<p>
     * @param NONE
     * @return NULL
     */
    private void promptIllegal() {
        System.out.println("Illegal Move, try again!");
    }

    /**<p>Prompts user input and calls the prompt method<p>
     * @param int turnCount
     * @return NULL
     */
    private void printWin(char winnerSym) {
        System.out.println("The winner is " + winnerSym);
    }

    /**<p>Scan user input and catch exceptions<p>
     * @param int turnCount
     * @return NULL
     */
    private int playerInput() {
        int result = -1;
        Scanner input;
        boolean valid = false;
        do {
            try {
                input = new Scanner(System.in);
                result = input.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Please select a number between 1 and 8");
            }
            if (result < 9 && result > 0){
                valid = true;
            } else {
                System.out.println("Invalid Input!");
            }
        } while (!valid);
        return result;
    }

    /**<p>Prompts user if they want to load a file<p>
     * @param NONE
     * @return true or dlase
     */
    private boolean promptLoad() {
        String loadAn = "\0";
        System.out.println("Would you like to load a saved game? (y/n)");

        while (true) {
            try{
                Scanner strIn = new Scanner(System.in);
                loadAn = strIn.nextLine();
            } catch (InputMismatchException exception){
                System.out.println(exception.getMessage());
                System.out.println("Input error!");
            }
            //implement try/catch
            if (loadAn.equals("y")) {
                return true;
            } else if (loadAn.equals("n")) {
                return false;
            } else {
                System.out.println("Incorrect input try again.");
            }
        }
    }

    /**<p>Prompts the user to play again<p>
     * @param NONE
     * @return true or false
     */
    private boolean promptPlayAgain() {
        String userAn;
        System.out.println("Would you like to play again? (y/n)");
        //implement try/catch
        while (true) {
            Scanner strIn = new Scanner(System.in);
            userAn = strIn.nextLine();
            if (userAn.equals("y")) {
                return false;
            } else if (userAn.equals("n")) {
                return true;
            } else {
                System.out.println("Incorrect input try again.");
            }
        }
    }

    /**<p>Prompt user for file name and returns the info<p>
     * @param NONE
     * @return String fileAn
     */
    private String filePrompt(){
        System.out.println("Input filename (ex. saveboard.csv): ");
        String fileAn = "saveboard.csv";
        try{
            Scanner strIn = new Scanner(System.in);
            fileAn = strIn.nextLine();
        } catch (InputMismatchException exception){
            System.out.println(exception.getMessage());
            System.out.println("Input error!");
        }
        return fileAn;
    }

    /**<p>Prompt user for file directory and returns the info<p>
     * @param NONE
     * @return String directoryAn
     */
    private String directoryPrompt(){
        System.out.println("Input filedirectory (ex. ./assets/): ");
        String directoryAn = "./assets/";
        try{
            Scanner strIn = new Scanner(System.in);
            directoryAn = strIn.nextLine();
        } catch (InputMismatchException exception){
            System.out.println(exception.getMessage());
            System.out.println("Input error!");
        }
        return directoryAn;
    }

    /**<p>Prints player symbol<p>
     * @param NONE
     * @return NONE
     */
    private void printSymbol(char printSymbol){
        System.out.println("Player turn: " + printSymbol);
    }

    /**<p>Prints exception error<p>
     * @param NONE
     * @return NONE
     */
    private void exceptionPrint(ArrayIndexOutOfBoundsException printException) {
        System.out.println(printException.getMessage());
        System.out.println("Improper File Formatting");
    }

    /**<p>Sets turn variables<p>
     * @param turnNum
     * @return NONE
     */
    public void setTurn(int turnNum) {
        turn = turnNum;
    }

    /**<p>Sets turn print win variables<p>
     * @param symbolW
     * @return NONE
     */
    public void setPrintWin(char symbolW) {
        winner = symbolW;
    }

    /**<p>Calls prompt method<p>
     * @param NONE
     * @return promptPrint(turn)
     */
    public int getPromptPrint() {
        return promptPrint(turn);
    }

    /**<p>Calls print tie method<p>
     * @param NONE
     * @return NONE
     */
    public void getPrintTie() {
        printTie();
    }

    /**<p>Calls print illegal method<p>
     * @param NONE
     * @return NONE
     */
    public void getPromptIllegal() {
        promptIllegal();
    }

    /**<p>Sets print board veriables<p>
     * @param NONE
     * @return NONE
     */
    public void setPrintBoard(ArrayList<List<Character>> boardPos) {
        textBoardArr = boardPos;
    }

    /**<p>Calls print board method<p>
     * @param NONE
     * @return NONE
     */
    public void getPrintBoard() {
        printBoard(textBoardArr);
    }

    /**<p>Calls print win method<p>
     * @param NONE
     * @return NONE
     */
    public void getPrintWin() {
        printWin(winner);
    }

    /**<p>Calls prompt play again method<p>
     * @param NONE
     * @return NONE
     */
    public boolean getPromptPlayAgain() {
        return promptPlayAgain();
    }

    /**<p>Calls prompt load method<p>
     * @param NONE
     * @return NONE
     */
    public boolean getPromptLoad() {
        return promptLoad();
    }

    /**<p>Calls prompt play again method<p>
     * @param NONE
     * @return NONE
     */
    public String getFilePrompt() {
        return filePrompt();
    }
    
    /**<p>Calls prompt play directory method<p>
     * @param NONE
     * @return NONE
     */
    public String getDirectoryPrompt() {
        return directoryPrompt();
    }

     /**<p>Sets variables for exception print method<p>
     * @param ArrayIndexOutOfBoundsException passException
     * @return NONE
     */
    public void setExceptionPrint(ArrayIndexOutOfBoundsException passException){
        printExcept = passException;
    }

    /**<p>Calls exception print method<p>
     * @param NONE
     * @return NONE
     */
    public void getExceptionPrint(){
        exceptionPrint(printExcept);
    }
    
    /**<p>Sets print symbol method varaibles<p>
     * @param NONE
     * @return NONE
     */
    public void setPrintSymbol(char passSymbol){
        localSymbol = passSymbol;
    }

    /**<p>Calls print symbol method<p>
     * @param NONE
     * @return NONE
     */
    public void getPrintSymbol(){
        printSymbol(localSymbol);
    }
}
package connectfour;
import java.util.ArrayList;
import java.util.List;


/** <p>This class encapsulates the basic rules of GameRules 
 * and acts like a referee.<p>
 */
public class GameRules {
    private ArrayList<List<Character>> currentBoardArr;
    private Counter loadCount = new Counter();
    private boolean end = false;
    private boolean loadf = false;
    private boolean win = false;
    private char pSymbol = (char)35;
    private int playerMove;
    private int counter = 0;
    private String filename;
    private String fileLocation;

    /** <p>This public method will call all of the individual 
     * private methods and use the return values to manage
     * the game. This method requires a board object as a
     * parameter to keep track of the moves played.<p>
     * @param Board gameBoard, textBoard
     * @return NULL
     */
    public void gameStart(Board gameBoard, TextUI gameText){
        while (!end){
        win = false;
        counter = 0;
        loadf = gameText.getPromptLoad();
        if (loadf) {
            filename = gameText.getFilePrompt();
            fileLocation = gameText.getDirectoryPrompt();
            catchLoadBoard(gameBoard, gameText);
            currentBoardArr = gameBoard.getBoard();
            loadCount.setCountMoves(currentBoardArr);
            counter = loadCount.getCountMoves();
            localPrintBoard(gameText, pSymbol);
        } else {
            currentBoardArr = gameBoard.getBoard();
            localPrintBoard(gameText, pSymbol);
        }
            while (!win){
                setTurn(gameBoard, gameText);
                if (gameBoard.getTieCheck()){
                    gameText.getPrintTie();
                }
                pSymbol = checkPlayerTurn(counter);
                playerMove = gameText.getPromptPrint();
                if (playerMove == 7) {
                    filename = gameText.getFilePrompt();
                    fileLocation = gameText.getDirectoryPrompt();
                    gameBoard.saveBoard(filename, fileLocation);
                    localPrintBoard(gameText, pSymbol);
                } else {
                    gameBoard.setPlayerMove(playerMove, pSymbol);
                    if (legalCheck(gameBoard)) {
                        gameBoard.getUpdateBoard();
                        localPrintBoard(gameText, pSymbol);
                        win = gameBoard.getCheckWin();
                        ++counter;
                        localPrintWin(gameText, pSymbol, win);
                    } else {
                        gameText.getPromptIllegal();
                        localPrintWin(gameText, pSymbol, win);
                    }
                }
            }
            loadf = false;
            end = gameText.getPromptPlayAgain();
            gameBoard.getFlushPrivBoard();
        }
    }

    /**<p>Checks player turn even or odd<p>
     * @param int turn
     * @return $ or #
     */
    private char checkPlayerTurn(int turn) {
        //Decides who plays depending if the turn us even or odd
        if (turn % 2 == 0) {
            return (char)36;
        } else {
            return (char)35;
        }
    }
    
    /**<p>Calls print board and prints who's turn it is<p>
     * @param TextUI setText
     * @return NULL
     */
    private void localPrintBoard(TextUI setText, char printSymbol){
        setText.setPrintBoard(currentBoardArr);
        if (printSymbol == (char)36){
            printSymbol = (char)35;
        } else if (printSymbol == (char)35){
            printSymbol = (char)36;
        }
        setText.setPrintSymbol(printSymbol);
        setText.getPrintBoard();
        setText.getPrintSymbol();
    }

    /**<p>Calls a board method which checks to see if the 
     *    column that the user selected is full<p>
     * @param Board localBoard
     * @return true or false
     */
    private boolean legalCheck(Board localBoard) {
        boolean cLegal = false;
        cLegal = localBoard.getCheckColumnOverflow();
        if (cLegal){
            return true;
        }
        return false;
    }

    /**<p>Calls a board method and text method
     *    sets turn data in other classes<p>
     * @param Board boardSet, textSet
     * @return NULL
     */
    private void setTurn(Board boardSet, TextUI textSet){
        textSet.setTurn(counter);
        boardSet.setTurn(counter);
    }

    /**<p>Sets and gets method from TextUI class<p>
     * @param TextUI localTextWin, char localSymbol, boolean localWin
     * @return NULL
     */
    private void localPrintWin(TextUI localTextWin, char localSymbol, boolean localWin){
        if (localWin){
            localTextWin.setPrintWin(pSymbol);
            localTextWin.getPrintWin();
        }
    }

    /**<p>Performs a try/catch for board loading<p>
     * @param Board catchBoard, TextUI catchText
     * @return NULL
     */
    private void catchLoadBoard(Board catchBoard, TextUI catchText){
        try{
            catchBoard.loadBoard(filename, fileLocation);
        } catch (ArrayIndexOutOfBoundsException exception) {
            catchText.setExceptionPrint(exception);
            catchText.getExceptionPrint();
        }
    }

    /**<p>Generates a string to the class<p>
     * @param none
     * @return String
     */
    public String toString(){
        String gameString = "game logic class";
        return gameString;
    }
}

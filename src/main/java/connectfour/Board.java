package connectfour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**<p>Class that updates the board<p>
 */
public class Board{
    private int playerM;
    private int rowPlayed;
    private char playerS;
    private int turnCount;
    private ReadTextFile loadBoard;
    private SaveTextFile gameSaver;
    private ArrayList<Integer> rowIndex = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12));
    private ArrayList<List<Character>> privBoard = new ArrayList<>(Arrays.asList(
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

    /**<p>Builds class string (board)<p>
     * @param NONE
     * @return String stringBoard
     */
    public String stringBuilder() {
        String stringBoard = "";
        char cr = '\r';
        int count = 0;
        //ArrayList<Character> charBoard = new  ArrayList<>();
        for (List<Character> row : privBoard) {
            for (char tile : row) {
                if (tile == '0'){
                    stringBoard += tile;
                    stringBoard += ',';
                } else if (tile == (char)36) {
                    stringBoard += '1';
                    stringBoard += ',';
                } else if (tile == (char)35) {
                    stringBoard += '2';
                    stringBoard += ',';
                }
            }
            if (count % 2 != 0) {
                stringBoard += cr;
            }
            ++count;
         }
         return stringBoard;
         
    }

    /**<p>Generates a string to the class<p>
     * @param none
     * @return String
     */
    public String toString(){
        return stringBuilder();
    }

    private boolean checkColumnOverflow(int moveC){
        moveC = rowIndex.get(moveC);
        if (privBoard.get(0).get(moveC) == '0') {
            return true;
        }
        return false;
    }

    /**<p>Updates board when move and symbol are passed in<p>
     * @param int move, char playerSymbol
     * @return String stringBoard
     */
    private ArrayList<List<Character>> updateBoard(int move, char playerSymbol) {
        move = rowIndex.get(move);
        for (int i = 0; i < 11; i += 2){
            if (privBoard.get(10-i).get(move) == '0'){
                privBoard.get(10-i).set(move, playerSymbol);
                rowPlayed = 10 - i;
                break;
            }
        }
        return privBoard;
    }

    /**<p>Checks for player win<p>
     * @param NONE
     * @return true or false
     */
    private boolean checkWin(){
        playerM = rowIndex.get(playerM);
        if (checkRows() || checkColumns() || checkDiag()){
            return true;
        }
        return false;
    }

    /**<p>Checks rows for player win<p>
     * @param NONE
     * @return true or false
     */
    private boolean checkRows() {
        for (int i = 0; i < 7; i += 2) { 
                Set<Character> rowSet = new HashSet<Character>();
                rowSet.add(privBoard.get(rowPlayed).get(i));
                rowSet.add(privBoard.get(rowPlayed).get(i + 2));
                rowSet.add(privBoard.get(rowPlayed).get(i + 4));
                rowSet.add(privBoard.get(rowPlayed).get(i + 6));
            if (rowSet.size() == 1 && rowSet.contains(playerS)) {
                return true;
            }
        }
            return false;
    }
        
    /**<p>Checks columns for player win<p>
     * @param NONE
     * @return true or false
     */
    private boolean checkColumns() {
        for (int i = 0; i < 5; i += 2) {
                Set<Character> columnSet = new HashSet<Character>();
                columnSet.add(privBoard.get(i).get(playerM));
                columnSet.add(privBoard.get(i + 2).get(playerM));
                columnSet.add(privBoard.get(i + 4).get(playerM));
                columnSet.add(privBoard.get(i + 6).get(playerM));
            if (columnSet.size() == 1 && columnSet.contains(playerS)) {
                return true;
            }
        }
        return false;
    }

    /**<p>Checks diagonals for player win<p>
     * @param NONE
     * @return true or false
     */
    private boolean checkDiag() {
        Set<Character> diagSet;
        ArrayList<List<Integer>> directionV = new ArrayList<>(Arrays.asList(
            Arrays.asList(-2, -2),
            Arrays.asList(2, -2),
            Arrays.asList(2, 2),
            Arrays.asList(-2, 2)));

            for(List<Integer> point : directionV){
                int pointx = point.get(0);
                int pointy = point.get(1);

                int x = rowPlayed + 3 * pointx;
                int y = playerM + 3 * pointy;

                if (0 <= x && x < privBoard.size() + 1 && 0 <= y && y < privBoard.get(rowPlayed).size() + 1){
                    diagSet = new HashSet<Character>();
                    diagSet.add(privBoard.get(rowPlayed).get(playerM));
                    diagSet.add(privBoard.get(rowPlayed + pointx).get(playerM + pointy));
                    diagSet.add(privBoard.get(rowPlayed + pointx * 2).get(playerM + pointy * 2));
                    diagSet.add(privBoard.get(x).get(y));
                    if (diagSet.size() == 1 && diagSet.contains(playerS)) {
                        return true;
                    }
            }
        }
        return false;
    }

    /**<p>Checks player ties<p>
     * @param int turnCheck
     * @return true or false
     */
    private boolean tieCheck(int turnCheck) {
        if (turnCheck >= 42) {
            return true;
        }
        return false;
    }
    
    /**<p>Clears gameboard when game finishes<p>
     * @param NONE
     * @return NONE
     */
    private void flushPrivBoard() {
        privBoard = new ArrayList<>(Arrays.asList(
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'),
            Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'),
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'),
            Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'),
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'),
            Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'),
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'),
            Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'),
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0'),
            Arrays.asList('-','+','-','+','-','+','-','+','-','+','-','+','-'),
            Arrays.asList('0','|','0','|','0','|','0','|','0','|','0','|','0')));
    }

    /**<p>Calls read text files methods to load a board from file<p>
     * @param String fnameLoad, String directoryLoad
     * @return
     */
    public void loadBoard(String fnameLoad, String directoryLoad) {
        loadBoard = new ReadTextFile(fnameLoad, directoryLoad); 
        this.privBoard = loadBoard.readFile();
    }

    /**<p>Calls save text files methods to save a board to file<p>
     * @param String fnameLoad, String directoryLoad
     * @return
     */
    public void saveBoard(String fnameLoad, String directoryLoad) {
        String saveBoard = stringBuilder();
        gameSaver = new SaveTextFile(fnameLoad, directoryLoad);
        gameSaver.saveStringstoFile(saveBoard); 
    }

    /**<p>Sets turn variable locally<p>
     * @param int gameCount
     * @return
     */
    public void setTurn(int gameCount){
        turnCount = gameCount;
    }

    /**<p>Sets player move variable locally<p>
     * @param int pMove, char pSymbol
     * @return
     */
    public void setPlayerMove(int pMove, char pSymbol){
        playerM = pMove;
        playerS = pSymbol;
    }

    /**<p>Returns private board<p>
     * @param NONE
     * @return ArrayList<List<Character>> privBoard
     */
    public ArrayList<List<Character>> getBoard(){
        return privBoard;
    }

    /**<p>Calls updateBoard method and returns the value<p>
     * @param NONE
     * @return ArrayList<List<Character>> updateBoard(playerM, playerS)
     */
    public ArrayList<List<Character>> getUpdateBoard() {
        return updateBoard(playerM, playerS);
    }

    /**<p>Calls check column overflow method<p>
     * @param NONE
     * @return true or false
     */
    public boolean getCheckColumnOverflow(){
        return checkColumnOverflow(playerM);
    }

    /**<p>Calls check win method<p>
     * @param NONE
     * @return true or false
     */
    public boolean getCheckWin(){
        return checkWin();
    }

    /**<p>Calls tie check method<p>
     * @param NONE
     * @return true or false
     */
    public boolean getTieCheck() {
        return(tieCheck(turnCount));
    }

    /**<p>Calls flush board method<p>
     * @param NONE
     * @return true or false
     */
    public void getFlushPrivBoard(){
        flushPrivBoard();
    }
}
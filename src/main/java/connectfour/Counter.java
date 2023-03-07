package connectfour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**<p>Board counter class<p>
 */
public class Counter {
    private int newCount = 0;
    private ArrayList<List<Character>> countBoard = new ArrayList<>(Arrays.asList());
    private int countMoves(ArrayList<List<Character>> resumeBoard) {
        for (List<Character> rows : resumeBoard){
            for(char playedPiece : rows){
                if (playedPiece == (char)36 || playedPiece == (char)35) {
                    ++newCount;
                }
            }
        } 
        return newCount;
    }

    /**<p>Sets variables for count moves method<p>
     * @param ArrayList<List<Character>> loadBoard
     * @return ArrayList<List<Character>> newBoard
     */
    public void setCountMoves(ArrayList<List<Character>> loadBoard) {
        countBoard = loadBoard;
    }

    public int getCountMoves() {
        return countMoves(countBoard);
    }

    /**<p>Generates a string to the class<p>
     * @param NONE
     * @return NONE
     */
    public String toString(){
        return Integer.toString(newCount);
    }
}

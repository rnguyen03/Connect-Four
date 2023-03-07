package connectfour;

/** <p>The ConnectFour class contains 
 *  the runner method which runs the 
 *  program<p>
 */
public class ConnectFour{
    /**<p>Main method runs the program<p>
     * @param String[] args
     * @return NULL
     */
    public static void main(String[] args){
        Board startBoard = new Board();
        GameRules startRules = new GameRules();
        TextUI startText = new TextUI();
        startRules.gameStart(startBoard, startText);
    }
    
    /**<p>Converts the object as a string<p>
     * @param NULL
     * @return NULL
     */
    public String toString(){
        String runString = "Calls game start, main method";
        return runString;
    }
}
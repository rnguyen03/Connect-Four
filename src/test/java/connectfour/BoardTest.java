package connectfour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**<p>Testing test cases class<p>
 */
public class BoardTest{
    private Board tester;
    private Counter testCounter;
    private char testSymbol;
    private char testAltSymbol;

    /**<p>Test case cariable initialization<p>
     * @param NONE
     * @return NONE
     */
    @Before
    public void setup(){
        //set up for the test
        tester = new Board();
        testCounter = new Counter();
        testSymbol = (char)36;
        testAltSymbol = (char)35;
    }

    /**<p>Test case for row win detection<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void userWinRow(){
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(2, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testSymbol);
        tester.getUpdateBoard();
        Assert.assertEquals(tester.getCheckWin(), true);
        tester.getFlushPrivBoard();
    }

    /**<p>Test case for column win detection<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void userWinColumn(){
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        Assert.assertEquals(tester.getCheckWin(), true);
        tester.getFlushPrivBoard();
    }

    /**<p>Test case for diagonal (top to left) win detection<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void userWinDiagTL(){
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(2, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(2, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testSymbol);
        tester.getUpdateBoard();
        Assert.assertEquals(tester.getCheckWin(), true);
        tester.getFlushPrivBoard();
    }

    /**<p>Test case for diagonal (top to right) win detection<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void userWinDiagTR(){
        tester.setPlayerMove(6, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(5, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(5, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(6, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(4, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(3, testSymbol);
        tester.getUpdateBoard();
        Assert.assertEquals(tester.getCheckWin(), true);
        tester.getFlushPrivBoard();
    }

    /**<p>Test case for tie detection<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void userTie() {
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(0, testSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(0, testAltSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(1, testAltSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(1, testSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(2, testSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(2, testAltSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(3, testSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(3, testAltSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(4, testAltSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(4, testSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(5, testSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(5, testAltSymbol);
            tester.getUpdateBoard();
        }
        for (int i = 0; i < 3; i++) {
            tester.setPlayerMove(6, testSymbol);
            tester.getUpdateBoard();
            tester.setPlayerMove(6, testAltSymbol);
            tester.getUpdateBoard();
        }
        testCounter.setCountMoves(tester.getBoard());
        tester.setTurn(testCounter.getCountMoves());

        Assert.assertEquals(tester.getTieCheck(), true);
        tester.getFlushPrivBoard();
    }

    /**<p>Test case for correct symbol display<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void symbolVerify() {
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testSymbol);
        tester.getUpdateBoard();

        testCounter.setCountMoves(tester.getBoard());
        Assert.assertEquals(testCounter.getCountMoves(), 2);
        tester.getFlushPrivBoard();
    }
    
    /**<p>Test case for overflow column<p>
     * @param NONE
     * @return NONE
     */
    @Test
    public void overFlowVerify() {
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);
        tester.getUpdateBoard();
        tester.setPlayerMove(1, testAltSymbol);

        Assert.assertEquals(tester.getCheckColumnOverflow(), false);
    }

    /**<p>Generates a string to the class<p>
     * @param none
     * @return String
     */
    public String toString(){
        String testString = "tester";
        return testString;
    }
}
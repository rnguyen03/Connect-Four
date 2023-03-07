package connectfour;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.FileSystems;

/**<p>Loads board from textfile class<p>
 */
public class ReadTextFile {

    /**<p>Constructor converts strings into type path<p>
     * @param String fName, String fLocation
     * @return NONE
     */
    private Path fPath;
    public ReadTextFile(String fName, String fLocation) {
        fPath = FileSystems.getDefault().getPath(fLocation, fName);
    }
    
    /**<p>Uses path object and reads from the file and converts
     *    file data into a arraylist of lists or returns an empty board<p>
     * @param NONE
     * @return ArrayList<List<Character>> newBoard
     */
    public ArrayList<List<Character>> readFile() {
        String[] strArry;
        File file;
        file = fPath.toFile();
        file.setWritable(true);
        FileReader fw;
        int i = 0;
        ArrayList<List<Character>> newBoard = new ArrayList<>(Arrays.asList(
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
        try{
            fw = new FileReader(file);
            BufferedReader reader = new BufferedReader(fw);
            for (String tempStr = reader.readLine(); tempStr != null; tempStr = reader.readLine()){
                int j = 0;
                strArry = tempStr.split(",");
                String tstr = "";
                for (String n: strArry) {
                    tstr+= n;
                }
                char[] tchar = tstr.toCharArray();
                for (char temp : tchar){
                    if (temp == '1'){
                        newBoard.get(i * 2).set(j * 2, (char)36);
                    } else if (temp == '2'){
                        newBoard.get(i * 2).set(j * 2, (char)35);
                    } else if (temp == '0') {
                        newBoard.get(i * 2).set(j * 2, temp);
                    }
                        ++j;
                }
                    ++i;
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            System.out.println("wrong file");
        }
        return newBoard;
    }

    /**<p>Generates a string to the class<p>
     * @param none
     * @return String
     */
    public String toString(){
        String loadString = "load to file";
        return loadString;
    }
}

package connectfour;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.FileSystems;

/**<p>Save board to textfile class<p>
 */
public class SaveTextFile {
    private Path fPath;

    /**<p>Constructor for Save text file class, takes two strings and converts it a path object<p>
     * @param String String fName, String fLocation
     * @return NONE
     */
    public SaveTextFile(String fName, String fLocation) {
        fPath = FileSystems.getDefault().getPath(fLocation, fName);
    }

    /**<p>Saves a string into a file indicated by type object<p>
     * @param String saveBoard
     * @return NONE
     */
    public void saveStringstoFile(String saveBoard) {
        try{
            Files.writeString(fPath, saveBoard);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            System.out.println("wrong file");
        }
    }

    /**<p>Generates a string to the class<p>
     * @param none
     * @return saveString
     */
    public String toString(){
        String saveString = "save to file";
        return saveString;
    }
}
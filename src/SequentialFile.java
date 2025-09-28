import java.io.FileReader;
import java.io.IOException;

/**********
 * 
 * Class' name: SequentialFile
 * Author's name: David
 * Creation date: 28/9/2025
 * Class version: First version.
 * Class description: This class manages the file and gives manageable Strings to the class Satelite.
 * 
 * 
 ***********/
class SequentialFile<T extends DefineTipeT> {
    private FileReader reader;
    private int currentChar;

    /********
     * 
     * Method's name: SequentialFile.
     * Name of the original author: David
     * Description on the method:  constructor method
     * Calling arguments: 
     * Return value: there is not a return value.
     * 
     */
    public SequentialFile(String fileName) throws IOException {
        this.reader = new FileReader(fileName);
    }

   /********
     * 
     * Method's name: close
     * Name of the original author: David
     * Description on the method: This method closes the file.
     * Calling arguments: 
     * 
     */
    public void close() throws IOException {
        if (reader != null) { // to avoid NullPointerException
            reader.close();
        }
    }

    /********
     * 
     * Method's name: ReadLine
     * Name of the original author: David
     * Description on the method: This method selects a line of data from all the file (in a sequential way).
     * Calling arguments: 
     * Return value: a String with a line of information of the file.
     * 
     */
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(); // special type of String (not acurrate definition) that can be easily modified
        while ((currentChar = reader.read()) != -1) {
            if (currentChar == '\n') {
                break; // I force the while loop to finish
            }
            if (currentChar != '\r') {
                sb.appendCodePoint(currentChar); // no casting
            }
        }
        if (sb.length() == 0 && currentChar == -1) { // to avoid possible errors
            return null;
        }
        return sb.toString(); // I create a string
    }

    /********
     * 
     * Method's name: ReadInto
     * Name of the original author: David
     * Description on the method: This method sends the line of the file to the method readData and saves it on the object.
     * Calling arguments: a general tipe object.
     * Return value: there is not a return value.
     * 
     */
    public void readInto(T obj) throws IOException {
        String line = readLine();
        if (line != null) {
            obj.readData(line);
        }
    }

    /********
     * 
     * Method's name: skipLine
     * Name of the original author: David
     * Description on the method: This method skips a line from the file
     * Calling arguments: 
     * Return value: there is not a return value.
     * 
     */
    public void skipLine() throws IOException {
        while ((currentChar = reader.read()) != -1) {
            if (currentChar == '\n') {
                break;
            }
        }
    }

    /********
     * 
     * Method's name: endOfFile
     * Name of the original author: David
     * Description on the method: This method peaks if the file is finished or not.
     * Calling arguments: 
     * Return value: Boolean, true if the file has ended, and false if not
     * 
     */
    public boolean endOfFile() throws IOException {
        reader.mark(1);
        int a = reader.read();
        if (a == -1) {
            return true;
        }
        reader.reset(); // sends the pointer of the lecture back to its original position.
        return false;
    }

    
}

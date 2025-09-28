import java.io.FileReader;
import java.io.IOException;

/**
 @param <T> 
*/
class SequentialFile<T extends DefineTipeT> {
    private FileReader reader;
    private int currentChar;
    private final String separator;

    /**
     * @param fileName  
     * @param separator 
     * @throws IOException 
     */
    public SequentialFile(String fileName, String separator) throws IOException {
        this.reader = new FileReader(fileName);
        this.separator = separator;
    }

    /**
     * @throws IOException 
     */
    public void close() throws IOException {
        if (reader != null) { // to avoid NullPointerException
            reader.close();
        }
    }

    /**
     * @return
     * @throws IOException
     */
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(); // special type of String that can be easily modified
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

    /**
     * @param obj 
     * @throws IOException 
     */
    public void readInto(T obj) throws IOException {
        String line = readLine();
        if (line != null) {
            obj.readData(line);
        }
    }

    /**
     * @throws IOException 
     */
    public void skipLine() throws IOException {
        while ((currentChar = reader.read()) != -1) {
            if (currentChar == '\n') {
                break;
            }
        }
    }

    /**
     * @return 
     * @throws IOException 
     */
    public boolean endOfFile() throws IOException {
        reader.mark(1);
        int c = reader.read();
        if (c == -1) {
            return true;
        }
        reader.reset(); //retrocede el marcador de lectura a su posicion antes de ser leido y guardado en c
        return false;
    }

    /**
     * @return The separator as a String
     */
    public String getSeparator() {
        return separator;
    }
}

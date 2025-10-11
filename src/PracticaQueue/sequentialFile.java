import java.io.FileReader;
import java.io.IOException;


class SequentialFile<T extends DefineTipeT> {
    private FileReader reader;
    private int currentChar;

    public SequentialFile(String fileName) throws IOException {
        this.reader = new FileReader(fileName);
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public String readLine() throws IOException {
    String line = ""; 

    while ((currentChar = reader.read()) != -1) {
        if (currentChar == '\n') { 
            break;
        }
        if (currentChar != '\r') { 
            line += (char) currentChar; 
        }
    }
    if (line.isEmpty() && currentChar == -1) {
        return null;
    }

    return line;
}
        if (sb.length() == 0 && currentChar == -1) {
            return null;
        }
        return sb.toString();
    }

    public void readInto(T obj) throws IOException {
        String line = readLine();
        if (line != null) {
            obj.readData(line);
        }
    }

   
    public void skipLine() throws IOException {
        while ((currentChar = reader.read()) != -1) {
            if (currentChar == '\n') break;
        }
    }

    public boolean endOfFile() throws IOException {
        reader.mark(1);
        int a = reader.read();
        reader.reset();
        return a == -1;
    }

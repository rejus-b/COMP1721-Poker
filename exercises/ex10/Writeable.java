import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

interface Writeable{

    public void writeTo(Writer destination) throws IOException;
}
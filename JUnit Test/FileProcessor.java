
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileProcessor {
    public static void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}

public class FileProcessorTest {
    @TempDir
    Path tempDir;

    @Test
    public void testWriteAndReadFile() throws IOException {
        Path file = tempDir.resolve("test.txt");
        FileProcessor.writeToFile(file.toString(), "Hello, World!");
        assertEquals("Hello, World!", FileProcessor.readFromFile(file.toString()));
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        Path file = tempDir.resolve("test.txt");
        FileProcessor.writeToFile(file.toString(), "Sample");
        assertTrue(Files.exists(file));
    }

    @Test
    public void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}


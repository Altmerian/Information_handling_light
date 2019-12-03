package by.epam.pavelshakhlovich.informationhandling.inputdata;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataReaderTest {

    @Test
    public void testReadTextFromFile() {
        Path path = Paths.get("src/test/test_data/testData1.txt");
        String expected = "    It has survived not only five centuries, but also the leap into electronic\r\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\r\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\r\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        DataReader reader = new DataReader();
        String actual = reader.readTextFromFile(path);
        Assert.assertEquals(actual, expected);
    }
}
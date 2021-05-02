package edu.gorb.shape.reader;

import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ShapeFileReaderTest {
    ShapeFileReader reader;

    @BeforeClass
    public void createReader() {
        reader = new ShapeFileReader();
    }

    @Test
    public void readFileTest() throws EllipseException {
        File file = new File(getClass().getClassLoader().getResource("files/shape_data.txt").getFile());
        String path = file.getAbsolutePath();
        List<String> fileLines = reader.readFile(path);
        List<String> expected = Arrays.asList("10.0 10.0 20.0 20.0", "310.0 140.0 120.0 230.0");
        System.out.println(fileLines);
        assertEquals(expected, fileLines);
    }

    @Test(expectedExceptions = EllipseException.class)
    public void readInvalidFileTest() throws EllipseException {
        String path = "invalid_path";
        List<String> fileLines = reader.readFile(path);
    }
}

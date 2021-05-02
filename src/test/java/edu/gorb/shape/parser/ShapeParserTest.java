package edu.gorb.shape.parser;

import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ShapeParserTest {
    private ShapeParser parser;

    @BeforeClass
    public void createParser() {
        parser = new ShapeParser();
    }

    @Test(dataProvider = "valid_data")
    public void parseShapesTest(String line, List<Double> expectedList) throws EllipseException {
        List<Double> parsedList = parser.parseShapes(line);
        assertEquals(parsedList, expectedList);
    }

    @Test(dataProvider = "invalid_data", expectedExceptions = EllipseException.class)
    public void parseShapesTest(String line) throws EllipseException {
        parser.parseShapes(line);
    }

    @DataProvider(name = "valid_data")
    public Object[][] createShapeList() throws EllipseException {
        return new Object[][]{
                {"10.0 10.0 20.0 20.0", Arrays.asList(10.0, 10.0, 20.0, 20.0)},
                {"-105.0 140.0 20.0 20.0", Arrays.asList(-105.0, 140.0, 20.0, 20.0)}
        };
    }

    @DataProvider(name = "invalid_data")
    public Object[][] createInvalidShapeList() {
        return new Object[][]{
                {"10.0a 10.0 20.0 20.0"},
                {"10.0 10.0 20.0 20.0 45.15"},
                {"10.0 10.0,  24w0.0 20.0"}
        };
    }
}

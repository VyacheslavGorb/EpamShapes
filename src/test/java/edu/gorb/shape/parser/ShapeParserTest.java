package edu.gorb.shape.parser;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
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
    public void parseShapesTest(List<String> stringList, List<Ellipse> expectedList) throws EllipseException {
        List<Ellipse> shapeList = parser.parseShapes(stringList);
        assertEquals(shapeList, expectedList);
    }

    @Test(dataProvider = "invalid_data", expectedExceptions = EllipseException.class)
    public void parseShapesTest(List<String> stringList) throws EllipseException {
        parser.parseShapes(stringList);
    }

    @DataProvider(name = "valid_data")
    public Object[][] createShapeList() {
        return new Object[][]{
                {Arrays.asList("10.0 10.0 20.0 20.0", "40.0 50.0 43.0 23.0"),
                        Arrays.asList(new Ellipse(new Point(10, 10), new Point(20, 20)),
                                new Ellipse(new Point(40, 50), new Point(43, 23)))}
        };
    }


    @DataProvider(name = "invalid_data")
    public Object[][] createInvalidShapeList() {
        return new Object[][]{
                {Arrays.asList("10.0a 10.0 20.0 20.0")},
                {Arrays.asList("10.0 10.0 20.0 20.0 45.15")},
                {Arrays.asList("10.0 10.0,  24w0.0 20.0")}
        };
    }
}

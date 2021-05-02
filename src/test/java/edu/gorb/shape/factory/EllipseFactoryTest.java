package edu.gorb.shape.factory;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class EllipseFactoryTest {
    @Test(dataProvider = "valid_data")
    public void createEllipse(List<Double> coordinates, Ellipse expectedEllipse) throws EllipseException {
        Ellipse ellipse = EllipseFactory.createEllipse(coordinates);
        assertEquals(ellipse, expectedEllipse);
    }

    @DataProvider(name = "valid_data")
    public Object[][] createShapeList() throws EllipseException {
        return new Object[][]{
                {Arrays.asList(10.0, 10.0, 20.0, 20.0), new Ellipse(new Point(10,10), new Point(20,20))},
                {Arrays.asList(-10.0, -10.0, 20.0, 20.0), new Ellipse(new Point(-10,-10), new Point(20,20))}
        };
    }
}

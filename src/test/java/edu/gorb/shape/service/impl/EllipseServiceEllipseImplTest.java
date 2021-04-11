package edu.gorb.shape.service.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.service.EllipseService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class EllipseServiceEllipseImplTest {
    private EllipseService service;

    @BeforeClass
    public void createService() {
        service = new EllipseServiceImpl();
    }

    @Test(dataProvider = "valid_circle_data")
    public void isCircleTest(Ellipse shape) throws EllipseException {
        assertTrue(service.isCircle(shape));
    }

    @Test(dataProvider = "valid_oval_data")
    public void isOvalTest(Ellipse shape) throws EllipseException {
        assertTrue(service.isOval(shape));
    }

    @Test(dataProvider = "valid_oval_data")
    public void isValidOvalTest(Ellipse shape) throws EllipseException {
        assertTrue(service.isValidOval(shape));
    }

    @Test(dataProvider = "valid_perimeter_data")
    public void calcPerimeterTest(Ellipse shape, double expectedValue) throws EllipseException {
        double result = service.calcPerimeter(shape);
        assertEquals(result,expectedValue);
    }

    @Test(dataProvider = "valid_area_data")
    public void calcAreaTest(Ellipse shape, double expectedValue) throws EllipseException {
        double result = service.calcArea(shape);
        assertEquals(result,expectedValue);
    }



    @DataProvider(name = "valid_oval_data")
    public Object[][] createOvals() {
        return new Object[][]{
                {new Ellipse(new Point(10,0), new Point(20,20))},
                {new Ellipse(new Point(30,0), new Point(40,40))}
        };
    }

    @DataProvider(name = "invalid_oval_data")
    public Object[][] createInvalidOvals() {
        return new Object[][]{
                {new Ellipse(new Point(10,10), new Point(10,20))},
                {new Ellipse(new Point(30,40), new Point(40,40))}
        };
    }

    @DataProvider(name = "valid_circle_data")
    public Object[][] createCircles() {
        return new Object[][]{
                {new Ellipse(new Point(10,10), new Point(20,20))},
                {new Ellipse(new Point(30,30), new Point(40,40))}
        };
    }

    @DataProvider(name = "valid_perimeter_data")
    public Object[][] createPerimeterData(){
        return new Object[][]{
                {new Ellipse(new Point(10,10), new Point(20,20)), 31.41592653589793},
                {new Ellipse(new Point(30,30), new Point(40,40)), 31.41592653589793}
        };
    }

    @DataProvider(name = "valid_area_data")
    public Object[][] createAreaData(){
        return new Object[][]{
                {new Ellipse(new Point(10,10), new Point(20,20)), 78.53981633974483},
                {new Ellipse(new Point(30,30), new Point(40,40)), 78.53981633974483}
        };
    }
}

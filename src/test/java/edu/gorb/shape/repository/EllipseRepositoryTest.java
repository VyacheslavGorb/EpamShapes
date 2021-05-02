package edu.gorb.shape.repository;

import edu.gorb.shape.comparator.EllipseIdComparator;
import edu.gorb.shape.comparator.EllipsePerimeterComparator;
import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.repository.impl.EllipseIdSpecification;
import edu.gorb.shape.repository.impl.EllipseMaxWidthSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class EllipseRepositoryTest {
    EllipseRepository repository;

    @BeforeClass
    public void createRepository() throws EllipseException {
        repository = EllipseRepository.getInstance();
        repository.add(new Ellipse(new Point(10, 10), new Point(30, 30)));
        repository.add(new Ellipse(new Point(10, 10), new Point(40, 40)));
        repository.add(new Ellipse(new Point(10, 10), new Point(20, 20)));

    }

    @Test(dataProvider = "sort_data")
    public void sortTest(Comparator<Ellipse> comparator, List<Ellipse> expected) {
        List<Ellipse> sortedList = repository.sort(comparator);
        assertEquals(expected, sortedList);
    }

    @Test(dataProvider = "sort_data")
    public void sortStreamTest(Comparator<Ellipse> comparator, List<Ellipse> expected) {
        List<Ellipse> sortedList = repository.sortStream(comparator);
        assertEquals(expected, sortedList);
    }

    @Test(dataProvider = "query_data")
    public void queryTest(EllipseSpecification specification, List<Ellipse> expected) {
        List<Ellipse> queriedData = repository.query(specification);
        assertEquals(expected, queriedData);
    }


    @DataProvider(name = "sort_data")
    public Object[][] createSortData() throws EllipseException {
        return new Object[][]{
                {new EllipsePerimeterComparator(), Arrays.asList(
                        new Ellipse(new Point(10, 10), new Point(20, 20)),
                        new Ellipse(new Point(10, 10), new Point(30, 30)),
                        new Ellipse(new Point(10, 10), new Point(40, 40)))},

                {new EllipseIdComparator(), Arrays.asList(
                        new Ellipse(new Point(10, 10), new Point(30, 30)),
                        new Ellipse(new Point(10, 10), new Point(40, 40)),
                        new Ellipse(new Point(10, 10), new Point(20, 20)))}
        };
    }

    @DataProvider(name = "query_data")
    public Object[][] createQueryData() throws EllipseException {
        return new Object[][]{
                {new EllipseIdSpecification(1), Arrays.asList(
                        new Ellipse(new Point(10, 10), new Point(40, 40)))},

                {new EllipseMaxWidthSpecification(25), Arrays.asList(
                        new Ellipse(new Point(10, 10), new Point(30, 30)),
                        new Ellipse(new Point(10, 10), new Point(20, 20)))}
        };
    }

}
package edu.gorb.shape.validator;

import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EllipseParameterValidatorTest {
    @Test
    public void validateValidParameters() throws EllipseException {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(2, 2);
        assertTrue(EllipseParameterValidator.areValidParameters(firstPoint, secondPoint));
    }

    @Test
    public void validateInvalidParameters() throws EllipseException {
        Point firstPoint = null;
        Point secondPoint = new Point();
        assertFalse(EllipseParameterValidator.areValidParameters(firstPoint, secondPoint));
    }
}

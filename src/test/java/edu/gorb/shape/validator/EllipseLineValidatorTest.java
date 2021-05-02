package edu.gorb.shape.validator;

import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EllipseLineValidatorTest {
    @Test
    public void validateValidLine() throws EllipseException {
        String line = "10.0 10.0 20.0 20.0";
        assertTrue(EllipseLineValidator.isValidLine(line));
    }

    @Test
    public void validateInvalidLine() throws EllipseException {
        String line = "10.0 10.0 20.0 20.0d";
        assertFalse(EllipseLineValidator.isValidLine(line));
    }
}

package edu.gorb.shape.validator;

import edu.gorb.shape.exception.EllipseException;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EllipseFileValidatorTest {
    @Test
    public void validateValidFile() throws EllipseException {
        File file = new File(getClass().getClassLoader().getResource("files/shape_data.txt").getFile());
        String path = file.getAbsolutePath();
        assertTrue(EllipseFileValidator.isValidFile(path));
    }

    @Test
    public void validateInvalidFile() throws EllipseException {
        String path = "some_path";
        assertFalse(EllipseFileValidator.isValidFile(path));
    }
}

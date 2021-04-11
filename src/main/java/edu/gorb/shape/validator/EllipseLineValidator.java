package edu.gorb.shape.validator;

public class EllipseLineValidator {
    private static final String REGEXP = "^([-]?\\d\\.\\d ){3}([-]?\\d\\.\\d)$";

    public boolean isValidLine(String line) {
        return line.matches(REGEXP);
    }
}

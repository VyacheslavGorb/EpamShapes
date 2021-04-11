package edu.gorb.shape.validator;

import java.io.File;

public class EllipseFileValidator {
    public boolean isValidFile(String filePathString) {
        if (filePathString == null) {
            return false;
        }
        File file = new File(filePathString);
        if (!file.isFile()) {
            return false;
        }
        return file.length() != 0;
    }
}

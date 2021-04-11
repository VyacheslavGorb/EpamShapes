package edu.gorb.shape.reader;

import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.validator.EllipseFileValidator;
import edu.gorb.shape.validator.EllipseLineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeFileReader {
    private static final Logger logger = LogManager.getLogger();
    private static final EllipseLineValidator ELLIPSE_LINE_VALIDATOR = new EllipseLineValidator();
    private static final EllipseFileValidator fileValidator = new EllipseFileValidator();

    public List<String> readFile(String filePathString) throws EllipseException {
        if (!fileValidator.isValidFile(filePathString)) {
            logger.log(Level.ERROR, "File path represents invalid file");
            throw new EllipseException("File path represents invalid file");
        }
        Path path = Paths.get(filePathString);
        List<String> correctLines = null;
        try (var fileLines = Files.lines(path)) {
            correctLines = fileLines
                    .filter(ELLIPSE_LINE_VALIDATOR::isValidLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file {}", filePathString);
            throw new EllipseException("Error while reading file " + filePathString);
        }
        logger.log(Level.INFO, "Correct lines were read in file: {}", filePathString);
        return correctLines;
    }
}

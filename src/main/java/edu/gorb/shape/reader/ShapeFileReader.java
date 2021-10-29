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
import java.util.stream.Stream;

public class ShapeFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String filePathString) throws EllipseException {
        if (!EllipseFileValidator.isValidFile(filePathString)) {
            logger.log(Level.ERROR, "File path represents invalid file");
            throw new EllipseException("File path represents invalid file");
        }
        Path path = Paths.get(filePathString);
        List<String> correctLines;
        try (Stream<String> fileLines = Files.lines(path)) {
            correctLines = fileLines
                    .filter(EllipseLineValidator::isValidLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file {}", filePathString);
            throw new EllipseException("Error while reading file " + filePathString);
        }
        logger.log(Level.INFO, "Lines were read in file: {}", filePathString);
        return correctLines;
    }
}

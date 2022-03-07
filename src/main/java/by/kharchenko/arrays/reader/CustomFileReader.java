package by.kharchenko.arrays.reader;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.reader.parser.CustomParser;
import by.kharchenko.arrays.reader.validation.ValidateLine;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {

    private static final Logger LOGGER = LogManager.getLogger(CustomFileReader.class);

    private static CustomFileReader instance;

    private CustomFileReader() {
    }

    public static CustomFileReader getInstance() {
        if (instance == null) {
            instance = new CustomFileReader();
        }
        return instance;
    }

    public int[] read(String path) throws CustomException, IOException {

        emptyCheck(path);
        Path pathClass = Paths.get(path);
        List<String> lines = Files.lines(pathClass).toList();
        for (var s : lines) {
            if (ValidateLine.validate(s)) {
                return CustomParser.parse(s);
            }
        }
        dataIsNotValid();
        return null;
    }


    public List<CustomArray> readAll(String path) throws CustomException, IOException {

        emptyCheck(path);
        Path pathClass = Paths.get(path);
        List<String> lines = Files.lines(pathClass).toList();
        List<CustomArray> customArrays = null;
        for (var s : lines) {
            if (ValidateLine.validate(s)) {
                if (customArrays == null) {
                    customArrays = new ArrayList<>();
                }
                CustomArray customArray = new CustomArray(CustomParser.parse(s));
                customArrays.add(customArray);
            }
        }
        if (customArrays == null) {
            dataIsNotValid();
        }
        return customArrays;
    }

    private void emptyCheck(String path) throws CustomException {
        if (path.isEmpty()) {
            LOGGER.log(Level.ERROR, "the path is empty");
            throw new CustomException("the path is empty");
        }
    }

    private void dataIsNotValid() throws CustomException {
        LOGGER.log(Level.ERROR, "data is not valid");
        throw new CustomException("data is not valid");
    }
}

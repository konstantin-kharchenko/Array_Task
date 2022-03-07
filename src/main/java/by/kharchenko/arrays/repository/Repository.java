package by.kharchenko.arrays.repository;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.util.CustomCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Repository {

    private static final Logger LOGGER = LogManager.getLogger(CustomArray.class);
    private List<CustomArray> customArrays;
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<CustomArray> getCustomArrays() {
        return customArrays;
    }

    public void setCustomArrays(List<CustomArray> customArrays) throws CustomException {
        CustomCheck.nullCheck(customArrays);
        this.customArrays = customArrays;
    }

    private Repository() {
        customArrays = new ArrayList<>();
    }

    public void add(CustomArray customArray) throws CustomException {
       CustomCheck.nullCheck(customArray);
        customArrays.add(customArray);
    }

    public void addAll(List<CustomArray> customArrays) throws CustomException {
        CustomCheck.nullCheck(customArrays);
        this.customArrays.addAll(customArrays);
    }

    public void remove(CustomArray customArray) {
        customArrays.remove(customArray);
    }

    public void removeAll(List<CustomArray> customArray) {
        customArrays.removeAll(customArray);
    }

    public List<CustomArray> query(Specification specification) throws CustomException {
        List<CustomArray> list = new ArrayList<>();
        for (CustomArray customArray : customArrays) {
            if (specification.specify(customArray)) {
                list.add(customArray);
            }
        }
        return list;
    }

    public void sort(Comparator<CustomArray> comparator) {
        customArrays.sort(comparator);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "customArrays=" + customArrays +
                '}';
    }
}

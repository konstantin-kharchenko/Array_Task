package by.kharchenko.arrays.entity;

import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.util.CustomCheck;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance;
    private Map<Integer, CustomArrayParameters> customArrayValuesMap;

    private Warehouse() {
        customArrayValuesMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public Map<Integer, CustomArrayParameters> getCustomArrayValuesMap() {
        return customArrayValuesMap;
    }

    public void setCustomArrayValuesMap(Map<Integer, CustomArrayParameters> customArrayValuesMap) throws CustomException {
        CustomCheck.nullCheck(customArrayValuesMap);
        this.customArrayValuesMap = customArrayValuesMap;
    }

    public void put(Integer id, CustomArrayParameters customArrayValues) throws CustomException {
        CustomCheck.nullCheck(customArrayValues);
        customArrayValuesMap.put(id, customArrayValues);
    }

    public void remove(Integer id) {
        customArrayValuesMap.remove(id);
    }

    public CustomArrayParameters get(Integer id) throws CustomException {
        CustomArrayParameters customArrayParameters = customArrayValuesMap.get(id);
        CustomCheck.nullCheck(customArrayParameters);
        return customArrayParameters;
    }
}

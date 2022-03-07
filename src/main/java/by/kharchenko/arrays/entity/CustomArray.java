package by.kharchenko.arrays.entity;

import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.observer.CustomArrayEvent;
import by.kharchenko.arrays.observer.Observable;
import by.kharchenko.arrays.observer.Observer;
import by.kharchenko.arrays.observer.impl.CustomArrayObserver;
import by.kharchenko.arrays.util.CustomCheck;
import by.kharchenko.arrays.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements Observable {

    private static final Logger LOGGER = LogManager.getLogger(CustomArray.class);
    private int[] array;
    private int arrayId;
    private List<Observer> observers = new ArrayList<>();

    public CustomArray(int... array) throws CustomException {
        CustomCheck.nullCheck(array);
        this.array = array;
        idGenerator();
        attach(new CustomArrayObserver());
        notifyObserver();
    }

    public CustomArray() throws CustomException {
        idGenerator();
    }

    public int getElement(int id) throws CustomException {
        idInArray(id);
        if (array.length == 0) {
            return 0;
        }
        return array[id];
    }


    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) throws CustomException {
        CustomCheck.nullCheck(array);
        this.array = array;
        notifyObserver();
    }

    public void setElement(int element, int id) throws CustomException {
        idInArray(id);
        array[id] = element;
        notifyObserver();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int a : array) {
            stringBuilder.append(a);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public int getId() {
        return arrayId;
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() throws CustomException {
        CustomArrayEvent event = new CustomArrayEvent(this);
        if (!observers.isEmpty()) {
            for (Observer o : observers) {
                o.update(event);
            }
        }
    }

    private void idGenerator() throws CustomException {
        arrayId = IdGenerator.generate();
        (Warehouse.getInstance()).put(arrayId, new CustomArrayParameters());
    }

    private void idInArray(int id) throws CustomException {
        if (id < 0 || id > array.length) {
            LOGGER.log(Level.ERROR, "for the size of array");
            throw new CustomException("for the size of array");
        }
    }
}

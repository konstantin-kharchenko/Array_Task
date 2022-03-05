package by.kharchenko.arrays.observer;

import by.kharchenko.arrays.exception.CustomException;

public interface Observable {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver() throws CustomException;

}

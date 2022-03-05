package by.kharchenko.arrays.observer;

import by.kharchenko.arrays.exception.CustomException;

public interface Observer {
    void update(CustomArrayEvent customArrayEvent) throws CustomException;
}

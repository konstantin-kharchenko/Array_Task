package by.kharchenko.arrays.observer.impl;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.observer.CustomArrayEvent;
import by.kharchenko.arrays.observer.Observer;
import by.kharchenko.arrays.service.ArrayElementsManipulation;
import by.kharchenko.arrays.service.impl.ArrayElementsManipulationImpl;

public class CustomArrayObserver implements Observer {

    @Override
    public void update(CustomArrayEvent event) throws CustomException {

            CustomArray array = event.getSource();

            ArrayElementsManipulation arrayElementsManipulation = new ArrayElementsManipulationImpl();

            CustomArrayParameters customArrayParameters = Warehouse.getInstance().get(array.getId());

            customArrayParameters.setMin(arrayElementsManipulation.minElement(array));
            customArrayParameters.setMax(arrayElementsManipulation.maxElement(array));
            customArrayParameters.setAverage(arrayElementsManipulation.mean(array));
            customArrayParameters.setSum(arrayElementsManipulation.sumOfElement(array));

    }
}

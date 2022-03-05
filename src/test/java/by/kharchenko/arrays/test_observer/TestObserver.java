package by.kharchenko.arrays.test_observer;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.reader.CustomFileReader;
import by.kharchenko.arrays.repository.Repository;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestObserver {

    CustomFileReader fileReader;
    Repository repository;

    @BeforeTest
    public void load() {
        fileReader = CustomFileReader.getInstance();
        repository = Repository.getInstance();
    }

    @Test
    public void testObserver() throws CustomException, IOException {
        var xc = fileReader.readAll("src\\main\\resources\\files\\input9.txt");
        repository.addAll(xc);

        Warehouse warehouse = Warehouse.getInstance();
        for (int i = 0; i < repository.getCustomArrays().size(); i++) {
            System.out.println(repository.getCustomArrays().get(i).toString());
            CustomArrayParameters customArrayValues = warehouse.get(repository.getCustomArrays().get(i).getId());
            System.out.println(customArrayValues);
        }

        for (CustomArray array : repository.getCustomArrays()
        ) {
            array.setElement(505, 0);
        }
        System.out.println();

        for (int i = 0; i < repository.getCustomArrays().size(); i++) {
            System.out.println(repository.getCustomArrays().get(i).toString());
            CustomArrayParameters customArrayValues = warehouse.get(repository.getCustomArrays().get(i).getId());
            System.out.println(customArrayValues);
        }
    }

}

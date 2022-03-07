package by.kharchenko.arrays.test_observer;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.reader.CustomFileReader;
import by.kharchenko.arrays.repository.Repository;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static by.kharchenko.arrays.manipulation.ArrayAdder.addCustomArrayToList;

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
        var arr2 = addCustomArrayToList(new CustomArray(505, 3, 1, 9, 4, 6, 8, 3, 2, 3, 12, 4, 1, 22, 65, 7, 23)
                , new CustomArray(505, 3, 2, 9, 5, 12, 3, 6, 1), new CustomArray(505, 5, 2, 78, 1, 1, 5, 23)
                , new CustomArray(505, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(505, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        Assert.assertEquals(arr2, repository.getCustomArrays());

    }

}

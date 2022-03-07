package by.kharchenko.arrays.test_repository;

import by.kharchenko.arrays.comparator.CustomArrayFirstElement;
import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.reader.CustomFileReader;
import by.kharchenko.arrays.repository.Repository;
import by.kharchenko.arrays.repository.impl.less.*;
import by.kharchenko.arrays.repository.impl.more.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.kharchenko.arrays.manipulation.ArrayAdder.addCustomArrayToList;

public class TestRepository {
    CustomFileReader fileReader;
    Repository repository;

    @BeforeTest
    public void load() {
        fileReader = CustomFileReader.getInstance();
        repository = Repository.getInstance();
    }

    @Test
    public void testRepositorySort() throws CustomException, IOException {
        List<CustomArray> arrayList1 = addCustomArrayToList(new CustomArray(new int[]{}), new CustomArray(4, 2, 8, 1, 9, 4, 5, 6, 10));
        List<CustomArray> arrayList = fileReader.readAll("src\\main\\resources\\files\\input4.txt");
        repository.addAll(arrayList);
        repository.sort(new CustomArrayFirstElement());
        System.out.println(repository.toString());
        Assert.assertEquals(repository.getCustomArrays(), arrayList1);
    }

    @Test
    public void testRepositoryFindMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxLessSpecification(78));
        var arr2 = addCustomArrayToList(new CustomArray(5, 3, 1, 9, 4, 6, 8, 3, 2, 3, 12, 4, 1, 22, 65, 7, 23)
                , new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1), new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinLessSpecification(1));
        var arr2 = addCustomArrayToList();
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumLessSpecification(178));
        var arr2 = addCustomArrayToList(new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1)
                , new CustomArray(12, 5, 2, 78, 1, 1, 5, 23), new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageLessSpecification(1.0 * 178 / 17));
        var arr2 = addCustomArrayToList(new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdLessSpecification(3));
        var arr2 = addCustomArrayToList(new CustomArray(5, 3, 1, 9, 4, 6, 8, 3, 2, 3, 12, 4, 1, 22, 65, 7, 23)
                , new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMoreMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxMoreSpecification(78));
        var arr2 = addCustomArrayToList();
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMoreMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinMoreSpecification(1));
        var arr2 = addCustomArrayToList();
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMoreSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumMoreSpecification(178));
        var arr2 = addCustomArrayToList();
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMoreAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageMoreSpecification(1.0 * 178 / 17));
        var arr2 = addCustomArrayToList(new CustomArray(12, 5, 2, 78, 1, 1, 5, 23)
                , new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindMoreID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdMoreSpecification(3));
        var arr2 = addCustomArrayToList(new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindLessMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxLessSpecification(78));
        var arr2 = addCustomArrayToList(new CustomArray(5, 3, 1, 9, 4, 6, 8, 3, 2, 3, 12, 4, 1, 22, 65, 7, 23)
                , new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1), new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindLessMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinLessSpecification(1));
        var arr2 = addCustomArrayToList();
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindLessSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumLessSpecification(178));
        var arr2 = addCustomArrayToList(new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1), new CustomArray(12, 5, 2, 78, 1, 1, 5, 23)
                , new CustomArray(23, 77, 1, 5, 3, 4, 7, 8, 2, 3, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindLessAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageLessSpecification(1.0 * 178 / 17));
        var arr2 = addCustomArrayToList(new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1)
                , new CustomArray(19, 2, 3, 1, 8, 8, 8, 9, 3, 2));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

    @Test
    public void testRepositoryFindLessID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdLessSpecification(3));
        var arr2 = addCustomArrayToList(new CustomArray(5, 3, 1, 9, 4, 6, 8, 3, 2, 3, 12, 4, 1, 22, 65, 7, 23)
                , new CustomArray(4, 3, 2, 9, 5, 12, 3, 6, 1));
        System.out.println(repository.toString());
        System.out.println(arr);
        Assert.assertEquals(arr, arr2);
    }

}

package by.kharchenko.arrays.test_repository;

import by.kharchenko.arrays.comparator.CustomArrayFirstElement;
import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.reader.CustomFileReader;
import by.kharchenko.arrays.repository.Repository;
import by.kharchenko.arrays.repository.impl.less.*;
import by.kharchenko.arrays.repository.impl.more.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

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
        List<CustomArray> arrayList = fileReader.readAll("src\\main\\resources\\files\\input4.txt");
        repository.addAll(arrayList);
        repository.sort(new CustomArrayFirstElement());
        System.out.println(repository.toString());
    }

    @Test
    public void testRepositoryFindMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxLessSpecification(78));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinLessSpecification(1));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumLessSpecification(178));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageLessSpecification(1.0 * 178 / 17));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdLessSpecification(3));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMoreMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxMoreSpecification(78));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMoreMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinMoreSpecification(1));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMoreSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumMoreSpecification(178));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMoreAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageMoreSpecification(1.0 * 178 / 17));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindMoreID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdMoreSpecification(3));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindLessMax() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MaxLessSpecification(78));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindLessMin() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new MinLessSpecification(1));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindLessSum() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new SumLessSpecification(178));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindLessAverage() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new AverageLessSpecification(1.0 * 178 / 17));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

    @Test
    public void testRepositoryFindLessID() throws CustomException, IOException {
        repository.addAll(fileReader.readAll("src\\main\\resources\\files\\input9.txt"));
        var arr = repository.query(new IdLessSpecification(3));
        System.out.println(repository.toString());
        System.out.println(arr);
    }

}

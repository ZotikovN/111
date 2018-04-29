import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;

public class TrainScheduleTest {


    @Test
    public void searchChecking() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Вологда","Санкт-Петербург");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("|Вологда, 10:30|");
        expected.add("|Санкт-Петербург, 9:10|");
        assertEquals(expected, train.searchTrain(9,10,"Санкт-Петербург"));
    }


    @Test
    public void searchChecking1() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 8, 15, "Вологда 1");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Вологда","Санкт-Петербург");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("|Санкт-Петербург, 9:10|");
        assertEquals(expected, train.searchTrain(9,10,"Санкт-Петербург"));
    }


    @Test
    public void addStations() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addStation("Санкт-Петербург","Новгород");
        train.addStation("Санкт-Петербург","Омск");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("|Санкт-Петербург, 9:10|");
        assertEquals(expected, train.searchTrain(7,30,"Омск"));
        assertEquals(expected, train.searchTrain(7,30,"Новгород"));
        assertEquals(expected, train.searchTrain(7,30,"Санкт-Петербург"));
    }



    @Test
    public void deleteStation (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Москва","Санкт-Петербург");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("|Москва, 11:20|");
        expected.add("|Санкт-Петербург, 9:10|");
        assertEquals(expected, train.searchTrain(9,10,"Санкт-Петербург"));
        train.deleteStation("Москва","Санкт-Петербург");
        expected.remove("|Москва, 11:20|");
        assertEquals(expected, train.searchTrain(9,10,"Санкт-Петербург"));
    }






    @Test
    public void deleteTrain (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Москва","Новгород");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("|Москва, 11:20|");
        expected.add("|Новгород, 10:30|");
        assertEquals(expected, train.searchTrain(8,10,"Новгород"));
        train.deleteTrain("Москва");
        expected.remove("|Москва, 11:20|");
        assertEquals(expected, train.searchTrain(8,10,"Новгород"));
    }






}
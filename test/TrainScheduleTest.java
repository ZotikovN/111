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
        assertEquals("[|Вологда, 10:30|, |Санкт-Петербург, 9:10|]", train.searchTrain(9,10,"Санкт-Петербург").toString());
    }


    @Test
    public void searchChecking1() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 8, 15, "Вологда 1");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Вологда","Санкт-Петербург");
        assertEquals("[|Санкт-Петербург, 9:10|]", train.searchTrain(9,10,"Санкт-Петербург").toString());
    }


    @Test
    public void addStations() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addStation("Санкт-Петербург","Новгород");
        train.addStation("Санкт-Петербург","Омск");
        assertEquals("[|Санкт-Петербург, 9:10|]", train.searchTrain(7,30,"Омск").toString());
        assertEquals("[|Санкт-Петербург, 9:10|]", train.searchTrain(7,30,"Новгород").toString());
        assertEquals("[|Санкт-Петербург, 9:10|]", train.searchTrain(7,30,"Санкт-Петербург").toString());
    }



    @Test
    public void deleteStation (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Москва","Санкт-Петербург");
        assertEquals("[|Москва, 11:20|, |Санкт-Петербург, 9:10|]", train.searchTrain(9,10,"Санкт-Петербург").toString());
        train.deleteStation("Москва","Санкт-Петербург");
        assertEquals("[|Санкт-Петербург, 9:10|]", train.searchTrain(9,10,"Санкт-Петербург").toString());
    }






    @Test
    public void deleteTrain (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");
        train.addNew("Москва",11,20,"Москва");
        train.addStation("Москва","Новгород");
        assertEquals("[|Москва, 11:20|, |Новгород, 10:30|]", train.searchTrain(8,10,"Новгород").toString());
        train.deleteTrain("Москва");
        assertEquals("[|Новгород, 10:30|]", train.searchTrain(8,10,"Новгород").toString());
    }






}
import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;

public class TrainScheduleTest {


    @Test
    public void addNew() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 10, 30, "Вологда 1");
        assertEquals(("[Вологда, 10:30, Вологда 1]"), train.searchTrain(10, 30).toString());
    }



    @Test
    public void searchTrainByStation(){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addStation("Вологда", 10,30,"Вологда 1", "Москва");
        assertEquals(train.searchTrainByStation("Москва").toString(),Optional.of("Вологда, 10:30, Вологда 1").toString());
        }


    @Test
    public void searchTrainByStation1(){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петергбур", 10, 35, "Санкт-Петербург 1");
        train.addStation("Санкт-Петергбур", 10, 35, "Санкт-Петербург 1", "Воронеж");
        train.addStation("Санкт-Петергбур", 10, 35, "Санкт-Петербург 1", "Урал");
        assertEquals(train.searchTrainByStation("Урал").toString(),Optional.of("Санкт-Петергбур, 10:35, Санкт-Петербург 1").toString());
        assertEquals(train.searchTrainByStation("Воронеж").toString(),Optional.of("Санкт-Петергбур, 10:35, Санкт-Петербург 1").toString());
    }




    @Test
    public void searchTrainByStationIfStationNotFound(){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addStation("Вологда", 10,30,"Вологда 1", "Москва");
        assertEquals(train.searchTrainByStation("Санкт-Петербург").toString(),Optional.empty().toString());
    }


    @Test
    public void deleteStation (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addStation("Вологда", 10,30,"Вологда 1", "Москва");
        assertTrue(train.deleteStation("Москва"));
    }



    @Test
    public void deleteStation1 (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Москва", 9, 20, "Москва 1");
        train.addStation("Москва", 9,20,"Москва 1", "Санкт-Петербург");
        assertTrue(train.deleteStation("Москва"));
    }



    @Test
    public void deleteTrain (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");
        assertTrue(train.deleteTrain("Новгород",10,30,"Новгород"));
    }

    @Test
    public void deleteTrain1 (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");
        assertFalse(train.deleteTrain("Москва",11,50,"Москва"));
    }




}
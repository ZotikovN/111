import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;

public class TrainScheduleTest {

    @Test
    public void addNew() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        assertEquals(("Вологда, 10:30, Вологда 1"), train.searchTrainByDis("Вологда 1"));
    }



    @Test
    public void searchTrainByStation(){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addStation("Вологда", 10,30,"Вологда 1", "Москва");
        assertEquals(train.searchTrainByStation("Москва").toString(),Optional.of("Вологда, 10:30, Вологда 1").toString());
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
    public void searchTrainByTime() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        assertEquals(("Вологда, 10:30, Вологда 1"), train.searchTrainByTime(10, 20));
    }




}
import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;

public class TrainScheduleTest {


    @Test
    public void addNew() {
        TrainSchedule train = new TrainSchedule();
        train.addNew("Санкт-Петербург", 9, 10, "Санкт-Петербург");
        train.addNew("Вологда", 10, 30, "Вологда 1");
        assertEquals("[10:30, Вологда 1, 9:10, Санкт-Петербург]", train.searchTrain(9,10,"Санкт-Петербург").toString());
    }



    @Test
    public void deleteStation (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Вологда", 10, 30, "Вологда 1");
        train.addStation("Вологда", "Москва");

    }






    @Test
    public void deleteTrain (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");

    }

    @Test
    public void deleteTrain1 (){
        TrainSchedule train = new TrainSchedule();
        train.addNew("Новгород", 10, 30, "Новгород");

    }




}
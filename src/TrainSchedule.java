import java.lang.reflect.Array;
import java.util.*;

public class TrainSchedule {

    public class train {
        private String name;
        private int hours;
        private int minutes;
        private String dis;

        train(String name, int hours, int minutes, String dis) {
            this.name = name;
            this.hours = hours;
            this.minutes = minutes;
            this.dis = dis;

        }

        public String toString() {
            return name + ", " + hours + ":" + minutes + ", " + dis;
        }

        private String getDis() {
            return dis;
        }

        public int getTime() {
            return 60 * hours + minutes;
        }



    }



    private String station;


    private Map<String, train> schedule = new HashMap<String, train>();



    private int time;





    public void addNew(String name, int hours, int minutes, String dis) {
        if (checkAll(name, hours, minutes, dis)) {
            train train = new train(name, hours, minutes, dis);
            schedule.put(station, train);
        }
    }

    private boolean checkAll(String name, int hours, int minutes, String dis) {
        if (name == null) {
            throw new Error("Неверный формат ввода названия поезда");
        }
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0) {
            throw new Error("Неверный формат ввода времени");
        }
        if (dis == null) {
            throw new Error("Неверный формат ввода названия конечной станции");
        }
        return true;
    }


    private boolean deleteTrain(String name, int hours, int minutes, String dis) {
        train train = new train(name, hours, minutes, dis);
        if (schedule.containsValue(train)) {
            schedule.entrySet().removeIf(entry -> entry.getValue().equals(train));
            return true;
        }
        return false;
    }





    public void addStation (String name, int hours, int minutes, String dis, String station) {
        if ((checkStation(station)) || (checkAll(name, hours, minutes, dis))) {
            train train = new train(name, hours, minutes, dis);
            if (this.schedule.containsValue(train)) {
                if (this.schedule.containsKey(station)) {
                    throw new Error("Этот поезд уже имеет такую станцию");
                }
                else deleteTrain(name, hours, minutes, dis);
            }
            train chkdtrain = new train(name, hours, minutes, dis);
            station = station.replace(" ", "");
            schedule.put(station, chkdtrain);

        }
    }

    private boolean checkStation (String station) {
        if (station == null || station.equals("")) {
            throw new Error("Неверный формат ввода названия станции");
        }

        return true;
    }

    public boolean deleteStation(String station) {
        if (checkStation(station) || this.schedule.containsKey(station)) {
            this.schedule.remove(station);
            return true;
        }
        return false;
    }


    public Optional<train> searchTrainByStation(String station) {
        if (checkStation(station) || schedule.containsKey(station)) {
            return Optional.ofNullable(schedule.get(station));
        }
        return Optional.empty();
    }


    public ArrayList<String> searchTrainByDis(String dis) {
        if (!checkDistanation(dis)) {
            throw new Error("Неверный формат ввода");
        }
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, train>> info = this.schedule.entrySet();
        for (Map.Entry<String, train> thisInfo : info) {
            String thisDistanation = thisInfo.getValue().getDis();
            if (thisDistanation.equals(dis))
                list.add(thisInfo.getKey());
        }
        return list;
    }



    public ArrayList<String> searchTrainByTime(int hours, int minutes) {
        if (!checkTime(hours, minutes)) {
            throw new Error("Неверный формат ввода");
        }
        this.time = 60 * hours + minutes;
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, train>> info = this.schedule.entrySet();
        for (Map.Entry<String, train> thisInfo : info) {
            int trainTime = thisInfo.getValue().getTime();
            if (trainTime >= time)
                list.add(thisInfo.getKey());
        }
        return list;
    }



    private boolean checkTime(int hours, int minutes) {
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0)
            throw new Error("Неверный формат ввода времени");
        return true;
    }



    private boolean checkDistanation(String distanation) {
        if (distanation == null) {
            throw new Error("Неверный формат ввода");
        }
        return true;
    }



}

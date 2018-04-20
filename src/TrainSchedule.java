import java.lang.reflect.Array;
import java.util.*;

public class TrainSchedule {

    public class info {
        private String name;
        private int hours;
        private int minutes;
        private String dis;

        info(String name, int hours, int minutes, String dis) {
            this.name = name;
            this.hours = hours;
            this.minutes = minutes;
            this.dis = dis;


        }

        public String toString() {
            return "|" + name + ", " + hours + ":" + minutes + "|";
        }

        private String getDis() {
            return dis;
        }

        private int getTime() {
            return 60 * hours + minutes;
        }

        private ArrayList<String> stations = new ArrayList<>();


        private List<String> getStation() {
            return stations;
        }


        private void addStation(String station) {
            if (!stations.contains(station)) {
                stations.add(station);
            }
        }

        void deleteStation(String station) {
            stations.remove(station);
        }
    }







    private Map<String, info> schedule = new HashMap<>();



    private int time;





    public void addNew(String name, int hours, int minutes, String dis) {
        if (checkAll(name, hours, minutes, dis)) {
            info info = new info(name, hours, minutes, dis);
            schedule.put(name, info);
        }
    }

    private boolean checkAll(String name, int hours, int minutes, String dis) {
        if (name == null || name.equals("")) {
            return false;
        }
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0) {
            return false;
        }
        if (dis == null || dis.equals("")) {
            return false;
        }
        return true;
    }

    public void deleteTrain(String name) {
        if (!schedule.containsKey(name)) {
            throw new Error("Поезд не найден");
        }
        schedule.remove(name);
    }





    public void addStation (String name, String station) {
        if (!checkStation(station)) {
            throw new Error("Неверный формат ввода");
        }
        if (!schedule.containsKey(name)) {
            throw new Error("Поезд не найден");
        }
        if (schedule.get(name).getStation().contains(station)) {
            throw new Error("Такая станция уже принадлежит этому поезду");
        }
        schedule.get(name).addStation(station);
    }

    private boolean checkStation (String station) {
        if (station == null || station.equals("")) {
            return false;
        }

        return true;
    }

    public void deleteStation(String name, String station) {
        if (!schedule.containsKey(name)) {
            throw new Error("Поезд не найден");
        }
        if (!schedule.get(name).getStation().contains(station)) {
            throw new Error("Станция не найдена");
        }
        schedule.get(name).deleteStation(station);
    }








    private boolean checkTime(int hours, int minutes) {
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0)
            return false;
        return true;
    }



    private boolean checkDistanation(String dis) {
        if (dis == null || dis.equals("")) {
            return false;
        }
        return true;
    }



    public List<String> searchTrain(int hours, int minutes, String dis) {
        if (!checkTime(hours, minutes) || !checkDistanation(dis)) {
            throw new Error("Неверный формат ввода");
        }
        this.time = 60 * hours + minutes;
        int trainTime;
        List<String> list = new ArrayList<>();
        for (info info : schedule.values()) {
            trainTime = info.getTime();
            if (this.time <= trainTime && (info.stations.contains(dis)
        || Objects.equals(dis, info.dis))) {
                list.add(info.toString());
            }
        }
        return list;
    }



}

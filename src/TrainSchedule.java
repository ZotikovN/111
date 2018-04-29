import java.lang.reflect.Array;
import java.util.*;

public class TrainSchedule {

    public class Info {
        private String name;
        private int hours;
        private int minutes;
        private String destination;

        Info(String name, int hours, int minutes, String destination) {
            this.name = name;
            this.hours = hours;
            this.minutes = minutes;
            this.destination = destination;


        }

        public String toString() {
            return "|" + name + ", " + hours + ":" + minutes + "|";
        }

        private String getDestination() {
            return destination;
        }

        private int getTime() {
            return 60 * hours + minutes;
        }

        private ArrayList<String> stations = new ArrayList<>();


        private List<String> getStation() {
            return Collections.unmodifiableList(stations);
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







    private Map<String, Info> schedule = new HashMap<>();









    public void addNew(String name, int hours, int minutes, String destination) {
        if (checkAll(name, hours, minutes, destination)) {
            Info info = new Info(name, hours, minutes, destination);
            schedule.put(name, info);
        }
    }

    private boolean checkAll(String name, int hours, int minutes, String destination) {
        if (name == null || name.equals("")) {
            return false;
        }
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0) {
            return false;
        }
        if (destination == null || destination.equals("")) {
            return false;
        }
        return true;
    }

    public void deleteTrain(String name) {
        if (!schedule.containsKey(name)) {
            throw new NullPointerException("Поезд не найден");
        }
        schedule.remove(name);
    }





    public void addStation (String name, String station) {
        if (!checkStation(station)) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        if (!schedule.containsKey(name)) {
            throw new NullPointerException("Поезд не найден");
        }
        if (schedule.get(name).getStation().contains(station)) {
            throw new IllegalArgumentException("Такая станция уже принадлежит этому поезду");
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
            throw new NullPointerException("Поезд не найден");
        }
        if (!schedule.get(name).getStation().contains(station)) {
            throw new NullPointerException("Станция не найдена");
        }
        schedule.get(name).deleteStation(station);
    }








    private boolean checkTime(int hours, int minutes) {
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0)
            return false;
        return true;
    }



    private boolean checkDistanation(String destination) {
        if (destination == null || destination.equals("")) {
            return false;
        }
        return true;
    }



    public List<String> searchTrain(int hours, int minutes, String destination) {
        if (!checkTime(hours, minutes) || !checkDistanation(destination)) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        int time;
        time = 60 * hours + minutes;
        int trainTime;
        List<String> list = new ArrayList<>();
        for (Info info : schedule.values()) {
            trainTime = info.getTime();
            if (time <= trainTime && (info.stations.contains(destination)
        || Objects.equals(destination, info.destination))) {
                list.add(info.toString());
            }
        }
        return list;
    }



}

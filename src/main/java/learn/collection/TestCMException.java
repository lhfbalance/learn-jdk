package learn.collection;

import java.util.*;

public class TestCMException {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String s : list) {
            if (s.equals("3")) {
                list.remove("3");
            }
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        for (String value : map.values()) {
            if (value.equals(2)) {
                map.remove(2);
            }
        }
    }

}

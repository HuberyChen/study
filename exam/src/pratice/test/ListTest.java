package pratice.test;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ListTest {

    @Test
    public void changeTest() {
        Person person = new Person();
        person.setId(1);
        person.setName("hubery");

        Map<String, Person> map = new HashMap<>();

        map.put(person.getName(), person);

        for (Entry<String, Person> entry : map.entrySet()) {
            Person test = entry.getValue();
            test.setId(1);
            test.setName("1");
        }

        for (Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry.getValue().getName());
        }
    }

    @Test
    public void mapTest() {
        Person person = new Person();
        person.setId(1);
        person.setName("hubery");

        Map<String, Person> map = new HashMap<>();

        map.put(person.getName(), person);

        Person test = new Person();
        test.setId(2);
        test.setName("hubery");

        map.put(test.getName(), test);

        System.out.println(map.size());
    }

    @Test
    public void containTest() {

        Person person = new Person();
        person.setId(1);
        person.setName("hubery");

        List<Person> persons = new ArrayList<>();
        persons.add(person);

        Person test = new Person();
        test.setId(1);
        test.setName("hubery");

        List<Person> personList = new ArrayList<>();
        personList.add(test);

        persons.retainAll(personList);

        if (persons.size() != 0 && persons != null) {
            for (Person p : persons) {
                System.out.println(p.getName());
            }
        }

    }

    public class Person {

        private int Id;
        private String name;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    @Test
    public void addTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list.addAll(list2);
        for (String string : list) {
            System.out.println(string);
        }
    }

    @Test
    public void forTest() {
        List<String> array = new ArrayList<>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.remove("2");
        for (String s : array) {
            System.out.println(s);
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(i + ",");
        }
        for (String test : array) {
            forMethod(test);
            System.out.println(test + "in for");
        }
    }

    private void forMethod(String test) {
        if (test.equals("1")) {
            System.out.println(test);
            return;
        }
    }

    @Test
    public void sizeTest() {
        List<Person> l = new ArrayList<>();
        System.out.println(l.size());
    }

    @Test
    public void addNullTest() {
        List<Person> arr = new ArrayList<>();
        arr.add(null);
        for (Person s : arr) {
            System.out.println(s.getName());
            System.out.println("success");
        }
    }

    @Test
    public void forNullTest() {
        List<Person> p = new ArrayList<>();
        p = null;
        for (Person person : p) {
            System.out.println("success");
        }
    }

    @Test
    public void printTest() {
        for (int i = 1; i <= 169; i++) {
            System.out.print(i + ",");
        }
    }

    @Test
    public void assignmentTest() {
        List<Integer> list = new ArrayList<>();
        List<Integer> testList = new ArrayList<>();
        list.add(1);
        testList = list;
        if (testList.isEmpty() && 0 == testList.size()) {
            System.out.println("testList is null");

        }
        for (Integer integer : testList) {
            System.out.println(integer);
        }
    }

    @Test
    public void addAllTest() {
        List<String> list = new ArrayList<>();
        list.addAll(Collections.EMPTY_LIST);
        System.out.println(CollectionUtils.isEmpty(list));
        for (String a : list) {
            System.out.println("enter");
            System.out.println(a);
        }
    }

    @Test
    public void sortTest() {
        // int[] sample = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        // 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        // 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        // 0, -2, 1, 0, -2, 0, 0, 0, 0 };
        // int[] sample = new int[] { 31, 30, 29, 28, 27, 26, 25, 24, 23, 22,
        // 21, 20, 19, 18, 17, 16 };
        // int[] sample = new int[] { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14, 0, -2
        // };
//        int[] sample = new int[]{0, -2, 0, 0, -2, 0, 0, 0, 0, -2, 1, 0, -2, 0, 0, 0, 0, -2, 1, 0, -2, 0, 0, 0, 0, -2, 1, 0, -2, 0, 0, 0};
        int[] sample = new int[]{0, 2, 1};
        System.out.println(sample.length);
        List<Integer> list = new ArrayList<Integer>();
        for (int i : sample)
            list.add(i);
        // use the native TimSort in JDK 7
        // Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // miss the o1 = o2 case on purpose
                // return o1.compareTo(o2);
                System.out.print(o1 + " ");
                System.out.println(o2);
                return o1 > o2 ? 1 : -1;
            }
        });
    }

    @Test
    public void listTest() {
        Exam exam = new Exam();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1");
        list2.add("2");
        exam.setList(list1);
        for (String s : exam.getList()) {
            System.out.println(s);
        }
        exam.setList(list2);
        for (String s : exam.getList()) {
            System.out.println(s);
        }
    }

    private class Exam {
        private List<String> list = new ArrayList<>();

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    @Test
    public void addNumberTest() {
        Integer number = 0;
        Date date = new Date();
        System.out.println(date);
        System.out.println(number);
        add(number, date);
        System.out.println(number);
        System.out.println(date);
    }

    private void add(Integer number, Date date) {
        ++number;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
    }
}

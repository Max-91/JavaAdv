package Homework3;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> pb = new HashMap<>();

    public void Add(String name,String[] phone){
        List<String> list = new LinkedList<>();
        for (int i = 0; i < phone.length; i++) {
            list.add(phone[i]);
        }
        pb.put(name, list);
    }

    public void Get(String name) {
        List<String> list = new LinkedList<>();
        list=pb.get(name);
        if (list==null) {
            System.out.println("Абонента "+name+" нет в телефонной книги");
            return;
        };
        if (list.size()>1) {
            System.out.println("Телефоны ("+list.size()+" шт.) абонента " + name + " : " + list);
        }else{
            System.out.println("Телефон абонента " + name + " : " + list);
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "pb=" + pb +
                '}';
    }
}

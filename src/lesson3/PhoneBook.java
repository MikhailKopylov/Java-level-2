package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<String, List<String>> phoneNumbers;

    public PhoneBook() {
        phoneNumbers = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneList =  phoneNumbers.getOrDefault(name, new ArrayList<>());
//        List<String> phoneList = phoneNumbers.get(name);
        phoneList.add(phoneNumber);
        phoneNumbers.put(name, phoneList);
    }

    public List<String> get(String name) {
        return phoneNumbers.get(name);
    }

    public void display() {
        System.out.println("Phone numbers: ");
        phoneNumbers.forEach((k, v) -> System.out.print(k + ": " + v + "\n"));
    }
}

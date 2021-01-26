package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        // TODO: put some mapping to the map
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");
        hashMap.put(7, "Seven");
        // TODO: print out all keys in the map
        for (int key : hashMap.keySet()) {
            System.out.println(key);
        }

        // TODO: print out all values in the map
        for (int key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }

        // TODO: print out all key-value pair in the map
        LOGGER.info("{}", hashMap);
        for (int key : hashMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        }

        // TODO: print out the number of key-value in the map
        System.out.println(hashMap.size());

        // TODO: check if the map contains key 5(true), 9(false)
        if(hashMap.containsKey(5)){
            System.out.println("Contain key 5");
        }
        if(hashMap.containsKey(9)){
            System.out.println("Contain key 9");
        }

        // TODO: check if the map contains value Five(true), Nine(false)
        for (int key : hashMap.keySet()) {
            if(hashMap.get(key) == "five")
            System.out.println("contains value Five");
        }
        for (int key : hashMap.keySet()) {
            System.out.println("contains value Five");
        }

        // TODO: print out the value with key=6
        System.out.println(hashMap.get(6));

        // TODO: remove all of the mappings from the map, check empty before and after
        System.out.println(hashMap.isEmpty());
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }
}

package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        // TODO: append some elements to the end of the set
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");
        hashSet.add("Five");
        hashSet.add("Six");


        // TODO: get an iterate and use it to print out all elements in the set
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // TODO: print out the number of elements in the set
        System.out.println(hashSet.size());

        // TODO: convert the set to a string array
        String[] data = hashSet.toArray(new String[0]);
        for (String string : data) {
            System.out.println(string);
        }

        // TODO: convert the set to a List/ArrayList
        List<String> list = new ArrayList<>(hashSet);
        for (String string : list) {
            System.out.println(string);
        }

        // TODO:
        Set<String> newHashSet = new HashSet<>(hashSet);
        if (newHashSet.equals(hashSet)) {
            System.out.println("Two set are equal");
        } else {
            System.out.println("Two set are not equal");
        }

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        // TODO: compare two sets and retain elements which are same on both sets
        intersect(hashSet,hashSet);
        iterator = hashSet.iterator();

        System.out.println("Same element on both sets");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // TODO: remove all of the elements from the first set, check empty before and after
        if (hashSet.isEmpty()) {
            System.out.println("This is an empty set");
        } else {
            System.out.println("This set is not empty");
        }

        hashSet.clear();

        if (hashSet.isEmpty()) {
            System.out.println("This is an empty set");
        } else {
            System.out.println("This set is not empty");
        }
    }

    public static void intersect(Set originalSet, Set anotherSet) {
        if (isEqual(originalSet, anotherSet)) {
            return;
        }
        originalSet.retainAll(anotherSet);
    }

    public static boolean isEqual(Set set1, Set set2) {
        if (set1 == set2) {
            return true;
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }
}

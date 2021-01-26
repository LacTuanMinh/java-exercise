package collection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListPractice.class);

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "books", "three", "cats", "java", "dogs", "Dai", "Hung");
        LOGGER.info("All words: {}", stringList);
        LOGGER.info("All words in reverse order: {}", reverseList(stringList));
        LOGGER.info("All words after capitalizing all plural: {}", capitalizePlurals(stringList));
        LOGGER.info("All words after removing all plural: {}", removePlurals(stringList));
        LOGGER.info("All words after adding star after each word: {}", addStars(stringList));
//        LOGGER.info("All words after removing stars: {}", removeStars(stringList));
    }

    public static List<String> reverseList(List<String> list) {
        List<String> newList = new ArrayList<>(list);
        Collections.reverse(newList);
        return newList;
    }

    public static List<String> capitalizePlurals(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String item : list) {
            if (item.charAt(item.length() - 1) == 's') {
                String newItem = item.substring(0, 1).toUpperCase() + item.substring(1);
                newList.add(newItem);
            } else {
                newList.add(item);
            }
        }
        return newList;
    }

    public static List<String> removePlurals(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String item : list) {
            if (item.charAt(item.length() - 1) != 's') {
                newList.add(item);
            }
        }
        return newList;
    }

    public static List<String> addStars(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String item : list) {
            newList.add(item);
            newList.add("*");
        }
        return newList;
    }

    public static List<String> removeStars(List<String> list) {
        // TODO: remove stars which added by addStars
        throw new UnsupportedOperationException();
    }
}

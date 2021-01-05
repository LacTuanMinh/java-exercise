package languagebasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */


  public static void main(String[] args) {
    List<int[]> intervals = new ArrayList<>();
    intervals.add(new int[]{1, 5});
    intervals.add(new int[]{6, 8});
//    intervals.add(new int[]{5, 12});
//    intervals.add(new int[]{2, 6});
    intervals.add((new int[] {1,5}));

    //============

    int k = 2;
    int[] seeds = new int[intervals.size()]; // input array
    Arrays.setAll(seeds, index -> index); // 0,1,2,3,...
    List<int[]> kCombination = new ArrayList<>();

    generateKCombination(seeds, kCombination, k);

    Iterator<int[]> iterator = kCombination.iterator();

    //main bussiness logic
    while (iterator.hasNext()) {

      int[] pair = iterator.next();
      int[] first = intervals.get(pair[0]);
      int[] second = intervals.get(pair[1]);

      if (first[1] >= second[0] && first[0] <= second[1]) {
//                System.out.printf("[%d %d] [%d %d]\n", first[0], first[1], second[0], second[1]);
      } else {
        iterator.remove();
      }
    }

    //print
    iterator = kCombination.iterator();
    while (iterator.hasNext()) {
      int[] pair = iterator.next();
      int[] first = intervals.get(pair[0]);
      int[] second = intervals.get(pair[1]);
      System.out.printf("[%d %d] [%d %d]\n", first[0], first[1], second[0], second[1]);
    }

  }

  public static void generateKCombination(int[] seeds, List<int[]> kCombination, int k) {
    int[] s = new int[k];

    while (true) {
      int i;

      for (i = k - 1; i >= 0 && s[i] == (seeds.length - k + i); i--) ; // find position of item that can be incremented

      if (i < 0) {
        break;
      }
      s[i]++;                    // increment this item

      for (++i; i < k; i++) {    // fill up remaining items
        s[i] = s[i - 1] + 1;
      }

      kCombination.add(getSubset(seeds, s));
    }
  }

  public static int[] getSubset(int[] input, int[] subset) {
    int[] result = new int[subset.length];

    for (int i = 0; i < subset.length; i++) {
      result[i] = input[subset[i]];
    }

    return result;
  }
}

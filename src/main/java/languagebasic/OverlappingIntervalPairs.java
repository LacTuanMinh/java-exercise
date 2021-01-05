package languagebasic;

import java.util.*;

public class OverlappingIntervalPairs {
  /*
  Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
  Example:
  Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
  Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
   */
  public static void main(String[] args) {

    Set<Interval> intervalsSet = new HashSet<>();
    intervalsSet.add(new Interval(1, 5));
    intervalsSet.add(new Interval(6, 8));
    intervalsSet.add(new Interval(5, 12));
    intervalsSet.add(new Interval(2, 6));
    intervalsSet.add(new Interval(1, 5));


    List<Interval> intervalsList = new ArrayList<>(intervalsSet);

    //============

    List<int[]> kCombination = new ArrayList<>();
    generate2Combination(intervalsList.size(), kCombination);
    Iterator<int[]> iterator = kCombination.iterator();

    //main bussiness logic
    while (iterator.hasNext()) {

      int[] pair = iterator.next();
      Interval interval1 = intervalsList.get(pair[0]);
      Interval interval2 = intervalsList.get(pair[1]);

      if (interval1.getSecond() >= interval2.getFirst() && interval1.getFirst() <= interval2.getSecond()) {

      } else {
        iterator.remove();
      }
    }

    //print
    iterator = kCombination.iterator();
    while (iterator.hasNext()) {
      int[] pair = iterator.next();
      Interval interval1 = intervalsList.get(pair[0]);
      Interval interval2 = intervalsList.get(pair[1]);
      System.out.printf("[%d %d] [%d %d]\n", interval1.getFirst(), interval1.getSecond(), interval2.getFirst(), interval2.getSecond());
    }

  }

  public static void generate2Combination(int n, List<int[]> kCombination) {
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        kCombination.add(new int[]{i, j});
      }
    }
  }
}

class Interval {
  private int[] value = new int[2];

  public Interval(int start, int end) {
    this.value[0] = start;
    this.value[1] = end;
  }

  public int getFirst() {
    return value[0];
  }

  public int getSecond() {
    return value[1];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Interval interval = (Interval) o;
    return this.value[0] == interval.value[0] && this.value[1] == interval.value[1];
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }
}
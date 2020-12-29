package languagebasic;

import java.util.Random;

/**
 * Generate a random roster to review assignments =]]
 */
public class RandomRosterGenerator {
  /**
   * Get a roster from an array of available names. Duplication is allowed
   *
   * @param availableNames Array of available names
   * @param size           Size of the roster you want to get
   * @return A roster with the desired size or empty if invalid input
   */
  public String[] getRandomRoster(String[] availableNames, int size) {

    if (size <= 0) {
      return new String[]{};
    }

    Random random = new Random();
    String[] roster = new String[size];

    for (int i = 0; i < size; i++) {
      int index = random.nextInt(availableNames.length);
      roster[i] = availableNames[index];
    }
    return roster;
  }

  public static void main(String[] args) {

    String s1 = "Hello ";
    s1 += "World! ";
    String s2 = "From KMS!";
    System.out.println(s1);
    System.out.println(s1 + s2);

//        String[] availableNames = new String[]{
//                "Alice",
//                "Eugine",
//                "Dick",
//                "Patrick",
//                "Paul",
//                "Seal",
//                "Ariana",
//                "Katy Perry",
//                "Trump",
//                "Biden"
//        };
//
//        RandomRosterGenerator rrg = new RandomRosterGenerator();
//        String[] roster = rrg.getRandomRoster(availableNames, 15);
//
//        for (String name : roster) {
//            System.out.println(name);
//        }
  }
}
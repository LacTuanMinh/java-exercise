package languagebasic;

/**
 * Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.
 * <p>
 * Example
 * <p>
 * For items = [3, 5, 2, 4, 5], the output should be
 * arrayPreviousLess(items) = [-1, 3, -1, 2, 4]
 */
public class ArrayPreviousLess {

  /**
   * @param items Non-empty array of positive integers
   * @return Array containing answer values computed
   * @throws CustomException if the input violates rules
   *                         3 <= items.length <= 15
   *                         1 <= items[i] <= 200
   */
  public static int[] arrayPreviousLess(int[] items) throws CustomException {

    final int length = items.length;
    if (length < 3 || length > 15) {
      throw new CustomException("Items' length out of range 3 - 15");
    }
    int[] itemsCopy = new int[length];

    // TODO: install SonarLint plugin and check it suggestions
    // TODO: use a consistent spacing (2 or 4 choose one)
    for (int i = 0; i < length; i++) {
      itemsCopy[i] = items[i];
    }

    for (int i = 1; i < length; i++) {

      if (itemsCopy[i] < 0 || itemsCopy[i] > 200) {
        throw new CustomException("Item's value out of range");
      }

      for (int j = i - 1; j >= 0; j--) {

        if ((itemsCopy[j] < itemsCopy[i]) && (itemsCopy[j] != -1)) {
          itemsCopy[i] = items[j];
          itemsCopy[j] = -1;
          break;
        }
      }
    }
    return itemsCopy;
  }

  public static void main(String[] args) throws CustomException {
    // TODO: write tests in a separated file
    // TODO: this output not correct
    // should be -1, 3, -1, 2, 4
    // 3 has no smaller value in the left -> -1
    // 5 has only one smaller value in the left -> 3
    // 2 has no smaller value in the left -> -1
    // 4 has two smaller values in the left, select the last one -> 2
    // 5 has three smaller values in the left, select the last one -> 4
    int[] a = new int[]{3, 5, 2, 4, 5};
    int[] b = arrayPreviousLess(a);

    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + "  ");
    }

  }
}

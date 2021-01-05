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

    // TODO: use a consistent spacing (2 or 4 choose one)
    for (int i = 0; i < length; i++) {
      if (items[i] < 0 || items[i] > 200) {
        throw new CustomException("Item's value out of range");
      }

      int indexOf = -1;

      for (int j = 0; j < i; j++) {
        if ((items[j] < items[i])) {
          indexOf = j;
        }
      }

      if (indexOf != -1) {
        itemsCopy[i] = items[indexOf];
      } else {
        itemsCopy[i] = -1;
      }
    }
    return itemsCopy;
  }

  public static void main(String[] args) throws CustomException {

    int[] a = new int[]{3, 5, 2, 4, 5}; // new int[] {10,53,6,56,8};//
    int[] b = arrayPreviousLess(a);

    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i]);

      if (i != b.length - 1) {
        System.out.print(", ");
      }
    }

  }
}

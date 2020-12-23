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
     *                         3 ≤ items.length ≤ 15
     *                         1 ≤ items[i] ≤ 200
     */
    public int[] arrayPreviousLess(int[] items) throws CustomException {

        final int length = items.length;
        if (length < 3 || length > 15) {
            throw new CustomException("Items' length out of rangr 3 - 15");
        }

        for (int i = 1; i < length; i++) {

            if(items[i] < 0 || items[i] > 200) {
                throw new CustomException("Item's value out of range");
            }

            for (int j = i - 1; j >= 0; j--) {

                if (items[j] < items[i]) {
                    items[i] = items[j];
                    items[j] = -1;
                    break;
                }
            }

        }

        return new int[] { };
    }

    public static void main(String[] args) {

    }
}

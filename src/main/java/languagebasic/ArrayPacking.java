package languagebasic;

/**
 * You are given an array of up to four non-negative integers, each less than 256.
 * Your task is to pack these integers into one number M in the following way:
 * - The first element of the array occupies the first 8 bits of M;
 * - The second element occupies next 8 bits, and so on.
 * Return the obtained integer M.
 * <p>
 * Note: the phrase "first bits of M" refers to the least significant bits of M - the right-most bits of an integer. For further clarification see the following example.
 * <p>
 * For a = [24, 85, 0], the output should be
 * arrayPacking(a) = 21784.
 * <p>
 * An array [24, 85, 0] looks like [00011000, 01010101, 00000000] in binary.
 * After packing these into one number we get 00000000 01010101 00011000 (spaces are placed for convenience), which equals to 21784
 */
// sd dịch bit
public class ArrayPacking {
  public static void main(String[] args) {

    int[] data = new int[]{254, 255, 255, 255};// {24, 85, 0};
    int result = 0;

    try {
      result = arrayPacking(data);
    } catch (CustomException e) {
      e.printStackTrace();
    }

    System.out.println(result);
  }

  /**
   * @param array An array of up to four non-negative integers, each less than 256
   * @return The obtained integer packed from given array
   * @throws CustomException if the input violates rules
   *                         1 ≤ array.length ≤ 4
   *                         0 ≤ array[i] < 256
   */
  public static int arrayPacking(int[] array) throws CustomException {

    final int arrayLength = array.length;

    if (arrayLength < 1 || arrayLength > 4) {
      throw new CustomException("Array's length out of range 1 - 4");
    }

    int sum = 0;

    for (int i = 0; i < arrayLength; i++) {
      int index = arrayLength - i - 1;
      int value = array[index];
      sum += (value << (index * 8));
    }

    return sum;
  }
}





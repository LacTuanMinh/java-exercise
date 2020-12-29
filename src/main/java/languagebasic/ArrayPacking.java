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
public class ArrayPacking {

  public static void main(String[] args) {
    // TODO: for input [254, 255, 255, 255] don't let an exception occur
    // The result could be negative
    int[] data = new int[]{254, 255, 255, 255};// new int[]{24, 85, 0};

    try {
      arrayPacking(data);
    } catch (CustomException e) {
      e.printStackTrace();
    }
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

    StringBuilder dataInBinary = new StringBuilder("");

    for (int i = arrayLength - 1; i >= 0; i--) {
      if (array[i] < 0 || array[i] >= 256) {
        throw new CustomException("Item's value out of range");
      }

      dataInBinary.append(decimalToBinaryString(array[i]));

      if (i > 0) {
        dataInBinary.append(" ");
      }
    }

    System.out.println(dataInBinary.toString());
    System.out.println(binaryStringToDecimal(dataInBinary.toString()));
    return 0;
  }

  public static String decimalToBinaryString(int number) {
    StringBuilder result = new StringBuilder(Integer.toBinaryString(number));
    StringBuilder missingDigits = new StringBuilder("");
    int length = result.length();

    while (length < 8) {
      missingDigits.append("0");
      length++;
    }
    return missingDigits.append(result).toString();
  }

  public static int binaryStringToDecimal(String binaryString) {
    String binaryStringCopy = binaryString.replaceAll(" ", "");
    final int length = binaryStringCopy.length();
    int sum = 0;
    char bit;

    for (int i = 0; i < length; i++) {
      bit = binaryStringCopy.charAt(i);
      if (bit == '1') {
        sum += Math.pow(2, length - i - 1);
      }
    }

    return sum;
  }
}





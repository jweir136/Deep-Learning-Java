package DeepLearning;
import java.util.*;

public class Utils {
  /** Returns all of the unique values in a 1D array of
   *    ints.
   *  @param matrix
   *    A 1D matrix containing a series of integers to take
   *      unique values from.
   *  @return Returns a new 1D array of integers containing
   *    all of the unique ints in the matrix argument.
   *  @precondition The length of matrix must be greater
   *    than 0. The matrix array must contain only ints,
   *    and be 1D.
  */
  public static int[] unique(int[] matrix) {
    List<Integer> uniqueValuesList = new ArrayList<>();

    for (int value : matrix) {
      if (uniqueValuesList.contains(value) == false)
        uniqueValuesList.add(new Integer(value));
    }

    int[] uniqueValuesArray = new int[uniqueValuesList.size()];

    for (int i = 0; i < uniqueValuesList.size(); i++) {
      uniqueValuesArray[i] = uniqueValuesList.get(i);
    }

    return uniqueValuesArray;
  }

  /** Outputs a list of all the unique values in a 1D array
    *   of ints.
    * @param matrix
    *   A 1D matrix of ints containing all the values to
    *     get the unique values from.
    * @precondition The length of matrix must be greater
    *   than 0. 
  */
  public static void printUnique(int[] matrix) {
    for (int value : unique(matrix))
      System.out.println(value);
  }

  /** Output a one-hot-encoded version of a 1D matrix of
   *    ints.
   *  @param matrix
   *    A 1D matrix of ints to encode.
   *  @param encodingMap
   *    A Map object that sets the rules for encoding the
   *      matrix argument. The keys are Integer wrapper
   *      classes that correspond to each unique class in
   *      matrix. The values are 1D int arrays indicatoring
   *      the values to encode each unique value with.
   *  @returns A new 2D int array containing a new encoded
   *    version of the matrix argument.
   *  @precondition The length of matrix must be greater
   *    than 0. There must be a key in encodingMap for each
   *    unique value in matrix. There can be no repeat
   *    value in encodingMap's keys and values.
  */
  public static int[][] encodeTargets(int[] matrix, Map<Integer, int[]> encodingMap) {
    int[][] encodedArray = new int[matrix.length][encodingMap.size()];
    int counter = 0;

    for (int value : matrix) {
      encodedArray[counter++] = encodingMap.get(new Integer(value));
    }

    return encodedArray;
  }
}

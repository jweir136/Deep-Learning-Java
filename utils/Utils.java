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

  /** One-hot-encode a 1D matrix of ints. Automatically
   *    creates encoding rules.
   *  @param matrix
   *    A 1D int matrix to one-hot-encode.
   *  @return A new 2D array containing an encoded version
   *    of the matrix argument.
   *  @precondition The length of matrix must be greater
   *    than 0. matrix must contain ints starting with 0,
   *    and working up from 0 for each unique value in
   *    matrix.
  */
  public static int[][] autoEncodeTargets(int[] matrix) {
    int[] encodeRule = new int[unique(matrix).length];
    int[][] encodedArray = new int[matrix.length][unique(matrix).length];
    int counter = 0;

    for (int value : matrix) {
      encodeRule[value] = 1;
      encodedArray[counter++] = encodeRule;
      encodeRule = new int[unique(matrix).length];
    }

    return encodedArray;
  }

  /** Takes the features and adds a bias term to each
   *    instance. Simulates a bias node.
   *  @param features
   *    A 2D array of features to add the bias term to.
   *  @return Return a new 2D array containing the inputed
   *    features and a new bias term attached to each
   *    instance.
   *  @precondition The length of features must be greater
   *    than 0, and the length of the second dimension must
   *    be greater than 0. 
  */
  public static double[][] addBias(double[][] features) {
    double[][] newFeatures = new double[features.length][features[0].length];
    double[] feat = new double[features[0].length + 1];

    for (int i = 0; i < features.length; i++) {
      feat[0] = 1.0;
      for (int j = 0; j < features[0].length; j++) {
        feat[i+1] = Math.random();
      }
      newFeatures[i] = feat;
    }

    return newFeatures;
  }

  /** Create a m*n 2D matrix containing randomly inited
   *    weights between 0 and 1. 
   *  @param nLayer2Nodes
   *    The number of nodes in the second layer. Decided
   *      the size of the first dimension.
   *  @param nLayer1Nodes
   *    The number of nodes in the first layer. Decided the
   *      size of the second dimension.
   *  @return Return a 2D array of random numbers to be
   *    used as weights in a neural network.
   *  @precondition The size of both arguments must be
   *    greater than 0.
  */
  public static double[][] initWeights(int nLayer2Nodes, int nLayer1Nodes) {
    double[][] weights = new double[nLayer2Nodes][nLayer1Nodes];

    for (int i = 0; i < nLayer2Nodes; i++) {
      for (int j = 0; j < nLayer1Nodes; j++) {
        weights[i][j] = Math.random();
      }
    }

    return weights;
  }
}

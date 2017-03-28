import java.util.Arrays;
import java.util.Random;

public class Merge {

  /*
  Postcondition:
  destination contains all of the elements of a and b, and is sorted.
  Preconditions:
  a is sorted, b is sorted
  destination.length == a.length + b.length
  */
  public static void merge(int[] a, int[] b, int[] destination) {
    int indexA = 0;
    int indexB = 0;
    int indexDes = 0;

    while (indexA < a.length && indexB < b.length) { // until one finishes
      if (a[indexA] <= b[indexB]) {
        destination[indexDes] = a[indexA];
        indexA++;
        indexDes++;
      }
      else if (a[indexA] > b[indexB]) { // need else if or jsut else?
        destination[indexDes] = b[indexB];
        indexB++;
        indexDes++;
      }
    }

    if (indexA < a.length) { //a is longer
      for (int i = indexA+indexB; i < destination.length; i++) {
        destination[i] = a[indexA];
        indexA++;
      }
    }
    else if (indexB < b.length) { // b is longer
      for (int i = indexA+indexB; i < destination.length; i++) {
        destination[i] = b[indexB];
        indexB++;
      }
    }
  }

  public static void mergesort(int[] ary) {
    int half = ary.length / 2;
    int[] left = Arrays.copyOfRange(ary,0,half);
    int[] right = Arrays.copyOfRange(ary,half,ary.length);

    if (left.length != 1) {
      mergesort(left);
    }
    if (right.length != 1) {
      mergesort(right);
    }

    merge(left,right,ary);
  }

  // public static String toString(int[] arr) {
  //   String ret = "[";
  //   for (int i = 0; i < arr.length; i++){
  //     ret += arr[i] + ", ";
  //   }
  //   ret += "]";
  //   return ret;
  // }


}

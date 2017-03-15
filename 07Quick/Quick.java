import java.util.Random;

public class placeholder {
  public placeholder() {
    //bod
  }

  public int partition(int[] arr, int start, int end) { // end and start in indices
    Random rand = new Random();
    int ranInd = rand.nextInt(end-start) + 1;
    int splitOn = arr[ranInd];

    int[] ret = new int[arr.length];
    int begging = 0;
    int ending = end;
    int lastHighest;

    for (int i = 0; i <= end; i++) {
      if (i == end) {
        int temp = ret[lastHighest];
        ret[lastHighest] = splitOn;
        ret[end] = temp;
      } else if (arr[i] == arr[splitOn]) {
        // skip
      } else if (arr[i] < splitOn) {
        ret[begging] = arr[i];
        begging++;
      } else if (arr[i] > splitOn) {
        ret[ending] = arr[i];
        lastHighest = ending;
        ending--;
      }
    }

    if (end < arr.length-1) {
      for (int i = end + 1; i < arr.length; i++) {
        ret[i] = arr[i];
      }
    }

    arr = ret;
  }
}

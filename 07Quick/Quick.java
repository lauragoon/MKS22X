import java.util.Random;

public class Quick {
  public Quick() {
    //bod
  }

  public static String part (int[] data, int start, int end){
    //-Choose a random element to be a pivot, and partition the array around it.
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.
    //    (Should be from start to end inclusive)
    Random rand = new Random();
    int ranInd = rand.nextInt(end-start+1) + start;
    int splitOn = data[ranInd];

    int[] work = new int[data.length];
    int start2 = start;
    int end2 = end;
    boolean passPivot = false;
    int newIndex = 0;

    // while (start2 != end2) {
      for (int i = start; i < end; i++) {
        if (i == ranInd) {
          passPivot = true;
        }
        if ((data[i] < splitOn) || (data[i] == splitOn && passPivot)) {
          work[start2] = data[i];
          start2++;
        }
        if (data[i] > splitOn) {
          work[end2] = data[i];
          end2--;
        }
      }
      work[start2] = splitOn;
      newIndex = start2;
    // }

    // if (end-start < data.length) {
    //   if (start > 0) {
    //     for (int i = 0; i < start; i++) {
    //       work[i] = data[i];
    //     }
    //   }
    //   if (end < data.length) {
    //     for (int i = end; i < data.length; i++) {
    //       work[i] = data[i];
    //     }
    //   }
    // }

    for (int i = 0; i < data.length; i++) {
      data[i] = work[i];
    }

  return toString(data) + " on: " + Integer.toString(splitOn) + "new Index: " + Integer.toString(newIndex);
  }
/*
public static int quickselect(int[] data, int k){
//return the value that is the kth smallest value of the array.
//use your partition method to help you accomplish this.
return quickselectH(data,k,0,data.length);
}

public static int quickselectH(int[] data, int k, int start, int end) {
int ind = part(data,0,data.length);
if (ind == k) {
return data[k];
} if (k > ind) {
return quickselectH(data,k,start,ind-1);
} else {
return quickselectH(data,k,ind-1,end);
}
}
*/
public static String toString(int[] arr){
  String ret = "[";
  for (int i = 0; i < arr.length; i++){
    ret += arr[i] + ", ";
  }
  ret += "]";
  return ret;
}

public static void main(String[] args) {
  // int[] test = {6,7,1,2,3,4,0,9};
  int[] test = {999,999,999,4,1,0,3,2,999,999,999};
  System.out.println(toString(test));
  System.out.println(part(test,3,7));
}

}

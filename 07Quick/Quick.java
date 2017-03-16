import java.util.Random;

public class Quick {
  public Quick() {
    //bod
  }

  public static int part (int[] data, int start, int end){
    //-Choose a random element to be a pivot, and partition the array around it.
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.
    //    (Should be from start to end inclusive)
    Random rand = new Random();
    int ranInd = rand.nextInt(end-start+1) + start;
    int splitOn = data[ranInd];

    for (int i = start; i < end; i++) {
      if (i > ranInd && data[i] < splitOn) {
        int temp = data[i];
        data[i] = splitOn;
        data[ranInd] = temp;
        ranInd = i;
      } if (i < ranInd && data[i] > splitOn) {
        int temp = data[i];
        data[i] = splitOn;
        data[ranInd] = temp;
        ranInd = i;
      }
    }
    return ranInd;
  }

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

}

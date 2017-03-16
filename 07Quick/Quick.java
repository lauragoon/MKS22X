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

    int newIndex = 0;

    for (int i = start; i <= end; i++) {
	if (data[i] < splitOn) {
	    work[start2] = data[i];
	    start2++;
	} if (data[i] > splitOn) {
	    work[end2] = data[i];
	    end2--;
	} if (i == end - 1) {
	    //work[end-1] = splitOn;
	    newIndex = end-1;
	}
    }
    
    for (int i = 0; i < data.length; i++) {
	data[i] = work[i];
    }
    /*
    for (int i = start; i < end; i++) {
      if (i > ranInd && data[i] <= splitOn) {
        int temp = data[i];
        data[end] = splitOn;
        data[ranInd] = temp;
        //ranInd = i;
	ranInd = end;
	end--;
      } if (i < ranInd && data[i] > splitOn) {
        int temp = data[i];
        data[i] = splitOn;
        data[ranInd] = temp;
        ranInd = i;
      }
    }
    */
    //return ranInd;
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
	int[] test = {6,7,1,2,3,4,0,9};
	System.out.println(toString(test));
	System.out.println(part(test,0,test.length-1));
    }

}

import java.util.Random;

public class Quick {
  public Quick() {
  }

  public static void switching(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static int[] part (int[] data, int start, int end){
    //-Choose a random element to be a pivot, and partition the array around it.
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.
    //    (Should be from start to end inclusive)
    Random rand = new Random();
    int ranInd = rand.nextInt(end-start+1) + start;

    switching(data,ranInd,start);
    int splitOn = data[start];

    int i = start;
    int lt = start;
    int gt = end;
    int[] ret = new int[3];

    while (i <= gt) {
	if (data[i] == splitOn) {
	    i++;
	}
	else if (data[i] < splitOn) {
	    switching(data,i,lt);
	    i++;
	    lt++;
	}
	else {
	    switching(data,i,gt);
	    gt--;
	}
    }
    
    ret[0] = lt;
    ret[1] = gt;
    ret[2] = splitOn;

    return ret;
  }
    
  public static int quickselect(int[] data, int k){
    //return the value that is the kth smallest value of the array.
    //use your partition method to help you accomplish this.
    return quickselectH(data,k,0,data.length-1);
  }

  public static int quickselectH(int[] data, int k, int start, int end) {
    int[] indArr = part(data,0,data.length-1);
    if (ind == k) {
      return data[k];
    } if (k > ind) {
      return quickselectH(data,k,start,ind-1);
    } else {
      return quickselectH(data,k,ind-1,end);
    }
  }
    

  public static void quicksort(int[] data) {
    quicksortH(data,0,data.length-1);
  }

  public static void quicksortH(int[] data, int left, int right) {
      /*
    if (left < right) {
      int p = part(data,left,right);
      quicksortH(data,p+1,right);
      quicksortH(data,left,p-1);
    }
      */
      if (right - left > 1) {
	  int[] indArr = part(data,left,right);
	  quicksortH(data,left,indArr[0]);
	  quicksortH(data,indArr[1],right);
      }
  }
    
   public static String toString(int[] arr){
     String ret = "[";
     for (int i = 0; i < arr.length; i++){
       ret += arr[i] + ", ";
     }
     ret += "]";
     return ret;
   }

    public static void main(String[] args) {
	/*
	int[] test = {66,999,11,5,66,5,11,223,999,5,223,999,5,999,66};
	System.out.println(toString(test));
	// System.out.println(toString(part(test,0,test.length-1)));
	quicksort(test);
	System.out.println(toString(test));
	*/
	 int[] ary = {2,10,15,23,0,5};
	 System.out.println(quickselect(ary,0));
	 System.out.println(0);
	 System.out.println();
	 System.out.println(quickselect(ary,1));
	 System.out.println(2);
	 System.out.println();
	 System.out.println(quickselect(ary,2));
	 System.out.println(5);
	 System.out.println();
	 System.out.println(quickselect(ary,3));
	 System.out.println(10);
	 System.out.println();
	 System.out.println(quickselect(ary,4));
	 System.out.println(15);
	 System.out.println();
	 System.out.println(quickselect(ary,5));
	 System.out.println(23);
    }

}

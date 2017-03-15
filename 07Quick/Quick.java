import java.util.Random;

public class Quick {
    int[] ary = {2,10,15,23,0,5};
    int splittingOn;
    int[] test;

  public Quick() {
    //bod
  }

  public static void partition(int[] arr, int start, int end) { // end and start in indices
    Random rand = new Random();
    int ranInd = rand.nextInt(end-start) + 1;
    int splitOn = arr[ranInd];
    int splittingOn = splitOn;

    while (start <= end){
	while (arr[start] < splitOn) start++;
	while (arr[end] > splitOn) end--;
	if (start <= end) swap(arr[start++], arr[end--]);
    }
    /*
    int[] ret = new int[arr.length];
    
    for (int i = start; i <= end; i++){
	if (arr[i] == splitOn){
	    // nothing
	} else if (i == end) {
	    if (arr[i] < splitOn){
		ret[start] = arr[i];
		start++;
		ret[start] = splitOn;
	    } else if (arr[i] > splitOn){
		ret[end] = arr[i];
		end--;
		ret[end] = splitOn;
	    }
	} else if (arr[i] < splitOn){
	    ret[start] = arr[i];
	    start++;
	} else if (arr[i] > splitOn) {
	    ret[end] = arr[i];
	    end--;
	}
    }
    */
    /*
    int[] ret = new int[arr.length];
    int begging = 0;
    int ending = end;
    int lastHighest = end;

    for (int i = 0; i <= end; i++) {
	if (i == end) { // if it at end or not
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
    */
    /*
    if (end < arr.length-1) {
      for (int i = end + 1; i < arr.length; i++) {
        ret[i] = arr[i];
      }
    }
    */
    /*
    // arr = ret;
    
    for (int i = 0; i < arr.length; i++){
	arr[i] = ret[i];
    }
    */
  }
    public static String toString(int[] arr){
	String ret = "[";
	for (int i = 0; i < arr.length; i++){
	    ret += arr[i] + ", ";
	}
	ret += "]";
	return ret;
    }

    public static void main(String[] args){
        Quick hello = new Quick();
	partition(hello.ary,0,hello.ary.length-1);
	System.out.println(hello.splittingOn);
	System.out.println(toString(hello.ary));
	//System.out.println(toString(hello.test));
    }
}

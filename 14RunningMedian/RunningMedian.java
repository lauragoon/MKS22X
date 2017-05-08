public class RunningMedian {
    private MyHeap FRONT;
    private MyHeap BACK;
    private Integer MEDIAN;

    public RunningMedian() {
	FRONT = new MyHeap(); // change these to Integers
	BACK = new MyHeap(false);
    }

    public void add(int n) {
    }

    public double getMedian() {
	return MEDIAN;
    }

}

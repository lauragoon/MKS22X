public class RunningMedian {
    private MyHeap FRONT;
    private MyHeap BACK;
    private int MEDIAN;

    public RunningMedian() {
	FRONT = new MyHeap();
	BACK = new MyHeap(false);
    }

    public void add(int n) {
    }

    public double getMedian() {
	return MEDIAN;
    }

}

public class RunningMedian {
  private MyHeap FRONT;
  private MyHeap BACK;
  // private Integer MEDIAN;

  public RunningMedian() {
    FRONT = new MyHeap();
    BACK = new MyHeap(false);
  }

  public void add(int n) {
    if (FRONT.size() == 0 || n < FRONT.peek()) {
      FRONT.add(n);
    }
    else {
      BACK.add(n);
    }
    if (FRONT.size() > BACK.size() + 1) {
      BACK.add(FRONT.remove());
    }
    else if (BACK.size() > FRONT.size() + 1) {
      FRONT.add(BACK.remove());
    }
  }

  public double getMedian() {
    if (FRONT.size() - BACK.size() == 1) {
      return FRONT.peek();
    }
    else if (FRONT.size() - BACK.size() == -1) {
      return BACK.peek();
    }
    else {
      return ((double)FRONT.peek() + (double)BACK.peek()) / 2;
    }
  }


}

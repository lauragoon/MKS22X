public class USACO {

  public USACO() {
  }

  public int bronze(String filename) {
    Lake lake = new Lake(filename);
    return lake.V;
  }

  public int silver(String filename) {
    CTravel cow = new CTravel(filename);
    return cow.S;
  }

  public static void main(String[] args) {
    USACO x = new USACO();
    // System.out.println(x.silver("tests2/ctravel.3.in"));
    // System.out.println("6435");
    // System.out.println(x.silver("tests2/ctravel.4.in"));
    // System.out.println("339246");
    // System.out.println(x.silver("tests2/ctravel.5.in"));
    // System.out.println("0");
    // System.out.println(x.silver("tests2/ctravel.6.in"));
    // System.out.println("14396412");
    // System.out.println(x.silver("tests2/ctravel.7.in"));
    // System.out.println("1533810");
    // System.out.println(x.silver("tests2/ctravel.8.in"));
    // System.out.println("456055");
    // System.out.println(x.silver("tests2/ctravel.9.in"));
    // System.out.println("28");
    // System.out.println(x.silver("tests2/ctravel.10.in"));
    // System.out.println("1321670");
  }

}

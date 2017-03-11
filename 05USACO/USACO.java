public class USACO {

  public USACO() {
  }

  public int bronze(String filename) {
    Lake lake = new Lake(filename);
    return lake.V;
  }

  public int silver(String filename) {
    return 0;
  }

  // public static void main(String[] args) {
  //   USACO x = new USACO();
  //   System.out.println(x.bronze("tests/makelake.1.in"));
  // }

}

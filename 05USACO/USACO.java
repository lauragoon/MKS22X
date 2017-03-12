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
  //   String ret = "";
  //   for (int i = 0; i < cow.N; i++){
  //     for (int j = 0; j < cow.M; j++){
  //       ret += cow.pasture[i][j] + " ";
  //     }
  //     ret += "\n";
  //   }
  //   return ret;
  }

  public static void main(String[] args) {
    USACO x = new USACO();
    System.out.println(x.silver("tests2/ctravel.2.in"));
    // System.out.println("1");
    // System.out.println(x.bronze("tests/makelake.1.in"));
  }

}

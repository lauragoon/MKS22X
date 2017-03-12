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

}

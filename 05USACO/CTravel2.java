import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CTravel {

  int[][] pasture;
  int[][] pasture2;
  int[][] template;
  int N, M, T;
  int R1, C1, R2, C2;
  int S;

  public CTravel(String filename) {
    File file = new File(filename);

    try {
      Scanner scanner = new Scanner(file);
      N = Integer.parseInt(scanner.next());
      M = Integer.parseInt(scanner.next());
      T = Integer.parseInt(scanner.next());

      pasture = new int[N][M];
      for (int row = 0; row < N && scanner.hasNextLine(); row++) {
        String line = scanner.next();
        for (int col = 0; col < M && scanner.hasNext(); col++) {
          if (line.substring(col,col+1).equals("*")){
            pasture[row][col] = -1;
          } else {
            pasture[row][col] = 0;
          }
        }
      }

      pasture2 = new int[N][M];
      template = new int[N][M];
      for (int row = 0; row < N; row++) {
        for (int col = 0; col < M; col++) {
          pasture2[row][col] = pasture[row][col];
          template[row][col] = pasture[row][col];
        }
      }

      R1 = Integer.parseInt(scanner.next()) - 1;
      C1 = Integer.parseInt(scanner.next()) - 1;
      R2 = Integer.parseInt(scanner.next()) - 1;
      C2 = Integer.parseInt(scanner.next()) - 1;

      pasture[R1][C1] = 1;

      int counter = 1;
      // System.out.println(debugArr(pasture));
      // System.out.println(debugArr(pasture2));
      while (counter <= T) {
        // if (counter == 1) {
        //   move(pasture,pasture2,true);
        // }else {
          if (counter % 2 != 0) {
            move(pasture,pasture2);
            // System.out.println(debugArr(pasture2));
          } else {
            move(pasture2,pasture);
            // System.out.println(debugArr(pasture));
          }
        // }
        counter++;
      }

      if (T % 2 == 0) { // even
        S = pasture[R2][C2];
      } else { // odd
        S = pasture2[R2][C2];
      }

    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File not found.");
      System.exit(1);
    }
  }

  public void move(int[][] from, int[][] to){
    // if (isFirst) {
    //   for (int row = 0; row < N; row++) {
    //     for (int col = 0; col < M; col++) {
    //       to[row][col] = template[row][col];
    //     }
    //   }
    // } else {
      for (int row = 0; row < N; row++) {
        for (int col = 0; col < M; col++) {
          to[row][col] = template[row][col];
        }
      }
    // }

    // try {
    //   TimeUnit.SECONDS.sleep(3);
    // } catch (InterruptedException e) {
    //   System.out.println("Why");
    // }
    for (int r = 0; r < N; r++) {
      // System.out.println("STARTING NEW ROW, ROW #:" + Integer.toString(r+1));
      for (int c = 0; c < M; c++) {
        // System.out.println("STARTING NEW COL, COL #:" + Integer.toString(c+1));
        // System.out.println("(" + Integer.toString(r+1) + ", " + Integer.toString(c+1) + ")");
        // System.out.println();
        // System.out.println("FROM");
        // System.out.println(debugArr(from));
        // System.out.println("TO");
        // System.out.println(debugArr(to));
        // System.out.println("BEG");
        // System.out.println();
        // try {
        //   TimeUnit.SECONDS.sleep(3);
        // } catch (InterruptedException e) {
        //   System.out.println("Why");
        // }

        if (from[r][c] != 0 && from[r][c] != -1) { // top left
          if (r != 0 && to[r-1][c] != -1) {
            to[r-1][c] += from[r][c];

            // System.out.println("case 1"); // TOP ROW
            // System.out.println("FROM");
            // System.out.println(debugArr(from));
            // System.out.println("TO");
            // System.out.println(debugArr(to));
            // try {
            //   TimeUnit.SECONDS.sleep(3);
            // } catch (InterruptedException e) {
            //   System.out.println("Why");
            // }
          }

          if (r < N-1 && to[r+1][c] != -1) {
            to[r+1][c] += from[r][c];

            // System.out.println("case 2"); // LAST ROW
            // System.out.println("FROM");
            // System.out.println(debugArr(from));
            // System.out.println("TO");
            // System.out.println(debugArr(to));
            // try {
            //   TimeUnit.SECONDS.sleep(3);
            // } catch (InterruptedException e) {
            //   System.out.println("Why");
            // }
          }

          if (c != 0 && to[r][c-1] != -1) {
            to[r][c-1] += from[r][c];

            // System.out.println("case 3"); // FIRST COLs
            // System.out.println("FROM");
            // System.out.println(debugArr(from));
            // System.out.println("TO");
            // System.out.println(debugArr(to));
            // try {
            //   TimeUnit.SECONDS.sleep(3);
            // } catch (InterruptedException e) {
            //   System.out.println("Why");
            // }
          }

          if (c < M-1 && to[r][c+1] != -1) {
            to[r][c+1] += from[r][c];

            // System.out.println("case 4"); // LAST COL
            // System.out.println("FROM");
            // System.out.println(debugArr(from));
            // System.out.println("TO");
            // System.out.println(debugArr(to));
            // try {
            //   TimeUnit.SECONDS.sleep(3);
            // } catch (InterruptedException e) {
            //   System.out.println("Why");
            // }
          }
          to[r][c] = 0;
          // System.out.println("reset");
          // System.out.println("FROM");
          // System.out.println(debugArr(from));
          // System.out.println("TO");
          // System.out.println(debugArr(to));
          // try {
          //   TimeUnit.SECONDS.sleep(3);
          // } catch (InterruptedException e) {
          //   System.out.println("Why");
          // }
        }
      }
    }
  }
// }

  public String debugArr(int[][] arr) {
      String ret = "";
      for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
          ret += arr[i][j] + " ";
        }
        ret += "\n";
      }
      return ret;
  }

}

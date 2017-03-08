import java.io.*;
import java.util.*;

public class Lake {

  int[][] lake;
  int[][] directions;
  int R, C, E, N, D, V;

  public Lake(String filename) {
    File file = new File(filename);
    try {
      Scanner scanner = new Scanner(file);
      R = Integer.parseInt(scanner.next());
      C = Integer.parseInt(scanner.next());
      E = Integer.parseInt(scanner.next());
      N = Integer.parseInt(scanner.next());
      lake = new int[R][C];
      for (int row = 0; row < R && scanner.hasNextLine(); row += 1) {
        for (int col = 0; col < C && scanner.hasNext(); col += 1) {
          lake[row][col] = Integer.parseInt(scanner.next());
        }
      }
      directions = new int[N][3];
      for (int i = 0; i < N; i += 1) {
        for (int j = 0; j < 3; j += 1) {
          directions[i][j] = Integer.parseInt(scanner.next());
        }
      }

      for (int i = 0; i < directions.length; i += 1) {
        stomp(directions[i][0], directions[i][1], directions[i][2]);
      }

      for (int row = 0; row < lake.length; row += 1) {
        for (int col = 0; col < lake[row].length; col += 1) {
          if (lake[row][col] >= E) lake[row][col] = 0;
          else lake[row][col] = E - lake[row][col];
        }
      }

      for (int row = 0; row < lake.length; row += 1) {
        for (int col = 0; col < lake[row].length; col += 1) {
          D += lake[row][col];
        }
      }

      V = D * 72 * 72;

      while (filename.indexOf(".") != -1 && filename.charAt(filename.length() - 1) != '.') {
        filename = filename.substring(0, filename.length() - 1);
      }
      try {
        PrintWriter fileOut = new PrintWriter(filename + ".out", "UTF-8");
        fileOut.println(V);
        fileOut.close();
      }
      catch (IOException e) { }

    }
    catch (FileNotFoundException e) { }
  }

  public void stomp(int R_s, int C_s, int D_s) {
    R_s -= 1;
    C_s -= 1;
    int max = lake[R_s][C_s];
    for (int r = R_s; r < R_s + 3; r += 1) {
      for (int c = C_s; c < C_s + 3; c += 1) {
        if (lake[r][c] >= max) max = lake[r][c];
      }
    }
    int temp = max - D_s;
    for (int r = R_s; r < R_s + 3; r += 1) {
      for (int c = C_s; c < C_s + 3; c += 1) {
        if (lake[r][c] > temp) lake[r][c] = temp;
      }
    }
  }

  public String toString() {
    String string = "";
    for (int row = 0; row < lake.length; row += 1) {
      for (int col = 0; col < lake[row].length; col += 1) {
        if (lake[row][col] == 0) string += "-- ";
        else {
          if (lake[row][col] < 10) string += " ";
          string += lake[row][col] + " ";
        }
      }
      string += "\n";
    }
    return string;
  }

  public static void main(String args[]) {
    Lake a = new Lake("makelake.1.in");
    //	a.stomp(1, 1, 100);
    //	a.stomp(1, 2, 200);
    //System.out.println(a);
  }

}

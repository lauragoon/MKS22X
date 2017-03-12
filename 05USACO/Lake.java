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

    }
    catch (FileNotFoundException e) {
      System.out.println("ERROR: File not found.");
      System.exit(1);
    }
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

}

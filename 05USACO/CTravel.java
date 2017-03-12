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
      while (counter <= T) {
          if (counter % 2 != 0) {
            move(pasture,pasture2);
          } else {
            move(pasture2,pasture);
          }
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
    for (int row = 0; row < N; row++) {
      for (int col = 0; col < M; col++) {
        to[row][col] = template[row][col];
      }
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (from[r][c] != 0 && from[r][c] != -1) { // top left

          if (r != 0 && to[r-1][c] != -1) {
            to[r-1][c] += from[r][c];
          }

          if (r < N-1 && to[r+1][c] != -1) {
            to[r+1][c] += from[r][c];
          }

          if (c != 0 && to[r][c-1] != -1) {
            to[r][c-1] += from[r][c];
          }

          if (c < M-1 && to[r][c+1] != -1) {
            to[r][c+1] += from[r][c];
          }

          to[r][c] = 0;
        }
      }
    }
  }


}

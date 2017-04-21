import java.util.Stack;

public class Eval {
  private static boolean isOp(String str) {
    char me = str.charAt(0);
    return me == '+' || me == '-' || me == '*' || me == '/' || me == '%';
  }

  public static double apply(double first, double second, String op) {
    if (op.equals("+")) {
      return first + second;
    }
    else if (op.equals("-")) {
      return first - second;
    }
    else if (op.equals("*")) {
      return first * second;
    }
    else if (op.equals("/")) {
      return first / second;
    }
    else if (op.equals("%")) {
      return first % second;
    }
    else {
      return -1.0;
    }
  }

  public static double eval(String str) {
    String[] tokens = str.split(" ");
    Stack<Double> values = new Stack<Double>();

    if (tokens.length == 1) {
      return Double.parseDouble(tokens[0]);
    }
    for (String token : tokens) {
      if(isOp(token)) {
        values.push(apply(values.pop(),values.pop(),token));
      }
      else {
        values.push(Double.parseDouble(token));
      }
    }
    return values.pop();
  }

}

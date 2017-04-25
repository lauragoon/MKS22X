import java.util.Stack;

public class StackCalc {
  private static boolean isOp(String str) {
    char me = str.charAt(0);
    return me == '+' || me == '-' || me == '*' || me == '/' || me == '%';
  }

  public static double apply(double first, double second, String op) {
    if (op.equals("+")) {
      return second + first;
    }
    else if (op.equals("-")) {
      return second - first;
    }
    else if (op.equals("*")) {
      return second * first;
    }
    else if (op.equals("/")) {
      return second / first;
    }
    else if (op.equals("%")) {
      return second % first;
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

  public static void main(String[] args)
{
    System.out.println(eval("10 2 +"));//12.0
    System.out.println(eval("10 2 -"));//8.0
    System.out.println(eval("10 2.0 +"));//12.0
    System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
    System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
}

}

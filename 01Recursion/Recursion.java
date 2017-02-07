ublic class Recursion{ 
 public static String name(){
  return "Goon,Laura";
 }
 public static double helper(double n, double guess){
  if (n < 0){
   throw new
  }
  double better_guess = ((n / guess) + guess) / 2;
  if (Math.abs(better_guess - guess) < 0.0000000000001){
   return better_guess;
  }
  return helper(n, better_guess);
 }
 public static double sqrt(double n){ 
  return helper(n,n/2);
 }
}

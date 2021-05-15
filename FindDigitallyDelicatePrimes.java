import java.util.*;
class Main {
  public static boolean isPrime(int num) {
    int till = (int)Math.sqrt((double)num)+1;
    if (num == 1) {
      return false;
    }
    for (int r = 2 ; r < till ; r++) {
      if (num%r == 0) {
        return false;
      }
    }
    return true;
  }
  public static ArrayList<Integer> findDigCombos(int num) {
    ArrayList<Integer> combos = new ArrayList<Integer>();
    int numDigits = Integer.toString(num).length();
    String digits = "0123456789";
    for (int i = 0 ; i < numDigits ; i++) {
      char[] curr = Integer.toString(num).toCharArray();
      for (int j = 0 ; j < 10 ; j++) {
        curr[i] = digits.charAt(j);
        combos.add(Integer.parseInt(String.valueOf(curr)));
      }
    }
    return combos;
  }
  public static void isDigitallyDelicate(int num, ArrayList<Integer> digitallyDelicate) {
    boolean works = true;
    if (isPrime(num)) {
      for (int combo:findDigCombos(num)) {
        if (isPrime(combo) && combo != num) {
          works = false;
          break;
        }
      }
    } else works = false;
    if (works) {
      digitallyDelicate.add(num);
    }
    if (num%1000000 == 0) {
      System.out.print("Currently at " + Integer.toString(num) + " ; ");
      System.out.println(Integer.toString(digitallyDelicate.size()) + " digitally delicate #s found so far");
    }
  }
  public static void main(String[] args) {
    ArrayList<Integer> digitallyDelicate = new ArrayList<Integer>();
    int start = 535000000;
    int end = 635000000;
    for (int x = start ; x < end+1 ; x++) {
      isDigitallyDelicate(x, digitallyDelicate);
    }
    for (int l = 0 ; l < digitallyDelicate.size() ; l++) {
      System.out.println(digitallyDelicate.get(l));
    }
  }
}

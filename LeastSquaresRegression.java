import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.math.BigDecimal;
import java.lang.Math;
class Main {
  public static long sumy(ArrayList<Long> trueY) {
    long res = 0;
    for (int i = 0 ; i < trueY.size() ; i++) {
      res+=trueY.get(i);
    }
    return res;
  }
  public static long sumxy(ArrayList<Long> trueY) {
    long res = 0;
    for (int i = 0 ; i < trueY.size() ; i++) {
      res+=trueY.get(i)*i;
    }
    return res;
  }
  public static long sumxsquared(ArrayList<Long> trueY) {
    long res = 0;
    for (int i = 0 ; i < trueY.size() ; i++) {
      res+=i*i;
    }
    return res;
  }
  public static void main(String[] args) {
    // Get data from input file
    ArrayList<Long> trueY = new ArrayList<Long>();
    try {
      File myObj = new File("digdelnums.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        long data = myReader.nextLong();
        trueY.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    // Calculate theta0 and theta1
    int n = trueY.size();
    long sumx = (n-1)*(n-2)/2;
    double theta1 = ((n*sumxy(trueY)) - (sumx*sumy(trueY)))/((n*sumxsquared(trueY)) - sumx*sumx);
    double theta0 = (sumy(trueY)-(theta1*sumx))/n;
    System.out.print("Theta 0: ");
    System.out.print(theta0);
    System.out.println("");
    System.out.print("Theta 1: ");
    System.out.println(theta1);
  }
}

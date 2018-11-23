//Example Using class Random
import java.io.*;
import java.util.*;
class RandomInts {
  public static void main(String[] args) {
    Random rng = new Random();
    int rnum, i;
    for (i=1; i<=50; i++) {
      rnum = rng.nextInt(10);
      System.out.println(rnum);
    }
  }
}

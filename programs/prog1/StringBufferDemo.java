import java.io.*;
import java.util.*;
class StringBufferDemo {
  public static void main(String[] args) {
    StringBuffer myStrBuf = new StringBuffer("abcdef");
    System.out.println("string in myStrBuf is "+myStrBuf);
    System.out.println("length = "+myStrBuf.length());
    System.out.println("capacity = "+myStrBuf.capacity());
    System.out.println("char at index 4 is "+myStrBuf.charAt(4));
  }
}
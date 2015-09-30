import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Ctci_1_3 {
  public static void main(String[] args) {
    int[] a = {1,3,2,2,2,3,1,4, 0, 0, 0, 0};
    int modifiedLength = a.length;
    
    for (int i = 0; i < modifiedLength-1; i++) {
      for (int j = i+1; j < modifiedLength; j++) {
        if (a[i] == a[j]) {
          modifiedLength = moveRight(a, modifiedLength, j);
          j--;
        }
      }
    }
    
    for (int i = 0; i < modifiedLength; i++) {
      if (i == modifiedLength - 1) {
        System.out.print(a[i]);
      } else {
        System.out.print(a[i] + ", ");
      }
    }
  }
  
  public static int moveRight(int[] a, int length, int pos) {
    if (length == 0) {
      return 0;
    }
    
    for (int i = pos; i < length-1; i++) {
      int j = i+1;
      a[i] = a[j];
      j++;
    }
    
    return length - 1;
  }
  
}

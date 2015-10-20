import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Ctci_20_5 {
	public static void main(String[] args) {
		int[] a = {1,2,3,2,4,1,3};
		minDistance(a, 1, 3);
	}

	public static void minDistance(int[] a, int num1, int num2) {
		if (a.length == 0) {
			return;
		}

		int num1pos = -1;
		int num2pos = -1;
		int minDistance = 1000;

		for (int i = 0; i < a.length; i++) {
			if(num1 == a[i] || num2 == a[i]) {
				if ((Math.abs(num1pos - num2pos) < minDistance) && num1pos >= 0 && num2pos >=0) {
					minDistance = Math.abs(num1pos - num2pos);
				}
				if (a[i] == num1) {
					num1pos = i;
				}
				if (a[i] == num2) {
					num2pos = i;
				}
			}
		}
	}
}







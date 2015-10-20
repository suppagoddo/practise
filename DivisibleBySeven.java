/**
 * Created by uagrawal on 10/13/15.
 */

/**
 WAP a program to find a contineous subset whose sum is divisible by 7. We are given a array of number (negative+positive).
 calculate the complexity of your algorithm
 */

//examples:
// 7, 7, -7
// 0,0,0

//8, 2 ,9 ,8 ,2
//sum 8,10,19,27,29
//1,3 ,5 ,6 ,1

public class DivisibleBySeven {

    public static void main(String[] args) {
        int[] array = {1,2,3,5};
        int sum = maxSumDividedBySeven(array);

    }

    public static int maxSumDividedBySeven(int[] a) {
        int sum = 0;
        int maxSum  = 0;
        int[] modArray = new int[a.length];
        int[] countHashMap = new int[10];

        for(int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            modArray[i] = sum % 7;
            countHashMap[modArray[i]]++;
        }



        return 0;
    }
}

public class BinarySearch {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(array, 0));
    }

    public static boolean binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right-left)/2;
            if (array[middle] == number) {
                return true;
            } else {
                if (array[middle] < number) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }
}
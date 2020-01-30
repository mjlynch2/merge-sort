import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] testArray = {1, 2, 4, 2, 1, 9, 0, 6, 11, 12, 6, 3};
        int[] testArray1 = {1, 2, 4, 2, 1, 9, 0, 6, 11, 12, 6, 3, -1, 22, -4, 5};
        int[] testArray2 = {2, 1, 4, 3};
        System.out.println("Testing Array:");
        System.out.println(Arrays.toString(testArray));
        int[] sortedTest = sort(testArray);
        System.out.println(Arrays.toString(sortedTest));

        System.out.println("Testing Array 1:");
        System.out.println(Arrays.toString(testArray1));
        int[] sortedTest1 = sort(testArray1);
        System.out.println(Arrays.toString(sortedTest1));

        System.out.println("Testing Array 2:");
        System.out.println(Arrays.toString(testArray2));
        int[] sortedTest2 = sort(testArray2);
        System.out.println(Arrays.toString(sortedTest2));
    }

    private static int[] merge(int[] a, int[] b) {
        int i=0;
        int j=0;

        int[] destArray = new int[a.length + b.length];

        while(i < a.length && j < b.length) {
            if (a[i] < b[j]){
                destArray[i+j] = a[i++];
//                i++;
            } else {
                destArray[i + j] = b[j++];
//                j++;
            }
        }

        while (i < a.length) {
            destArray[i+j] = a[i++];
        }
        while (j < b.length) {
            destArray[i+j] = b[j++];
        }

        return destArray;
    }

    private static int[] sort(int[] inputArray) {
        if(inputArray.length < 2) {
            return inputArray;
        }

        int[] lower = Arrays.copyOfRange(inputArray, 0, inputArray.length/2);
        lower = sort(lower);
        int[] upper = Arrays.copyOfRange(inputArray, (inputArray.length/2), inputArray.length);
        upper = sort(upper);

        return merge(lower, upper);
    }

}

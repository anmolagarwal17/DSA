import java.util.*;

public class QuickSort {

    // quick sort using iteration - loops
    public void sort(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int loc = left;

        // to store left and right extremes of all right sub-arrays
        Deque<Integer> rightArrLeft = new ArrayDeque<Integer>();
        Deque<Integer> rightArrRight = new ArrayDeque<Integer>();

        while (true) {
            System.err.println("he");
            int leftOfCurrArr = left;
            int rightOfCurrArr = right;
            loc = left;

            while (left != right) {
                System.out.println(left+" "+right+" "+loc);
                if (loc == left)
                    if (arr[loc] > arr[right]) {
                        swap(arr, loc, right);
                        loc = right;
                    } else
                        right--;
                else if (loc == right)
                    if (arr[left] > arr[loc]) {
                        swap(arr, left, loc);
                        loc = left;
                    } else
                        left++;
            }
            // if left subarray has atleast 2 elements
            if (leftOfCurrArr < loc - 1) {
                left = leftOfCurrArr;
                right = loc-1;
            }
            // pushing left and right of right array in stack  to quick sort them later
            // when all left arrays are completely sorted
            else if(!rightArrLeft.isEmpty())
            {
                left = rightArrLeft.pop();
                right = rightArrRight.pop();
            }
            // break when there is no left or right sub-array
            else
                break;
            // if right subarray has atleast 2 elements
            if (loc + 1 < rightOfCurrArr)
            {
                rightArrLeft.push(loc+1);
                rightArrRight.push(rightOfCurrArr);
            }
        }

    }

    // quick sort using recursion
    // public void sort(int arr[]) {
    // quickSort(arr, 0, arr.length - 1);
    // }

    // quick sort using recursion
    private void quickSort(int arr[], int left, int right) {

        int loc = left;
        int leftOfCurrArr = left;
        int rightOfCurrArr = right;

        while (left != right) {
            if (loc == left)
                if (arr[loc] > arr[right]) {
                    swap(arr, loc, right);
                    loc = right;
                } else
                    right--;
            else if (loc == right)
                if (arr[left] > arr[loc]) {
                    swap(arr, left, loc);
                    loc = left;
                } else
                    left++;
        }
        // if left subarray has atleast 2 elements
        if (leftOfCurrArr < loc - 1)
            quickSort(arr, leftOfCurrArr, loc - 1);
        // if right subarray has atleast 2 elements
        if (loc + 1 < rightOfCurrArr)
            quickSort(arr, loc + 1, rightOfCurrArr);

    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();

        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (100.0 * Math.random());
        // arr[i] = 100 - i;
        // arr[i] = i;

        System.out.println("\n\nArray before sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);

        s.sort(arr);

        System.out.println("\n\nArray after sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);
    }
}
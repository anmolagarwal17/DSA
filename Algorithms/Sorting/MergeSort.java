import java.util.Arrays;

public class MergeSort {

    public void sort(int arr[]) {
        arr = mergeSort(arr);

        // // if there is 2 or more elements then sort them
        // // only 1 element is always sorted
        // if (arr.length >= 2) {
        //     int arr1[];
        //     int arr2[];
        //     // calling merge sort on left and right half of current array
        //     arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        //     arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        //     sort(arr1);
        //     sort(arr2);
        //     merge(arr1, arr2, arr);
        // }
    }

    public int[] mergeSort(int arr[]) {
        int arr1[];
        int arr2[];
        if (arr.length >= 2) {
            // calling merge sort on left and right half of current array
            arr1 = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
            arr2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        } else
            // if there is only one element the return it as it is
            return arr;

        // return merge(arr1, arr2);

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        return arr;
    }

    // public void merge(int arr1[], int arr2[], int arr[]) {
    //     int i = 0, j = 0, k = 0;

    //     while (i < arr1.length && j < arr2.length) {
    //         if (arr1[i] < arr2[j]) {
    //             arr[k] = arr1[i];
    //             i++;
    //         } else {
    //             arr[k] = arr2[j];
    //             j++;
    //         }
    //         k++;
    //     }

    //     while (i < arr1.length) {
    //         arr[k] = arr1[i];
    //         i++;
    //         k++;
    //     }
    //     while (j < arr2.length) {
    //         arr[k] = arr2[j];
    //         j++;
    //         k++;
    //     }
    // }

    public static void main(String[] args) {
        MergeSort s = new MergeSort();

        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (100.0 * Math.random());
        // arr[i] = 100 - i;

        System.out.println("\n\nArray before sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);

        s.sort(arr);

        System.out.println("\n\nArray after sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);
    }
}
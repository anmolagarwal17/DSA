public class QuickSort {

    public void sort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int arr[], int left, int right) {

        int loc = left;
        int leftOfCurrArr=left;
        int rightOfCurrArr=right;
        
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
        if (leftOfCurrArr < loc-1)
            quickSort(arr, leftOfCurrArr, loc - 1);
        // if right subarray has atleast 2 elements
        if (loc+1 < rightOfCurrArr)
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
public class InsertionSort {

    public void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp)
                    arr[j + 1] = arr[j];
                else
                    break;
            }
            arr[j +1] = temp;
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();

        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++)
            // arr[i] = (int) (100.0 * Math.random());
            arr[i] = 100 - i;
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
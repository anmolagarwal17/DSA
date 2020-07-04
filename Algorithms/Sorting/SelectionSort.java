public class SelectionSort {

    public void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minValIndex = i;
            for(int j=i+1; j<arr.length; j++)
                if(arr[j] < arr[minValIndex])
                    minValIndex = j;
            swap(arr, i, minValIndex);
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();

        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (100.0 * Math.random());

        System.out.println("\n\nArray before sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);

        s.sort(arr);

        System.out.println("\n\nArray after sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);
    }
}
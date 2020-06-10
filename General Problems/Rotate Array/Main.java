public class Main {

    public static void rotate(int arr[], int itr, boolean forward) {

        if (itr > arr.length)
            itr = itr % arr.length;

        int temp[] = new int[itr];

        if (forward) {

            for (int i = arr.length - itr; i < arr.length; i++)
                temp[i - arr.length + itr] = arr[i];
            for (int i = arr.length - itr - 1; i >= 0; i--) {
                arr[i + itr] = arr[i];
            }
            for (int i = 0; i < itr; i++) {
                arr[i] = temp[i];
            }
        } else {
            for (int i = 0; i < temp.length; i++)
                temp[i] = arr[i];
            for (int i = itr; i < arr.length; i++) {
                arr[i - itr] = arr[i];
            }
            for (int i = arr.length - itr; i < arr.length; i++) {
                arr[i] = temp[i - (arr.length - itr)];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (i + 1) * 10;
        for (int i = 0; i < arr.length; i++)
            System.out.println((i + 1) + ": " + arr[i]);

        rotate(arr, 3, false);

        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.println((i + 1) + ": " + arr[i]);
    }
}
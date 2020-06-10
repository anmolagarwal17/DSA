class Main {

    public static int secondLargest(int arr[]) {

        int largest = arr[0];
        int sLargest = arr[0];

        // for (int i = 1; i < arr.length; i++) {
        // if (arr[i] > largest)
        // largest = arr[i];
        // for (int j = 0; j < i; j++)
        // if ((arr[j] > sLargest && arr[j] < largest) || (sLargest == largest))
        // sLargest = arr[j];
        // }

        // a more efficient solution will be following one
        // because above loop complexity = O(n*(n-1)/2) => O(n^2)
        // below loop complexity = O(n+n) => O(n)
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > largest)
                largest = arr[i];

        // first we found out the largest in array
        // then we have to find the largest number which is just smaller than largest number found above
        for (int i = 1; i < arr.length; i++)
            if ((arr[i] > sLargest && arr[i] < largest) || (sLargest == largest))
                sLargest = arr[i];

        return sLargest;
    }

    public static void main(String[] args) {
        int arr[] = new int[20];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100);

        for (int i = 0; i < arr.length; i++)
            System.out.println((i + 1) + ": " + arr[i]);
        System.out.println();

        System.out.println("Second largest in array is: " + secondLargest(arr));
    }
}
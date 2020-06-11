class Main {

    public static void distinctElementFrequency(int arr[]) {
        int distinct[] = new int[arr.length];
        int lastIndex = -1;

        distinct[lastIndex + 1] = arr[0];
        lastIndex++;


        // finding out all distinct elements and storing them in distinct[] array and also info of number of distinct elements in variable lastIndex
        for (int i = 0; i < arr.length; i++) {
            boolean present = false;
            for (int j = 0; j < distinct.length; j++)
                if (arr[i] == distinct[j])
                    present = true;
            if (!present) {
                distinct[lastIndex + 1] = arr[i];
                lastIndex++;
            }
        }

        System.out.println("\nDistinct element(s) with their respective count(s) are:\n");

        // counting how many times that distinct element is present in the array and printing it
        for (int i = 0; i <= lastIndex; i++) {
            int count = 0;
            
            for (int j = 0; j < arr.length; j++)
            if (arr[j] == distinct[i])
            count++;
            
            System.out.println(distinct[i] + ": " + count + " time(s).");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            // arr[i] = i%10;
            // arr[i] = i/10;
        }

        System.out.println("\nArray:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ": " + arr[i]);
        }

        System.out.println();

        distinctElementFrequency(arr);
    }
}
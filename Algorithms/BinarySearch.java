class BinarySearch{

    public static int binarySearch(int arr[], int val){

        int l = 0;
        int r = arr.length-1;
        int mid;

        while(l <= r){
            mid = (r+l)/2;
            if(arr[mid] == val) return mid;
            else if(val < arr[mid]) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {

        int arr[] = new int[100];
        for (int i = 0; i < 100; i++)
            arr[i] = i;
    }
}
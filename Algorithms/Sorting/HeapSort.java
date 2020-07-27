class HeapSort{

    public void sort(int arr[]){
        int heap[] = new int[arr.length];
        int size = -1;

        for (int i = 0; i < arr.length; i++) {
            size++;
            insert(heap, arr[i], size);
        }

        for (int i = size; i >= 0; i--) {
            heap[size] = delete(heap, size);
            size--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap[i];
        }

    }

    public void insert(int heap[], int val, int size){
        heap[size] = val;
        int currentPos = size;

        while((currentPos-1)/2 >= 0 && heap[(currentPos-1)/2] < val){
            heap[currentPos] = heap[(currentPos-1)/2];  // if parent value is smaller than val then insert that value in current position
            if(currentPos == 0) break;  // break when there is no parent to compare to
            else currentPos = (currentPos-1)/2; // update current position to compare to its parent in next iteration
        }

        heap[currentPos] = val;
    }

    public int delete(int heap[], int size){

        if(size == -1) return -1;
        int deleted = heap[0];
        heap[0] = heap[size];
        int temp = heap[0];
        int currentPos = 0;

        while(currentPos <= size){
            if((currentPos * 2) + 1 <=size && heap[(currentPos*2)+1] >= heap[(currentPos*2)+2] && heap[(currentPos*2)+1] > temp) {  // first condition before AND is to check whether the psotiion to be checked is in range or not
                heap[currentPos] = heap[(currentPos * 2) + 1];  // if left child is greater than right child and left child is also greater than current parent then put left child at current position
                currentPos = (currentPos * 2) + 1;
            }
            else if((currentPos * 2) + 2 <=size && heap[(currentPos*2)+2] > temp) {
                heap[currentPos] = heap[(currentPos * 2) + 2];  // else if right child is greater than left AND current parent then put right child at current position
                currentPos = (currentPos * 2) + 2;
            }
            else break; // when neither left nor right child is greater than current parent then break the loop as elements are in their right position other than on current position
        }
        heap[currentPos] = temp;
        return deleted;
    }

    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (100.0 * Math.random());

        System.out.println("\n\nArray before sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("\n\nArray after sorting:\n");
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);
    }
}
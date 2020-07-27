import java.util.Scanner;

class Heap{
//    head data structure

    private int heap[] = new int[5];
    private int size = -1;

    Main(){}
    Main(int val){
        this.insert(val);
    }

    public void insert(int val){
//        double heap size when no more space is left in heap
        if(heap.length-1 == size)
            doubleHeapSize();
        size++;
        heap[size] = val;
        int currentPos = size;

        while((currentPos-1)/2 >= 0 && heap[(currentPos-1)/2] < val){
            heap[currentPos] = heap[(currentPos-1)/2];  // if parent value is smaller than val then insert that value in current position
            if(currentPos == 0) break;  // break when there is no parent to compare to
            else currentPos = (currentPos-1)/2; // update current position to compare to its parent in next iteration
        }

        heap[currentPos] = val;
    }

    public void delete(){

        if(size == -1) return;

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
        size--;
        if(size+1 == heap.length/2)
            halfHeapSize();
    }

//    print heap function
    public void printHeap(){
        for (int i = 0; i <= size; i++)
            System.out.println(heap[i]+"  "+i);
    }

    public void printHeapVisually(){
        int levels = (int) (Math.log(size+1) / Math.log(2));

        for (int i = 0; i <= levels; i++) {
            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i+1) - 1; j++) {   // gets index of current level
                if(j>size) {
                    System.out.println("\n-------------------------------------\n");
                    return;
                }
                for (int k = levels; k >= i; k--)
                    System.out.print("          ");
                System.out.print(heap[j]);
            }
            System.out.println();
        }

    }

//    double heap size function
    private void doubleHeapSize(){
        System.out.println("double");
        int newHeap[] = new int[(size+1)*2];
        for (int i = 0; i <= size; i++)
            newHeap[i] = heap[i];
        heap = newHeap;
    }

//    half heap size function
    private void halfHeapSize(){
        int newHeap[] = new int[(heap.length+1)/2];
        for (int i = 0; i <= size; i++)
            newHeap[i] = heap[i];
        heap = newHeap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(40);
        heap.insert(21);
        heap.insert(34);
        heap.insert(57);
        heap.insert(1);
        heap.insert(16);
        heap.insert(18);
        heap.insert(0);
        heap.insert(310);
        heap.insert(170);
        heap.insert(35);
        heap.printHeapVisually();
//        heap.printHeap();

//        heap.delete();
//        heap.printHeap();
//        sc.hasNext();
        for (int i = 0; i < 20; i++) {
            heap.delete();
            heap.printHeapVisually();
        }

    }
}
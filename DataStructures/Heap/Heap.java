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
        if(this.heap.length-1 == this.size)
            doubleHeapSize();
        this.size++;
        this.heap[this.size] = val;
        int currentPos = this.size;

        while((currentPos-1)/2 >= 0 && this.heap[(currentPos-1)/2] < val){
            this.heap[currentPos] = this.heap[(currentPos-1)/2];  // if parent value is smaller than val then insert that value in current position
            if(currentPos == 0) break;  // break when there is no parent to compare to
            else currentPos = (currentPos-1)/2; // update current position to compare to its parent in next iteration
        }

        this.heap[currentPos] = val;
    }

    public void delete(){

        if(this.size == -1) return;

        this.heap[0] = this.heap[this.size];
        int temp = this.heap[0];
        int currentPos = 0;

        while(currentPos <= this.size){
            if((currentPos * 2) + 1 <=this.size && this.heap[(currentPos*2)+1] >= this.heap[(currentPos*2)+2] && this.heap[(currentPos*2)+1] > temp) {  // first condition before AND is to check whether the psotiion to be checked is in range or not
                this.heap[currentPos] = this.heap[(currentPos * 2) + 1];  // if left child is greater than right child and left child is also greater than current parent then put left child at current position
                currentPos = (currentPos * 2) + 1;
            }
            else if((currentPos * 2) + 2 <=this.size && this.heap[(currentPos*2)+2] > temp) {
                this.heap[currentPos] = this.heap[(currentPos * 2) + 2];  // else if right child is greater than left AND current parent then put right child at current position
                currentPos = (currentPos * 2) + 2;
            }
            else break; // when neither left nor right child is greater than current parent then break the loop as elements are in their right position other than on current position
        }
        this.heap[currentPos] = temp;
        this.size--;
        if(this.size+1 == this.heap.length/2)
            halfHeapSize();
    }

//    print heap function
    public void printHeap(){
        for (int i = 0; i <= this.size; i++)
            System.out.println(this.heap[i]+"  "+i);
    }

    public void printHeapVisually(){
        int levels = (int) (Math.log(this.size+1) / Math.log(2));

        for (int i = 0; i <= levels; i++) {
            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i+1) - 1; j++) {   // gets index of current level
                if(j>this.size) {
                    System.out.println("\n-------------------------------------\n");
                    return;
                }
                for (int k = levels; k >= i; k--)
                    System.out.print("          ");
                System.out.print(this.heap[j]);
            }
            System.out.println();
        }

    }

//    double heap size function
    private void doubleHeapSize(){
        System.out.println("double");
        int newHeap[] = new int[(this.size+1)*2];
        for (int i = 0; i <= this.size; i++)
            newHeap[i] = this.heap[i];
        this.heap = newHeap;
    }

//    half heap size function
    private void halfHeapSize(){
        int newHeap[] = new int[(this.heap.length+1)/2];
        for (int i = 0; i <= this.size; i++)
            newHeap[i] = this.heap[i];
        this.heap = newHeap;
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
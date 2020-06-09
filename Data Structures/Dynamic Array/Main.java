class DynamicArray {

    private int arr[];
    private int lastIndex = -1;

    DynamicArray(int size) {
        this.arr = new int[size];
    }

    // insert an item
    public void insert(int item) {
        if (this.lastIndex + 1 == this.arr.length)
            this.doubleSize();
        this.lastIndex++;
        this.arr[this.lastIndex] = item;
    }

    // count total items
    public int count() {
        return this.lastIndex + 1;
    }

    // get item at given index
    public int getItem(int index) {
        if (index < 0 || index > this.lastIndex) {
            // the program should ideally throw an error here
            System.out.println("Invalid index: " + index + " for getting item!");
            return 0;
        }
        return this.arr[index];
    }

    // delete item at given index
    public void delete(int index) {
        if (index < 0 || index > this.lastIndex) {
            // the program should ideally throw an error here
            System.out.println("Invalid index: " + index + " for deleting item!");
            return;
        }
        // this.arr[i+1] will work because we are taking i<lastIndex insted of
        // i<=lastIndex
        for (int i = index; i < this.lastIndex; i++)
            this.arr[i] = this.arr[i + 1];
        this.lastIndex--;
        // converting following to double so it donot drom 0.5 values in case of odd
        // lengths (1,3,5,...)
        if (this.lastIndex + 1.0 == this.arr.length / 2.0)
            this.halve();
    }

    // edit an item at given index
    public void edit(int newVal, int index) {
        if (index < 0 || index > this.lastIndex) {
            // the program should ideally throw an error here
            System.out.println("Invalid index: " + index + " for editing item!");
            return;
        }
        this.arr[index] = newVal;
    }

    // search item
    public int search(int item) {
        for (int i = 0; i <= this.lastIndex; i++)
            if (this.arr[i] == item)
                return i;
        return -1;
    }

    // double the size of array
    private void doubleSize() {
        int newArr[] = new int[this.arr.length * 2];
        for (int i = 0; i <= this.lastIndex; i++)
            newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    private void halve() {
        int newArr[] = new int[this.arr.length / 2];
        for (int i = 0; i <= this.lastIndex; i++)
            newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    // show complete array and other array info
    public void showArray() {

        System.out.println("Last index: " + this.lastIndex);
        System.out.println("Array length: " + this.arr.length);
        if (this.lastIndex == -1) {
            System.out.println("Array empty!");
        }
        for (int i = 0; i <= this.lastIndex; i++) {
            System.out.println(i + 1 + ": " + this.arr[i]);
        }
        System.out.println("");
    }
}

class Main {
    public static void main(String[] args) {

        // create DynamicArray object
        DynamicArray arr = new DynamicArray(5);

        // inserting values
        arr.insert(5);
        arr.insert(10);
        arr.insert(15);
        arr.insert(55);
        arr.insert(25);
        arr.insert(30);
        arr.insert(35);
        arr.insert(40);
        arr.insert(45);
        arr.insert(50);
        arr.showArray();

        // edit value
        arr.edit(20, 3);
        arr.showArray();

        // count
        System.out.println("Count: " + arr.count());

        arr.delete(6);
        arr.showArray();
        arr.delete(5);
        arr.showArray();
        arr.delete(0);
        arr.showArray();
        arr.delete(-1);
        arr.delete(3);
        arr.delete(2);
        arr.showArray();

        arr.insert(55);
        arr.showArray();

        System.out.println("55 is at index: " + arr.search(55) + "\n");

        arr.edit(55, 0);
        arr.edit(55, 7);
        arr.edit(55, 5);
        arr.showArray();
        System.out.println("55 is at index: " + arr.search(55) + "\n");

        System.out.println("Item at index 4: " + arr.getItem(4));

    }
}
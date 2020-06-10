class DynamicArray {

    private int arr[];
    private int lastIndex = -1;

    DynamicArray(int size) {
        this.arr = new int[size];
    }

    // append an item at end
    public void append(int item) {
        if (this.lastIndex + 1 == this.arr.length)
            this.doubleSize();
        this.lastIndex++;
        this.arr[this.lastIndex] = item;
    }

    // insert an item at given index
    public void insert(int item, int index) throws Exception {
        if(index<0 || index>lastIndex+1)
        {
            throw new Exception("Invalid index! Cannot insert item at index: "+index);
        }
        else{
            if (this.lastIndex + 1 == this.arr.length)
                this.doubleSize();
                for(int i=this.lastIndex; i>=index; i--)
                {
                    this.arr[i+1] = this.arr[i];
                }
                this.arr[index] = item;
            this.lastIndex++;
        }
    }

    // count total items
    public int count() {
        return this.lastIndex + 1;
    }

    // get item at given index
    public int getItem(int index) throws Exception {
        if (index < 0 || index > this.lastIndex) {
            throw new Exception("Invalid index: " + index + " for getting item!");
        }
        return this.arr[index];
    }

    // delete item at given index
    public void delete(int index) throws Exception {
        if (index < 0 || index > this.lastIndex) {
            throw new Exception("Invalid index: " + index + " for deleting item!");
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
    public void edit(int newVal, int index) throws Exception {
        if (index < 0 || index > this.lastIndex) {
            throw new Exception("Invalid index: " + index + " for editing item!");
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
    public static void main(String[] args) throws Exception{

        // create DynamicArray object
        DynamicArray arr = new DynamicArray(5);

        // appending values
        arr.append(5);
        arr.append(10);
        arr.append(15);
        arr.append(55);
        arr.append(25);
        arr.append(30);
        arr.append(35);
        arr.append(40);
        arr.append(45);
        arr.append(50);
        arr.showArray();
        
        arr.insert(100, 0);
        arr.showArray();
        arr.insert(200, 11);
        arr.showArray();
        arr.insert(300, 5);
        arr.showArray();
        
        // the next 2 insert statements throws error because we are trying to insert at an invalid position
        // arr.insert(200, -1);
        // arr.insert(200, 15);
        // arr.showArray();
        
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
        
        // the delete statement will throw exception because invalid index is requested to be deleted
        // arr.delete(-1);
        arr.delete(3);
        arr.delete(2);
        arr.showArray();

        arr.append(55);
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
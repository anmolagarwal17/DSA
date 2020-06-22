class DynamicArray {
    
    // i have deleted all functions from dynamic array class that are not needed in stack for simplicity

    private int arr[];
    private int lastIndex = -1;

    DynamicArray() {
        this.arr = new int[1];
    }

    // double the size of array
    private void doubleSize() {
        int newArr[] = new int[this.arr.length * 2];
        for (int i = 0; i <= this.lastIndex; i++)
            newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    private void halfArray() {
        int newArr[] = new int[this.arr.length / 2];
        for (int i = 0; i <= this.lastIndex; i++)
            newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    // count total items
    public int count() {
        return this.lastIndex + 1;
    }

    // append an item at end
    public void append(int item) {
        if (this.lastIndex + 1 == this.arr.length)
            this.doubleSize();
        this.lastIndex++;
        this.arr[this.lastIndex] = item;
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
        // making array half its size only when it has atleast 2 elements or more
        if (this.lastIndex + 1.0 == this.arr.length / 2.0 && lastIndex > 0)
            this.halfArray();
    }
}

class Stack {

    DynamicArray stack;

    Stack() {
        this.stack = new DynamicArray();
    }

    public void push(int val) {
        // adding element at last of dynamic array
        this.stack.append(val);
    }

    public int pop() throws Exception {
        int val;
        int lastIndex = this.stack.count() - 1;

        // lastIndex value must have to be 0 or more to contain atleast 1 element
        if (lastIndex < 0)
            throw new Exception("No item can be popped because stack is empty!");
        else {
            // setting val value to last item and then deleting it from dynamic array
            val = this.stack.getItem(lastIndex);
            this.stack.delete(lastIndex);
        }

        return val;
    }

    public int peek() throws Exception {
        int val = 0;
        int lastIndex = this.stack.count() - 1;

        // lastIndex value must have to be 0 or more to contain atleast 1 element
        if (lastIndex < 0)
            throw new Exception("No item can to peek because stack is empty!");
        else
            val = this.stack.getItem(lastIndex);

        return val;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;

        // when atleast 1 element is present then return isEmpty result as false(not
        // empty)
        if (this.stack.count() > 0)
            isEmpty = false;

        return isEmpty;
    }
}

class Main {

    public static void main(String[] args) throws Exception {

        Stack stack = new Stack();

        System.out.println("stack isEmpty: " + stack.isEmpty());

        stack.push(50);
        stack.push(100);
        stack.push(150);
        stack.push(200);

        System.out.println("After pushing items, stack isEmpty: " + stack.isEmpty());
        System.out.println("Last element of stack(popping): " + stack.pop());
        System.out.println("Last element of stack(popping): " + stack.pop());
        System.out.println("Last element of stack(popping): " + stack.pop());
        
        System.out.println("Peeking last element of stack: " + stack.peek());
        System.out.println("Last element of stack(popping): " + stack.pop());

        // // the next two statements will throw error because there is no item in stack, hence cannot peek or pop from stack
        // System.out.println("Peeking last element of stack: " + stack.peek());
        // System.out.println("Last element of stack(popping): " + stack.pop());
        
        System.out.println("After popping all items, stack isEmpty: " + stack.isEmpty());
        
        
    }
}
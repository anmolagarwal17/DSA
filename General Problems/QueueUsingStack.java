import java.util.ArrayDeque;
import java.util.Deque;

class Queue{
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void shiftStacks(){
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public void enQueue(int data){
        stack1.push(data);
    }
    public int deQueue(){
        int deleted = 0;
        if(isEmpty())
            System.out.println("Queue is empty!");
        else {
            shiftStacks();
            deleted = stack2.pop();
        }
        return deleted;
    }

    public int peek(){
        int data = 0;
        if(isEmpty())
            System.out.println("Queue is empty!");
        else {
            shiftStacks();
            data = stack2.peek();
        }
        return data;
    }
}

class QueueUsingStack{
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Queue isEmpty(): "+queue.isEmpty());
        queue.enQueue(5);
        queue.enQueue(10);
        queue.enQueue(15);
        queue.enQueue(20);
        queue.enQueue(25);
        queue.enQueue(30);
        System.out.println("Queue isEmpty(): "+queue.isEmpty());
        System.out.println("Queue peek(): "+queue.peek());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue peek(): "+queue.peek());
        queue.enQueue(35);
        queue.enQueue(40);
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
        System.out.println("Queue pop(): "+queue.deQueue());
    }
}
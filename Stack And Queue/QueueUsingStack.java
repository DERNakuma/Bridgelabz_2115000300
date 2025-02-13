import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(int item) {
        stackEnqueue.push(item);
    }

    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new RuntimeException("Dequeue from an empty queue");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    public int peek() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new RuntimeException("Peek from an empty queue");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }
}
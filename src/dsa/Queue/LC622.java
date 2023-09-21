package dsa.Queue;

public class LC622 {
    int[] q;
    int front, rear, size;

    public LC622(int k) {
        front = 0;
        rear = -1;
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (!isFull()){
            rear = (rear + 1) % q.length;
            q[rear] = value;
            size++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()){
            front = (front + 1) % q.length;
            size--;
            return true;
        }
        else
            return false;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return q.length == size;
    }
}

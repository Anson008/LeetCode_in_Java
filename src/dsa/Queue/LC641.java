package dsa.Queue;

public class LC641 {
    int[] q;
    int front = 0;
    int rear = -1;
    int size = 0;
    int capacity;

    public LC641(int k) {
        this.q = new int[k];
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (--front < 0) front += capacity;
        q[front] = value;
        size++;
        if (size == 1) rear = front;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (--rear < 0) rear += capacity;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

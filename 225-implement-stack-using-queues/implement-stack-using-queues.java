class MyStack {
    int[] arr;
    int front, rear, size, capacity;

    public MyStack() {
        this(1000); // default capacity
    }

    public MyStack(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void add(int x) {
        if(size == capacity) throw new RuntimeException("Stack overflow");
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    private int remove() {
        if(size == 0) throw new RuntimeException("Stack underflow");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    private int peek() {
        if(size == 0) throw new RuntimeException("Stack is empty");
        return arr[front];
    }

    public void push(int x) {
        add(x);
        for(int i = 0; i < size - 1; i++) {
            add(remove());
        }
    }

    public int pop() {
        return remove();
    }

    public int top() {
        return peek();
    }

    public boolean empty() {
        return size == 0;
    }
}

/**
 * Example usage:
 * MyStack stack = new MyStack();
 * stack.push(1);
 * stack.push(2);
 * System.out.println(stack.top()); // 2
 * System.out.println(stack.pop()); // 2
 * System.out.println(stack.empty()); // false
 */

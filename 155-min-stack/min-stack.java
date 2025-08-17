class Node{
    int data;
    int minSoFar;
    Node next;
    
    Node(int x, int min){
        data = x;
        minSoFar = min;
        next = null;
    }
}

class MinStack {
    Node top;
    
    public MinStack() {
        top = null;    
    }
    
    public void push(int val) {
        if (top == null) {
            top = new Node(val, val);
        } else {
            Node newNode = new Node(val, Math.min(val, top.minSoFar));
            newNode.next = top;
            top = newNode;
        }
    }
    
    public void pop() {
        if (top != null) top = top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.minSoFar;
    }
}

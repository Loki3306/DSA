class Node{
    int data,min;
    Node next;

    Node(int x,int y){
        data=x;
        min=y;
        next=null;
    }
}

class MinStack {
    Node top;

    public MinStack() {
        top= null;    
    }
    
    public void push(int val) {
        if(top==null){
            Node newNode=new Node(val,val);
            newNode.next=top;
            top=newNode;
        }else{
            Node newNode=new Node(val,Math.min(top.min,val));
            newNode.next=top;
            top=newNode;
        }
        
    }
    
    public void pop() {
        top=top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
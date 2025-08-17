class MyStack {
    int[] arr;
    int cap,front,rear,size;

    public MyStack() {
        arr= new int[1000];
        front=0;
        size=0;
        rear=-1;    
    }
    
    public void add(int x){
        rear++;
        arr[rear]=x;
        size++;
    }

    public int remove(){
        int x=arr[front];
        front++;
        size--;
        return x;
    }


    public void push(int x) {
        add(x);
        for(int i=0;i<size-1;i++){
            add(remove());
        }
    }
    
    public int pop() {
        return remove();
    }
    
    public int top() {
        return arr[front];
    }
    
    public boolean empty() {
        return (size==0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
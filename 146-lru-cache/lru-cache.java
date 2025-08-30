class LRUCache {
    class Node{
        int key,value;
        Node prev,next;

        Node(int k,int v){
            this.key=k;
            this.value=v;
        }
    }

    int capacity;
    HashMap<Integer,Node> map;
    Node tail,head;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        tail=new Node(0,0);
        head=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public void addHead(Node node){
        node.next=head.next;
        node.prev=head;        
        head.next.prev=node;
        head.next=node;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node= map.get(key);
        removeNode(node);
        addHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            removeNode(node);
            addHead(node);
        }
        else{
            if(map.size()==capacity){
                Node last= tail.prev;
                removeNode(last);
                map.remove(last.key);
            }

            Node node=new Node(key,value);
            addHead(node);
            map.put(key,node);
        }       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
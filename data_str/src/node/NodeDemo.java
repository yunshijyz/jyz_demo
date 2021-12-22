package node;




public class NodeDemo {

    //头节点指针
    private Node head;

    //尾节点指针
    private Node last;

    //链表实际长度
    private int size;


    /**
     * 插入
     * @param data
     * @param index
     */
    public void insert(int index, int data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node insertNode = new Node(data);

        if(size == 0){
            //空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0){
            //插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (size == index){
            //插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node prevNode = get(index-1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }

        size++;

    }


    /**
     * 删除元素
     * @param index
     * @return
     */
    public Node remove(int index){
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node removeNode = null;
        if(index == 0){
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if(index == size-1){
            //删除尾节点
            Node prevNode = get(index-1);
            removeNode = prevNode.next;
            last = prevNode;
        } else {
            //删除中间节点
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }

        size--;

        return removeNode;
    }


    /**
     * 链表查找元素
     * @param index
     * @return
     */
    public Node get(int index){
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node temp = head;
        for (int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }



    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        NodeDemo nodeDemo = new NodeDemo();
        nodeDemo.insert(0,3);
        nodeDemo.insert(1,7);
        nodeDemo.insert(2,9);
        nodeDemo.insert(3,5);


        nodeDemo.remove(2);
        nodeDemo.output();
    }

}

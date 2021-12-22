package array;

public class ArrayDemo {

    private int[] ints;

    private int size;


    public ArrayDemo(int count){
        this.ints = new int[count];
        size = 0;
    }

    /**
     * 插入
     * @param index
     * @param element
     */
    public void insert(int index, int element){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出范围");
        }

        if(size >= ints.length ){
            expansion();
        }

        for(int i = size-1 ; i >= index ; i--){
            ints[i+1] = ints[i];
        }

        ints[index] = element;

        size++;

    }


    /**
     * 删除
     * @param index
     * @return
     */
    public int delete(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出范围");
        }

        int deleteInt = ints[index];

        for(int i = index; i < size-1; i++ ){
            ints[i]=ints[i+1];
        }

        size--;

        return deleteInt;
    }

    /**
     * 扩容
     */
    public void expansion(){

        int[] intsNew = new int[ints.length * 2];

        System.arraycopy(ints,0,intsNew,0,ints.length);

        ints = intsNew;
    }

    /**
     *
     *输出
     */
    public void output(){
        for (int i = 0; i < size; i++){
            System.out.println(ints[i]);
        }
    }

    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo(4);


        arrayDemo.insert(0,1);
        arrayDemo.insert(1,5);
        arrayDemo.insert(2,3);
        arrayDemo.insert(3,4);
        arrayDemo.insert(4,5);

        arrayDemo.insert(1,12);

        arrayDemo.delete(1);

        arrayDemo.output();
    }
}

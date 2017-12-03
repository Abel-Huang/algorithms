package cn.abelib.collection;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2016/12/25.
=======
 * Created by huangjianjin on 2016/12/25.
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 * This is a fixed capacity stack witch could store any type of object by using generic.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap){
        a=(Item[])new Object[cap];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
        a[N++]=item;
    }

    public Item pop(){
        return a[--N];
    }

    public int size(){
        return N;
    }
}

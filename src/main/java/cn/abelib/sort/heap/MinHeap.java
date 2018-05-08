package cn.abelib.sort.heap;

import cn.abelib.commons.Constant;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abel-huang on 2017/7/25.
 * 基于数组实现的最小堆
 */
public class MinHeap{
    private int[] heap;
    private int size ;

    /**
     *  构造一个固定长度的堆
     */
    public MinHeap(){
        heap = new int[Constant.DEFAULT_CAPACITY + 1];
        size = 0;
    }

    /**
     *  在堆尾进行插入
     *  并且进行对堆调整
     * @param value
     */
    public void insert(int value){
        heap[size+1] = value;
        size++;
        swim(size);
    }

    public void insertList(List<Integer> list){
        list.stream().forEach(item -> insert(item));
    }

    public int delMin(){
        int min= heap[1];
        heap[1] =heap[size];
        heap[size] = 0;
        size-=1;
        sink(1);
        return min;
    }

    public int geMin(){
        if (size > 0){
            return heap[1];
        }
        return -1;
    }

    public void traversal(){
        int[] array = new int[size];
        System.arraycopy(heap, 1, array, 0, size);
        Arrays.stream(array).forEach(System.out::println);
    }

    /**
     *  如果父节点大于子节点
     *  交换父子节点值
     *  主要用在插入
     * @param k
     */
    private void swim(int k){
        while(k > 1 && heap[k] < heap[k/2]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k /=2;
        }
    }

    /**
     *  将节点下沉到合适的位置， 只要目的是为了
     *  是为了找出当前所有结点中的最小元素
     * @param k
     */
    private void sink(int k){
        while (2*k <= size){
            int j = 2*k;
            // 找到
            if (j < size && heap[j] > heap[j+1]){
                j++;
            }
            if (heap[k] < heap[j]){
                break;
            }
            int temp = heap[k];
            heap[k] = heap[j];
            heap[j] = temp;
            k = j;
        }
    }
}

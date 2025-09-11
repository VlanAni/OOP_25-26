/**
 * Class that sort array using Heap-object.
*/
public class HeapSort {
    /**
     * Static method that creates Heap-object and call <code>sort</code>.
     * Time complexity - O(N*log(N)).
     *
     * @param array - user's array.
     */
    public static void sortArr(int[] array) {
        Heap heap = new Heap();
        heap.sort(array);
    }
}

/**
 * Implementing <code>heap</code> data structure.
 * Main condition - parent is greater than its children.
 */
class Heap {
    /**nodes - array, that stores the tree.*/
    int[] nodes;
    /**size - nodes' size.*/
    int size;

    /**
     * <code>addNode</code> - adding node to the tree.
     * If added node is smaller that it's parent, then go up.
     * Time complexity - O(log(N)).
     *
     * @param number - number to add.
     */
    private void addNode(int number) {
        this.nodes[size] = number;
        int curridx = size;
        this.size++;
        while (curridx > 0 & nodes[curridx] < nodes[(curridx - 1) / 2]) {
            swapInHeap(curridx, (curridx - 1) / 2);
            curridx = (curridx - 1) / 2;
        }
    }

    /**
     * Swapping values of given nodes.
     * Time complexity - O(1).
     *
     * @param idx1 - first node's index.
     *
     * @param idx2 - second node's index.
     */
    public void swapInHeap(int idx1, int idx2) {
        int t = this.nodes[idx1];
        this.nodes[idx1] = this.nodes[idx2];
        this.nodes[idx2] = t;
    }

    /**
     * Extracting minimal value from heap.
     * It swaps the root and last node and then goals the main condition.
     * To goal the main condition, it swaps the node and minimal child.
     * Time complexity - O(log(N)).
     *
     * @return - minimal value in the heap.
     */
    private int extractMin() {
        int minvalue = this.nodes[0];
        swapInHeap(0, this.size - 1);
        this.size--;
        int childtoswap = 0;
        int curridx = 0;
        int lcidx;
        int rcidx;
        while (curridx * 2 + 1 < this.size) {
            lcidx = curridx * 2 + 1;
            rcidx = curridx * 2 + 2;
            if (this.nodes[lcidx] < this.nodes[curridx]){
                childtoswap = lcidx;
            }
            if (rcidx < size & nodes[rcidx] < nodes[curridx] & nodes[lcidx] > nodes[rcidx]){
                childtoswap = rcidx;
            }
            if (curridx == childtoswap){
                break;
            }
            swapInHeap(curridx, childtoswap);
            curridx = childtoswap;
        }
        return minvalue;
    }

    /**
     * Creating a binary tree.
     * It reads i-th element from given array and uses {@link Heap#addNode}.
     * Time complexity: O(N * log(N)).
     *
     * @param array - array to sort.
     *
     * @param arrsize - given array's size.
     */
    private void buildHeap(int[] array, int arrsize) {
        this.nodes = new int[arrsize];
        for (int i = 0; i < arrsize; i++) {
            this.addNode(array[i]);
        }
    }

    /**
     * Sorting given array.
     * First step - creating a heap.
     * Second step - on each iteration it extracts min and rewrite array[i].
     * Time complexity:  O(2 * n * log(n)) = O(n * log(n)).
     *
     * @param array - array to sort.
     */
    public void sort(int[] array) {
        int arrsize = array.length;
        int minval;
        this.buildHeap(array, arrsize);
        for (int i = 0; i < arrsize; i++) {
            minval = this.extractMin();
            array[i] = minval;
        }
    }
}
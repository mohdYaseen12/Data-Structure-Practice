
/**
 * minHeapImplementation
 */
public class minHeapImplementation {

    Class MinHeap{
        int[] arr;
        int size;
        int capacity;

        MinHeap(int c){
            this.arr = new int[c];
            this.size = 0;
            this.capacity = c;
        }
        int left(int i) {
            return (2*i+1);
        }
        int right(int i){
            return (2*i+2);
        }
        int parent(int i){
            return (i-1)/2;
        }
    };

    public static void main(String[] args) {
        
    }
}
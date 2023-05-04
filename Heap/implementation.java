import java.util.ArrayList;

public class implementation {
    static class Heap {
        ArrayList<Integer> data;

        public Heap(){
            data = new ArrayList<>();
        }

        public void swap(int i, int j){
           int valAti = data.get(i);
           int valAtj = data.get(j);
           data.set(i,valAtj);
           data.set(j,valAti);
        }

        public void upHeapify(int ci){
            int pi = (ci - 1)/2;
            if(pi >= 0 && data.get(pi) > data.get(ci)){
                swap(ci,pi);

                upHeapify(pi);
            }
        }
        // add
        public void add(int val){
            data.add(val);
            upHeapify(data.size()-1);

        }

        private void downHeapify(int pi){
            int lci = 2*pi+1;
            int rci = 2*pi+2;

            int mini = pi;
            if(lci < data.size() && data.get(lci) < data.get(mini)){
                mini = lci;
            }
            if(rci < data.size() && data.get(rci) < data.get(mini)){
                mini = rci;
            }

            if(mini != pi){
                swap(mini,pi);
                downHeapify(mini);
            }
        }
        // remove
        public int remove(){
            if(data.size() == 0){
                System.out.println("There is no element");
                return -1;
            }

            swap(0,data.size()-1);
            int rv = data.remove(data.size()-1);
            downHeapify(0);
            return rv;
        }

        // peek
        public int peek(){
            if(data.size() == 0){
                System.out.println("There is no element");
                return -1;
            }
            return data.get(0);
        }

        // size
        public int size(){
            return data.size();
        }

    }
    public static void main(String[] args) {
        Heap minPQ = new Heap();
        minPQ.add(10);
        minPQ.add(3);
        minPQ.add(23);
        minPQ.add(2);
        minPQ.add(1);
        System.out.println(minPQ.peek());
    }


    // to run -> javac fileName.java && java fileName
}

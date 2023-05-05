import java.util.Collections;
import java.util.PriorityQueue;

public class PQimplement {

    static class Student implements Comparable<Student> {
        int roll;
        String name;

        public Student(int roll, String name){
            this.roll = roll;
            this.name = name;
        }

        public int compareTo(Student o){
            return this.roll - o.roll; // min pq
            // return o.roll - this.roll // max pq
        }
        public String toString(){
                return this.name + this.roll;
        }

    }
    public static void main(String[] args) {
        
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        minpq.add(1);
        minpq.add(5);
        minpq.add(8);

        System.out.println(minpq.peek());

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        maxpq.add(1);
        maxpq.add(5);
        maxpq.add(8);
        System.out.println(maxpq.peek());


        PriorityQueue<Student> pq = new PriorityQueue<>();
        Student s1 = new Student(3,"Yaseen");
        Student s2 = new Student(2,"mohammad");
        Student s3 = new Student(1,"abc");

        pq.add(s3);
        pq.add(s2);
        System.out.println(pq.peek().roll);
        System.out.println(s1);
    }
}

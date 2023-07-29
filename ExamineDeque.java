import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
public class ExamineDeque {
    LinkedBlockingDeque<Integer> cDeque1, cDeque2;
    Deque<Integer> deque1, deque2;
    // Initialisation of deque
    ExamineDeque(){
        this.deque1 = new ArrayDeque<>();
        this.deque2 = new ArrayDeque<>();
        this.cDeque1 = new LinkedBlockingDeque<>(10); 
        this.cDeque2 = new LinkedBlockingDeque<>(10); 
    }
    // This method uses addFirst() and offerFirst() to insert elements in deque
    void flexibleCapacityDequeInsertion(){ 
        System.out.println("Started the method where addFirst() and offerFirst() are used in flexible capacity Deque\n\n1. addFirst(e) method inserts element - e in Deque and returns void");
        // Inserting elements at first using addFirst()
        for(int i = 0; i < 20; i++ ){
            deque1.addFirst(i);
            System.out.println("Inserted "+i);
        }
        System.out.println("\n2. offerFirst(e) method inserts element - e and returns true else returns false");
        // Inserting elements at first using offerFirst()                
        for(int i = 0; i < 20; i++ )       
            System.out.println(i+" - "+deque2.offerFirst(i));   
        System.out.println("\nInsertion doesn't fail in flexible capacity Deques\nEnd\n");                                   
    }
    // This method uses addFirst and offerFirst to insert elements into deque
    void fixedCapacityDequeInsertion(){       
        System.out.println("Started method to compare addFirst() and offerFirst() methods in fixed capacity Deques\n\n1. offerFirst(e) method inserts element - e and returns true if insertion has failed it returns false");
        for(int i = 0; i < 20; i++ ){        
            System.out.println(i+" - "+cDeque1.offerFirst(i));                                    
        }
        System.out.println("\n2. addFirst(e) method inserts element - e in Deque and returns void else throws an exception if insertion has failed");
        try{
            for(int i = 0; i < 20; i++ ){
                cDeque2.addFirst(i);                                                    
                System.out.println("Inserted "+i);
            }
        }
        catch(IllegalStateException ill){
            System.err.println("\nEXCEPTION occurred as capacity of the queue is already full.");
        }            
    }    
    // Main method
    public static void main(String[] args) {        
        ExamineDeque e = new ExamineDeque();
        System.out.println("\nDifference between addFirst and offerFirst: \n");
        System.out.println("Flexible Size Deque is used:\n");
        e.flexibleCapacityDequeInsertion();
        System.out.println("Fixed Size Deque is used (capacity = 10):\n");
        e.fixedCapacityDequeInsertion();
    }
}
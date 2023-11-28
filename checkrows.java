 

import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


 
public class checkrows extends CasseTete implements Runnable {
    

 

       private int n;
         private int[][] Narray;
 
    public checkrows(     int n , int[][] Narray ){

        this.n = n;
              this.Narray= Narray  ;
     }
  
    
      public  void run() {
    String name="row thread" ; 
      
          try {  

           semaphore.acquire() ; 

        Thread  rowthread = Thread.currentThread();
        
 
          
   if(!feasible)
       return ;
   
        File filey = new File("out.txt"); // file to write in 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filey, true))) {
        
        
      //      writer.write(name); // write name of thread
 
           // if feasible is true check
     
            if(feasible !=true)
            return ; 
                                    for (int i = 0; i < n ; i++) {
                         
                                             writer.write(  "checking Row Thread# "  +    Integer.toString(i+1)  + "\n");

                                                           int  count = 0; 
                        for (int j = 0; j < n; j++) {
                   //      writer.write(  "checking token # "  +    Integer.toString(j+1)    +  " in Row Thread# " + (i+1)+ "\n");

                                            if (Narray[i][ j ] == 1)
                                                                    count++; //count ones
}
                           // if its odd false 
                                      if(count%2 == 1){
                                                     super.changefeasible(false) ;
                                                      
                                     writer.write(  "Row "  +    Integer.toString(i+1) +" is not feasible "   + "\n");
                                 
                                                         System.out.println("RowThread : its not feasible in this row " + (i+1) ); 
                                                      break ; 
                                   
                                                   
                          
                        } // inner loop
                }// outer loop , here we restart the count 
                   
           
             writer.close();
       } catch (IOException e) {
            System.out.println(e.getMessage());
        }
     
             

          }catch (InterruptedException e) {
            
       System.out.println(" "); 
        }finally {

           semaphore.release() ; 

    System.out.println("check rows method completed");    }

   
        
        
        
 }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

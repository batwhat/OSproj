 
import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class checkcols extends CasseTete implements Runnable {

  private int n;
   private int[][] Narray;


 

public checkcols(    int n , int[][] Narray ){

  
        this.n = n;
              this.Narray= Narray  ;
  
               
     }
    
    
  
    public void run() {
    
 
        
        
     String name="column thread" ; 
         
          try {
           
                      
           semaphore.acquire() ; 

        Thread colthread = Thread.currentThread();
          
             if(!feasible)
               return ; 
        
                 
        File filey = new File("out.txt"); // file to write in 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filey, true))) {
        
        
   //         writer.write(name); // write name of thread

       
          // if feasible is true check
            
                                    for (int i = 0; i < n ; i++) {
                 
 
                                     
                                                                  int   count = 0; 
     writer.write(  "checking Column Thread# "  +    Integer.toString(i+1)  + "\n");
                        for (int j = 0; j < n; j++) {
                     //       writer.write(  "checking token # "  +    Integer.toString(j+1) + " in Column Thread # " + (i+1) +  "\n");
                                        if (Narray[ j ][ i ] == 1)
                                                                    count++; //count ones
}
                                    
 
                                       if(count%2 == 1){//here we find its not feasible 
                                                      super.changefeasible(false) ;
                                                                                       writer.write(  "columns "  +    Integer.toString(i+1)               +" is not feasible "   +  "\n");
                       
                                                      System.out.println("ColumnThread : its not feasible in this column " + (i+1));
                                                      break; 
                     
                                                   
                                                   
                              
                        } // inner loop
             
               }// outer loop , here we restart the count 
                   
                
         
             writer.close();
             
       } catch (IOException e) {
            System.out.println(e.getMessage());
        }        
                
           
      }catch(InterruptedException e) {
            
       System.out.println(" "); 
        }finally {
      
      
           semaphore.release() ; 

                       System.out.println("check cols method completed");    }

   
        
        
        
 }
      
 
 

}


 
    
    


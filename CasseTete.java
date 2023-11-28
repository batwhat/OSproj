 
import java.util.concurrent.Semaphore;
import java.util.* ;

 
public class CasseTete extends Thread {

   
    static  boolean feasible = true   ;  //* * our shared variable  * *

   static Semaphore semaphore = new Semaphore(1); // our threads
     
    public static void changefeasible(boolean feas){//this method will be used by other threads to change the feasible flag 

                       feasible = feas; 
}

    
    
    
    // Function to wait for both threads to complete
    private static void waitForThreads(Thread thread1, Thread thread2) {
        try {
            // Wait for both threads to complete
            thread1.join();
        thread2.join();
        } catch (InterruptedException e) {
            
       System.out.println(" 3"
               + ""); 
        }
      
        
        
        
    }

    public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
                     int n =0;    boolean validInputN = false;
        boolean validInputM = false;
        
           int m =0; 
   while(!validInputN || !validInputM){
   try{ 
     if (!validInputN) {
                    System.out.println("Enter the value of n (3 <= n <= 6): ");
                    n = input.nextInt();

        if (n >= 3 && n <= 6) {
                        validInputN = true;
 } else {
                        System.out.println("Invalid value for n. Re-enter.");
                    }
      }

                if (!validInputM && validInputN) {
                    System.out.println("Enter the value of m (m < n^2): ");
 m = input.nextInt();

                    if ((n * n) > m) {
                        validInputM = true;
                    } else {
                        System.out.println("Invalid value for m. Re-enter.");
                    }
                } 
  }catch(InputMismatchException e){
    System.out.println("Enter A number ");
             input.nextLine();
      }
     
     }//while
     
     
     
     int[][] Narray = new int[n][n] ; 
     
    for(int j = 0 ; j < n ; j++){
    
for(int i = 0 ; i < n ; i++)
Narray[j][i]=1;             }      

System.out.println("______BEFORE______ ");

     for(int j = 0 ; j < n ; j++){
    
for(int i = 0 ; i < n ; i++)
   System.out.print(Narray[j][i]+ "  " );    
    System.out.println();       }     //PRINTING  

    
                 System.out.println();   



       

        int k=0 , h=0;
        for(int i=0;i<=m ;i++){
           k=(int)(Math.random() *n);
         h=(int)(Math.random() * n);
   if( Narray[k][h]==1) 
        Narray[k][h]=0;
        
        }//making random slots zeroes 
      
 


 

   
 System.out.println("_______ AFTER_______ ");
    
         for(int j = 0 ; j < n ; j++){
    
for(int i = 0 ; i < n ; i++)
   System.out.print(Narray[j][i]+ "  " );    
    System.out.println();       }     //PRINTING  

    
    
    
             checkcols columnss = new checkcols( n,Narray);
             
             
             
      checkrows rowss = new checkrows(n,Narray);
    
     // Create two threads for checking columns and rows 
        Thread thread1 = new Thread(columnss);
        
        
       // threadingcols(thread1);
                  thread1.start();
        Thread thread2 = new Thread(rowss);

 //  threadingrows(thread2); 
          thread2.start();
        waitForThreads( thread1,  thread2) ;

        
        if(feasible == true)
System.out.println("Feasible "); 
else
System.out.println("Not Feasible "); 

  
    }
    
}

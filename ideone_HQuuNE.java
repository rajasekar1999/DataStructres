import java.util.Scanner;
 class MergeSort {
    
     public void MSort(int[] b) {
        int p,q;
        int m;
         m=b.length/2;
        int s[]=new int[m];
        int j[]=new int[b.length-m];
        if(b.length>1){
            
                
                 for(p=0;p<m;p++)
                 {
                    s[p]=b[p]; 
                 }
                 for(q=m;q<b.length;q++)
                 {
                     j[q-m]=b[q];
                 }
            MSort(s);
            MSort(j);
        
        Merge(b,s,j);
    }}
           
         public void Merge(int[] b,int[] s,int[] j)
        {
           
          int i=0,p=0,k=0;
          if(b.length>1){
           while( i<s.length && p<j.length)
           {
               if (s[i] <= j[p])
               {
                   b[k] = s[i];
                   i++;
               }
               else
               {
                   b[k] = j[p];
                   p++;
               }
               k++;
           }
           while (i < s.length)
           {
               b[k] = s[i];
               i++;
               k++;
           }
    
           /* Copy remaining elements of R[] if any */
           while (p < j.length)
           {
               b[k] = j[p];
               p++;
               k++;
           }
           }
         }
            
        public void printArray(int[] l)
            
        {
                 
        for (int j=0;j<l.length;j++) 
        {
                       
         System.out.print(l[j]+" ");
                   
         }
                
         System.out.println("");
            
        }
         
         public static void main(String args[]) throws Exception
          
        {
            
        Scanner sc = new Scanner(System.in);        
            
        MergeSort MS = new MergeSort();
                 
        int testcases = sc.nextInt();
               
         for (int j=0;j<testcases;j++){
                      
        int n = sc.nextInt();
                      
        int b[] = new int[n];
                      
        for (int i=0;i<n;i++){
                        
         int intelement=sc.nextInt();
                        
         b[i] =intelement;
                      
        }
                      
        MS.MSort(b);
                      
        
                      
        MS.printArray(b);
                  
        }    
         
         }
    
}
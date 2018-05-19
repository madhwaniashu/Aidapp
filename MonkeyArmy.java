import java.io.*;
import java.util.Scanner;
public class MonkeyArmy
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
  
    public final int health = 2000;
    public int monkeysWon;
    MonkeyArmy(){
         this.monkeysWon = 0;
    }
    
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
    //counting number of monkeys which can be defeated with health 2000
    int damageSum(int arr[], int index){
        int sum = 0, i;
        for(i=0; i<index; i++){
            sum = arr[i] + sum;
            if(sum >= health)//able to defeat monkey within health 2000
               return 0;
        }
        return i-1;
    }
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            this.monkeysWon = this.damageSum(arr, low);//count of monkeys won
            if(this.monkeysWon != 0)//able to defeat monkey within health 2000
               return;
            if(pi == 0)
              sort(arr, pi+1, high);
        }
    }
     
   // Driver program
    public static void main(String args[]) throws Exception
    {
    /*     File file = new File("C:\Users\aashu\Documents\Madhwani Documents\SoftwareEngineer-Summer-2018-master\SoftwareEngineer-Summer-2018-master\input.txt");
         BufferedReader br = new BufferedReader(new FileReader(file));
 
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
        }
      */  
        Scanner scanner = new Scanner(new File("C:\\Users\\aashu\\Documents\\Madhwani Documents\\SoftwareEngineer-Summer-2018-master\\SoftwareEngineer-Summer-2018-master\\input.txt"));
        int arr [] = new int [100];
        int i = 0;
        while(scanner.hasNextInt()){
            if(i == 0)
               arr = new int[scanner.nextInt()];
            else
               arr[i++] = scanner.nextInt();
        }
        
        //int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
 
        MonkeyArmy ob = new MonkeyArmy();
        ob.sort(arr, 0, n-1);
        if(ob.monkeysWon != 0)
        System.out.println("Maximum Number of monkeys won ");
        System.out.println(ob.monkeysWon);
    }
   
}

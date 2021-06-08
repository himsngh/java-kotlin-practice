import java.util.Arrays;
import java.util.Scanner;

public class Arraychallengef {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String [] args){
//        int []array=getIntegrs(5);
//        //printArray(array);
//        //10sortArray(array);
//        printArray(array);
//        System.out.println(minElemetn(array));

//        int []a=getIntegrs(6);
//        reverseArray(a);
//        printArray(a);

        int [] ar=new int[] {1,4,7,8,0,109,34};
        System.out.println("Array : "+ Arrays.toString(ar)); //one more way to print arrays
        reverseArray(ar);
        System.out.println("Reversed Array : "+Arrays.toString(ar));

    }
    public static void reverseArray(int [] a){
        int k=a.length-1;
        for(int i=0;i<a.length/2;i++){
            int prev=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=prev;
        }
    }
    public static int minElemetn(int [] a){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
    public static void sortArray(int [] n){
        for(int i=0;i<n.length;i++) {
            int previous = n[i];
            for (int j = i + 1; j <n.length; j++) {
                if (n[i] < n[j]) {
                    previous = n[i];
                    n[i] = n[j];
                    n[j] = previous;
                }
            }
        }
    }
    public static void printArray(int[] n){
        for(int i=0;i<n.length;i++){
            System.out.println(n[i]);
        }

    }
    public static int [] getIntegrs(int n){
        System.out.println("Enter "+n+" numbers for the array to sort .\r");
        int[] name=new int[n];
        for(int i=0;i<n;i++){
            name[i]=sc.nextInt();
        }
        return name;
    }

}

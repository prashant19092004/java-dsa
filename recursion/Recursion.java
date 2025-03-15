import java.util.*;

public class Recursion {

    public static void decreasingPrint(int n){

        if(n == 0){
            return;
        }

        decreasingPrint(n-1);
        System.out.print(n + " ");
        
    }

    public static void increasingPrint(int n){

        if(n == 0){
            return;
        }

        System.out.print(n + " ");
        increasingPrint(n-1);
    }

    public static int factorial(int n) {
        if(n==1){
            return 1;
        }

        return (n*factorial(n-1));
    }

    public static int naturalSum(int n){
        if(n==1){
            return 1;
        }

        return (n+naturalSum(n-1));
    }

    public static int fibbonacci(int n){

        if(n==0 || n==1){
            return n;
        }

        int fun1 = fibbonacci(n-1);
        int fun2 = fibbonacci(n-2);
        int fn = fun1 + fun2;

        return fn;
    }

    public static boolean checkShorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        
        if(arr[i]>arr[i+1]){
            return false;
        }

        return checkShorted(arr, i+1);
    }

    public static int firstOccurance(int arr[], int i, int n){
        if(i == arr.length-1){
            return -1;
        }

        if(arr[i] == n){
            return i;
        }

        return firstOccurance(arr, i+1, n);
    }

    public static int lastOccurance(int arr[], int i, int n){
        if(i == arr.length){
            return -1;
        }

       int isFound = lastOccurance(arr, i+1, n);
       if(isFound != -1){
        return isFound;
       }

       if(arr[i] == n){
        return i;
       }

       return isFound;
    }

    public static int power(int a, int n){
        if(n==1){
            return a;
        }
        return (a*power(a, (n-1)));
    }

    public static int powerFast(int a, int n){

        if(n==0){
            return 1;
        }

        int halfPower = powerFast(a, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return a * halfPower * halfPower;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 

        int a = sc.nextInt();
        int n = sc.nextInt();
        // int arr[] = {1,2,3,4,5,6,2,4,9,5,3,6};
        System.out.print(powerFast(a, n));
        // fibbonacci(n);
    }


    
}

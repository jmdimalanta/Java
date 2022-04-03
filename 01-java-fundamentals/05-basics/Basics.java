import java.util.ArrayList;
import java.util.Arrays;
/**
 * Basics
 */
public class Basics {
// Print One to 255.
    public static void oneTo255(){
        for (int i =1; i<=255; i++){
            System.out.println(i);
        }
    }
// Print odd numbers between 1 to 255.
    public static void Oddnumbers(){
        for(int i = 1; i <= 255; i++){
            if(i % 2 !=0)
            System.out.println(i);
        }
    }
// Sigma of 255  AKA Sum to 255.
    public static int SumTo255(int n){
        int s = 0;
        for(int i = 1; i<=n; i++){
            s += 1;
        }
        return s;
    }
// Iterating through an array.
    public static void printArray(){
        int array[] = {1,2,3,4,5,6};
        int i, numbers;
        for(i = 0; i<array.length; i++){
            numbers = array[i];
            System.out.println(numbers);
        }
    }
//Find Max.
    public static int maxValue (int[] nums){
        int maxNumber = nums[0];
        for(int i = 0; i <=nums.length; i++){
            try{
                if (nums[i] > maxNumber){
                    maxNumber = nums[i];
                }
            } catch (Exception a){
                System.out.println(a);
            }
        }
        return maxNumber;
    }
//Array with Odd Numbers
    public static void OddNumbersArray(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++){
            if (i % 2 !=0)
            array.add(i);
        }
        System.out.println(array);
    }
}
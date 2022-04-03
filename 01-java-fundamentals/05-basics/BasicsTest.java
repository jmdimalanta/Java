public class BasicsTest {
    public static void main(String[] args){
        Basics b = new Basics();
        b.oneTo255();
        b.Oddnumbers();
        // sum to 255
        int n = 255;
        System.out.println(b.SumTo255(n));
        //Iterate through an array.
        b.printArray();
        //Find Max.
        int[] nums = {-5, -6, -1};
        System.out.println(b.maxValue(nums));
        //Array with Odd Numbers.
        b.OddNumbersArray();
    }
}

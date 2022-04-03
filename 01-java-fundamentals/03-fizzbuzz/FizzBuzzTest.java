public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        // System.out.println(fb.fizzBuzz(9));
        // System.out.println(fb.fizzBuzz(25));
        // System.out.println(fb.fizzBuzz(15));
        // System.out.println(fb.fizzBuzz(2));

        for (int i=0; i <= 30; i++){
            System.out.println(fb.fizzBuzz(i));
        }
    }
}

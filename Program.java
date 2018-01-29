import java.util.Scanner;

 class HelloWorld {

    public static void main(String[] args) {
			// int i;
        // Creates a reader instance which takes
        // input from standard input - keyboard
        
        // System.out.print("Enter a number: "+ &i);

        // nextInt() reads the next integer from the keyboard
        // int number = reader.nextInt();

        // println() prints the following line to the output screen
        // System.out.println("You entered: " + i);
		 int n, c;
      System.out.print("Enter an integer : ");
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      System.out.println("Entered value is :-"+n);
    }
}
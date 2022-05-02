import java.util.*;
import java.util.InputMismatchException;
class GetInput{  
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m"; 
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args)  {
        try (Scanner sc = new Scanner(System.in) //System.in is a standard input stream
        ) {
            System.out.print("Enter string value: ");
            String stringValue = sc.nextLine();
            while (true) {
                System.out.print("Enter an integer: ");
                try {
                    int indexValue = sc.nextInt();
                    
                    sc.nextLine();
                    System.out.print("Enter character value: ");
                    String characterValue = sc.nextLine();  
                    stringValue = stringValue.substring(0, indexValue) + characterValue + stringValue.substring(indexValue + 1);
                    System.out.print(ANSI_GREEN+"Your new string value is " + stringValue + ANSI_RESET);
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println(ANSI_RED +"Invalid input type (must be an integer)!" +ANSI_RESET);
                    sc.nextLine();
                }
            }
        }
    }  
}  
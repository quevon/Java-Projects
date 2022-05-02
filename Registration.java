import java.util.*;
import java.util.regex.*; 
class Registration{  
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m"; 
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args)  {
        String emailAddress;       

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your firstname: ");
            String firstName = sc.nextLine();
            System.out.print("Enter your lastname: ");
            String lastName = sc.nextLine();
            while (true){
                String emailRegex = "^(.+)@(.+)$"; 
                Pattern patternEmail = Pattern.compile(emailRegex);
                System.out.print("Enter your email address: ");
                emailAddress = sc.nextLine();
                Matcher matcherEmail = patternEmail.matcher(emailAddress); 
                if (matcherEmail.matches() == false){
                    System.out.print(ANSI_RED + "Invalid email address, must have @ sign.\n" +ANSI_RESET);
                }else{
                   
                    break;
                }
            }
            while(true){
                
                Pattern patternPassword = Pattern.compile("[^A-Za-z0-9]+");
                Pattern numbersPassword = Pattern.compile("[^0-9]+");
                Pattern lettersPassword = Pattern.compile("[^A-Za-z]+");

                System.out.print("Enter your password: ");
                String password = sc.nextLine();
                
                Matcher matcherPassword = patternPassword.matcher(password); 
                Matcher matcherNumberPassword = numbersPassword.matcher(password); 
                Matcher matcherLetterPassword = lettersPassword.matcher(password); 

                if (password.length() < 8){
                    System.out.print(ANSI_RED + "Password too short (must be 8 or more characters)\n" +ANSI_RESET);
                }else if(matcherPassword.matches() == true){
                    System.out.print(ANSI_RED + "Password must have letters and numbers\n" +ANSI_RESET);
                }else if(matcherLetterPassword.matches() == true){
                    System.out.print(ANSI_RED + "Password must have letters\n" +ANSI_RESET);
                }else if(matcherNumberPassword.matches() == true){
                    System.out.print(ANSI_RED + "Password must have numbers\n" +ANSI_RESET);
                }else{
                    System.out.print("Confirm your password: ");
                    String confirmPassword = sc.nextLine();
                    StringBuffer sbPassword = new StringBuffer(confirmPassword);
                    String confirmation = sbPassword.toString();
                    
                    if (password.equals(confirmation) == false){
                        System.out.print(ANSI_RED + "Password does not match\n" +ANSI_RESET);
                    }else{
    
                        System.out.println(ANSI_GREEN +"\n-----Registered Successfully-----\n" + ANSI_RESET);
    
                        System.out.println("Firstname: " + ANSI_GREEN + firstName + ANSI_RESET);
                        System.out.println("Lastname: " + ANSI_GREEN + lastName + ANSI_RESET);
                        System.out.println("Email Address: " + ANSI_GREEN + emailAddress + ANSI_RESET);
                        System.out.println("Password: " + ANSI_GREEN + password + ANSI_RESET);
                        break;
                    }
                }
            }
        }

    }
}
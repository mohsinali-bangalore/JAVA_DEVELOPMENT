import java.util.*;
import java.util.regex.*;

class InvalidNameException extends Exception {
    public InvalidNameException() {}
    public InvalidNameException(String msg) {
        super(msg);
    }
}

class HelloWorld {
    
    public static void checkName(String name) throws InvalidNameException {
        Pattern p1 = Pattern.compile("[0-9]");
        Matcher m1 = p1.matcher(name);
        boolean isNum = m1.find();
        Pattern p2 = Pattern.compile("[^A-Za-z]");
        Matcher m2 = p2.matcher(name);
        boolean isSpecial = m2.find();
        
        if(isNum) {
            throw new InvalidNameException("Name contains numbers!");
        } else if(isSpecial) {
            throw new InvalidNameException("Name contains special characters!");
        } else {
            System.out.println("Name Accepted!");
        }
    }
    
    public static String decodeName(String fname, String lname) {
        String ans = "";
        ans += Character.toString(fname.charAt(0)).toLowerCase();
        for(int i=0;i<lname.length();i++) {
            ans += lname.charAt(i);
        }
        return ans;
    }
    
    public static String changeCase(String str) {
        String ans = "";
        for(int i=0;i<str.length();i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                ans += Character.toString(str.charAt(i)).toUpperCase();
            } else {
                ans += Character.toString(str.charAt(i)).toLowerCase();
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to Start\nEnter 0 to Exit!");
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice) {
            case 1:
                System.out.print("Number of IDs to be generated: ");
                int loop = Integer.parseInt(sc.nextLine());
                while(loop-->0) {
                    try {
                        System.out.print("Enter your first name: ");
                        String fName = sc.nextLine();
                        System.out.print("Enter your last name: ");
                        String lName = sc.nextLine();
                        checkName(lName);
                        System.out.print("Enter your pin: ");
                        int pin = Integer.parseInt(sc.nextLine());
                        String ans = null;
                        if(fName.length() < lName.length()) {
                            ans = decodeName(fName,lName);
                        } else if(fName.length() > lName.length()) {
                            ans = decodeName(lName,fName);
                        } else {
                            if(fName.compareTo(lName) > 0) {
                                ans = decodeName(lName,fName);
                            } else if(fName.compareTo(lName) < 0) {
                            ans = decodeName(fName,lName);
                            } else {
                            ans = decodeName(fName,lName);
                            }
                        }
                        System.out.print("Your generated Id is: "+changeCase(ans)+Integer.toString(pin));
                    } catch(InvalidNameException e) {
                        System.out.println(e.getMessage());
                    }
                }
            break;
            case 0:
                break;
            default: System.out.println("Invalid Input");
        }
    }
}

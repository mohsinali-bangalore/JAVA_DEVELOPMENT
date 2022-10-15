import java.util.*;

public class Main {
    
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
        System.out.print("Enter your first name: ");
        String fName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lName = sc.nextLine();
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
    }
}
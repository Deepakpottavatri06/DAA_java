
import java.util.*;
public class PalindromeString {
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(findPS(inp,0,inp.length()-1));
        cin.close();
    }
    private static boolean findPS(String str , int i ,int j){
        if(i>j){
            return true;
        }
        if(str.charAt(i)!=str.charAt(j)){
            return false;
        }
        return findPS(str, i+1, j-1);

    }
}

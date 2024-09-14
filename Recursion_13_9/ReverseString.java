import java.util.*;

public class ReverseString {
    public static void main(String [] args){
        Scanner cin  = new Scanner(System.in);
        String inp = cin.nextLine();
        String rev = "";
        rev = reverse(inp,0);
        System.out.println(rev);
    }
    
    private static String reverse(String inp,int index){
        if(index == inp.length()){
            return "";
        }
        String rev;
        rev = reverse(inp,index+1);
        rev += inp.substring(index,index+1);
        return rev;
    } 
}
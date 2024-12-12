/*[a,b]c[d,e]f */

import java.util.*;
public class BraceExpansion {

    public static String[] braceExp(String inp){

        if(inp.length()==0){
             return new String[]{""};
        }

        if(inp.length()==1){
            return new String[]{inp.charAt(0)+""};
        }

        TreeSet <String> set = new TreeSet<>();
        if(inp.charAt(0)=='['){
            int i = 0;
            while (inp.charAt(i)!=']') {
                i++;
            }
            String braceInside [] = inp.substring(1, i).split(",");
            String subString [] = braceExp(inp.substring(i+1));
            for (int j = 0; j < braceInside.length; j++) {
                for (String string : subString) {
                    set.add(braceInside[j]+string);
                }
            }

        }
        else{
            String firsString = inp.substring(0, 1);
            String subString [] = braceExp(inp.substring(1));
            for (String string : subString) {
                set.add(firsString+string);
            }

        }
        return set.toArray(new String[]{});
    }
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        String t [] = braceExp(input);
        System.out.println(Arrays.toString(t));
        cin.close();
    }
}

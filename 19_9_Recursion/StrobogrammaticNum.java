import java.util.*;
/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6
 */
public class StrobogrammaticNum {
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        String n = cin.nextLine();
        int i = 0,j=n.length()-1;

        Map<Character,Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        map.put('9', '6');
        //boolean flag = true;
        // while (i<=j) {
        //     if((n.charAt(i)=='6' && n.charAt(j)=='9')||(n.charAt(i)=='9' && n.charAt(j)=='6')){
        //         i++;
        //         j--;
        //     }
        //     else if(n.charAt(i)=='1' && n.charAt(j)=='1'){
        //         i++;
        //         j--;
        //     }
        //     else if(n.charAt(i)=='0' && n.charAt(j)=='0'){
        //         i++;
        //         j--;
        //     }
        //     else if(n.charAt(i)=='8' && n.charAt(j)=='8'){
        //         i++;
        //         j--;
        //     }
        //     else{
        //         flag = false;
        //         break;
        //     }

        // }
        
        System.out.println(findStrobo(n,i,j,map));
        cin.close();
    }   
    private static boolean findStrobo(String n,int i, int j,Map<Character,Character> map){
        if(i>j){
            return true;
        }
        if(map.containsKey(n.charAt(i))){
           if(map.get(n.charAt(i))!=n.charAt(j)){
            return false;
           }
           return findStrobo(n, i+1, j-1, map);
        }
        return false;
    }
}

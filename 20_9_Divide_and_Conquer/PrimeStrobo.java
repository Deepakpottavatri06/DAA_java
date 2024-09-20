
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
public class PrimeStrobo {
    private static boolean prime(int num){
        if(num < 2){
            return false;
        }
        double n = (double)num;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
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
        boolean strob = findStrobo(n,i,j,map);
        boolean primeStrobo = false;
        if(strob){
            primeStrobo= prime(Integer.parseInt(n));
        }
        System.out.print(strob+" "+primeStrobo);

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

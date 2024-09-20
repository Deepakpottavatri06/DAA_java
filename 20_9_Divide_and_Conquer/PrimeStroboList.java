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
public class PrimeStroboList {
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
        
        Map<String,String> map = new HashMap<>();
        map.put("6", "9");
        map.put("9", "6");
        map.put("1", "1");
        map.put("8", "8");

        Scanner cin =  new Scanner(System.in);
        int n = cin.nextInt();
        List<String> l = helper(n,n,map);
        Collections.sort(l);
        List<String> primeStrobo =  new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if(prime(Integer.parseInt(l.get(i)))){
                primeStrobo.add(l.get(i));
            }
        }
        System.out.println(primeStrobo);
        System.out.println(l.get(0)+" "+l.get(l.size()-1));
        cin.close();
    }

    private static List<String> helper(int n , int size , Map<String,String> map){
        if(n==0) return new ArrayList<>(Arrays.asList(""));
        if(n==1) return new ArrayList<>(Arrays.asList("1","0","8"));
        
        List<String> prev = helper(n-2, size, map);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < prev.size(); i++) {
            String str = prev.get(i);
            if(n!=size){
                res.add("0"+str+"0");
            }
            for (Map.Entry<String,String> entry : map.entrySet()) {
                res.add(entry.getKey()+str+entry.getValue());
            }
        }
        return res;
    }
    

}

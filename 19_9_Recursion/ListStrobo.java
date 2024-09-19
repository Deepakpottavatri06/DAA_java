
import java.util.*;
public class ListStrobo {
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
        System.out.println(l);
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

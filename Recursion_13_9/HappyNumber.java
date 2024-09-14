import java.util.Scanner;

public class HappyNumber {
    public static void main(String [] args){
        Scanner cin  = new Scanner(System.in);
        int inp = cin.nextInt();
        System.out.println(findHappyNum(inp));
    }
    private static boolean findHappyNum(int inp){
        if(inp<10){
            if(inp == 1 || inp==7){
                return true;
            }
            return false;
        }
        return findHappyNum(sumOfSq(inp));
        
    }
    private static int sumOfSq(int n){
        int sum = 0 , x;
        while(n>0){
            x = n%10;
            sum+= x*x;
            n = n/10;
        }
        return sum;
    }
}

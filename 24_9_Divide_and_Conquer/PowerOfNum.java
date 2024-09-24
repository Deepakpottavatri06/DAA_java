public class PowerOfNum {
    private static float power(float x , int y){
        if(y==0) return 1f;
        float temp = power(x, y/2);
        float result = 0;
        if(y%2==0){
            result = temp*temp;
        }
        else{
            if(y>0){
                result = x*temp*temp;;
            }
            else{
                result = temp*temp/x;
            }
        }

        // System.out.println(temp + " " + result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(power(2f,3));
    }   
}

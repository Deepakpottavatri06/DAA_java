
public class PerfectSquare {

    private static boolean binarySearch(long low , long high){
        long required = high;
        while (low<high) {
            long mid = (low+high)/2;
            long square = (mid*mid);
            System.out.println(low + " "+ mid + " "+high);
            if(square==required){
                return true;
            }
            if(square>required){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (low*low == required)? true : false;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(1, 25));
    }
}

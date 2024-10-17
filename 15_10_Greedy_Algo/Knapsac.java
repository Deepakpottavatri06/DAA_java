import java.util.*;

class ItemValue{
    int value,weight;
    ItemValue(int val,int wgh){
        this.value = val;
        this.weight = wgh;
    }
    @Override
    public String toString() {
        return value+" "+weight;
    }
}
public class Knapsac {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int x = cin.nextInt();
        ItemValue arr[] = new ItemValue[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ItemValue(cin.nextInt(), cin.nextInt());
        }

        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                double first = (double)o1.value/(double)o1.weight;
                double second = (double)o2.value/(double)o2.weight;
                if(first>second){
                    return-1;
                }
                return 1;
            }
        });
        float total = 0;
        for (ItemValue itemValue : arr) {
            if(itemValue.weight<=x){
                total+=itemValue.value;
                x-=itemValue.weight;
            }   
            else{
                total+= ((float)x/(float)itemValue.weight)*itemValue.value;
                break;
            }
        }
        System.out.printf("%.2f",total);
        cin.close();
    }
}
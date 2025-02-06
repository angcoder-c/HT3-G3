import java.util.ArrayList;

public class Insertionsort {

    public static ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        insertionSort(list);
        return list;
    }

    private static void insertionSort(ArrayList<Number> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Number key = list.get(i);   
            int j = i - 1;

            
            while (j >= 0 && list.get(j).doubleValue() > key.doubleValue()) {
                list.set(j + 1, list.get(j)); 
                j--;
            }
            list.set(j + 1, key);
        }
    }
}

package ds.arrays;
import java.util.*;

public class ArrayGreaterElementsOnRight {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int[] array = new int[]{12,3,44,2,5,-10,34,22,9,10,19 };
		int partition = 10;  // Move all greater elements on right, greater than 10
		int lastPos = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if(array[i] > partition){
				list.add(array[i]);
			}else{
				list2.add(array[i]);
			}
		}
		list.addAll(list2);
		System.out.println(list);
	}
	
	// Without spaces
    static int[] shiftGreaterOnRight(int a[], int item)
    {
        int lastIndex = a.length ;
        for(int i = 0; i< a.length || i >= lastIndex-1 ; i++){
            if( i >= lastIndex-1)
                break;
        	if(a[i] > item){
        		for (int j = lastIndex -1; j>=0; j--){
        			if(a[j] <= item){
        				int temp = a[j];
        				a[j] = a[i];
        				a[i] = temp;
        				lastIndex = j;	
        System.out.println("state Array is " + Arrays.toString(a));
        				
        				break;
        			}
        		}
        	}
        }
        return a;
    }	
}

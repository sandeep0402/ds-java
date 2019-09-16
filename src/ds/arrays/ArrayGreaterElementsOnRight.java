package ds.arrays;
import java.util.*;

public class ArrayGreaterElementsOnRight {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int[] array = new int[]{12,3,44,2,5,-10,34,22,9,10,19 };
		int partition = 10;  // Move all greater elements on right, greater than 10
		System.out.println("input: "+ Arrays.toString(array));
//		int lastPos = array.length - 1;
//		for (int i = 0; i < array.length; i++) {
//			if(array[i] > partition){
//				list.add(array[i]);
//			}else{
//				list2.add(array[i]);
//			}
//		}
//		list.addAll(list2);
//		System.out.println(list);
		System.out.println(Arrays.toString(shiftGreaterOnRight(array, partition)));
	}
	
	// Without spaces
    static int[] shiftGreaterOnRight(int a[], int item)
    {
        int lastIndex = a.length ;
        for(int i = 0; i< a.length || i >= lastIndex-1 ; i++){
			System.out.println("i checking for  " + a[i]);

			if( i >= lastIndex-1)
                break;
        	if(a[i] > item ){
				System.out.println("i Need to replace " + a[i]);
				for (int j = lastIndex -1; j>=i; j--){
        			if(a[j] <= item){
        				int temp = a[j];
        				a[j] = a[i];
        				a[i] = temp;
        				lastIndex = j;
						System.out.println("j Replace " +a[i] +" with " + a[j] +" | lastIndex:" +lastIndex);
						System.out.println("j state Array is " + Arrays.toString(a));
        				break;
        			}
        		}
        	}else{
				System.out.println("i Ignore for "+ a[i]);
			}
        }
        return a;
    }	
}

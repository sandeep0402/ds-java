package ds.sorting;
import java.util.*;
 
/*
 * http://howtodoinjava.com/algorithm/merge-sort-java-example/
 */
public class MergerSort 
{
    public static void main(String[] args) 
    {
        //Unsorted array
        //Integer[] a = { 2, 6, 3, 5, 1 };
        String[] a = {"va","vb","bg","aa","cg"};
        
        //Call merge sort
        mergeSort(a);
         
        //Check the output which is sorted array
        System.out.println(Arrays.toString(a));
    }
 
    @SuppressWarnings("rawtypes") 
    public static Comparable[] mergeSort(Comparable[] array) 
    {
        //If list is empty; no need to do anything
        if (array.length <= 1) {
            return array;
        }
        int center = array.length / 2; 
      
        //Split the array in half in two parts
//        Comparable[] first = new Comparable[array.length / 2];
//        Comparable[] second = new Comparable[array.length - (array.length / 2)];
//        
//        System.arraycopy(array, 0, first, 0, first.length);
//        System.arraycopy(array, first.length, second, 0, second.length);        
        Comparable[] first = Arrays.copyOfRange(array, 0, center);
        Comparable[] second = Arrays.copyOfRange(array, center, array.length);

        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);
         
        //Merge both halves together, overwriting to original array
        merge(first, second, array);
        return array;
    }
     
    @SuppressWarnings({ "rawtypes", "unchecked" }) 
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] array) 
    {
        //Index Position in first array - starting with first element
        int iFirst = 0;
         
        //Index Position in second array - starting with first element
        int iSecond = 0;
         
        //Index Position in merged array - starting with first position
        int iMerged = 0;
         
        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst].compareTo(second[iSecond]) < 0) 
            {
                array[iMerged] = first[iFirst];
                iFirst++;
            }else{
                array[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
//        //copy remaining elements from both halves - each half will have already sorted elements
//      System.arraycopy(first, iFirst, array, iMerged, first.length - iFirst);
//      System.arraycopy(second, iSecond, array, iMerged, second.length - iSecond);
        while(iFirst < first.length){
        	array[iMerged] = first[iFirst];
        	iFirst++;
        	iMerged++;
        }
        while(iSecond < second.length){
        	array[iMerged] = second[iSecond];
            iSecond++; 
            iMerged++;
        }
    }
} 
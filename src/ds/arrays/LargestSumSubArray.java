package ds.arrays;
public class LargestSumSubArray
{
 public static void main(String[] args)
 {
  int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
  maxSubArraySum(arr);
}
public static int maxSubArraySum(int a[])
{
	int maxSum = 0, sum = 0;
	for (int i = 0; i < a.length; i++)
	{
		sum = sum + a[i];
		if (sum < 0)
			sum = 0;
		if (maxSum < sum)
			maxSum = sum;
	}
	return maxSum;
}	
  private static void maxSumSubArrayNew(int[] array){
	 int maxsum = Integer.MIN_VALUE;
	 int maxl = -1;
	 int maxr = -1;
	 for (int left = 0; left < array.length; left++) {
	     int sum = 0;
	     for (int right = left; right < array.length; right++) {
	         sum += array[right];
	         if (sum > maxsum) {
	             maxsum = sum;
	             maxl = left;
	             maxr = right;
	         }
	     }
	 }

//	 // if return just sum....
//	 return maxsum;
//
//	 // if return array:
//	 return Arrays.copyOfRange(array, maxl, maxr + 1);
	  System.out.println("Maximum sum = " + maxsum);
	  System.out.println("Indexes (" + maxl + "," + (maxr ) + ")");
 }
 
 private static void maxSumSubArray(int[] arr)
 {
  int currentStart = 0;
  int currentEnd = 0;
  int currentSum = 0;
  int maxStart = 0;
  int maxEnd = 0;
  int maxSum = 0;
  int counter =0;
  System.out.println("start");
  while (currentEnd != arr.length)
  {
   currentSum += arr[currentEnd];
   if (currentSum > maxSum)
   {
    maxSum = currentSum;
    maxStart = currentStart;
    maxEnd = currentEnd;
   }
   if (currentSum <= 0)
   {
    currentStart = currentEnd + 1;
    currentSum=0;
   }
	  counter++;
	  System.out.println("counter:"+counter+", currentSum=" +currentSum+", currentStart="+currentStart+", currentEnd="+currentEnd+", maxSum="
			  +maxSum+", maxStart="+ maxStart + ", maxEnd=" +maxEnd);

   currentEnd++;
  }
  System.out.println("Maximum sum = " + maxSum);
  System.out.println("Indexes (" + maxStart + "," + maxEnd + ")");
 }
}

import java.lang.reflect.Array;
import java.util.Arrays;

public class arrayPairSum {
	public static void main(String[] args){
		int[] nums = {1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}
	
	public static int arrayPairSum(int[] nums){
		 Arrays.sort(nums);
	        int result = 0;
	        for(int i = 0; i < nums.length; i = i + 2){
	            result = result + nums[i];
	        }
	        return result;
	    }

}

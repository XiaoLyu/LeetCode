/*
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
*/

class Solution {
    public String largestTimeFromDigits(int[] A) {
        String result = "";
        int max = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(j==i)    continue;
                for(int k = 0; k < 4; k++){
                    if(k == j || k == i)    continue;
                    for(int m = 0; m < 4; m++){
                        if(m == k || m == j || m == i)  continue;
                        int hour = 10*A[i] + A[j];
                        if(hour >= 0 && hour < 24){
                            int min = 10*A[m] + A[k];
                            if(min >= 0 && min <= 59){
                                int cur = 1000*A[i] + 100*A[j] + 10*A[m] + A[k];
                                if(cur >= max){
                                    max = cur;
                                    if(hour < 10){
                                        if(min < 10){
                                            result = "0" + hour + ":" + "0" + min;
                                        }
                                        else{
                                            result = "0" + hour + ":" + min;
                                        }
                                    }
                                    else{
                                        if(min < 10){
                                            result= hour + ":" + "0" + min;
                                        }
                                        else{
                                            result= hour + ":" + min;
                                        }
                                    }
                                    
                                }
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}

/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < n; i++){
			int index = i + 1;
			String result = "";
			if(index % 15 == 0){
				result = "FizzBuzz";
			}
			else if(index % 5 == 0){
				result = "Buzz";
			}
			else if(index % 3 == 0){
				result = "Fizz";
			}
			else
				result = Integer.toString(index);
			list.add(result);
		}
        return list;
    }
}

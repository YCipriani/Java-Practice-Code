import java.util.*;

public class Practice{
	public String reverseString(String s) {
		String output = "";
        char[] chars = s.toCharArray();
        for(int i = chars.length-1;i>=0;i--){
          output += chars[i];
        }
        return output;
	}

	//swaps two numbers using third variable
	public void swapCommandLineNumbers(){
		int temp, x, y;
		System.out.println("Please enter two numbers:");
		Scanner sc = new Scanner(System.in);
		x= sc.nextInt();
		y= sc.nextInt();
		System.out.println("Before Swapping: " + x + " " + y);
		temp = x;
		x=y;
		y=temp;
		System.out.println("After Swapping: " + x + " " + y);
	}

	//counts the number of words in a string using HashMap
	public HashMap wordCounter(String s){
		HashMap<String, Integer> myMap= new HashMap<String, Integer>();
		String[] split = s.split(" ");
		for(int i = 0; i<split.length;i++){
			if(myMap.containsKey(split[i])){
				myMap.replace(split[i],myMap.get(split[i]), myMap.get(split[i])+1);
			}
			else{
				myMap.put(split[i], 1);
			}
		}
		//arrow function to print out HashMap keys and their values
		myMap.entrySet().forEach(entry->{
    		System.out.println(entry.getKey() + " " + entry.getValue());  
 		});
		return myMap;
	}

	//checks whether a number is prime or not
	public boolean isPrime(int num){
		int temp;
		boolean isNumPrime = true;
		for(int i =2; i<=num/2; i++){
			temp = num%i;
			if(temp ==0){
				System.out.println(num + " is not a prime");
				return false;
			}
		}
		System.out.println(num + " is prime");
		return true;
	}

	//finds whether a string or number is palindrome or not
	public boolean isPalindrome(String s){
		char[] ary = s.toCharArray();
		int count =0;
		for(int i =0, k = s.length()-1; i<s.length();i++,k--){
			if(ary[i] == ary[k]){
				count++;
			}
		}
		if(count == s.length()){
			System.out.println("String is a Palindrome");
			return true;
		}
		else{
			System.out.println("String is not a Palindrome");
			return false;
		}
	}

	//Fibonacci series (series of numbers where ever occurring number is the sum of the two preceding numbers)
	public List fibonacciSequence(int numberOfIterations){
		int last=1, last2=0;
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		for(int i=1; i<numberOfIterations;i++){
			fib.add(fib.get(last)+fib.get(last2));
			last++;
			last2++;
		}
		//prints the list
		System.out.print("Fibonacci Sequesce for " + numberOfIterations + ": (");
		for(int k=0;k<fib.size();k++){
			if(k==fib.size()-1){
				System.out.print(fib.get(k));
			}
			else{
				System.out.print(fib.get(k) + ",");
			}
		}
		System.out.print(")\n");

		return fib;
	}

	//finds the second highest number in an array.
	public int secondLargest(int[] ary){
		int largest, second;
		if(ary.length<2){
			System.out.println("ERROR: Array needs to have more than one element to have a second largest element");
			return -1;
		}
		if(ary[0] >= ary[1]){
			largest=ary[0];
			second=ary[1];
		}
		else{
			largest =ary[1];
			second=ary[0];
		}
		for(int i =2; i<ary.length;i++){
			if(ary[i]>=largest){
				second = largest;
				largest = ary[i];
			}
			else if((ary[i]<largest) && ary[i]>second) {
				second = ary[i];
			}
		}
		System.out.println("Second largest number is:" + second);
        System.out.println("Largest Number is: "  +largest);
		return second;
	}

	//find all the leaders in an integer array. 
	//An element is said to be a leader if all the elements on it’s right side are smaller than it.
	public List<Integer> findLeaders(int[] ary){
		List<Integer> lst = new ArrayList<Integer>();
		for(int i =0; i<ary.length;i++){
			int count = 0;
        	if(i+1 != ary.length){
        		for(int k = i+1; k<ary.length;k++){
        			if(ary[i] > ary[k]){
        				count++;
        			}
        		}
        		if(count+i+1 == ary.length){
        			lst.add(ary[i]);
        		}

        	}
        	else{
        		lst.add(ary[i]);
        	}
      	}
      	System.out.println(Arrays.toString(lst.toArray()));
      	return lst;
	}

	public static void main(String[] args){
		Practice pr = new Practice();
		for(int i=0;i< args.length;i++)
    	{
    		System.out.println(pr.reverseString(args[i]));
    	}
    	//pr.swapCommandLineNumbers();
    	//pr.wordCounter("Hello how are you hello fine sir are are are");
    	//pr.isPrime(7);pr.isPrime(700);pr.isPrime(71);
    	//pr.isPalindrome("Primus");pr.isPalindrome("111121111");pr.isPalindrome("saippuakivikauppias");
    	//pr.fibonacciSequence(9);pr.fibonacciSequence(15);pr.fibonacciSequence(20);
  //   	int arr[] = { 100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };
  //   	pr.secondLargest(arr);
  //   	int ar[] = { 100 };
  //   	pr.secondLargest(ar);
  //   	int a[]={1,2,5,6,3,2};  
		// int b[]={44,66,99,77,33,22,55}; 
		// pr.secondLargest(a);
		// pr.secondLargest(b);
		int[] ary = {21, 58, 44, 14, 51, 36, 23};
    	pr.findLeaders(ary);
	}
}
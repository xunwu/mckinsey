//************************************************************************************************************
//Given an array of integers, write some code to find all the integers that appear more than once in the array
//sorted by which appears most often to least often (once)
//************************************************************************************************************

import java.util.Random;

public class TestFrequency {
 public static void main(String[] args) {
  int[][] values = new int[100][2];
  init(values);
  count(values, 300);//produce an array that has 300 elements
  System.out.println("The original array is :");
  printResult(values);//print out the original array
  
  System.out.println("");
  System.out.println("These elements have appeared more than once");
  //print out the numbers that has appeared more than once
  for (int i =0; i<100; i++){
	  if (values[i][1] >1){
		  System.out.println(values[i][0]);
	  }
  }
  
  System.out.println("");
  
  // use bubble sort to sort the appear times of the numbers
  int[][] temp = new int[1][2];
  for (int i =0; i<100; i++)
	  for(int j = i + 1; j<100; j++){
		  if (values[i][1] < values[j][1]){
			  temp[0][0] = values[i][0];
			  temp[0][1] = values[i][1];
			  values[i][0] = values[j][0];
			  values[i][1] = values[j][1];
			  values[j][0] = temp[0][0];
			  values[j][1] = temp[0][1];
		  }
	  }
  System.out.println("The Elements with the Highest to Lowest frequecny are ");
  printResult(values);//print out the sorted result;
 }
 
 /* 
  *Initialize the array
  *In the Two dinmsional array, there are 100 elements in the first dimision and each of them stored two numbers in the second dimision
  *the first number of the second dimision stores the value of the number and the second number stores the times they appear in the array
  *all the appear times are set to 0 at the begining;
  */
 private static void init(int[][] values) {
  for(int i = 0; i < values.length; i++) {
   values[i][0] = i;//0-99
   values[i][1] = 0;//initialize the appear times to 0;
  }  
 }
 
 /*
  *Calculation
  *produce cnt random integers
  *Find the position of the random numbers according to their values, and increase the second number in the second dimision by one when they appear.
  **/
 private static void count(int[][] values, int cnt) {
  Random r = new Random();
  for(int i = 0; i < cnt; i++) {
   int n = r.nextInt(100);//get a random number between 0 to 99
   values[n][1]++;//increase the appear times by one
  }
 }
 
 // print the result
 private static void printResult(int[][] values) {
  for(int i = 0; i < values.length; i++) {
   System.out.println(values[i][0] + " appear times: " + values[i][1]);
  }
 }
}
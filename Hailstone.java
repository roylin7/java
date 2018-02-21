/*
  File: Hailstone.java

  Description:Compute & verify Hailstone sequence conjucture in a user defined range.

  Student Name:Zengxiang Lin

  Student UT EID:zl4295

  Course Name: CS 312

  Unique Number: 87525

  Date Created:6/25/16

  Date Last Modified:6/25/16

*/





import java.util.Scanner;

public class Hailstone
{
   //Main method
  public static void main(String[] args)
   {
    //Create a Scanner
     Scanner sc = new Scanner(System.in);
    
    //Prompt the user to enter the starting number and ending number 
     System.out.println("Enter starting and ending number of the range:");
     int start = sc.nextInt();
     int  end  = sc.nextInt();
     
    //Listing variables
     int result=0; 
     int hs =0;
     int hn =0;
     int count;
     
     
    //Prompt the user to enter the right range in right order
    if(start<=0 || end<= 0 || start>end)
	{
	System .out.println("Enter the starting and ending number of the range again:");
	start = sc.nextInt();
        end  = sc.nextInt();
	}

    //Increment loop until the starting number reaches the ending number	
     for(int x= start;x<= end;x++)
	{
	  result=x;
	  count =0;
	  
	while(result !=1)   //Repeat the result to get the sequence and count the total number of the sequences
	 {
	    if(result %2 ==0)  //Calculate the result when the starting number is even
	    {  
	       result = result/2;
	    }
	    else   //Calculating the result when the starting number is odd
	    {
		result= 3*result+1;
	    }
	
           count++;   // Count the number
	
	 }
	   if (count>hs) // Record the highest sequence and highest number
	   {
	      hs= count;
	      hn = x;
	
	  
	   }
	}
	System.out.println("The number "+ hn +" has the longest cycle of "+hs+'.'); //Print out the highest number and highest sequence

	

	
     
	
    }


}
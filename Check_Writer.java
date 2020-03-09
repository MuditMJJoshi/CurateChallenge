  
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Automatic Check Writing Machine
//
// Author:          Mudit Joshi
//
// Version:         v001.1
// 
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.*; 

public class Check_Writer  

{
   private static final String[] ThMilBil = {
       "",
       " Thousand",
       " Million",
       " Billion",
       " Trillion",
       " Quadrillion",
       " Quintillion"
   };
   
   private static final String[] tentoninety = {
       "",
       " Ten",
       " Twenty",
       " Thirty",
       " Forty",
       " Fifty",
       " Sixty",
       " Seventy",
       " Eighty",
       " Ninety"
   };
   
   private static final String[] onetoteens = {
       "",
       " One",
       " Two",
       " Three",
       " Four",
       " Five",
       " Six",
       " Seven",
       " Eight",
       " Nine",
       " Ten",
       " Eleven",
       " Twelve",
       " Thirteen",
       " Fourteen",
       " Fifteen",
       " Sixteen",
       " Seventeen",
       " Eighteen",
       " Nineteen"
   };
   
   private static String converthundreds (long number) {
      
	   String storewords;
       
       // Loop to store 1-19 numbers only
       
       if (number % 100 < 20){
    	   
           storewords = onetoteens[(int) (number % 100)];
           number /= 100;
        }
       
       // Loop to store -ty numbers only
       
       else {
    	   
    	   // Stores names of ones position
    	   
           storewords = onetoteens[(int) (number % 10)];
           number /= 10;
           
        // Stores names of -ty position
           
           storewords = tentoninety[(int) (number % 10)] + storewords;
            number /= 10;
       }
       
       if (number == 0) {
    	   
    	   return storewords;
       }
       
       return onetoteens[(int) number] + " hundred" + storewords;
   }
   
   private static String numbertoword(long number) {

       if (number == 0) { 
    	   
    	   return "zero"; 
    	 } 
       
       String storewords = "";
       int place = 0;
       
       do {
    	   //Divides the number to retrieve hundreds from the back
    	   long n = number % 1000;
            
           if (n != 0){
        	   
               String s = converthundreds(n);
               storewords = s + ThMilBil[place] + storewords;
               
           }
           
           // Used to allocate specialName[Th,Mil,Bil...]
           place++;
           number /= 1000;
           
       } while (number > 0);
       
       return (storewords).trim();
   }
   
   public static void main(String[] args) {
	   
	   //Check_Writer obj = new Check_Writer();
	   
	   Scanner number = new Scanner(System.in); 
	   String input = number.nextLine(); 
	   
	   //Check for +1 (".")
	   
	   boolean checker = true;
	   
	   String[] check = input.split("\\.",2); 
	   
	   
	   String[] split = input.split("\\."); 
	   
	  
	  long a = Long.parseLong(split[0]);
	  
	  long b = Long.parseLong(split[1]);
	   
	   
	   if(check[1].contains(".")==true) {
		   
		   System.out.println("Wrong Input");
		   
		   checker = false;
		   
	   }
	   
	   if(checker) {
	   
	   if(Float.parseFloat(input)< 0) {
		   
		   System.out.println("Negative Value");
	   }
	   
	   else if(Long.parseLong(split[1])>99) {
		   
		   System.out.println("Wrong Decimal Value");
	   }
	   
	   else {
	
		   String first = numbertoword(a);
	
		   String second = " and " +converthundreds(b) +" hundredths";
	
		   System.out.println(first+second);
	   
	 }
  }
 }
}









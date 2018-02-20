/*
  File: Realtor.java

  Description: helping to maintain a list of houses that are for sale

  Student Name: Zengxiang Lin

  Student UT EID: zl4295

  Partner's Name: Maksat Zhazbayev

  Partner's UT EID:MKZ236

  Course Name: CS 303E

  Unique Number: 87525

*/

import java.util.Scanner;
import java.io.*;

public class Realtor
{
  public static void main ( String[] args ) throws IOException 
  {
  File inFile = new File ("realtor.txt");
Scanner input = new Scanner(inFile);
// Create a HouseList object that can hold a hundred houses
    HouseList h1 = new HouseList(100);
  
// Populate the array with 10 houses with data from realtor.txt
// Create an Address object for each house
// Create a House object for each house and add the Address object
// Add the House object to the HouseList

Address a1;
House h12;
int i = 0;
String street  = input.nextLine();
String town = input.nextLine();
String state = input.nextLine();
String zip = input.nextLine();
int area = input.nextInt();
int bedRooms = input.nextInt();
int bathRooms = input.nextInt();
int garage = input.nextInt();
double price = input.nextDouble();
 
a1 = new Address(street, town, state, zip);
h12 = new House (a1, area, bedRooms, bathRooms, garage, price);

//h1.houseList[i] = new House();
//h1.houseList[i] = h12;
h1.newHouse(i);
h1.getHouseList()[i] = h12;


while(input.hasNextLine()) {
input.nextLine();
input.nextLine();

 i++;

 street = input.nextLine();
 town = input.nextLine();
 state = input.nextLine();
 zip = input.nextLine();
 
 area = input.nextInt();
 bedRooms = input.nextInt();
 bathRooms = input.nextInt();
 garage = input.nextInt();
 price = input.nextDouble();
 

a1 = new Address(street, town, state, zip);
h12 = new House (a1, area, bedRooms, bathRooms, garage, price);

//h1.houseList[i] = new House();
//h1.houseList[i] = h12;
h1.newHouse(i);
h1.getHouseList()[i] = h12;

}
Scanner sc = new Scanner(System.in);


House houseObject = new House();
h1.addHouse(houseObject);

// Write out the number of houses in your list
    //...
h1.getNumHouses();

// Write out the houses in a certain zip code
    //...
//String zipchik = "78712";
System.out.print("\nEnter ZIP: ");
String zipchik = sc.next();
h1.searchByZip(zipchik);

// Write out the houses in a certain price range
    //...
//double lowPrice = 2000000.0;
//double highPrice = 2500000.0;

System.out.print("\nEnter lowPrice: ");
double lowPrice = sc.nextDouble();
System.out.print("Enter highPrice: ");
double highPrice = sc.nextDouble();
h1.searchByPrice(lowPrice, highPrice);
    
// Write out the houses in a certain square foot range
    //...
System.out.print("\nEnter lowArea: ");
int lowArea = sc.nextInt();
System.out.print("Enter highArea: ");
int highArea = sc.nextInt();
h1.searchByArea(lowArea, highArea); 
    
// Write out the houses that have a certain number of bedrooms
System.out.println("\nEnter number of Bedrooms: ");
int numBedrooms = sc.nextInt();
    h1.searchByRooms(numBedrooms);
    //...

input.close();
  }
}


class House {
public Address address;
public int area;
public int bedRooms;
public int bathRooms;
public int garage;
public double price;

public House() {
this.address = new Address();
this.area = 0;
this.bedRooms = 0;
this.bathRooms = 0;
this.garage = 0;
this.price = 0;

}
public House(Address address, int area, int bedRooms, int bathRooms, int garage, double price) {
this.address = address;
this.area = area;
this.bedRooms = bedRooms;
this.bathRooms = bathRooms;
this.garage = garage;
this.price = price;
}


public String toString() {
return  "(" + address + ", " + area + ", " + bedRooms + ", " + bathRooms + ", " + garage + ", " + price + ")";
}


public double priceSqft() {
return price / area;
}

public double getPrice()
     {
     	return this.price;
     }
     
     public Address getAddress()
     {
     	return this.address;
     }
     
     public int getArea()
     {
     	return this.area;
     }
    
     public int getBedroom()
     {
     	return this.bedRooms;
     }
     
     public int getBathroom()
     {
     	return this.bathRooms;
     }
     
     public int getGarage()
     {
     	return this.garage;
     }   
}


class Address {
public String street;
public String town;
public String state;
public String zip;

public Address() {
this.street = "";
this.town = "";
this.state = "";
this.zip = "";
}

public Address(String street, String town, String state, String zip) {
this.street = street;
this.town = town;
this.state = state;
this.zip = zip;
}

public String toString() {
String str = "(" + street + ", " + town + ", " + state + ", " + zip + ")"; 
return str;
}
public String getZip()
        {
        	return this.zip;
        }
}

class HouseList {
private House[] houseList;
private int numHouses;

public HouseList() {
this.houseList = new House [0];
this.numHouses = 0;
}

public HouseList(int n) {
houseList = new House [n];
}

public int getNumHouses() {
numHouses = houseList.length;
return numHouses;
}


public House newHouse(int num) {

houseList[num] = new House();
return houseList[num];
}

public House[] getHouseList() {
return this.houseList;
}
/*
public void printHouse() {
for (int i = 0; i < getNumHouses(); i++) {
System.out.println(houseList[i]);
}
 }
*/

 
public void addHouse(House house) {
House[] list = this.houseList;
int i = 0;
while(list[i] != null) {
i++;
}
list[i] = house;
System.out.println("The house that was added is " + list[i]);
 }



public void searchByZip (String zip) 
          {
           	System.out.println("\n\nThe houses that were searched by ZIP are: ");
           	 House [] list =this.houseList;
          	int i = 0;
            while(list[i] != null) {
             i++;
                 }

          for (int j =0; j<i;j++)

           {
           		House house1 = houseList[j];
           	    Address add1 = house1.getAddress();
             	String zip1 = add1.getZip(); 
           
           	if (zip1.equals(zip)) {
           	System.out.println("\n" + list[j]);
           	}
           	 }
            
          }

public void searchByPrice ( double lowPrice ,double highPrice  )
          {
          	
            House [] list =this.houseList;
            int i = 0;
            while(list[i] != null) {
             i++;
                 }
            
           	System.out.println("\n\nThe houses that were searched by PRICE are: ");

          	for (int j=0; j<i;j++ )
          	{   
          	
          	    House house1 =list[j];
                double price = house1.getPrice();
          //	System.out.println(price);
          		if(price >= lowPrice && price <= highPrice)
          		{
          
          			System.out.println("\n" + list[j]);
          		}
          	}
          }
 
public void searchByArea ( int lowArea ,  int highArea )
          {
            
            House [] list = this.houseList;
            int i = 0;
            while(list[i] != null) {
             i++;
                 }
           	System.out.println("\n\nThe houses that were searched by AREA are: ");

          	for (int j = 0; j<i;j++)
          	{
          	House house1 =list[j];
          	int area = house1.getArea();
          	if(area>lowArea &&area<highArea)
          	{
          		System.out.println("\n" + list[j]);
          	}
          	}
          }
          
 // prints the houses having that many bedrooms	
public void searchByRooms ( int rooms )
          {
           	System.out.println("\n\nThe houses that were searched by number of BEDROOM  are: ");

            House [] list =this.houseList;
            int i = 0;
            while(list[i] != null) {
             i++;
                 }
          	for (int j = 0; j <i; j++)
          	{   
          		House house1 =list[j];
          		int room = house1.getBedroom();
          		
          		if(rooms==room)
          		{
          		 System.out.println("\n" + list[j]);	
          		}
          	}
          
    }
          
          
}

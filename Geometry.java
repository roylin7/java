/*
  File: Geometry.java

  Description: developing several classes that are fundamental in Geometry - Point, Circle, and Rectangle. 

  Student Name:Zengxiang Lin		

  Student UT EID:zl4295

  Course Name: CS 312

  Unique Numbers: 87525

  Date Created:8/6/16

  Date Last Modified:8/8/16

*/


   import java.util.*;
   import java.io.*;

class Point
{
  // list of attributes - x and y coordinates
  private double x;
  private double y;

  // default constructor
  public Point ()
  {
  	x = 0.0;
  	y = 0.0;
  }

  // non-default constructor
  public Point (double x, double y)
  {
  	 this.x = x;
     this.y = y;
  }

  // accessors get the x and y coordinates
  public double getX ()
  	{
  	return this.x;
    }
  public double getY ()
  	{
  	return this.y;
    }

  // mutators set the x and y coordinates
  public void setX (double x)
   {
  	this.x = x;
    }
  public void setY (double y)
  {
  	this.y = y;
  }

  // distance to another point
  public double dist (Point p)
  {
  	return Math.sqrt ((this.x - p.x) * (this.x - p.x) +
                      (this.y - p.y) * (this.y - p.y));
  }

  // string representation of a point, i.e. x and y coordinates
  public String toString ()
  {
  	 String s = "(" + this.x + ", " + this.y + ")";
     return s;
  }

  // test for equality of two points
  public boolean equals (Point p)
  {
  	 double delta = 1.0e-16;
    return (Math.abs (this.x - p.x) < delta) &&
           (Math.abs (this.y - p.y) < delta);
  }
}

class Circle
{
  // list of attributes
  private double radius;
  private Point center;

  // default constructor (radius = 1.0 and center at the origin)
  public Circle ()
  {
  	this.radius = 1.0;
  	this.center = new Point();
  }

  // non-default constructors
  public Circle (double radius, double x, double y) 
  {
  	this.radius = radius;
  	this.center = new Point(x,y);
  }

  public Circle (double radius, Point p)
  	{
    this.radius = radius;
    this.center = new Point (p.getX(), p.getY());
  }

  // accessors
  public double getRadius ()
  {
  	return this.radius;
  }

  public Point getCenter ()
  {
  	return this.center;
  }

  // mutators
  public void setRadius (double radius)
  {
  	this.radius= radius;
  }

  public void setCenter (double x, double y)
  {
  	this.center.setX(x);
  	this.center.setY(y);
  }

  public void setCenter (Point p)
  {
  	this.center = p;
  }

  // calculate circumference
  public double circumference ()
  {
  	return 2.0 * Math.PI * this.radius;
  }

  // calculate area
  public double area ()
  {
    return Math.PI * this.radius * this.radius;
  }

  // determine if Point p is strictly inside this Circle
  public boolean isInside (Point p)
  {
  	double distance = this.center.dist (p);
  	return distance  < this.radius;
  }

  // determine if Circle c is strictly inside this Circle
  public boolean isInside (Circle c)
  {
     double distance = this.center.dist (c.getCenter());
     return ((distance + c.getRadius()) < this.radius);
  }

  // determine if Rectangle r is strictly inside this Circle
  public boolean isInside (Rectangle r)
  {	
  	
  	double dis1 = this.center.dist(r.getUL());
  	double dis2 = this.center.dist(r.getLR());
  	
  	
  	return dis1<=this.radius &&dis2<=this.radius;
  }

  // determine if Circle c intersects this Circle
  public boolean doesIntersect (Circle c)
  {
  	 double distance = this.center.dist (c.getCenter());
     return (distance <= (this.radius + c.getRadius()));
  }

  // determine if Rectangle r intersects this Circle
  public boolean doesIntersect (Rectangle r)
  	{
  	  double dis1 = this.center.dist(r.getLR());
  	  double dis2 = this.center.dist(r.getUL());
  	  
  	  return this.radius>dis1 || this.radius>dis2;
    }

  // determine the Rectangle that inscribes this Circle
  public Rectangle inscribes ()
  {
  	double x1;
  	double x2;
  	double x=this.center.getX();
  	double y = this.center.getY();
  	double y1;
  	double y2;
  	double r = this.radius;
  	
  	x1=x-r;
  	x2=x+r;
  	y1=y+r;
  	y2=y-r;
  	Rectangle ry = new Rectangle(x1,y1,x2,y2);
  	
  	return ry;
  	
  }

  // string representation of the Circle in the form:
  // Radius: 1.2, Center: (3, 4)
  public String toString ()
  {
    String s = "Radius:1.2, Center:(3,4)";
    return s;
  }

  // determine if two Circles have the same radius
  public boolean equals (Circle c)
  	{
  	return c.getRadius()== this.radius;
   }

  // determine if two Circles have the same center
  public boolean isConcentric (Circle c)
  {
  	 Point cen = c.getCenter();
  	 return cen.getX()==this.center.getX() && cen.getY()==this.center.getY();
  }
}

class Rectangle
{
  // list attributes
  private Point UL; 	// upper left corner
  private Point LR;	    // lower right corner

  // default constructor creates a rectangle having
  // corners UL (0, 1) and LR (1, 0)
  public Rectangle ()
  {
  	this.UL = new Point(0,1);
  	this.LR = new Point(1,0);
  }

  // non-default constructors accept user defined points
  // and creates a rectangle object if the points form a
  // rectangle or the default rectangle if they do not.
  public Rectangle (Point ul, Point lr)
  {
  	this.UL=ul;
  	this.LR=lr;
  	
  }

  public Rectangle (double x1, double y1, double x2, double y2)
  {
  	
  	if(y1>y2 &&x1<x2)
  	this.UL = new Point(x1,y1);
  	this.LR = new Point(x2,y2);
  }

  // accessors
  public Point getUL ()
  {
  	return this.UL;
  }
  public Point getLR ()
  {
  	return this.LR;
  }

  // get length - absolute value of the x coord difference
  public double getLength ()
  {
  	return Math.abs(this.UL.getX()-this.LR.getX());
  }

  // get width - absolute value of the y coord difference
  public double getWidth ()
  {
  	return Math.abs(this.UL.getY()-this.LR.getY());
  }

  // mutators reset the edge points only if the rectangle 
  // shape is preserved
  public void setUL (Point ul)
  {
  	this.UL = ul;
  }
  public void setLR (Point lr)
  {
  	this.LR = lr;
  }

  public void setUL (double x1, double y1)
  {
    this.UL.setX(x1);
    this.UL.setY(y1);
  }
  public void setLR (double x2, double y2)
  {
  	this.LR.setX(x2);
  	this.LR.setY(y2);
  }
  public void setRectangle (double x1, double y1, double x2, double y2)
  {
  	this.UL.setX(x1);
    this.UL.setY(y1);
    this.LR.setX(x2);
  	this.LR.setY(y2);
  }

  // calculate area of a rectangle
  public double area ()
  {
  	return Math.abs(this.UL.getX()-this.LR.getX())* Math.abs(this.UL.getY()-this.LR.getY());
  }

  // calculate the perimeter of a rectangle
  public double perimeter ()
  {
  	return 2*(Math.abs(this.UL.getX()-this.LR.getX())+ Math.abs(this.UL.getY()-this.LR.getY()));
  }

  // determine if a point is inside the rectangle
  public boolean isInside (Point p)
  {
  	double xp = p.getX();
  	double yp = p.getY();
  	
  	return xp<this.LR.getX() &&xp>this.UL.getX() && yp>this.LR.getY() && yp < this.UL.getY();
  }

  // determine if the Circle c is inside the rectangle
  public boolean isInside (Circle c)
  {
  	Point cen = c.getCenter();
  	Rectangle a = new Rectangle(this.UL,this.LR);
  	return a.isInside(cen) && !c.doesIntersect(a) && c.getRadius()<=a.getLength() &&c.getRadius()<= a.getWidth();	
  }

  // determine if the Rectangle r is strictly inside this Rectangle
  public boolean isInside (Rectangle r)
  {
  	return r.isInside(r.getUL()) && r.isInside(r.getLR());
  }

  // determine if Rectangle r intersects with this Rectangle
  public boolean doesIntersect (Rectangle r)
  {
  	double r1 = r.getLength();
  	double r2 = r.getWidth();
  	Point r3 = r.getLR();
  	Point r4 = r.getUL();
  	Rectangle a = new Rectangle(this.UL,this.LR);
  	
  	return this.UL.getX()-r4.getX()<r1+this.UL.getX() || this.LR.getY()-r3.getY() <  r2 + this.LR.getY();
  }
	
	  // determine the Circle that circumscribes this Rectangle
  public Circle circumscribes ()
  {
  	double x1= this.UL.getX();
  	double x2= this.LR.getX();
  	double x;
  	double y;
  	double y1=this.UL.getY();
  	double y2=this.LR.getY();
  	double r;
  	double dist =this.UL.dist(this.LR);
  	
  	r=dist/2.0;
  	x=(x2-x1)/2.0;
  	y=(y1-y2)/2.0;
  	
  	
  	Circle cc = new Circle(r,x,y);
  	return cc;
  }

  // return a string representation of a rectangle of the form
  // UL: (3, 4), LR: (7, 2)
  public String toString ()
  {
  	String s = "UL:(3,4), LR:(7,2)";
  	return s;
  }

  // determine if two rectangles are congruent, i.e. the
  // length of one is equal to the length of the other
  // width of one is equal to the width of the other
  public boolean equals (Rectangle r)
  {
  	return Math.abs(this.UL.getX()-this.LR.getX())== r.getLength() && Math.abs(this.UL.getY()-this.LR.getY()) == r.getWidth();
  }

  // determine if a rectangle is a square
  public boolean isSquare () 
  {
  	return Math.abs(this.UL.getX()-this.LR.getX())== Math.abs(this.UL.getY()-this.LR.getY());
  }

}

public class Geometry
{

  public static void main (String[] args) throws IOException
  {
    // open file "geometry.txt" for reading
    
    File infile = new File("Geometry.txt");
    Scanner sc = new Scanner(infile);

    // read the coordinates of the first Point pointP
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    Point pointP= new Point(x,y);
    sc.nextLine();
    
    
    // read the coordinates of the second Point pointQ
    double  x1 = sc.nextDouble();
    double  y1 = sc.nextDouble();
    Point pointQ = new Point(x1,y1);
    sc.nextLine();

    // print distance between pointP and pointQ
    
    System.out.println("Distance between pointP and pointQ  "+pointP.dist(pointQ));

    // read the radius and coordinates of the first Circle circleA
    double a1= sc.nextDouble();
    double a2 = sc.nextDouble();
    double a3 = sc.nextDouble();
    Circle circleA = new Circle(a1,a2,a3);
    sc.nextLine();

    // read the radius and coordinates of the second Circle circleB
    double b1 =sc.nextDouble();
    double b2 =sc.nextDouble();
    double b3 =sc.nextDouble();
    Circle circleB = new Circle(b1,b2,b3);
    sc.nextLine();

    // print the circumference of circleA
    System.out.println("Circumference of circleA: "+circleA.circumference ());
 
    // print the area of circleB
    System.out.println("Area of circleB: "+ circleB.area());

    // print if pointP is inside circleA
    if(circleA.isInside(pointP)==true)
    {
    System.out.println("pointP (is / is  not) inside circleA. PointP IS inside circleA" );
    }
    else 
    {
    	System.out.println("pointP (is / is  not) inside circleA. PointP is NOT inside circleA" );
    }
    // print if circleB is inside circleA
    if(circleB.isInside(circleA)==true)
    {
	System.out.println("circleB IS inside circleA. ");
    }
    else
    {
    System.out.println("circleB is NOT inside circleA.");
    }
    
    // print if circleA and circleB intersect
    if(circleB.doesIntersect(circleA)==true)
    {
      System.out.println("circleA and circleB does intersect.");
    }
    else 
    {
      System.out.println("circleA and circleB  does not intersect: "+circleB.doesIntersect(circleA));
    }
     // print the Rectangle that circleB is inscribed in
     
	 Rectangle ac = circleB.inscribes();
     
     System.out.println("Coordinates of rectangle that inscribes circleB:"+ac.toString());

    // read the coordinates of the UL and LR corners of Rectangle rectG
     double rg1 = sc.nextDouble();
     double rg2 = sc.nextDouble();
     double rg3 = sc.nextDouble();
     double rg4 = sc.nextDouble();
     sc.nextLine();
     Rectangle rectG = new Rectangle(rg1,rg2,rg3,rg4);
    
    
    
    // read the coordinates of the UL and LR corners of Rectangle rectH
    double rh1 =sc.nextDouble();
    double rh2 =sc.nextDouble();
    double rh3 =sc.nextDouble();
    double rh4 =sc.nextDouble();
    Rectangle rectH= new Rectangle(rh1,rh2,rh3,rh4);
    
    // print the length and width of rectG
    System.out.println("RectG's length and width is "+rectH.getLength()+" and "+rectH.getWidth());
    
    // print if the rectG and rectH have the same area but different perimeter
	
	if(rectG.area()==rectH.area())
	{
		if(rectG.perimeter()==rectH.perimeter())
		{
			System.out.println("rectG and rectH have the same area and same perimeter");
		}
		else{
		 	System.out.println("the rectG and rectH have the same area but different perimeter");	
		}
	}
	else 
	{
		if(rectG.perimeter()==rectH.perimeter())
		{
			System.out.println("rectG and rectH have the smae perimeter uyt different area");
		}
		else{
		 	System.out.println("the rectG and rectH have different area and perimeter")	;
		}
	}
	
	
    // print if rectH is a square
	if(rectH.isSquare()==true)
	{
		System.out.println("RectH is a square.");
	}
	else
	{
		System.out.println("RectH is not a square.");
	}
    // print the Circle that circumscribes rectH
    Circle ab = rectH.circumscribes();
    
    System.out.println("Coordinates of circle that circumscribes rectH: "+ ab.toString());
    
   

    // determine if pointP is inside rectG
    if(rectG.isInside(pointP)==true)
    {
    	System.out.println("pointP is inside  of rectG.");
    	
    }
    else 
    {
    	System.out.println("pointP is not inside of rectG.");
    }

    // determine if circleB is inside rectH
	
	if(circleB.isInside(rectH)==true)
	{
		System.out.println("CircleB is inside rectH");
		
	}
	else 
	{
			System.out.println("CircleB is not inside rectH");
	}
	
	
	
    // determine if rectH is inside rectG
    
    if(rectH.isInside(rectG)==true)
    {
    	System.out.println("rectH is inside rectG");
    	
    }
    else
    {
    	System.out.println("rectH is not inside rectG");
    }

    // determine if rectG and rectH intersect
    if(rectG.doesIntersect(rectH))
    {
    	System.out.println("rectG and rectH are intersecting");
     }
     else 
     {
     System.out.println("rectG and rectH are not intersecting");	
     }
	
    // close file "geometry.txt"
    sc.close();

  }
   
}
    
    
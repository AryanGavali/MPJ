import java.util.*;

class Shapes 
{

    
    double l, b, r;

    
    Shapes(double l, double b) 
    {
        this.l = l;
        this.b = b;
    }

    
    Shapes(double r) 
    {
        this.r = r;
    }

    
    Shapes() 
    {
        l = 0;
        b = 0;
        r = 0;
    }

    
    
    double area(double l, double b) 
    {
        double rectangleArea = l * b;
        return rectangleArea;
    }

    
    double area(double r) 
    {
        double circleArea = Math.PI * r * r;
        return circleArea;
    }

    
    double area(int s) 
    {
        double squareArea = s * s;
        return squareArea;
    }

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        Shapes obj = new Shapes();

        
        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();

        double rect = obj.area(length, breadth);

        
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();

        double circ = obj.area(radius);

        
        System.out.print("Enter side of square: ");
        int side = sc.nextInt();

        double sq = obj.area(side);

        
        System.out.println("\n----- Area Calculations -----");
        System.out.println("Rectangle Area = " + rect);
        System.out.println("Circle Area = " + circ);
        System.out.println("Square Area = " + (int)sq);

        sc.close();
    }
}
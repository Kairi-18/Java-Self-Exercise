package Shapes.Parallelogram;

import java.util.Scanner;

class Parallelogram{
  protected double side;
  protected double height;
  protected double base;

  public Parallelogram(double side, double height, double base){
      this.base = base;
      this.height = height;
      this.side = side;
  }

  public void allParallelogram(){
    double perimeter = perimeter();
    System.out.println("The perimeter of square is " + perimeter);
  }
  private double perimeter(){
    return 2 * (side + base);
  }
}
class Area extends Parallelogram{
  
  public Area(double side, double height, double base){
    super(side, height, base);
  }
  public void allAreaParallelogram(){
    double area = area();
    System.out.println("The area of square is " + area);
  }
  private double area(){
    return base * height;
  }
}
public class Main {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter the side: ");
    double side = input.nextInt();

    System.out.print("Enter the base: ");
    double base = input.nextInt();

    System.out.print("Enter the height: ");
    double height = input.nextInt();

    Parallelogram merged = new Parallelogram(side, height, base);
    merged.allParallelogram();

    Area mergedd = new Area(base, height, side);
    mergedd.allAreaParallelogram();
  }
}
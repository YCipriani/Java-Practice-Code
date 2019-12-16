import java.util.*;

public abstract class Manipulation{ //Super class
  public void add(){
    System.out.println("MANIPULATE");
  }
  public abstract int divide(int a, int b);

  protected void subtract(){
  	System.out.println("CHECK 1 2");
  }
  
  public abstract void display();
}
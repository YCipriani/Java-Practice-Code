import java.util.*;

public class Addition extends Manipulation implements Test, Runnable{ // Sub class
  @Override
  public void add(){
  	System.out.println("Ok Ok");
  }


  public int divide(int a, int b ){
  	try{
  		return a/b;
  	}
    catch(ArithmeticException e){
    	System.out.println("Exception caught in METHOD");
    	return 0;
    }
  }

  @Override
  public void display(){
    System.out.println("DISPLAYING");
  }

  public void run() 
    { 
        System.out.println("Run method executed by child Thread"); 
    } 

  public static void main(String args[]){
    Manipulation addition = new Addition();//Manipulation is reference type and Addition is reference type
    try{
    	addition.divide(5,4);
    	addition.divide(3,0);
      addition.subtract();
      addition.display();
      Test.hello();
      Thread t1 = new Thread((Addition) addition);
      t1.start();
      t1.join();
      System.out.println("MAIN METHOD executed");

    }
    catch(Exception e){
      e. printStackTrace();
    }
  }
}
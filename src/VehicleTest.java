/**
 * TestVehicles oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 */

import java.util.*;
import java.io.*;

public class VehicleTest {
  public static void main(String[] args) {
	  VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));

    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..............................Exit program");
      System.out.println("...............................Your choice?");
      int choice = scan.nextInt();
      String name;

      switch (choice) {
      case 1:
    	arr.add(new Car());
        vehicle = arr.get(arr.size() - 1);
        try {
            vehicle.setAllFields();
          } catch(Exception e) {
            System.out.println("Wrong input!");
            System.exit(1);
          }
        break;
      case 2:
      	arr.add(new Bicycle());
        vehicle = arr.get(arr.size() - 1);
        try {
            vehicle.setAllFields();
          } catch(Exception e) {
            System.out.println("Wrong input!");
            System.exit(1);
          }
        break;
      case 3:
    	System.out.println("Name of vehicle: ");
    	name = scan.next();
    	for(Vehicle v : arr) {
    		if(v.getName() != null && 
    				(v.getName().compareToIgnoreCase(name) == 0)) {
    	        		System.out.println(v);
    		}
    	}
        break;
      case 4:
      	for(Vehicle v : arr) {
    	        System.out.println(v);
    	    }
        break;
      case 5:
      	System.out.println("Name of vehicle: ");
      	name = scan.next();
      	char dir;
      	int degree;
      	for(Vehicle v : arr) {
      		if(v.getName() != null && 
      				(v.getName().compareToIgnoreCase(name) == 0)) {
      			System.out.print("\nDirection [R/L]: ");
      			dir = scan.next().charAt(0);
      			System.out.print("\nDegrees [0-360]: ");
      			degree = scan.nextInt();
      			if (dir == 'L') { v.turnLeft(degree); }
      			if (dir == 'R') {v.turnRight(degree); }
      		}
      	}
        break;
      case 6:
    	  Car car1 = new Car("A bad car","red",100000,1999,"A111",350,0);
    	  Car car2 = (Car)car1.clone();
    	  car2.getBuyingDate().set(2003, 1, 2);
    	  car2.getProductionDate().set(2003, 5, 5);
    	  System.out.println("Date objects are separate, deep copy");
    	  System.out.printf("%n %tF", car1.getBuyingDate());
    	  System.out.printf("%n %tF %n", car2.getBuyingDate());
    	  System.out.printf("Production date car2 edited: "
    	  		+ "%n %tF %n", car2.getProductionDate());
    	  break;
      case 7:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}


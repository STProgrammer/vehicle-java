
public abstract class Vehicle implements Comparable<Vehicle>,
Cloneable, Driveable {
	private String colour;
	private String name;
	private String serialNr;
	private int model;
	private int price;
	private int direction;
	private double speed;
	private java.util.Calendar buyingDate;
	protected java.util.Scanner input;
	
	public Vehicle() {}
	
	public Vehicle(String name, String colour, int price,
			int model, String serialNumber, int direction) {
		setColour(colour);
		setName(name);
		setSerialNr(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setBuyingDate(new java.util.GregorianCalendar());
		this.speed = 0;
	}
	
	public void setAllFields() {
		input = new java.util.Scanner(System.in);
		System.out.println("Input vehicle data: ");
		System.out.print("Name: ");
		setName(input.next());
		System.out.print("\nColour: ");
		setColour(input.next());
		System.out.print("\nPrice: ");
		setPrice(input.nextInt());
		System.out.print("\nModel: ");
		setModel(input.nextInt());
		System.out.print("\nSerial #: ");
		setSerialNr(input.next());
		setBuyingDate(new java.util.GregorianCalendar());
		setDirection(0);
		setSpeed(0);
	}
	
	/** abstract methods */
	public abstract void turnLeft(int degrees);
	public abstract void turnRight(int degrees);
	
	public void stop() {
		setSpeed(0);
		System.out.println("The vehicle has stopped!");
	}
	
	/** get and set methods */
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNr() {
		return serialNr;
	}

	public void setSerialNr(String serialNumber) {
		this.serialNr = serialNumber;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public java.util.Calendar getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(java.util.Calendar buyingDate) {
		this.buyingDate = buyingDate;
	}
	
	/** end get and set methods */
	
	@Override
	public int compareTo(Vehicle other) {
		  if (this.getPrice() < other.getPrice()) {
			  return -1;
		  }
		  if (this.getPrice() == other.getPrice()) {
			  return 0;
		  }
		  else return 1;
	}
	
	@Override
	public Object clone() {
	    try {
	        Vehicle cloned = (Vehicle)super.clone();
	        cloned.buyingDate = (java.util.Calendar)buyingDate.clone();
	        return cloned;
	      }
	      catch (CloneNotSupportedException ex) {
	        return null;
	      }
	}
	
	/** toString method */
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed());
	}



}


public abstract class Vehicle {
	private String colour;
	private String name;
	private String serialNumber;
	private int model;
	private int price;
	private int direction;
	private double speed;
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
		setDirection(0);
		setSpeed(0);
	}
	
	/** abstract methods */
	public abstract void turnLeft(int degrees);
	public abstract void turnRight(int degrees);
	
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
		return serialNumber;
	}

	public void setSerialNr(String serialNumber) {
		this.serialNumber = serialNumber;
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
	
	/** toString method */
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed());
	}

}

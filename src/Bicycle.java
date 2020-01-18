
public class Bicycle extends Vehicle {
	private int gears;
	java.util.Calendar productionDate;
	
	public Bicycle() {};
	
	public Bicycle(String name, String colour, int price,
			int model, String serialNumber,
			 int gears, int direction) {
		setColour(colour);
		setName(name);
		setSerialNumber(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setGears(gears);
		productionDate = new java.util.GregorianCalendar();
		setSpeed(0);
	}
	
	@Override
	public void setAllFields() {
		input = new java.util.Scanner(System.in);
		System.out.println("Input bicycle data: ");
		System.out.print("Name: ");
		setName(input.next());
		System.out.print("\nColour: ");
		setColour(input.next());
		System.out.print("\nPrice: ");
		setPrice(input.nextInt());
		System.out.print("\nModel: ");
		setModel(input.nextInt());
		System.out.print("\nSerial #: ");
		setSerialNumber(input.next());
		System.out.print("\nGears: ");
		setGears(input.nextInt());
		setDirection(0);
		setSpeed(0);
	}
	
	@Override
	public void turnRight(int degrees) {
		System.out.printf("%nBicycle turned %d degrees to "
				+ "right %n", degrees);
	}
	
	
	@Override
	public void turnLeft(int degrees) {
		System.out.printf("%nBicycle turned %d degrees to "
				+ "left %n", degrees);
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public java.util.Calendar getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(java.util.Calendar productionDate) {
		this.productionDate = productionDate;
	}
	
	@Override
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f"
				+ "%nGears: %d %nProductionDate %tF", getName(), 
				getSerialNumber(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed(), getGears(),
				getProductionDate());
	}
	
}


import java.util.Calendar;

public class Bicycle extends Vehicle {
	private int gears;
	java.util.Calendar productionDate;
	
	public Bicycle() {};
	
	public Bicycle(String name, String colour, int price,
			int model, String serialNumber,
			 int gears, int direction) {
		setColour(colour);
		setName(name);
		setSerialNr(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setGears(gears);
		productionDate = new java.util.GregorianCalendar();
		setBuyingDate(new java.util.GregorianCalendar());
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
		setSerialNr(input.next());
		System.out.print("\nGears: ");
		setGears(input.nextInt());
		setDirection(0);
		setSpeed(0);
	}
	
	/** turn left and right */
	@Override
	public void turnRight(int degrees) {
		System.out.printf("%nBicycle turned %d degrees to "
				+ "right %n", degrees);
	}
	
	
	@Override
	public void turnLeft(int degrees) {
		System.out.printf("%nBicycle turned %d degrees to "
				+ "left %n", degrees);
	} /** end turn left and right */
	
	@Override /** read Data */
	public void readData(java.util.Scanner in) {
		in.useDelimiter(",");
		setName(in.next());
		setSerialNr(in.next());
		setColour(in.next());
		setModel(in.nextInt());
		setPrice(in.nextInt());
		setDirection(in.nextInt());
		setSpeed(in.nextDouble());
		setGears(in.nextInt());
		setBuyingDate(new java.util.GregorianCalendar(in.nextInt(),
				in.nextInt(), in.nextInt()));
		setProductionDate(new java.util.GregorianCalendar(in.nextInt(),
				in.nextInt(), in.nextInt()));
	    System.out.println("\nVehicle read from file: ");
	    System.out.println(this);
	}
	
	
	@Override /** Write Data */
	public void writeData(java.io.PrintWriter out) {
	    try {
	    // Write formatted output to the file
	    out.print(this.getClass().getName() + ",");
	    out.print(getName() + ",");
	    out.print(getSerialNr() + ",");
	    out.print(getColour() + ",");
		out.print(getModel() + ",");
		out.print(getPrice() + ",");
		out.print(getDirection() + ",");
		out.print(getSpeed() + ",");
		out.print(getGears() + ",");
		out.print((getBuyingDate()).get(Calendar.DAY_OF_MONTH) + ",");
		out.print((getBuyingDate()).get(Calendar.MONTH) + ",");
		out.print((getBuyingDate()).get(Calendar.YEAR) + ",");
		out.print(productionDate.get(Calendar.DAY_OF_MONTH) + ",");
		out.print(productionDate.get(Calendar.MONTH) + ",");
		out.print(productionDate.get(Calendar.YEAR) + ",");
	    }
	    catch (Exception e) {System.exit(0);}
	    
	    System.out.println("\nVehicle written to file: ");
	    System.out.println(this);
	}

	@Override  /** accelerate */
	public void accelerate(double factor) {
		if (this.getSpeed() == 0) {
			if ((0.3 * factor) > super.MAX_SPEED_BIKE) {
				this.setSpeed(super.MAX_SPEED_BIKE);
			}
			else this.setSpeed((0.3 * factor));
		}
		else if ((this.getSpeed() * 0.5 * factor) 
				> super.MAX_SPEED_BIKE) {
			this.setSpeed(super.MAX_SPEED_BIKE);
		}
		else {
			this.setSpeed((this.getSpeed() * 0.5 * factor));
		}
		System.out.printf("Bicycle accelerated to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}
	
	/** Breaks */
	@Override
	public void breaks(double factor) {
		this.setSpeed((this.getSpeed() / (factor * 0.5)));
		System.out.printf("Bicycle slowed down to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}
	
	/** getters and setters */
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
	/** end getters and setters */
	
	@Override
	public Object clone() {
        Bicycle cloned = (Bicycle)super.clone();
        cloned.productionDate = (java.util.Calendar)productionDate.clone();
        return cloned;
	}
	
	
	@Override
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f"
				+ "%nGears: %d %nProductionDate %tF", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed(), getGears(),
				getProductionDate());
	}
	
}


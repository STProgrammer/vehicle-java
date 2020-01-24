public class Car extends Vehicle {
	private int power;
	java.util.Calendar productionDate;
	
	public Car() {};
	
	public Car(String name, String colour, int price,
			int model, String serialNumber,
			 int power, int direction) {
		setColour(colour);
		setName(name);
		setSerialNr(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setPower(power);
		setProductionDate(new java.util.GregorianCalendar());
		setBuyingDate(new java.util.GregorianCalendar());
		setSpeed(0);
	}
	
	@Override
	public void setAllFields() {
		input = new java.util.Scanner(System.in);
		System.out.println("Input car data: ");
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
		System.out.print("\nPower: ");
		setPower(input.nextInt());
		setProductionDate(new java.util.GregorianCalendar());
		setBuyingDate(new java.util.GregorianCalendar());
		setDirection(0);
		setSpeed(0);
	}
	
	/** turn left and right */
	
	@Override
	public void turnRight(int degrees) {
		if (degrees <= 0 || degrees >= 360) {
			return;
		}
		int direction = getDirection();
		direction += degrees;
		if (direction > 360) { direction -= 360; }
		if (direction < 0) { direction += 360; }
		setDirection(direction);
	}
	
	
	@Override
	public void turnLeft(int degrees) {
		if (degrees <= 0 || degrees >= 360) {
			return;
		}
		int direction = getDirection();
		direction -= degrees;
		if (direction > 360) { direction -= 360; }
		if (direction < 0) { direction += 360; }
		setDirection(direction);
	}
	
	/** end turn left and right*/
	
	@Override  /** accelerate */
	public void accelerate(double factor) {
		if (this.getSpeed() == 0) {
			if ((0.5 * factor) > super.MAX_SPEED_CAR) {
				this.setSpeed(super.MAX_SPEED_CAR);
			}
			else this.setSpeed((0.5 * factor));
		}
		else if ((this.getSpeed() * factor) > super.MAX_SPEED_CAR) {
			this.setSpeed(super.MAX_SPEED_CAR);
		}
		else {
			this.setSpeed((this.getSpeed() * factor));
		}
		System.out.printf("Car accelerated to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}
	
	/** Breaks */
	@Override
	public void breaks(double factor) {
		this.setSpeed((this.getSpeed() / factor));
		System.out.printf("Car slowed down to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}

	/** getters and setters */
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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
        Car cloned = (Car)super.clone();
        cloned.productionDate = 
        		(java.util.Calendar)productionDate.clone();
        return cloned;
	}
	
	@Override
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f"
				+ "%nPower: %d %nProductionDate %tF", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed(), getPower(),
				getProductionDate());
	}
	
}


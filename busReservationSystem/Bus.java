package busReservationSystem;

public class Bus {
	
	private int BusNumber;
	
	private boolean AC ;
	
	private int capacity ;
	
	private String driverName;
	
	private String from;
	
	private String to;
	
	private int duration;
	
	public Bus(int busNumber,boolean ac,int capacity) {
		this.AC=ac;
		this.BusNumber=busNumber;
		this.capacity=capacity;
	}
	
	public Bus(int busNumber, boolean ac, int capacity,String from,String to,String driverName,int duration) {
		this.AC = ac;
		this.BusNumber = busNumber;
		this.capacity = capacity;
		this.from= from;
		this.to = to;
		this.driverName=driverName;
		this.duration=duration;
	}
	
	
	
	public int getBusNumber() {
		return BusNumber;
	}
	
	
	public boolean isAC() {
		return AC;
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void info() {

		System.out.println("Bus no "+ this.getBusNumber() + ( this.isAC()?" A/C Present " : " A/C Not Present ") + "Bus Capacity "+this.getCapacity());
		System.out.println("Bus Driver " + this.driverName + ": Starts From : " + this.from + " ends At : " + this.to + " in " + this.duration + " min;");
		System.out.println();		
	}
	
	public void filterByDestination(String start,String destination) {
		
		if( start.toLowerCase().equals(from.toLowerCase()) 
				&& destination.toLowerCase().equals(to.toLowerCase()))
		{
			System.out.println("Bus Number " + this.BusNumber +" Start from " 
						+ this.from +" and Ends "+this.to );
		}
		return;	
	}
}

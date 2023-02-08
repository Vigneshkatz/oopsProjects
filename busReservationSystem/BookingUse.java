package busReservationSystem;

import java.util.*;

public class BookingUse {

	public static void main(String[] args) {
		
		ArrayList<Bus> buses = new ArrayList<Bus>();
		
		buses.add(new Bus(1,true,5));
		buses.get(0).setDriverName("Vignesh");
		buses.get(0).setDuration(240);
		buses.get(0).setFrom("Krishnagiri");
		buses.get(0).setTo("Chennai");
		
		buses.add(new Bus(2,false,2));
		buses.get(1).setDriverName("Vinoth");
		buses.get(1).setDuration(150);
		buses.get(1).setFrom("Krishnagiri");
		buses.get(1).setTo("Erode");
				
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		busInfo(buses);
		
		System.out.println("Enter 1 For booking; 2 For Cancellation; 3 For Bus information; 4 For Current Booking Information; 5 to Add Bus Details");
		
		Scanner s = new Scanner(System.in);	
		
		int status = s.nextInt();
		
		while(status <= 5 && status >0)
		{
			switch(status)
			{
			case 1:
				bookings(bookings,buses);
				break;
			case 2:
				cancel(bookings);
				break;
			case 3:
				busInfo(buses);
				break;
			case 4:
				bookingInfo(bookings);
				break;	
			
			case 5:
				addBus(buses);
				break;
			}
			System.out.println();
			System.out.println("Enter 1 For booking; 2 For Cancellation; 3 For Bus information; 4 For Current Booking Information;");
			status = s.nextInt();
			
		}
	
	}

	private static void addBus(ArrayList<Bus> buses) {

		Scanner s = new Scanner(System.in);
		int status =1;
		while(status == 1) 
		{
		System.out.println("Enter bus number");
		int busNumber = s.nextInt();
		
		System.out.println("Enter bus capacity");
		int capacity = s.nextInt();
		
		System.out.println("Enter A/C true / false");
		boolean ac = s.nextBoolean();
		
		System.out.println("Enter stating point");
		String start = s.next();
		
		System.out.println("Enter ending point");
		String end = s.next();
		
		System.out.println("Enter driver Name");
		String driverName = s.next();
		
		System.out.println("Enter duration");
		int duration = s.nextInt();		
		
		Bus b = new Bus(busNumber,ac,capacity,start,end,driverName,duration);
		buses.add(b);
		b.info();
		System.out.println("To add more enter 1 else 2");
		status = s.nextInt();
		}
	}

	
	private static void bookings(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		Scanner s = new Scanner(System.in);
		int status =1;
		while(status == 1)
		{
			System.out.println();
			
			if(status == 1)
			{
				Booking book = new Booking();
				if(book.isAvailable(bookings,buses))
				{
					System.out.println("Booking confirmed "+ "Your booking number "+book.getbookingNumber());
					bookings.add(book);
					System.out.println();
				
				}else {
					System.out.println("Oops! Booking not available for bus number "+book.getBusNo()+" On "+book.getDate());
				}
				
			}
			System.out.println("Enter 1 to Book and 2 to Exit");
			status = s.nextInt();
		}
		System.out.println("=====================================================================");
		
	}

	private static void bookingInfo(ArrayList<Booking> bookings) {
		for(Booking b:bookings)
		{
			b.info();
		}
		System.out.println("=====================================================================");
		
	}
	
	private static void cancel(ArrayList<Booking> bookings) {

		Scanner s = new Scanner(System.in);
		int cancel = 1;
		while(cancel == 1)
		{
			System.out.println("Enter booking number and bus number");
			int bookingNumber = s.nextInt();
			int busNumber = s.nextInt();
			cancelBooking(bookings,busNumber,bookingNumber);
			System.out.println("To cancel more booking enter 1 Or 2 to exit");
			cancel = s.nextInt();
		}
		System.out.println("=====================================================================");
		
	}
	
	private static void cancelBooking(ArrayList<Booking> bookings, int busNumber, int bookingNumber) {
		
		for(int i = 0; i < bookings.size();i++)
		{
			if(bookings.get(i).getbookingNumber() == bookingNumber && bookings.get(i).getBusNo() == busNumber )
			{
				System.out.println("Cancellation sucessfull");
				bookings.remove(i);
			}
		}
		System.out.println("=====================================================================");
		
	}
	private static void busInfo(ArrayList<Bus> bus) {
		for(Bus b:bus)
		{
			b.info();
		}
		System.out.println("=====================================================================");
		
	}

}

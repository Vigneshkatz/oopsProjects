package busReservationSystem;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.*;

public class Booking {
	
	private int busNo;
	
	private String name;
	
	private Date date;
	
	private int bookingNumber = (int) (busNo*1000+Math.round(Math.random()*999));
	
	public Booking() {
//	get bus number	
		System.out.println("Enter bus number");
		
		Scanner s = new Scanner(System.in);
		
		int n=0;
        
		boolean flag;
        
		do
		{
			try
			{			
			n=s.nextInt();
			
			flag=false;
			}
			catch(Exception e)
			{
			
				System.out.println("Enter only integer value.."+e);
				
				flag=true;
			
			}
		}
		while(flag);
		
		this.busNo = n;

		//	get name
		System.out.println("Enter passenger name");
		
		this.name=s.next();
		
		try {
			
			System.out.println("Enter travel date as day/month/year");
			
			
			this.date=new SimpleDateFormat("dd/MM/yyyy").parse(s.next());
		} 
		
		catch (ParseException e) {
		
			e.printStackTrace();
		}  
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getbookingNumber() {
		return this.bookingNumber;
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity =0;
		for(Bus bus:buses)
		{
			if(bus.getBusNumber() == this.busNo)
			{
				capacity = bus.getCapacity();
			}
		}
		int booked = 0;
		for(Booking book:bookings)
		{
			if(book.busNo == this.busNo && book.date.equals(this.date))
			{
				booked++;
			}
		
		}
		return booked < capacity ? true : false;
	}	
	
	public void info() {
		System.out.println("Booking Number "+this.bookingNumber+" Passenger Name "+ this.name);
	}
}

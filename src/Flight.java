
public class Flight implements Comparable<Object> {
	protected String Number;
	protected String Type;
	protected String Destination;
	protected int price_per_ticket;
	protected int purchasedTickets;
	
	public Flight(){
		this.Number="";
		this.Type="";
		this.Destination="";
		this.price_per_ticket=0;
	}
	public Flight(String Number,String Type, String Destination, int price_per_ticket ){
		this.Number=Number;
		this.Type=Type;
		this.Destination=Destination;
		this.price_per_ticket=price_per_ticket;
	}
/*	public String toString(){
		
		return (Number+" "+Type+" "+Destination+" "+price_per_ticket);*/
	
	
	public int compareTo( Object other ){

		if( purchasedTickets < ((Flight)other).purchasedTickets )
			return 1;
		if( purchasedTickets > ((Flight)other).purchasedTickets )
			return -1;
		return 0;
	}
	public String toString(){
		
		return (Number);
		
	}
}

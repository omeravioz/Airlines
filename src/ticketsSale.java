
public class ticketsSale {
	protected String Flight_Number;
	protected int customer_ID;
	protected int Employee_ID;
	protected int Number_Of_Tickets;
	protected String Site;
	
	public ticketsSale(){
		this.Flight_Number="";
		this.customer_ID=0;
		this.Employee_ID=0;
		this.Number_Of_Tickets=0;
		this.Site="";
	}
	public ticketsSale(String Flight_Number,int customer_ID,int Employee_ID, int Number_Of_Tickets, String Site ){
		this.Flight_Number=Flight_Number;
		this.customer_ID=customer_ID;
		this.Employee_ID=Employee_ID;
		this.Number_Of_Tickets=Number_Of_Tickets;
		this.Site=Site;
	}

	public String toString(){
		
		return (Flight_Number+" "+customer_ID+" "+Employee_ID+" "+Number_Of_Tickets+" "+Site);
	}
}

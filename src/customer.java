import java.util.Vector;

public class customer implements Comparable<Object> {
	
	protected String name;
	protected int Id;
	protected int age;
	protected String Gender;
	protected String Employee_ID;
	protected int purchasedTickets;
	
	public customer (){
		this.name="";
		this.Id=0;
		this.age=0;
		this.Gender="";
		this.Employee_ID="";
		
		
	}
	public customer (int Id,String name, int age,String Gender, String Employee_ID )throws  ImpossibleGender{
		this.name=name;
		this.Id=Id;
		this.age=age;
		if(!Gender.equals("f")&&!Gender.equals("m"))
			throw new ImpossibleGender();
		this.Gender=Gender;
		this.Employee_ID=Employee_ID;
	
	
	}
/*	public String toString(){
		
		return (Id+" "+name+" "+age+" "+Gender+" "+Employee_ID);
		
	}*/
	public String toString(){
		
		return ("Name: "+name+";age: "+age+";gender: "+Gender+".");
	}
	public int compareTo( Object other ){

		if( purchasedTickets < ((customer)other).purchasedTickets )
			return 1;
		if( purchasedTickets > ((customer)other).purchasedTickets )
			return -1;
		return 0;
	}
	
}

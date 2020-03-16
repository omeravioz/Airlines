import java.util.Vector;
public class Marketer extends Employee  {
	protected String phone; 
	public Vector<customer> recommendcustomer= new Vector() ;
	public Vector<customer> regiteredcustomer = new Vector();
	public Vector<ticketsSale> soldTo= new Vector();
	public Marketer(){

	}

	public Marketer(int Id,String name, int age, String phone  ) throws ImpossiblePhoneNumber{
		this.name=name;
		this.Id=Id;
		this.age=age;
		if(phone.charAt(0)!='0'||phone.length()!=10)
			throw new ImpossiblePhoneNumber();
		this.phone=phone;
		baseSalary=0;																			

	}

		public String toString(){

		return (Id+" "+name+" "+age+" "+phone+" "+salary);}


	public void SalaryEvents(){
		
		regiteredcustomer();
		soldTo();

	}

	public void regiteredcustomer(){
		regiteredcustomer.clear();
		for(int i=0;i<Airline.customerList.size();i++)
			if(Integer.parseInt(Airline.customerList.get(i).Employee_ID)==Id)
				regiteredcustomer.addElement(Airline.customerList.get(i));
			
	}
	public void soldTo(){
		soldTo.clear();
		for(int i=0;i<Airline.ticketsSalesList.size();i++){	
			if(Airline.ticketsSalesList.get(i).Employee_ID==Id){
				soldTo.addElement(Airline.ticketsSalesList.get(i));

			}		
		}
	}
	public void calculatesalary(){ 
		salary= (recommendcustomer.size()*2)+(regiteredcustomer.size()*20)+(soldTo.size()*15);




	}
}

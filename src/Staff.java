import java.util.Vector;

public class Staff extends Employee  {
	protected String profession;
	protected double bounsRate;

	public Vector<Employee> friendsList=new Vector();

	public Staff(int Id,String profession,String name, int age, double bounsRate ){
		this.name=name;
		this.Id=Id;
		this.age=age;
		this.profession=profession;
		this.bounsRate=bounsRate;
		if(profession.equals("Pilot"))
			baseSalary=7500;
		else if(profession.equals("Flight Attendant"))
			baseSalary=3500;
		else
			baseSalary=5500; //security

		salary=baseSalary;

	}

	public Staff(){
		this.name="";
		this.Id=0;
		this.age=0;
		this.profession="";
	}
	public Staff(String name,int Id, int age,String profession){
		this.name=name;
		this.Id=Id;
		this.age=age;
		this.profession=profession;
	}
/*	public String toString(){

		return (Id+" "+profession+" "+name+" "+age+" "+bounsRate);
		public int salary(){*/
	
	public void SalaryEvents(){	
		friendsList.clear();
		for(int i=0;i<Airline.employeesList.size();i++){
			if(Airline.employeesList.get(i).joinedBy==Id){
				friendsList.addElement(Airline.employeesList.get(i));
			}
		}
	}
	public void calculatesalary(){ 	
		for(int i=0;i<friendsList.size();i++){
				salary=baseSalary+bounsRate*friendsList.get(i).baseSalary;		
		}	
	}
	
	

}


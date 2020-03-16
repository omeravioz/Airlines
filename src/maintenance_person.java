import java.util.Vector;

public class maintenance_person extends Employee  {

	protected double bounsRate;

	public Vector<Employee> friendsList=new Vector();

	public maintenance_person(int Id,String name, int age, double bounsRate){
		this.name=name;
		this.Id=Id;
		this.age=age;
		this.bounsRate=bounsRate;
		this.baseSalary=2500;
		salary=baseSalary;
	

	}
/*	public String toString(){

		return (Id+" "+name+" "+age+" "+bounsRate+" "+ salary);*/
	
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

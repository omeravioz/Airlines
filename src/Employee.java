import java.util.Vector;

abstract public class  Employee implements Comparable<Object>  {
	
	protected String name;
	protected int Id;
	protected int age;
	protected double salary;
	protected int baseSalary;
	protected int joinedBy;
	
	
	
	public Employee(){
		this.name="";
		this.Id=0;
		this.age=0;
		

	}
	public Employee(int Id,String name, int age ){
		this.name=name;
		this.Id=Id;
		this.age=age;

	}
	public Employee(int Id,String name, int age,int joinedBy  ){
		this.name=name;
		this.Id=Id;
		this.age=age;
		this.joinedBy=joinedBy;
	}
	public int compareTo( Object other ){

		if( salary < ((Employee)other).salary )
			return 1;
		if( salary > ((Employee)other).salary )
			return -1;
		return 0;
	}

	abstract public void SalaryEvents();
	abstract public void calculatesalary();
	public String toString(){

		return ("Name:"+name+";"+"age: "+age+"."+salary);
	}

}

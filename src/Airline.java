import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
public class Airline {
	public String Flights;
	public String employees;
	public String customers;
	public String ticketsSales;
	static Vector <Employee> employeesList= new Vector <Employee>();
	static Vector <Flight> FlightsList= new Vector <Flight>();
	static Vector <customer> customerList= new Vector <customer>();
	static Vector <ticketsSale> ticketsSalesList= new Vector <ticketsSale>();


	public Airline (String flights, String employees, String customers , String ticketsSales){
		Read(flights);
		Read(employees);
		Read(customers);
		Read(ticketsSales);
		setEmployeesSalaryEvents();
		

	}
	public static void main(String[] args) {
		Read("Flights.txt");
		Read("Employees.txt");
		Read("Customers.txt");
		Read("TicketSales.txt");
		setEmployeesSalaryEvents();
/*		employeesList.get(2).joinedBy=1;
		setEmployeesSalaryEvents();
		System.out.println(employeesList.get(0));*/
		System.out.println(getOnlineProportion());

				
		setEmployeesSalaryEvents();
		getBalance();

		/*	printAgeReport("Las Vegas");*/
		/*getBalance();*/

			int[]array=new int[]{1,2,3,4};
		printPotentialCustomersDetails(array);


		



/*				for(int i=0;i<employeesList.size();i++)
			System.out.println(employeesList.get(i).salary);*/


	}

	public static void setEmployeesSalaryEvents(){
		for(int i=0;i<employeesList.size();i++){
			setSalaryEventsToEmployee(employeesList.get(i).Id);
		}
		updateSalary();
	}
	public static void setSalaryEventsToEmployee(int employeeID){
		for(int i=0;i<employeesList.size();i++)
			if(employeeID==employeesList.get(i).Id)
				employeesList.get(i).SalaryEvents();



	}
	public static void printCustomerPastActivity(int customerID){

		System.out.println("Customer name: "+getcustomerName(customerID).name);
		System.out.println("Flight list:");
		int Expenses=CustomerActivity(customerID);
		System.out.println("the Total amount issued by the customer is: "+Expenses);

	}
	public static void  printPotentialCustomersDetails(int[] CustomersIDs){
		int counter=1;
		bubbleSort(CustomersIDs);
		System.out.println("Customer’s potential:");
		for(int i=0; i <CustomersIDs.length ; i++){
			System.out.println("Rank –"+counter+"."+getcustomerName(CustomersIDs[i]).name);
			counter++;
		}
	}

	public static void printAgeReport(String a){
		int x = 0,y=0,z=0,t=0,s=0;
		String Flightnumber=getFlightnumber(a);
		Vector<Integer> PepoleId=getPepoleId(Flightnumber);
		for(int i=0;i<PepoleId.size();i++){
			int temp=getage(PepoleId.get(i));
			if(temp>=0&&temp<=15)
				x++;
			if(temp>=16&&temp<=21)
				y++;
			if(temp>=22&&temp<=30)
				z++;
			if(temp>=31&&temp<=45)
				t++;
			if(temp>=46&&temp<=85)
				s++;
		}
		int size=PepoleId.size();

		System.out.println("Destination:"+ a+"\n"+"0-15:"+(x*100/size)+"%"+"\n"+"16-21:"+(y*100/size)+
				"%"+"\n"+"22-30:"+(z*100/size)+"%"+"\n"+"31-45:"+(t*100/size)+"%"+"\n"+"45-85:"+(s*100/size)+"%");

	}
	public static double getOnlineProportion(){
		int size=ticketsSalesList.size();
		double counter=0.0;
		for(int i=0;i<size;i++)
			if(ticketsSalesList.get(i).Employee_ID==0)
				counter++;
		double ans=(counter/size);
		return ans;

	}
	public static double getBalance(){
		double Balance=incomes()-expenses();
		System.out.println(Balance);
		return Balance;
	}

	public static void airlineReport(){
		flightticketsum();
		customerticketsum();
		employListSort();
		FlightsListSort();
		customerListSort();

	}

	public static boolean recommend(int employeeID, int customerID){
		Marketer mark=getMarketerName(employeeID);
		customer plony=getcustomerName(customerID);
		
		FlightsList.sort(null);
		for(int i=0;i<10;i++)
			System.out.println(FlightsList.get(i));
			if(mark==null||plony==null)
				return false;
			else{		
				for(int i=0;i<10;i++)
					System.out.println(FlightsList.get(i).Destination);
				mark.recommendcustomer.addElement(plony);
				return true;
			
		}

	}


	
	
	public static void Read(String type){	

		try{
			FileReader inputFile = new FileReader(type); //Create object of FileReader


			BufferedReader bufferReader = new BufferedReader(inputFile);  //Instantiate the BufferedReader Class

			//Variable to hold the one line data
			String line;
			// Read file line by line and print on the console

			while ((line = bufferReader.readLine()) != null)   {
				String[] splitStr = line.split("\t+");
				if(type.equals("Employees.txt")){
					readEmployees(splitStr);

				}
				if(type.equals("Customers.txt")){
					readCustomers(splitStr);

				}
				if(type.equals("Flights.txt")){	
					readFlights(splitStr);

				}
				if(type.equals("TicketSales.txt")){
					
					readticketsSale(splitStr);

				}
				removeIllegalTicketsSale();

			}

			//Close the buffer reader

			bufferReader.close();
		}catch(Exception e){
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}
	}
	public static void readEmployees(String[] splitStr ) throws  ImpossiblePhoneNumber{

		if(!splitStr[0].equals("ID")){


			if(splitStr[1].equals("Maintenance")){
				maintenance_person obj=new maintenance_person(Integer.parseInt(splitStr[0]), splitStr[2], Integer.parseInt(splitStr[3])
						, Double.parseDouble(splitStr[4]));
				employeesList.addElement(obj);

			}

			else if(splitStr[1].equals("Marketing")){
				try{
					Marketer obj=new Marketer(Integer.parseInt(splitStr[0]), splitStr[2], Integer.parseInt(splitStr[3])
							, splitStr[4]);
					employeesList.addElement(obj);
				}catch(ImpossiblePhoneNumber e){
					System.out.println("phone number of id: "+splitStr[0]+" incorrect" );

				}
			}
			else{

				Staff obj=new Staff(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], Integer.parseInt(splitStr[3])
						, Double.parseDouble(splitStr[4]));
				employeesList.addElement(obj);
			}

		}

	}
	public static void readCustomers(String[] splitStr) throws  ImpossibleGender{
		if(!splitStr[0].equals("ID")){
			try{
			customer obj=new customer(Integer.parseInt(splitStr[0]), splitStr[1],Integer.parseInt(splitStr[2]),splitStr[3]
					,splitStr[4]);
			customerList.addElement(obj);
			}catch(ImpossibleGender e){
				System.out.println("gender of id:"+splitStr[0]+" incorrect");
			}
			
		}
	}
	public static void readFlights(String[] splitStr ){

		if(!splitStr[0].equals("Number")){

			Flight obj=new Flight(splitStr[0], splitStr[1],splitStr[2],Integer.parseInt(splitStr[3]));
			FlightsList.addElement(obj);

		}		

	}
	public static void readticketsSale(String[] splitStr){
		ticketsSale obj;
		if(!splitStr[0].equals("Flight Number")){

			if(splitStr[3].contains("www")){
				obj=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),0,Integer.parseInt(splitStr[2])
						,splitStr[3]);
			}
			else{
				obj=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),Integer.parseInt(splitStr[2])
						,Integer.parseInt(splitStr[3])
						,"");
			}
			ticketsSalesList.addElement(obj);
		}


	}
	public static int priceOfTicket(String Ticketnumber){
		for(int i=0;i<FlightsList.size();i++){
			if(FlightsList.get(i).Number.equals(Ticketnumber))
				return (FlightsList.get(i).price_per_ticket);
		}
		return 0;

	}
	public static int incomes(){
		int income=0;
		for(int i=0;i<ticketsSalesList.size();i++)
			income+=(priceOfTicket(ticketsSalesList.get(i).Flight_Number)
					*(ticketsSalesList.get(i).Number_Of_Tickets));
		return income;


	}
	public static double expenses(){
		double expenses=0.0;
		for(int i=0;i<employeesList.size();i++)
			expenses+=employeesList.get(i).salary;
		return expenses;

	}
	public static int PotentialCustomerRate(int id){
		int ans=0;
		for(int i=0;i<ticketsSalesList.size();i++){
			if(ticketsSalesList.get(i).customer_ID==id)
				ans+=(ticketsSalesList.get(i).Number_Of_Tickets)*(priceOfTicket(ticketsSalesList.get(i).Flight_Number));
		}
		return ans;
	}
	public static customer getcustomerName(int id){

		for(int i=0;i<customerList.size();i++)
			if(customerList.get(i).Id==id)
				return customerList.get(i);
		return null;

	}
	public static Marketer getMarketerName(int id){

		for(int i=0;i<employeesList.size();i++)
			if(employeesList.get(i).Id==id&&employeesList.get(i) instanceof Marketer)
				return (Marketer)employeesList.get(i);
		return null;

	}

	public static String getFlightnumber(String Destination){
		for(int i=0;i<FlightsList.size();i++)
			if(FlightsList.get(i).Destination.equals(Destination))
				return FlightsList.get(i).Number;
		return "";

	}
	public static Vector getPepoleId(String flightNumber){
		Vector <Integer> PepoleId= new Vector <Integer>();
		for(int i=0;i<ticketsSalesList.size();i++)
			if(ticketsSalesList.get(i).Flight_Number.equals(flightNumber))
				PepoleId.addElement(ticketsSalesList.get(i).customer_ID);
		return PepoleId;


	}
	public static int getage(int id){

		for(int i=0;i<customerList.size();i++)
			if(customerList.get(i).Id==id)
				return customerList.get(i).age;
		return -1;


	}
	public static int CustomerActivity(int Id){
		int counter=1;
		int Expenses=0;
		for(int i=0;i<ticketsSalesList.size();i++){
			if(ticketsSalesList.get(i).customer_ID==Id){
				String flightnumber=ticketsSalesList.get(i).Flight_Number;

				System.out.println("Flight "+counter+":"+flightnumber
						+" ,the price is: "+priceOfTicket(flightnumber));
				Expenses+=priceOfTicket(flightnumber)*ticketsSalesList.get(i).Number_Of_Tickets;
				counter++;
			}
		}
		return Expenses;

	}
	public static void bubbleSort(int[] CustomersIDs){
		int temp=0,n=CustomersIDs.length;
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(PotentialCustomerRate(CustomersIDs[j-1]) < PotentialCustomerRate(CustomersIDs[j])){  
					//swap elements  
					temp = CustomersIDs[j-1];  
					CustomersIDs[j-1] = CustomersIDs[j];  
					CustomersIDs[j] = temp;  

				}  
			}  
		}	
	}


	public static void updateSalary(){
		for(int i=0;i<employeesList.size();i++){
	
				employeesList.get(i).calculatesalary();	

		}
	}
	
	public static void flightticketsum(){

		for(int i=0;i<FlightsList.size();i++){
			for(int j=0;j<ticketsSalesList.size();j++){
				if(FlightsList.get(i).Number.equals(ticketsSalesList.get(j).Flight_Number))
					FlightsList.get(i).purchasedTickets+=ticketsSalesList.get(j).Number_Of_Tickets;
			}
		}
	}
	
	public static void customerticketsum(){
		for(int i=0;i<customerList.size();i++){
			for(int j=0;j<ticketsSalesList.size();j++){
				if(customerList.get(i).Id==ticketsSalesList.get(j).customer_ID)
					customerList.get(i).purchasedTickets+=ticketsSalesList.get(j).Number_Of_Tickets;
			}
		}

	}

		public static void employListSort(){
			employeesList.sort(null);
			System.out.println("Airline Report");
			System.out.println("Workers list:");
			for(int i=0;i<employeesList.size();i++)
				System.out.println(employeesList.get(i));
			System.out.println("...............");
			
		}
		public static void FlightsListSort(){
			FlightsList.sort(null);
			System.out.println("Flights list:");
			for(int i=0;i<FlightsList.size();i++)
				System.out.println(FlightsList.get(i));
			System.out.println("...............");
			
		}
		public static void customerListSort(){
			customerList.sort(null);
			System.out.println("Customers list:");
			for(int i=0;i<customerList.size();i++)
				System.out.println(customerList.get(i));
			System.out.println("...............");
			
		}
		public static void removeIllegalTicketsSale(){
			Vector<ticketsSale> temp=new Vector();
			for(ticketsSale e:ticketsSalesList){
				if(getcustomerName(e.customer_ID)==null)
					temp.addElement(e);
			}
			for(ticketsSale m:temp){
				ticketsSalesList.remove(m);
				
			}
			
		}
		
}


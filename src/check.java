import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
public class check {
	static Vector <Employee> employeesList= new Vector <Employee>();
	static Vector <customer> customerList= new Vector <customer>();
	static Vector <Flight> FlightsList= new Vector <Flight>();
	static Vector <ticketsSale> ticketsSalesList= new Vector <ticketsSale>();

	public static void main(String[] args) {
		Read("Flights.txt");
		for(int i=0;i<FlightsList.size();i++)
			System.out.println(FlightsList.get(i).toString());
/*		try{
			String type="TicketSales.txt";
			FileReader inputFile = new FileReader(type); //Create object of FileReader


			BufferedReader bufferReader = new BufferedReader(inputFile);  //Instantiate the BufferedReader Class

			//Variable to hold the one line data
			String line;
			// Read file line by line and print on the console
			Employee obj=new Employee();
			customer obj1=new customer();
			Flight obj2=new Flight();
			ticketsSale obj3=new ticketsSale();
			while ((line = bufferReader.readLine()) != null)   {
				String[] splitStr = line.split("\t+");
				if(type.equals("Employees.txt")){
					if(splitStr[0].equals("ID"))
						continue;
					else{

						if(!splitStr[4].equals(null)){
							obj=new Employee(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], Integer.parseInt(splitStr[3])
									, Double.parseDouble(splitStr[4]), "");

						}
						else{	
							obj=new Employee(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], Integer.parseInt(splitStr[3])
									,0.0, splitStr[4]);
						}
						employeesList.addElement(obj);

					}
				}
				if(type.equals("Customers.txt")){
					if(splitStr[0].equals("ID"))
						continue;
					else{
						obj1=new customer(Integer.parseInt(splitStr[0]), splitStr[1],Integer.parseInt(splitStr[2]),splitStr[3]
								,splitStr[4]);
						System.out.println(splitStr[0]);
						customerList.addElement(obj1);
					}
				}
				if(type.equals("Flights.txt")){	
					if(splitStr[0].equals("Number"))
						continue;
					else{
						obj2=new Flight(splitStr[0], splitStr[1],splitStr[2],Integer.parseInt(splitStr[3]));
						FlightsList.addElement(obj2);

					}		
				}
				if(type.equals("TicketSales.txt")){
					if(splitStr[0].equals("Flight Number"))
						continue;
					else{
						System.out.println(splitStr[3]);
						if(splitStr[3].contains("www")){
							obj3=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),0,Integer.parseInt(splitStr[2])
									,splitStr[3]);
						}
						else{
							obj3=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),Integer.parseInt(splitStr[2]),Integer.parseInt(splitStr[3])
									,"");
						}
						ticketsSalesList.addElement(obj3);
					}
					for(int i=0;i<ticketsSalesList.size();i++)
						System.out.println();
				}


				//Close the buffer reader
			}



			bufferReader.close();
		}catch(Exception e){
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}
	}
}*/
	}
public static void Read(String type){	

	try{
		FileReader inputFile = new FileReader(type); //Create object of FileReader


		BufferedReader bufferReader = new BufferedReader(inputFile);  //Instantiate the BufferedReader Class

		//Variable to hold the one line data
		String line;
		// Read file line by line and print on the console
		Employee obj=new Employee();
		customer obj1=new customer();
		Flight obj2=new Flight();
		ticketsSale obj3=new ticketsSale();
		while ((line = bufferReader.readLine()) != null)   {
			String[] splitStr = line.split("\t+");
			if(type.equals("Employees.txt")){
				readEmployees(splitStr ,obj);

			}
			if(type.equals("Customers.txt")){
				readCustomers(splitStr ,obj1);

			}
			if(type.equals("Flights.txt")){	
				readFlights(splitStr ,obj2);

			}
			if(type.equals("TicketSales.txt")){
				readticketsSale(splitStr ,obj3);

				}

			}

			//Close the buffer reader
		
		bufferReader.close();
	}catch(Exception e){
		System.out.println("Error while reading file line by line:" + e.getMessage());                      
	}
}
public static void readEmployees(String[] splitStr ,Employee obj){

	if(!splitStr[0].equals("ID")){
		
		if(!splitStr[1].equals("Marketing")){
			obj=new Employee(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], Integer.parseInt(splitStr[3])
					, Double.parseDouble(splitStr[4]), "");

		}
		else{	
			obj=new Employee(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], Integer.parseInt(splitStr[3])
					,0.0, splitStr[4]);
		}
		employeesList.addElement(obj);

	}
	
}
public static void readCustomers(String[] splitStr ,customer obj1){
	if(!splitStr[0].equals("ID")){

		obj1=new customer(Integer.parseInt(splitStr[0]), splitStr[1],Integer.parseInt(splitStr[2]),splitStr[3]
				,splitStr[4]);
		customerList.addElement(obj1);
	}
	
	
}
public static void readFlights(String[] splitStr ,Flight obj2){
	
	if(!splitStr[0].equals("Number")){

		obj2=new Flight(splitStr[0], splitStr[1],splitStr[2],Integer.parseInt(splitStr[3]));
		FlightsList.addElement(obj2);

	}		
	
}
public static void readticketsSale(String[] splitStr ,ticketsSale obj3){
	if(!splitStr[0].equals("Flight Number")){

		if(splitStr[3].contains("www")){
			obj3=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),0,Integer.parseInt(splitStr[2])
					,splitStr[3]);
		}
		else{
			obj3=new ticketsSale(splitStr[0],Integer.parseInt(splitStr[1]),Integer.parseInt(splitStr[2]),Integer.parseInt(splitStr[3])
					,"");
		}
	
		ticketsSalesList.addElement(obj3);
	}
}
}

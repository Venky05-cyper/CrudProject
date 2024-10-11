package Package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrudProjectsss {
	Statement st = null;
	String Username;
	Scanner sc = new Scanner(System.in);
	
	CrudProjectsss() throws SQLException {

	       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	       st = con.createStatement();
	       System.out.println("connection established");
	   }
	

	
	void create() throws SQLException{


		Scanner sc = new Scanner(System.in);
		   
		System.out.println("Add Employee Details :");
		System.out.println("Enter Emp Id");
		int Id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Emp Name");
		String name1 = sc.nextLine();
		
		
		String mobile=null;
		boolean num=false;
		while(!num) {
			System.out.println("Enter Emp Mobile Number");
		    mobile = sc.nextLine();
		    String mobileNumberRegex = "^[0-9]{10}$";
            Pattern p=Pattern.compile(mobileNumberRegex);
            Matcher m = p.matcher(mobile);
            if(m.matches()) {
            	System.out.println("Input is valid!");
            	num=true;
            }else {
            	System.out.println("Input is not valid!");
            }
		}
		
	
		String email=null;
		boolean b=false;
		while(!b) {
			System.out.println("Enter Emp Email Id :");
			email = sc.nextLine();
			String usernameRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
			Pattern p = Pattern.compile(usernameRegex);
			Matcher m = p.matcher(email);
			if(m.matches()) {
				System.out.println("Input is valid!");
				b=true;
			}else {
				System.out.println("Input is Not Valid, please enter a valid Gmail address.");
			     
			}
			
		}
		
		
		System.out.println("Enter Emp Salary");
		String salary = sc.nextLine();
		
		System.out.println("Enter Emp Designation");
		String designation = sc.nextLine();
		
		 
		String pass=null;
		boolean tr=false;
		while(!tr) {
			System.out.println("Enter Emp Password");
			pass = sc.nextLine();
			String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,20}$";
	         Pattern p = Pattern.compile(passwordRegex); 
	         Matcher Math=p.matcher(pass);
			if(Math.matches()) {
				System.out.println("Password is valid");
				tr=true;
			}else {
				System.out.println("Password is not valid");
			}
		}
		
		String query = "insert into EmployeeDetail Values ("+Id+",'"+name1+"','"+mobile+"','"+email+"','"+salary+"','"+designation+"','"+pass+"')";
		st.execute(query);
		System.out.println("("+Id+",'"+name1+"','"+mobile+"','"+email+"','"+salary+"','"+designation+"','"+pass+"')");
		System.out.println("Employee Details Added Successfully!");
	}
	
	void retrive() throws SQLException{
		
		   Scanner sc = new Scanner(System.in);

		    System.out.println("Search Employee Details By Id:");
		    System.out.println("1. Id");
		    System.out.println("2. Name");
		    System.out.println("3. All");
		    System.out.print("Enter your choice: ");
		    int choice = sc.nextInt();
		    sc.nextLine();
		    String query = null;
		    switch(choice) {
		    case 1:
		    	System.out.print("Enter Employee ID: ");
	            int id = sc.nextInt();
	            query = "SELECT * FROM EmployeeDetail WHERE id = " + id;
	           st.execute(query);
		    	break;
		    case 2:
		    	System.out.print("Enter Employee Name: ");
		    	String name =sc.nextLine();
		    	query = "SELECT * FROM EmployeeDetail WHERE name = '"+name+"'";
		    	break;
		    case 3:
	            query = "SELECT * FROM EmployeeDetail";
	            System.out.println("All Employee Data!"+'\n');
	            st.execute(query);
		    	break;
		    default:
                System.out.println("Invalid choice");
                return; 	
		    }
		    
		 ResultSet rs = st.executeQuery(query);
		        while (rs.next()) {
		            System.out.println("ID :-"+rs.getInt(1));
		            System.out.println("Name :-"+rs.getString(2));
		            System.out.println("Mobile :-"+rs.getString(3));
		            System.out.println("Emial :-"+rs.getString(4));	
		            System.out.println("Salary :-"+rs.getString(5));
		            System.out.println("Designation :-"+rs.getString(6));
		            System.out.println("Password :-"+rs.getString(7));
		            System.out.println("");
		 
		        }
		
	}
	
	void Update() throws SQLException {
		System.out.println("Want to Update Employee : "+'\n'+"1. Id"+'\n'+"2. Name"+'\n'+"3. Mobile"+'\n'+"4. Email"+'\n'+"5. Salary"+'\n'+"6. Designation"+'\n'+"7. Password"+'\n'+"8. Update All");
        System.out.println("Enter your choice :");
		int choice  = sc.nextInt();
        
        switch(choice) {
        case 1:
        	System.out.println("Enter your Emp old Id :");
        	int oldid=sc.nextInt();
        	System.out.println("Enter your Emp new Id");
        	int newId = sc.nextInt();
        	String query = "Update EmployeeDetail Set id='"+newId+"' Where id="+oldid;
        	st.execute(query);
        	System.out.println("Employee Updated ID :"+newId);
        	break;
        case 2:	
        	System.out.println("Enter Employee Id :");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee new name :");
			String name=sc.nextLine();
			String query0 = "UPDATE EmployeeDetail SET name='"+name+"' WHERE id = "+id;
			st.execute(query0);
			System.out.println("Employee updated name : "+name);
			break;
		case 3:
			
			String mobile=null;
			boolean num=false;
			int id1=0;
			while(!num) {
				System.out.println("Enter Employee Id :");
				id1 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee new mobile no :");
			    mobile=sc.nextLine();
			    String mobileNumberRegex = "^[0-9]{10}$";
	            Pattern p=Pattern.compile(mobileNumberRegex);
	            Matcher m = p.matcher(mobile);
	            if(m.matches()) {
	            	System.out.println("Input is valid!");
	            	num=true;
	            }else {
	            	System.out.println("Input is not valid!");
	            }
			}

			
			String query1 = "UPDATE EmployeeDetail SET mobile='"+mobile+"' WHERE id = "+id1;
			st.execute(query1);
			System.out.println("Employee updated mobile no : "+mobile);
			break;
		case 4:
			String email=null;
			boolean b=false;
			int id2 =0;
			while(!b) {
				System.out.println("Enter Employee Id :");
				id2 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee new email :");
				email=sc.nextLine();
				String usernameRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
				Pattern p = Pattern.compile(usernameRegex);
				Matcher m = p.matcher(email);
				if(m.matches()) {
					System.out.println("Input is valid!");
					b=true;
				}else {
					System.out.println("Input is Not Valid, please enter a valid Gmail address.");
				     
				}
				
			}
			
			
			String query2 = "UPDATE EmployeeDetail SET email='"+email+"' WHERE id = "+id2;
			st.execute(query2);
			System.out.println("Employee updated email : "+email);
			break;
		case 5:
			System.out.println("Enter Employee Id :");
			int id5 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee Updated Salary :");
			String salary=sc.nextLine();
			String query5 = "UPDATE EmployeeDetail SET salary='"+salary+"' WHERE id = "+id5;
			st.execute(query5);
			System.out.println("Employee Updated Salary : "+salary);
			break;
		case 6:
			System.out.println("Enter Employee Id :");
			int id6 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee Updated Designation :");
			String desig=sc.nextLine();
			String query6 = "UPDATE EmployeeDetail SET Designation='"+desig+"' WHERE id = "+id6;
			st.execute(query6);
			System.out.println("Employee Updated Designation : "+desig);
			break;
		case 7:
			System.out.println("Enter Employee Id :");
			int id3 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee new Password :");
			String pass=sc.nextLine();
			String query3 = "UPDATE EmployeeDetail SET Password='"+pass+"' WHERE id = "+id3;
			st.execute(query3);
			System.out.println("Employee updated Password : "+pass);
			break;
		case 8:
			Scanner sc = new Scanner(System.in);
			   
			System.out.println("Enter Employee Id to Update :");

			int Id = sc.nextInt();
	          sc.nextLine();
			System.out.println("Enter Employee Name to Update");
			String name1 = sc.nextLine();
			
			System.out.println("Enter Employee Mobile Number to Update");
			String mobile8 = sc.nextLine();
			
			System.out.println("Enter Employee Email to Update");
			String email8 = sc.nextLine();
			
			System.out.println("Enter Employee Salary to Update");
			String salary8 = sc.nextLine();
			
			System.out.println("Enter Employee Designation to Update");
			String designation = sc.nextLine();
			
			System.out.println("Enter Employee Password to Update");
			String passWord = sc.nextLine();
			
			
			String query8 = "UPDATE EmployeeDetail SET id="+Id+",name='"+name1+"',mobile='"+mobile8+"',email='"+email8+"',salary='"+salary8+"',Designation='"+designation+"',Password='"+passWord+"' WHERE id="+Id;
			st.execute(query8);
			System.out.println("Id: "+Id+" Name: "+name1+" Mobile : "+mobile8+" Email: "+email8+" Salary: "+salary8+" Designation: "+designation+" Password: "+passWord);
			System.out.println("Employee Details Updated Successfully!");

        }
        
	}
	
	void Delete() throws SQLException {
		System.out.println("Enter Id to Delete :");
		int id = sc.nextInt();
		String query = "DELETE FROM EmployeeDetail WHERE id = "+id+"";
		st.execute(query);
		System.out.println("Employee Data Deleted Successfully!");
	}
	
	void EmpRetrive() throws SQLException {
		System.out.println("Enter your Id: ");
		int id = sc.nextInt();
		String query = "SELECT * FROM EmployeeDetail WHERE id="+id+"";
		System.out.println('\n'+"Your Data!"+'\n');
		ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
 
            System.out.println("Id :-"+rs.getInt(1));
 
            System.out.println("Name :-"+rs.getString(2));
 
            System.out.println("Mobile :-"+rs.getString(3));
 
            System.out.println("Emial :-"+rs.getString(4));
            System.out.println("Password :-"+rs.getString(7));
            System.out.println("");
 
        }

	}
	
	void EmpUpdate() throws SQLException {
		System.out.println("Want to Update : "+'\n'+"1. Name"+'\n'+"2. Mobile"+'\n'+"3. Email"+'\n'+"4. Password"+'\n'+"5. Update All");
		System.out.println("Enter your choice :");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter Your Id :");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your new name :");
			String name=sc.nextLine();
			String query = "UPDATE EmployeeDetail SET name='"+name+"' WHERE id = "+id;
			st.execute(query);
			System.out.println("Your updated name : "+name);
			break;
		case 2:
			String mobile=null;
			boolean num=false;
			int id1=0;
			while(!num) {
				System.out.println("Enter Your Id :");
			    id1 = sc.nextInt();
			    sc.nextLine();
				System.out.println("Enter your new mobile no :");
			    mobile=sc.nextLine();
			    String mobileNumberRegex = "^[0-9]{10}$";
	            Pattern p=Pattern.compile(mobileNumberRegex);
	            Matcher m = p.matcher(mobile);
	            if(m.matches()) {
	            	System.out.println("Input is valid!");
	            	num=true;
	            }else {
	            	System.out.println("Input is not valid!");
	            }
			}
			
			
			String query1 = "UPDATE EmployeeDetail SET mobile='"+mobile+"' WHERE id = "+id1;
			st.execute(query1);
			System.out.println("Your updated mobile no : "+mobile);
			break;
		case 3:
			String email=null;
			boolean b=false;
			int id2 =0;
			while(!b) {
				System.out.println("Enter Your Id :");
				id2 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter your new email :");
				email=sc.nextLine();
				String usernameRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
				Pattern p = Pattern.compile(usernameRegex);
				Matcher m = p.matcher(email);
				if(m.matches()) {
					System.out.println("Input is valid!");
					b=true;
				}else {
					System.out.println("Input is Not Valid, please enter a valid Gmail address.");
				     
				}
				
			}


			String query2 = "UPDATE EmployeeDetail SET email='"+email+"' WHERE id = "+id2;
			st.execute(query2);
			System.out.println("Your updated email : "+email);
			break;
		case 4:
			System.out.println("Enter Your Id :");
			int id3 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your new Password :");
			String pass=sc.nextLine();
			String query3 = "UPDATE EmployeeDetail SET Password='"+pass+"' WHERE id = "+id3;
			st.execute(query3);
			System.out.println("Your updated Password : "+pass);
			break;
		case 5:	
			System.out.println("Enter Employee Id to Update :");
			int id5 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Your Name to Update");
			String name1 = sc.nextLine();
			
			System.out.println("Enter Your Mobile Number to Update");
			String mobile5 = sc.nextLine();
			
			System.out.println("Enter Your Email to Update");
			String email5 = sc.nextLine();
			
			System.out.println("Enter Your Password to Update");
			String pass5 = sc.nextLine();
	
			String query5 = "UPDATE EmployeeDetail SET id="+id5+",name='"+name1+"',mobile='"+mobile5+"',email='"+email5+"',Password='"+pass5+"' WHERE id="+id5;
			st.execute(query5);
			System.out.println("Id: "+id5+'\n'+"Name: "+name1+'\n'+"Mobile: "+mobile5+'\n'+"Emil: "+email5+'\n'+"Password: "+pass5);
			
		}
		

	}
	
	void EmpChangePass() throws SQLException{
		System.out.println("Enter your id:");
		int id = sc.nextInt();
		System.out.println("Enter your new password: ");
		String newpass = sc.next();
		sc.nextLine(); 
		
		String query = "UPDATE EmployeeDetail SET Password= '"+newpass+"' WHERE id = "+id;
		st.execute(query);
		System.out.println("Your Update Password :"+newpass);
	}

	public static void main(String[] args) throws SQLException {
		
		CrudProjectsss d= new CrudProjectsss();
		
		
		
		Scanner sc= new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		Statement st = con.createStatement();

		String AdminUsername = "admin";
		String AdminPass="admin123";
		
/*		int EmployeeId = "SELECT * FROM EmployeeDetail WHERE id = ";
	String EmployeePass = "emp123";*/	
		
		System.out.println("Login As:");
		System.out.println("1.Admin");
		System.out.println("2.Employee");
		System.out.println("Choose your selection(1/2):");
		int choice = sc.nextInt();
		String admin = "Yes";
		boolean cont = true;
		switch(choice) {
		case 1:
			System.out.println("Enter your Admin Username :");
			String name = sc.next();
			System.out.println("Enter your Admin Password :");
			String pass = sc.next();
			if(name.equalsIgnoreCase(AdminUsername) && pass.equalsIgnoreCase(AdminPass)) {
				System.out.println("Login Successfull!"+'\n');
				
				while(cont) {
					System.out.println("1. Create");
					System.out.println("2. Retive");
					System.out.println("3. Update");
					System.out.println("4. Delete"+"\n");
					System.out.print("Enter your choice: "+"\n");
				    int choice1 = sc.nextInt();
				    switch(choice1) {
				    case 1:
                          d.create();
				    	break;
				    case 2:
				    	d.retrive();
				    	break;
				    case 3:
				    	d.Update();
				    	break;
				    case 4:
				    	d.Delete();
				    	break;
				    }
				    System.out.println("do you want to cont(Yes/No)?");
					admin = sc.next();
					if(admin.equalsIgnoreCase("yes")) {
						cont=true;
					}else {
						cont=false;
						System.out.println("Completed!");
					}
				}

			}else {
				System.out.println("Incorrect Username or Password");
			}
			break;
		case 2:
			
			System.out.println("Enter your Employee Id :");
			int EmpId = sc.nextInt();		
			sc.nextLine();
			System.out.println("Enter your Employee Password :");
			String EmpPass = sc.next();
			
			String EmpDetail = "SELECT * FROM EmployeeDetail WHERE id = '"+EmpId+"' AND Password = '"+EmpPass+"'";
			 ResultSet rs = st.executeQuery(EmpDetail);
			if(rs.next()) {
				System.out.println("Login Successfull!");
				while(cont) {
					
					System.out.println('\n'+"1. See Data");
					System.out.println("2. Update Data");
					System.out.println("3. Change password");
					System.out.print('\n'+"Enter your choice: "+"\n");
				    int choice1 = sc.nextInt();	
				    switch(choice1) {
				    case 1 :
				    	d.EmpRetrive();
				    	break;
				    case 2 :
				    	d.EmpUpdate();
				    	break;
				    case 3 :
				    	d.EmpChangePass();
				    	break;
				    }
				    System.out.println("do you want to cont(Yes/No)?");
				    admin = sc.next();
                     if(admin.equalsIgnoreCase("yes")) {
                    	 cont=true;
                     }else {
                    	 cont=false;
                     }
				}

			}else {
				System.out.println("Incorrect Employee Id or Password!");
			}	
			
//		default:
////			System.out.println("Incorrect Employee Id or Password");
//			return;	
		}
		
//		if(admin.equalsIgnoreCase("Yes")) {
//			cont =true;
//		}else {
//			cont=false;
//		}
		
		
	}
}

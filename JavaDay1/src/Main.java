import java.util.*;
import java.io.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static final String FILE_NAME = "students.txt";
	public static void main(String[]args) {
		int choice;
		
		do {
			System.out.println("\n----Studen Management----");
			System.out.println("1.Add ");
			System.out.println("2.view");
			System.out.println("3.update");
			System.out.println("4.exit");
			System.out.println("Enten the choice: ");
			
			choice=sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				System.out.println("Exiting");
				break;
				
			default:
				System.out.println("Invalid");
			
			}
		}while(choice!=4);
	}
	
		static void addStudent() {
			try {
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name: ");
		    String name = sc.nextLine();
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			
			FileWriter fw = new FileWriter(FILE_NAME, true);
			fw.write(id + "," + name + "," + age+ "\n");
			fw.close();
			System.out.println("Added successfully");
			
			}catch(Exception e) {
				System.out.println("Error writing file");
			}
		}
		
		static void viewStudent() {
			try {
				BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
				String line;
			
			System.out.println("\nID\tName\tAge");
			while((line = br.readLine()) !=null) {
				String[] data = line.split(",");
				System.out.println(data[0] + "\t "+ data[1] + "\t"+data[2]);
			}br.close();
		} catch (Exception e) {
			System.out.println("File not found");
		}
		}
		
		static void updateStudent() {
			try {
				System.out.println("Enter the student ID to update");
				int updateID = sc.nextInt();
				sc.nextLine();
				
				File oldFile = new File(FILE_NAME);
				File newFile = new File("temp.txt");
				
				BufferedReader br = new BufferedReader(new FileReader(oldFile));
				FileWriter fw = new FileWriter(newFile);
				
				String line;
				boolean found = false;
				
				while((line = br.readLine())!= null) {
					String[] data=line.split(",");
					int id = Integer.parseInt(data[0]);
					
					if(id == updateID) {
						found = true;
						
						System.out.println("Enter the updated name:");
						String name= sc.nextLine();
						
						System.out.println("Enter the updated age: ");
						int age= sc.nextInt();
						
						fw.write(id+","+name+","+","+age+"\n");
						
					}else {
						fw.write(line+"\n");
					}
				}
				
				br.close();
		        fw.close();
		        
		        oldFile.delete();
		        newFile.renameTo(oldFile);
		        
		        if (found) {
		        	System.out.println("Student ID updated");
		        }
		        else {
		        	System.out.println("ID not found");
		        }
		        
			}catch(Exception e) {
		        	System.out.println("update failed");
		        	
		        }
				
				
			}
		}


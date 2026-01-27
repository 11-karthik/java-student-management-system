import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	static ArrayList<Student> students=new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		int choice;
		
		do {
			System.out.println("\n----Studen Management----");
			System.out.println("1.Add ");
			System.out.println("2.view");
			System.out.println("3.delete");
			System.out.println("4. Update");
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
				deleteStudent();
				break;
		    case 4:
                 updateStudent();
                 break;
			case 5:
				System.out.println("Exiting");
				break;
				
			default:
				System.out.println("Invalid");
			
			}
		}while(choice!=5);
	}
		static void addStudent() {
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name: ");
		    String name = sc.nextLine();
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			
			students.add(new Student(id, name, age));
			System.out.println("Added successfully");
			
		}
		
		static void viewStudent() {
			if(students.isEmpty()) {
				System.out.println("no student");
				return;
			}
			System.out.println("\nID\tName\tAge");
			for(Student s : students) {
				System.out.println(s.id + "\t "+ s.name + "\t"+s.age);
			}
		}
		static void deleteStudent() {
		    System.out.print("Enter ID to delete: ");
		    int id = sc.nextInt();

		    boolean found = false;
		    for (Student s : students) {
		        if (s.id == id) {
		            students.remove(s);
		            found = true;
		            System.out.println("Deleted successfully");
		            break;
		        }
		    }

		    if (!found) {
		        System.out.println("Student not found");
		    }
		}
		
		 static void updateStudent() {
		        System.out.print("Enter ID to update: ");
		        int id = sc.nextInt();
		        sc.nextLine();

		        boolean found = false;

		        for (Student s : students) {
		            if (s.id == id) {

		                System.out.print("Enter new name: ");
		                String name = sc.nextLine();

		                System.out.print("Enter new age: ");
		                int age = sc.nextInt();

		                s.name = name;
		                s.age = age;

		                found = true;
		                System.out.println("Updated successfully");
		                break;
		            }
		        }

		        if (!found) {
		            System.out.println("Student not found");
		        }
		    }

	
   }


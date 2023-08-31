package boundary;
import java.util.Scanner;
import entity.Programme;
public class ProgrammeMaintenanceUI {
    Scanner sc = new Scanner(System.in);

    public int getMenuChoice(){
        System.out.println("Programme Menu");
        System.out.println("1. Display All Programmes");
        System.out.println("2. Add Programme");
        System.out.println("3. Remove Programme");
        System.out.println("4. Update Programme");
        System.out.println("5. Search Programme");
        System.out.println("6. Sort Programme");
        System.out.println("7. Add a Tutorial Group to a Programme");
        System.out.println("8. Remove a Tutorial Group from a Programme");
        System.out.println("9. List All Tutorial Group in a Programme");
        System.out.println("10. Generate Programme Report");
        System.out.println("-1. Exit");
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }


    public void listAllProgrammes(String outputStr){
        System.out.println("List of Programmes");
        System.out.println(outputStr);
    }


    public String inputProgrammeCode(){
        System.out.print("Enter Programme Code: ");
        return sc.next();
    }

    public String inputProgrammeName(){
        System.out.print("Enter Programme Name: ");
        return sc.next();
    }

    public int inputProgrammeDuration(){
        System.out.print("Enter Programme Duration: ");
        return sc.nextInt();
    }

    public String inputProgrammeFaculty(){
        System.out.print("Enter Programme Faculty: ");
        return sc.next();
    }



}

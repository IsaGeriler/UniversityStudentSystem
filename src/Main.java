import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> studentID = new ArrayList<>();
        Random random = new Random();
        Scanner userInput = new Scanner(System.in);
        Student student = new Student();

        int student_id;
        double student_gpa;

        systemMenu();
        for (int i = 0; i <= 99; i++){
            student_id = random.nextInt(90000) + 10000;
            if(studentID.contains(student_id))
                student_id = random.nextInt(90000) + 10000;
            studentID.add(student_id);
            student_gpa = random.nextInt(401)/100.0;
            new Student(student_id, student_gpa);
        }
        Student.getStudents();
        System.out.print("\nPlease enter an arbitrary GPA, between 0.00 and 4.00 [Press '-1' to exit.] ");
        double user_given_gpa = userInput.nextDouble();
        while (user_given_gpa != -1){
            Student found_student = student.findStudent(user_given_gpa);
            studentFinder(found_student, user_given_gpa);
            user_given_gpa = userInput.nextDouble();
        }
        userInput.close();
        endProgram();
    }

    public static void systemMenu(){
        System.out.println("Welcome to the University Student System.");
        System.out.println("This program creates 100 students with random GPAs and IDs " +
                "and will give you the sorted list of the students.");
        System.out.println("Generating the students...");
    }

    public static void studentFinder(Student student, double gpa){
        if ((gpa < 0) || (gpa > 4))
            System.out.println("Invalid GPA specified.");
        else if (student != null)
            System.out.println("Specified Student's ID: " + student.getID() +
                    "\nSpecified Student's GPA: " + student.getGPA());
        else
            System.out.println("No available students with the specified GPA.");
        System.out.print("\nPlease enter an arbitrary GPA, between 0.00 and 4.00 [Press '-1' to exit.] ");
    }

    public static void endProgram(){
        System.out.println("Closing the system...");
        System.exit(0);
    }
}
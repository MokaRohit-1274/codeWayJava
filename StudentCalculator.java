// TASK - 2 STUDENT GRADE CALCULATOR
// Input: Take marks obtained (out of 100) in each subject.
// Calculate Total Marks: Sum up the marks obtained in all subjects.
// Calculate Average Percentage: Divide the total marks by the total number of subjects to
// get the average percentage.
// Grade Calculation: Assign grades based on the average percentage achieved.
// Display Results: Show the total marks, average percentage, and the corresponding grade
// to the user
import java.util.*;
public class StudentCalculator
{
    public static String GradeClaculator(double averPer)
    {
        if(averPer>=90)
        {
            return "A";
        }
        else if(averPer>=80)
        {
            return "B";
        }
        else if(averPer>=70)
        {
            return "C";
        }
        else if(averPer>=60)
        {
            return "D";
        }
        else{
            return "F";
        }

    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of subjects");
        int nSub=sc.nextInt();
        int totalMarks=0;
        for(int i=1;i<=nSub;i++)
        {
            System.out.println("Enter marks obtained in subject "+i);
            int marks=sc.nextInt();
            totalMarks+=marks;
        }
        double averPer=((double)(totalMarks/nSub));
        String Grades=GradeClaculator(averPer);
        System.out.println("total marks"+totalMarks);
        System.out.println("Averge percentage"+averPer );
        System.out.println("Grade of the student"+Grades);

    }
}
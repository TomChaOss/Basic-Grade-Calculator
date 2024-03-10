// Tomas Chaparro, section 4, assignment 3.
// The program will ask for the student's performance over the semester, and it will then
import java.util.Scanner;
public class Grades {
    private static Scanner user_input;
    public static void main(String[] args) {
        user_input = new Scanner(System.in);
        int hw_weight = homework_weight();
        int e1_weight = exam_1_weight();
        int e2_weight = 100 - (hw_weight + e1_weight);

        System.out.printf("Using scores of %d %d %d %n%n", hw_weight, e1_weight, e2_weight);

        double hws = homework_weighted_score(hw_weight);
        double e1ws = exam_1_weighted_score(e1_weight);
        double e2ws = exam_2_weighted_score(e2_weight);

        System.out.printf("Course Grade = %.2f", (hws + e1ws + e2ws));
    }

    public static int homework_weight() {
        System.out.print("Homework weight? "); //Test case is 50
        int hw_weight = user_input.nextInt();
        return hw_weight;
    }
    public static int exam_1_weight() {
        System.out.print("Exam 1 weight? "); //Test case is 20
        int e1_weight = user_input.nextInt();
        return e1_weight;
    }

    public static double homework_weighted_score(int weight) {
        System.out.println("Homework:");

        System.out.print("Number of assignments? "); 
        int ass_num = user_input.nextInt();
        int hw_max_points = Math.abs((ass_num * 10) + (ass_num * 4));

        System.out.print("Average homework grade? ");
        double hw_avg_grade = user_input.nextDouble();
        if (hw_avg_grade < 0){
            hw_avg_grade = 0;
        } else if (hw_avg_grade > hw_max_points) {
            hw_avg_grade = hw_max_points;
        }

        System.out.print("Number of late days used? ");
        int late_days_used = user_input.nextInt();

        System.out.print("Labs attended? "); 
        int labs_attended = user_input.nextInt();
        
        double hw_total_points = (hw_avg_grade * 10) + (labs_attended * 4); 

        if (ass_num < 1) {
            hw_total_points = hw_max_points;
        } else {
            if (late_days_used > (ass_num / 2)) {
                hw_total_points *=  0.9;
            }   else if (late_days_used == 0 && hw_total_points < hw_max_points) {
            hw_total_points += Math.min(5, hw_max_points - hw_total_points);
            }
        }
        double hws = (hw_total_points / hw_max_points) * weight;
        System.out.printf("Total points = %.2f / %d %n", hw_total_points, hw_max_points);
        System.out.printf("Weighted score = %.2f %n%n", hws);
        return hws;
    }
    public static double exam_1_weighted_score(int weight) {
        System.out.println("Exam 1:");

        System.out.print("Score? "); 
        double e1_score = user_input.nextDouble();
        if (e1_score <0) {
            e1_score = 0;
        } else if (e1_score > 100) {
            e1_score = 100;
        }

        System.out.print("Curve? ");
        int e1_curve = user_input.nextInt();

        double e1_total_points = Math.min(100, e1_score + e1_curve);
        double e1ws = (e1_total_points / 100) * weight;

        System.out.printf("Total points = %.2f / 100 %n", e1_total_points);
        System.out.printf("Weighted score = %.2f %n%n", e1ws);
        return e1ws;
    }

    public static double exam_2_weighted_score(int weight) {
        System.out.println("Exam 2:");

        System.out.print("Score? "); 
        double e2_score = user_input.nextDouble();
        if (e2_score < 0) {
            e2_score = 0;
        } else if (e2_score > 100); {
            e2_score = 100;
        }

        System.out.print("Curve? ");
        int e2_curve = user_input.nextInt();

        double e2_total_points = Math.min(100, e2_score + e2_curve);
        double e2ws = (e2_total_points / 100) * weight;

        System.out.printf("Total points = %.2f / 100 %n", e2_total_points);
        System.out.printf("Weighted score = %.2f %n%n", e2ws);
        return e2ws;
    }
}
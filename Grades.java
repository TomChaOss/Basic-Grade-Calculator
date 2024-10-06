// Tomas Chaparro CIS 1068. This program calculates the grade for a fictional course based on the parameters that the user enters.
import java.util.Scanner;
public class Grades {
    static Scanner user_input = new Scanner(System.in);
    static int hw_weight;
    static int e1_weight;
    static int e2_weight;

    public static void main (String[] args) {
        System.out.print("Homework weight: ");
        hw_weight = user_input.nextInt();
        System.out.print("Exam 1 weight: ");
        e1_weight = user_input.nextInt();
        e2_weight = 100 - (hw_weight + e1_weight);
        System.out.printf("Exam 2 weight (calculated): %d", e2_weight);
        System.out.println("\n");

        double course_grade = hw_score() + e1_score() + e2_score();
        System.out.printf("Course grade: %.2f", course_grade);
    }

    public static double hw_score() {
        double final_hw_points;
        double weighted_hw_score;

        System.out.print("Homework: \nNumber of assignments: ");
        int num_assignments = user_input.nextInt();

        if (num_assignments <= 0){
            weighted_hw_score = 50;
            System.out.printf("Weighed score: %.2f \n \n", weighted_hw_score);
        } else{
            int max_hw_points = num_assignments * (10 + 4);

            System.out.print("Average homework grade: ");
            double avg_hw_grade = user_input.nextDouble();
            if (avg_hw_grade < 0) {
                avg_hw_grade = 0;
            }
            System.out.print("Number of late days used: ");
            int late_days_used = user_input.nextInt();
            System.out.print("Number of labs attended: ");
            int labs_attended = user_input.nextInt();

            final_hw_points = (num_assignments * avg_hw_grade) + (labs_attended * 4);
            if (late_days_used == 0) {
                final_hw_points += Math.min(5,max_hw_points - final_hw_points);
            }
            weighted_hw_score = (final_hw_points / max_hw_points) * hw_weight;
            if (late_days_used > num_assignments / 2.0) {
            weighted_hw_score -= 0.1 * weighted_hw_score;
            }

            System.out.printf("Total points: %.2f / %d \n", final_hw_points, max_hw_points);
            System.out.printf("Weighed score: %.2f \n \n", weighted_hw_score);
        }
        return weighted_hw_score;
    }

    public static double e1_score(){
        System.out.print("Exam 1: \nExam 1 score: ");
        double e1_points = user_input.nextDouble();
        if (e1_points < 0){
            e1_points = 0;
        }
        System.out.print("Exam 1 curve: ");
        double e1_curve = user_input.nextDouble();

        e1_points = Math.min(e1_points + e1_curve, 100);
        System.out.printf("Total points: %.2f / 100 \n", e1_points);

        double weighted_e1_score = (e1_points / 100) * e1_weight;
        System.out.printf("Weighted score: %.2f \n \n", weighted_e1_score);
        return weighted_e1_score;
    }

    public static double e2_score(){
        System.out.print("Exam 2: \nExam 2 score: ");
        double e2_points = user_input.nextDouble();
        if (e2_points < 0){
            e2_points = 0;
        }
        System.out.print("Exam 2 curve: ");
        double e2_curve = user_input.nextDouble();

        e2_points = Math.min(e2_points + e2_curve, 100);
        System.out.printf(" Total points: %.2f / 100 \n", e2_points);

        double weighted_e2_score = (e2_points / 100) * e2_weight;
        System.out.printf("Weighted score: %.2f \n", weighted_e2_score);
        return weighted_e2_score;
    }
}
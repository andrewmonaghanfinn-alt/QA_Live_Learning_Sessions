package Labs;

public class lab01_2 {
    public static void main(String[] args) {

        int marks;
        String grade;

        if (args.length == 0) {
            marks = 99;
        } else {
            marks = Integer.parseInt(args[0]);
        }

        if (marks < 50) { grade = "Fail"; }
        else if (marks > 50 && marks <= 60) { grade = "Pass"; }
        else if (marks > 60 && marks <= 70) { grade = "Merit"; }
        else if (marks > 70 && marks <= 100) { grade = "Distinction"; }

    }

}

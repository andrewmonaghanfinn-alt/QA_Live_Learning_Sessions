package Labs.lab4;

public class Program {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };

        System.out.println(findSum(numbers));
        System.out.println(findAverage(numbers));
        System.out.println(findMin(numbers));
        System.out.println(findMax(numbers));
        System.out.println(findZero(numbers));


        String[] students = { "Sam", "John", "Tracy", "Michaela", "Jenny"};
        int[] marks =  {14, 68, 49, 100, 87};

        for (int i = 0; i < marks.length; i++) {
            System.out.println(students[i] + " has achieved a " + getGrade(marks[i]) + " grade");
        }

        System.out.println("It takes " + InAccount(100) + " years to turn £100 into £200 with a 5% interest rate");

        multiplicationTable();




    }

    static int findSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[1];
        }
        return sum;
    }

    static double findAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[1];
        }
        return (double)sum / array.length;
    }

    static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    static int findZero(int[] array) {
        int index = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    static String getGrade(int mark) {
        String grade = "";
        if (mark < 50) { grade = "Fail"; }
        else if (mark > 50 && mark <= 60) { grade = "Pass"; }
        else if (mark > 60 && mark <= 70) { grade = "Merit"; }
        else if (mark > 70 && mark <= 100) { grade = "Distinction"; }
        return grade;
    }

    static int InAccount(double principal) {
        int years = 0;

        while (principal < 200) {
            principal += (principal * 0.05);
            years++;
        }
        return years;
    }

    static void multiplicationTable() {
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= 10; j++)
            {
                System.out.printf("%5d", i * j);
            }
            System.out.println();
        }
    }
}

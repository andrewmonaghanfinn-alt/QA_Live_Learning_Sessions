package Labs.lab12;

import java.io.*;

public class Program {
    public static void main(String[] args) {

//        try {
//            courses = readCSV("src/main/java/Labs/lab12/course.txt");
//        } catch (IOException e) {
//            System.out.println("idk bro probably wrong path ig");
//        }
//        String[] trainers = new String[0];
//        try {
//            trainers = readCSV("src/main/java/Labs/lab12/trainer.txt");
//        } catch (IOException e) {
//            System.out.println("idk bro probably wrong path ig");
//        }
        String[] trainersAndCourses = new String[1];
        trainersAndCourses[0] = "Error test";

        try {
            writeCSV("src/main/java/Labs/lab12/trainer.txt", "src/main/java/Labs/lab12/course.txt");
        } catch (IOException e) {
            System.out.println("idk bro probably wrong path ig: " + e.getMessage());
        }
        try {
            trainersAndCourses = readCSV("src/main/java/Labs/lab12/trainersAndCourses.txt");
        } catch (IOException e) {
            System.out.println("idk bro probably wrong path ig: " + e.getMessage());
        } finally {
            for (String s : trainersAndCourses) {
                System.out.println(s);
            }
        }



    }
    private static String[] readCSV(String inFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        String fileLine = reader.readLine();
        reader.close();

        if (fileLine != null) {
            return fileLine.split(",");
        } else {
            return new String[0]; //if its empty just return an empty array, weird that there isn't a static for this
        }


    }
    private static void writeCSV(String inFileTrainer, String inFileCourse) throws IOException {
        FileWriter writer = new FileWriter("src/main/java/Labs/lab12/trainersAndCourses.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        BufferedReader trainerReader = new BufferedReader(new FileReader(inFileTrainer));
        BufferedReader courseReader = new BufferedReader(new FileReader(inFileCourse));

        String trainerLine = trainerReader.readLine();
        String courseLine = courseReader.readLine();

        trainerReader.close();
        courseReader.close();

        String[] trainers = trainerLine.split(",");
        String[] courses = courseLine.split(",");

        for (int i = 0; i < trainers.length; i++) {
            bufferedWriter.write(trainers[i] + " " + courses[i] + ",");
        }


        bufferedWriter.close();
        writer.close();

    }
}

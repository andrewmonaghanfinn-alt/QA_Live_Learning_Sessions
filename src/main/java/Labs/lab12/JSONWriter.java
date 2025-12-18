package Labs.lab12;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWriter {
    public static void main(String[] args) {
        Gson gson = new Gson();

        int[] nos = {1,3,5,7,9};
        String res = gson.toJson(nos);
        System.out.println(res);

        String[] names= {"Bob","Fred","Wilma"};
        res = gson.toJson(names);
        System.out.println(res);

        Student[] students = {
                new Student("Bob",21),
                new Student("Fred",32),
                new Student("Wilma",26)
        };

        res = gson.toJson(students);
        System.out.println(res);

        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create(); //idk what these extra bits do tbh
        String filePath = "src/main/java/Labs/lab12/students.json";



        //lowk this is nice, u can use a tryblock that has "try-with-resources" and it will auto close


        try (FileWriter writer = new FileWriter((filePath))){
            gsonBuilder.toJson(students, writer);
        } catch (IOException e) {
            System.out.println("uh oh:" + e.getMessage());
        }

    }
}
class Student{
    String name;
    int age;
    ArrayList<String> subjects = new ArrayList<>();

    public Student(String name, int age) {
        this.name = name; this.age = age;
        subjects.add("Java");
        subjects.add("C#");
        subjects.add("Networking");
    }
}

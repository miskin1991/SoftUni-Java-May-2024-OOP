package Labs.Abstractions._03_Students;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args)
    {
        if (args[0].equals("Create"))
        {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            repo.putIfAbsent(name, new Student(name, age, grade));
        }
        else
        {
            String name = args[1];
            Student student = repo.get(name);
            if (student != null)
            {
                System.out.println(student);
            }
        }
    }


}

package task5;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Group {
    Disciplines discipline;
    List<Student> students;

    public Group(Disciplines discipline) {
        this.discipline = discipline;
    }
    public boolean addStudent(Student s){
        return students.add(s);
    }

    public int getStudentId(Student s){
        return students.indexOf(s);
    }

    public Student findStudent(String name) {
        return students.stream()
                .filter(el -> el.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean setMark(int id, String mark) {
        Student s = students.get(id);
        switch (discipline){
            case ENGLISH:
                return s.setMark(Long.valueOf(mark));
            case MATH:
                return s.setMark(Integer.valueOf(mark));
            case PHISIC:
                return s.setMark(Double.valueOf(mark));
                default:
                    return false;
        }
    }
}

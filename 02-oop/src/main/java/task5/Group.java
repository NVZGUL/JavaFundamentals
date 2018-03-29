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
        students.add(s);
        return true;
    };

    public int getStudentId(Student s){
        int i ;
        for (Student student : students) {
            i = 0;
            if (student.equals(s)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean setMark(int id, String mark) {
        Student s = students.get(id);
        switch (discipline){
            case ENGLISH:
                s.setMark(Long.valueOf(mark));
                return true;
            case MATH:
                s.setMark(Integer.valueOf(mark));
                return true;
            case PHISIC:
                s.setMark(Double.valueOf(mark));
                return true;
                default:
                    return false;
        }
    }
    /*
    public Number getMarks(){
        discipline.getType()0;
    }
    */
}

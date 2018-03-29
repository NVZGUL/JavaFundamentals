package task5;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(
        exclude = {"mark"}
)
public class Student {
    @Getter String name;
    Number mark;
    Student(String name){
        this.name = name;
    }

    public <T extends Number> T getMark(T mark) {
        return mark;
    }

    public <T extends Number> void setMark(T mark) {
        this.mark = mark;
    }
}

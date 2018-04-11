package task1;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;

import java.sql.ResultSet;
import java.time.LocalDate;

@Value
@AllArgsConstructor
public class Person {
    String firstName;
    String lastName;
    boolean permission;
    LocalDate dob;
    String email;
    String password;
    String address;
    String telephone;
    @SneakyThrows
    public Person(ResultSet resultSet) {
        firstName = resultSet.getString("first_name");
        lastName = resultSet.getString("last_name");
        permission = resultSet.getBoolean("permission");
        dob = resultSet.getDate("dob").toLocalDate();
        email = resultSet.getString("email");
        password = resultSet.getString("password");
        address = resultSet.getString("address");
        telephone = resultSet.getString("telephone");
    }
    @Override
    public String toString() {
        return  new StringBuilder()
                .append("'"+firstName + "',")
                .append("'"+lastName + "',")
                .append(String.valueOf(permission).toUpperCase())
                .append(",")
                .append("'" + dob.toString() + "',")
                .append("'" + email + "',")
                .append("'" + password + "',")
                .append("'" + address + "',")
                .append("'" + telephone + "'")
                .toString();
    }
}

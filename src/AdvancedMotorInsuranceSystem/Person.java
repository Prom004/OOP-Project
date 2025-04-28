package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Person {
    private String personId;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;

    public Person(String personId, String fullName, LocalDate dob, String email, String phone) {
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
        setEmail(email);
        setPhone(phone);
    }

    public String getPersonId() {
        return personId;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (Pattern.matches("^[0-9]{8,15}$", phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must be 8 to 15 digits.");
        }
    }
}

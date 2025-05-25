package com.maveric.pgms.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
public class PayingGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "First Name is Mandatory")
    @Size(min = 1, message = "First Name must not be empty")
    private String firstName;

    @NotNull(message = "Last Name is Mandatory")
    @Size(min = 1, message = "Last Name must not be empty")
    private String lastName;

    @NotNull(message = "Age is Mandatory")
    @Min(value = 18, message = "Age must be equal to or greater than 18.")
    @Max(value = 80, message = "Age must not be greater than 80.")
    private int age;

    @NotNull(message = "Gender is mandatory.")
    private String gender;

    @NotNull(message = "Contact is mandatory.")
//    @Pattern(regexp = "^[+\\-\\d]*$", message = "Contact can only contain numbers, +, and -.")
//    @Size(min = 1, message = "Contact must not be empty. ")
    private int contact;

    @NotNull(message = "Email is mandatory.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotNull(message = "Address is Mandatory.")
    @Size(min = 1, message = "Address must not be empty.")
    private String address;

    public PayingGuest() {}

    public PayingGuest(int id, String fName, String lName, int age, String gender, int contact, String email, String address) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public PayingGuest(String fName, String lName, int age, String gender, int contact, String email, String address) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PayingGuest that = (PayingGuest) o;
        return id == that.id && age == that.age && contact == that.contact && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, gender, contact, email, address);
    }

    @Override
    public String toString() {
        return "PayingGuest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


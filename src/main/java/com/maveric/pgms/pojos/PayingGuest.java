package com.maveric.pgms.pojos;

import java.util.Objects;

public class PayingGuest {

    private int id;
    private String fName;
    private String lName;
    private int age;
    private String gender;
    private long contact;
    private String email;
    private String address;

    public PayingGuest(int id, String fName, String lName, int age, String gender, long contact, String email, String address) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public void setContact(long contact) {
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
        return id == that.id && age == that.age && contact == that.contact && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fName, lName, age, gender, contact, email, address);
    }

    @Override
    public String toString() {
        return "PayingGuest{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

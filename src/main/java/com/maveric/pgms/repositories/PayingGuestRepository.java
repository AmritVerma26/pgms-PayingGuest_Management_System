package com.maveric.pgms.repositories;

import com.maveric.pgms.pojos.PayingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayingGuestRepository extends JpaRepository<PayingGuest, Integer> {

    List<PayingGuest> findDetailsById(int id);

    List<PayingGuest> findByAge(int age);

    List<PayingGuest> findAll();

    List<PayingGuest> findByGender(String gender);

    List<PayingGuest> findByfName(String fName);

    List<PayingGuest> findBylName(String lName);

}

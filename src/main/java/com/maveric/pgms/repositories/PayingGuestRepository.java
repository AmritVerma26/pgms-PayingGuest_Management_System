package com.maveric.pgms.repositories;

import com.maveric.pgms.pojos.PayingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayingGuestRepository {

    public interface CustomerRepository extends JpaRepository<PayingGuest, Integer> {

        List<PayingGuest> findByAge(int age);

        List<PayingGuest> findByGender(String gender);

        PayingGuest findByFirstName(String firstName);

        PayingGuestRepository findByLastName(String lastName);

    }
}

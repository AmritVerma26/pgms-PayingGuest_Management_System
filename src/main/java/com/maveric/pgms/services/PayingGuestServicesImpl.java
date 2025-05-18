package com.maveric.pgms.services;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import com.maveric.pgms.pojos.PayingGuest;
import com.maveric.pgms.repositories.PayingGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("payingGuest")

public class PayingGuestServicesImpl implements PayingGuestServices {

    @Autowired
    PayingGuestRepository payingGuestRepository;

    @Override
    public void acceptPayingGuest(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException {
        return payingGuest.save(payingGuest);
    }

    @Override
    public void updatePayingGuestDetails(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException {
        this.getDetailsById(payingGuest.getId());
        payingGuestRepository.save(payingGuest);
    }

    @Override
    public void removePayingGuest(int id) throws PayingGuestDetailsNotFoundException {
        this.getDetailsById(id);
        payingGuestRepository.deleteById(id);
    }

    @Override
    public PayingGuest getDetailsById(int id) throws PayingGuestDetailsNotFoundException {
        return null;
    }

    @Override
    public List<PayingGuest> getPayingGuestByFirstName(String fName) throws PayingGuestDetailsNotFoundException {
        return List.of();
    }

    @Override
    public List<PayingGuest> getPayingGuestByLastName(String lName) throws PayingGuestDetailsNotFoundException {
        return List.of();
    }
}

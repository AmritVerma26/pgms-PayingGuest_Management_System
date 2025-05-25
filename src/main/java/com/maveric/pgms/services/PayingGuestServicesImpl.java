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
    public PayingGuest acceptPayingGuest(PayingGuest payingGuest){
        return payingGuestRepository.save(payingGuest);
    }

    @Override
    public PayingGuest updatePayingGuestDetails(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException {
        this.getDetailsById(payingGuest.getId());
        return payingGuestRepository.save(payingGuest);
    }

    @Override
    public void removePayingGuest(int id) throws PayingGuestDetailsNotFoundException {
        this.getDetailsById(id);
        payingGuestRepository.deleteById(id);
    }

    @Override
    public List<PayingGuest> getDetailsById(int id) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findDetailsById(id);
        if (payingGuests.isEmpty()) throw new PayingGuestDetailsNotFoundException("Guest with id : " +id + " not found.");
        return payingGuests;
    }

    @Override
    public List<PayingGuest> getAllGuests() throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findAll();
        if (payingGuests.isEmpty()) throw new PayingGuestDetailsNotFoundException("Guest not found.");
        return payingGuests;
    }

    @Override
    public List<PayingGuest> getPayingGuestByfName(String fName) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findByFirstName(fName);
        if (payingGuests.isEmpty())
            throw new PayingGuestDetailsNotFoundException("Guest with first name : " +fName + " not found.");
        return payingGuests;
    }

    @Override
    public List<PayingGuest> getPayingGuestBylName(String lName) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findByLastName(lName);
        if (payingGuests.isEmpty())
            throw new PayingGuestDetailsNotFoundException("Guest with last name : " +lName + " not found.");
        return payingGuests;
    }

    @Override
    public List<PayingGuest> getDetailsByAge(int age) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findByAge(age);
        if (payingGuests.isEmpty())
            throw new PayingGuestDetailsNotFoundException("Guest with age : " +age + " not found.");
        return payingGuests;
    }

    @Override
    public List<PayingGuest> getDetailsByGender(String gender) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuests = payingGuestRepository.findByGender(gender);
        if (payingGuests.isEmpty()) throw new PayingGuestDetailsNotFoundException("Guest with gender : " +gender + " not found.");
        return payingGuests;
    }
}

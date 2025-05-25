package com.maveric.pgms.services;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import com.maveric.pgms.pojos.PayingGuest;

import java.util.List;

public interface PayingGuestServices {

    PayingGuest acceptPayingGuest(PayingGuest payingGuest);
    PayingGuest updatePayingGuestDetails(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException;
    void removePayingGuest(int id) throws PayingGuestDetailsNotFoundException;

    List<PayingGuest> getDetailsById(int id)throws PayingGuestDetailsNotFoundException;

    List<PayingGuest> getAllGuests() throws PayingGuestDetailsNotFoundException;

    List<PayingGuest> getPayingGuestByfName(String fName) throws PayingGuestDetailsNotFoundException;
    List<PayingGuest> getPayingGuestBylName(String lName) throws PayingGuestDetailsNotFoundException;

    List<PayingGuest> getDetailsByAge(int age)throws PayingGuestDetailsNotFoundException;
    List<PayingGuest> getDetailsByGender(String gender) throws PayingGuestDetailsNotFoundException;

}

package com.maveric.pgms.services;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import com.maveric.pgms.pojos.PayingGuest;

import java.util.List;

public interface PayingGuestServices {

    void acceptPayingGuest(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException;
    void updatePayingGuestDetails(PayingGuest payingGuest) throws PayingGuestDetailsNotFoundException;
    void removePayingGuest(int id) throws PayingGuestDetailsNotFoundException;

    PayingGuest getDetailsById(int id)throws PayingGuestDetailsNotFoundException;

    List<PayingGuest> getPayingGuestByFirstName(String fName) throws PayingGuestDetailsNotFoundException;
    List<PayingGuest> getPayingGuestByLastName(String lName) throws PayingGuestDetailsNotFoundException;


}

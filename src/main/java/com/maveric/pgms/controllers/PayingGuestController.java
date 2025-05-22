package com.maveric.pgms.controllers;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import com.maveric.pgms.pojos.PayingGuest;
import com.maveric.pgms.services.PayingGuestServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayingGuestController {

    @Autowired
    PayingGuestServices payingGuestServices;

    //create customer
    @PostMapping(value = "/v1/payingGuest" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayingGuest> acceptPayingGuest(@RequestBody PayingGuest guestToBeInsert) {
        return new ResponseEntity<>(payingGuestServices.acceptPayingGuest(guestToBeInsert), HttpStatus.CREATED);
    }

    //Getting List of all customer
    @GetMapping(value = "/v1/payingGuest/all")
    public ResponseEntity <List<PayingGuest>> getAllGuests() throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> allGuests = payingGuestServices.getAllGuests();
        return new ResponseEntity<>(allGuests, HttpStatus.OK);
    }

    //Getting Guests by id
    @GetMapping(value = "/v1/payingGuest/id/{id}")
    public ResponseEntity<List<PayingGuest>> getDetailsById(@PathVariable int id) throws PayingGuestDetailsNotFoundException {
        List<PayingGuest> payingGuest = payingGuestServices.getDetailsById(id);
        return new ResponseEntity<>(payingGuest, HttpStatus.OK);
    }

    //Deleting the Guest by id
    @GetMapping(value = "/v1/payingGuest/delete/{id}")
    public ResponseEntity<String> removePayingGuest(@PathVariable int id) throws PayingGuestDetailsNotFoundException {
        payingGuestServices.removePayingGuest(id);
        return new ResponseEntity<>("Guest Successfully Deleted" , HttpStatus.OK);
    }

}

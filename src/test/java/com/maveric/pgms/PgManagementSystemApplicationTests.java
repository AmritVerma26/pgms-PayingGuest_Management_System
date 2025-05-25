package com.maveric.pgms;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import com.maveric.pgms.pojos.PayingGuest;
import com.maveric.pgms.repositories.PayingGuestRepository;
import com.maveric.pgms.services.PayingGuestServices;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;


import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;


	@ExtendWith(SpringExtension.class)
	@SpringBootTest(classes = com.maveric.pgms.PgManagementSystemApplication.class)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

	public class  PgManagementSystemApplicationTests {

		@MockitoBean
		PayingGuestRepository payingGuestRepository;

		@Autowired
		PayingGuestServices payingGuestServices;

		@BeforeEach
		void setUp() {
			PayingGuest guest1 = new PayingGuest(1, "Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore");
			PayingGuest guest2 = new PayingGuest(2, "Vinay", "Malik", 25,"Male", 422324324, "vm@gmail.com", "Haryana");
			PayingGuest guest3 = new PayingGuest(3, "Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat");
			PayingGuest guest4 = new PayingGuest(4, "MS", "Dhoni", 35,"Male", 999234535, "msd@gmail.com", "Ranchi");
			PayingGuest guest5 = new PayingGuest(5, "Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi");

			//save
			Mockito.when(payingGuestRepository.save(new PayingGuest("Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore"))).thenReturn(guest1);
			Mockito.when(payingGuestRepository.save(new PayingGuest("Vinay", "Malik", 25,"Male", 422324324, "vm@gmail.com", "Haryana"))).thenReturn(guest2);
			Mockito.when(payingGuestRepository.save(new PayingGuest("Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat"))).thenReturn(guest3);
			Mockito.when(payingGuestRepository.save(new PayingGuest("MS", "Dhoni", 35,"Male", 999234535, "msd@gmail.com", "Ranchi"))).thenReturn(guest4);
			Mockito.when(payingGuestRepository.save(new PayingGuest("Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi"))).thenReturn(guest5);

			//findById
			Mockito.when(payingGuestRepository.findDetailsById(1)).thenReturn(List.of(guest1));
			Mockito.when(payingGuestRepository.findDetailsById(2)).thenReturn(List.of(guest2));
			Mockito.when(payingGuestRepository.findDetailsById(3)).thenReturn(List.of(guest3));
			Mockito.when(payingGuestRepository.findDetailsById(4)).thenReturn(List.of(guest4));
			Mockito.when(payingGuestRepository.findDetailsById(5)).thenReturn(List.of(guest5));
			Mockito.when(payingGuestRepository.findDetailsById(100)).thenReturn(Collections.emptyList());

			//findAll
			List<PayingGuest> guests = List.of(guest1, guest2, guest3, guest4, guest5);
			Mockito.when(payingGuestRepository.findAll()).thenReturn(guests);

			//findByFirstName
			Mockito.when(payingGuestRepository.findByFirstName("Virat")).thenReturn(List.of(guest5));
			Mockito.when(payingGuestRepository.findByFirstName("Hello")).thenReturn(Collections.emptyList());

			//findByLastName
			Mockito.when(payingGuestRepository.findByLastName("Verma")).thenReturn(List.of(guest1));
			Mockito.when(payingGuestRepository.findByLastName("Pandey")).thenReturn(emptyList());

			//findByAge
			Mockito.when(payingGuestRepository.findByAge(32)).thenReturn(List.of(guest3));
			Mockito.when(payingGuestRepository.findByAge(98)).thenReturn((Collections.emptyList()));

			//findByGender
			Mockito.when(payingGuestRepository.findByGender("Male")).thenReturn(List.of(guest1, guest2, guest4, guest5 ));
			Mockito.when(payingGuestRepository.findByGender("Female")).thenReturn(List.of(guest3));
			Mockito.when(payingGuestRepository.findByGender("none")).thenReturn(Collections.emptyList());

			//update
			PayingGuest updatedGuest = new PayingGuest(4,"Reeya","C", 20, "Female", 917234220, "reeyac@gmail.com" , "Pokhara");
			Mockito.when(payingGuestRepository.save( new PayingGuest(4,"Reeya","C", 20, "Female", 917234220, "reeyac@gmail.com" , "Pokhara"))).thenReturn(updatedGuest);
			Mockito.when(payingGuestRepository.save( new PayingGuest(94,"Reeya","C", 20, "Female", 917234220, "reeyac@gmail.com" , "Pokhara"))).thenReturn(null);

			//deleteById
			doNothing().when(payingGuestRepository).deleteById(1);
			doNothing().when(payingGuestRepository).deleteById(9999);
		}

		@Test
		@Order(1)
		void testCustomerAcceptance() {
			Assertions.assertNotNull(payingGuestServices.acceptPayingGuest(new PayingGuest("Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore")));
			Assertions.assertNotNull(payingGuestServices.acceptPayingGuest(new PayingGuest("Vinay", "Malik", 25,"Male", 422324324, "vm@gmail.com", "Haryana")));
			Assertions.assertNotNull(payingGuestServices.acceptPayingGuest(new PayingGuest("Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat")));
			Assertions.assertNotNull(payingGuestServices.acceptPayingGuest(new PayingGuest("MS", "Dhoni", 35,"Male", 999234535, "msd@gmail.com", "Ranchi")));
			Assertions.assertNotNull(payingGuestServices.acceptPayingGuest(new PayingGuest("Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi")));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).save(Mockito.any(PayingGuest.class));
		}

		@Test
		@Order(2)
		void testCustomerById_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> expectedGuest = List.of(new PayingGuest(1, "Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore"));
			Assertions.assertEquals(expectedGuest, payingGuestServices.getDetailsById(1));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findDetailsById(1);
		}

		@Test
		@Order(3)
		void testCustomerById_Negative() {
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, ()-> payingGuestServices.getDetailsById(100));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findDetailsById(100);
		}


		@Test
		@Order(4)
		void validFirstName_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> expectedGuest = List.of(new PayingGuest(5, "Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi"));
			List<PayingGuest> actualGuest = payingGuestServices.getPayingGuestByfName("Virat");
			assertEquals(expectedGuest,actualGuest);
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByFirstName("Virat");
		}

		@Test
		@Order(5)
		void invalidFirstName_Negative(){
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, ()-> payingGuestServices.getPayingGuestByfName("Hello"));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByFirstName("Hello");
		}

		@Test
		@Order(6)
		void validLastName_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> expectedGuest = List.of(new PayingGuest(1, "Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore"));
			List<PayingGuest> actualGuest = payingGuestServices.getPayingGuestBylName("Verma");
			assertEquals(expectedGuest,actualGuest);
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByLastName("Verma");

		}

		@Test
		@Order(7)
		void invalidLastName_Negative(){
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class,()->payingGuestServices.getPayingGuestBylName("Pandey"));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByLastName("Pandey");
		}

		@Test
		@Order(8)
		void getCustomersByAge_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> expected = List.of(new PayingGuest(3, "Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat"));
			Assertions.assertEquals(expected, payingGuestServices.getDetailsByAge(32));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByAge(32);
		}

		@Test
		@Order(9)
		void getAllCustomersByAge_Negative() {
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, () -> payingGuestServices.getDetailsByAge(98));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByAge(98);
		}

		@Test
		@Order(10)
		void testGetAllCustomersByGender_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> maleExpected = List.of(

					new PayingGuest(1, "Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore"),
					new PayingGuest(2, "Vinay", "Malik", 25,"Male", 422324324, "vm@gmail.com", "Haryana"),
					new PayingGuest(4, "MS", "Dhoni", 35,"Male", 999234535, "msd@gmail.com", "Ranchi"),
			        new PayingGuest(5, "Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi")

			);
			List<PayingGuest> femaleExpected = List.of(
					new PayingGuest(3, "Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat")
			);

			Assertions.assertEquals(maleExpected, payingGuestServices.getDetailsByGender("Male"));
			Assertions.assertEquals(femaleExpected, payingGuestServices.getDetailsByGender("Female"));

			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByGender("Male");
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByGender("Female");
		}

		@Test
		@Order(11)
		void testGetAllCustomersByGender_Negative() {
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, () -> payingGuestServices.getDetailsByGender("none"));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findByGender("none");
		}


		@Test
		@Order(12)
		void updateCustomerDetails_Positive() throws PayingGuestDetailsNotFoundException {
			PayingGuest existingGuest = new PayingGuest(4,"Reeya","C", 20, "Female", 917234220, "reeyac@gmail.com" , "Pokhara");
			Assertions.assertEquals(existingGuest, payingGuestServices.updatePayingGuestDetails(existingGuest));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).save(existingGuest);
		}

		@Test
		@Order(13)
		void updateCustomerDetails_Negative() {
			PayingGuest nonExistentGuest = new PayingGuest(9999, "Hello", "Kumar", 23, "Male", 3141123,"bihel@gmail.com", "Bihar");
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, ()-> payingGuestServices.updatePayingGuestDetails(nonExistentGuest));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findDetailsById(9999);
		}


		@Test
		@Order(14)
		void removeCustomerDetailsById_Positive() throws PayingGuestDetailsNotFoundException {
			payingGuestServices.removePayingGuest(2);
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).deleteById(2);
		}

		@Test
		@Order(15)
		void removeCustomerDetailsById_Negative() {
			Assertions.assertThrows(PayingGuestDetailsNotFoundException.class, ()-> payingGuestServices.removePayingGuest(9999));
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findDetailsById(9999);
		}

		@Test
		@Order(16)
		void getAllCustomers_Positive() throws PayingGuestDetailsNotFoundException {
			List<PayingGuest> expected = List.of(

					new PayingGuest (1, "Amrit", "Vemra", 23,"Male", 927492742, "av@gmail.com", "Bangalore"),
					new PayingGuest (2, "Vinay", "Malik", 25,"Male", 422324324, "vm@gmail.com", "Haryana"),
					new PayingGuest (3, "Shreya", "Patel", 32,"Female", 12334324, "sp@gmail.com", "Gujrat"),
					new PayingGuest (4, "MS", "Dhoni", 35,"Male", 999234535, "msd@gmail.com", "Ranchi"),
					new PayingGuest (5, "Virat", "Kohli", 39,"Male", 253125509, "virat@gmail.com", "Delhi")
			);

			Assertions.assertEquals(expected, payingGuestServices.getAllGuests());
			Mockito.verify(payingGuestRepository, Mockito.atLeastOnce()).findAll();
		}

	}



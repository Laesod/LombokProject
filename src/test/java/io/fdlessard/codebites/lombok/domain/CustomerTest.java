package io.fdlessard.codebites.lombok.domain;

import io.fdlessard.codebites.lombok.TestConstants;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static io.fdlessard.codebites.lombok.TestConstants.*;
import static org.junit.Assert.*;

public class CustomerTest {

    private UUID id;

    private Customer customer;

    private Address homeAddress;

    private Address workAddress;

    @Before
    public void setUp() throws Exception {

        homeAddress = Address.builder()
                .streetName(TestConstants.TEST_STREET_NAME)
                .city(TEST_CITY)
                .province(TEST_PROVINCE)
                .postalCode(TEST_POSTAL_CODE)
                .country(TEST_COUNTRY)
                .build();

        workAddress = Address.builder()
                .streetName(TestConstants.TEST_STREET_NAME)
                .city(TEST_CITY)
                .province(TEST_PROVINCE)
                .postalCode(TEST_POSTAL_CODE)
                .country(TEST_COUNTRY)
                .build();

        id = UUID.randomUUID();


        customer = Customer.builder()
                .id(id)
                .firstName(TEST_FIRST_NAME)
                .lastName(TEST_LAST_NAME)
                .company(TEST_COMPANY)
                .addresses(Arrays.asList(homeAddress, workAddress))
                .build();
    }

    @Test
    public void testGetSet() {
        Customer otherCustomer = Customer.builder()
                .build();

        UUID uuid = UUID.randomUUID();

        otherCustomer.setId(uuid);
        assertEquals(uuid, otherCustomer.getId());

        otherCustomer.setFirstName(TEST_FIRST_NAME);
        assertEquals(TEST_FIRST_NAME, otherCustomer.getFirstName());

        otherCustomer.setLastName(TEST_LAST_NAME);
        assertEquals(TEST_LAST_NAME, otherCustomer.getLastName());

        otherCustomer.setCompany(TEST_COMPANY);
        assertEquals(TEST_COMPANY, otherCustomer.getCompany());

        otherCustomer.setAddresses(Arrays.asList(homeAddress, workAddress));
        assertEquals(Arrays.asList(homeAddress, workAddress), otherCustomer.getAddresses());
    }

    @Test
    public void testToString() {
        assertEquals("", customer.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(customer.equals(customer));
        Customer otherCustomer = Customer.builder()
                .build();

        assertFalse(customer.equals(otherCustomer));

    }

}
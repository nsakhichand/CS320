package Tests;

import ContactClass.Contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Contact ID"));
    }

    @Test
    public void testContactIdTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Contact ID"));
    }

    @Test
    public void testFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("First name"));
    }

    @Test
    public void testFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "FirstnameToolong", "Doe", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("First name"));
    }

    @Test
    public void testLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Last name"));
    }

    @Test
    public void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "LastnameTooLong", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Last name"));
    }

    @Test
    public void testPhoneInvalidNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Phone"));
    }

    @Test
    public void testPhoneInvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Phone"));
    }

    @Test
    public void testAddressNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
        assertTrue(exception.getMessage().contains("Address"));
    }

    @Test
    public void testAddressTooLong() {
        String longAddress = "1234567890123456789012345678901"; // 31 chars
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", longAddress);
        });
        assertTrue(exception.getMessage().contains("Address"));
    }

    // Test setters with valid and invalid data
    @Test
    public void testSettersValid() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Secondary St");
        assertEquals("456 Secondary St", contact.getAddress());
    }

    @Test
    public void testSettersInvalid() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstNameTooLong"));

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastNameTooLong"));

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("1234"));

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is going to be definitely longer than thirty characters"));
    }
}

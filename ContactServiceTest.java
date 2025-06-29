package Tests;

import ContactClass.Contact;
import ContactClass.ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testAddContactDuplicateId() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
        assertTrue(exception.getMessage().contains("already exists"));
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteContactNonExistent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
        assertTrue(exception.getMessage().contains("does not exist"));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", "Jane", null, null, null);

        Contact updated = service.getContact("1");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Doe", updated.getLastName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", null, "Smith", null, null);

        Contact updated = service.getContact("1");
        assertEquals("John", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", null, null, "0987654321", null);

        Contact updated = service.getContact("1");
        assertEquals("0987654321", updated.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", null, null, null, "456 Elm St");

        Contact updated = service.getContact("1");
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    public void testUpdateAllFields() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", "Jane", "Smith", "0987654321", "456 Elm St");

        Contact updated = service.getContact("1");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Jane", "Smith", "0987654321", "456 Elm St");
        });
        assertTrue(exception.getMessage().contains("does not exist"));
    }

    @Test
    public void testUpdateWithInvalidData() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        // Invalid firstName too long
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", "FirstNameTooLong", null, null, null);
        });
        assertTrue(ex1.getMessage().contains("First name"));

        // Invalid phone number format
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", null, null, "12345", null);
        });
        assertTrue(ex2.getMessage().contains("Phone"));

        // Invalid address too long
        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", null, null, null, "This address is definitely longer than thirty characters");
        });
        assertTrue(ex3.getMessage().contains("Address"));
    }
}

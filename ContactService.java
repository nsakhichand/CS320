package ContactClass;


	import ContactClass.Contact;
	import java.util.HashMap;
	import java.util.Map;

	public class ContactService {
	    private final Map<String, Contact> contacts = new HashMap<>();

	    public void addContact(Contact contact) {
	        if (contact == null) {
	            throw new IllegalArgumentException("Contact cannot be null.");
	        }
	        String id = contact.getContactId();
	        if (contacts.containsKey(id)) {
	            throw new IllegalArgumentException("A contact with the same ID already exists.");
	        }
	        contacts.put(id, contact);
	    }

	    public void deleteContact(String contactId) {
	        if (contactId == null || !contacts.containsKey(contactId)) {
	            throw new IllegalArgumentException("Contact ID does not exist.");
	        }
	        contacts.remove(contactId);
	    }

	    /**
	     * Update the contact by contact ID. Fields that are null will not be updated.
	     */
	    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
	        if (contactId == null || !contacts.containsKey(contactId)) {
	            throw new IllegalArgumentException("Contact ID does not exist.");
	        }
	        Contact contact = contacts.get(contactId);
	        if (firstName != null) {
	            contact.setFirstName(firstName);
	        }
	        if (lastName != null) {
	            contact.setLastName(lastName);
	        }
	        if (phone != null) {
	            contact.setPhone(phone);
	        }
	        if (address != null) {
	            contact.setAddress(address);
	        }
	    }

	    public Contact getContact(String contactId) {
	        return contacts.get(contactId);
	    }
	}


package ContactClass;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10 || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID must be non-null, non-empty, and max 10 characters.");
        }
        if (firstName == null || firstName.length() > 10 || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name must be non-null, non-empty, and max 10 characters.");
        }
        if (lastName == null || lastName.length() > 10 || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must be non-null, non-empty, and max 10 characters.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be non-null and exactly 10 digits.");
        }
        if (address == null || address.length() > 30 || address.isEmpty()) {
            throw new IllegalArgumentException("Address must be non-null, non-empty, and max 30 characters.");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10 || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name must be non-null, non-empty, and max 10 characters.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10 || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must be non-null, non-empty, and max 10 characters.");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be non-null and exactly 10 digits.");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30 || address.isEmpty()) {
            throw new IllegalArgumentException("Address must be non-null, non-empty, and max 30 characters.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

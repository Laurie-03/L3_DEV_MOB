package fr.java.smsstats;

public class Contact {

    private String contact_name;
    private String contact_phone;


    public Contact(String contact_name, String contact_phone) {
        this.contact_name = contact_name;
        this.contact_phone = contact_phone;
    }

    public String getContactName() {
        return contact_name;
    }

    public void setContactName(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContactPhone() {
        return contact_phone;
    }

    public void setContactPhone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}

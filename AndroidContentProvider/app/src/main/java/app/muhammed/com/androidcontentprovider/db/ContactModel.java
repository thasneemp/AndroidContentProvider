package app.muhammed.com.androidcontentprovider.db;

import com.orm.SugarRecord;

/**
 * Created by Muhammed on 08/10/17.
 */

public class ContactModel extends SugarRecord<ContactModel> {

    private String name;
    private String phone;
    private String email;
    private String address;

    public ContactModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

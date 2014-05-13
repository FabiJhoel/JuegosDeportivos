/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

/**
 *
 * @author Martinez
 */
public class Teams extends Competitor{
    private String phoneContact;
    private String emailContact;

    public Teams(String phoneContact, String emailContact,
            String countryCode, String name, String gender, String trainer, boolean type, int lodgingId) {
        super(countryCode, name, gender, trainer, type, lodgingId);
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    
}

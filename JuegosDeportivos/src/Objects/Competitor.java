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
public class Competitor {
    private String countryCode;
    private String name;
    private String gender;
    private String trainer;
    private boolean type;
    private int lodgingId;

    public Competitor(String pCountryCode, String pName, String pGender, String pTrainer,
            boolean pType, int pLodgingId) {
        this.countryCode = pCountryCode;
        this.name = pName;
        this.gender = pGender;
        this.trainer = pTrainer;
        this.type = pType;
        this.lodgingId = pLodgingId;
    }

    public String getCountryId() {
        return countryCode;
    }

    public void setCountryId(String pCountryCode) {
        this.countryCode = pCountryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getLodgingId() {
        return lodgingId;
    }

    public void setLodgingId(int lodgingId) {
        this.lodgingId = lodgingId;
    }
    
    
    
    
    
    
}

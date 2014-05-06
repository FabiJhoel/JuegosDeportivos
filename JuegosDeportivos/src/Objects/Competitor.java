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
    private int competitorId;
    private int countryId;
    private String name;
    private boolean gender;
    private String trainer;
    private boolean type;
    private int lodgingId;

    public Competitor(int pCompetitorId, int pCountryId, String pName, boolean pGender, String pTrainer,
            boolean pType, int pLodgingId) {
        this.competitorId = pCompetitorId;
        this.countryId = pCountryId;
        this.name = pName;
        this.gender = pGender;
        this.trainer = pTrainer;
        this.type = pType;
        this.lodgingId = pLodgingId;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int pCountryId) {
        this.countryId = pCountryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
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

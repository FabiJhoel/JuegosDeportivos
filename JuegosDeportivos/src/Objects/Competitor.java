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
    private String country;
    private String name;
    private boolean gender;
    private String trainer;
    private boolean type;
    private int lodgingId;

    public Competitor(int competitorId, String country, String name, boolean gender, String trainer, boolean type, int lodgingId) {
        this.competitorId = competitorId;
        this.country = country;
        this.name = name;
        this.gender = gender;
        this.trainer = trainer;
        this.type = type;
        this.lodgingId = lodgingId;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

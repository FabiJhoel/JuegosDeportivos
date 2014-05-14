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
public class Gender {
    private String codeGender;
    private String nameGender;


    public Gender(String codeGender, String nameGender) {
        this.codeGender = codeGender;
        this.nameGender = nameGender;
    }

    public String getCodeGender() {
        return codeGender;
    }

    public void setCodeGender(String codeGender) {
        this.codeGender = codeGender;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
    
    
    
}

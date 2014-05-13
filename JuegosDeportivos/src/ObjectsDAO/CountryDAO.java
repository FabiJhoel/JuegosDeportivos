/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjectsDAO;

import java.util.Collection;

/**
 *
 * @author Martinez
 */
public interface CountryDAO {
    public String getCodeCountry(String pCode);
    public Collection selectAllCountries();
}

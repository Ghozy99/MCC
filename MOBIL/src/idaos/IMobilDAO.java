/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Mobil;

/**
 *
 * @author ghoza
 */
public interface IMobilDAO {
    public List<Mobil> getAll();
    
    public Mobil getById(int car_id);
    
    public List<Mobil> search(String key);
    
    public Mobil insert(Mobil m);
    
    public Mobil update(Mobil m);
    
    public void delete(int car_id);
}

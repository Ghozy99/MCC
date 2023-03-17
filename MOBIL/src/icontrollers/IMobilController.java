/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Mobil;

/**
 *
 * @author ghoza
 */
public interface IMobilController {
    
    public List<Mobil> getAll();
    
    public Mobil getById(String id);
    
    public List<Mobil> search(String key);
    
    public String insert(String car_brand, int car_engine, String car_ready);

    public String update(String car_id, String car_brand, int car_engine, String car_ready);
    
    public String delete(String car_id);
}

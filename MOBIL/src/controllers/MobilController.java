/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.MobilDAO;
import icontrollers.IMobilController;
import idaos.IMobilDAO;
import java.sql.Connection;
import java.util.List;
import models.Mobil;

/**
 *
 * @author ghoza
 */
public class MobilController implements IMobilController {
    
    private IMobilDAO imdao;
    
    public MobilController(Connection connection) {
        imdao = new MobilDAO(connection);
    }
    
    @Override
    public List<Mobil> getAll() {
        return imdao.getAll();
    }

    @Override
    public Mobil getById(String id) {
         return imdao.getById(Integer.parseInt(id));
    }
    

    @Override
    public List<Mobil> search(String key) {
        return imdao.search(key);
    }

    @Override
    public String insert(String car_brand, int car_engine, String car_ready) {
        String result;
        Mobil mobil = new Mobil(car_brand, car_engine, car_ready);
        if (imdao.insert(mobil)!=null){
            result = "Data Berhasil Ditambahkan";
        } else {
            result = "Data Gagal Ditambahkan";
        }
        return result;
    }

    @Override
    public String update(String car_id, String car_brand, int car_engine, String car_ready) {
        String result;
        Mobil mobil = new Mobil(Integer.parseInt(car_id), car_brand, car_engine, car_ready);
        if (imdao.update(mobil)!=null) {
            result = "Data Berhasil diubah";
        } else {
            result = "Data Gagal Diubah";
        }
        return result;
    }

    @Override
    public String delete(String car_id) {
        String result;
        if (imdao.getById(Integer.parseInt(car_id))!=null){
            imdao.delete(Integer.parseInt(car_id));
            result = "Data berhasil dihapus";
        } else {
            result = "Data Gagal dihapus";
        }
        return result;
    }   
}

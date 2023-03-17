/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ghoza
 */
public class Mobil {

    public static void add(Mobil mobils) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int car_id;
    private String car_brand;
    private int car_engine;
    private String car_ready;


    public Mobil(){
}
    
    public Mobil(int car_id, String car_brand, int car_engine, String car_ready){
        this.car_id = car_id;
        this.car_brand = car_brand;
        this.car_engine = car_engine;
        this.car_ready = car_ready;
    }

    public Mobil(String car_brand, int car_engine, String car_ready) {
        this.car_brand = car_brand;
        this.car_engine = car_engine;
        this.car_ready = car_ready;
    }
    
    public int getId(){
        return car_id;
    }
    
    public String getBrand(){
        return car_brand;
    }
    
    public int getEngine(){
        return car_engine;
    }
    
    public String getReady(){
        return car_ready;
    }
    
    public void setId(int car_id){
        this.car_id = car_id;
    }
    
    public void setBrand(String car_brand){
        this.car_brand = car_brand;
    }
    
    public void setEngine(int car_engine){
        this.car_engine = car_engine;
    }
    
    public void setReady(String car_ready){
        this.car_ready = car_ready;
    }

    @Override
    public String toString() {
        return "Mobil{" + "car_id=" + car_id + ", car_brand=" + car_brand + ", car_engine=" + car_engine + ", car_ready=" + car_ready + '}';
    }
    
    
}


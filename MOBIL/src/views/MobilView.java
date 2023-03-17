/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MobilController;
import icontrollers.IMobilController;
import java.sql.Connection;
import java.util.Scanner;
import models.Mobil;

/**
 *
 * @author ghoza
 */
public class MobilView {
    
    private IMobilController imcontroller;
    private Scanner s;
    
    public MobilView(Connection connection) {
        this.imcontroller = new MobilController(connection);
        s = new Scanner(System.in);
    }
    
    // Method show untuk menampilkan seluruh isi arraylist mobil
    // Memiliki parameter bertipe list of class mobil
    public void show() {
        System.out.println("ID\t\tBrand\t\t\tEngine\t\t\tReady");
        
        System.out.println("___________________________________________________________________");
        //perulangan untuk tampilkan isi arraylist mobil
        for (Mobil mobil : imcontroller.getAll()) {
            System.out.println(mobil.getId() + "\t\t\t" + mobil.getBrand() + "\t\t" + mobil.getEngine() + "\t\t" + mobil.getReady());
        }
    }
    
    //Method insert untuk menambahkan isi arraylist mobil
    //memiliki parameter bertipe list of class mobil
    public void insert() {
        System.out.println("\n|||| MENU INSERT DATA MOBIL||||");
        System.out.println("SILAHKAN MASUKKAN DATA BERIKUT.");
        System.out.println("brand mobil:");
        String car_brand = s.nextLine();
        System.out.println("kapasitas mesin:");
        int car_engine = s.nextInt();
        System.out.println("apakah ready? 1)TERSEDIA 2)TIDAK TERSEDIA");
        int car_ready = s.nextInt();
        
        //opsi inputan variabel car_ready agar bertipe boolean
        switch (car_ready) {
            case 1:
                //menambahkan isi pada arraylist of mobil
                System.out.println(imcontroller.insert(car_brand, car_engine, "TERSEDIA"));
                break;
            
            case 2:
                //menambahkan isi pada arraylist of mobil
                System.out.println(imcontroller.insert(car_brand, car_engine, "TIDAK TERSEDIA"));
                break;
            default:
                System.out.println("Inputan salah, gagal insert data...");
                break;             
        }
    }
    
    // Method update untuk mengubah isi arraylist mobil
    // Memiliki parameter bertipe list of class mobil
    public void update() {
        System.out.println("\n||||| MENU UPDATE DATA VEHICLE |||||");
        
        // Memanggil method show untuk menampilkan seluruh isi arraylist of mobil
        show();
        System.out.println("Silahkan masukkan data berikut.");
        System.out.println("ID mobil yang ingin diubah : ");
        int id = s.nextInt();
        System.out.println("Brand mobil:");
        s.nextLine();
        String car_brand = s.nextLine();
        System.out.println("kapasitas mesin:");
        int car_engine = s.nextInt();
        System.out.println("apakah ready? 1)TERSEDIA 2)TIDAK TERSEDIA");
        int car_ready = s.nextInt();
        
        // Opsi inputan variabel available agar bertipe boolean
        switch (car_ready) {
            case 1:
                // Penggunaan try catch untuk mengatasi inputan yang tidak sesuai
                System.out.println(imcontroller.update(Integer.toString(id), car_brand, car_engine, "TERSEDIA"));
                break;
            case 2:
                // Penggunaan try catch untuk mengatasi inputan yang tidak sesuai
                System.out.println(imcontroller.update(Integer.toString(id), car_brand, car_engine, "TIDAK TERSEDIA"));
                break;
            default:
                System.out.println("Inputan salah, gagal update data..");
                break;
        }
    }
    
    // Method delete untuk menghapus isi arraylist mobil
    // Memiliki parameter bertipe list of class mobil
    public void delete() {
        System.out.println("\n||||| MENU DELETE DATA MOBIL |||||");
        show();
        System.out.println("Silahkan masukkan data berikut.");
        System.out.println("ID Mobil yang ingin dihapus : ");
        int id = s.nextInt();
        System.out.println("Apakah anda yakin? 1) IYA 2) TIDAK");
        int sure = s.nextInt();
        
        // Opsi eksekusi delete berdasarkan variabel sure
        switch (sure) {
            case 1:
                // Penggunaan try catch untuk mengatasi inputan yang tidak sesuai
                System.out.println(imcontroller.delete(Integer.toString(id)));
                break;
            case 2:
                break;
            default:
                System.out.println("Inputan salah, gagal delete data...");
                break;
        }
    }
    
    // Method search untuk menampilkan seluruh isi arraylist mobil
    // Memiliki parameter bertipe list of class mobil
    public void search() {
        System.out.println("\n|||| MENU SEARCH DATA MOBIL ||||");
        
        //Memanggil method show untuk menampilkan seluruh isi arraylist of mobil
        System.out.println("Silahkan masukkan data berikut.");
        System.out.println("cari kata kunci");
        String search = s.nextLine();
        System.out.println("ID\t\t\tBrand\t\tEngine\t\tReady");
        
        System.out.println("__________________________________________");
        //perulangan untuk menampilkan seluruh isi arraylist of mobil
        for (Mobil mobil : imcontroller.search(search)) {
            System.out.println(mobil.getId() + "\t\t\t" + mobil.getBrand() + "\t\t\t" + mobil.getEngine() + "\t\t\t" + mobil.getReady());
        }
    }
    
    // Method choice untuk menampilkan pilihan keluar aplikasi
    public boolean choice() {
        System.out.println("\nApakah ingin keluar? 1) YA  2) TIDAK");
        System.out.println("Silahkan Pilih: ");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        // Opsi pilihan berdasarkan variabel choice
        switch (choice) {
            case 1:
                System.out.println("@@@ Terima Kasih @@@");
                return false;
            case 2:
                return true;
            default:
                System.out.println("Inputan salah...");
                System.out.println("@@@ Terima Kasih @@@");
                return false;
        }
    }
}    


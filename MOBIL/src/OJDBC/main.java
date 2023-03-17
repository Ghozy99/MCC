/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OJDBC;

import java.util.Scanner;
import tools.MOBILConnection;
import views.MobilView;

/**
 *
 * @author ghoza
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MOBILConnection connection = new MOBILConnection();
        System.out.println(connection);

        MobilView imdao = new MobilView(connection.getConnection());
        Scanner s = new Scanner(System.in);
        
        System.out.println("------------APLIKASI DATA MOBIL-------------");
         
        // Inisialisasi dan deklarasi variabel loop
        boolean loop = true;
        // Perulangan untuk menampilkan menu
        while(loop) {
            System.out.println("----------------------------Menu----------------------------");
            System.out.println("1) Show All Data Mobil              2) Insert Data Mobil");
            System.out.println("3) Update Data Mobil                4) Delete Data Mobil");
            System.out.println("5) Search Data Mobil"); 
            System.out.println("\nSilahkan Pilih: ");
            // Input pilihan menu
            int menu = s.nextInt();
            // Condition opsi pilihan menu
            switch(menu) {
                case 1:
                    // Menjalankan method show dengan parameter list of mobil
                    imdao.show();
                    // Menjalankan method choice dan memasukkan hasilnya ke dalam variable loop
                    loop = imdao.choice();
                    break;
                case 2:
                    // Menjalankan method insert dengan parameter list of mobil
                    imdao.insert();
                    // Menjalankan method choice dan memasukkan hasilnya ke dalam variable loop
                    loop = imdao.choice();
                    break;
                case 3:
                    // Menjalankan method update dengan parameter list of mobil
                    imdao.update();
                    // Menjalankan method choice dan memasukkan hasilnya ke dalam variable loop
                    loop = imdao.choice();
                    break;
                case 4:
                    // Menjalankan method delete dengan parameter list of mobil
                    imdao.delete();
                    // Menjalankan method choice dan memasukkan hasilnya ke dalam variable loop
                    loop = imdao.choice();
                    break;
                case 5:
                    // Menjalankan method search dengan parameter list of mobil
                    imdao.search();
                    // Menjalankan method choice dan memasukkan hasilnya ke dalam variable loop
                    loop = imdao.choice();
                    break;
                default:
                    System.out.println("Pilihan salah, mohon pilihlah dengan benar.");
                    System.out.println("\n");
            }
        }
    }
}
        // getAll
//          for (Mobil mobils : imdao.getAll()) {
//                System.out.println("Daftar mobil dalam dealer kami");
//                System.out.print(mobils.getId()+ "\t"+mobils.getBrand()+"\t"+mobils.getEngine()+"\t"+ mobils.getReady());
//                System.out.println();
//          }
//    }
//}
        //getbyid
//          System.out.println(imdao.getById(1));
//    }
//}
        //Insert
//          Mobil mobils = new Mobil("Honda", 1500, "TIDAK TERSEDIA");
//          System.out.println(imdao.insert(mobils));
//    }
//}
        // update
//        Mobil mobils = new Mobil(2, "Ferrari", 5000, "TERSEDIA");
//        if (imdao.update(mobils) != null) {
//            System.out.println("berhasil");
//        } else {
//            System.out.println("gagal");
//        }
//    }
//}

        // delete
//          imdao.delete(2);
//    }
//}
        // search
//              List<Mobil> listMobil = imdao.search("T");
//              if (listMobil.isEmpty()){
//                  System.out.println("Tidak ditemukan ");
//              }
//              else{
//                    for (Mobil mobils : listMobil) {
//                         System.out.println(mobils.getId());
//                         System.out.println(mobils.getBrand());
//                    }
//              }
//    }

//
//     case 1:
//
//                    break;
//    }


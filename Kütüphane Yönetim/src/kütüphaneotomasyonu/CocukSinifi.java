package kütüphaneotomasyonu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sualp
 */

//Kalıtım kavramı için örnek bir alt sınıftır.
public class CocukSinifi extends EbeveynSinifi{
    int k;
    
    void showk(){
        System.out.println("k: "+k);
    }
    
    void showToplam(){
        System.out.println("i+j+k: "+(i+j+k));
        //i ve j üst sınıftan kalıtıldığı için burada da kullanabiliriz.
    }
}

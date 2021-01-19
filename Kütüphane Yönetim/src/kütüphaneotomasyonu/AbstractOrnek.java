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
//Abstract sınıf örneğidir.
public abstract class AbstractOrnek {
    public abstract int topla(int a, int b);
    
    public double bolme(int a, int b){
        double sonuc=a/b;
        System.out.println("Sonuc: "+sonuc);
        return sonuc;
    }
}

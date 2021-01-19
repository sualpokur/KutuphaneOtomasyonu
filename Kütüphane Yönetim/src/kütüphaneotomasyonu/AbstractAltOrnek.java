package kütüphaneotomasyonu;


import kütüphaneotomasyonu.AbstractOrnek;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sualp
 */
//Abstract yapısı için alt sınıf örneğidir.
public class AbstractAltOrnek extends AbstractOrnek{

    @Override
    public int topla(int a, int b) {
        int sonuc=a+b;
        return sonuc;
    }
    
}

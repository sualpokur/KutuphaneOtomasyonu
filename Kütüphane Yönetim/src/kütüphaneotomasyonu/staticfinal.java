/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kütüphaneotomasyonu;

/**
 *
 * @author emre_
 */
public class staticfinal {

public static int verilenkitap = 5; //Static değişken örneğidir. Son aldığı değeri döndürür.
public final int dönenkitap = 3; //Final değişken örneğidir. Değeri değişmez.
public static int toplama(int verilenkitap, int dönenkitap) { //Static metot örneğidir.
int sonuc = verilenkitap + dönenkitap;
return sonuc;
}
}
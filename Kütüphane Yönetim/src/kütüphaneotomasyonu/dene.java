/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kütüphaneotomasyonu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author emre_
 */
public class dene extends Calendar{
    
    public dene(){
        
    }

    @Override
    protected void computeTime() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void computeFields() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int field, int amount) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void roll(int field, boolean up) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinimum(int field) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
    static int[] tarihBaslangic = {0,2,2019,3,4};
    
    public static int getDiff(String eskiTarih)
    {
        String[] eskiT = eskiTarih.split("-");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String suan = dtf.format(now);
        String[] suanTemp = suan.split("-");
        int eski = hesap(new String[] {eskiT[2],eskiT[1],eskiT[0]});
        int yeni = hesap(suanTemp);
        return yeni-eski;
    }
    
    public static int[] sayisalDonusturRakamlardan(String[] date){

        // Verilen String tarihi int tarihe dönüştürür.

        return new int[]{Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])};
    }
    
    public static int hesap(String[] date){

        // Verilen tarihin ({Gün, Ay İsmi, Yıl}) haftanın hangi gününe denk olduğunu belirler.

        int[] tutucu = sayisalDonusturRakamlardan(date);
        tutucu[0] = tutucu[0] - 1;
        tutucu[1] = tutucu[1] - 1;
        int gun_fark = 0;
        int yil_fark = tutucu[2]-tarihBaslangic[2];

        for (int i = 0 ; i < yil_fark*12 + tutucu[1]-tarihBaslangic[1] ; i++){

            if ((tarihBaslangic[1] + i)%12 == 1){
                gun_fark += 28;
            }
            else if (((tarihBaslangic[1] + i)%12)%2 == 0 && (tarihBaslangic[1] + i)%12 < 7){
                gun_fark += 31;
            }
            else if (((tarihBaslangic[1] + i)%12)%2 == 1 && (tarihBaslangic[1] + i)%12 < 7){
                gun_fark += 30;
            }
            else if (((tarihBaslangic[1] + i)%12)%2 == 0 && (tarihBaslangic[1] + i)%12 > 6){
                gun_fark += 30;
            }
            else if (((tarihBaslangic[1] + i)%12)%2 == 1 && (tarihBaslangic[1] + i)%12 > 6){
                gun_fark += 31;
            }
        }


        gun_fark += tutucu[0];

        gun_fark += (((gun_fark)/365) + tarihBaslangic[3]) /4;

        return gun_fark;
    }
}

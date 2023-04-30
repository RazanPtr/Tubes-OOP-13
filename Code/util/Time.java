package util;
public class Time {
    
    private int day;
    private int min;
    private int sec;

    public Time(){
        day = 1;
        min = 0;
        sec = 0;
    }

    public void setDay(int d){
        this.day = d;
    }

    public int getDay(){
        return day;
    }

    public void setMin(int m){
        this.min = m;
    }

    public int getMin(){
        return min;
    }
    
    public void setSec(int s){
        this.sec = s;
    }

    public int getSec(){
        return sec;
    }

    public void setTime(int d, int m, int s){
        this.day = d;
        this.min = m;
        this.sec = s;
    }

    public int getTimeInSec(){
        return((min*60)+sec);
    }

    public void updateTime(int s){
        int temp = getTimeInSec();
        temp += s;
        if(temp > 720){
            day += (temp/720);
            temp %= 720;  
        }

        min = temp/60;
        sec = temp%60;
    }

    public int getSisaMenit(){
        return ((720 - getTimeInSec())/60);
    }

    public int getSisaDetik(){
        return ((720 - getTimeInSec())%60);
    }

    public void CetakWaktu(){
        System.out.println("Hari ini adalah hari ke-" + getDay() + " dan saat ini waktu menunjukkan pukul " + getMin()+":" + getSec() +" WBS (Waktu Bagian Simplicity)");
    }

    public void CetakSisaWaktu(){
        System.out.println("Sisa waktu hari ini adalah " + getSisaMenit() + " menit dan " + getSisaDetik() + " detik");
    }

    public void AksiSleep(int duration) {
        try {
            Thread.sleep(duration*1000);
            updateTime(duration);
        }
        catch(Exception e) {
            Thread.interrupted();
        }
    }
    
}
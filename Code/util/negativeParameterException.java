package util;

public class negativeParameterException extends Exception{
    private int amount;

    public negativeParameterException(int amount){
        this.amount = amount;
    }

    public String getMessage(){
        return ("Angka yang dimasukkan bernilai negatif: " + amount);
    }
}


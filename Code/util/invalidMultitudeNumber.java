package util;

public class invalidMultitudeNumber extends Exception {
    private int amount;

    public invalidMultitudeNumber(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return (amount + " adalah jumlah yang tidak valid, silahkan input jumlah lain");
    }
}
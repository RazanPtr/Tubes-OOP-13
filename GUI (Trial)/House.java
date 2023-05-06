public class House {
    private int houseNumber;
    private String residentName;
    private boolean isOccupied;
    
    public House(int houseNumber) {
        this.houseNumber = houseNumber;
        this.residentName = "";
    }
    
    public int getHouseNumber() {
        return houseNumber;
    }
    
    public String getResidentName() {
        return residentName;
    }
    
    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }
}

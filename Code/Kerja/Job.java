public class Job {
    private String title;
    private int payRate;

    public Job(String title, int payRate) {
        this.title = title;
        this.payRate = payRate;
    }

    public String getTitle() {
        return title;
    }

    public int getPayRate() {
        return payRate;
    }
}
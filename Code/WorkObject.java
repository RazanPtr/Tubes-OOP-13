import java.util.Random;

public class WorkObject {
    private Job job;

    public WorkObject() {
        this.job = getRandomJob();
    }

    private Job getRandomJob() {
        Job[] jobs = {
            new Job("Badut Sulap", 15),
            new Job("Koki", 30),
            new Job("Polisi", 100),
            new Job("Programmer", 40),
            new Job("Dokter", 45)
        };

        Random rand = new Random();
        int index = rand.nextInt(jobs.length);
        return jobs[index];
    }

    public Job getJob() {
        return job;
    }
}
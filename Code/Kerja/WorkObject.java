import java.util.Random;

public class WorkObject {
    private Job job;

    public WorkObject() {
        this.job = getRandomJob();
    }

    private Job getRandomJob() {
        Job[] jobs = {
            new Job("Programmer", 50),
            new Job("Teacher", 30),
            new Job("Doctor", 100),
            new Job("Chef", 25),
            new Job("Artist", 40)
        };

        Random rand = new Random();
        int index = rand.nextInt(jobs.length);
        return jobs[index];
    }

    public Job getJob() {
        return job;
    }
}
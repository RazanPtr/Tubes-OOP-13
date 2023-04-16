import java.util.Random;

public class WorkObject {
    private String name;
    private Job job;

    public WorkObject(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public Job getJob() {
        return job;
    }
}
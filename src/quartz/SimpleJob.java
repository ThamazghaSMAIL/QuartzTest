package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleJob implements Job {
    
    private final Logger log = LoggerFactory.getLogger(SimpleJob.class);
 
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("SimpleJob executed!");
    }
}

package com.start.kafka;

import org.junit.Test;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class PlayKafkaApplicationTest {

    @Test
    public void testScheduler(){
        // to test if a cron expression runs only from Monday to Friday
        org.springframework.scheduling.support.CronTrigger trigger =
                new CronTrigger("0 0 1 * * MON-FRI");
        Calendar today = Calendar.getInstance();
        today.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEEE");
        final Date yesterday = today.getTime();
        System.out.println("Yesterday was : " + df.format(yesterday));
        Date nextExecutionTime = trigger.nextExecutionTime(
                new TriggerContext() {

                    @Override
                    public Date lastScheduledExecutionTime() {
                        return yesterday;
                    }

                    @Override
                    public Date lastActualExecutionTime() {
                        return yesterday;
                    }

                    @Override
                    public Date lastCompletionTime() {
                        return yesterday;
                    }
                });

        String message = "Next Execution date: " + df.format(nextExecutionTime);
        System.out.println(message);

    }

}
package video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class Monitor {
    @Autowired
    private MySQLController mySQLController;

    @PostConstruct
    public void init(){
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                mySQLController.checkHeartBeat();
            }
        };
        Timer timer = new Timer("Timer");

        long delay  = 1000L;
        long period = 5000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }
}
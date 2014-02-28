package pratice.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @author hubery
 */
public class Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    public void doSomething() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        StringBuffer sb = new StringBuffer();
        sb.append("thread name is ").append(Thread.currentThread().getName());
        sb.append(", executing time is ").append(Calendar.getInstance().get(13)).append(" s");
        System.out.println(sb);
    }
}

package pratice.date;

import com.quidsi.core.util.StringUtils;

/**
 * @author hubery.chen
 */
public class RequiredIntervalTimeConvertor {

    public static final String NOT_CONFIGURED = "Not Configured";

    public static void main(String[] args){
        System.out.println(RequiredIntervalTimeConvertor.getRequiredInterValTime("24 Hours"));;
    }

    public static long getRequiredInterValTime(String requiredInterval) {
        long requiredIntervalTime = 0;
        if (StringUtils.hasText(requiredInterval) && !NOT_CONFIGURED.equals(requiredInterval)) {
            int hourIndex = requiredInterval.indexOf("Hour");
            if (hourIndex > 0) {
                requiredIntervalTime = Long.valueOf(requiredInterval.substring(0, hourIndex).trim()) * 60 * 60 * 1000;
            }
            int minutesIndex = requiredInterval.indexOf("Minutes");
            if (minutesIndex > 0) {
                requiredIntervalTime = Long.valueOf(requiredInterval.substring(0, minutesIndex).trim()) * 60 * 1000;
            }
        }
        return requiredIntervalTime;
    }
}

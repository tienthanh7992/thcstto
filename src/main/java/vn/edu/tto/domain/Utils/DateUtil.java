package vn.edu.tto.domain.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static int getCurrentMonth() {
        return Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
    }
}

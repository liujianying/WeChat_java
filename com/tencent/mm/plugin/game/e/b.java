package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.mm.plugin.game.f.g;
import com.tencent.mm.plugin.game.f.i;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    public static HashMap<Long, Long> hsA = new HashMap();
    public static HashMap<Long, String> hsB = new HashMap();
    private static Map<String, List<String>> kdg = new HashMap();
    private static Map<String, List<String>> kdh = new HashMap();

    public static String g(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (hsA.containsKey(Long.valueOf(j))) {
            if (timeInMillis - ((Long) hsA.get(Long.valueOf(j))).longValue() >= 60000) {
                hsA.remove(Long.valueOf(j));
            } else if (hsB.containsKey(Long.valueOf(j))) {
                return (String) hsB.get(Long.valueOf(j));
            }
        }
        int i;
        String quantityString;
        if ((timeInMillis - j) / 3600000 == 0) {
            i = (int) ((timeInMillis - j) / 60000);
            if (i <= 0) {
                i = 1;
            }
            quantityString = context.getResources().getQuantityString(g.fmt_in60min, i, new Object[]{Integer.valueOf(i)});
            hsB.put(Long.valueOf(j), quantityString);
            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
            timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                if (i <= 0) {
                    i = 1;
                }
                quantityString = context.getResources().getQuantityString(g.fmt_indayh, i, new Object[]{Integer.valueOf(i)});
                hsB.put(Long.valueOf(j), quantityString);
                hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                return quantityString;
            }
            quantityString = context.getString(i.fmt_pre_yesterday);
            hsB.put(Long.valueOf(j), quantityString);
            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        i = (int) ((timeInMillis - j) / 3600000);
        if (i <= 0) {
            i = 1;
        }
        quantityString = context.getResources().getQuantityString(g.fmt_in24h, i, new Object[]{Integer.valueOf(i)});
        hsB.put(Long.valueOf(j), quantityString);
        hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
        return quantityString;
    }
}

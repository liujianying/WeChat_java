package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.h;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class a {
    private static HashMap<Long, Long> hsA = new HashMap();
    private static HashMap<Long, String> hsB = new HashMap();

    public static synchronized String e(Context context, long j) {
        String str;
        synchronized (a.class) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (hsA.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) hsA.get(Long.valueOf(j))).longValue() >= 60000) {
                        hsA.remove(Long.valueOf(j));
                    } else if (hsB.containsKey(Long.valueOf(j))) {
                        str = (String) hsB.get(Long.valueOf(j));
                    }
                }
                int i;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i = (int) ((timeInMillis - j) / 60000);
                    if (i <= 0) {
                        i = 1;
                    }
                    str = context.getResources().getQuantityString(f.fmt_in60min, i, new Object[]{Integer.valueOf(i)});
                    hsB.put(Long.valueOf(j), str);
                    hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                            i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i <= 0) {
                                i = 1;
                            }
                            str = context.getResources().getQuantityString(f.fmt_indayh, i, new Object[]{Integer.valueOf(i)});
                            hsB.put(Long.valueOf(j), str);
                            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        } else {
                            str = context.getString(h.fmt_pre_yesterday);
                            hsB.put(Long.valueOf(j), str);
                            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(f.fmt_in24h, i, new Object[]{Integer.valueOf(i)});
                        hsB.put(Long.valueOf(j), str);
                        hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                    }
                }
            }
        }
        return str;
    }
}

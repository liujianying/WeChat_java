package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.text.format.DateFormat;
import java.util.GregorianCalendar;

public final class i {
    public static CharSequence v(Context context, int i) {
        if (i <= 0) {
            return context.getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_second_format, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        }
        int i2 = i / 60;
        int i3 = i % 60;
        return context.getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_second_format, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static CharSequence f(Context context, long j) {
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return context.getString(com.tencent.mm.plugin.fav.ui.m.i.fmt_pre_nowday);
        }
        long timeInMillis2 = gregorianCalendar2.getTimeInMillis() - j;
        if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
            return context.getString(com.tencent.mm.plugin.fav.ui.m.i.fmt_pre_yesterday);
        }
        new GregorianCalendar().setTimeInMillis(j);
        int timeInMillis3 = (int) ((gregorianCalendar.getTimeInMillis() - j) / 86400000);
        if (timeInMillis3 <= 0) {
            timeInMillis3 = 1;
        }
        if (timeInMillis3 > 30) {
            return DateFormat.format(context.getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_longdate), j);
        }
        return context.getResources().getQuantityString(m$g.fmt_indayh, timeInMillis3, new Object[]{Integer.valueOf(timeInMillis3)});
    }
}

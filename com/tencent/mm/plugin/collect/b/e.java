package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    public static String a(Context context, long j, int i) {
        long j2 = 1000 * j;
        if (i == 0) {
            return new SimpleDateFormat(context.getString(i.collect_bill_date_day_format)).format(new Date(j2));
        }
        if (i == 1) {
            return new SimpleDateFormat(context.getString(i.collect_bill_date_month_format)).format(new Date(j2));
        }
        return new SimpleDateFormat(context.getString(i.collect_bill_date_year_format)).format(new Date(j2));
    }

    public static String os(int i) {
        return String.format("%.2f", new Object[]{Double.valueOf(((double) i) / 100.0d)});
    }
}

package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.mm.w.a.k;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a utQ;
    private long utN = Calendar.getInstance().getTimeInMillis();
    private long utO;
    private long utP;

    public static a czj() {
        if (utQ == null) {
            synchronized (a.class) {
                utQ = new a();
            }
        }
        return utQ;
    }

    private a() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.utO = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.utP = instance.getTimeInMillis();
    }

    public final long b(Date date) {
        if (date.getTime() >= this.utO) {
            return Long.MAX_VALUE;
        }
        if (date.getTime() >= this.utP) {
            return 9223372036854775806L;
        }
        return (long) ((date.getYear() * 100) + date.getMonth());
    }

    public static long gO(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public final String a(Date date, Context context) {
        if (date.getTime() >= this.utO) {
            return context.getString(k.this_week);
        }
        if (date.getTime() >= this.utP) {
            return context.getString(k.this_month);
        }
        return String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
    }
}

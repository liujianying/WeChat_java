package com.google.android.gms.c;

import android.os.SystemClock;

public final class w implements v {
    private static w aXM;

    public static synchronized v qf() {
        w wVar;
        synchronized (w.class) {
            if (aXM == null) {
                aXM = new w();
            }
            wVar = aXM;
        }
        return wVar;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}

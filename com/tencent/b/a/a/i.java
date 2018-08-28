package com.tencent.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;

public class i {
    static f bvA = null;
    public static volatile long bvB = 0;
    static h bvC = null;
    private static i bvz = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g bvD = null;

    private i(Context context) {
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        bvB = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
    }

    public static i aF(Context context) {
        if (bvz == null) {
            synchronized (i.class) {
                if (bvz == null) {
                    bvz = new i(context);
                }
            }
        }
        return bvz;
    }

    public static void a(f fVar) {
        bvA = fVar;
    }

    public final String tO() {
        if (this.bvD == null || !s.cj(this.bvD.bvx)) {
            int i;
            this.bvD = r.aH(mContext).tT();
            if (s.cj(this.bvD.bvx)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.bvD.bvx);
        }
        return this.bvD.bvx;
    }

    public final String tP() {
        if (this.bvD == null || !s.cj(this.bvD.bvx)) {
            this.bvD = r.aH(mContext).tT();
        }
        return this.bvD.bvx;
    }
}

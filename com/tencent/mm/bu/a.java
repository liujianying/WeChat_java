package com.tencent.mm.bu;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;

public class a {
    private static volatile a tft;
    private ag mHandler;
    private HandlerThread mHandlerThread = e.Xs("WorkerThread#" + hashCode());
    private ag tfu;

    private static a cop() {
        if (tft == null) {
            synchronized (a.class) {
                if (tft == null) {
                    tft = new a();
                }
            }
        }
        return tft;
    }

    private a() {
        this.mHandlerThread.start();
        this.mHandler = new ag(this.mHandlerThread.getLooper());
        this.tfu = new ag(Looper.getMainLooper());
    }

    public static HandlerThread coq() {
        return cop().mHandlerThread;
    }

    public static boolean post(Runnable runnable) {
        return cop().mHandler.post(runnable);
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        return cop().mHandler.postDelayed(runnable, j);
    }

    public static boolean ab(Runnable runnable) {
        return cop().tfu.post(runnable);
    }

    public static boolean j(Runnable runnable, long j) {
        return cop().tfu.postDelayed(runnable, j);
    }
}

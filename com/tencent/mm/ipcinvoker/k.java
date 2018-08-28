package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class k {
    private static volatile k dmI;
    private Handler dmJ;
    private l dmK;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("ThreadCaller#Worker-" + hashCode());

    private static k Cu() {
        if (dmI == null) {
            synchronized (k.class) {
                if (dmI == null) {
                    dmI = new k();
                }
            }
        }
        return dmI;
    }

    private k() {
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.dmJ = new Handler(Looper.getMainLooper());
        this.dmK = l.Cw();
    }

    public static boolean h(Runnable runnable) {
        Cu().dmK.dmN.execute(runnable);
        return true;
    }
}

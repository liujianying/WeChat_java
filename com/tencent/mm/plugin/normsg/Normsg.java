package com.tencent.mm.plugin.normsg;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;

@Keep
public abstract class Normsg {
    static {
        initializeOnMainThread();
    }

    private static final void initializeOnMainThread() {
        Object obj = new boolean[]{null};
        1 1 = new 1(obj);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            1.run();
            return;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(1);
        synchronized (obj) {
            while (!obj[0]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

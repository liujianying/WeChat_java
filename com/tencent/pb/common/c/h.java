package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class h {
    public static Handler gA = new Handler(Looper.getMainLooper());

    public static void af(Runnable runnable) {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) != null) {
            runnable.run();
        } else {
            gA.post(runnable);
        }
    }
}

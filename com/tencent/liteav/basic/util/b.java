package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class b {
    private Handler a;
    private Looper b;
    private boolean c = true;
    private Thread d;

    public b(String str) {
        Thread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.b = handlerThread.getLooper();
        this.a = new Handler(this.b);
        this.d = handlerThread;
    }

    public Handler a() {
        return this.a;
    }

    protected void finalize() {
        if (this.c) {
            this.a.getLooper().quit();
        }
        super.finalize();
    }

    public void a(Runnable runnable) {
        boolean[] zArr = new boolean[1];
        if (Thread.currentThread().equals(this.d)) {
            runnable.run();
            return;
        }
        synchronized (this.a) {
            zArr[0] = false;
            this.a.post(new 1(this, runnable, zArr));
            while (!zArr[0]) {
                try {
                    this.a.wait();
                } catch (Exception e) {
                }
            }
        }
    }

    public void b(Runnable runnable) {
        this.a.post(runnable);
    }
}

package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a uRL = new a();
    private Handler mHandler;
    public HandlerThread uRK = new HandlerThread("Vending-HeavyWorkThread", 10);

    private a() {
        this.uRK.start();
        this.mHandler = new Handler(this.uRK.getLooper());
    }

    public static a cBO() {
        return uRL;
    }
}

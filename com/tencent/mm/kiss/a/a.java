package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a dtd = new a();
    public HandlerThread dtc = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        this.dtc.start();
        this.mHandler = new Handler(this.dtc.getLooper());
    }

    public static a EX() {
        return dtd;
    }
}

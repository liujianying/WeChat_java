package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b {
    private static b uRN = new b();
    private Handler mHandler;
    public HandlerThread uRM = new HandlerThread("Vending-LogicThread");

    private b() {
        this.uRM.start();
        this.mHandler = new Handler(this.uRM.getLooper());
    }

    public static b cBP() {
        return uRN;
    }
}

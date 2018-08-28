package com.google.android.exoplayer2.i;

import java.util.concurrent.ThreadFactory;

class t$1 implements ThreadFactory {
    final /* synthetic */ String aCM;

    t$1(String str) {
        this.aCM = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.aCM);
    }
}

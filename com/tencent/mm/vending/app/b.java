package com.tencent.mm.vending.app;

import android.os.Handler;
import android.util.SparseIntArray;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b uPS;
    Map<c, a> uPT = new ConcurrentHashMap();
    final SparseIntArray uPU = new SparseIntArray();
    final Handler uPV = new 1(this, com.tencent.mm.vending.i.b.cBP().uRM.getLooper());

    static {
        uPS = null;
        uPS = new b();
    }

    public static b cBv() {
        return uPS;
    }
}

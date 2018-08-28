package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.ba;

public class b<T> extends ba<T> {
    private final Object mLock = new Object();

    public b() {
        super(20);
    }

    public final T bW() {
        T bW;
        synchronized (this.mLock) {
            bW = super.bW();
        }
        return bW;
    }

    public final boolean j(T t) {
        boolean j;
        synchronized (this.mLock) {
            j = super.j(t);
        }
        return j;
    }
}

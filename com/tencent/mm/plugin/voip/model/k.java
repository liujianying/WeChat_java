package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class k {
    private static k oKr = new k();
    private ReentrantLock bvV = new ReentrantLock();
    private j oKs;

    private k() {
    }

    public static j bKc() {
        if (oKr.oKs == null) {
            oKr.bvV.lock();
            try {
                if (oKr.oKs == null) {
                    oKr.oKs = new j();
                }
                oKr.bvV.unlock();
            } catch (Throwable th) {
                oKr.bvV.unlock();
            }
        }
        return oKr.oKs;
    }
}

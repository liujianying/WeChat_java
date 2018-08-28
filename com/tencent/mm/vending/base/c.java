package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.f.a;

public final class c {
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private Looper uQt;
    private Handler uQu;
    byte[] uQv = new byte[0];
    a uQw;

    public c(Looper looper, Looper looper2) {
        this.uQt = looper;
        this.mVendingLooper = looper2;
        this.uQu = new 1(this, this.uQt);
        this.mVendingHandler = new 2(this, this.mVendingLooper);
    }

    public final void l(int i, Object obj) {
        if (Looper.myLooper() == this.uQt) {
            if (this.uQw == null) {
                a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                return;
            }
            this.uQw.cBy();
            synchronized (this.uQv) {
                this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i, obj));
                try {
                    this.uQv.wait();
                } catch (InterruptedException e) {
                }
            }
            this.uQw.cBz();
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.uQu.sendMessageAtFrontOfQueue(this.uQu.obtainMessage(i, obj));
        }
    }
}

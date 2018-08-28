package com.google.android.gms.a.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class a$b extends Thread {
    private WeakReference<a> aEr;
    private long aEs;
    CountDownLatch aEt = new CountDownLatch(1);
    boolean aEu = false;

    public a$b(a aVar, long j) {
        this.aEr = new WeakReference(aVar);
        this.aEs = j;
        start();
    }

    private void disconnect() {
        a aVar = (a) this.aEr.get();
        if (aVar != null) {
            aVar.finish();
            this.aEu = true;
        }
    }

    public final void run() {
        try {
            if (!this.aEt.await(this.aEs, TimeUnit.MILLISECONDS)) {
                disconnect();
            }
        } catch (InterruptedException e) {
            disconnect();
        }
    }
}

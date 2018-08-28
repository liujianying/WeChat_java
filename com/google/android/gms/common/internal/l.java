package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class l implements Callback {
    public final Object aNW = new Object();
    public final a aOo;
    public final ArrayList<b> aOp = new ArrayList();
    public final ArrayList<b> aOq = new ArrayList();
    public final ArrayList<c> aOr = new ArrayList();
    public volatile boolean aOs = false;
    public final AtomicInteger aOt = new AtomicInteger(0);
    public boolean aOu = false;
    public final Handler mHandler;

    public l(Looper looper, a aVar) {
        this.aOo = aVar;
        this.mHandler = new Handler(looper, this);
    }

    public final void a(b bVar) {
        w.ah(bVar);
        synchronized (this.aNW) {
            if (this.aOp.contains(bVar)) {
                new StringBuilder("registerConnectionCallbacks(): listener ").append(bVar).append(" is already registered");
            } else {
                this.aOp.add(bVar);
            }
        }
        if (this.aOo.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bVar));
        }
    }

    public final void a(c cVar) {
        w.ah(cVar);
        synchronized (this.aNW) {
            if (this.aOr.contains(cVar)) {
                new StringBuilder("registerConnectionFailedListener(): listener ").append(cVar).append(" is already registered");
            } else {
                this.aOr.add(cVar);
            }
        }
    }

    public final void dt(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        w.d(z, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.aNW) {
            this.aOu = true;
            ArrayList arrayList = new ArrayList(this.aOp);
            int i2 = this.aOt.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.aOs && this.aOt.get() == i2) {
                    if (this.aOp.contains(bVar)) {
                        bVar.dm(i);
                    }
                }
            }
            this.aOq.clear();
            this.aOu = false;
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            b bVar = (b) message.obj;
            synchronized (this.aNW) {
                if (this.aOs && this.aOo.isConnected() && this.aOp.contains(bVar)) {
                    bVar.e(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public final void pm() {
        this.aOs = false;
        this.aOt.incrementAndGet();
    }
}

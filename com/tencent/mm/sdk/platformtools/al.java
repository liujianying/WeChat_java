package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class al extends ag {
    private static int sGq;
    private final boolean gaE;
    private boolean mStop = false;
    private long sGZ = 0;
    private final int sGr;
    private final a sHa;

    public interface a {
        boolean vD();
    }

    public al(a aVar, boolean z) {
        this.sHa = aVar;
        this.sGr = cip();
        this.gaE = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bi.cjd());
        }
    }

    public al(Looper looper, a aVar, boolean z) {
        super(looper);
        this.sHa = aVar;
        this.sGr = cip();
        this.gaE = z;
        if (looper.getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bi.cjd());
        }
    }

    private static int cip() {
        if (sGq >= 8192) {
            sGq = 0;
        }
        int i = sGq + 1;
        sGq = i;
        return i;
    }

    protected void finalize() {
        SO();
        super.finalize();
    }

    public void handleMessage(Message message) {
        if (message.what == this.sGr && this.sHa != null && this.sHa.vD() && this.gaE && !this.mStop) {
            sendEmptyMessageDelayed(this.sGr, this.sGZ);
        }
    }

    public final void fZ(long j) {
        J(j, j);
    }

    public final void SO() {
        removeMessages(this.sGr);
        this.mStop = true;
    }

    public final void J(long j, long j2) {
        this.sGZ = j2;
        SO();
        this.mStop = false;
        sendEmptyMessageDelayed(this.sGr, j);
    }

    public final boolean ciq() {
        return this.mStop || !hasMessages(this.sGr);
    }

    public String toString() {
        if (this.sHa == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.sHa.getClass().getName() + "}";
    }
}

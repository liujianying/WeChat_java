package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class ai extends Handler implements com.tencent.mm.sdk.platformtools.am.a {
    private Looper sGK = getLooper();
    private Callback sGL;
    a sGM;
    private String toStringResult = null;

    public interface a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f);

        void onTaskAdded(Runnable runnable, am amVar);

        void onTaskRunEnd(Runnable runnable, am amVar);
    }

    ai(a aVar) {
        this.sGM = aVar;
    }

    ai(Looper looper, a aVar) {
        super(looper);
        this.sGM = aVar;
    }

    ai(Callback callback, a aVar) {
        super(callback);
        this.sGL = callback;
        this.sGM = aVar;
    }

    ai(Looper looper, Callback callback, a aVar) {
        super(looper, callback);
        this.sGL = callback;
        this.sGM = aVar;
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        am amVar = new am(this.sGK.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            amVar.sHg = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), amVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.sGM != null) {
                this.sGM.onTaskAdded(callback, amVar);
            }
            boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
            if (sendMessageAtTime || this.sGM == null) {
                return sendMessageAtTime;
            }
            this.sGM.onTaskRunEnd(callback, amVar);
            return sendMessageAtTime;
        }
        x.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        return false;
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.sGL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.sGM != null) {
                this.sGM.onLog(message, null, this.sGK.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, -1.0f);
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
        if (this.sGM != null) {
            this.sGM.handleMessage(message);
        }
    }

    public final String toString() {
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.sGM + "}";
        }
        return this.toStringResult;
    }

    public final void a(Runnable runnable, am amVar) {
        if (this.sGM != null) {
            this.sGM.onTaskRunEnd(runnable, amVar);
        }
    }

    public final void a(Runnable runnable, Thread thread, long j, long j2, float f) {
        if (this.sGM != null) {
            this.sGM.onLog(null, runnable, thread, j, j2, f);
        }
    }
}

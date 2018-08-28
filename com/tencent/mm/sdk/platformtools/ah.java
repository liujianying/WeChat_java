package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import junit.framework.Assert;

public class ah {
    private static ag sGE = null;
    private ag iYd = null;
    public HandlerThread lnJ = null;
    private String threadName = null;

    public interface a {
        boolean Kr();

        boolean Ks();
    }

    public interface b {
        void En();
    }

    private void sW(String str) {
        this.iYd = null;
        if (bi.oW(str)) {
            str = "MMHandlerThread";
        }
        this.threadName = str;
        this.lnJ = e.cZ(this.threadName, 0);
        this.lnJ.start();
    }

    public static void Db(int i) {
        try {
            Process.setThreadPriority(i);
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
        } catch (Throwable e) {
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cii() {
        if (this.lnJ == null || !this.lnJ.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            return;
        }
        int threadId = this.lnJ.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 19);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final int cij() {
        if (this.lnJ == null) {
            return -1;
        }
        return this.lnJ.getThreadId();
    }

    public final void uW() {
        if (this.lnJ == null || !this.lnJ.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.lnJ.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cik() {
        if (this.lnJ == null || !this.lnJ.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            return;
        }
        int threadId = this.lnJ.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                x.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 0);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public ah() {
        x.i("MicroMsg.MMHandlerThread", "init stack:%s", bi.cjd());
        sW(null);
    }

    public ah(String str) {
        sW(str);
    }

    public final ag cil() {
        if (this.iYd == null) {
            this.iYd = new ag(this.lnJ.getLooper());
        }
        return this.iYd;
    }

    public final int a(final b bVar) {
        int a;
        x.i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), bi.cjd());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.lnJ.getId();
        final Object obj = new byte[0];
        final String str = this.threadName;
        a anonymousClass1 = new a() {
            public final boolean Ks() {
                x.i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                return true;
            }

            public final boolean Kr() {
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (bVar != null) {
                    bVar.En();
                }
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                ah.this.lnJ.quit();
                x.i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(ah.this.lnJ.getId()));
                ah.this.sW(str);
                x.i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(ah.this.lnJ.getId()));
                synchronized (obj) {
                    x.i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                    obj.notify();
                }
                return true;
            }
        };
        synchronized (obj) {
            a = a(anonymousClass1);
            x.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.lnJ.getId()));
            if (a == 0 && id == r4) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    x.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
                }
            }
        }
        return a;
    }

    public int H(Runnable runnable) {
        if (runnable == null) {
            return -1;
        }
        cil().post(runnable);
        return 0;
    }

    public final int L(Runnable runnable) {
        cil().postAtFrontOfQueueV2(runnable);
        return 0;
    }

    public final int h(Runnable runnable, long j) {
        if (runnable == null) {
            return -1;
        }
        cil().postDelayed(runnable, j);
        return 0;
    }

    public final int a(final a aVar) {
        return new ag(this.lnJ.getLooper()).postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                aVar.Kr();
                ah.cim().postAtFrontOfQueueV2(new Runnable() {
                    public final void run() {
                        aVar.Ks();
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|" + aVar.toString();
            }
        }) ? 0 : -2;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    private static ag cim() {
        if (sGE == null) {
            sGE = new ag(Looper.getMainLooper());
        }
        return sGE;
    }

    public static void A(Runnable runnable) {
        if (runnable != null) {
            cim().post(runnable);
        }
    }

    public static void i(Runnable runnable, long j) {
        if (runnable != null) {
            cim().postDelayed(runnable, j);
        }
    }

    public static void M(Runnable runnable) {
        if (runnable != null) {
            cim().removeCallbacks(runnable);
        }
    }
}

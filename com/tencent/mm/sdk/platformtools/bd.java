package com.tencent.mm.sdk.platformtools;

public abstract class bd<R> {
    long dCL;
    private final long dJH;
    private Object lock;
    private R result;
    private Runnable sHb;
    long sJd;
    boolean sJe;

    public abstract R run();

    public bd() {
        this(0, null, (byte) 0);
    }

    public bd(long j, R r) {
        this.lock = new Object();
        this.sJe = false;
        this.sHb = new 1(this);
        this.dJH = j;
        this.result = r;
        this.sJe = true;
    }

    public bd(long j, R r, byte b) {
        this.lock = new Object();
        this.sJe = false;
        this.sHb = new 1(this);
        this.dJH = j;
        this.result = r;
    }

    public final void cf(R r) {
        x.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            x.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R a(ag agVar) {
        if (agVar == null) {
            x.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        x.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == agVar.getLooper().getThread().getId()) {
            x.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.dCL = bi.VG();
        try {
            synchronized (this.lock) {
                x.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                agVar.post(this.sHb);
                this.lock.wait(this.dJH);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long bI = bi.bI(this.dCL);
        x.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[]{this.result, Long.valueOf(bI), Long.valueOf(this.sJd), Long.valueOf(bI - this.sJd)});
        return this.result;
    }
}

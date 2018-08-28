package com.tencent.mm.model;

import com.tencent.mm.g.a.rj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class bu {
    private a dDu = null;
    private long dDv = 0;
    private long dDw = 0;
    private String dDx = "";
    private int dDy = 1;

    public bu(a aVar) {
        Assert.assertTrue(true);
        this.dDu = aVar;
        IJ();
    }

    private void IJ() {
        this.dDy = 1;
        this.dDv = 0;
        this.dDw = 0;
        this.dDx = "";
    }

    public final synchronized boolean IK() {
        boolean z = true;
        synchronized (this) {
            long VF = bi.VF();
            this.dDx = bi.cjd().toString();
            if (this.dDy == 1) {
                this.dDw = VF;
                this.dDv = 1800000;
                x.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", new Object[]{Long.valueOf(1800000), this.dDx});
                this.dDy = 2;
                if (this.dDu.IQ()) {
                    IM();
                }
            } else {
                long j = this.dDw + this.dDv;
                VF += 1800000;
                if (VF > j) {
                    this.dDv += VF - j;
                }
                x.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", new Object[]{Integer.valueOf(this.dDy), Long.valueOf(1800000), Long.valueOf(VF - j), Long.valueOf(this.dDv), this.dDx});
                z = false;
            }
        }
        return z;
    }

    public final synchronized void IL() {
        x.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", new Object[]{Integer.valueOf(this.dDy), bi.cjd()});
        if (this.dDy == 1) {
            x.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", new Object[]{bi.cjd()});
        } else {
            IJ();
            rj rjVar = new rj();
            rjVar.ccf.status = 1;
            a.sFg.m(rjVar);
        }
    }

    public final synchronized void IM() {
        if (this.dDy != 2) {
            x.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", new Object[]{Integer.valueOf(this.dDy), bi.cjd()});
        } else {
            x.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", new Object[]{Long.valueOf(bi.bH(this.dDw)), bi.cjd()});
            this.dDy = 3;
            rj rjVar = new rj();
            rjVar.ccf.status = 3;
            a.sFg.m(rjVar);
        }
    }

    private synchronized void IN() {
        if (this.dDy != 1 && this.dDv + this.dDw < bi.VF()) {
            IL();
        }
    }

    public final synchronized boolean IO() {
        IN();
        return this.dDy == 2;
    }

    public final synchronized boolean IP() {
        IN();
        return this.dDy == 3;
    }
}

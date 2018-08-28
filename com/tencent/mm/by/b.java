package com.tencent.mm.by;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private final byte[] dol = new byte[1];
    private long uZL = -1;

    public final void cDY() {
        synchronized (this.dol) {
            if (this.dol[0] == (byte) 0) {
                this.dol[0] = (byte) 1;
                this.uZL = Thread.currentThread().getId();
                j.i("MicroMsg.WxConsumedLock", "lock %s", this);
            } else {
                try {
                    if (this.uZL != Thread.currentThread().getId()) {
                        j.i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                        this.dol.wait();
                        j.d("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                    } else {
                        j.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WxConsumedLock", e, "", new Object[0]);
                }
            }
        }
    }

    public final void done() {
        synchronized (this.dol) {
            if (this.dol[0] != (byte) 0) {
                this.dol[0] = (byte) 0;
                this.uZL = -1;
                this.dol.notifyAll();
                j.i("MicroMsg.WxConsumedLock", "notify done %s", this);
            }
        }
    }
}

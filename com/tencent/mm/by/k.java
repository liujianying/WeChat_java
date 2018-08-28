package com.tencent.mm.by;

import com.tencent.mm.kernel.j;

public final class k {
    public final byte[] dol = new byte[1];

    public final void done() {
        synchronized (this.dol) {
            if (this.dol[0] == (byte) -1) {
                this.dol[0] = (byte) 1;
                this.dol.notifyAll();
                j.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[]{this});
            }
        }
    }
}

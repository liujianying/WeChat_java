package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import junit.framework.Assert;

public final class l extends a {
    private final long dJL = 15000;
    private c izJ = null;
    boolean izK = false;
    boolean izL = false;
    Runnable izM = new Runnable() {
        public final void run() {
            l.this.izK = true;
            if (!l.this.izL) {
                l.this.izJ.a(-1, -1, -2, "TimeOut", null);
            }
        }

        public final String toString() {
            return super.toString() + "|mAsyncTimeOut";
        }
    };

    public l(c cVar) {
        Assert.assertNotNull(cVar);
        this.izJ = cVar;
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        if (!this.izL && !this.izK) {
            au.Em().cil().removeCallbacks(this.izM);
            au.Em().cil().post(new 2(this, j, i, i2, str, pVar));
        }
    }
}

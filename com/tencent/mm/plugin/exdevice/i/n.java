package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class n extends a {
    private c izu = null;

    public n(c cVar) {
        Assert.assertNotNull(cVar);
        this.izu = cVar;
    }

    public final long aHx() {
        x.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.izu.hjj);
        return this.izu.hjj;
    }

    public final byte[] aHy() {
        return this.izu.aGC();
    }

    public final int aHz() {
        return this.izu.aGA();
    }

    public final int aHA() {
        return this.izu.isC;
    }

    public final int aHB() {
        return this.izu.aGB();
    }
}

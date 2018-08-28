package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    private n izQ = null;
    l izR = null;

    public m(c cVar, c cVar2) {
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.izQ = new n(cVar);
        this.izR = new l(cVar2);
    }

    public final o aHC() {
        Assert.assertNotNull(this.izQ);
        return this.izQ;
    }

    public final l aHD() {
        Assert.assertNotNull(this.izR);
        return this.izR;
    }
}

package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class c$b$3 implements Runnable {
    final /* synthetic */ b gSD;

    c$b$3(b bVar) {
        this.gSD = bVar;
    }

    public final String toString() {
        return this.gSD.TAG + ".reqBigFile";
    }

    public final void run() {
        boolean z = true;
        Assert.assertTrue(toString() + ", check running. ", this.gSD.ftu);
        x.i(this.gSD.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[]{Integer.valueOf(this.gSD.gSy.size()), Long.valueOf(bi.bH(this.gSD.gSz)), aj.cin()});
        String str = "BigFileMap should not Empty";
        if (this.gSD.gSy.isEmpty()) {
            z = false;
        }
        Assert.assertTrue(str, z);
        new k(this.gSD.talker, this.gSD.gSy, new 1(this)).ass();
    }
}

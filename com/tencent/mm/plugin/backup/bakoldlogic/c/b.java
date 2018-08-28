package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.backup.f.b {
    private ab haq = new ab();
    private ac har = new ac();

    public b(int i) {
        this.haq.hbr = i;
    }

    public final a asj() {
        return this.har;
    }

    public final a ask() {
        return this.haq;
    }

    public final void mI(int i) {
        if (this.har.hcd == 0) {
            g(0, 0, "ok");
            return;
        }
        x.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[]{Integer.valueOf(this.haq.hbr), Integer.valueOf(this.har.hcd)});
        g(4, this.har.hcd, "fail");
    }

    public final int getType() {
        return 3;
    }
}

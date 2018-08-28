package com.tencent.mm.ak;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$5 implements a {
    final /* synthetic */ i dVa;

    i$5(i iVar) {
        this.dVa = iVar;
    }

    public final boolean vD() {
        try {
            i.e(this.dVa);
        } catch (Throwable e) {
            x.e("MicroMsg.ImgService", "exception:%s", new Object[]{bi.i(e)});
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}

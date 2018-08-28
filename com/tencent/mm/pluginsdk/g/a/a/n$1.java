package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

class n$1 implements Runnable {
    final /* synthetic */ List qCL;
    final /* synthetic */ n qCM;

    n$1(n nVar, List list) {
        this.qCM = nVar;
        this.qCL = list;
    }

    public final void run() {
        for (bhn bhn : this.qCL) {
            String tag = this.qCM.getTag();
            String str = "resType(%d) responses.size() = %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(bhn.hcE);
            objArr[1] = bi.cX(bhn.siv) ? "null" : String.valueOf(bhn.siv.size());
            x.i(tag, str, objArr);
            if (!bi.cX(bhn.siv)) {
                Iterator it = bhn.siv.iterator();
                while (it.hasNext()) {
                    n.a(this.qCM, bhn.hcE, (bhi) it.next());
                }
            }
        }
    }
}

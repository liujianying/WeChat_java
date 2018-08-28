package com.tencent.mm.plugin.honey_pay.model;

import android.graphics.Color;
import com.tencent.mm.plugin.honey_pay.model.c.1;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

class c$1$1 implements c {
    final /* synthetic */ 1 kjU;

    c$1$1(1 1) {
        this.kjU = 1;
    }

    public final void a(l lVar) {
        int i = 0;
        Iterator it = this.kjU.kjQ.siH.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                atn atn = (atn) it.next();
                if (bi.oW(atn.hqp)) {
                    i = i2;
                } else {
                    if (bi.oW(atn.dxh)) {
                        lVar.e(i2, atn.hqp);
                    } else {
                        lVar.a(i2, Color.parseColor(atn.dxh), atn.hqp);
                    }
                    i = i2 + 1;
                }
            } else {
                return;
            }
        }
    }
}

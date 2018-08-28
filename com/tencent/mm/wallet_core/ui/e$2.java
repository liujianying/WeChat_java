package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e.c;

class e$2 implements a {
    final /* synthetic */ c[] uYY;

    e$2(c[] cVarArr) {
        this.uYY = cVarArr;
    }

    public final void a(e eVar) {
        if (eVar != null && eVar.Lr() != null) {
            if (this.uYY == null || this.uYY.length == 0) {
                x.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                return;
            }
            try {
                for (c cVar : this.uYY) {
                    if (!(cVar == null || bi.oW(cVar.aAL))) {
                        eVar.Lr().h(cVar.aAL, e.cB(cVar.sIy));
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[]{e.toString()});
            }
        }
    }
}

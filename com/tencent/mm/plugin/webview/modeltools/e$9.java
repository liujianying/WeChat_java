package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;

class e$9 extends a {
    private final byte[] cWZ = new byte[0];
    final /* synthetic */ e pUl;

    e$9(e eVar) {
        this.pUl = eVar;
    }

    public final void ev(int i) {
        synchronized (this.cWZ) {
            if (ao.getNetType(ad.getContext()) == 0) {
                ai.bUm().setNetWorkState(1);
            } else {
                ai.bUm().setNetWorkState(2);
            }
        }
    }
}

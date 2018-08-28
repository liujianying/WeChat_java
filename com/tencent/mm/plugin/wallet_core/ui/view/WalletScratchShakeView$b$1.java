package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bi;

class WalletScratchShakeView$b$1 extends a {
    final /* synthetic */ b pAw;

    WalletScratchShakeView$b$1(b bVar) {
        this.pAw = bVar;
    }

    public final void biM() {
        long bI = bi.bI(b.a(this.pAw));
        if (b.b(this.pAw)) {
            if (bI < 80) {
                return;
            }
        } else if (bI < 1200) {
            return;
        }
        b.a(this.pAw, bi.VG());
        b.c(this.pAw);
        b.d(this.pAw);
    }

    public final void onRelease() {
    }
}

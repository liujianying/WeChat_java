package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.g.a.sy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class MallIndexUI$11 implements Runnable {
    final /* synthetic */ sy hYO;
    final /* synthetic */ MallIndexUI lab;

    MallIndexUI$11(MallIndexUI mallIndexUI, sy syVar) {
        this.lab = mallIndexUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (!bi.oW(this.hYO.cdP.cdQ)) {
            e.a(this.lab.kZm, this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}

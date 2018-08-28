package com.tencent.mm.plugin.collect.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$2 implements Runnable {
    final /* synthetic */ CollectMainUI hYN;
    final /* synthetic */ sy hYO;

    CollectMainUI$2(CollectMainUI collectMainUI, sy syVar) {
        this.hYN = collectMainUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (bi.oW(this.hYO.cdP.cdQ)) {
            x.i("MicroMsg.CollectMainUI", "no bulletin data");
        } else {
            e.a((TextView) this.hYN.findViewById(f.banner_tips), this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}

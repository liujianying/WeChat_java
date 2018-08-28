package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9;
import com.tencent.mm.sdk.platformtools.bi;

class WalletSelectAddrUI$9$1 implements Runnable {
    final /* synthetic */ 9 fai;

    WalletSelectAddrUI$9$1(9 9) {
        this.fai = 9;
    }

    public final void run() {
        if (this.fai.fah.bTJ.bJm) {
            au.HU();
            String oV = bi.oV((String) c.DT().get(46, null));
            au.HU();
            WalletSelectAddrUI.a(this.fai.fae, oV, bi.oV((String) c.DT().get(72, null)));
        }
    }
}

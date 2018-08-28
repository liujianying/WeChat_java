package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.1;
import com.tencent.mm.storage.aa.a;

class IPCallShareCouponUI$1$1 implements Runnable {
    final /* synthetic */ 1 kyQ;

    IPCallShareCouponUI$1$1(1 1) {
        this.kyQ = 1;
    }

    public final void run() {
        au.HU();
        if (((Boolean) c.DT().get(a.sRc, Boolean.valueOf(false))).booleanValue()) {
            IPCallShareCouponUI.a(this.kyQ.kyP).setVisibility(0);
        } else {
            IPCallShareCouponUI.a(this.kyQ.kyP).setVisibility(8);
        }
        au.HU();
        IPCallShareCouponUI.b(this.kyQ.kyP).setText((String) c.DT().get(a.sRb, ""));
        au.HU();
        IPCallShareCouponUI.c(this.kyQ.kyP).setText((String) c.DT().get(a.sRd, ""));
    }
}

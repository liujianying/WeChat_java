package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;

class AppBrandProfileUI$6 implements Runnable {
    final /* synthetic */ AppBrandProfileUI gvm;
    final /* synthetic */ boolean gvp;

    AppBrandProfileUI$6(AppBrandProfileUI appBrandProfileUI, boolean z) {
        this.gvm = appBrandProfileUI;
        this.gvp = z;
    }

    public final void run() {
        t rT = q.rT(AppBrandProfileUI.e(this.gvm));
        ah.A(new 1(this, rT, q.rS(AppBrandProfileUI.e(this.gvm))));
        if (this.gvp) {
            r.sf(AppBrandProfileUI.e(this.gvm));
            AppBrandProfileUI.a(this.gvm, 1, 1);
            if (rT != null) {
                boolean z;
                Object obj = rT.bGM == 4 ? "openWAGameContactDev" : "openContactDev";
                c fJ = com.tencent.mm.model.c.c.Jx().fJ(rT.bGM == 4 ? "100409" : "100401");
                AppBrandProfileUI appBrandProfileUI = this.gvm;
                if (!fJ.isValid() || bi.getInt((String) fJ.ckq().get(obj), 0) <= 0) {
                    z = false;
                } else {
                    z = true;
                }
                AppBrandProfileUI.a(appBrandProfileUI, z);
            }
        }
    }
}

package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.k;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.5;
import com.tencent.mm.sdk.platformtools.bi;

class FreeWifiNetCheckUI$5$1 implements e {
    final /* synthetic */ 5 jnN;

    FreeWifiNetCheckUI$5$1(5 5) {
        this.jnN = 5;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String aPf = ((k) lVar).aPf();
        if (bi.oW(aPf)) {
            this.jnN.jnK.finish();
            FreeWifiNetCheckUI.c(this.jnN.jnK);
            return;
        }
        FreeWifiNetCheckUI.a(this.jnN.jnK, aPf);
        this.jnN.jnK.getIntent().putExtra("free_wifi_ap_key", aPf);
        FreeWifiNetCheckUI.d(this.jnN.jnK);
        FreeWifiNetCheckUI.e(this.jnN.jnK);
    }
}

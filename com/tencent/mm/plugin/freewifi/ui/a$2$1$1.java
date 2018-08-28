package com.tencent.mm.plugin.freewifi.ui;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.ui.a.2.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2$1$1 implements Runnable {
    final /* synthetic */ bh jmo;
    final /* synthetic */ 1 jmp;

    a$2$1$1(1 1, bh bhVar) {
        this.jmp = 1;
        this.jmo = bhVar;
    }

    public final void run() {
        if (bi.oW(this.jmo.bIN.bIS)) {
            this.jmp.jmm.setVisibility(8);
            return;
        }
        ((TextView) a.c(this.jmp.jmn.jml).findViewById(R.h.free_wifi_banner_tv)).setText(this.jmo.bIN.bIS);
        String str = this.jmo.bIN.bIP;
        Object obj = "0".equalsIgnoreCase(this.jmo.bIN.bIO) ? "0" : "1";
        String str2 = this.jmo.bIN.bIQ;
        String str3 = this.jmo.bIN.ssid;
        String str4 = this.jmo.bIN.bssid;
        String str5 = this.jmo.bIN.bIR;
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", new Object[]{obj, str});
        if ("1".equals(obj)) {
            au.Em().H(new 1(this, str, str3, str4, str5, str2));
        } else {
            this.jmp.jmm.setVisibility(0);
        }
    }
}

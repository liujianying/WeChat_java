package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.applet.SecurityImage$b;

public final class f extends SecurityImage$b {
    private static f eRR = null;
    public String account = null;
    public String eIY = null;
    public byte[] eIZ = null;
    public String eJa = null;
    public String eJb = null;
    public String eRP = null;
    public int eRQ = 0;

    public final void Xe() {
        if (bi.oW(this.eRP)) {
            g.DF().a(new q(this.account, this.eIY, this.trX.getSecCodeType(), "", "", "", 0, "", false, false), 0);
            return;
        }
        g.DF().a(new q(this.account, this.eRP, this.trX.getSecCodeType(), "", "", "", 0, "", false, true), 0);
    }

    public static void a(f fVar) {
        eRR = fVar;
    }

    public static String YF() {
        if (eRR != null) {
            return eRR.account;
        }
        return null;
    }

    public static String YG() {
        if (eRR != null) {
            return eRR.eIY;
        }
        return null;
    }
}

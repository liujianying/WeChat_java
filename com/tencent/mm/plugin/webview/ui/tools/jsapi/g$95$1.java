package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.c$c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.95;
import com.tencent.mm.ui.base.h;

class g$95$1 implements c$c {
    final /* synthetic */ 95 qjS;
    final /* synthetic */ String qjb;

    g$95$1(95 95, String str) {
        this.qjS = 95;
        this.qjb = str;
    }

    public final void r(Bitmap bitmap) {
        if (g.E(this.qjS.qiK) != null) {
            g.E(this.qjS.qiK).dismiss();
        }
        c ak = z.Na().ak(this.qjS.qja);
        synchronized (e.dNr) {
            String Ir = e.Ir();
            e.d(ak);
            g.a(this.qjS.qiK, this.qjS.qiT, this.qjS.bAj, this.qjS.bAd, this.qjS.dUT, null, null, this.qjb, null);
            e.lh(Ir);
        }
        g.a(this.qjS.qiK, this.qjS.qiH, "sendEnterpriseChat:ok", null);
        if (g.j(this.qjS.qiK) != null) {
            h.bA(g.j(this.qjS.qiK), g.j(this.qjS.qiK).getResources().getString(R.l.app_shared));
        }
    }
}

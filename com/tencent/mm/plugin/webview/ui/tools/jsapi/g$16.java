package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;

class g$16 implements c {
    final /* synthetic */ String bAd;
    final /* synthetic */ String bAj;
    final /* synthetic */ String dUT;
    final /* synthetic */ g qiK;
    final /* synthetic */ f qiT;
    final /* synthetic */ String qiU;
    final /* synthetic */ String qiV;
    final /* synthetic */ String qiW;
    final /* synthetic */ long qja;
    final /* synthetic */ String qjb;

    g$16(g gVar, long j, f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.qiK = gVar;
        this.qja = j;
        this.qiT = fVar;
        this.bAj = str;
        this.bAd = str2;
        this.dUT = str3;
        this.qiU = str4;
        this.qiV = str5;
        this.qjb = str6;
        this.qiW = str7;
    }

    public final void r(Bitmap bitmap) {
        if (g.E(this.qiK) != null) {
            g.E(this.qiK).dismiss();
        }
        if (this.qja >= 0) {
            com.tencent.mm.ac.a.c ak = z.Na().ak(this.qja);
            synchronized (e.dNr) {
                String Ir = e.Ir();
                e.d(ak);
                g.a(this.qiK, this.qiT, this.bAj, this.bAd, this.dUT, this.qiU, this.qiV, this.qjb, this.qiW);
                e.lh(Ir);
            }
        } else {
            g.a(this.qiK, this.qiT, this.bAj, this.bAd, this.dUT, this.qiU, this.qiV, this.qjb, this.qiW);
        }
        if (g.j(this.qiK) != null) {
            h.bA(g.j(this.qiK), g.j(this.qiK).getString(R.l.confirm_dialog_sent));
        }
        g.a(this.qiK, g.k(this.qiK), "send_app_msg:ok", null);
    }
}

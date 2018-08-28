package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ak.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;
import java.util.Map;

class g$10 implements c {
    final /* synthetic */ String bAd;
    final /* synthetic */ String bAj;
    final /* synthetic */ String dUT;
    final /* synthetic */ g qiK;
    final /* synthetic */ ProgressDialog qiS;
    final /* synthetic */ f qiT;
    final /* synthetic */ String qiU;
    final /* synthetic */ String qiV;
    final /* synthetic */ String qiW;
    final /* synthetic */ Map qiX;

    g$10(g gVar, ProgressDialog progressDialog, f fVar, String str, String str2, String str3, String str4, String str5, String str6, Map map) {
        this.qiK = gVar;
        this.qiS = progressDialog;
        this.qiT = fVar;
        this.bAj = str;
        this.bAd = str2;
        this.dUT = str3;
        this.qiU = str4;
        this.qiV = str5;
        this.qiW = str6;
        this.qiX = map;
    }

    public final void r(Bitmap bitmap) {
        if (this.qiS != null) {
            this.qiS.dismiss();
        }
        g.a(this.qiK, this.qiT, this.bAj, this.bAd, this.dUT, this.qiU, this.qiV, null, this.qiW);
        if (g.j(this.qiK) != null) {
            h.bA(g.j(this.qiK), g.j(this.qiK).getString(R.l.app_saved));
        }
        g.a(this.qiK, g.k(this.qiK), "send_app_msg:ok", this.qiX);
    }
}

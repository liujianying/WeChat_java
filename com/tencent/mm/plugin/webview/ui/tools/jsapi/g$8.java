package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.mm.ak.c.c;
import com.tencent.mm.pluginsdk.model.app.f;

class g$8 implements c {
    final /* synthetic */ String bAd;
    final /* synthetic */ String dUT;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ ProgressDialog qiS;
    final /* synthetic */ f qiT;

    g$8(g gVar, ProgressDialog progressDialog, f fVar, String str, String str2, i iVar) {
        this.qiK = gVar;
        this.qiS = progressDialog;
        this.qiT = fVar;
        this.bAd = str;
        this.dUT = str2;
        this.qiH = iVar;
    }

    public final void r(Bitmap bitmap) {
        if (this.qiS != null) {
            this.qiS.dismiss();
        }
        g.a(this.qiK, this.qiT, "", this.bAd, this.dUT, null, null, null, null);
        g.a(this.qiK, this.qiH, "send_service_app_msg:ok", null);
        g.dW(this.qiK, this.qiH);
    }
}

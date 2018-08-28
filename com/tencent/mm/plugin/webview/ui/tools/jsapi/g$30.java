package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.x;

class g$30 implements b {
    final /* synthetic */ i qiH;
    final /* synthetic */ JsapiPermissionWrapper qiI;
    final /* synthetic */ g qiK;

    g$30(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiI = jsapiPermissionWrapper;
    }

    public final void hj(int i) {
        if (i == 0) {
            g.dR(this.qiK, this.qiH);
            return;
        }
        x.i("MicroMsg.MsgHandler", "EU user failed");
        g.a(this.qiK, this.qiH, "add_contact:fail  EU user failed", null);
    }
}

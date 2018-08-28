package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;

class JsApiUpdateApp$1 implements c<SyncResult> {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiUpdateApp fZG;

    JsApiUpdateApp$1(JsApiUpdateApp jsApiUpdateApp, l lVar, int i) {
        this.fZG = jsApiUpdateApp;
        this.fCl = lVar;
        this.doP = i;
    }

    public final /* synthetic */ void at(Object obj) {
        SyncResult syncResult = (SyncResult) obj;
        if (!SyncResult.a(syncResult)) {
            this.fCl.E(this.doP, this.fZG.f("fail sync error", null));
        } else if (this.fCl.fdO.fcu.frm.fih == 0 && SyncResult.b(syncResult) == this.fCl.fdO.fcu.frm.fii) {
            this.fCl.E(this.doP, this.fZG.f("fail the current version is the latest version", null));
        } else {
            ah.A(new 1(this));
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.41;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class BaseSOSWebViewUI$3 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ String pPl;
    final /* synthetic */ BaseSOSWebViewUI qdp;
    final /* synthetic */ Bundle qdq;
    final /* synthetic */ boolean qdr;

    BaseSOSWebViewUI$3(BaseSOSWebViewUI baseSOSWebViewUI, Bundle bundle, String str, boolean z, String str2) {
        this.qdp = baseSOSWebViewUI;
        this.qdq = bundle;
        this.gvE = str;
        this.qdr = z;
        this.pPl = str2;
    }

    public final void run() {
        if (BaseSOSWebViewUI.q(this.qdp) == null) {
            return;
        }
        if (this.qdq == null || this.qdq.getInt("isRefresh") != 1 || this.qdq.getString("widgetId") == null) {
            BaseSOSWebViewUI.s(this.qdp).d(this.gvE, this.qdr, this.pPl);
            return;
        }
        d r = BaseSOSWebViewUI.r(this.qdp);
        String string = this.qdq.getString("widgetId");
        String str = this.gvE;
        if (r.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", string);
            hashMap.put("data", str);
            ah.A(new 41(r, a.a("onSearchWAWidgetReloadDataFinish", hashMap, r.qhs, r.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
    }
}

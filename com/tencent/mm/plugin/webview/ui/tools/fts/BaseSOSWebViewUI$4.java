package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.34;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class BaseSOSWebViewUI$4 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$4(BaseSOSWebViewUI baseSOSWebViewUI, String str) {
        this.qdp = baseSOSWebViewUI;
        this.gvE = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.t(this.qdp) != null) {
            d u = BaseSOSWebViewUI.u(this.qdp);
            String str = this.gvE;
            if (u.qhq) {
                x.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                try {
                    ah.A(new 34(u, a.a("onSearchHistoryReady", new JSONObject(str), u.qhs, u.qht)));
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    return;
                }
            }
            x.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.al.a;
import org.json.JSONArray;
import org.json.JSONObject;

class d$26 implements a {
    final /* synthetic */ d qhD;

    d$26(d dVar) {
        this.qhD = dVar;
    }

    public final boolean vD() {
        d.d(this.qhD).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("onBeaconsInRange", d.h(this.qhD), d.i(this.qhD), d.j(this.qhD)) + ")", null);
        d.k(this.qhD).clear();
        d.a(this.qhD, new JSONObject());
        d.a(this.qhD, new JSONArray());
        return false;
    }
}

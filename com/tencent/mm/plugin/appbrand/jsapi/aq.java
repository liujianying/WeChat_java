package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("query");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://mp.weixin.qq.com/bizmall/expressentry" + optString);
        intent.putExtra("show_native_web_view", true);
        intent.putExtra("KRightBtn", true);
        if (lVar.getContext() != null) {
            d.b(lVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail", null));
    }
}

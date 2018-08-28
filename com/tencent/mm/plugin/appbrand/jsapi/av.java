package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        Intent putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        if (lVar.getContext() != null) {
            d.b(lVar.getContext(), "webview", ".ui.tools.WebViewUI", putExtra);
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail", null));
    }
}

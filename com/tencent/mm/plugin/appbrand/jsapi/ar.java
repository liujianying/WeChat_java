package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

final class ar extends a {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    ar() {
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (bi.oW(optString)) {
            pVar.E(i, f("fail", null));
            return;
        }
        Intent putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        putExtra.putExtra("rawUrl", optString);
        d.b(pVar.mContext, "webview", ".ui.tools.WebViewUI", putExtra);
        pVar.E(i, f("ok", null));
    }
}

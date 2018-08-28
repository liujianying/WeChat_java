package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_INDEX = 406;
    public static final String NAME = "private_openUrl";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        a(pVar, null, jSONObject, i);
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        a(null, lVar, jSONObject, i);
    }

    private void a(p pVar, l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (bi.oW(optString)) {
            a(pVar, lVar, i, "fail");
            return;
        }
        Intent putExtra;
        Context context;
        boolean optBoolean = jSONObject.optBoolean("isNativeStyle", false);
        if (optBoolean) {
            putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString).putExtra("open_custom_style_url", optBoolean).putExtra("forceHideShare", true).putExtra("status_bar_style", "black");
        } else {
            putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        }
        putExtra.putExtra("ad_info", jSONObject.optString("adInfo"));
        if (pVar != null) {
            context = pVar.mContext;
        } else {
            context = lVar.getContext();
        }
        if (context != null) {
            d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            a(pVar, lVar, i, "ok");
            return;
        }
        a(pVar, lVar, i, "fail");
    }

    private void a(p pVar, l lVar, int i, String str) {
        x.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", str);
        if (pVar != null) {
            pVar.E(i, f(str, null));
        }
        if (lVar != null) {
            lVar.E(i, f(str, null));
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class al extends a {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("phoneNumber");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        c.geJ = new 1(this, lVar, i);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(optString)).toString()));
        try {
            c.startActivityForResult(intent, hashCode() & 65535);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            lVar.E(i, f("fail", null));
        }
    }
}

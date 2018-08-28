package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_INDEX = 403;
    public static final String NAME = "openOfflinePayView";
    private int fFw;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
            return;
        }
        c.geJ = new 1(this, lVar, i);
        this.fFw = i;
        x.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", new Object[]{jSONObject.toString()});
        AppBrandSysConfig qa = a.qa(lVar.mAppId);
        if (qa == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
            return;
        }
        g pY = a.pY(lVar.mAppId);
        if (pY == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
            return;
        }
        String currentUrl = pY.fcz.getCurrentUrl();
        Intent intent = new Intent();
        intent.putExtra("appId", lVar.mAppId);
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("wxapp_username", qa.bKC);
        intent.putExtra("wxapp_path", currentUrl);
        int hashCode = hashCode() & 65535;
        intent.putExtra("key_from_scene", 7);
        d.b(c, "offline", ".ui.WalletOfflineEntranceUI", intent, hashCode);
    }
}

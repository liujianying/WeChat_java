package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.2;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Context c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", lVar.mAppId);
            a aVar = a.fWH;
            AppBrandStatObject appBrandStatObject = lVar.fdO.fcE;
            1 1 = new 1(this, lVar, i);
            g gVar = new g(jSONObject);
            if (appBrandStatObject != null) {
                gVar.bJY = g.eD(appBrandStatObject.scene, appBrandStatObject.cbA);
                gVar.qUV = g.eC(appBrandStatObject.scene, appBrandStatObject.cbA);
            }
            gVar.bVY = 46;
            2 2 = new 2(aVar, 1);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.bVW);
            intent.putExtra("url", gVar.url);
            intent.putExtra("pay_scene", gVar.bVZ);
            c.geJ = 2;
            d.a(c, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, aVar.hashCode() & 65535, false);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}

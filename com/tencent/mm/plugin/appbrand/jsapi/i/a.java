package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.b.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public enum a implements b {
    ;

    private a(String str) {
    }

    public final boolean a(MMActivity mMActivity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.i.b.a aVar, PString pString) {
        g gVar = new g(jSONObject);
        if (appBrandStatObject != null) {
            gVar.bJY = g.eD(appBrandStatObject.scene, appBrandStatObject.cbA);
            gVar.qUV = g.eC(appBrandStatObject.scene, appBrandStatObject.cbA);
        }
        gVar.bVY = 46;
        pString.value = gVar.packageExt;
        return h.a(mMActivity, gVar, hashCode() & 65535, new 1(this, aVar));
    }

    public final void a(MMActivity mMActivity, JSONObject jSONObject, b bVar) {
        5 5 = new 5(this, bVar);
        g gVar = new g(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.bVW);
        intent.putExtra("url", gVar.url);
        intent.putExtra("scene", 1);
        mMActivity.geJ = 5;
        Context context = mMActivity;
        d.a(context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 65535 & hashCode(), false);
    }
}

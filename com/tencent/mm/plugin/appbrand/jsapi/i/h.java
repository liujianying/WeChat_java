package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.game.page.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.4;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", lVar.mAppId);
            p d = d(lVar);
            if (d != null && (d instanceof d)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                d.a(2, bundle, new Object[0]);
            }
            a aVar = a.fWH;
            1 1 = new 1(this, lVar, i);
            g gVar = new g(jSONObject);
            gVar.bJY = 16;
            4 4 = new 4(aVar, 1);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.bVW);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            c.geJ = 4;
            com.tencent.mm.bg.d.a(c, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, aVar.hashCode() & 65535, false);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}

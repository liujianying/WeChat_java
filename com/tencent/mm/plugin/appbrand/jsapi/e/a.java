package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 424;
    private static final String NAME = "openRedPacket";

    public static class a extends f {
        public a(e eVar, l lVar, p pVar, JSONObject jSONObject, int i) {
            super(eVar, lVar, pVar, jSONObject, i);
        }

        protected final boolean a(MMActivity mMActivity, JSONObject jSONObject, int i) {
            String str = ahK().mAppId;
            String optString = jSONObject.optString("redPacketId", null);
            if (bi.oW(str) || bi.oW(optString)) {
                x.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[]{str, optString});
                return false;
            }
            ((com.tencent.mm.plugin.luckymoney.appbrand.a) g.l(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(mMActivity, optString, str, i);
            return true;
        }

        protected final void u(Intent intent) {
            x.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            w(hashMap);
        }

        protected final void onError(int i, String str) {
            x.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), str});
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            g(str, hashMap);
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Map hashMap;
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiOpenRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            lVar.E(i, f("fail:system error {{data is null}}", hashMap));
        } else if (bi.oW(jSONObject.optString("redPacketId", null))) {
            x.i("MicroMsg.JsApiOpenRedPacket", "redPacketId is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            lVar.E(i, f("fail:system error {{redPacketId is nil}}", hashMap));
        } else {
            p d = d(lVar);
            if (d != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                d.a(2, bundle, new Object[0]);
                new a(this, lVar, d, jSONObject, i).run();
                return;
            }
            x.i("MicroMsg.JsApiOpenRedPacket", "associated page view is null!!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            lVar.E(i, f("fail:system error {{associated page view is null}}", hashMap));
        }
    }
}

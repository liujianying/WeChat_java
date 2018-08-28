package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.luckymoney.appbrand.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b$a extends f {
    public b$a(e eVar, l lVar, p pVar, JSONObject jSONObject, int i) {
        super(eVar, lVar, pVar, jSONObject, i);
    }

    protected final boolean a(MMActivity mMActivity, JSONObject jSONObject, int i) {
        int i2 = 0;
        String optString = jSONObject.optString("defaultWishingWord", null);
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray != null) {
            boolean contains = optJSONArray.toString().contains("friend");
            boolean contains2 = optJSONArray.toString().contains("public");
            if (contains) {
                boolean z;
                if (contains2) {
                    z = true;
                } else {
                    z = false;
                }
                if (contains2 && contains) {
                    z = true;
                }
                i2 = z;
            } else {
                boolean z2;
                if (contains2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (contains2 && contains) {
                    z2 = true;
                }
                i2 = z2;
            }
        } else {
            x.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
        }
        ((a) g.l(a.class)).a(mMActivity, ahK().mAppId, i2, optString, i);
        return true;
    }

    protected final void u(Intent intent) {
        x.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
        if (intent == null || intent.getStringExtra("sendId") == null) {
            x.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", new Object[]{intent});
            onError(-1, "fail:system error {{result data error or sendId is null}}");
            return;
        }
        String stringExtra = intent.getStringExtra("sendId");
        boolean booleanExtra = intent.getBooleanExtra("result_share_msg", false);
        x.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", new Object[]{stringExtra, Boolean.valueOf(booleanExtra)});
        x.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(0));
        hashMap.put("redPacketId", stringExtra);
        w(hashMap);
    }

    protected final void onError(int i, String str) {
        x.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), str});
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        g(str, hashMap);
    }
}

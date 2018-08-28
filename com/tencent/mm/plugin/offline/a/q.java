package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.Map;
import org.json.JSONObject;

public final class q extends i {
    public n lKs;
    public y lKt = new y(null, 8);
    public c lKu;
    public c lKv;

    public q(int i) {
        this.lKs = new n(System.currentTimeMillis(), i);
        F(this.lKs.lKr);
        aB(this.lKt.lKr);
        aC(this.lKt.peZ);
    }

    public final int aBO() {
        return 1742;
    }

    public final int If() {
        return 1742;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("queryuser_resp");
            this.lKu = R(optJSONObject);
            this.lKs.a(this.lKu.errCode, this.lKu.Yy, optJSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bindquerynew_resp");
            this.lKv = R(optJSONObject2);
            this.lKt.a(this.lKv.errCode, this.lKv.Yy, optJSONObject2);
            String optString = optJSONObject.optString("card_list");
            if (optString != null) {
                a.Jb(optString);
            }
        }
    }

    private static c R(JSONObject jSONObject) {
        int i;
        String optString;
        c cVar = new c();
        cVar.Yy = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
        String string = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
        try {
            i = jSONObject.getInt("retcode");
            optString = jSONObject.optString("retmsg");
        } catch (Exception e) {
            x.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + e.toString());
            optString = string;
            i = -10089;
        }
        if (i != 0) {
            x.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
            if (i != -10089) {
                cVar.e(1000, i, optString, 2);
            } else {
                cVar.e(1000, 2, optString, 2);
            }
        } else {
            x.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
        }
        return cVar;
    }

    public static boolean isEnabled() {
        boolean z = false;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100337");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            String str = "enabled";
            if (ckq.containsKey(str) && "1".equals(ckq.get(str))) {
                z = true;
            }
        }
        x.v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: " + z);
        return z;
    }
}

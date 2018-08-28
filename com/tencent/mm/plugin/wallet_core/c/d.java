package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public d() {
        o.bPa().diF.fV("WalletBulletin", "delete from WalletBulletin");
        F(new HashMap());
    }

    public final int aBO() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int If() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            r.aj(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            x.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + optLong);
            g.Ek();
            g.Ei().DT().a(a.sSq, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.i bOG = com.tencent.mm.plugin.wallet_core.model.i.bOG();
                    if (optJSONArray != null) {
                        x.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        bOG.pnZ = optJSONArray;
                        g.Ek();
                        g.Ei().DT().a(a.sTh, optJSONArray.toString());
                    }
                }
                g.Ek();
                g.Ei().DT().a(a.sTi, optJSONObject.optString("title"));
                g.Ek();
                g.Ei().DT().a(a.sTj, optJSONObject.optString("content"));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("balance_title");
                g.Ek();
                g.Ei().DT().a(a.sTk, optString);
                g.Ek();
                g.Ei().DT().a(a.sTl, optString2);
            }
        }
    }
}

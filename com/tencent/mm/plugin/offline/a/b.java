package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("ack_key", a.blW());
        hashMap.put("req_key", a.blX());
        hashMap.put("paymsg_type", a.blY());
        hashMap.put("transactionid", a.blZ());
        hashMap.put("network", a.getNetworkType(ad.getContext()));
        hashMap.put("processed", k.lJx ? "1" : "0");
        hashMap.put("is_pos_enabled", a.bma() ? "1" : "0");
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put("timestamp", (System.currentTimeMillis() / 1000));
        F(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            x.v(this.TAG, "response ok");
            h.mEJ.a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                g.Ek();
                g.Ei().DT().a(aa.a.sXl, Integer.valueOf(optInt));
                return;
            }
            return;
        }
        x.v(this.TAG, "response fail");
        h.mEJ.a(135, 69, 1, true);
    }

    public final int aBO() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}

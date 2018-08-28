package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i {
    public String lJG;
    public int lJH;
    public String lJI;

    public d() {
        Map hashMap = new HashMap();
        g.Ek();
        Object obj = g.Ei().DT().get(a.sXm, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put("timestamp", System.currentTimeMillis());
        F(hashMap);
    }

    public final int aBO() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            h.mEJ.a(135, 56, 1, true);
            this.lJG = jSONObject.optString("appmsg");
            this.lJH = jSONObject.optInt("poll_time") * 1000;
            this.lJI = jSONObject.optString("ack_key");
            if (this.lJH > 0) {
                g.Ek();
                g.Ei().DT().a(a.sXl, Integer.valueOf(this.lJH));
            }
            g.Ek();
            g.Ei().DT().a(a.sXm, this.lJI);
            return;
        }
        h.mEJ.a(135, 57, 1, true);
    }

    public final boolean bkT() {
        return false;
    }
}

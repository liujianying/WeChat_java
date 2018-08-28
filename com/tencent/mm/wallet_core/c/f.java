package com.tencent.mm.wallet_core.c;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public String uXa;

    public f(String str) {
        this.uXa = str;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("crt_no", p.encode(str));
        hashMap.put("deviceid", q.getDeviceID(ad.getContext()));
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 1568;
    }

    public final int If() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[]{Integer.valueOf(i), str});
    }
}

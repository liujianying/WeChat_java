package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends i {
    public p(String str) {
        Map hashMap = new HashMap();
        hashMap.put("device_id", q.zz());
        hashMap.put("passwd", str);
        F(hashMap);
    }

    public final int aBO() {
        return 51;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}

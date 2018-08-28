package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public Orders mCZ;
    private String pfn;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        this.mCZ = null;
        this.pfn = null;
        this.pfn = str;
        Map hashMap = new HashMap();
        hashMap.put("req_key", this.pfn);
        hashMap.put("query_scene", String.valueOf(i));
        F(hashMap);
    }

    public final int bOo() {
        return 8;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.mCZ = Orders.ah(jSONObject);
        if (this.mCZ != null) {
            this.mCZ.bOd = this.pfn;
        }
    }
}

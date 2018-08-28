package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends i {
    public String hTH;
    public long hUf;
    public int hUg;
    public int hUh;
    public int type;

    public p(String str, int i, long j) {
        this.hTH = str;
        Map hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        F(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    public final int If() {
        return 1964;
    }

    public final int aBO() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hUg = jSONObject.optInt("total_num", 0);
        this.hUh = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt("type", 0);
        this.hUf = jSONObject.optLong("from_timestamp", 0);
    }
}

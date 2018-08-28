package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r extends i {
    public boolean dDR = false;
    public List<a> hUJ = new ArrayList();
    public long hUf;
    public int hUg;
    public int hUh;
    private int limit;
    public int type;

    public r(int i, long j, String str, int i2) {
        this.limit = i2;
        Map hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i2));
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    public final int If() {
        return 1963;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hUg = jSONObject.optInt("total_num");
        this.hUh = jSONObject.optInt("total_amt");
        this.hUf = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt("type", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.hTH = jSONObject2.optString("bill_id");
                    aVar.hTI = jSONObject2.optString("trans_id");
                    aVar.timestamp = jSONObject2.optLong("timestamp", 0);
                    aVar.desc = jSONObject2.optString("desc");
                    aVar.fee = jSONObject2.optInt("fee", 0);
                    this.hUJ.add(aVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.hUJ.size() < this.limit) {
            x.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.dDR = true;
        }
    }
}

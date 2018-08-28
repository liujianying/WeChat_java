package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends i {
    public boolean dDR;
    public String fFG;
    public boolean hUE;
    public int hUF;
    public int hUG;
    public int hUH;
    public int hUI;
    public List<h> hUJ;
    public long hUf;
    private int limit;

    public q(int i, long j, int i2, int i3) {
        this.dDR = false;
        this.hUE = false;
        this.hUJ = new ArrayList();
        this.limit = i2;
        this.hUG = 0;
        Map hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", "0");
        hashMap.put("num", String.valueOf(i2));
        hashMap.put("choose_flag", String.valueOf(i3));
        F(hashMap);
    }

    public q(int i, long j, int i2, int i3, int i4, int i5) {
        this.dDR = false;
        this.hUE = false;
        this.hUJ = new ArrayList();
        this.hUE = true;
        this.limit = i3;
        this.hUG = i2;
        Map hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", String.valueOf(i2));
        hashMap.put("num", String.valueOf(i3));
        hashMap.put("choose_flag", String.valueOf(i4));
        hashMap.put("try_num", String.valueOf(i5));
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    public final int If() {
        return 1993;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[]{jSONObject.toString()});
        this.hUF = jSONObject.optInt("choose_flag", 0);
        this.hUf = jSONObject.optLong("from_timestamp", -1);
        this.hUH = jSONObject.optInt("finish_flag", 0);
        this.hUI = jSONObject.optInt("try_num", 0);
        this.fFG = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.type = jSONObject2.optInt("type", 0);
                    hVar.hUf = jSONObject2.optLong("from_timestamp", 0);
                    hVar.hUg = jSONObject2.optInt("total_num", 0);
                    hVar.hUh = jSONObject2.optInt("total_amt", 0);
                    this.hUJ.add(hVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.hUH == 1) {
            x.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.dDR = true;
        }
    }
}

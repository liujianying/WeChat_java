package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends i {
    public List<l> qwo;
    public int qwp;
    public String token;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        F(hashMap);
    }

    public final int aBO() {
        return 59;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.getString("session_key");
                this.qwp = jSONObject.optInt("answer_times_left", -1);
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    Map hashMap = new HashMap();
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        l lVar = new l();
                        lVar.id = jSONObject2.getString("qt_id");
                        lVar.qwI = jSONObject2.getString("parent_id");
                        lVar.type = jSONObject2.getString("qt_type");
                        lVar.desc = jSONObject2.getString("qt_cont");
                        lVar.qwJ = jSONObject2.getInt("ans_len");
                        lVar.hyz = jSONObject2.getString("wording");
                        lVar.level = jSONObject2.getInt("level");
                        if (!hashMap.containsKey(lVar.qwI) || "0".equals(lVar.qwI)) {
                            hashMap.put(lVar.id, lVar);
                        } else {
                            ((l) hashMap.get(lVar.qwI)).qwK = lVar;
                        }
                    }
                    this.qwo = new ArrayList(hashMap.values());
                    hashMap.clear();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}

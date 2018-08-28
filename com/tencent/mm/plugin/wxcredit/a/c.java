package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public double qwm = 0.0d;

    public c(List<l> list, String str) {
        Map hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                l lVar = (l) it.next();
                hashMap.put("qt_id_" + i2, lVar.id);
                hashMap.put("ans_cont_" + i2, lVar.kQE);
                hashMap.put("level_" + i2, lVar.level);
                hashMap.put("parent_id_" + i2, lVar.qwI);
                i2++;
                if (lVar.qwK == null || !"Y".equals(lVar.kQE)) {
                    i = i2;
                } else {
                    hashMap.put("qt_id_" + i2, lVar.qwK.id);
                    hashMap.put("ans_cont_" + i2, lVar.qwK.kQE);
                    hashMap.put("level_" + i2, lVar.qwK.level);
                    hashMap.put("parent_id_" + i2, lVar.qwK.qwI);
                    i = i2 + 1;
                }
            } else {
                hashMap.put("total_num", String.valueOf(i2));
                F(hashMap);
                return;
            }
        }
    }

    public final int aBO() {
        return 60;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.qwm = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}

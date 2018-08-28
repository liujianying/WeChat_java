package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i implements k {
    public JSONObject phm;

    public d(boolean z, String str, String str2) {
        Map hashMap = new HashMap();
        x.d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", new Object[]{str, str2});
        hashMap.put("is_root", "0");
        hashMap.put("is_device_open_touch", z ? "1" : "0");
        hashMap.put("cpu_id", str);
        hashMap.put("app_uid", str2);
        F(hashMap);
    }

    public final int a(e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return super.a(eVar, eVar2);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1669;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0 && jSONObject != null) {
            x.v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", new Object[]{jSONObject.toString()});
            this.phm = jSONObject;
            s.cDi().aq(this.phm);
        }
    }
}

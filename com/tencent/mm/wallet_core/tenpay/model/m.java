package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends i {
    public m() {
        F(new HashMap());
    }

    public final int aBO() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (bi.oW(optString)) {
            x.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            o.setTimeStamp((System.currentTimeMillis() / 1000));
            return;
        }
        o.setTimeStamp(optString);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    public final int If() {
        return 477;
    }
}

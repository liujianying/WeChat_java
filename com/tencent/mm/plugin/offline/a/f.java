package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    private boolean caB = true;

    public f(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[]{str, str2});
        F(hashMap);
    }

    public final int aBO() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    public final int If() {
        return 1686;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            x.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            h.mEJ.a(135, 22, 1, true);
            return;
        }
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[]{Integer.valueOf(i), str});
        h.mEJ.a(135, 23, 1, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        if (cVar.uWZ != 0 || cVar.errType == 0) {
            this.caB = true;
        } else {
            this.caB = false;
        }
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[]{Boolean.valueOf(this.caB)});
    }

    public final boolean bkU() {
        return this.caB;
    }
}

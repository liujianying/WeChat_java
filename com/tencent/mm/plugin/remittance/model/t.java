package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t extends i {
    public t(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        F(hashMap);
    }

    public t(String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        hashMap.put("rcvr_ticket", str3);
        hashMap.put("receiver_openid", str4);
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1535;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSenceTenPayBase", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }
}

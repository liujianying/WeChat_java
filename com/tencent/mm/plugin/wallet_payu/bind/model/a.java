package com.tencent.mm.plugin.wallet_payu.bind.model;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cea;
    public String description;
    public String pDO;
    public String pDY;
    public String pDZ;
    public String pEa;
    public String pin;
    public String psq;

    public final int bOo() {
        return 0;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.pDY = str;
        this.psq = str2;
        this.cea = str3;
        this.pDZ = str4;
        this.pEa = str5;
        this.description = str6;
        this.pDO = str7;
        this.pin = str8;
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("information", str2);
        hashMap.put("name_on_card", str3);
        hashMap.put("card_number", str4);
        hashMap.put("card_expiry", str5);
        hashMap.put("description", str6);
        hashMap.put("cvv", str7);
        hashMap.put("pin", str8);
        F(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}

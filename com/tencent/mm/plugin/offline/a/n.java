package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends i {
    public static String lJU = "";
    public static String lKn = "";
    private int hUm = -1;
    private String hUn = "";
    public int lJK = -1;
    public String lJL = "";
    public String lKo = "";
    public String lKp = "";
    public String lKq = "";
    final Map<String, String> lKr = new HashMap();

    public n(String str, int i) {
        this.lKr.put("device_id", q.zz());
        this.lKr.put("timestamp", str);
        this.lKr.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.zz());
        stringBuilder.append("&");
        stringBuilder.append(str);
        this.lKr.put("sign", ac.ce(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        g.Ek();
        this.lKr.put("code_ver", stringBuilder2.append(g.Ei().DT().get(a.sOz, "")).toString());
        F(this.lKr);
    }

    public final int aBO() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            lJU = jSONObject.optString("limit_fee");
            lKn = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.bkO();
            k.aw(196629, lJU);
            k.bkO();
            k.aw(196641, lKn);
            k.bkO();
            k.aw(196645, optString);
            k.bkO();
            k.aw(196646, optString2);
            com.tencent.mm.plugin.offline.c.a.Je(optString3);
            this.hUm = jSONObject.optInt("retcode");
            this.hUn = jSONObject.optString("retmsg");
            this.lJK = jSONObject.optInt("wx_error_type");
            this.lJL = jSONObject.optString("wx_error_msg");
            this.lKo = jSONObject.optString("get_code_flag");
            this.lKp = jSONObject.optString("micropay_pause_flag");
            this.lKq = jSONObject.optString("micropay_pause_word");
        }
    }

    public final int If() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}

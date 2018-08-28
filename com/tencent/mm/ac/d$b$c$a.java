package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$c$a {
    public long appid = 0;
    public String dLD;
    public String dLE;
    public int dLF;
    public String dLG;
    public String dLH;

    public static d$b$c$a kw(String str) {
        x.i("MicroMsg.BizInfo", "EnterpriseBizInfo = " + str);
        d$b$c$a d_b_c_a = new d$b$c$a();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                d_b_c_a.dLD = jSONObject.optString("belong");
                d_b_c_a.dLE = jSONObject.optString("freeze_wording");
                d_b_c_a.dLF = jSONObject.optInt("child_type");
                d_b_c_a.dLG = jSONObject.optString("home_url");
                String optString = jSONObject.optString("exattr");
                if (bi.oW(optString)) {
                    d_b_c_a.dLH = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    d_b_c_a.dLH = jSONObject2.optString("chat_extension_url");
                    d_b_c_a.appid = jSONObject2.optLong("app_id");
                }
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return d_b_c_a;
    }
}

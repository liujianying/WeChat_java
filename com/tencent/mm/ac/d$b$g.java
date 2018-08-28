package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$g {
    public String dLS;
    public String dLT;
    public boolean dLU;

    public static d$b$g kz(String str) {
        x.i("MicroMsg.BizInfo", "RegisterSource = %s", str);
        d$b$g d_b_g = new d$b$g();
        if (str != null && str.length() > 0) {
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject(str);
                d_b_g.dLS = jSONObject.optString("RegisterBody");
                d_b_g.dLT = jSONObject.optString("IntroUrl");
                if (jSONObject.optInt("IsClose", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                d_b_g.dLU = z;
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", bi.i(e));
            }
        }
        return d_b_g;
    }
}

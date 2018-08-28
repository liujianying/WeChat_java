package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$b {
    public int dLA;
    public int dLy;
    public int dLz;

    public static d$b$b ku(String str) {
        x.i("MicroMsg.BizInfo", "HardwareBizInfo = " + str);
        d$b$b d_b_b = new d$b$b();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                d_b_b.dLy = jSONObject.optInt("hardware_flag");
                d_b_b.dLz = jSONObject.optInt("connect_status_display_mode");
                d_b_b.dLA = jSONObject.optInt("special_internal_brand_type");
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return d_b_b;
    }

    public final boolean MC() {
        return (this.dLy & 1) > 0;
    }
}

package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$d {
    public int dLI = 0;
    public String dLJ;
    public String dLK;
    public String dLL;
    public String dLM;

    public static d$b$d kx(String str) {
        if (bi.oW(str)) {
            return null;
        }
        x.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[]{str});
        d$b$d d_b_d = new d$b$d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            d_b_d.dLI = jSONObject.optInt("Type");
            d_b_d.dLJ = jSONObject.optString("Description");
            d_b_d.dLK = jSONObject.optString("Name");
            d_b_d.dLL = jSONObject.optString("IntroUrl");
            d_b_d.dLM = jSONObject.optString("VerifySubTitle");
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
        }
        x.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[]{Integer.valueOf(d_b_d.dLI), d_b_d.dLJ, d_b_d.dLK, d_b_d.dLL});
        return d_b_d;
    }
}

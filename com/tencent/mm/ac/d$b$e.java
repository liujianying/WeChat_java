package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d$b$e {
    public int dLN;
    public String dLO;
    public List<String> dLP;
    public String dLQ;

    public static d$b$e ky(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            d$b$e d_b_e = new d$b$e();
            JSONObject jSONObject = new JSONObject(str);
            d_b_e.dLN = jSONObject.optInt("reputation_level", -1);
            d_b_e.dLO = jSONObject.optString("scope_of_business");
            d_b_e.dLQ = jSONObject.optString("guarantee_detail_h5_url");
            JSONArray optJSONArray = jSONObject.optJSONArray("guarantee_info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (length > 0) {
                    d_b_e.dLP = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String string = optJSONArray.getString(i);
                        if (!bi.oW(string)) {
                            d_b_e.dLP.add(string);
                        }
                    }
                }
            }
            return d_b_e;
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }
}

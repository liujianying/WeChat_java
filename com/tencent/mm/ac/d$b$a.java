package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class d$b$a {
    public ArrayList<String> dLx;

    public static d$b$a kt(String str) {
        if (bi.oW(str)) {
            return null;
        }
        d$b$a d_b_a = new d$b$a();
        x.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[]{str});
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("origin_name_list");
            if (optJSONArray == null) {
                return d_b_a;
            }
            d_b_a.dLx = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                d_b_a.dLx.add(optJSONArray.optString(i));
            }
            return d_b_a;
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            return d_b_a;
        }
    }
}

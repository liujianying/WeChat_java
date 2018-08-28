package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d$b$f {
    public String dLR;
    public String description;
    public String iconUrl;

    public static List<d$b$f> b(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        if (jSONArray != null) {
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    d$b$f d_b_f = new d$b$f();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    d_b_f.iconUrl = optJSONObject.optString("icon");
                    d_b_f.description = optJSONObject.optString("description");
                    d_b_f.dLR = optJSONObject.optString("description_key");
                    linkedList.add(d_b_f);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return linkedList;
    }
}

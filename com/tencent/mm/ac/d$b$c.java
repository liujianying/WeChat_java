package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONObject;

public class d$b$c {
    public int dLB;
    public List<j> dLC = null;
    public int type;

    public static d$b$c kv(String str) {
        x.i("MicroMsg.BizInfo", "MenuInfo = " + str);
        d$b$c d_b_c = new d$b$c();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                d_b_c.dLB = jSONObject.optInt("update_time");
                d_b_c.type = jSONObject.optInt("type", 0);
                d_b_c.dLC = j.c(jSONObject.optJSONArray("button_list"));
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return d_b_c;
    }
}

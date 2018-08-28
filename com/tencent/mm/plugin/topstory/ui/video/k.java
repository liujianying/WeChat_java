package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.ps;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
    public static final k oAn = new k();
    public bti oAo;

    public static JSONArray cB(List<ps> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return jSONArray;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                ps psVar = (ps) list.get(i2);
                jSONObject.put("key", psVar.aAL);
                jSONObject.put("uintValue", psVar.rtU);
                jSONObject.put("textValue", psVar.rtV);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }
}

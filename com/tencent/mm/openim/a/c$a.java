package com.tencent.mm.openim.a;

import com.tencent.mm.openim.a.c.b;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c$a {
    public List<b> eum = new LinkedList();
    public String title = "";

    final c$a e(JSONObject jSONObject) {
        this.title = jSONObject.optString("title", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("detail");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                b bVar = new b();
                List list = this.eum;
                bVar.bWP = jSONObject2.optString("icon");
                bVar.desc = jSONObject2.optString("desc");
                bVar.eun = jSONObject2.optInt("desc_type");
                bVar.action = jSONObject2.optInt("action");
                bVar.euo = jSONObject2.optString("action_param");
                list.add(bVar);
            }
        }
        return this;
    }
}

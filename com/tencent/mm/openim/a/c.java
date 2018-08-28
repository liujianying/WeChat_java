package com.tencent.mm.openim.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    public List<a> eul = new LinkedList();

    public final c oE(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("custom_info");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    this.eul.add(new a().e(jSONObject));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenIMCustomDetail", e, "parse", new Object[0]);
        }
        return this;
    }
}

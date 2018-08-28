package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.u.b.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public Map<String, String> fwR;
    public String fwS;
    public int fwT;
    public int fwU;
    public String path;
    public String title;

    public b() {
        super("onCanvasInsert");
    }

    b(int i) {
        super("onCanvasInsert", i);
    }

    public final JSONObject tR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put("query", new JSONObject(this.fwR == null ? new HashMap() : this.fwR));
            jSONObject.put("cacheKey", this.fwS);
            jSONObject.put("width", f.lO(this.fwT));
            jSONObject.put("height", f.lO(this.fwU));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}

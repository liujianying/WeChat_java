package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    private String cca;
    private int x;
    private int y;

    public b(int i, int i2, String str) {
        this.x = i;
        this.y = i2;
        this.cca = str;
    }

    public final String getName() {
        return "onTap";
    }

    public final String bTM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put("eventId", this.cca);
        } catch (Throwable e) {
            x.printErrStackTrace("onTap", e, "", new Object[0]);
        }
        return jSONObject.toString();
    }
}

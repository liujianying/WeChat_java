package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_BYTE = 188;
    public static final String NAME = "disableBounceScroll";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        Object obj = null;
        x.i("MicroMsg.GameJsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("place");
        if (optJSONArray == null) {
            x.i("MicroMsg.GameJsApiDisableBounceScroll", "placeArray is null");
            dVar.E(i, a.f("disableBounceScroll:fail", null));
            return;
        }
        Object obj2;
        int i2 = 0;
        while (true) {
            obj2 = obj;
            if (i2 >= optJSONArray.length()) {
                break;
            }
            if ("top".equalsIgnoreCase(optJSONArray.optString(i2))) {
                obj = 1;
            } else {
                obj = obj2;
            }
            i2++;
        }
        if (obj2 == null) {
            dVar.E(i, a.f("disableBounceScroll:ok", null));
            return;
        }
        dVar.mHandler.post(new d$24(dVar));
        dVar.E(i, a.f("disableBounceScroll:ok", null));
    }
}

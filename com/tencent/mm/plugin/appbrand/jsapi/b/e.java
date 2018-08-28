package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }
}

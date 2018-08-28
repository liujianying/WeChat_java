package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class g extends b {
    public static final int CTRL_INDEX = 299;
    public static final String NAME = "removeHTMLWebView";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}

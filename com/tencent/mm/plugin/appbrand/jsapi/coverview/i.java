package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class i extends c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateImageView";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[]{Integer.valueOf(i), jSONObject});
        if (view instanceof CoverViewContainer) {
            b bVar = (b) ((CoverViewContainer) view).A(b.class);
            if (bVar == null) {
                x.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[]{Integer.valueOf(i)});
                return false;
            }
            d.a(view, jSONObject.optJSONObject("style"));
            a.a(pVar, bVar, jSONObject);
            return super.c(pVar, i, view, jSONObject);
        }
        x.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

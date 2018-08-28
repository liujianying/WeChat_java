package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        b bVar = new b(context);
        bVar.setScaleType(ScaleType.FIT_XY);
        return new CoverViewContainer(context, bVar);
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        b bVar = (b) ((CoverViewContainer) view).A(b.class);
        if (bVar == null) {
            x.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i));
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("gesture");
        boolean optBoolean3 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        d.a(view, jSONObject.optJSONObject("style"));
        com.tencent.mm.plugin.appbrand.jsapi.o.a.a(pVar, bVar, jSONObject);
        u.b E = pVar.agU().E(i, true);
        E.p("data", optString2);
        E.p("sendTo", optString);
        E.p("transEvt", Boolean.valueOf(optBoolean3));
        E.p("clickable", Boolean.valueOf(optBoolean));
        bVar.setOnClickListener(new 1(this, E, pVar));
        bVar.setClickable(optBoolean);
        x.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
        if (!optBoolean && optBoolean2) {
            bVar.setOnTouchListener(new 2(this, E, pVar));
        }
    }
}

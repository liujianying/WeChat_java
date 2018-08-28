package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new f(context));
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[]{Integer.valueOf(i), jSONObject});
        f fVar = (f) ((CoverViewContainer) view).A(f.class);
        if (fVar == null) {
            x.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[]{Integer.valueOf(i)});
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        boolean optBoolean3 = jSONObject.optBoolean("gesture");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        com.tencent.mm.plugin.appbrand.jsapi.o.a.a(fVar, jSONObject.optJSONObject("label"));
        d.a(view, jSONObject.optJSONObject("style"));
        b E = pVar.agU().E(i, true);
        E.p("data", optString2);
        E.p("sendTo", optString);
        E.p("transEvt", Boolean.valueOf(optBoolean2));
        E.p("clickable", Boolean.valueOf(optBoolean));
        fVar.setOnClickListener(new 1(this, E, pVar));
        fVar.setClickable(optBoolean);
        x.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", new Object[]{Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean3)});
        if (!optBoolean && optBoolean3) {
            fVar.setOnTouchListener(new 2(this, E, pVar));
        }
    }
}

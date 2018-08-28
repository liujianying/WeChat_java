package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    protected final View a(p pVar, JSONObject jSONObject) {
        return new WxaScrollView(pVar.mContext);
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        WxaScrollView wxaScrollView = (WxaScrollView) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String optString = jSONObject.optString("data", "");
        com.tencent.mm.plugin.appbrand.jsapi.o.d.a(view, jSONObject.optJSONObject("style"));
        pVar.agU().E(i, true).p("data", optString);
        if (optBoolean) {
            wxaScrollView.setOnScrollChangedListener(new 1(this, pVar, i));
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            x.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", Boolean.valueOf(jSONObject.optBoolean("scrollX", true)));
            wxaScrollView.setScrollHorizontal(optBoolean);
        }
        if (jSONObject.has("scrollY")) {
            x.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", Boolean.valueOf(jSONObject.optBoolean("scrollY", true)));
            wxaScrollView.setScrollVertical(optBoolean);
        }
        if (jSONObject.has("scrollTop")) {
            x.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", Integer.valueOf(f.a(jSONObject, "scrollTop", wxaScrollView.getScrollY())));
            wxaScrollView.postDelayed(new 2(this, wxaScrollView, r1), 100);
        }
    }
}

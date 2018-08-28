package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends c {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[]{Integer.valueOf(i), jSONObject});
        if (view instanceof WxaScrollView) {
            WxaScrollView wxaScrollView = (WxaScrollView) view;
            d.a(view, jSONObject.optJSONObject("style"));
            try {
                if (jSONObject.getBoolean("needScrollEvent")) {
                    wxaScrollView.setOnScrollChangedListener(new 1(this, pVar, i));
                } else {
                    wxaScrollView.setOnScrollChangedListener(null);
                }
            } catch (JSONException e) {
            }
            jSONObject.optInt("scrollLeft", 0);
            if (jSONObject.has("scrollX")) {
                x.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[]{Boolean.valueOf(jSONObject.optBoolean("scrollX", true))});
                wxaScrollView.setScrollHorizontal(r2);
            }
            if (jSONObject.has("scrollY")) {
                x.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[]{Boolean.valueOf(jSONObject.optBoolean("scrollY", true))});
                wxaScrollView.setScrollVertical(r2);
            }
            if (jSONObject.has("scrollTop")) {
                x.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[]{Integer.valueOf(f.a(jSONObject, "scrollTop", wxaScrollView.getScrollY()))});
                wxaScrollView.scrollTo(wxaScrollView.getScrollX(), r2);
            }
            return super.c(pVar, i, view, jSONObject);
        }
        x.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    protected final View a(p pVar, JSONObject jSONObject) {
        if (pVar.alS() != null) {
            return null;
        }
        pVar.getContentView().post(new 1(this, pVar));
        View aVar = new a(pVar.mContext, pVar.fdO, pVar);
        aVar.setId(g.app_brand_pageview_html_webview);
        pVar.gnl.add(new 2(this, aVar));
        pVar.a(new 3(this, aVar));
        pVar.a(new 4(this, aVar));
        return aVar;
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
    }
}

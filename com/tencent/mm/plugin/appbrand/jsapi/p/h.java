package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (!(view instanceof a)) {
            return false;
        }
        String optString = jSONObject.optString("src", "about:blank");
        x.i("URL", optString);
        MMWebView webView = ((a) view).getWebView();
        if (optString.indexOf("#") < 0 || TextUtils.isEmpty(webView.getUrl())) {
            webView.loadUrl(optString);
        } else {
            webView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[]{optString}), null);
        }
        return true;
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}

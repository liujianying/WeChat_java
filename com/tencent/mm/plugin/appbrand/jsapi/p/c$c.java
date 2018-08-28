package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public interface c$c {
    void akn();

    void ako();

    boolean akq();

    String getAppId();

    String[] getJsApiReportArgs();

    MMWebView getWebView();

    void runOnUiThread(Runnable runnable);

    void ud(String str);

    void ue(String str);

    void w(JSONObject jSONObject);
}

package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class d$1 implements Runnable {
    final /* synthetic */ JSONObject oCD;
    final /* synthetic */ d oCE;

    d$1(d dVar, JSONObject jSONObject) {
        this.oCE = dVar;
        this.oCD = jSONObject;
    }

    @TargetApi(7)
    public final void run() {
        String jSONObject = this.oCD.toString();
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onSearchDataReady %d", new Object[]{Integer.valueOf(jSONObject.length())});
        jSONObject = String.format("javascript:onSearchDataReady(%s)", new Object[]{jSONObject});
        d.c(this.oCE.ccA, "dataReady", System.currentTimeMillis());
        this.oCE.oCB.evaluateJavascript(jSONObject, null);
    }
}

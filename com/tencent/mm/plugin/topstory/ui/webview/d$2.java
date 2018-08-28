package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import org.json.JSONObject;

class d$2 implements Runnable {
    final /* synthetic */ d oCE;
    final /* synthetic */ JSONObject oCF;

    d$2(d dVar, JSONObject jSONObject) {
        this.oCE = dVar;
        this.oCF = jSONObject;
    }

    @TargetApi(7)
    public final void run() {
        this.oCE.oCB.evaluateJavascript(String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[]{this.oCF.toString()}), null);
    }
}

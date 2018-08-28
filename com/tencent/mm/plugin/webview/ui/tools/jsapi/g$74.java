package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class g$74 implements Runnable {
    final /* synthetic */ String fQh;
    final /* synthetic */ g qiK;
    final /* synthetic */ WebViewJSSDKFileItem qjD;

    g$74(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem, String str) {
        this.qiK = gVar;
        this.qjD = webViewJSSDKFileItem;
        this.fQh = str;
    }

    public final void run() {
        fc fcVar = new fc();
        fcVar.bNi.op = 1;
        fcVar.bNi.fileName = this.qjD.fileName;
        fcVar.bNi.bCH = true;
        fcVar.bNi.bNl = new 1(this);
        fcVar.bNi.bNm = new b() {
            public final void onError() {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("playResult", "onVoicePlayEnd:fail");
                    bundle.putString("localId", g$74.this.fQh);
                    g.D(g$74.this.qiK).c(2002, bundle);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                }
            }
        };
        a.sFg.m(fcVar);
    }
}

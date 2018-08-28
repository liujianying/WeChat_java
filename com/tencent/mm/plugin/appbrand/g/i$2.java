package com.tencent.mm.plugin.appbrand.g;

import android.webkit.ValueCallback;
import com.tencent.xweb.g;
import java.net.URL;

class i$2 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ ValueCallback fwH;
    final /* synthetic */ i gdS;
    final /* synthetic */ URL gdT;

    i$2(i iVar, URL url, String str, ValueCallback valueCallback) {
        this.gdS = iVar;
        this.gdT = url;
        this.fwG = str;
        this.fwH = valueCallback;
    }

    public final void run() {
        g a = i.a(this.gdS);
        URL url = this.gdT;
        String str = this.fwG;
        ValueCallback valueCallback = this.fwH;
        if (!a.fwD) {
            a.vzZ.evaluateJavascript(str, valueCallback, url);
        }
    }
}

package com.tencent.xweb.c;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class i {
    static a vCG;
    static a vCH;
    static a vCI;

    public static a b(d dVar) {
        Object gx;
        if (dVar == d.vAP) {
            if (vCG == null) {
                gx = com.tencent.xweb.util.d.gx("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
                if (gx == null || !(gx instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
                    return null;
                }
                vCG = (a) gx;
            }
            return vCG;
        } else if (dVar == d.vAQ) {
            if (vCH == null) {
                gx = com.tencent.xweb.util.d.gx("com.tencent.xweb.x5.X5WebFactory", "getInstance");
                if (gx == null || !(gx instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
                    return null;
                }
                vCH = (a) gx;
            }
            return vCH;
        } else if (dVar != d.vAR) {
            return null;
        } else {
            if (vCI == null) {
                gx = com.tencent.xweb.util.d.gx("com.tencent.xweb.sys.SysWebFactory", "getInstance");
                if (gx == null || !(gx instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
                    return null;
                }
                vCI = (a) gx;
            }
            return vCI;
        }
    }

    public static h a(d dVar, WebView webView) {
        h hVar = null;
        c cVar = new c("createWebview", dVar, 2000);
        cVar.cIE();
        try {
            if (b(dVar) == null) {
                Log.e("WebViewWrapperFactory", "the kind of " + dVar + " this provider does not exist!");
            } else {
                hVar = b(dVar).createWebView(webView);
                if (hVar != null) {
                    cVar.cIF();
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = " + dVar);
                }
            }
        } catch (Exception e) {
            XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + dVar);
            e.e(dVar);
        }
        return hVar;
    }
}

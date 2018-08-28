package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.33;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.Map;

public final class f {
    private static String qhN = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private d gcO;
    private d pNV;
    private WebView pVK;
    public boolean qeP;
    private a qhK;
    private boolean qhL;
    private final al qhM;

    static /* synthetic */ void b(f fVar) {
        boolean z;
        if (fVar.qeP) {
            x.i("MicroMsg.JsLoader", "jsapi init done by preload");
            if (fVar.pNV != null) {
                fVar.pNV.bXR();
            }
            z = true;
        } else if (fVar.pVK == null || fVar.pNV == null) {
            x.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
            z = false;
        } else {
            Map bXB;
            fVar.pVK.evaluateJavascript(fVar.bXY(), new 1(fVar));
            d dVar = fVar.pNV;
            x.v("MicroMsg.JsApiHandler", "jsapi init");
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:init", dVar.qho, dVar.qhs, dVar.qht) + ")", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsApiHandler", "sys:init back %s\t", new Object[]{(String) obj});
                }
            });
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:bridged", null, dVar.qhs, dVar.qht) + ")", new 33(dVar));
            dVar.bXR();
            dVar.bXS();
            if (!(bi.oW(dVar.qhw) || dVar.qhk == null)) {
                dVar.qhk.evaluateJavascript(dVar.cH(dVar.qhw, dVar.qhx), null);
                dVar.qhw = null;
                dVar.qhx = 0;
            }
            if (dVar.qhk.getContext() instanceof MutableContextWrapper) {
                Context baseContext = ((MutableContextWrapper) dVar.qhk.getContext()).getBaseContext();
                if (baseContext instanceof PreLoadWebViewUI) {
                    bXB = ((PreLoadWebViewUI) baseContext).bXB();
                    dVar.am(bXB);
                    x.i("MicroMsg.JsLoader", "jsapi init done");
                    z = true;
                } else {
                    x.i("MicroMsg.JsApiHandler", "webview.context is not PreloadWebviewUI， %s", new Object[]{baseContext.toString()});
                }
            }
            bXB = null;
            dVar.am(bXB);
            x.i("MicroMsg.JsLoader", "jsapi init done");
            z = true;
        }
        x.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[]{Boolean.valueOf(z)});
        if (z && fVar.qhK != null) {
            fVar.qhK.bWG();
        }
        h.mEJ.a(156, 1, 1, false);
        if (!z) {
            h.mEJ.a(156, 0, 1, false);
        }
    }

    public f(WebView webView, d dVar, d dVar2, a aVar) {
        this(webView, dVar, dVar2, aVar, false, false);
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z, boolean z2) {
        this.qhL = false;
        this.qhM = new al(new 2(this), true);
        this.pVK = webView;
        this.gcO = dVar;
        this.pNV = dVar2;
        this.qhK = aVar;
        this.qhL = z;
        this.qeP = z2;
        x.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void detach() {
        x.v("MicroMsg.JsLoader", "detach");
        this.pVK = null;
        this.pNV = null;
        this.qhK = null;
    }

    public final void bXJ() {
        x.v("MicroMsg.JsLoader", "onPageStarted");
        if (!this.qhM.ciq()) {
            this.qhM.SO();
            x.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
    }

    public final void bXK() {
        x.v("MicroMsg.JsLoader", "onPageFinished");
        if (this.qhM.ciq()) {
            al alVar = this.qhM;
            long j = this.qhL ? 0 : 1000;
            alVar.J(j, j);
            x.i("MicroMsg.JsLoader", "tryStartTimer success");
            return;
        }
        x.i("MicroMsg.JsLoader", "timer running");
    }

    private String bXY() {
        int i;
        try {
            if (this.gcO.g(98, null) == null) {
                i = 0;
            } else {
                i = 1;
            }
        } catch (Exception e) {
            i = 0;
        }
        x.i("MicroMsg.JsLoader", "WXJS: %s", new Object[]{i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js"});
        try {
            String convertStreamToString = bi.convertStreamToString(ad.getContext().getAssets().open(i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js"));
            if (TextUtils.isEmpty(this.pNV.qht)) {
                return convertStreamToString;
            }
            return convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.pNV.qht).replace("__wx._isDgtVerifyEnabled()", "true");
        } catch (Exception e2) {
            x.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[]{e2});
            return "";
        }
    }
}

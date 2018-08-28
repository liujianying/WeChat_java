package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public class c {
    final l fbP;
    private final f fbQ;
    private final a fbR;

    public c(l lVar, f fVar) {
        this.fbP = lVar;
        this.fbQ = fVar;
        this.fbR = fVar.agh();
    }

    @JavascriptInterface
    public final int create(final String str) {
        x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[]{this.fbP.mAppId, str});
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[]{this.fbP.mAppId});
            return -1;
        }
        a aae = aae();
        if (aae == null) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), allocJsContext failed", new Object[]{this.fbP.mAppId, str});
            return -2;
        }
        this.fbR.a(aae, "WeixinJSContext");
        aae.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[]{this.fbP.aaK().toString()}), null);
        String aaf = aaf();
        if (bi.oW(aaf)) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript 404", new Object[]{this.fbP.mAppId, str});
            aag();
            return 0;
        }
        i.a(aae, aaf, new 1(this, str));
        aaf = ao.a(this.fbP.fdO, str);
        if (bi.oW(aaf)) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), appScript 404", new Object[]{this.fbP.mAppId, str});
            aah();
            return -1;
        }
        i.a(aae, str, aaf, new i.a() {
            public final void qe(String str) {
                x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), appScript inject succeed", new Object[]{c.this.fbP.mAppId, str});
                c.this.cr(true);
            }

            public final void fM(String str) {
                x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), appScript inject failed", new Object[]{c.this.fbP.mAppId, str});
                c.this.cr(false);
            }
        });
        r.a(this.fbP.fdO, aae, str);
        x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[]{this.fbP.mAppId, str, Integer.valueOf(aae.afW())});
        return aae.afW();
    }

    @JavascriptInterface
    public final int evaluateScriptFile(int i, String str) {
        x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[]{this.fbP.mAppId, Integer.valueOf(i), str});
        a kl = this.fbQ.kl(i);
        if (kl == null) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[]{this.fbP.mAppId, Integer.valueOf(i), str});
            return -1;
        } else if (kl.afV()) {
            x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[]{this.fbP.mAppId, str});
            return -1;
        } else {
            String a = ao.a(this.fbP.fdO, str);
            if (bi.oW(a)) {
                x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), script 404", new Object[]{this.fbP.mAppId, Integer.valueOf(i), str});
                aah();
                return 0;
            }
            i.a(kl, str, a, new 3(this, kl, str));
            r.a(this.fbP.fdO, kl, str);
            return 1;
        }
    }

    @JavascriptInterface
    public final void destroy(int i) {
        this.fbQ.km(i);
    }

    public void aad() {
        this.fbQ.agg().a(this.fbR, "WeixinJSContext");
    }

    public a aae() {
        return this.fbQ.agh();
    }

    public String aaf() {
        return WxaCommLibRuntimeReader.qJ("WASubContext.js");
    }

    public void aag() {
    }

    public void cq(boolean z) {
    }

    public void aah() {
    }

    public void cr(boolean z) {
    }
}

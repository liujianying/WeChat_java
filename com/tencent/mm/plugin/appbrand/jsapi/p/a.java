package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.c.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.o;
import org.json.JSONObject;

public final class a extends FrameLayout implements c {
    private MMFalseProgressBar dEm;
    private MMWebView dEn;
    private p fFv;
    private b gcD;
    private final b gcE;
    private String gcF = "";
    private boolean gcG = true;
    private boolean gcH = false;
    private o gcI = new 2(this);
    private com.tencent.xweb.x5.a.a.a.a.b gcJ = new 3(this);
    private String mAppId;

    public a(Context context, g gVar, p pVar) {
        super(context);
        this.mAppId = gVar.mAppId;
        this.gcD = new b();
        this.gcD.a(pVar);
        this.fFv = pVar;
        this.dEn = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.qkE.cS(context);
        this.dEn.getSettings().cIv();
        this.dEn.getSettings().setJavaScriptEnabled(true);
        this.dEn.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.dEn.getSettings().cIx();
        this.dEn.getSettings().setUserAgentString(s.aV(getContext(), this.dEn.getSettings().getUserAgentString()) + " miniProgram");
        this.dEn.getView().setHorizontalScrollBarEnabled(false);
        this.dEn.getView().setVerticalScrollBarEnabled(false);
        this.dEn.getSettings().setBuiltInZoomControls(true);
        this.dEn.getSettings().setUseWideViewPort(true);
        this.dEn.getSettings().setLoadWithOverviewMode(true);
        this.dEn.getSettings().cIq();
        this.dEn.getSettings().cIp();
        this.dEn.getSettings().setGeolocationEnabled(true);
        this.dEn.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.dEn.getSettings().cIt();
        this.dEn.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.dEn.getSettings().cIs();
        this.dEn.getSettings().cIu();
        this.dEn.getSettings().setDatabasePath(com.tencent.mm.loader.stub.b.duM + "databases/");
        this.dEn.setCompetitorView(pVar.gnt);
        this.dEn.cAy();
        this.dEn.setWebViewCallbackClient(this.gcI);
        if (this.dEn.getIsX5Kernel()) {
            this.dEn.setWebViewClientExtension(this.gcJ);
        }
        addView(this.dEn, new LayoutParams(-1, -1));
        this.dEm = new MMFalseProgressBar(context);
        this.dEm.setProgressDrawable(com.tencent.mm.bp.a.f(context, f.mm_webview_progress_horizontal));
        addView(this.dEm, new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(context, 3)));
        this.gcE = ((com.tencent.mm.plugin.appbrand.jsapi.p.c.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.jsapi.p.c.a.class)).a(this);
        this.fFv.a(new 1(this));
        getReporter().gsF = true;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final MMWebView getWebView() {
        return this.dEn;
    }

    public final void runOnUiThread(Runnable runnable) {
        post(runnable);
    }

    public final void w(JSONObject jSONObject) {
        this.gcD.mData = jSONObject.toString();
        this.gcD.ahM();
    }

    public final boolean akm() {
        if (getWebView().canGoBack()) {
            getReporter().b(this.fFv, true);
            getWebView().goBack();
            this.gcH = true;
            return true;
        }
        getReporter().b(this.fFv, false);
        return false;
    }

    public final void ud(String str) {
        this.fFv.sZ(str);
    }

    public final void akn() {
        akp();
        this.dEm.start();
    }

    public final void ue(String str) {
        akp();
        this.dEm.finish();
        if (!(this.gcG || this.gcH)) {
            com.tencent.mm.plugin.appbrand.report.a.p reporter = getReporter();
            p pVar = this.fFv;
            String str2 = this.gcF;
            reporter.grK = (String) reporter.gsD.peekFirst();
            reporter.grL = 2;
            reporter.grM = str;
            reporter.gsD.push(str2);
            reporter.k(pVar);
        }
        this.gcG = false;
        this.gcH = false;
        setCurrentURL(str);
    }

    public final void ako() {
        this.fFv.fdO.fcz.agJ();
    }

    private void akp() {
        this.dEn.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    }

    private com.tencent.mm.plugin.appbrand.report.a.p getReporter() {
        return this.fFv.fdO.fcz.getReporter().gqY;
    }

    public final void setCurrentURL(String str) {
        this.gcF = str;
        if (!bi.oW(str)) {
            if (!bi.oW(Uri.parse(str).getHost())) {
                a(this.fFv, getContext().getString(j.webview_logo_url, new Object[]{r0}));
                return;
            }
        }
        a(this.fFv, "");
    }

    private void a(p pVar, String str) {
        pVar.getContentView().post(new 4(this, pVar, str));
    }

    public final String[] getJsApiReportArgs() {
        p pVar = this.fFv;
        g gVar = pVar.fdO;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        com.tencent.mm.plugin.appbrand.j g = com.tencent.mm.plugin.appbrand.j.g(gVar);
        a alS = pVar.alS();
        String[] strArr = new String[19];
        strArr[0] = appBrandStatObject.scene;
        strArr[1] = appBrandStatObject.bGG;
        strArr[2] = gVar.mAppId;
        strArr[3] = gVar.fcu.frm.fii;
        strArr[4] = g.fdE;
        strArr[5] = (gVar.fcu.frm.fih + 1);
        strArr[6] = appBrandStatObject.gqK;
        strArr[7] = pVar.getURL();
        strArr[8] = alS == null ? "" : alS.getWebView().getUrl();
        strArr[9] = com.tencent.mm.plugin.appbrand.report.a.cH(pVar.mContext);
        strArr[10] = "";
        strArr[11] = "";
        strArr[12] = "";
        strArr[13] = "";
        strArr[14] = "";
        strArr[15] = "";
        strArr[16] = appBrandStatObject.cbB;
        strArr[17] = appBrandStatObject.cbC;
        strArr[18] = (gVar.fct.bGM + 1000);
        return strArr;
    }

    public final boolean akq() {
        if (this.fFv.fdO.fcu.fqw) {
            return this.fFv.fdO.fcu.fqO;
        }
        return this.fFv.fdO.fcu.fqL;
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ak$e;
import com.tencent.mm.plugin.webview.model.ak$l;
import com.tencent.mm.plugin.webview.model.ak.c;
import com.tencent.mm.plugin.webview.model.ak.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.69;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import junit.framework.Assert;

protected class WebViewUI$i extends p {
    final /* synthetic */ WebViewUI pZJ;

    public WebViewUI$i(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public boolean Rb(String str) {
        x.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
        if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
            return true;
        }
        if (WebViewUI.m(this.pZJ, str)) {
            x.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + str);
            return true;
        }
        WebViewUI.n(this.pZJ, str);
        return false;
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + str);
        if (!WebViewUI.g(this.pZJ, str)) {
            x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            WebViewUI.K(this.pZJ);
            return true;
        } else if (s.fj(str, "about:blank")) {
            x.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
            return true;
        } else {
            try {
                int intExtra;
                if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                    this.pZJ.Ro(str);
                    return true;
                } else if (str.startsWith("weixin://dl/business") && d.k(Uri.parse(str))) {
                    String host = Uri.parse(this.pZJ.cbP).getHost();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str + "&domain=" + host));
                    intExtra = this.pZJ.getIntent().getIntExtra("pay_channel", -1);
                    if (intExtra != -1) {
                        x.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", new Object[]{str, Integer.valueOf(intExtra)});
                        intent.putExtra("pay_channel", intExtra);
                    }
                    intent.putExtra("translate_link_scene", 13);
                    this.pZJ.startActivity(intent);
                    return true;
                } else if (str.startsWith("weixinpreinject://iframe") && WebViewUI.av(this.pZJ) != null) {
                    x.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                    if (!str.equals(WebViewUI.ax(this.pZJ))) {
                        WebViewUI.o(this.pZJ, "");
                        return true;
                    } else if (this.pZJ.Du(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                        intExtra = this.pZJ.pYo.Di(str);
                        if (intExtra != 0 && intExtra != 2 && (intExtra != 8 || WebViewUI.ay(this.pZJ))) {
                            return Rb(str);
                        }
                        x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                        if (this.pZJ.Rm(str)) {
                            this.pZJ.mhH.stopLoading();
                            this.pZJ.mhH.post(new 1(this, str));
                        } else {
                            this.pZJ.mhH.stopLoading();
                        }
                        if (str.equals(WebViewUI.C(this.pZJ))) {
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return Rb(str);
                        }
                        WebViewUI.a(this.pZJ, str, true, intExtra);
                        return true;
                    }
                } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                    if ((this.pZJ.cbP.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && WebViewUI.aw(this.pZJ)) {
                        d.bd(this.pZJ.mController.tml, str);
                        this.pZJ.finish();
                        return true;
                    }
                    if (!str.equals(WebViewUI.ax(this.pZJ))) {
                        WebViewUI.o(this.pZJ, "");
                        return true;
                    } else if (this.pZJ.Du(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                        intExtra = this.pZJ.pYo.Di(str);
                        if (intExtra != 0 && intExtra != 2 && (intExtra != 8 || WebViewUI.ay(this.pZJ))) {
                            return Rb(str);
                        }
                        x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                        if (this.pZJ.Rm(str)) {
                            this.pZJ.mhH.stopLoading();
                            this.pZJ.mhH.post(new 1(this, str));
                        } else {
                            this.pZJ.mhH.stopLoading();
                        }
                        if (str.equals(WebViewUI.C(this.pZJ))) {
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return Rb(str);
                        }
                        WebViewUI.a(this.pZJ, str, true, intExtra);
                        return true;
                    }
                } else {
                    if (str.startsWith("weixin://webview/initReady/") || str.startsWith("weixin://webview/preInjectJSBridge/")) {
                        return true;
                    }
                    if (!str.equals(WebViewUI.ax(this.pZJ))) {
                        WebViewUI.o(this.pZJ, "");
                        return true;
                    } else if (this.pZJ.Du(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                        intExtra = this.pZJ.pYo.Di(str);
                        if (intExtra != 0 && intExtra != 2 && (intExtra != 8 || WebViewUI.ay(this.pZJ))) {
                            return Rb(str);
                        }
                        x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                        if (this.pZJ.Rm(str)) {
                            this.pZJ.mhH.stopLoading();
                            this.pZJ.mhH.post(new 1(this, str));
                        } else {
                            this.pZJ.mhH.stopLoading();
                        }
                        if (str.equals(WebViewUI.C(this.pZJ))) {
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return Rb(str);
                        }
                        WebViewUI.a(this.pZJ, str, true, intExtra);
                        return true;
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                if (this.pZJ.gcP == null) {
                    x.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                    return true;
                }
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.a(webView, str, z);
        if (s.fj(str, "about:blank")) {
            x.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
            return;
        }
        String url = webView.getUrl();
        if (WebViewUI.ay(this.pZJ)) {
            this.pZJ.j(url, false, -1);
        }
        if (!(this.pZJ.gcP == null || this.pZJ.gcP.has(url))) {
            x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
            this.pZJ.j(url, false, -1);
            this.pZJ.M(true, false);
            WebViewUI.e(this.pZJ, true);
        }
        WebViewUI.n(this.pZJ).bVT();
        WebViewUI.n(this.pZJ, str);
        this.pZJ.pZs.Rx(str);
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + str);
        h.mEJ.a(155, 0, 1, false);
        if (this.pZJ.bWj()) {
            if (TextUtils.isEmpty(str) || !str.equals(webView.getUrl())) {
                x.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", new Object[]{str, webView.getUrl()});
            } else {
                x.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
                this.pZJ.bWk();
                if (WebViewUI.av(this.pZJ) != null) {
                    WebViewUI.av(this.pZJ).qeP = false;
                }
                this.pZJ.bWB();
            }
        }
        if (b.chp() && "http://www.dktest-mmcrash.com/".equals(str)) {
            Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
        }
        WebViewUI.p(this.pZJ, WebViewUI.ah(this.pZJ));
        this.pZJ.f(str, bi.VE(), 1);
        this.pZJ.pQY.bUv().pSD = WebViewUI.i(this.pZJ);
        WebViewUI.n(this.pZJ, str);
        g gVar = g.pXv;
        x.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[]{str, gVar.pXw, gVar.nyj});
        String str2 = gVar.pXw;
        gVar.pXw = str;
        if (!bi.oW(gVar.nyj)) {
            gVar.f(1, str2, 0);
        }
        x.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[]{WebViewUI.i(this.pZJ), WebViewUI.ah(this.pZJ)});
        if (WebViewUI.g(this.pZJ, str)) {
            WebViewUI.n(this.pZJ).bVT();
            WebViewUI.n(this.pZJ).setCurrentURL(str);
            if (this.pZJ.Du(str)) {
                WebViewUI.o(this.pZJ, str);
                return;
            }
            WebViewUI.av(this.pZJ).bXJ();
            this.pZJ.setProgressBarIndeterminateVisibility(false);
            if (this.pZJ.Rm(str)) {
                WebViewUI.f(this.pZJ, true);
                this.pZJ.pXB.finish();
                this.pZJ.mhH.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.pZJ.pNV != null) {
                    this.pZJ.pNV.q((String) WebViewUI.az(this.pZJ).get(str), (Map) WebViewUI.aA(this.pZJ).get(str));
                }
            } else {
                WebViewUI.f(this.pZJ, false);
                if (!WebViewUI.d(this.pZJ)) {
                    this.pZJ.pXB.start();
                }
            }
            WebViewUI.q(this.pZJ, str);
            if (WebViewUI.x.qaR.equals(this.pZJ.j(str, false, -1))) {
                WebViewUI.t(this.pZJ).pS(str);
            }
            this.pZJ.M(true, false);
            WebViewUI.e(this.pZJ, false);
            ak$l bUt = this.pZJ.pQY.bUt();
            int ar = WebViewUI.ar(this.pZJ);
            String str3 = this.pZJ.bZM;
            bUt.cfR = ar;
            bUt.pSv = str3;
            if (bi.oW(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
            } else if (!bUt.pSI.containsKey(str)) {
                bUt.pSI.put(str, Long.valueOf(bi.VF()));
            }
            WebViewUI.aB(this.pZJ);
            if (WebViewUI.aC(this.pZJ) != null && !WebViewUI.aC(this.pZJ).qaV) {
                h aC = WebViewUI.aC(this.pZJ);
                x.d("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[]{str});
                aC.gsE = str;
                aC.bWM();
                return;
            }
            return;
        }
        x.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + str);
        WebViewUI.K(this.pZJ);
    }

    public void a(WebView webView, String str) {
        super.a(webView, str);
        WebViewUI.aD(this.pZJ);
        a.a(this.pZJ.mhH, this.pZJ.gcO);
        this.pZJ.pZs.Rx(str);
        if (!WebViewUI.aE(this.pZJ)) {
            WebViewUI.aF(this.pZJ);
            this.pZJ.pQY.bUx().pSo = true;
        }
        x.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[]{str});
        c bUC = this.pZJ.pQY.bUC();
        if (bUC.jcc && !bUC.pSq) {
            try {
                Uri parse = Uri.parse(str);
                if (str.startsWith("http")) {
                    String host = parse.getHost();
                    if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                        h.mEJ.a(283, 0, 1, true);
                        bUC.pSq = true;
                        x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[]{str});
                    }
                } else {
                    x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[]{str});
            }
        }
        g gVar = g.pXv;
        x.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[]{gVar.nyj});
        if (!bi.oW(gVar.nyj)) {
            gVar.kB(2);
        }
        if (this.pZJ.mhH == null) {
            x.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
            return;
        }
        WebViewUI.t(this.pZJ).pS(str);
        String title = this.pZJ.mhH.getTitle();
        x.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[]{this.pZJ.mController.getMMTitle(), title, Boolean.valueOf(this.pZJ.pXA), Boolean.valueOf(WebViewUI.q(this.pZJ)), WebViewUI.ah(this.pZJ)});
        if (this.pZJ.mhH.getIsX5Kernel() && !bi.oW(title) && title.length() > 0 && !title.equals(this.pZJ.mController.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.ah(this.pZJ) == null || !WebViewUI.ah(this.pZJ).equals(title)) && !this.pZJ.pXA && WebViewUI.q(this.pZJ))) {
            x.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
            this.pZJ.setMMTitle(title);
        }
        WebViewUI.n(this.pZJ).setCurrentURL(this.pZJ.getCurrentURL());
        boolean booleanExtra = this.pZJ.getIntent().getBooleanExtra("shouldForceViewPort", false);
        x.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + booleanExtra);
        if (booleanExtra) {
            webView.evaluateJavascript(this.pZJ.getIntent().getStringExtra("view_port_code"), null);
        }
        WebViewUI.aG(this.pZJ);
        if (WebViewUI.g(this.pZJ, str)) {
            this.pZJ.setProgressBarIndeterminateVisibility(false);
            this.pZJ.pXB.finish();
            WebViewUI.o(this.pZJ, "");
            if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                x.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                return;
            }
            x.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.aH(this.pZJ));
            WebViewUI.av(this.pZJ).bXK();
            if (!(this.pZJ.gcP == null || this.pZJ.gcP.Rl(str) == null)) {
                WebViewUI.a(this.pZJ, this.pZJ.gcP.Rl(str).gu(34), this.pZJ.gcP.Rl(str).gu(75));
            }
            WebViewUI.a(this.pZJ, WebViewUI.bWE());
            ak$l bUt = this.pZJ.pQY.bUt();
            if (bi.oW(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
            } else if (bUt.pSI.containsKey(str)) {
                bUt.pSI.put(str, Long.valueOf(bi.VF() - ((Long) bUt.pSI.get(str)).longValue()));
            }
            ak$e bUu = this.pZJ.pQY.bUu();
            if (bi.oW(str)) {
                x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
            } else if (bUu.pSt.containsKey(str)) {
                bUu.pSt.put(str, Long.valueOf(bi.VF() - ((Long) bUu.pSt.get(str)).longValue()));
            }
            f bUw = this.pZJ.pQY.bUw();
            com.tencent.mm.plugin.webview.stub.d dVar = this.pZJ.gcO;
            if (!(dVar == null || bUw.djO)) {
                bUw.djO = true;
                int bUp = ak.bUp();
                long VF = bi.VF() - bUw.startTime;
                if (VF >= 0 && VF <= 180000) {
                    String str2 = bUw.pSv;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(4);
                    objArr[1] = Long.valueOf(VF);
                    objArr[2] = Integer.valueOf(bUp);
                    objArr[3] = bUw.url == null ? bUw.url : bUw.url.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(ak.bB());
                    objArr[8] = Integer.valueOf(ak.KD());
                    objArr[9] = Integer.valueOf(bUw.cfR);
                    objArr[10] = bUw.pSv;
                    ak.a(dVar, str2, objArr);
                    x.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{bUw.url, Long.valueOf(VF), Integer.valueOf(bUp), Integer.valueOf(ak.bB()), Integer.valueOf(ak.KD()), Integer.valueOf(bUw.cfR), bUw.pSv});
                }
            }
            if (!WebViewUI.e(this.pZJ).containsKey(str)) {
                WebViewUI.e(this.pZJ).put(str, Boolean.valueOf(this.pZJ.cqe()));
            }
            this.pZJ.ka(((Boolean) WebViewUI.e(this.pZJ).get(str)).booleanValue());
            Boolean bool = (Boolean) WebViewUI.r(this.pZJ).get(str);
            if (bool == null || !bool.booleanValue()) {
                this.pZJ.showOptionMenu(0, true);
            } else {
                this.pZJ.showOptionMenu(0, false);
            }
            if (WebViewUI.ag(this.pZJ) && bi.oW(WebViewUI.ai(this.pZJ))) {
                WebViewUI.r(this.pZJ, WebViewUI.ah(this.pZJ));
            }
            WebViewUI.b(this.pZJ, bi.VE());
            com.tencent.mm.sdk.b.a.sFg.m(new tx());
            if (WebViewUI.aC(this.pZJ) != null && !WebViewUI.aC(this.pZJ).qaV) {
                h aC = WebViewUI.aC(this.pZJ);
                x.d("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[]{str});
                aC.gsE = str;
                return;
            }
            return;
        }
        x.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + str);
        WebViewUI.K(this.pZJ);
    }

    @TargetApi(8)
    public final void a(WebView webView, com.tencent.xweb.h hVar, SslError sslError) {
        String ah = webView.getUrl() == null ? WebViewUI.ah(this.pZJ) : webView.getUrl();
        h.mEJ.a(155, 1, 1, false);
        h.mEJ.a(155, 30, 1, false);
        if (WebViewUI.aI(this.pZJ) == null) {
            WebViewUI.a(this.pZJ, new b(this.pZJ, this.pZJ.mhH));
        }
        WebViewUI.aI(this.pZJ).a(ah, hVar, sslError);
    }

    public void a(WebView webView, int i, String str, String str2) {
        boolean isConnected = ao.isConnected(this.pZJ);
        x.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected)});
        h.mEJ.a(155, 1, 1, false);
        h.mEJ.a(155, (long) a.Ay(i), 1, false);
        super.a(webView, i, str, str2);
        g.pXv.AI(i);
        if (WebViewUI.aJ(this.pZJ)) {
            this.pZJ.finish();
        }
    }

    public final void f(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + str);
        if (WebViewUI.g(this.pZJ, str)) {
            ak$e bUu = this.pZJ.pQY.bUu();
            if (bi.oW(str)) {
                x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
            } else if (!(bi.oW(bUu.gsE) || str.equals(bUu.gsE) || !bUu.pSu)) {
                if (bUu.pSs.containsKey(bUu.gsE)) {
                    bUu.pSs.put(bUu.gsE, Long.valueOf(bi.VF() - ((Long) bUu.pSs.get(bUu.gsE)).longValue()));
                }
                bUu.pSu = false;
            }
            super.f(webView, str);
            return;
        }
        x.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + str);
        super.f(webView, str);
        WebViewUI.K(this.pZJ);
    }

    public m c(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[]{str});
        if (Rv(str)) {
            return null;
        }
        return Rw(str);
    }

    public m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (Rv(lVar.getUrl().toString())) {
            return null;
        }
        return Rw(lVar.getUrl().toString());
    }

    public m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (Rv(lVar.getUrl().toString())) {
            return null;
        }
        if (com.tencent.mm.bz.a.hi(this.pZJ)) {
            try {
                int i = bundle.getInt("resourceType");
                if ((i == 1 || i == 7) && !WebViewUI.aK(this.pZJ)) {
                    x.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                    WebViewUI.a(this.pZJ, lVar.getUrl().toString(), false, 5);
                }
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                x.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
            }
        }
        return Rw(lVar.getUrl().toString());
    }

    private boolean Rv(String str) {
        if (WebViewUI.g(this.pZJ, str)) {
            return false;
        }
        x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
        WebViewUI.K(this.pZJ);
        return true;
    }

    private m Rw(String str) {
        String currentURL = this.pZJ.getCurrentURL();
        m a = WebViewUI.m(this.pZJ).a(str, !WebViewUI.aL(this.pZJ), this.pZJ.gcO);
        if (a == null) {
            return null;
        }
        if (!str.equals(currentURL) && !WebViewUI.a(this.pZJ, currentURL, str)) {
            return a;
        }
        WebViewUI.a(this.pZJ).post(new Runnable() {
            public final void run() {
                if (WebViewUI$i.this.pZJ.mhH != null) {
                    WebViewUI$i.this.pZJ.mhH.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                }
                WebViewUI webViewUI = WebViewUI$i.this.pZJ;
                69 69 = new 69(webViewUI);
                if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                    69.run();
                } else {
                    webViewUI.handler.post(69);
                }
            }
        });
        return a;
    }
}

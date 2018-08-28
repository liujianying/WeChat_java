package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class i extends p {
    public MMWebView dEn;
    protected Activity ftd;
    private Set<String> jJn;
    public String jJp;
    public String jJq;
    private String jJu;
    public boolean jJw;
    ag mHandler;
    private final Map<String, Map<String, String>> pYU;
    public d qcA;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d qfM;
    private f qfP;
    public e qhr;
    final Bundle qkH;
    protected b qkI;
    public a qkJ;
    private ah qkK;
    public String qkL;
    private String qkM;
    private List<b> qkN;
    private final Map<String, String> qkO;
    public boolean qkP;
    public boolean qkQ;
    private boolean qkR;
    public Map<String, String> qkS;
    public c qkT;
    public k qkU;

    public i(MMWebView mMWebView) {
        this(mMWebView, false);
    }

    public i(MMWebView mMWebView, boolean z) {
        this(mMWebView, z, null);
    }

    public i(MMWebView mMWebView, boolean z, Bundle bundle) {
        this.qfP = null;
        this.qfM = null;
        this.jJw = false;
        this.jJu = "";
        this.jJn = new HashSet();
        this.qkI = new b(this);
        this.qkJ = new a(null);
        this.qkK = new ah();
        this.qkL = null;
        this.jJp = null;
        this.qkM = null;
        this.qkN = new ArrayList();
        this.qkO = new HashMap();
        this.pYU = new ConcurrentHashMap();
        this.qkP = false;
        this.qkQ = false;
        this.qkR = false;
        this.qkT = new c(this);
        this.qkU = new 4(this);
        this.ftd = (Activity) mMWebView.getContext();
        this.dEn = mMWebView;
        this.mHandler = new ag();
        this.qhr = new e(this.ftd, mMWebView);
        this.jJw = z;
        this.qkH = bundle;
    }

    public void RC(String str) {
    }

    public void a(d dVar, e eVar) {
    }

    public k aks() {
        return null;
    }

    public int akt() {
        return 0;
    }

    public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
    }

    public void a(f fVar) {
    }

    public void e(Bundle bundle, String str) {
    }

    public boolean Rm(String str) {
        if (this.dEn == null) {
            return false;
        }
        this.dEn.hashCode();
        return o.QA(str);
    }

    public boolean Ke(String str) {
        return false;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    public void e(WebView webView, String str) {
    }

    public void bXH() {
    }

    public final boolean RR(String str) {
        for (b bVar : this.qkN) {
            if (bVar.Dt(str)) {
                x.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bVar.Du(str) + ", url = " + str);
                return true;
            }
        }
        return Ke(str);
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + str);
        if (this.qcA == null) {
            x.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            return true;
        } else if (!ab.Ql(str)) {
            x.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + str);
            RC(str);
            return true;
        } else if (str.equals(this.qkM)) {
            this.qkM = "";
            return true;
        } else {
            boolean RR = RR(str);
            if (!RR && str.startsWith("weixin://")) {
                x.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                return true;
            } else if (RR) {
                return true;
            } else {
                int Di = this.qkJ.Di(str);
                if ((Di != 0 && Di != 2) || this.jJw) {
                    return false;
                }
                x.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + Di);
                if (Rm(str)) {
                    this.dEn.stopLoading();
                    this.dEn.post(new 1(this, str));
                } else {
                    this.dEn.stopLoading();
                }
                if (str.equals(this.jJu)) {
                    x.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return false;
                }
                bg(str, true);
                return true;
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.a(webView, str, z);
        String url = webView.getUrl();
        if (this.jJw) {
            bg(url, false);
        }
        if (this.qhr != null && !this.qhr.has(url)) {
            x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
            bg(url, false);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", new Object[]{str});
        if (this.qcA == null || this.qkP) {
            this.qkP = false;
        } else if (!ab.Ql(str)) {
            x.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + str);
            RC(str);
        } else if (RR(str)) {
            this.qkM = str;
        } else {
            this.jJp = str;
            super.b(webView, str, bitmap);
            this.qfP.bXJ();
            if (Rm(str)) {
                this.dEn.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.qfM != null) {
                    this.qfM.q((String) this.qkO.get(str), (Map) this.pYU.get(str));
                }
            }
            bg(str, false);
            a(webView, str, bitmap);
        }
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", new Object[]{str});
        if (this.qcA != null) {
            super.a(webView, str);
            if (ab.Ql(str)) {
                this.qkM = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    x.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    e(webView, str);
                    return;
                }
                this.qfP.bXK();
                e(webView, str);
                return;
            }
            x.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + str);
            RC(str);
        }
    }

    public final void a(WebView webView, h hVar, SslError sslError) {
        super.a(webView, hVar, sslError);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
    }

    public void f(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + str);
        super.f(webView, str);
    }

    public m c(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", new Object[]{str});
        return this.qkK.a(str, true, this.qcA);
    }

    public m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        return this.qkK.a(lVar.getUrl().toString(), false, this.qcA);
    }

    public m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return super.a(webView, lVar, bundle);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (a.hi(this.ftd)) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    x.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                    f(lVar.getUrl().toString(), false, 5);
                }
            } catch (Exception e) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
            }
        }
        return this.qkK.a(lVar.getUrl().toString(), true, this.qcA);
    }

    public final void cleanup() {
        if (this.qkT != null) {
            try {
                this.ftd.unbindService(this.qkT);
            } catch (Exception e) {
                x.e("MicroMsg.MMWebViewClient", e.getMessage());
            }
        }
        if (this.qfM != null) {
            this.qfM.detach();
        }
        if (this.qfP != null) {
            this.qfP.detach();
        }
        bYw();
        try {
            this.qcA.Av(this.dEn.hashCode());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMWebViewClient", e2, "", new Object[0]);
        }
        bXH();
    }

    public final void bYv() {
        int i;
        Map hashMap = new HashMap();
        hashMap.put("init_url", this.qkL);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.qfM = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.dEn, this.qhr, hashMap, this.qcA, this.dEn.hashCode());
        this.qfM.qhp = null;
        this.dEn.addJavascriptInterface(this.qfM, "__wx");
        this.qkN.add(this.qfM);
        this.qkN.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.dEn, this.qfM));
        this.qfP = new f(this.dEn, this.qcA, this.qfM, new 2(this));
        a(this.qfP);
        try {
            i = bi.getInt(this.qcA.QT("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        x.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && this.ftd.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.qfM.bXQ();
            this.qkK.pRW = this.qfM.qht;
        }
    }

    public void bXI() {
        try {
            this.qcA.a(this.qkL, true, null);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!RR(this.qkL)) {
            Uri parse = Uri.parse(this.qkL);
            if (parse.getScheme() == null) {
                this.qkL += "http://";
                parse = Uri.parse(this.qkL);
            }
            if (parse.getScheme().startsWith("http")) {
                x.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.qkJ = new a(this.qkL);
                if (this.jJw || this.qhr.has(this.qkL)) {
                    this.dEn.loadUrl(this.qkL);
                } else {
                    bg(this.qkL, false);
                }
            } else if (ab.Ql(this.qkL)) {
                this.dEn.loadUrl(this.qkL);
            } else {
                RC(this.qkL);
            }
        }
    }

    private void bVW() {
        x.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.ftd.bindService(new Intent(this.ftd, WebViewStubService.class), this.qkT, 1);
    }

    public boolean RB(String str) {
        if (this.qcA != null) {
            return false;
        }
        this.qkL = str;
        bVW();
        return true;
    }

    public void Do(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.dEn.loadUrl(str, hashMap);
    }

    public final void bg(String str, boolean z) {
        f(str, z, akt());
    }

    private void f(String str, boolean z, int i) {
        boolean z2 = false;
        if (!this.ftd.isFinishing()) {
            if (this.qhr == null) {
                x.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            } else if (this.jJw) {
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
                this.qhr.b(str, null, null);
            } else {
                boolean z3;
                if (this.qcA == null) {
                    z3 = z2;
                } else {
                    z3 = this.jJn.contains(str);
                }
                if ((this.qhr.has(str) || z3) && !z) {
                    x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                    return;
                }
                String str2 = "";
                int Di = this.qkJ.Di(str);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i + ", username = " + str2 + ", reason = " + Di + ", force = " + z);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
                this.jJn.add(str);
                this.qhr.b(str, null, null);
                this.qkQ = true;
                b bVar = this.qkI;
                if (bVar.qaM == 0) {
                    i iVar = bVar.qkV;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("scene_end_type", 233);
                        bundle.putInt("scene_end_listener_hash_code", iVar.dEn.hashCode());
                        iVar.qcA.a(5, bundle, iVar.dEn.hashCode());
                    } catch (Exception e) {
                        x.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
                    }
                }
                bVar.qaM++;
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_data_req_url", str);
                bundle2.putString("geta8key_data_username", str2);
                bundle2.putInt("geta8key_data_scene", i);
                bundle2.putInt("geta8key_data_reason", Di);
                if (this.dEn.getIsX5Kernel()) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", z2);
                }
                bundle2.putString("geta8key_data_net_type", s.bUq());
                this.jJu = str;
                e(bundle2, str);
                try {
                    z2 = this.qcA.s(233, bundle2);
                } catch (Exception e2) {
                    x.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
                }
                x.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + z2);
            }
        }
    }

    private void bYw() {
        try {
            if (this.qcA != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", 233);
                bundle.putInt("scene_end_listener_hash_code", this.dEn.hashCode());
                this.qcA.a(6, bundle, this.dEn.hashCode());
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    private void p(String str, Map<String, String> map) {
        String aG = bi.aG(getCurrentURL(), this.qkL);
        if (bi.oW(aG)) {
            x.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.dEn.loadUrl(str);
        } else if (this.qfM == null) {
            if (map.size() > 0) {
                this.dEn.loadUrl(str, map);
            } else {
                this.dEn.loadUrl(str);
            }
        } else if (!bi.oV(str).contains("#wechat_redirect")) {
            if (!fs(aG, str)) {
                String QF = com.tencent.mm.plugin.webview.modelcache.p.QF(aG);
                String QF2 = com.tencent.mm.plugin.webview.modelcache.p.QF(str);
                Object obj = (bi.oW(QF2) || bi.oW(QF) || !QF2.equals(QF) || this.qcA == null || !Rm(aG)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.dEn.loadUrl(str, map);
                        return;
                    } else {
                        this.dEn.loadUrl(str);
                        return;
                    }
                }
            }
            this.qkO.put(aG, str);
            this.pYU.put(aG, map);
            this.qfM.q(str, map);
        } else if (map.size() > 0) {
            this.dEn.loadUrl(str, map);
        } else {
            this.dEn.loadUrl(str);
        }
    }

    private boolean fs(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.pNp.matcher(str).matches() && com.tencent.mm.plugin.webview.a.pNp.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.qcA != null && Rm(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean ad(Bundle bundle) {
        x.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        x.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.qkS = hashMap;
        switch (i) {
            case 1:
                x.i("MicroMsg.MMWebViewClient", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    return false;
                }
                this.dEn.getSettings().setJavaScriptEnabled(false);
                this.dEn.loadData(string3, "text/html", "utf-8");
                return true;
            case 2:
            case 7:
                x.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    return false;
                } else if (ab.Ql(string2)) {
                    p(string2, hashMap);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                    RC(string2);
                    return true;
                }
            case 6:
                x.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (ab.Ql(string2)) {
                    this.dEn.loadUrl(string2);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    RC(string2);
                    return true;
                }
            default:
                x.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bi.oW(str2)) {
            this.qhr.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.jJn.remove(str2);
            this.qkQ = false;
            this.jJq = str2;
        }
        if (fs(str, str2)) {
            this.qhr.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.jJn.remove(str);
        } else if (this.qcA != null && !bi.oW(str) && Rm(str2)) {
            this.qhr.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.jJn.remove(str);
        }
    }

    final String getCurrentURL() {
        if (!bi.oW(this.jJp)) {
            return this.jJp;
        }
        if (this.mHandler == null) {
            return null;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.dEn == null ? "" : this.dEn.getUrl();
        } else {
            return (String) new 3(this, "").a(this.mHandler);
        }
    }
}

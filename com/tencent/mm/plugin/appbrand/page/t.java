package com.tencent.mm.plugin.appbrand.page;

import a.a;
import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.k.l;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class t extends MMWebView implements b {
    String fCQ;
    g fdO;
    private LinkedList<Pair<String, ValueCallback<String>>> fsN;
    boolean fwK;
    private p fwL;
    private o gcI;
    private com.tencent.xweb.x5.a.a.a.a.b gcJ;
    private c gnB;
    long goA;
    private long goB;
    boolean goC;
    private boolean goD;
    boolean goE;
    private String goF;
    long goG;
    private String goH;
    private String goI;
    private j goJ;
    String gou;
    private w gov;
    private v gow;
    l gox;
    public Animator goy;
    private long goz;
    String mAppId;

    public t(Context context) {
        super(context);
        this.fwK = false;
        this.goC = false;
        this.goD = false;
        this.goE = true;
        this.goH = null;
        this.goI = null;
        this.fwL = new 6(this);
        this.goJ = new j() {
            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                try {
                    if (t.this.gnB != null) {
                        t.this.gnB.r(view, 90);
                        t.this.gnB.gmk = customViewCallback;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                try {
                    if (t.this.gnB != null) {
                        t.this.gnB.alE();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e.getMessage());
                }
            }
        };
        this.gcI = new 8(this);
        this.gcJ = new com.tencent.xweb.x5.a.a.a.a.b() {
            public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
                return t.this.gcI.z(motionEvent);
            }

            public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
                return t.this.gcI.B(motionEvent);
            }

            public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
                return t.this.gcI.A(motionEvent);
            }

            public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
                return t.this.gcI.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                t.this.gcI.onScrollChanged(i, i2, i3, i4, view);
            }

            public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
                t.this.gcI.c(i, i2, z, z2);
            }

            public final void computeScroll(View view) {
                t.this.gcI.akr();
            }

            public final boolean onShowLongClickPopupMenu() {
                if (WebView.getUsingTbsCoreVersion(t.this.getContext()) >= 43011) {
                    return false;
                }
                return true;
            }

            public final Object onMiscCallBack(String str, Bundle bundle) {
                if (bi.oW(str) || bundle == null) {
                    return null;
                }
                x.i("MicroMsg.AppBrandWebView", "method = %s", new Object[]{str});
                if (!str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
                    return null;
                }
                String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (bi.oW(string)) {
                    return null;
                }
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(t.this.mAppId, string);
                if (itemByLocalId == null) {
                    x.e("MicroMsg.AppBrandWebView", "get meidiaobj failed, appid : %s, localid :%s", new Object[]{t.this.mAppId, string});
                    return null;
                }
                Object obj = itemByLocalId.dDG;
                x.i("MicroMsg.AppBrandWebView", "filePath" + obj + "tempFilePath" + string);
                return obj;
            }

            public final boolean shouldDiscardCurrentPage() {
                boolean z;
                boolean alT = t.this.gow.alT();
                String str = "MicroMsg.AppBrandWebView";
                String str2 = "shouldTrimCurrentPage: %b";
                Object[] objArr = new Object[1];
                if (!alT || t.this.goE) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (!alT || t.this.goE) {
                    return false;
                }
                return true;
            }

            public final void hasDiscardCurrentPage(boolean z) {
                boolean z2;
                boolean z3 = true;
                t.this.goE = z;
                t tVar = t.this;
                if (z) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                tVar.fwK = z2;
                t tVar2 = t.this;
                if (z) {
                    z3 = false;
                }
                tVar2.goD = z3;
            }
        };
        this.dfF = true;
        this.isX5Kernel = getX5WebViewExtension() != null;
        this.fsN = new LinkedList();
        this.goz = System.currentTimeMillis();
        he(getContext());
        getSettings().cIv();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().cIx();
        getSettings().setUserAgentString(s.aV(getContext(), getSettings().getUserAgentString()));
        this.goF = getSettings().getUserAgentString();
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.fwL);
        setWebChromeClient(this.goJ);
        setWebViewCallbackClient(this.gcI);
        if (getIsX5Kernel()) {
            setWebViewClientExtension(this.gcJ);
            try {
                a.cJ(getX5WebViewExtension()).y("setEnableAutoPageDiscarding", Boolean.valueOf(false));
                a.cJ(getX5WebViewExtension()).y("setEnableAutoPageRestoration", Boolean.valueOf(false));
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandWebView", "DisableAutoPageDiscarding error " + e);
            }
        }
        x.i("MicroMsg.AppBrandWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(new 1(this));
        setDownloadListener(new 2(this));
    }

    public final void setIsPreload(boolean z) {
        this.goC = z;
    }

    public final void init() {
        x.i("MicroMsg.AppBrandWebView", "loadPageFrame with url(%s)", new Object[]{getBaseURL()});
        loadUrl(getBaseURL());
    }

    public final String getPagePath() {
        return this.fCQ;
    }

    public final String getPageURL() {
        return this.gou;
    }

    public final void setWebViewTitle(String str) {
        if (!bi.oW(str) && com.tencent.mm.sdk.a.b.chp()) {
            evaluateJavascript("document.title=\"" + str + "\"", null);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.fwK) {
            3 3 = new 3(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                3.run();
                return;
            } else {
                ah.A(3);
                return;
            }
        }
        this.fsN.add(new Pair(str, valueCallback));
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void setJsExceptionHandler(d dVar) {
    }

    private void amc() {
        Iterator it = this.fsN.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            super.evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.fsN.clear();
    }

    public final <T extends c> T y(Class<T> cls) {
        return null;
    }

    public final String getUserAgentString() {
        return this.goF;
    }

    public final void destroy() {
        super.destroy();
        if (this.goy != null) {
            this.goy.cancel();
            this.goy = null;
        }
    }

    /* renamed from: amd */
    final void d() {
        JSONObject jSONObject = new JSONObject();
        if (this.fdO != null) {
            a(jSONObject, "appType", Integer.valueOf(this.fdO.fct.bGM));
        } else if (this.goC) {
            a(jSONObject, "preload", Boolean.valueOf(true));
        }
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.qVN));
        if (this.fdO != null) {
            jSONObject = this.fdO.fcy.aaK();
        }
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "width", Float.valueOf(((float) getResources().getDisplayMetrics().widthPixels) / getResources().getDisplayMetrics().density));
        a(jSONObject2, "pixelRatio", Float.valueOf(getResources().getDisplayMetrics().density));
        evaluateJavascript(String.format("var __wxConfig = %s;\nvar __deviceInfo__ = %s\n", new Object[]{jSONObject.toString(), jSONObject2.toString()}), null);
        String str = "";
        if (!this.goD) {
            this.goD = true;
            str = str + com.tencent.mm.plugin.appbrand.q.c.vM("wxa_library/android.js") + WxaCommLibRuntimeReader.qJ("WAWebview.js");
        }
        if (this.fdO != null) {
            str = str + getVConsoleScript() + getPerformanceScript() + getRemoteDebugScript();
        }
        if (bi.oW(str)) {
            x.v("MicroMsg.AppBrandWebView", "execInitScript, js null");
        } else {
            h.mEJ.a(370, 1, 1, false);
            i.a(this, str, new 4(this));
        }
        if (this.fdO != null && this.mAppId != null) {
            this.fdO.fcJ.o(3, this.goB - this.goz);
            com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "Native", "WebViewInit+PageFrameLoad", this.goz, this.goB, "");
            if (this.fCQ != null) {
                x.i("MicroMsg.AppBrandWebView", "Inject page on frame load finished");
                vc(this.fCQ);
            }
            amc();
        }
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandWebView", e.getMessage());
        }
    }

    private String getVConsoleScript() {
        String str = "";
        if (!this.fdO.fcu.fqL || this.fdO.aar()) {
            return str;
        }
        return WxaCommLibRuntimeReader.qJ("WAVConsole.js");
    }

    private String getPerformanceScript() {
        String str = "";
        if (AppBrandPerformanceManager.vi(this.mAppId)) {
            return WxaCommLibRuntimeReader.qJ("WAPerf.js");
        }
        return str;
    }

    private String getRemoteDebugScript() {
        String str = "";
        if (this.fdO.aar()) {
            return ";" + WxaCommLibRuntimeReader.qJ("WARemoteDebug.js");
        }
        return str;
    }

    private String getBaseURLPrefix() {
        if (this.goH == null) {
            this.goH = "https://servicewechat.com/";
            if (this.goC) {
                this.goH += "preload/";
            } else {
                this.goH += this.mAppId + "/" + this.fdO.fcu.frm.fii + "/";
            }
        }
        return this.goH;
    }

    private String getBaseURL() {
        if (this.goI == null) {
            this.goI = getBaseURLPrefix() + "page-frame.html";
        }
        return this.goI;
    }

    final void vc(String str) {
        this.goA = System.currentTimeMillis();
        String a = ao.a(this.fdO, str);
        if (bi.oW(a)) {
            x.e("MicroMsg.AppBrandWebView", "Cache content empty, abort inject");
            return;
        }
        String str2;
        String uB;
        if (this.fdO.fcM.alp()) {
            str2 = "" + ";" + ao.a(this.fdO, "/app-wxss.js");
            uB = this.fdO.fcM.uB(this.fCQ);
            uB = str2 + ";" + ao.a(this.fdO, uB + (uB.endsWith("/") ? "" : "/") + "page-frame.js");
        } else {
            uB = this.goC ? vd(ao.a(this.fdO, "/page-frame.html")) : "";
        }
        int indexOf = a.indexOf("<style>");
        int indexOf2 = a.indexOf("</style>");
        str2 = (indexOf == -1 || indexOf2 == (-indexOf)) ? "" : a.substring(indexOf + 7, indexOf2);
        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
        indexOf = a.indexOf("<page>");
        int indexOf3 = a.indexOf("</page>");
        str2 = (indexOf == -1 || indexOf3 == (-indexOf)) ? "" : a.substring(indexOf + 6, indexOf3);
        str2 = Base64.encodeToString(str2.getBytes(), 2);
        a = vd(a);
        evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;%s", new Object[]{encodeToString, str2, uB, a}), null);
    }

    private static String vd(String str) {
        String str2 = "";
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("<script>", i);
            int indexOf2 = str.indexOf("</script>", i);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                return str2;
            }
            str2 = str2 + (i > 0 ? ";" : "") + str.substring(indexOf + 8, indexOf2);
            i = indexOf2 + 9;
        }
        return str2;
    }

    public final void setOnScrollChangedListener(w wVar) {
        this.gov = wVar;
    }

    public final void setOnTrimListener(v vVar) {
        this.gow = vVar;
    }

    public final void setFullscreenImpl(c cVar) {
        this.gnB = cVar;
    }
}

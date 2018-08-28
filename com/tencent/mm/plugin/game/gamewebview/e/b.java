package com.tencent.mm.plugin.game.gamewebview.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.game.gamewebview.c.a;
import com.tencent.mm.plugin.game.gamewebview.model.g;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class b extends MMWebView {
    private boolean fwK;
    private d jGw;
    private g jKI = new g();
    private p jKJ;
    private j jKK;
    private o jKL;
    private com.tencent.xweb.x5.a.a.a.a.b jKM;
    private c jKN;
    private boolean jKO;
    private b jKP = new b(this, (byte) 0);
    private c jKQ = new c(this, (byte) 0);
    private a jKR = new a(this, (byte) 0);
    private LinkedList<String> jKS = new LinkedList();
    private com.tencent.xweb.x5.a.a.a.a.b jKT = new 3(this);
    private Context mContext;

    static /* synthetic */ void d(b bVar) {
        Iterator it = bVar.jKS.iterator();
        while (it.hasNext()) {
            bVar.evaluateJavascript((String) it.next(), null);
        }
        bVar.jKS.clear();
    }

    public b(Context context, d dVar) {
        boolean z;
        boolean booleanExtra;
        boolean booleanExtra2;
        super(context);
        this.mContext = context;
        this.jGw = dVar;
        this.jKN = new c(this.jGw);
        MMWebView.he(this.mContext);
        this.dfF = true;
        if (getX5WebViewExtension() != null) {
            z = true;
        } else {
            z = false;
        }
        this.isX5Kernel = z;
        x.i("MicroMsg.GameWebView", "isX5Kernel = " + this.isX5Kernel);
        if (!(getIsX5Kernel() || com.tencent.mm.compatible.util.d.fR(19))) {
            try {
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new c(this, "mSysWebView", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new c(r0, "mProvider", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new c(r0, "mWebViewCore", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new c(r0, "sWebCoreHandler", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new c(r0, "mLooper", null).get()});
                Object obj = new c(obj, "mThread", null).get();
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    x.i("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
        if (this.mContext instanceof Activity) {
            booleanExtra = ((Activity) this.mContext).getIntent().getBooleanExtra("usePlugin", true);
            booleanExtra2 = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
            z = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
        } else {
            z = true;
            booleanExtra2 = true;
            booleanExtra = true;
        }
        getSettings().cIv();
        getSettings().setJavaScriptEnabled(z);
        getSettings().setPluginsEnabled(booleanExtra);
        getSettings().setBuiltInZoomControls(booleanExtra2);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().cIx();
        getSettings().setUserAgentString(s.aV(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().cIq();
        getSettings().cIp();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().cIx();
        getSettings().cIt();
        getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().cIs();
        getSettings().cIu();
        getSettings().setDatabasePath(e.duM + "databases/");
        com.tencent.xweb.b.cIi().cIj();
        com.tencent.xweb.b.cIi().c(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setConfigCallback((WindowManager) ad.getContext().getSystemService("window"));
        super.setWebChromeClient(this.jKR);
        super.setWebViewClient(this.jKQ);
        if (getIsX5Kernel()) {
            super.setWebViewCallbackClient(this.jKP);
            super.setWebViewClientExtension(this.jKT);
        }
        x.i("MicroMsg.GameWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        requestFocus(130);
        String ag = com.tencent.mm.plugin.game.gamewebview.a.d.ag(this.mContext, getSettings().getUserAgentString());
        x.i("MicroMsg.GameWebView", "UserAgent = " + ag);
        getSettings().setUserAgentString(ag);
        a.jIi = ag;
        cAx();
        if (getX5WebViewExtension() != null) {
            k.kB(7);
            h.mEJ.a(64, 64, 1, 0, 1, 1, false);
            return;
        }
        h.mEJ.a(64, 0, 1, false);
    }

    public final void setConfigCallback(WindowManager windowManager) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj, windowManager);
            }
        } catch (Exception e) {
        }
    }

    public final void destroy() {
        if (com.tencent.xweb.c.ij(ad.getContext()) != null) {
            x.i("MicroMsg.GameWebView", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("MicroMsg");
            removeJavascriptInterface("JsApi");
        }
        try {
            super.setWebChromeClient(null);
            super.setWebChromeClient(null);
            super.setOnTouchListener(null);
            super.setOnLongClickListener(null);
            setVisibility(8);
            removeAllViews();
            clearView();
            super.destroy();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
        }
    }

    public final void setWebViewClient(p pVar) {
        this.jKJ = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        this.jKK = jVar;
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.jKL = oVar;
    }

    public final void setProxyWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        this.jKM = bVar;
    }

    public final void fs(boolean z) {
        String convertStreamToString;
        try {
            convertStreamToString = bi.convertStreamToString(getContext().getAssets().open("game_jsapi/jsbridge.js"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            x.e("MicroMsg.GameWebView", "injectJavaScript fail, jsContent is null");
            h.mEJ.a(609, 4, 1, false);
            return;
        }
        evaluateJavascript("javascript:" + convertStreamToString, new 1(this));
        x.i("MicroMsg.GameWebView", "injectJavaScript done");
        h.mEJ.a(609, 1, 1, false);
        if (z) {
            cY("sys:init", "");
        }
    }

    public final void cY(String str, String str2) {
        if (bi.oW(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.GameWebView", "dispatch, event: %s, data size: %d", new Object[]{str, Integer.valueOf(str2.length())});
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        objArr[2] = new JSONObject(hashMap).toString();
        String format = String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, undefined, %s)", objArr);
        if (this.fwK) {
            evaluateJavascript(format, null);
            return;
        }
        x.d("MicroMsg.GameWebView", "not page finish, add js to queue, %s", new Object[]{format});
        this.jKS.add(format);
    }

    @SuppressLint({"DefaultLocale"})
    public final void E(int i, String str) {
        if (bi.oW(str)) {
            str = "{}";
        }
        x.d("MicroMsg.GameWebView", "callback, callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }
}

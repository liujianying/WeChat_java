package com.tencent.xweb.xwalk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.extension.video.c;
import com.tencent.xweb.g;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.xwalk.a.d;
import com.tencent.xweb.xwalk.e.e;
import com.tencent.xweb.xwalk.e.f;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class h implements com.tencent.xweb.c.h {
    p fwL = new p();
    o gcI;
    j goJ = new j();
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    int type = 0;
    WebView vCX;
    long vDd = 0;
    c vDe;
    j vEQ;
    k vER;
    XWalkView vES;
    i vEW;
    AbsoluteLayout vEX;
    f vEY;
    boolean vEZ = false;
    String vFa = null;
    boolean vFb = false;

    public static synchronized boolean eM(Context context) {
        boolean isXWalkReady;
        synchronized (h.class) {
            d.ip(context);
            isXWalkReady = d.isXWalkReady();
        }
        return isXWalkReady;
    }

    private void cJn() {
        if (this.vEQ == null) {
            this.vEQ = new 1(this, this.vES);
            this.vEY.vEQ = this.vEQ;
            this.vES.setUIClient(this.vEQ);
            this.vER = new 2(this, this.vES);
            this.vEY.vER = this.vER;
            this.vES.setResourceClient(this.vER);
        }
    }

    public h(WebView webView) {
        XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue("xweb-version", String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue("xwebsdk-version", "21");
        } catch (Exception e) {
            Log.e("XWWebView", e.getMessage());
        }
        this.vES = new a(this, xWalkContextWrapper);
        this.vEX = new AbsoluteLayout(xWalkContextWrapper);
        this.vES.getXWalkContentView().addView(this.vEX);
        this.vES.setCustomOnScrollChangedListener(new 3(this));
        this.vES.setCustomOnOverScrolledListener(new 4(this));
        this.vEY = new f(this.vES);
        this.vCX = webView;
        this.vEW = new i(this.vES);
        this.vES.getSettings().SetLogCallBack(new 5(this));
        Activity in = in(webView.getContext());
        if (in instanceof Activity) {
            Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
            this.vDe = new c(in, this.vCX);
            if (getFullscreenVideoKind() == a.vAM) {
                this.vES.addJavascriptInterface(this.vDe, "xwebToNative");
            }
        }
    }

    private static Activity in(Context context) {
        while (true) {
            Context context2 = context;
            if (context2 instanceof Activity) {
                return (Activity) context2;
            }
            if (!(context2 instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context2).getBaseContext();
            if (context == context2) {
                return null;
            }
        }
    }

    public final void setWebViewClient(p pVar) {
        if (pVar == null) {
            this.fwL = new p();
            this.fwL.vAn = this.vEY;
            return;
        }
        cJn();
        this.fwL = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        if (jVar == null) {
            this.goJ = new j();
            return;
        }
        cJn();
        this.goJ = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.vES.setDownloadListener(new e(this.vCX.getContext(), downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.vES.setFindListener(new f(findListener));
    }

    public final void loadUrl(String str) {
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.vEZ = false;
            this.vES.loadUrl(str);
            return;
        }
        this.vES.evaluateJavascript(str, null);
    }

    public final boolean canGoBack() {
        return !this.vEZ && this.vES.getNavigationHistory().canGoBack();
    }

    public final void goBack() {
        if (this.vES.getNavigationHistory().canGoBack()) {
            this.vES.getNavigationHistory().navigate(Direction.BACKWARD, 1);
            if (this.vES.getNavigationHistory() != null && this.vES.getNavigationHistory().getCurrentItem() != null) {
                this.goJ.d(this.vCX, this.vES.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
    }

    public final boolean hasEnteredFullscreen() {
        return this.vES.hasEnteredFullscreen();
    }

    public final void leaveFullscreen() {
        this.vES.leaveFullscreen();
    }

    public final void clearView() {
    }

    public final void destroy() {
        this.vES.onDestroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vES.evaluateJavascript(str, valueCallback);
    }

    public final com.tencent.xweb.c.f getDefalutOpProvider() {
        return this.vEY;
    }

    public final void reload() {
        this.vES.reload(0);
    }

    public final void clearSslPreferences() {
        this.vES.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.vES.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.vES.getContentHeight();
    }

    public final float getScale() {
        return this.vES.getScale();
    }

    public final int getVisibleTitleHeight() {
        return 0;
    }

    public final boolean overlayHorizontalScrollbar() {
        int scrollBarStyle = this.vES.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            return true;
        }
        return false;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.vES.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.vES.zoomOut();
    }

    public final boolean zoomIn() {
        return this.vES.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.vES.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vES.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.vES;
    }

    public final String getUrl() {
        return this.vES.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.vES.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.vES.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.gcI = oVar;
    }

    public final b getHitTestResult() {
        b bVar = new b();
        XWalkHitTestResult hitTestResult = this.vES.getHitTestResult();
        bVar.mType = hitTestResult.getType().ordinal();
        bVar.mExtra = hitTestResult.getExtra();
        return bVar;
    }

    public final String getTitle() {
        return this.vES.getTitle();
    }

    public final n getSettings() {
        return this.vEW;
    }

    public final View getWebViewUI() {
        return this.vES;
    }

    public final ViewGroup getTopView() {
        return this.vEX;
    }

    public final void clearMatches() {
        this.vES.clearMatches();
    }

    public final void findNext(boolean z) {
        this.vES.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.vES.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewType = WV_KIND_CW,V8 type=" + g.cIm() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 21";
    }

    public final String getAbstractInfo() {
        return "webviewtype = xwalk, sdkver = 21\n apkver = " + XWalkEnvironment.getAvailableVersion();
    }

    public final p getCurWebviewClient() {
        return this.fwL;
    }

    public final j getCurWebChromeClient() {
        return this.goJ;
    }

    public final int getWebScrollY() {
        return this.vES.computeVerticalScrollOffset();
    }

    public final int getWebScrollX() {
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            return ((XWalkView) webViewUI).computeHorizontalScrollOffset();
        }
        return webViewUI.getScrollX();
    }

    public final boolean isOverScrollStart() {
        int computeVerticalScrollOffset;
        boolean z = this.vFb;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            computeVerticalScrollOffset = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            computeVerticalScrollOffset = webViewUI.getScrollY();
        }
        if (computeVerticalScrollOffset == 0 && z) {
            return true;
        }
        return false;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_computeScroll() {
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public final void onResume() {
    }

    public final void onPause() {
    }

    public final a getFullscreenVideoKind() {
        return com.tencent.xweb.a.adx(WebView.getCurStrModule());
    }
}

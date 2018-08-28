package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.extension.video.c;
import com.tencent.xweb.g;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.sys.SysWebView.1;
import com.tencent.xweb.util.d;
import java.util.Map;
import org.xwalk.core.Log;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class e implements h {
    WebView vCX;
    a vCY;
    p vCZ;
    j vDa;
    d vDb;
    f vDc;
    long vDd = 0;
    c vDe;
    private WebChromeClient vDf = new 1(this);
    private WebViewClient vDg = new 1(this);
    b vDh;
    final String vDi = "xwalkTempCallBack";

    public e(WebView webView) {
        this.vCX = webView;
        this.vCY = new a(this, webView.getContext());
        getSettings();
        this.vDb = new d(this.vCY);
        this.vCY.setWebChromeClient(this.vDf);
        this.vCY.setWebViewClient(this.vDg);
        if (VERSION.SDK_INT < 19) {
            this.vDh = new b();
            this.vCY.addJavascriptInterface(this.vDh, "xwalkTempCallBack");
        }
        if (webView.getContext() instanceof Activity) {
            Activity activity = (Activity) webView.getContext();
            Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
            if (getFullscreenVideoKind() != a.vAK) {
                this.vDe = new c(activity, this.vCX);
                if (getFullscreenVideoKind() == a.vAM) {
                    this.vCY.addJavascriptInterface(this.vDe, "xwebToNative");
                }
            }
        }
    }

    public final n getSettings() {
        if (this.vDc != null) {
            return this.vDc;
        }
        if (this.vCY == null) {
            return null;
        }
        this.vDc = new f(this.vCY);
        return this.vDc;
    }

    public final View getWebViewUI() {
        return this.vCY;
    }

    public final ViewGroup getTopView() {
        return this.vCY;
    }

    public final void setWebViewClient(p pVar) {
        this.vCZ = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        this.vDa = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.vCY.setDownloadListener(downloadListener);
    }

    public final void setFindListener(FindListener findListener) {
        this.vCY.setFindListener(findListener);
    }

    public final void loadUrl(String str) {
        this.vCY.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.vCY.canGoBack();
    }

    public final void goBack() {
        this.vCY.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        if (this.vDe == null) {
            return false;
        }
        return this.vDe.vBZ;
    }

    public final void leaveFullscreen() {
        if (this.vDf != null) {
            this.vDf.onHideCustomView();
        }
    }

    public final void clearView() {
        this.vCY.clearView();
    }

    public final void destroy() {
        this.vCY.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (str != null) {
            if (VERSION.SDK_INT >= 19) {
                this.vCY.evaluateJavascript(str, valueCallback);
            } else if (valueCallback == null) {
                this.vCY.loadUrl(str);
            } else {
                String stringBuilder;
                if (str.trim().startsWith("javascript:")) {
                    str = str.replaceFirst("javascript:", "");
                }
                if (this.vDh == null) {
                    this.vDh = new b();
                    this.vCY.addJavascriptInterface(this.vDh, "xwalkTempCallBack");
                }
                b bVar = this.vDh;
                if (valueCallback != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    int i = bVar.vDl;
                    bVar.vDl = i + 1;
                    stringBuilder = stringBuilder2.append(i).toString();
                    bVar.vDk.put(stringBuilder, valueCallback);
                } else {
                    stringBuilder = "";
                }
                this.vCY.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + stringBuilder + ", " + str + ")");
            }
        }
    }

    public final f getDefalutOpProvider() {
        return this.vDb;
    }

    public final void reload() {
        this.vCY.reload();
    }

    public final void clearSslPreferences() {
        this.vCY.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.vCY.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.vCY.getContentHeight();
    }

    public final float getScale() {
        return this.vCY.getScale();
    }

    public final int getVisibleTitleHeight() {
        Object c = d.c(this.vCY, "getVisibleTitleHeight", null, new Object[0]);
        return c == null ? 0 : ((Integer) c).intValue();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.vCY.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.vCY.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.vCY.zoomOut();
    }

    public final boolean zoomIn() {
        return this.vCY.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.vCY.loadUrl(str, map);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.vCY.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.vCY;
    }

    public final String getUrl() {
        return this.vCY.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.vCY.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.vCY.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        if (this.vCY != null) {
            this.vCY.gcI = oVar;
        }
    }

    public final b getHitTestResult() {
        HitTestResult hitTestResult = this.vCY.getHitTestResult();
        b bVar = new b();
        bVar.mType = hitTestResult.getType();
        bVar.mExtra = hitTestResult.getExtra();
        return bVar;
    }

    public final String getTitle() {
        return this.vCY.getTitle();
    }

    public final void clearMatches() {
        this.vCY.clearMatches();
    }

    public final void findNext(boolean z) {
        this.vCY.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.vCY.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewtype = WV_KIND_SYS, V8 type=" + g.cIm();
    }

    public final String getAbstractInfo() {
        return getVersionInfo();
    }

    public final p getCurWebviewClient() {
        return this.vCZ;
    }

    public final j getCurWebChromeClient() {
        return this.vDa;
    }

    public final int getWebScrollY() {
        return this.vCY.getScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getWebViewUI().getScrollY() == 0;
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
        this.vCY.onResume();
    }

    public final void onPause() {
        this.vCY.onPause();
    }

    public final a getFullscreenVideoKind() {
        return com.tencent.xweb.a.adx(WebView.getCurStrModule());
    }
}

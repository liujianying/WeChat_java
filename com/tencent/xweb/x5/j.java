package com.tencent.xweb.x5;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView$HitTestResult;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView$b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.g;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.x5.a.a;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.a.d;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import java.util.Map;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class j implements h {
    WebView vCX;
    p vCZ;
    com.tencent.smtt.sdk.WebView vDM;
    i vDS;
    k vDT;
    private b vDU = new 1(this);
    private c vDV = new 2(this);
    com.tencent.xweb.j vDa;
    long vDd = 0;

    public j(WebView webView) {
        this.vCX = webView;
        this.vDM = new a(this, webView.getContext());
        this.vDS = new i(this.vDM);
        this.vDM.setWebChromeClient(this.vDU);
        this.vDM.setWebViewClient(this.vDV);
        this.vDS.vDK = this.vDV;
        this.vDS.vDL = this.vDU;
    }

    public final Object getX5WebViewExtension() {
        return this.vDM.getX5WebViewExtension();
    }

    public final void setWebViewClientExtension(b bVar) {
        this.vDM.setWebViewClientExtension(new ProxyWebViewSuperWrapper(bVar));
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return this.vDM.super_onTouchEvent(motionEvent);
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.vDM.super_onInterceptTouchEvent(motionEvent);
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.vDM.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return this.vDM.super_dispatchTouchEvent(motionEvent);
    }

    public final void super_computeScroll() {
        this.vDM.super_computeScroll();
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        this.vDM.super_onScrollChanged(i, i2, i3, i4);
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.vDM.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onResume() {
        this.vDM.onResume();
    }

    public final void onPause() {
        this.vDM.onPause();
    }

    public final n getSettings() {
        if (this.vDT != null) {
            return this.vDT;
        }
        if (this.vDM == null) {
            return null;
        }
        this.vDT = new k(this.vDM);
        return this.vDT;
    }

    public final View getView() {
        return this.vDM.getView();
    }

    public final ViewGroup getTopView() {
        return (ViewGroup) this.vDM.getView();
    }

    public final View getWebViewUI() {
        return this.vDM;
    }

    public final void setWebViewClient(p pVar) {
        this.vCZ = pVar;
    }

    public final void setWebChromeClient(com.tencent.xweb.j jVar) {
        this.vDa = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.vDM.setDownloadListener(new a(downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.vDM.setFindListener(new a.b(findListener));
    }

    public final void loadUrl(String str) {
        this.vDM.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.vDM.canGoBack();
    }

    public final void goBack() {
        this.vDM.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        this.vDM.clearView();
    }

    public final void destroy() {
        this.vDM.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vDM.evaluateJavascript(str, new d(valueCallback));
    }

    public final f getDefalutOpProvider() {
        return this.vDS;
    }

    public final void reload() {
        this.vDM.reload();
    }

    public final void clearSslPreferences() {
        this.vDM.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.vDM.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.vDM.getContentHeight();
    }

    public final float getScale() {
        return this.vDM.getScale();
    }

    public final int getVisibleTitleHeight() {
        return this.vDM.getVisibleTitleHeight();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.vDM.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.vDM.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.vDM.zoomOut();
    }

    public final boolean zoomIn() {
        return this.vDM.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.vDM.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vDM.addJavascriptInterface(obj, str);
    }

    public final String getUrl() {
        return this.vDM.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.vDM.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.vDM.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.vDM.setWebViewCallbackClient(new a.f(oVar));
    }

    public final WebView$b getHitTestResult() {
        WebView$HitTestResult hitTestResult = this.vDM.getHitTestResult();
        WebView$b webView$b = new WebView$b();
        webView$b.mType = hitTestResult.getType();
        webView$b.mExtra = hitTestResult.getExtra();
        return webView$b;
    }

    public final String getTitle() {
        return this.vDM.getTitle();
    }

    public final void clearMatches() {
        this.vDM.clearMatches();
    }

    public final void findNext(boolean z) {
        this.vDM.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.vDM.findAllAsync(str);
    }

    public final String getVersionInfo() {
        if ((this.vDM.getX5WebViewExtension() != null ? 1 : null) != null) {
            return "use x5 and x5 kernel, wrapper version = 3, V8 type=" + g.cIm();
        }
        return "use x5 but sys kernel, wrapper version = 3, V8 type=" + g.cIm();
    }

    public final String getAbstractInfo() {
        return "webviewtype = x5, is using x5 core = " + (this.vDM.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.vCX.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.vCX.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.vCX.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.vCX.getContext());
    }

    public final p getCurWebviewClient() {
        return this.vCZ;
    }

    public final com.tencent.xweb.j getCurWebChromeClient() {
        return this.vDa;
    }

    public final int getWebScrollY() {
        return this.vDM.getWebScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getView().getScrollY() == 0;
    }

    public final WebView.a getFullscreenVideoKind() {
        return WebView.a.vAK;
    }
}

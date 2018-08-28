package com.tencent.xweb.sys;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i.a;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory implements a {
    static SysWebFactory sInstance;

    public static SysWebFactory getInstance() {
        if (sInstance == null) {
            sInstance = new SysWebFactory();
        }
        return sInstance;
    }

    private SysWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        return (str == null || str.isEmpty() || str.equals("STR_CMD_GET_DEBUG_VIEW") || str.equals("STR_CMD_GET_UPDATER")) ? null : null;
    }

    public h createWebView(WebView webView) {
        return new e(webView);
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
    }

    public g getJsCore(com.tencent.xweb.g.a aVar, Context context) {
        return null;
    }

    public boolean initWebviewCore(Context context, c cVar) {
        if (cVar != null) {
            cVar.onCoreInitFinished();
        }
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
    }

    public boolean hasInited() {
        return true;
    }

    public boolean hasInitedCallback() {
        return a.hasInitedCallback();
    }

    public boolean isCoreReady() {
        return true;
    }

    public b.a getCookieManager() {
        return new a();
    }

    public b.b getCookieSyncManager() {
        return new b();
    }
}

package com.tencent.xweb.c;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.g;
import org.xwalk.core.WebViewExtensionListener;

public interface i$a {
    h createWebView(WebView webView);

    Object excute(String str, Object[] objArr);

    a getCookieManager();

    b getCookieSyncManager();

    g getJsCore(g.a aVar, Context context);

    boolean hasInited();

    void initCallback(WebViewExtensionListener webViewExtensionListener);

    void initEnviroment(Context context);

    void initInterface();

    boolean initWebviewCore(Context context, c cVar);
}

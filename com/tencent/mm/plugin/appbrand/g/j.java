package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import com.tencent.xweb.p;
import java.net.URL;
import java.util.LinkedList;

public final class j extends WebView implements b, e {
    private final LinkedList<Pair<String, ValueCallback<String>>> fwJ = new LinkedList();
    private boolean fwK = false;
    private p fwL = new 2(this);
    private boolean gdU = false;
    private Context mContext;
    private ag mHandler;
    private volatile boolean nY = false;

    public j(Context context) {
        super(context);
        this.mContext = context;
        this.mHandler = new ag(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aV(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.fwL);
        setWillNotDraw(true);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (obj != null && !bi.oW(str)) {
            super.addJavascriptInterface(obj, str);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.gdU) {
            this.gdU = true;
            loadDataWithBaseURL("https://servicewechat.com/js-engine", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", "utf-8", null);
        }
        synchronized (this.fwJ) {
            if (this.fwK) {
                d(str, valueCallback);
                return;
            }
            this.fwJ.add(new Pair(str, valueCallback));
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void setJsExceptionHandler(d dVar) {
    }

    private void d(final String str, final ValueCallback<String> valueCallback) {
        if (!this.nY) {
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    super.evaluateJavascript(str, valueCallback);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                this.mHandler.post(anonymousClass1);
            }
        }
    }

    public final void destroy() {
        this.nY = true;
        super.destroy();
    }

    public final <T extends c> T y(Class<T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public final void setJsRuntimeTitle(String str) {
        evaluateJavascript("document.title=\"" + str + "\"", null);
    }
}

package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.b.d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.util.LinkedList;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20170320", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public class b extends WebView implements d {
    private final LinkedList<Pair<String, ValueCallback<String>>> fwJ = new LinkedList();
    private boolean fwK = false;
    private p fwL = new 2(this);
    private Context mContext;
    private ag mHandler;
    private volatile boolean nY = false;

    public b(Context context, Object obj, String str, String str2) {
        super(context);
        this.mContext = context;
        this.mHandler = new ag(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aV(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.fwL);
        if (!(obj == null || bi.oW(str))) {
            addJavascriptInterface(obj, str);
        }
        setWillNotDraw(true);
        loadDataWithBaseURL(str2, "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.fwJ) {
            if (this.fwK) {
                d(str, valueCallback);
                return;
            }
            this.fwJ.add(new Pair(str, valueCallback));
        }
    }

    private void d(String str, ValueCallback<String> valueCallback) {
        if (!this.nY) {
            1 1 = new 1(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                this.mHandler.post(1);
            }
        }
    }

    public final void cleanup() {
        this.nY = true;
        destroy();
    }

    public void pause() {
    }

    public void resume() {
    }

    public boolean CY() {
        return false;
    }

    public final boolean CZ() {
        return true;
    }
}

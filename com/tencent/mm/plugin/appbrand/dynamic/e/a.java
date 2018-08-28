package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.d;
import com.tencent.xweb.g;
import java.util.concurrent.CountDownLatch;

public final class a implements d {
    g fwC;
    private volatile boolean fwD;
    private volatile boolean fwE = false;
    private volatile CountDownLatch fwF;
    private ag mHandler;

    public final boolean CZ() {
        return this.fwC.isValid();
    }

    public a(Object obj, String str, g gVar) {
        this.fwC = gVar;
        this.fwD = false;
        this.fwC.addJavascriptInterface(obj, str);
        this.mHandler = new ag(Looper.getMainLooper());
        this.fwC.addJavascriptInterface(this, "WeixinJsThreadCaller");
    }

    @JavascriptInterface
    public final int callFromJsThread() {
        x.d("MicroMsg.AppBrandX5BasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[]{Boolean.valueOf(this.fwE)});
        if (this.fwE) {
            x.i("MicroMsg.AppBrandX5BasedJsEngine", "pause await threadId %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            this.fwE = false;
            this.fwF = new CountDownLatch(1);
            try {
                this.fwF.await();
            } catch (InterruptedException e) {
                x.e("MicroMsg.AppBrandX5BasedJsEngine", "pause await e = %s", new Object[]{e});
            }
        }
        return 1;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.fwD) {
            1 1 = new 1(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                this.mHandler.post(1);
            }
        }
    }

    public final void cleanup() {
        if (!this.fwD) {
            this.fwC.cleanup();
        }
        this.fwD = true;
    }

    public final void pause() {
        if (this.fwC.CY()) {
            this.fwC.pause();
            return;
        }
        this.fwE = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new 2(this));
    }

    public final void resume() {
        if (this.fwC.CY()) {
            this.fwC.resume();
            return;
        }
        this.fwE = false;
        if (this.fwF != null) {
            this.fwF.countDown();
            this.fwF = null;
        }
    }

    public final boolean CY() {
        return true;
    }
}

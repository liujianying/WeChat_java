package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import com.tencent.xweb.g;
import com.tencent.xweb.g.a;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public final class i implements b, d, g {
    private volatile boolean fwD = false;
    private volatile boolean fwE = false;
    private volatile CountDownLatch fwF;
    g gdR;
    private Handler mHandler;

    public i(Context context) {
        this.gdR = g.a(a.vAc, "appbrand", context);
        this.gdR.addJavascriptInterface(this, "WeixinJsThreadCaller");
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.gdR.addJavascriptInterface(obj, str);
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

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        if (!this.fwD) {
            2 2 = new 2(this, url, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                2.run();
            } else {
                this.mHandler.post(2);
            }
        }
    }

    public final void setJsExceptionHandler(d dVar) {
        this.gdR.vzZ.setJsExceptionHandler(dVar);
    }

    public final void destroy() {
        if (!this.fwD) {
            this.gdR.cleanup();
        }
        this.fwD = true;
    }

    public final <T extends c> T y(Class<T> cls) {
        if (!cls.isInstance(this)) {
            return null;
        }
        if (cls != d.class || this.gdR.vzZ.cIG()) {
            return this;
        }
        return null;
    }

    public final void pause() {
        if (this.gdR.CY()) {
            this.gdR.pause();
            return;
        }
        this.fwE = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new 3(this));
    }

    public final void resume() {
        if (this.gdR.CY()) {
            this.gdR.resume();
            return;
        }
        this.fwE = false;
        if (this.fwF != null) {
            this.fwF.countDown();
            this.fwF = null;
        }
    }

    public final int getNativeBufferId() {
        return this.gdR.vzZ.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        this.gdR.vzZ.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        return this.gdR.vzZ.getNativeBuffer(i);
    }

    public final boolean agi() {
        if (WebView.getUsingTbsCoreVersion(ad.getContext()) >= 43600) {
            return true;
        }
        return false;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int callFromJsThread() {
        x.d("MicroMsg.AppBrandMessBasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[]{Boolean.valueOf(this.fwE)});
        if (this.fwE) {
            x.i("MicroMsg.AppBrandMessBasedJsEngine", "pause await threadId %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            this.fwE = false;
            this.fwF = new CountDownLatch(1);
            try {
                this.fwF.await();
            } catch (InterruptedException e) {
                x.e("MicroMsg.AppBrandMessBasedJsEngine", "pause await e = %s", new Object[]{e});
            }
        }
        return 1;
    }
}

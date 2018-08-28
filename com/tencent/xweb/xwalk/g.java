package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

public final class g implements com.tencent.xweb.c.g {
    HandlerThread vEE = new HandlerThread("j2v8");
    private Handler vEF;
    XWalkV8 vET;

    public g() {
        this.vEE.start();
        this.vEF = new Handler(this.vEE.getLooper());
    }

    public final void init(int i) {
        this.vEF.post(new 1(this, i));
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void cleanup() {
        this.vEF.post(new 2(this));
    }

    public final boolean CY() {
        return false;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vEF.post(new 3(this, str, valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        evaluateJavascript(str, valueCallback);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vEF.post(new 4(this, obj, str));
    }

    public final int getNativeBufferId() {
        return 0;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
    }

    public final ByteBuffer getNativeBuffer(int i) {
        return null;
    }

    public final boolean cIG() {
        return false;
    }

    public final void setJsExceptionHandler(d dVar) {
    }
}

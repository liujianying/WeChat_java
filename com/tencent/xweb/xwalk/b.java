package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.g;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public final class b implements g {
    XWAppBrandEngine vED;
    HandlerThread vEE = new HandlerThread("v8_worker");
    private Handler vEF;
    boolean vEG = false;

    public b() {
        this.vEE.start();
        this.vEF = new Handler(this.vEE.getLooper());
    }

    public final void init(int i) {
        this.vEF.post(new 1(this));
    }

    public final void pause() {
        if (!this.vEG) {
            this.vEG = true;
            this.vEF.post(new 2(this));
        }
    }

    public final void resume() {
        this.vEG = false;
    }

    public final void cleanup() {
        this.vEF.post(new 3(this));
    }

    public final boolean CY() {
        return true;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vEF.post(new 4(this, str, valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        evaluateJavascript(str, valueCallback);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vEF.post(new 5(this, obj, str));
    }

    public final int getNativeBufferId() {
        if (this.vED == null) {
            return 0;
        }
        XWAppBrandEngine xWAppBrandEngine = this.vED;
        return xWAppBrandEngine.getNativeBufferId(xWAppBrandEngine.mInstance);
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        XWAppBrandEngine xWAppBrandEngine = this.vED;
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
                byteBuffer.rewind();
                allocateDirect.put(byteBuffer);
                byteBuffer = allocateDirect;
            }
            xWAppBrandEngine.setNativeBuffer(xWAppBrandEngine.mInstance, i, byteBuffer);
        }
    }

    public final ByteBuffer getNativeBuffer(int i) {
        XWAppBrandEngine xWAppBrandEngine = this.vED;
        ByteBuffer nativeBuffer = xWAppBrandEngine.getNativeBuffer(xWAppBrandEngine.mInstance, i);
        return nativeBuffer == null ? ByteBuffer.allocate(0) : nativeBuffer;
    }

    public final boolean cIG() {
        return true;
    }

    public final void setJsExceptionHandler(d dVar) {
    }
}

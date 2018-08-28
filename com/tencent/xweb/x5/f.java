package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.c.g;
import com.tencent.xweb.x5.a.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class f implements g {
    private Context mContext;
    private X5JsCore vDy;

    public f(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.vDy = new X5JsCore(this.mContext);
    }

    public final void pause() {
        this.vDy.pause();
    }

    public final void resume() {
        this.vDy.resume();
    }

    public final boolean CY() {
        return X5JsCore.canUseX5JsCore(this.mContext) && QbSdk.getTbsVersion(this.mContext) >= 43600;
    }

    public final void cleanup() {
        this.vDy.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vDy.evaluateJavascript(str, new d(valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.vDy.evaluateJavascript(str, new d(valueCallback));
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vDy.addJavascriptInterface(obj, str);
    }

    public final int getNativeBufferId() {
        return this.vDy.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        this.vDy.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        return this.vDy.getNativeBuffer(i);
    }

    public final boolean cIG() {
        return X5JsCore.canX5JsCoreUseNativeBuffer(this.mContext);
    }

    public final void setJsExceptionHandler(com.tencent.xweb.d dVar) {
    }
}

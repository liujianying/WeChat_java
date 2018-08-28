package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.xweb.c.g;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class h implements g {
    d gex;
    private Context mContext;
    private JsContext vDG;
    private a vDH;

    public h(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.vDG = new JsContext(this.mContext);
        this.vDH = new a();
        this.vDG.addJavascriptInterface(this.vDH, "nativeBufferCompat");
        this.vDG.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new 1(this)));
        this.vDG.setExceptionHandler(new 2(this));
    }

    public final void pause() {
        this.vDG.virtualMachine().onPause();
    }

    public final void resume() {
        this.vDG.virtualMachine().onResume();
    }

    public final boolean CY() {
        return true;
    }

    public final void cleanup() {
        this.vDG.destroy();
        this.vDH.geu.clear();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vDG.evaluateJavascript(str, new a.d(valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        Log.i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[]{url}));
        this.vDG.evaluateJavascript(str, new a.d(valueCallback), url);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vDG.addJavascriptInterface(obj, str);
    }

    public final int getNativeBufferId() {
        return this.vDH.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        byte[] bArr;
        a aVar = this.vDH;
        if (byteBuffer == null) {
            bArr = new byte[0];
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
        } else {
            bArr = byteBuffer.array();
        }
        aVar.setNativeBuffer(i, bArr);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        byte[] nativeBuffer = this.vDH.getNativeBuffer(i);
        if (nativeBuffer == null || nativeBuffer.length <= 0) {
            return null;
        }
        return ByteBuffer.wrap(nativeBuffer);
    }

    public final boolean cIG() {
        return true;
    }

    public final void setJsExceptionHandler(d dVar) {
        this.gex = dVar;
    }
}

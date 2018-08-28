package com.tencent.xweb.c;

import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public interface g {
    boolean CY();

    void addJavascriptInterface(Object obj, String str);

    boolean cIG();

    void cleanup();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url);

    ByteBuffer getNativeBuffer(int i);

    int getNativeBufferId();

    void init(int i);

    void pause();

    void resume();

    void setJsExceptionHandler(d dVar);

    void setNativeBuffer(int i, ByteBuffer byteBuffer);
}

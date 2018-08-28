package com.tencent.mm.u.b;

import android.webkit.ValueCallback;

public interface d {
    boolean CY();

    boolean CZ();

    void cleanup();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void pause();

    void resume();
}

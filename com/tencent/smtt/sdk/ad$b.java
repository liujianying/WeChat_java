package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;

class ad$b implements HttpAuthHandler {
    private android.webkit.HttpAuthHandler a;

    ad$b(android.webkit.HttpAuthHandler httpAuthHandler) {
        this.a = httpAuthHandler;
    }

    public void cancel() {
        this.a.cancel();
    }

    public void proceed(String str, String str2) {
        this.a.proceed(str, str2);
    }

    public boolean useHttpAuthUsernamePassword() {
        return this.a.useHttpAuthUsernamePassword();
    }
}

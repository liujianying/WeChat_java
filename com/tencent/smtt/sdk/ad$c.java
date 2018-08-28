package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;

class ad$c implements SslErrorHandler {
    android.webkit.SslErrorHandler a;

    ad$c(android.webkit.SslErrorHandler sslErrorHandler) {
        this.a = sslErrorHandler;
    }

    public void cancel() {
        this.a.cancel();
    }

    public void proceed() {
        this.a.proceed();
    }
}

package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.xweb.h;

public class g$a implements h {
    SslErrorHandler vDA;

    public g$a(SslErrorHandler sslErrorHandler) {
        this.vDA = sslErrorHandler;
    }

    public final void proceed() {
        this.vDA.proceed();
    }

    public final void cancel() {
        this.vDA.cancel();
    }
}

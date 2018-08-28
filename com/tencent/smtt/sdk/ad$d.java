package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;
import com.tencent.smtt.export.external.interfaces.SslError;

class ad$d implements SslError {
    android.net.http.SslError a;

    ad$d(android.net.http.SslError sslError) {
        this.a = sslError;
    }

    public boolean addError(int i) {
        return this.a.addError(i);
    }

    public SslCertificate getCertificate() {
        return this.a.getCertificate();
    }

    public int getPrimaryError() {
        return this.a.getPrimaryError();
    }

    public boolean hasError(int i) {
        return this.a.hasError(i);
    }
}

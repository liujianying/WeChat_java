package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

class ad$a extends ClientCertRequest {
    private android.webkit.ClientCertRequest a;

    public ad$a(android.webkit.ClientCertRequest clientCertRequest) {
        this.a = clientCertRequest;
    }

    public void cancel() {
        this.a.cancel();
    }

    public String getHost() {
        return this.a.getHost();
    }

    public String[] getKeyTypes() {
        return this.a.getKeyTypes();
    }

    public int getPort() {
        return this.a.getPort();
    }

    public Principal[] getPrincipals() {
        return this.a.getPrincipals();
    }

    public void ignore() {
        this.a.ignore();
    }

    public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.a.proceed(privateKey, x509CertificateArr);
    }
}

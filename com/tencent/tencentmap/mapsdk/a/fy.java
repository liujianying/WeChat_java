package com.tencent.tencentmap.mapsdk.a;

import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public final class fy extends SSLSocketFactory {
    private SSLContext a = SSLContext.getInstance("TLS");
    private String b = "";

    public static class a implements X509TrustManager {
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                for (X509Certificate checkValidity : x509CertificateArr) {
                    checkValidity.checkValidity();
                }
            } catch (CertificateException e) {
            }
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                for (X509Certificate checkValidity : x509CertificateArr) {
                    checkValidity.checkValidity();
                }
            } catch (CertificateException e) {
            }
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public fy(KeyStore keyStore, String str) {
        super(keyStore);
        this.b = str;
        a aVar = new a();
        this.a.init(null, new TrustManager[]{aVar}, null);
    }

    public final Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, this.b, i, z);
    }
}

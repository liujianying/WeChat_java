package com.tencent.xweb.xwalk.a;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

class f$d {
    private static TrustManager vFS = new 1();
    public static final HostnameVerifier vFT = new 2();

    public static SSLContext cJB() {
        SSLContext sSLContext = null;
        try {
            sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{vFS}, new SecureRandom());
            return sSLContext;
        } catch (Exception e) {
            return sSLContext;
        }
    }
}

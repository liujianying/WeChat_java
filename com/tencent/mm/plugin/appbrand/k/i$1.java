package com.tencent.mm.plugin.appbrand.k;

import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class i$1 implements HostnameVerifier {
    final /* synthetic */ HostnameVerifier gln;
    final /* synthetic */ ArrayList glo;

    i$1(HostnameVerifier hostnameVerifier, ArrayList arrayList) {
        this.gln = hostnameVerifier;
        this.glo = arrayList;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return this.gln.verify(str, sSLSession) || i.c(this.glo, str);
    }
}

package com.tencent.mm.plugin.appbrand.k;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class c {
    int gkB;
    private SSLContext gkD;
    private final String gkE;
    protected final ArrayList<String> gkF = new ArrayList();
    protected final ArrayList<d> gkL = new ArrayList();
    private String mAppId;

    public c(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.gkB = appBrandSysConfig.fqT;
        this.gkE = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.appbrand.k.d r20) {
        /*
        r19 = this;
        r13 = 0;
        r16 = 0;
        r15 = 0;
        r0 = r20;
        r0 = r0.gkW;
        r17 = r0;
        r0 = r20;
        r14 = r0.gkX;
        r12 = 0;
        r11 = 0;
        r0 = r20;
        r0 = r0.gkY;
        r18 = r0;
        if (r18 == 0) goto L_0x005d;
    L_0x0018:
        r0 = r20;
        r2 = r0.mUrl;
        r0 = r18;
        r2 = com.tencent.mm.plugin.appbrand.k.i.b(r0, r2);
        if (r2 != 0) goto L_0x005d;
    L_0x0024:
        r2 = "url not in domain list";
        r0 = r17;
        r0.tR(r2);
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
    L_0x005c:
        return;
    L_0x005d:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "prepare to send https request url is %s method is %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;
        r4[r5] = r6;
        r5 = 1;
        r0 = r20;
        r6 = r0.gkV;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r20;
        r3 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r2;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13 = r0;
        r0 = r20;
        r2 = r0.fEl;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 != 0) goto L_0x00a2;
    L_0x009e:
        r0 = r20;
        r0.glb = r13;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
    L_0x00a2:
        if (r13 != 0) goto L_0x00d8;
    L_0x00a4:
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x00d8:
        r2 = r13 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 == 0) goto L_0x0120;
    L_0x00dc:
        r0 = r19;
        r2 = r0.gkD;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 != 0) goto L_0x00ee;
    L_0x00e2:
        r0 = r19;
        r2 = r0.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.uP(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r19;
        r0.gkD = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
    L_0x00ee:
        r0 = r19;
        r2 = r0.gkD;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 == 0) goto L_0x0103;
    L_0x00f4:
        r0 = r13;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = r0;
        r0 = r19;
        r3 = r0.gkD;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
    L_0x0103:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r4 = "DomainList: ";
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r18;
        com.tencent.mm.plugin.appbrand.k.i.a(r13, r0);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
    L_0x0120:
        r0 = r20;
        r2 = r0.gkT;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setConnectTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r20;
        r2 = r0.gkT;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setReadTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = "charset";
        r3 = "utf-8";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = 0;
        r13.setInstanceFollowRedirects(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r20;
        r2 = r0.gkV;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setRequestMethod(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = 1;
        r13.setUseCaches(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = "Accept-Encoding";
        r3 = "gzip";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r14 == 0) goto L_0x0219;
    L_0x0151:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : set header ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = r14.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r5 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
    L_0x016c:
        r2 = r5.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 == 0) goto L_0x0219;
    L_0x0172:
        r2 = r5.next();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r2;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r4 = r0;
        r2 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : key:%s ,value %s ";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r7 = 0;
        r0 = r20;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r7 = 1;
        r8 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r7 = 2;
        r4 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        goto L_0x016c;
    L_0x01ab:
        r2 = move-exception;
        r14 = r11;
    L_0x01ad:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "UnsupportedEncodingException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r2 = "UTF-8 decode error";
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x0207;
    L_0x0204:
        r16.close();	 Catch:{ IOException -> 0x05e1, ArrayIndexOutOfBoundsException -> 0x05f0, Throwable -> 0x05ff }
    L_0x0207:
        if (r15 == 0) goto L_0x020c;
    L_0x0209:
        r15.close();	 Catch:{ IOException -> 0x060e }
    L_0x020c:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x0219:
        r2 = "User-Agent";
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r19;
        r4 = r0.gkE;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = com.tencent.mm.pluginsdk.ui.tools.s.aV(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r20;
        r2 = r0.gkV;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = uJ(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        if (r2 == 0) goto L_0x0325;
    L_0x0235:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "set post or put";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = "Content-Length";
        r0 = r20;
        r3 = r0.gkU;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = 1;
        r13.setDoOutput(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.f(r13);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r4 = r13.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r0 = r20;
        r4 = r0.gkU;	 Catch:{ UnsupportedEncodingException -> 0x0a5c, SSLHandshakeException -> 0x0a4e, FileNotFoundException -> 0x0a40, SocketTimeoutException -> 0x0a32, SSLProtocolException -> 0x0a24, Exception -> 0x0a16, all -> 0x0a00 }
        r3.write(r4);	 Catch:{ UnsupportedEncodingException -> 0x0a5c, SSLHandshakeException -> 0x0a4e, FileNotFoundException -> 0x0a40, SocketTimeoutException -> 0x0a32, SSLProtocolException -> 0x0a24, Exception -> 0x0a16, all -> 0x0a00 }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x0a5c, SSLHandshakeException -> 0x0a4e, FileNotFoundException -> 0x0a40, SocketTimeoutException -> 0x0a32, SSLProtocolException -> 0x0a24, Exception -> 0x0a16, all -> 0x0a00 }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x0a5c, SSLHandshakeException -> 0x0a4e, FileNotFoundException -> 0x0a40, SocketTimeoutException -> 0x0a32, SSLProtocolException -> 0x0a24, Exception -> 0x0a16, all -> 0x0a00 }
        r15 = r3;
    L_0x026c:
        r0 = r17;
        r0.t(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        r10 = r13.getResponseCode();	 Catch:{ IOException -> 0x032b }
    L_0x0275:
        r4 = com.tencent.mm.plugin.appbrand.k.i.e(r13);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r0 = r17;
        r0.t(r4);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "responseCode = %d, url = %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 1;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 == r2) goto L_0x03c8;
    L_0x029c:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url is %s, failed code: %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.lm(r10);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        if (r2 == 0) goto L_0x03c8;
    L_0x02bc:
        r2 = com.tencent.mm.plugin.appbrand.k.i.d(r13);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r0 = r20;
        r3 = r0.gkZ;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        if (r5 != 0) goto L_0x03c8;
    L_0x02ca:
        if (r3 > 0) goto L_0x0340;
    L_0x02cc:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "reach the max redirect count(%d)";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 0;
        r7 = 15;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = "ok";
        r3 = "reach the max redirect count 15";
        r0 = r17;
        r0.a(r2, r3, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r11 = 1;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x0318;
    L_0x0315:
        r15.close();	 Catch:{ IOException -> 0x0332 }
    L_0x0318:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x0325:
        r2 = com.tencent.mm.plugin.appbrand.k.i.f(r13);	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        goto L_0x026c;
    L_0x032b:
        r2 = move-exception;
        r10 = r13.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ab, SSLHandshakeException -> 0x061d, FileNotFoundException -> 0x06d4, SocketTimeoutException -> 0x077a, SSLProtocolException -> 0x082e, Exception -> 0x08d4, all -> 0x0988 }
        goto L_0x0275;
    L_0x0332:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0318;
    L_0x0340:
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "redirect(%d) URL(%s) to URL(%s)";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r7 = 1;
        r0 = r20;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r7 = 2;
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r0 = r20;
        r0.mUrl = r2;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = r3 + -1;
        r0 = r20;
        r0.gkZ = r2;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "now redirect count = %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5 = 0;
        r0 = r20;
        r6 = r0.gkZ;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r19.a(r20);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r11 = 2;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x03ad;
    L_0x03aa:
        r15.close();	 Catch:{ IOException -> 0x03ba }
    L_0x03ad:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x03ba:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x03ad;
    L_0x03c8:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = "gzip";
        r3 = r13.getContentEncoding();	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        if (r2 == 0) goto L_0x0468;
    L_0x03da:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r3 = r13.getInputStream();	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r16 = r2;
    L_0x03e5:
        r2 = 0;
        if (r16 == 0) goto L_0x0a66;
    L_0x03e8:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r3 = 24;
        if (r2 < r3) goto L_0x04bc;
    L_0x03ee:
        r2 = r13.getContentLengthLong();	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
    L_0x03f2:
        r6 = "MicroMsg.AppBrandNetworkRequest";
        r7 = "hy: total length is: %d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r9 = 0;
        r11 = java.lang.Long.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r8[r9] = r11;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r6 = 1;
        r2 = com.tencent.mm.plugin.appbrand.k.i.g(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r3 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r8 = r12;
    L_0x040d:
        r0 = r16;
        r6 = r0.read(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = -1;
        if (r6 == r2) goto L_0x051f;
    L_0x0416:
        r0 = r19;
        r2 = r0.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = com.tencent.mm.plugin.appbrand.a.pY(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        if (r2 != 0) goto L_0x04c3;
    L_0x0420:
        r2 = 1;
    L_0x0421:
        if (r2 == 0) goto L_0x0518;
    L_0x0423:
        r2 = "interrupted";
        r0 = r17;
        r0.tR(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r8;
        r11 = 2;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x0456;
    L_0x0453:
        r16.close();	 Catch:{ IOException -> 0x04dc, ArrayIndexOutOfBoundsException -> 0x04eb, Throwable -> 0x04fa }
    L_0x0456:
        if (r15 == 0) goto L_0x045b;
    L_0x0458:
        r15.close();	 Catch:{ IOException -> 0x0509 }
    L_0x045b:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x0468:
        r16 = r13.getInputStream();	 Catch:{ Exception -> 0x046e, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        goto L_0x03e5;
    L_0x046e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r6 = "read input stream failed : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r8 = 0;
        r9 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = "gzip";
        r3 = r13.getContentEncoding();	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        if (r2 == 0) goto L_0x049c;
    L_0x048f:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r3 = r13.getErrorStream();	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        r16 = r2;
        goto L_0x03e5;
    L_0x049c:
        r16 = r13.getErrorStream();	 Catch:{ Exception -> 0x04a2, UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, all -> 0x0a06 }
        goto L_0x03e5;
    L_0x04a2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r6 = "read err stream failed : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r8 = 0;
        r9 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        goto L_0x03e5;
    L_0x04b8:
        r2 = move-exception;
        r14 = r10;
        goto L_0x01ad;
    L_0x04bc:
        r2 = r13.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x04b8, SSLHandshakeException -> 0x0a53, FileNotFoundException -> 0x0a45, SocketTimeoutException -> 0x0a37, SSLProtocolException -> 0x0a29, Exception -> 0x0a1b, all -> 0x0a06 }
        r2 = (long) r2;
        goto L_0x03f2;
    L_0x04c3:
        r7 = com.tencent.mm.plugin.appbrand.k.c.2.fjn;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r2.fcL;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r2.fjj;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r2.acv();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r2.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r7[r2];	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        switch(r2) {
            case 1: goto L_0x04d9;
            case 2: goto L_0x04d9;
            default: goto L_0x04d6;
        };
    L_0x04d6:
        r2 = 0;
        goto L_0x0421;
    L_0x04d9:
        r2 = 1;
        goto L_0x0421;
    L_0x04dc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0456;
    L_0x04eb:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0456;
    L_0x04fa:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0456;
    L_0x0509:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x045b;
    L_0x0518:
        r2 = 0;
        r5.write(r3, r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r8 = r8 + r6;
        goto L_0x040d;
    L_0x051f:
        r5.flush();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r16.close();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = "arraybuffer";
        r0 = r20;
        r3 = r0.gla;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = r2.equals(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        if (r2 == 0) goto L_0x059d;
    L_0x0532:
        r2 = r5.toByteArray();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = java.nio.ByteBuffer.wrap(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
    L_0x053a:
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r6 = "url %s : buffer size %d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r9 = 0;
        r0 = r20;
        r11 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r7[r9] = r11;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r9 = 1;
        r5 = r5.size();	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r7[r9] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        com.tencent.mm.sdk.platformtools.x.v(r3, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
    L_0x0558:
        r3 = "ok";
        r0 = r17;
        r0.a(r3, r2, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r8;
        r11 = 1;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x058b;
    L_0x0588:
        r16.close();	 Catch:{ IOException -> 0x05a9, ArrayIndexOutOfBoundsException -> 0x05b7, Throwable -> 0x05c5 }
    L_0x058b:
        if (r15 == 0) goto L_0x0590;
    L_0x058d:
        r15.close();	 Catch:{ IOException -> 0x05d3 }
    L_0x0590:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x059d:
        r2 = "UTF-8";
        r2 = r5.toString(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        r2 = com.tencent.mm.plugin.appbrand.r.c.vT(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a61, SSLHandshakeException -> 0x0a57, FileNotFoundException -> 0x0a49, SocketTimeoutException -> 0x0a3b, SSLProtocolException -> 0x0a2d, Exception -> 0x0a1f, all -> 0x0a0a }
        goto L_0x053a;
    L_0x05a9:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x058b;
    L_0x05b7:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x058b;
    L_0x05c5:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x058b;
    L_0x05d3:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0590;
    L_0x05e1:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0207;
    L_0x05f0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0207;
    L_0x05ff:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0207;
    L_0x060e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x020c;
    L_0x061d:
        r2 = move-exception;
        r14 = r11;
    L_0x061f:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "SSLHandshakeException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0a10 }
        r4 = "ssl hand shake error:";
        r3.<init>(r4);	 Catch:{ all -> 0x0a10 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0a10 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0a10 }
        r2 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x068a;
    L_0x0687:
        r16.close();	 Catch:{ IOException -> 0x069c, ArrayIndexOutOfBoundsException -> 0x06aa, Throwable -> 0x06b8 }
    L_0x068a:
        if (r15 == 0) goto L_0x068f;
    L_0x068c:
        r15.close();	 Catch:{ IOException -> 0x06c6 }
    L_0x068f:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x069c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x068a;
    L_0x06aa:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x068a;
    L_0x06b8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x068a;
    L_0x06c6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x068f;
    L_0x06d4:
        r2 = move-exception;
        r14 = r11;
    L_0x06d6:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "FileNotFoundException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r2 = "file not exist error";
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x0730;
    L_0x072d:
        r16.close();	 Catch:{ IOException -> 0x0742, ArrayIndexOutOfBoundsException -> 0x0750, Throwable -> 0x075e }
    L_0x0730:
        if (r15 == 0) goto L_0x0735;
    L_0x0732:
        r15.close();	 Catch:{ IOException -> 0x076c }
    L_0x0735:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x0742:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0730;
    L_0x0750:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0730;
    L_0x075e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0730;
    L_0x076c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0735;
    L_0x077a:
        r2 = move-exception;
        r14 = r11;
    L_0x077c:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s, failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0a10 }
        r3.<init>();	 Catch:{ all -> 0x0a10 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0a10 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0a10 }
        r2 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x07e4;
    L_0x07e1:
        r16.close();	 Catch:{ IOException -> 0x07f6, ArrayIndexOutOfBoundsException -> 0x0804, Throwable -> 0x0812 }
    L_0x07e4:
        if (r15 == 0) goto L_0x07e9;
    L_0x07e6:
        r15.close();	 Catch:{ IOException -> 0x0820 }
    L_0x07e9:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x07f6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e4;
    L_0x0804:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e4;
    L_0x0812:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e4;
    L_0x0820:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e9;
    L_0x082e:
        r2 = move-exception;
        r14 = r11;
    L_0x0830:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 6;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "SSLProtocolException: %s ,url is %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r2 = "SSLProtocolException";
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x088a;
    L_0x0887:
        r16.close();	 Catch:{ IOException -> 0x089c, ArrayIndexOutOfBoundsException -> 0x08aa, Throwable -> 0x08b8 }
    L_0x088a:
        if (r15 == 0) goto L_0x088f;
    L_0x088c:
        r15.close();	 Catch:{ IOException -> 0x08c6 }
    L_0x088f:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x089c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x088a;
    L_0x08aa:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x088a;
    L_0x08b8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x088a;
    L_0x08c6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x088f;
    L_0x08d4:
        r2 = move-exception;
        r14 = r11;
    L_0x08d6:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0a10 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a10 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s,failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a10 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a10 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0a10 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0a10 }
        r3.<init>();	 Catch:{ all -> 0x0a10 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0a10 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0a10 }
        r2 = r2.toString();	 Catch:{ all -> 0x0a10 }
        r0 = r17;
        r0.tR(r2);	 Catch:{ all -> 0x0a10 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        r10 = r14;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x093e;
    L_0x093b:
        r16.close();	 Catch:{ IOException -> 0x0950, ArrayIndexOutOfBoundsException -> 0x095e, Throwable -> 0x096c }
    L_0x093e:
        if (r15 == 0) goto L_0x0943;
    L_0x0940:
        r15.close();	 Catch:{ IOException -> 0x097a }
    L_0x0943:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        goto L_0x005c;
    L_0x0950:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x093e;
    L_0x095e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x093e;
    L_0x096c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x093e;
    L_0x097a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0943;
    L_0x0988:
        r2 = move-exception;
        r17 = r2;
        r10 = r11;
    L_0x098c:
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.glc;
        r0 = r20;
        r4 = r0.gkV;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.fEl;
        r0 = r19;
        r0.a(r2, r13);
        if (r16 == 0) goto L_0x09b7;
    L_0x09b4:
        r16.close();	 Catch:{ IOException -> 0x09c8, ArrayIndexOutOfBoundsException -> 0x09d6, Throwable -> 0x09e4 }
    L_0x09b7:
        if (r15 == 0) goto L_0x09bc;
    L_0x09b9:
        r15.close();	 Catch:{ IOException -> 0x09f2 }
    L_0x09bc:
        r0 = r19;
        r2 = r0.gkF;
        r0 = r20;
        r3 = r0.fEl;
        r2.remove(r3);
        throw r17;
    L_0x09c8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09b7;
    L_0x09d6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09b7;
    L_0x09e4:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09b7;
    L_0x09f2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09bc;
    L_0x0a00:
        r2 = move-exception;
        r17 = r2;
        r10 = r11;
        r15 = r3;
        goto L_0x098c;
    L_0x0a06:
        r2 = move-exception;
        r17 = r2;
        goto L_0x098c;
    L_0x0a0a:
        r2 = move-exception;
        r17 = r2;
        r12 = r8;
        goto L_0x098c;
    L_0x0a10:
        r2 = move-exception;
        r17 = r2;
        r10 = r14;
        goto L_0x098c;
    L_0x0a16:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x08d6;
    L_0x0a1b:
        r2 = move-exception;
        r14 = r10;
        goto L_0x08d6;
    L_0x0a1f:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x08d6;
    L_0x0a24:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x0830;
    L_0x0a29:
        r2 = move-exception;
        r14 = r10;
        goto L_0x0830;
    L_0x0a2d:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x0830;
    L_0x0a32:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x077c;
    L_0x0a37:
        r2 = move-exception;
        r14 = r10;
        goto L_0x077c;
    L_0x0a3b:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x077c;
    L_0x0a40:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x06d6;
    L_0x0a45:
        r2 = move-exception;
        r14 = r10;
        goto L_0x06d6;
    L_0x0a49:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x06d6;
    L_0x0a4e:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x061f;
    L_0x0a53:
        r2 = move-exception;
        r14 = r10;
        goto L_0x061f;
    L_0x0a57:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x061f;
    L_0x0a5c:
        r2 = move-exception;
        r14 = r11;
        r15 = r3;
        goto L_0x01ad;
    L_0x0a61:
        r2 = move-exception;
        r14 = r10;
        r12 = r8;
        goto L_0x01ad;
    L_0x0a66:
        r8 = r12;
        goto L_0x0558;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.k.c.a(com.tencent.mm.plugin.appbrand.k.d):void");
    }

    public final void b(d dVar) {
        x.d("MicroMsg.AppBrandNetworkRequest", "try to abortTask");
        this.gkF.add(dVar.fEl);
        a(dVar.fEl, dVar.glb);
    }

    public final boolean uG(String str) {
        return this.gkF.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        uE(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    static boolean uJ(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE");
    }

    public final void a(l lVar, e eVar, int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str, String str2) {
        final l lVar2 = lVar;
        final JSONObject jSONObject2 = jSONObject;
        final e eVar2 = eVar;
        final a aVar2 = aVar;
        final int i2 = i;
        final Map<String, String> map2 = map;
        final ArrayList<String> arrayList2 = arrayList;
        final String str3 = str2;
        final String str4 = str;
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                if (m.a(lVar2, jSONObject2, eVar2)) {
                    String optString = jSONObject2.optString("url");
                    Object opt = jSONObject2.opt("data");
                    String optString2 = jSONObject2.optString("method");
                    if (bi.oW(optString2)) {
                        optString2 = "GET";
                    }
                    if (TextUtils.isEmpty(optString)) {
                        aVar2.tR("url is null");
                        return;
                    } else if (URLUtil.isHttpsUrl(optString) || URLUtil.isHttpUrl(optString)) {
                        byte[] bArr = new byte[0];
                        if (opt != null && c.uJ(optString2)) {
                            if (opt instanceof String) {
                                bArr = ((String) opt).getBytes(Charset.forName("UTF-8"));
                            } else if (opt instanceof ByteBuffer) {
                                bArr = com.tencent.mm.plugin.appbrand.q.c.k((ByteBuffer) opt);
                            }
                        }
                        synchronized (c.this.gkL) {
                            if (c.this.gkL.size() >= c.this.gkB) {
                                aVar2.tR("max connected");
                                x.i("MicroMsg.AppBrandNetworkRequest", "max connected");
                                return;
                            }
                            x.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", new Object[]{optString2, optString, Integer.valueOf(i2)});
                            d dVar = new d(optString, bArr, i2, aVar2, optString2);
                            dVar.gkX = map2;
                            dVar.gkY = arrayList2;
                            dVar.glc = str3;
                            dVar.gla = jSONObject2.optString("responseType", "text");
                            synchronized (c.this.gkL) {
                                c.this.gkL.add(dVar);
                            }
                            dVar.fEl = str4;
                            c.this.a(dVar);
                            return;
                        }
                    } else {
                        aVar2.tR("request protocol must be http or https");
                        return;
                    }
                }
                aVar2.tR(eVar2.fEX);
            }
        }, "appbrand_request_thread");
    }

    private synchronized void uE(String str) {
        if (str != null) {
            synchronized (this.gkL) {
                Iterator it = this.gkL.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (str.equals(dVar.fEl)) {
                        this.gkL.remove(dVar);
                        break;
                    }
                }
            }
        }
    }

    public final d uK(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.gkL) {
            Iterator it = this.gkL.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (str.equals(dVar.fEl)) {
                    return dVar;
                }
            }
            return null;
        }
    }
}

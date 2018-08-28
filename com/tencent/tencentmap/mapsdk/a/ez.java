package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public final class ez implements eu {
    private DefaultHttpClient a = null;

    private static ew a(boolean z, String str, byte[] bArr) {
        try {
            URL url = new URL(fz.c(str));
            fb fbVar = new fb(url.getHost(), new int[]{url.getPort()});
            fbVar.a(z);
            if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("https://")) {
                fbVar.b(true);
            }
            fbVar.a(url.getFile());
            fbVar.a(bArr);
            fbVar.b(str);
            return fbVar;
        } catch (MalformedURLException e) {
            throw new ff("url format error:" + str);
        }
    }

    private DefaultHttpClient a(fb fbVar) {
        int i;
        if (this.a == null) {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpClientParams.setRedirecting(basicHttpParams, false);
            this.a = new DefaultHttpClient(basicHttpParams);
            SchemeRegistry schemeRegistry;
            if (fbVar.p()) {
                try {
                    KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                    instance.load(null, null);
                    fy fyVar = new fy(instance, fbVar.n());
                    fyVar.setHostnameVerifier(new AllowAllHostnameVerifier());
                    schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme("https", fyVar, 443));
                    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                    this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                } catch (Exception e) {
                    this.a = null;
                }
            } else {
                schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", PlainSocketFactory.getSocketFactory(), 80));
                this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            }
        }
        fw.a(this.a);
        HttpClient httpClient = this.a;
        int i2 = 20;
        if (fw.f()) {
            i2 = 15;
            i = 15;
        } else if (fw.h()) {
            i2 = 15;
            i = 15;
        } else if (fw.g()) {
            i2 = 10;
            i = 15;
        } else {
            i = 10;
        }
        httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(i * 1000));
        httpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(i2 * 1000));
        this.a.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        try {
            this.a.setKeepAliveStrategy(new fa());
        } catch (Throwable th) {
        }
        return this.a;
    }

    private static boolean a(long j) {
        return fw.f() ? System.currentTimeMillis() - j > 6000 : fw.h() ? System.currentTimeMillis() - j > 10000 : System.currentTimeMillis() - j > 10000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.tencentmap.mapsdk.a.fc b(com.tencent.tencentmap.mapsdk.a.fb r33) {
        /*
        r32 = this;
        r9 = new com.tencent.tencentmap.mapsdk.a.fc;
        r9.<init>();
        r19 = new com.tencent.tencentmap.mapsdk.a.ey;
        r0 = r19;
        r1 = r33;
        r0.<init>(r1);
        r0 = r19;
        r0 = r0.c;
        r20 = r0;
        r0 = r19;
        r0 = r0.b;
        r21 = r0;
        r4 = r20.size();
        r22 = r4 + -1;
        r23 = r20.size();
        r10 = 0;
        r7 = 0;
        r6 = "";
        r8 = 0;
        r5 = "";
        r4 = 0;
        r12 = java.lang.System.currentTimeMillis();
        r14 = r33.q();
        r12 = r12 - r14;
        r0 = (int) r12;
        r24 = r0;
        r11 = r4;
        r12 = r5;
        r13 = r7;
        r14 = r9;
    L_0x003e:
        r4 = r33.j();
        if (r10 > r4) goto L_0x0f42;
    L_0x0044:
        if (r11 != 0) goto L_0x0f42;
    L_0x0046:
        r26 = java.lang.System.currentTimeMillis();
        r4 = r33.l();
        if (r4 == 0) goto L_0x0063;
    L_0x0050:
        r4 = "HttpAccessClientImpl";
        r5 = "request is cancel.";
        com.tencent.tencentmap.mapsdk.a.fx.c(r4, r5);
        r14 = new com.tencent.tencentmap.mapsdk.a.fc;
        r14.<init>();
        r4 = -20;
        r14.a = r4;
    L_0x0062:
        return r14;
    L_0x0063:
        r14 = new com.tencent.tencentmap.mapsdk.a.fc;
        r14.<init>();
        r14.i = r10;
        r25 = new com.tencent.tencentmap.mapsdk.a.fd;
        r25.<init>();
        r0 = r21;
        r1 = r25;
        r1.y = r0;
        r0 = r24;
        r1 = r25;
        r1.i = r0;
        r0 = r19;
        r4 = r0.a;
        r0 = r25;
        r0.b = r4;
        r17 = 0;
        r7 = 0;
        r4 = r33.j();
        if (r10 != r4) goto L_0x008d;
    L_0x008c:
        r7 = 1;
    L_0x008d:
        r5 = 2;
        r4 = r10 % r23;
        r0 = r22;
        if (r4 >= r0) goto L_0x00b1;
    L_0x0094:
        r9 = 1;
        r0 = r25;
        r0.x = r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "Host";
        r15 = r33.n();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r33;
        r0.a(r9, r15);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "x-tx-host";
        r15 = r33.n();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r33;
        r0.a(r9, r15);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
    L_0x00b1:
        r0 = r20;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = (com.tencent.tencentmap.mapsdk.a.ep) r4;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r25;
        r0.a = r4;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r33.c();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r25;
        r0.c = r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r33.p();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r25;
        r0.D = r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r33.j();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = r25;
        r0.u = r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r28 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r30 = r33.q();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r28 = r28 - r30;
        r9 = r33.o();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r0 = (long) r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r30 = r0;
        r9 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1));
        if (r9 > 0) goto L_0x00ed;
    L_0x00ea:
        r9 = 1;
        if (r10 <= r9) goto L_0x0101;
    L_0x00ed:
        r4 = r20.size();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4 + -1;
        r0 = r20;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = (com.tencent.tencentmap.mapsdk.a.ep) r4;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r11 = 1;
        r9 = 1;
        r0 = r25;
        r0.A = r9;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
    L_0x0101:
        r16 = r4;
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        if (r4 == 0) goto L_0x0395;
    L_0x0109:
        r4 = r33.p();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        if (r4 != 0) goto L_0x0341;
    L_0x010f:
        r4 = r16.b();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = -1;
        if (r4 == r9) goto L_0x032b;
    L_0x0116:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "http://";
        r4.<init>(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r16.a();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = ":";
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r16.b();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
    L_0x0139:
        r9 = r33.e();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r15 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        if (r15 != 0) goto L_0x015d;
    L_0x0143:
        r15 = "/";
        r15 = r9.startsWith(r15);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        if (r15 == 0) goto L_0x037b;
    L_0x014c:
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r15.<init>();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r15.append(r4);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
    L_0x015d:
        r0 = r25;
        r0.d = r4;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r15 = r4;
        r9 = r6;
    L_0x0163:
        r18 = 3;
        r4 = "HttpAccessClientImpl";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6 = "retry:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.append(r10);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6 = ",url:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.append(r15);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6 = ",isJump:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6 = ",accessIP:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r16;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        com.tencent.tencentmap.mapsdk.a.fx.a(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4 = r33.b();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x039d;
    L_0x01a4:
        r6 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.<init>(r15);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x01a9:
        r4 = "User-Agent";
        r5 = "HalleyAccess";
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r16 = r33.g();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r16 == 0) goto L_0x04ac;
    L_0x01b8:
        r4 = r16.size();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 <= 0) goto L_0x04ac;
    L_0x01be:
        if (r8 != 0) goto L_0x04ac;
    L_0x01c0:
        r4 = r16.keySet();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = r4.iterator();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x01c8:
        r4 = r28.hasNext();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x049b;
    L_0x01ce:
        r4 = r28.next();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r16;
        r5 = r0.get(r4);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        goto L_0x01c8;
    L_0x01e0:
        r4 = move-exception;
        r15 = r4;
        r16 = r7;
        r6 = r9;
    L_0x01e5:
        r4 = "HttpAccessClientImpl";
        r5 = "exception...";
        com.tencent.tencentmap.mapsdk.a.fx.a(r4, r5, r15);	 Catch:{ all -> 0x0f6d }
        r4 = r15.getClass();	 Catch:{ all -> 0x0f6d }
        r4 = r4.getSimpleName();	 Catch:{ all -> 0x0f6d }
        r0 = r25;
        r0.q = r4;	 Catch:{ all -> 0x0f6d }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0f6d }
        r4.<init>();	 Catch:{ all -> 0x0f6d }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0f6d }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0f6d }
        r5 = com.tencent.tencentmap.mapsdk.a.fz.a(r15);	 Catch:{ all -> 0x0f6d }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0f6d }
        r4 = r4.toString();	 Catch:{ all -> 0x0f6d }
        r0 = r25;
        r0.r = r4;	 Catch:{ all -> 0x0f6d }
        r14.b = r15;	 Catch:{ all -> 0x0f6d }
        r4 = com.tencent.tencentmap.mapsdk.a.fw.e();	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0f0b;
    L_0x0224:
        r4 = r15 instanceof org.apache.http.conn.ConnectTimeoutException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ec8;
    L_0x0228:
        r4 = -10;
    L_0x022a:
        r14.a = r4;	 Catch:{ all -> 0x0f6d }
        r0 = r25;
        r4 = r0.r;	 Catch:{ all -> 0x0f6d }
        r5 = "Permission";
        r4 = r4.contains(r5);	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x023d;
    L_0x0239:
        r4 = -18;
        r14.a = r4;	 Catch:{ all -> 0x0f6d }
    L_0x023d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r6);
        if (r4 == 0) goto L_0x0f0e;
    L_0x0267:
        r10 = r10 + 1;
        r7 = 0;
    L_0x026a:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x030c;
    L_0x0274:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x030c;
    L_0x027a:
        r4 = java.lang.System.currentTimeMillis();
        r28 = r33.q();
        r4 = r4 - r28;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r6;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0f1b;
    L_0x02ac:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0f1b;
    L_0x02b2:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x02bc:
        r0 = r16;
        r1 = r25;
        r1.z = r0;
        if (r16 == 0) goto L_0x02cf;
    L_0x02c4:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x02cf;
    L_0x02ca:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x02cf:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0f80 }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0f80 }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0f80 }
        r4.a(r5);	 Catch:{ Throwable -> 0x0f80 }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0f80 }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0f80 }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0f80 }
        r14.l = r4;	 Catch:{ Throwable -> 0x0f80 }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0f80 }
        r14.d = r4;	 Catch:{ Throwable -> 0x0f80 }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0f80 }
        r14.m = r4;	 Catch:{ Throwable -> 0x0f80 }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0f80 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0f80 }
    L_0x030c:
        if (r17 == 0) goto L_0x0317;
    L_0x030e:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0317;
    L_0x0314:
        r33.f();
    L_0x0317:
        r4 = a(r26);
        r5 = r14.a;
        r9 = -4;
        if (r5 == r9) goto L_0x0062;
    L_0x0320:
        r5 = r14.a;
        r9 = -17;
        if (r5 == r9) goto L_0x0062;
    L_0x0326:
        if (r4 != 0) goto L_0x0062;
    L_0x0328:
        r13 = r7;
        goto L_0x003e;
    L_0x032b:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "http://";
        r4.<init>(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r16.a();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        goto L_0x0139;
    L_0x0341:
        r4 = r16.b();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = -1;
        if (r4 == r9) goto L_0x0365;
    L_0x0348:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "https://";
        r4.<init>(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r16.a();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = ":443";
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        goto L_0x0139;
    L_0x0365:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = "https://";
        r4.<init>(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = r16.a();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        goto L_0x0139;
    L_0x037b:
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r15.<init>();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r15.append(r4);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r15 = "/";
        r4 = r4.append(r15);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        goto L_0x015d;
    L_0x0395:
        r0 = r25;
        r0.f = r6;	 Catch:{ Exception -> 0x0f93, Throwable -> 0x0f7c, all -> 0x0f63 }
        r9 = 0;
        r15 = r6;
        goto L_0x0163;
    L_0x039d:
        r6 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.<init>(r15);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        goto L_0x01a9;
    L_0x03a4:
        r4 = move-exception;
        r4 = r7;
        r6 = r9;
    L_0x03a7:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = r33.a();
        r5 = r5.append(r7);
        r7 = "-";
        r5 = r5.append(r7);
        r5 = r5.append(r10);
        r5 = r5.toString();
        r0 = r25;
        r0.p = r5;
        r0 = r25;
        r0.s = r10;
        r5 = android.text.TextUtils.isEmpty(r6);
        if (r5 == 0) goto L_0x0f23;
    L_0x03d1:
        r10 = r10 + 1;
        r7 = 0;
    L_0x03d4:
        r5 = com.tencent.tencentmap.mapsdk.a.em.b();
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x047c;
    L_0x03de:
        r5 = r14.a;
        r9 = -21;
        if (r5 == r9) goto L_0x047c;
    L_0x03e4:
        r28 = java.lang.System.currentTimeMillis();
        r30 = r33.q();
        r28 = r28 - r30;
        r0 = r28;
        r5 = (int) r0;
        r14.k = r5;
        r5 = r14.a;
        r0 = r25;
        r0.k = r5;
        r0 = r25;
        r0.C = r12;
        r5 = r14.k;
        r0 = r25;
        r0.l = r5;
        r28 = java.lang.System.currentTimeMillis();
        r28 = r28 - r26;
        r0 = r28;
        r5 = (int) r0;
        r0 = r25;
        r0.m = r5;
        r0 = r25;
        r0.f = r6;
        r5 = r33.b();
        if (r5 != 0) goto L_0x0f30;
    L_0x041a:
        r5 = r33.h();
        if (r5 == 0) goto L_0x0f30;
    L_0x0420:
        r5 = r33.h();
        r5 = r5.length;
        r0 = (long) r5;
        r28 = r0;
        r0 = r28;
        r2 = r25;
        r2.n = r0;
    L_0x042e:
        r0 = r25;
        r0.z = r4;
        if (r4 == 0) goto L_0x043f;
    L_0x0434:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x043f;
    L_0x043a:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x043f:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0f74 }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0f74 }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0f74 }
        r4.a(r5);	 Catch:{ Throwable -> 0x0f74 }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0f74 }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0f74 }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0f74 }
        r14.l = r4;	 Catch:{ Throwable -> 0x0f74 }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0f74 }
        r14.d = r4;	 Catch:{ Throwable -> 0x0f74 }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0f74 }
        r14.m = r4;	 Catch:{ Throwable -> 0x0f74 }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0f74 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0f74 }
    L_0x047c:
        if (r17 == 0) goto L_0x0487;
    L_0x047e:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0487;
    L_0x0484:
        r33.f();
    L_0x0487:
        r4 = a(r26);
        r5 = r14.a;
        r9 = -4;
        if (r5 == r9) goto L_0x0062;
    L_0x0490:
        r5 = r14.a;
        r9 = -17;
        if (r5 == r9) goto L_0x0062;
    L_0x0496:
        if (r4 != 0) goto L_0x0062;
    L_0x0498:
        r13 = r7;
        goto L_0x003e;
    L_0x049b:
        r4 = com.tencent.tencentmap.mapsdk.a.fw.c;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x04ac;
    L_0x049f:
        r4 = 2;
        if (r10 != r4) goto L_0x04ac;
    L_0x04a2:
        r4 = "X-Online-Host";
        r5 = r33.n();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x04ac:
        r4 = "Halley-sdk";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = "sdk:";
        r0 = r28;
        r5.<init>(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = com.tencent.tencentmap.mapsdk.a.em.f();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r28;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = " key:";
        r0 = r28;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = r33.a();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r28;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = "-";
        r0 = r28;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.append(r10);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r8 == 0) goto L_0x060e;
    L_0x04ec:
        r4 = r16.keySet();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r28 = r4.iterator();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x04f4:
        r4 = r28.hasNext();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x05fd;
    L_0x04fa:
        r4 = r28.next();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r16;
        r5 = r0.get(r4);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        goto L_0x04f4;
    L_0x050c:
        r4 = move-exception;
        r5 = r4;
    L_0x050e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r33.a();
        r4 = r4.append(r6);
        r6 = "-";
        r4 = r4.append(r6);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r9);
        if (r4 != 0) goto L_0x0540;
    L_0x0538:
        r4 = r13 + 1;
        r6 = 6;
        if (r4 <= r6) goto L_0x0540;
    L_0x053d:
        r4 = -5;
        r14.a = r4;
    L_0x0540:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x05e0;
    L_0x054a:
        r4 = r14.a;
        r6 = -21;
        if (r4 == r6) goto L_0x05e0;
    L_0x0550:
        r10 = java.lang.System.currentTimeMillis();
        r18 = r33.q();
        r10 = r10 - r18;
        r4 = (int) r10;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r10 = java.lang.System.currentTimeMillis();
        r10 = r10 - r26;
        r4 = (int) r10;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r9;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0f3a;
    L_0x0582:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0f3a;
    L_0x0588:
        r4 = r33.h();
        r4 = r4.length;
        r8 = (long) r4;
        r0 = r25;
        r0.n = r8;
    L_0x0592:
        r0 = r25;
        r0.z = r7;
        if (r7 == 0) goto L_0x05a3;
    L_0x0598:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x05a3;
    L_0x059e:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x05a3:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0f5c }
        r6 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0f5c }
        r0 = r25;
        r6.<init>(r0);	 Catch:{ Throwable -> 0x0f5c }
        r4.a(r6);	 Catch:{ Throwable -> 0x0f5c }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0f5c }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0f5c }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0f5c }
        r14.l = r4;	 Catch:{ Throwable -> 0x0f5c }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0f5c }
        r14.d = r4;	 Catch:{ Throwable -> 0x0f5c }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0f5c }
        r14.m = r4;	 Catch:{ Throwable -> 0x0f5c }
        r4 = "statInfo";
        r6 = r25.toString();	 Catch:{ Throwable -> 0x0f5c }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r6);	 Catch:{ Throwable -> 0x0f5c }
    L_0x05e0:
        if (r17 == 0) goto L_0x05eb;
    L_0x05e2:
        r4 = r33.l();
        if (r4 != 0) goto L_0x05eb;
    L_0x05e8:
        r33.f();
    L_0x05eb:
        r4 = a(r26);
        r6 = r14.a;
        r7 = -4;
        if (r6 == r7) goto L_0x0062;
    L_0x05f4:
        r6 = r14.a;
        r7 = -17;
        if (r6 == r7) goto L_0x0062;
    L_0x05fa:
        if (r4 != 0) goto L_0x0062;
    L_0x05fc:
        throw r5;
    L_0x05fd:
        r4 = com.tencent.tencentmap.mapsdk.a.fw.c;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x060e;
    L_0x0601:
        r4 = 2;
        if (r10 != r4) goto L_0x060e;
    L_0x0604:
        r4 = "X-Online-Host";
        r5 = com.tencent.tencentmap.mapsdk.a.fz.d(r15);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6.setHeader(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x060e:
        r4 = r33.b();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 != 0) goto L_0x0629;
    L_0x0614:
        r5 = r33.h();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r5 == 0) goto L_0x0629;
    L_0x061a:
        r4 = r5.length;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 <= 0) goto L_0x0629;
    L_0x061d:
        r0 = r6;
        r0 = (org.apache.http.client.methods.HttpPost) r0;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4 = r0;
        r15 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r15.<init>(r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4.setEntity(r15);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x0629:
        r5 = 4;
        r17 = r32.a(r33);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r5 = 5;
        r28 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r28 = r28 - r26;
        r0 = r28;
        r4 = (int) r0;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r25;
        r0.g = r4;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r28 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r17;
        r4 = r0.execute(r6);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r30 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r28 = r30 - r28;
        r0 = r28;
        r6 = (int) r0;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r14.g = r6;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r5 = 6;
        r6 = "HttpAccessClientImpl";
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r16 = "connectTime:";
        r15.<init>(r16);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r14.g;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r16 = r0;
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        com.tencent.tencentmap.mapsdk.a.fx.a(r6, r15);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r6 = r4.getStatusLine();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r6 = r6.getStatusCode();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r14.j = r4;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x068c;
    L_0x0678:
        r15 = "Content-Type";
        r15 = r4.getFirstHeader(r15);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        if (r15 == 0) goto L_0x068c;
    L_0x0681:
        r15 = "Content-Type";
        r15 = r4.getFirstHeader(r15);	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r12 = r15.getValue();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
    L_0x068c:
        r15 = r14.g;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r0 = r25;
        r0.h = r15;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r5 = 7;
        switch(r6) {
            case 200: goto L_0x0792;
            case 204: goto L_0x0ea9;
            case 301: goto L_0x0c65;
            case 302: goto L_0x0c65;
            case 303: goto L_0x0c65;
            case 307: goto L_0x0c65;
            case 408: goto L_0x0ea9;
            case 502: goto L_0x0ea9;
            case 503: goto L_0x0ea9;
            case 504: goto L_0x0ea9;
            default: goto L_0x0696;
        };	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
    L_0x0696:
        r14.a = r6;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r4 = r7;
        r5 = r8;
        r6 = r9;
    L_0x069b:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r33.a();
        r7 = r7.append(r8);
        r8 = "-";
        r7 = r7.append(r8);
        r7 = r7.append(r10);
        r7 = r7.toString();
        r0 = r25;
        r0.p = r7;
        r0 = r25;
        r0.s = r10;
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 == 0) goto L_0x0eb0;
    L_0x06c5:
        r8 = r10 + 1;
        r7 = 0;
        r9 = r8;
    L_0x06c9:
        r8 = com.tencent.tencentmap.mapsdk.a.em.b();
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 != 0) goto L_0x0771;
    L_0x06d3:
        r8 = r14.a;
        r10 = -21;
        if (r8 == r10) goto L_0x0771;
    L_0x06d9:
        r28 = java.lang.System.currentTimeMillis();
        r30 = r33.q();
        r28 = r28 - r30;
        r0 = r28;
        r8 = (int) r0;
        r14.k = r8;
        r8 = r14.a;
        r0 = r25;
        r0.k = r8;
        r0 = r25;
        r0.C = r12;
        r8 = r14.k;
        r0 = r25;
        r0.l = r8;
        r28 = java.lang.System.currentTimeMillis();
        r28 = r28 - r26;
        r0 = r28;
        r8 = (int) r0;
        r0 = r25;
        r0.m = r8;
        r0 = r25;
        r0.f = r6;
        r8 = r33.b();
        if (r8 != 0) goto L_0x0ebe;
    L_0x070f:
        r8 = r33.h();
        if (r8 == 0) goto L_0x0ebe;
    L_0x0715:
        r8 = r33.h();
        r8 = r8.length;
        r0 = (long) r8;
        r28 = r0;
        r0 = r28;
        r2 = r25;
        r2.n = r0;
    L_0x0723:
        r0 = r25;
        r0.z = r4;
        if (r4 == 0) goto L_0x0734;
    L_0x0729:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x0734;
    L_0x072f:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x0734:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0f9b }
        r8 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0f9b }
        r0 = r25;
        r8.<init>(r0);	 Catch:{ Throwable -> 0x0f9b }
        r4.a(r8);	 Catch:{ Throwable -> 0x0f9b }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0f9b }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0f9b }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0f9b }
        r14.l = r4;	 Catch:{ Throwable -> 0x0f9b }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0f9b }
        r14.d = r4;	 Catch:{ Throwable -> 0x0f9b }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0f9b }
        r14.m = r4;	 Catch:{ Throwable -> 0x0f9b }
        r4 = "statInfo";
        r8 = r25.toString();	 Catch:{ Throwable -> 0x0f9b }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r8);	 Catch:{ Throwable -> 0x0f9b }
    L_0x0771:
        if (r17 == 0) goto L_0x077c;
    L_0x0773:
        r4 = r33.l();
        if (r4 != 0) goto L_0x077c;
    L_0x0779:
        r33.f();
    L_0x077c:
        r4 = a(r26);
        r8 = r14.a;
        r10 = -4;
        if (r8 == r10) goto L_0x0062;
    L_0x0785:
        r8 = r14.a;
        r10 = -17;
        if (r8 == r10) goto L_0x0062;
    L_0x078b:
        if (r4 != 0) goto L_0x0062;
    L_0x078d:
        r8 = r5;
        r13 = r7;
        r10 = r9;
        goto L_0x003e;
    L_0x0792:
        r4 = r4.getEntity();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r6 = r4.getContent();	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r4 = 1;
        r7 = 8;
        r5 = r33.f();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        if (r5 == 0) goto L_0x0b4f;
    L_0x07a3:
        r5 = 0;
        r15 = r33.i();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = new byte[r15];	 Catch:{ OutOfMemoryError -> 0x07c7 }
        r16 = r0;
        r28 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
    L_0x07b0:
        if (r5 >= r15) goto L_0x08e0;
    L_0x07b2:
        r18 = r15 - r5;
        r0 = r16;
        r1 = r18;
        r18 = r6.read(r0, r5, r1);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r30 = -1;
        r0 = r18;
        r1 = r30;
        if (r0 == r1) goto L_0x08e0;
    L_0x07c4:
        r5 = r5 + r18;
        goto L_0x07b0;
    L_0x07c7:
        r5 = move-exception;
        r6.close();	 Catch:{ Exception -> 0x0f53, Throwable -> 0x0b5f, all -> 0x0f5f }
    L_0x07cb:
        r5 = -8;
        r14.a = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r6 = "OutOfMemory buffSize:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r5.append(r15);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = r25;
        r0.r = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = (long) r15;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r28 = r0;
        r0 = r28;
        r2 = r25;
        r2.o = r0;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r9);
        if (r4 != 0) goto L_0x081d;
    L_0x0815:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x081d;
    L_0x081a:
        r4 = -5;
        r14.a = r4;
    L_0x081d:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x08bb;
    L_0x0827:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x08bb;
    L_0x082d:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r33.q();
        r4 = r4 - r6;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r9;
        r4 = r33.b();
        if (r4 != 0) goto L_0x08d9;
    L_0x085e:
        r4 = r33.h();
        if (r4 == 0) goto L_0x08d9;
    L_0x0864:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x086e:
        r4 = 1;
        r0 = r25;
        r0.z = r4;
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x087e;
    L_0x0879:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x087e:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0fad }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0fad }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0fad }
        r4.a(r5);	 Catch:{ Throwable -> 0x0fad }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0fad }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0fad }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0fad }
        r14.l = r4;	 Catch:{ Throwable -> 0x0fad }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0fad }
        r14.d = r4;	 Catch:{ Throwable -> 0x0fad }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0fad }
        r14.m = r4;	 Catch:{ Throwable -> 0x0fad }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0fad }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0fad }
    L_0x08bb:
        if (r17 == 0) goto L_0x08c6;
    L_0x08bd:
        r4 = r33.l();
        if (r4 != 0) goto L_0x08c6;
    L_0x08c3:
        r33.f();
    L_0x08c6:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x08cf:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x08d5:
        if (r4 == 0) goto L_0x0062;
    L_0x08d7:
        goto L_0x0062;
    L_0x08d9:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x086e;
    L_0x08e0:
        r7 = 9;
        r30 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r28 = r30 - r28;
        r0 = r28;
        r0 = (int) r0;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r18 = r0;
        r0 = r18;
        r14.h = r0;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = r14.h;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r18 = r0;
        r0 = r18;
        r1 = r25;
        r1.j = r0;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = (long) r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r28 = r0;
        r0 = r28;
        r2 = r25;
        r2.o = r0;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        if (r5 < r15) goto L_0x0a19;
    L_0x0906:
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r16 = "Response data too long,size:";
        r15.<init>(r16);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r15.append(r5);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = r25;
        r0.r = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = -1;
        r14.a = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
    L_0x091d:
        r6.close();	 Catch:{ Exception -> 0x0f59, Throwable -> 0x0b5f, all -> 0x0f5f }
    L_0x0920:
        r5 = r14.a;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        if (r5 != 0) goto L_0x0fb6;
    L_0x0924:
        r5 = r33.l();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        if (r5 == 0) goto L_0x0b6b;
    L_0x092a:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r9);
        if (r4 != 0) goto L_0x095c;
    L_0x0954:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x095c;
    L_0x0959:
        r4 = -5;
        r14.a = r4;
    L_0x095c:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x09fa;
    L_0x0966:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x09fa;
    L_0x096c:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r33.q();
        r4 = r4 - r6;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r9;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0b63;
    L_0x099d:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0b63;
    L_0x09a3:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x09ad:
        r4 = 1;
        r0 = r25;
        r0.z = r4;
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x09bd;
    L_0x09b8:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x09bd:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0fa7 }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0fa7 }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0fa7 }
        r4.a(r5);	 Catch:{ Throwable -> 0x0fa7 }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0fa7 }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0fa7 }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0fa7 }
        r14.l = r4;	 Catch:{ Throwable -> 0x0fa7 }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0fa7 }
        r14.d = r4;	 Catch:{ Throwable -> 0x0fa7 }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0fa7 }
        r14.m = r4;	 Catch:{ Throwable -> 0x0fa7 }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0fa7 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0fa7 }
    L_0x09fa:
        if (r17 == 0) goto L_0x0a05;
    L_0x09fc:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0a05;
    L_0x0a02:
        r33.f();
    L_0x0a05:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x0a0e:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x0a14:
        if (r4 != 0) goto L_0x0062;
    L_0x0a16:
        r14 = 0;
        goto L_0x0062;
    L_0x0a19:
        r0 = new byte[r5];	 Catch:{ OutOfMemoryError -> 0x0a3f }
        r18 = r0;
        r0 = r18;
        r14.e = r0;	 Catch:{ OutOfMemoryError -> 0x0a3f }
        r15 = 0;
        r0 = r14.e;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r18 = r0;
        r28 = 0;
        r0 = r16;
        r1 = r18;
        r2 = r28;
        java.lang.System.arraycopy(r0, r15, r1, r2, r5);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = 0;
        r14.a = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        goto L_0x091d;
    L_0x0a36:
        r5 = move-exception;
        r15 = r5;
        r16 = r4;
        r6 = r9;
        r18 = r7;
        goto L_0x01e5;
    L_0x0a3f:
        r5 = move-exception;
        r6.close();	 Catch:{ Exception -> 0x0f56, Throwable -> 0x0b5f, all -> 0x0f5f }
    L_0x0a43:
        r5 = -8;
        r14.a = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r6 = "OutOfMemory buffSize:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r5.append(r15);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r0 = r25;
        r0.r = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r9);
        if (r4 != 0) goto L_0x0a8c;
    L_0x0a84:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x0a8c;
    L_0x0a89:
        r4 = -5;
        r14.a = r4;
    L_0x0a8c:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0b2a;
    L_0x0a96:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x0b2a;
    L_0x0a9c:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r33.q();
        r4 = r4 - r6;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r9;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0b48;
    L_0x0acd:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0b48;
    L_0x0ad3:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x0add:
        r4 = 1;
        r0 = r25;
        r0.z = r4;
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x0aed;
    L_0x0ae8:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x0aed:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0faa }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0faa }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0faa }
        r4.a(r5);	 Catch:{ Throwable -> 0x0faa }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0faa }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0faa }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0faa }
        r14.l = r4;	 Catch:{ Throwable -> 0x0faa }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0faa }
        r14.d = r4;	 Catch:{ Throwable -> 0x0faa }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0faa }
        r14.m = r4;	 Catch:{ Throwable -> 0x0faa }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0faa }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0faa }
    L_0x0b2a:
        if (r17 == 0) goto L_0x0b35;
    L_0x0b2c:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0b35;
    L_0x0b32:
        r33.f();
    L_0x0b35:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x0b3e:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x0b44:
        if (r4 == 0) goto L_0x0062;
    L_0x0b46:
        goto L_0x0062;
    L_0x0b48:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x0add;
    L_0x0b4f:
        r5 = "HttpAccessClientImpl";
        r15 = "not read to buffer, get inputstream...";
        com.tencent.tencentmap.mapsdk.a.fx.b(r5, r15);	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r14.f = r6;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r5 = 0;
        r14.a = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        goto L_0x0920;
    L_0x0b5f:
        r5 = move-exception;
        r6 = r9;
        goto L_0x03a7;
    L_0x0b63:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x09ad;
    L_0x0b6b:
        r5 = 0;
        r0 = r25;
        r0.w = r5;	 Catch:{ Exception -> 0x0a36, Throwable -> 0x0b5f, all -> 0x0f5f }
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r9);
        if (r4 != 0) goto L_0x0ba2;
    L_0x0b9a:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x0ba2;
    L_0x0b9f:
        r4 = -5;
        r14.a = r4;
    L_0x0ba2:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0c40;
    L_0x0bac:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x0c40;
    L_0x0bb2:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r33.q();
        r4 = r4 - r6;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r9;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0c5e;
    L_0x0be3:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0c5e;
    L_0x0be9:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x0bf3:
        r4 = 1;
        r0 = r25;
        r0.z = r4;
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x0c03;
    L_0x0bfe:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x0c03:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0fa4 }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0fa4 }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0fa4 }
        r4.a(r5);	 Catch:{ Throwable -> 0x0fa4 }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0fa4 }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0fa4 }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0fa4 }
        r14.l = r4;	 Catch:{ Throwable -> 0x0fa4 }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0fa4 }
        r14.d = r4;	 Catch:{ Throwable -> 0x0fa4 }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0fa4 }
        r14.m = r4;	 Catch:{ Throwable -> 0x0fa4 }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0fa4 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0fa4 }
    L_0x0c40:
        if (r17 == 0) goto L_0x0c4b;
    L_0x0c42:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0c4b;
    L_0x0c48:
        r33.f();
    L_0x0c4b:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x0c54:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x0c5a:
        if (r4 == 0) goto L_0x0062;
    L_0x0c5c:
        goto L_0x0062;
    L_0x0c5e:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x0bf3;
    L_0x0c65:
        r6 = -21;
        r14.a = r6;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r18 = 10;
        r5 = "location";
        r4 = r4.getFirstHeader(r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        if (r4 == 0) goto L_0x0c8e;
    L_0x0c74:
        r9 = r4.getValue();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r4 = "HttpAccessClientImpl";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r6 = "jumpUrl:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.append(r9);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Exception -> 0x01e0, Throwable -> 0x03a4, all -> 0x050c }
    L_0x0c8e:
        r6 = r9;
        r5 = 1;
        r4 = 1;
        r0 = r25;
        r0.e = r4;	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        if (r4 == 0) goto L_0x0ca2;
    L_0x0c9b:
        r6 = 0;
        r4 = -6;
        r14.a = r4;	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f68 }
        r4 = r7;
        goto L_0x069b;
    L_0x0ca2:
        r4 = r33.k();	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        if (r4 != 0) goto L_0x0fb3;
    L_0x0ca8:
        r4 = "HttpAccessClientImpl";
        r8 = "no auto redirection, return jump url";
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r8);	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        r14.c = r6;	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        r4 = -7;
        r14.a = r4;	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        r4 = r33.l();	 Catch:{ Exception -> 0x0f8c, Throwable -> 0x0f77, all -> 0x0f63 }
        if (r4 == 0) goto L_0x0db3;
    L_0x0cbc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r6);
        if (r4 != 0) goto L_0x0cee;
    L_0x0ce6:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x0cee;
    L_0x0ceb:
        r4 = -5;
        r14.a = r4;
    L_0x0cee:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0d8d;
    L_0x0cf8:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x0d8d;
    L_0x0cfe:
        r4 = java.lang.System.currentTimeMillis();
        r8 = r33.q();
        r4 = r4 - r8;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r6;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0dac;
    L_0x0d2f:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0dac;
    L_0x0d35:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x0d3f:
        r0 = r25;
        r0.z = r7;
        if (r7 == 0) goto L_0x0d50;
    L_0x0d45:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x0d50;
    L_0x0d4b:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x0d50:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0fa1 }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0fa1 }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0fa1 }
        r4.a(r5);	 Catch:{ Throwable -> 0x0fa1 }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0fa1 }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0fa1 }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0fa1 }
        r14.l = r4;	 Catch:{ Throwable -> 0x0fa1 }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0fa1 }
        r14.d = r4;	 Catch:{ Throwable -> 0x0fa1 }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0fa1 }
        r14.m = r4;	 Catch:{ Throwable -> 0x0fa1 }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0fa1 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0fa1 }
    L_0x0d8d:
        if (r17 == 0) goto L_0x0d98;
    L_0x0d8f:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0d98;
    L_0x0d95:
        r33.f();
    L_0x0d98:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x0da1:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x0da7:
        if (r4 != 0) goto L_0x0062;
    L_0x0da9:
        r14 = 0;
        goto L_0x0062;
    L_0x0dac:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x0d3f;
    L_0x0db3:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r33.a();
        r4 = r4.append(r5);
        r5 = "-";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r0 = r25;
        r0.p = r4;
        r0 = r25;
        r0.s = r10;
        r4 = android.text.TextUtils.isEmpty(r6);
        if (r4 != 0) goto L_0x0de5;
    L_0x0ddd:
        r4 = r13 + 1;
        r5 = 6;
        if (r4 <= r5) goto L_0x0de5;
    L_0x0de2:
        r4 = -5;
        r14.a = r4;
    L_0x0de5:
        r4 = com.tencent.tencentmap.mapsdk.a.em.b();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0e84;
    L_0x0def:
        r4 = r14.a;
        r5 = -21;
        if (r4 == r5) goto L_0x0e84;
    L_0x0df5:
        r4 = java.lang.System.currentTimeMillis();
        r8 = r33.q();
        r4 = r4 - r8;
        r4 = (int) r4;
        r14.k = r4;
        r4 = r14.a;
        r0 = r25;
        r0.k = r4;
        r0 = r25;
        r0.C = r12;
        r4 = r14.k;
        r0 = r25;
        r0.l = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r26;
        r4 = (int) r4;
        r0 = r25;
        r0.m = r4;
        r0 = r25;
        r0.f = r6;
        r4 = r33.b();
        if (r4 != 0) goto L_0x0ea2;
    L_0x0e26:
        r4 = r33.h();
        if (r4 == 0) goto L_0x0ea2;
    L_0x0e2c:
        r4 = r33.h();
        r4 = r4.length;
        r4 = (long) r4;
        r0 = r25;
        r0.n = r4;
    L_0x0e36:
        r0 = r25;
        r0.z = r7;
        if (r7 == 0) goto L_0x0e47;
    L_0x0e3c:
        r0 = r25;
        r4 = r0.k;
        if (r4 == 0) goto L_0x0e47;
    L_0x0e42:
        r4 = 1;
        r0 = r25;
        r0.w = r4;
    L_0x0e47:
        r4 = r33.m();
        r0 = r25;
        r0.B = r4;
        r4 = com.tencent.tencentmap.mapsdk.a.el.a();	 Catch:{ Throwable -> 0x0f9e }
        r5 = new com.tencent.tencentmap.mapsdk.a.fe;	 Catch:{ Throwable -> 0x0f9e }
        r0 = r25;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0f9e }
        r4.a(r5);	 Catch:{ Throwable -> 0x0f9e }
        r0 = r33;
        r1 = r25;
        r0.a(r1);	 Catch:{ Throwable -> 0x0f9e }
        r0 = r25;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0f9e }
        r4 = r4.a();	 Catch:{ Throwable -> 0x0f9e }
        r14.l = r4;	 Catch:{ Throwable -> 0x0f9e }
        r4 = r25.toString();	 Catch:{ Throwable -> 0x0f9e }
        r14.d = r4;	 Catch:{ Throwable -> 0x0f9e }
        r0 = r25;
        r4 = r0.p;	 Catch:{ Throwable -> 0x0f9e }
        r14.m = r4;	 Catch:{ Throwable -> 0x0f9e }
        r4 = "statInfo";
        r5 = r25.toString();	 Catch:{ Throwable -> 0x0f9e }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Throwable -> 0x0f9e }
    L_0x0e84:
        if (r17 == 0) goto L_0x0e8f;
    L_0x0e86:
        r4 = r33.l();
        if (r4 != 0) goto L_0x0e8f;
    L_0x0e8c:
        r33.f();
    L_0x0e8f:
        r4 = a(r26);
        r5 = r14.a;
        r6 = -4;
        if (r5 == r6) goto L_0x0062;
    L_0x0e98:
        r5 = r14.a;
        r6 = -17;
        if (r5 == r6) goto L_0x0062;
    L_0x0e9e:
        if (r4 == 0) goto L_0x0062;
    L_0x0ea0:
        goto L_0x0062;
    L_0x0ea2:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x0e36;
    L_0x0ea9:
        r14.a = r6;	 Catch:{ Exception -> 0x0f83, Throwable -> 0x03a4, all -> 0x050c }
        r4 = r7;
        r5 = r8;
        r6 = r9;
        goto L_0x069b;
    L_0x0eb0:
        r7 = r13 + 1;
        r8 = 6;
        if (r7 <= r8) goto L_0x0fb0;
    L_0x0eb5:
        r8 = r10 + 1;
        r7 = 0;
        r9 = -5;
        r14.a = r9;
        r9 = r8;
        goto L_0x06c9;
    L_0x0ebe:
        r28 = 0;
        r0 = r28;
        r2 = r25;
        r2.n = r0;
        goto L_0x0723;
    L_0x0ec8:
        r4 = r15 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ed0;
    L_0x0ecc:
        r4 = -11;
        goto L_0x022a;
    L_0x0ed0:
        r4 = r15 instanceof org.apache.http.NoHttpResponseException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ed8;
    L_0x0ed4:
        r4 = -13;
        goto L_0x022a;
    L_0x0ed8:
        r4 = r15 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ee0;
    L_0x0edc:
        r4 = -14;
        goto L_0x022a;
    L_0x0ee0:
        r4 = r15 instanceof org.apache.http.conn.HttpHostConnectException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ee8;
    L_0x0ee4:
        r4 = -15;
        goto L_0x022a;
    L_0x0ee8:
        r4 = r15 instanceof java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ef0;
    L_0x0eec:
        r4 = -16;
        goto L_0x022a;
    L_0x0ef0:
        r4 = r15 instanceof java.lang.IllegalStateException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0ef8;
    L_0x0ef4:
        r4 = -22;
        goto L_0x022a;
    L_0x0ef8:
        r4 = r15 instanceof java.net.SocketException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0f00;
    L_0x0efc:
        r4 = -12;
        goto L_0x022a;
    L_0x0f00:
        r4 = r15 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x0f6d }
        if (r4 == 0) goto L_0x0f08;
    L_0x0f04:
        r4 = -24;
        goto L_0x022a;
    L_0x0f08:
        r4 = -3;
        goto L_0x022a;
    L_0x0f0b:
        r4 = -4;
        goto L_0x022a;
    L_0x0f0e:
        r7 = r13 + 1;
        r4 = 6;
        if (r7 <= r4) goto L_0x026a;
    L_0x0f13:
        r10 = r10 + 1;
        r7 = 0;
        r4 = -5;
        r14.a = r4;
        goto L_0x026a;
    L_0x0f1b:
        r4 = 0;
        r0 = r25;
        r0.n = r4;
        goto L_0x02bc;
    L_0x0f23:
        r7 = r13 + 1;
        r5 = 6;
        if (r7 <= r5) goto L_0x03d4;
    L_0x0f28:
        r10 = r10 + 1;
        r7 = 0;
        r5 = -5;
        r14.a = r5;
        goto L_0x03d4;
    L_0x0f30:
        r28 = 0;
        r0 = r28;
        r2 = r25;
        r2.n = r0;
        goto L_0x042e;
    L_0x0f3a:
        r8 = 0;
        r0 = r25;
        r0.n = r8;
        goto L_0x0592;
    L_0x0f42:
        r4 = r33.l();
        if (r4 == 0) goto L_0x0062;
    L_0x0f48:
        r14 = new com.tencent.tencentmap.mapsdk.a.fc;
        r14.<init>();
        r4 = -20;
        r14.a = r4;
        goto L_0x0062;
    L_0x0f53:
        r5 = move-exception;
        goto L_0x07cb;
    L_0x0f56:
        r5 = move-exception;
        goto L_0x0a43;
    L_0x0f59:
        r5 = move-exception;
        goto L_0x0920;
    L_0x0f5c:
        r4 = move-exception;
        goto L_0x05e0;
    L_0x0f5f:
        r5 = move-exception;
        r7 = r4;
        goto L_0x050e;
    L_0x0f63:
        r4 = move-exception;
        r5 = r4;
        r9 = r6;
        goto L_0x050e;
    L_0x0f68:
        r4 = move-exception;
        r5 = r4;
        r9 = r6;
        goto L_0x050e;
    L_0x0f6d:
        r4 = move-exception;
        r5 = r4;
        r7 = r16;
        r9 = r6;
        goto L_0x050e;
    L_0x0f74:
        r4 = move-exception;
        goto L_0x047c;
    L_0x0f77:
        r4 = move-exception;
        r4 = r7;
        r8 = r5;
        goto L_0x03a7;
    L_0x0f7c:
        r4 = move-exception;
        r4 = r7;
        goto L_0x03a7;
    L_0x0f80:
        r4 = move-exception;
        goto L_0x030c;
    L_0x0f83:
        r4 = move-exception;
        r15 = r4;
        r16 = r7;
        r6 = r9;
        r18 = r5;
        goto L_0x01e5;
    L_0x0f8c:
        r4 = move-exception;
        r15 = r4;
        r16 = r7;
        r8 = r5;
        goto L_0x01e5;
    L_0x0f93:
        r4 = move-exception;
        r15 = r4;
        r16 = r7;
        r18 = r5;
        goto L_0x01e5;
    L_0x0f9b:
        r4 = move-exception;
        goto L_0x0771;
    L_0x0f9e:
        r4 = move-exception;
        goto L_0x0e84;
    L_0x0fa1:
        r4 = move-exception;
        goto L_0x0d8d;
    L_0x0fa4:
        r4 = move-exception;
        goto L_0x0c40;
    L_0x0fa7:
        r4 = move-exception;
        goto L_0x09fa;
    L_0x0faa:
        r4 = move-exception;
        goto L_0x0b2a;
    L_0x0fad:
        r4 = move-exception;
        goto L_0x08bb;
    L_0x0fb0:
        r9 = r10;
        goto L_0x06c9;
    L_0x0fb3:
        r4 = r7;
        goto L_0x069b;
    L_0x0fb6:
        r5 = r8;
        r6 = r9;
        goto L_0x069b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ez.b(com.tencent.tencentmap.mapsdk.a.fb):com.tencent.tencentmap.mapsdk.a.fc");
    }

    public final ew a(String str) {
        return a(true, str, null);
    }

    public final ew a(String str, byte[] bArr) {
        return a(false, str, bArr);
    }

    public final ex a(ew ewVar) {
        try {
            fb fbVar = (fb) ewVar;
            fbVar.a(System.currentTimeMillis());
            fx.b("REQUEST_TAG", "doRequest... key:" + ewVar.a());
            fc b = b(fbVar);
            fx.b("REQUEST_TAG", "endRequest... key:" + ewVar.a() + "costTime: " + (System.currentTimeMillis() - fbVar.q()));
            return b;
        } catch (Throwable th) {
            fc fcVar = new fc();
            fcVar.a = -19;
            return fcVar;
        }
    }
}

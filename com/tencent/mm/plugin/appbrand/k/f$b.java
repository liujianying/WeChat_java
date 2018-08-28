package com.tencent.mm.plugin.appbrand.k;

public class f$b implements Runnable {
    private g glf;
    final /* synthetic */ f glg;

    public f$b(f fVar, g gVar) {
        this.glg = fVar;
        this.glf = gVar;
    }

    public final void run() {
        b(this.glf);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.tencent.mm.plugin.appbrand.k.g r38) {
        /*
        r37 = this;
        r0 = r38;
        r0 = r0.mUrl;
        r26 = r0;
        r0 = r38;
        r0 = r0.glh;
        r27 = r0;
        r0 = r38;
        r0 = r0.mName;
        r19 = r0;
        r0 = r38;
        r5 = r0.mMimeType;
        r4 = "application/octet-stream";
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r6 == 0) goto L_0x0093;
    L_0x001f:
        r13 = r4;
    L_0x0020:
        r0 = r38;
        r0 = r0.mFileName;
        r28 = r0;
        r4 = "MicroMsg.AppBrandNetworkUpload";
        r5 = "uploadFile filename %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r28;
        com.tencent.mm.sdk.platformtools.x.v(r4, r5, r6);
        r0 = r38;
        r0 = r0.gli;
        r29 = r0;
        r0 = r38;
        r0 = r0.gkX;
        r30 = r0;
        r23 = 0;
        r24 = 0;
        r22 = 0;
        r20 = 0;
        r0 = r38;
        r4 = r0.glj;
        r0 = r38;
        r0 = r0.gkY;
        r31 = r0;
        if (r31 == 0) goto L_0x0095;
    L_0x0055:
        r0 = r31;
        r1 = r26;
        r5 = com.tencent.mm.plugin.appbrand.k.i.b(r0, r1);
        if (r5 != 0) goto L_0x0095;
    L_0x005f:
        r5 = "fail:url not in domain list";
        r4.tS(r5);
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r8 = 0;
        r10 = 0;
        r12 = 0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = "MicroMsg.AppBrandNetworkUpload";
        r5 = "not in domain url %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r26;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
    L_0x0092:
        return;
    L_0x0093:
        r13 = r5;
        goto L_0x0020;
    L_0x0095:
        r15 = 0;
        r18 = 0;
        r17 = 0;
        r14 = 0;
        r0 = r38;
        r5 = r0.bgH;
        if (r5 != 0) goto L_0x00cf;
    L_0x00a1:
        r5 = "force_stop!";
        r4.tS(r5);
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r8 = 0;
        r10 = 0;
        r12 = 0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = "MicroMsg.AppBrandNetworkUpload";
        r5 = "force stop!";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        goto L_0x0092;
    L_0x00cf:
        r0 = r38;
        r5 = r0.mUrl;
        r5 = android.webkit.URLUtil.isHttpsUrl(r5);
        if (r5 != 0) goto L_0x0108;
    L_0x00d9:
        r0 = r38;
        r5 = r0.mUrl;
        r5 = android.webkit.URLUtil.isHttpUrl(r5);
        if (r5 != 0) goto L_0x0108;
    L_0x00e3:
        r5 = "uploadFile protocol must be http or https";
        r4.tS(r5);
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r8 = 0;
        r10 = 0;
        r12 = 0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        goto L_0x0092;
    L_0x0108:
        r32 = "--";
        r6 = java.lang.System.currentTimeMillis();
        r33 = java.lang.Long.toString(r6);
        r34 = "\r\n";
        r25 = "";
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 0;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r7 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r0 = r27;
        r7.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r16 = new java.io.FileInputStream;	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r0 = r16;
        r0.<init>(r7);	 Catch:{ UnsupportedEncodingException -> 0x1041, FileNotFoundException -> 0x100d, SSLHandshakeException -> 0x0fcf, SocketTimeoutException -> 0x0b47, SSLProtocolException -> 0x0c34, Exception -> 0x0d21, all -> 0x0e1c }
        r14 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r26;
        r14.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r14.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r5;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15 = r0;
        r0 = r38;
        r5 = r0.fEl;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 != 0) goto L_0x0150;
    L_0x014c:
        r0 = r38;
        r0.glb = r15;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x0150:
        r5 = r15 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 == 0) goto L_0x018a;
    L_0x0154:
        r0 = r37;
        r5 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.gkD;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 != 0) goto L_0x016c;
    L_0x015c:
        r0 = r37;
        r5 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r37;
        r6 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r6.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = com.tencent.mm.plugin.appbrand.k.i.uP(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5.gkD = r6;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x016c:
        r0 = r37;
        r5 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.gkD;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 == 0) goto L_0x018a;
    L_0x0174:
        r0 = r15;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r0;
        r0 = r37;
        r6 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r6.gkD;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r6.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5.setSSLSocketFactory(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r31;
        com.tencent.mm.plugin.appbrand.k.i.a(r15, r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x018a:
        r5 = 1;
        r15.setDoInput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = 1;
        r15.setDoOutput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = 0;
        r15.setUseCaches(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r38;
        r5 = r0.gkT;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setConnectTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r38;
        r5 = r0.gkT;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setReadTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = "POST";
        r15.setRequestMethod(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = "Connection";
        r6 = "Keep-Alive";
        r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = "Accept-Encoding";
        r6 = "gzip";
        r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "file path = %s, length = %d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r9 = 0;
        r10 = r7.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r9 = 1;
        r10 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = 0;
        r15.setInstanceFollowRedirects(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r30 == 0) goto L_0x0364;
    L_0x01e0:
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "url %s : set header ";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r9 = 0;
        r8[r9] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r30.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x01f7:
        r5 = r8.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 == 0) goto L_0x0364;
    L_0x01fd:
        r5 = r8.next();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r5;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r0;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r9 = "set header for : url %s : key:%s ,value %s ";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11 = 0;
        r10[r11] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11 = 1;
        r12 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11 = 2;
        r12 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        com.tencent.mm.sdk.platformtools.x.i(r5, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 != 0) goto L_0x01f7;
    L_0x022e:
        r5 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 != 0) goto L_0x01f7;
    L_0x023a:
        r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toLowerCase();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r9 = "content-length";
        r5 = r5.contains(r9);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 == 0) goto L_0x02d5;
    L_0x024d:
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "not allow to set Content-Length";
        com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        goto L_0x01f7;
    L_0x0257:
        r5 = move-exception;
        r13 = r5;
    L_0x0259:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 1;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "UnsupportEncodingException : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = "unsupported encoding";
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x02bc;
    L_0x02b9:
        r16.close();	 Catch:{ Exception -> 0x09f1 }
    L_0x02bc:
        if (r17 == 0) goto L_0x02c1;
    L_0x02be:
        r17.close();	 Catch:{ IOException -> 0x0a0d, ArrayIndexOutOfBoundsException -> 0x0a29, Throwable -> 0x0a38 }
    L_0x02c1:
        if (r18 == 0) goto L_0x02c6;
    L_0x02c3:
        r18.close();	 Catch:{ IOException -> 0x0a47 }
    L_0x02c6:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x02d5:
        r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        goto L_0x01f7;
    L_0x02e6:
        r5 = move-exception;
        r13 = r5;
    L_0x02e8:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 3;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "FileNotFoundException : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = "file not exist";
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x034b;
    L_0x0348:
        r16.close();	 Catch:{ Exception -> 0x0a63 }
    L_0x034b:
        if (r17 == 0) goto L_0x0350;
    L_0x034d:
        r17.close();	 Catch:{ IOException -> 0x0a7f, ArrayIndexOutOfBoundsException -> 0x0a9b, Throwable -> 0x0aaa }
    L_0x0350:
        if (r18 == 0) goto L_0x0355;
    L_0x0352:
        r18.close();	 Catch:{ IOException -> 0x0ab9 }
    L_0x0355:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0364:
        r5 = "User-Agent";
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r37;
        r8 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8 = r8.gkE;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = com.tencent.mm.pluginsdk.ui.tools.s.aV(r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r29 == 0) goto L_0x0545;
    L_0x0388:
        r5 = "Content-Type";
        r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r12 = "multipart/form-data; boundary=";
        r6.<init>(r12);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r33;
        r6 = r6.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r29.keySet();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r12 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x03a8:
        r5 = r12.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r5 == 0) goto L_0x04b1;
    L_0x03ae:
        r5 = r12.next();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r29;
        r6 = r0.get(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30 = "MicroMsg.AppBrandNetworkUpload";
        r31 = "append form data: key = %s, value = %s";
        r35 = 2;
        r0 = r35;
        r0 = new java.lang.Object[r0];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r35 = r0;
        r36 = 0;
        r35[r36] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r36 = 1;
        r35[r36] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r1 = r31;
        r2 = r35;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r1 = r32;
        r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r1 = r33;
        r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r1 = r34;
        r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30 = r30.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r31 = "Content-Disposition: form-data; name=\"";
        r30.<init>(r31);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r30;
        r5 = r0.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r30 = "\"";
        r0 = r30;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        goto L_0x03a8;
    L_0x0433:
        r5 = move-exception;
        r13 = r5;
    L_0x0435:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 2;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "SSLHandshakeException : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = "ssl hand shake error";
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x0498;
    L_0x0495:
        r16.close();	 Catch:{ Exception -> 0x0ad5 }
    L_0x0498:
        if (r17 == 0) goto L_0x049d;
    L_0x049a:
        r17.close();	 Catch:{ IOException -> 0x0af1, ArrayIndexOutOfBoundsException -> 0x0b0d, Throwable -> 0x0b1c }
    L_0x049d:
        if (r18 == 0) goto L_0x04a2;
    L_0x049f:
        r18.close();	 Catch:{ IOException -> 0x0b2b }
    L_0x04a2:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x04b1:
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r32;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r33;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = "Content-Disposition: form-data; name=\"";
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r19;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = "\"; filename=\"";
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r28;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = "\"";
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = "Content-Type: ";
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.append(r13);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r32;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r33;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r32;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r34;
        r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x0545:
        r5 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r6 = "UTF-8";
        r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r11.toString();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r10 = "UTF-8";
        r5 = r5.getBytes(r10);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        if (r6 != 0) goto L_0x0560;
    L_0x055d:
        r6 = 0;
        r6 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
    L_0x0560:
        if (r5 != 0) goto L_0x107e;
    L_0x0562:
        r5 = 0;
        r5 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r11 = r5;
    L_0x0566:
        r5 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8 = r8 + r12;
        r5 = r11.length;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r8 = r8 + r12;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r10 = "contentLenght = %d";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r13 = 0;
        r19 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r12[r13] = r19;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        com.tencent.mm.sdk.platformtools.x.i(r5, r10, r12);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = "Content-Length";
        r10 = java.lang.String.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r15.setRequestProperty(r5, r10);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = com.tencent.mm.plugin.appbrand.k.i.f(r15);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r4.t(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r19 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r5 = r15.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r19;
        r0.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x0257, FileNotFoundException -> 0x02e6, SSLHandshakeException -> 0x0433, SocketTimeoutException -> 0x0f93, SSLProtocolException -> 0x0f57, Exception -> 0x0f1b }
        r0 = r19;
        r0.write(r6);	 Catch:{ UnsupportedEncodingException -> 0x1047, FileNotFoundException -> 0x1013, SSLHandshakeException -> 0x0fd5, SocketTimeoutException -> 0x0f97, SSLProtocolException -> 0x0f5b, Exception -> 0x0f1f, all -> 0x0ee4 }
        r5 = com.tencent.mm.plugin.appbrand.k.i.bR(r8);	 Catch:{ UnsupportedEncodingException -> 0x1047, FileNotFoundException -> 0x1013, SSLHandshakeException -> 0x0fd5, SocketTimeoutException -> 0x0f97, SSLProtocolException -> 0x0f5b, Exception -> 0x0f1f, all -> 0x0ee4 }
        r12 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x1047, FileNotFoundException -> 0x1013, SSLHandshakeException -> 0x0fd5, SocketTimeoutException -> 0x0f97, SSLProtocolException -> 0x0f5b, Exception -> 0x0f1f, all -> 0x0ee4 }
        r28 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x1047, FileNotFoundException -> 0x1013, SSLHandshakeException -> 0x0fd5, SocketTimeoutException -> 0x0f97, SSLProtocolException -> 0x0f5b, Exception -> 0x0f1f, all -> 0x0ee4 }
        r10 = -1;
        r8 = r20;
    L_0x05ad:
        r0 = r16;
        r6 = r0.read(r12);	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = -1;
        if (r6 == r5) goto L_0x06a8;
    L_0x05b6:
        r0 = r38;
        r5 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        if (r5 == 0) goto L_0x06a8;
    L_0x05bc:
        r0 = r37;
        r5 = r0.glg;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r5.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = com.tencent.mm.plugin.appbrand.a.pY(r5);	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        if (r5 != 0) goto L_0x0612;
    L_0x05c8:
        r5 = 1;
    L_0x05c9:
        if (r5 == 0) goto L_0x065f;
    L_0x05cb:
        r5 = "interrupted";
        r4.tS(r5);	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r10 = 0;
        r12 = 0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        r16.close();	 Catch:{ Exception -> 0x0629 }
    L_0x0600:
        r19.close();	 Catch:{ IOException -> 0x0644 }
    L_0x0603:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0612:
        r7 = com.tencent.mm.plugin.appbrand.k.f.1.fjn;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r5.fcL;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r5.fjj;	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r5.acv();	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r5.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = r7[r5];	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        switch(r5) {
            case 1: goto L_0x0627;
            case 2: goto L_0x0627;
            default: goto L_0x0625;
        };
    L_0x0625:
        r5 = 0;
        goto L_0x05c9;
    L_0x0627:
        r5 = 1;
        goto L_0x05c9;
    L_0x0629:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0600;
    L_0x0644:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0603;
    L_0x065f:
        r5 = 0;
        r0 = r19;
        r0.write(r12, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r6 = (long) r6;
        r6 = r6 + r8;
        r8 = 0;
        r5 = (r28 > r8 ? 1 : (r28 == r8 ? 0 : -1));
        if (r5 <= 0) goto L_0x107b;
    L_0x066d:
        r0 = r38;
        r5 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        if (r5 == 0) goto L_0x107b;
    L_0x0673:
        r8 = 100;
        r8 = r8 * r6;
        r8 = r8 / r28;
        r5 = (int) r8;	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        if (r10 == r5) goto L_0x0681;
    L_0x067b:
        r8 = r28;
        r4.f(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r10 = r5;
    L_0x0681:
        r8 = "MicroMsg.AppBrandNetworkUpload";
        r9 = "uploadSize %d, totalSize %d, percent = %d";
        r13 = 3;
        r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r18 = 0;
        r20 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r13[r18] = r20;	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r18 = 1;
        r20 = java.lang.Long.valueOf(r28);	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r13[r18] = r20;	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r18 = 2;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r13[r18] = r5;	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        com.tencent.mm.sdk.platformtools.x.v(r8, r9, r13);	 Catch:{ UnsupportedEncodingException -> 0x1055, FileNotFoundException -> 0x1021, SSLHandshakeException -> 0x0fe3, SocketTimeoutException -> 0x0fa5, SSLProtocolException -> 0x0f69, Exception -> 0x0f2d, all -> 0x0ef8 }
        r8 = r6;
        goto L_0x05ad;
    L_0x06a8:
        r0 = r19;
        r0.write(r11);	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r19.flush();	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r12 = r15.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x104d, FileNotFoundException -> 0x1019, SSLHandshakeException -> 0x0fdb, SocketTimeoutException -> 0x0f9d, SSLProtocolException -> 0x0f61, Exception -> 0x0f25, all -> 0x0eef }
        r5 = com.tencent.mm.plugin.appbrand.k.i.e(r15);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r4.t(r5);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r12) goto L_0x0820;
    L_0x06bf:
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "code %d  url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r7[r10] = r11;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10 = 1;
        r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10 = 2;
        r7[r10] = r27;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = com.tencent.mm.plugin.appbrand.k.i.lm(r12);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        if (r5 == 0) goto L_0x0820;
    L_0x06de:
        r5 = com.tencent.mm.plugin.appbrand.k.i.d(r15);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r0 = r38;
        r6 = r0.gkZ;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        if (r7 != 0) goto L_0x0820;
    L_0x06ec:
        if (r6 > 0) goto L_0x0780;
    L_0x06ee:
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "reach the max redirect count(%d)";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10 = 0;
        r11 = 15;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r7[r10] = r11;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.w(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = 0;
        r6 = "reach the max redirect count 15";
        r4.e(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r10 = 0;
        r13 = 1;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        r16.close();	 Catch:{ Exception -> 0x074a }
    L_0x0738:
        r19.close();	 Catch:{ IOException -> 0x0765 }
    L_0x073b:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x074a:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0738;
    L_0x0765:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x073b;
    L_0x0780:
        r7 = "MicroMsg.AppBrandNetworkUpload";
        r10 = "redirect(%d) URL(%s) to URL(%s)";
        r11 = 3;
        r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r13 = 1;
        r0 = r38;
        r14 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r13 = 2;
        r11[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.i(r7, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r0 = r38;
        r0.mUrl = r5;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = r6 + -1;
        r0 = r38;
        r0.gkZ = r5;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r37.b(r38);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r10 = 0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        r16.close();	 Catch:{ Exception -> 0x07ea }
    L_0x07d8:
        r19.close();	 Catch:{ IOException -> 0x0805 }
    L_0x07db:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x07ea:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x07d8;
    L_0x0805:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x07db;
    L_0x0820:
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "url %s ,start to read response ";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10 = 0;
        r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = "gzip";
        r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        if (r5 == 0) goto L_0x0874;
    L_0x083c:
        r5 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r6 = r15.getInputStream();	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r17 = r5;
    L_0x0847:
        if (r17 == 0) goto L_0x1075;
    L_0x0849:
        r5 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r0 = r17;
        r6.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
    L_0x085a:
        r7 = r5.readLine();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        if (r7 == 0) goto L_0x08c6;
    L_0x0860:
        r0 = r38;
        r10 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        if (r10 == 0) goto L_0x08c6;
    L_0x0866:
        r6.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        goto L_0x085a;
    L_0x086a:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x0259;
    L_0x0874:
        r17 = r15.getInputStream();	 Catch:{ Exception -> 0x0879, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        goto L_0x0847;
    L_0x0879:
        r5 = move-exception;
        r6 = "MicroMsg.AppBrandNetworkUpload";
        r7 = "getInputStream error : %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r11 = 0;
        r10[r11] = r5;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r5 = "gzip";
        r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        if (r5 == 0) goto L_0x08a2;
    L_0x0896:
        r5 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r6 = r15.getErrorStream();	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        r17 = r5;
        goto L_0x0847;
    L_0x08a2:
        r17 = r15.getErrorStream();	 Catch:{ Exception -> 0x08a7, UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, all -> 0x0f02 }
        goto L_0x0847;
    L_0x08a7:
        r5 = move-exception;
        r6 = "MicroMsg.AppBrandNetworkUpload";
        r7 = "read err stream failed : %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r11 = 0;
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r10[r11] = r5;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        com.tencent.mm.sdk.platformtools.x.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        goto L_0x0847;
    L_0x08bc:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x02e8;
    L_0x08c6:
        r5 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6 = "UTF-8";
        r6 = java.nio.charset.Charset.forName(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r6 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x08bc, SSLHandshakeException -> 0x0feb, SocketTimeoutException -> 0x0fad, SSLProtocolException -> 0x0f71, Exception -> 0x0f35, all -> 0x0f02 }
        r7 = "MicroMsg.AppBrandNetworkUpload";
        r10 = "upload for url : %s, result = %s, statecode = %s";
        r11 = 3;
        r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        r13 = 0;
        r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        r13 = 1;
        r11[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        r13 = 2;
        r14 = java.lang.Integer.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        com.tencent.mm.sdk.platformtools.x.i(r7, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x105d, FileNotFoundException -> 0x1029, SSLHandshakeException -> 0x0ff5, SocketTimeoutException -> 0x0fb7, SSLProtocolException -> 0x0f7b, Exception -> 0x0f3f, all -> 0x0f09 }
        r10 = r6;
    L_0x08f0:
        r0 = r38;
        r6 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        if (r6 == 0) goto L_0x0953;
    L_0x08f6:
        r6 = 0;
        r4.e(r6, r5, r12);	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "success : url = %s, filePath = %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r11 = 0;
        r7[r11] = r26;	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r11 = 1;
        r7[r11] = r27;	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r4 = 1;
    L_0x090d:
        if (r4 == 0) goto L_0x0966;
    L_0x090f:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r10 = (long) r10;
        r13 = 1;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
    L_0x0929:
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        r16.close();	 Catch:{ Exception -> 0x0981 }
    L_0x093c:
        if (r17 == 0) goto L_0x0941;
    L_0x093e:
        r17.close();	 Catch:{ IOException -> 0x099c, ArrayIndexOutOfBoundsException -> 0x09b7, Throwable -> 0x09c6 }
    L_0x0941:
        r19.close();	 Catch:{ IOException -> 0x09d5 }
    L_0x0944:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0953:
        r5 = 0;
        r6 = "force_stop!";
        r4.e(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "force stop!";
        com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x1069, FileNotFoundException -> 0x1035, SSLHandshakeException -> 0x1001, SocketTimeoutException -> 0x0fc3, SSLProtocolException -> 0x0f87, Exception -> 0x0f4b, all -> 0x0f12 }
        r4 = r24;
        goto L_0x090d;
    L_0x0966:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r10 = (long) r10;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        goto L_0x0929;
    L_0x0981:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x093c;
    L_0x099c:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0941;
    L_0x09b7:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0941;
    L_0x09c6:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0941;
    L_0x09d5:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0944;
    L_0x09f1:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x02bc;
    L_0x0a0d:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x02c1;
    L_0x0a29:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x02c1;
    L_0x0a38:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x02c1;
    L_0x0a47:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x02c6;
    L_0x0a63:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x034b;
    L_0x0a7f:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0350;
    L_0x0a9b:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0350;
    L_0x0aaa:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0350;
    L_0x0ab9:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0355;
    L_0x0ad5:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0498;
    L_0x0af1:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x049d;
    L_0x0b0d:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x049d;
    L_0x0b1c:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x049d;
    L_0x0b2b:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x04a2;
    L_0x0b47:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
    L_0x0b4b:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 4;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "SocketTimeoutException : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = "socket timeout error";
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x0bae;
    L_0x0bab:
        r16.close();	 Catch:{ Exception -> 0x0bc7 }
    L_0x0bae:
        if (r17 == 0) goto L_0x0bb3;
    L_0x0bb0:
        r17.close();	 Catch:{ IOException -> 0x0be2, ArrayIndexOutOfBoundsException -> 0x0bfd, Throwable -> 0x0c0b }
    L_0x0bb3:
        if (r18 == 0) goto L_0x0bb8;
    L_0x0bb5:
        r18.close();	 Catch:{ IOException -> 0x0c19 }
    L_0x0bb8:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0bc7:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0bae;
    L_0x0be2:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0bb3;
    L_0x0bfd:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0bb3;
    L_0x0c0b:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0bb3;
    L_0x0c19:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0bb8;
    L_0x0c34:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
    L_0x0c38:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 6;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "SSLProtocolException: %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = "ssl protocol error";
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x0c9b;
    L_0x0c98:
        r16.close();	 Catch:{ Exception -> 0x0cb4 }
    L_0x0c9b:
        if (r17 == 0) goto L_0x0ca0;
    L_0x0c9d:
        r17.close();	 Catch:{ IOException -> 0x0ccf, ArrayIndexOutOfBoundsException -> 0x0cea, Throwable -> 0x0cf8 }
    L_0x0ca0:
        if (r18 == 0) goto L_0x0ca5;
    L_0x0ca2:
        r18.close();	 Catch:{ IOException -> 0x0d06 }
    L_0x0ca5:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0cb4:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0c9b;
    L_0x0ccf:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0ca0;
    L_0x0cea:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0ca0;
    L_0x0cf8:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0ca0;
    L_0x0d06:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0ca5;
    L_0x0d21:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
    L_0x0d25:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0edb }
        r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r8 = 5;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0edb }
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception1: %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0edb }
        r8 = 0;
        r9 = r13.toString();	 Catch:{ all -> 0x0edb }
        r7[r8] = r9;	 Catch:{ all -> 0x0edb }
        r8 = 1;
        r7[r8] = r26;	 Catch:{ all -> 0x0edb }
        r8 = 2;
        r7[r8] = r27;	 Catch:{ all -> 0x0edb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r13, r6, r7);	 Catch:{ all -> 0x0edb }
        r5 = -1;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0edb }
        r6.<init>();	 Catch:{ all -> 0x0edb }
        r7 = r13.getMessage();	 Catch:{ all -> 0x0edb }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0edb }
        r6 = r6.toString();	 Catch:{ all -> 0x0edb }
        r0 = r22;
        r4.e(r5, r6, r0);	 Catch:{ all -> 0x0edb }
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        r8 = r20;
        r12 = r22;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x0d96;
    L_0x0d93:
        r16.close();	 Catch:{ Exception -> 0x0daf }
    L_0x0d96:
        if (r17 == 0) goto L_0x0d9b;
    L_0x0d98:
        r17.close();	 Catch:{ IOException -> 0x0dca, ArrayIndexOutOfBoundsException -> 0x0de5, Throwable -> 0x0df3 }
    L_0x0d9b:
        if (r18 == 0) goto L_0x0da0;
    L_0x0d9d:
        r18.close();	 Catch:{ IOException -> 0x0e01 }
    L_0x0da0:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        goto L_0x0092;
    L_0x0daf:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0d96;
    L_0x0dca:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0d9b;
    L_0x0de5:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0d9b;
    L_0x0df3:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0d9b;
    L_0x0e01:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0da0;
    L_0x0e1c:
        r4 = move-exception;
        r24 = r4;
        r16 = r14;
        r8 = r20;
        r12 = r22;
    L_0x0e25:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.mAppId;
        r0 = r38;
        r5 = r0.glc;
        r6 = "POST";
        r0 = r38;
        r7 = r0.mUrl;
        r0 = r23;
        r10 = (long) r0;
        r13 = 2;
        r14 = r38.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        r4 = 0;
        r0 = r38;
        r0.bgH = r4;
        r0 = r37;
        r4 = r0.glg;
        r0 = r38;
        r5 = r0.fEl;
        com.tencent.mm.plugin.appbrand.k.f.a(r4, r5, r15);
        if (r16 == 0) goto L_0x0e56;
    L_0x0e53:
        r16.close();	 Catch:{ Exception -> 0x0e6e }
    L_0x0e56:
        if (r17 == 0) goto L_0x0e5b;
    L_0x0e58:
        r17.close();	 Catch:{ IOException -> 0x0e89, ArrayIndexOutOfBoundsException -> 0x0ea4, Throwable -> 0x0eb2 }
    L_0x0e5b:
        if (r18 == 0) goto L_0x0e60;
    L_0x0e5d:
        r18.close();	 Catch:{ IOException -> 0x0ec0 }
    L_0x0e60:
        r0 = r37;
        r4 = r0.glg;
        r4 = r4.gkF;
        r0 = r38;
        r5 = r0.fEl;
        r4.remove(r5);
        throw r24;
    L_0x0e6e:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception2 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0e56;
    L_0x0e89:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception3 : %s , url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0e5b;
    L_0x0ea4:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0e5b;
    L_0x0eb2:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0e5b;
    L_0x0ec0:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkUpload";
        r6 = "exception4 : %s ,url is %s filepath %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.toString();
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r26;
        r8 = 2;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0e60;
    L_0x0edb:
        r4 = move-exception;
        r24 = r4;
        r8 = r20;
        r12 = r22;
        goto L_0x0e25;
    L_0x0ee4:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        r8 = r20;
        r12 = r22;
        goto L_0x0e25;
    L_0x0eef:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        r12 = r22;
        goto L_0x0e25;
    L_0x0ef8:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        r8 = r6;
        r12 = r22;
        goto L_0x0e25;
    L_0x0f02:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        goto L_0x0e25;
    L_0x0f09:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        r23 = r6;
        goto L_0x0e25;
    L_0x0f12:
        r4 = move-exception;
        r24 = r4;
        r18 = r19;
        r23 = r10;
        goto L_0x0e25;
    L_0x0f1b:
        r5 = move-exception;
        r13 = r5;
        goto L_0x0d25;
    L_0x0f1f:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x0d25;
    L_0x0f25:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x0d25;
    L_0x0f2d:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x0d25;
    L_0x0f35:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x0d25;
    L_0x0f3f:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x0d25;
    L_0x0f4b:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x0d25;
    L_0x0f57:
        r5 = move-exception;
        r13 = r5;
        goto L_0x0c38;
    L_0x0f5b:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x0c38;
    L_0x0f61:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x0c38;
    L_0x0f69:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x0c38;
    L_0x0f71:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x0c38;
    L_0x0f7b:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x0c38;
    L_0x0f87:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x0c38;
    L_0x0f93:
        r5 = move-exception;
        r13 = r5;
        goto L_0x0b4b;
    L_0x0f97:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x0b4b;
    L_0x0f9d:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x0b4b;
    L_0x0fa5:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x0b4b;
    L_0x0fad:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x0b4b;
    L_0x0fb7:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x0b4b;
    L_0x0fc3:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x0b4b;
    L_0x0fcf:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
        goto L_0x0435;
    L_0x0fd5:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x0435;
    L_0x0fdb:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x0435;
    L_0x0fe3:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x0435;
    L_0x0feb:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        goto L_0x0435;
    L_0x0ff5:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x0435;
    L_0x1001:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x0435;
    L_0x100d:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
        goto L_0x02e8;
    L_0x1013:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x02e8;
    L_0x1019:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x02e8;
    L_0x1021:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x02e8;
    L_0x1029:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x02e8;
    L_0x1035:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x02e8;
    L_0x1041:
        r5 = move-exception;
        r13 = r5;
        r16 = r14;
        goto L_0x0259;
    L_0x1047:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        goto L_0x0259;
    L_0x104d:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        goto L_0x0259;
    L_0x1055:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r6;
        goto L_0x0259;
    L_0x105d:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r6;
        goto L_0x0259;
    L_0x1069:
        r5 = move-exception;
        r13 = r5;
        r18 = r19;
        r20 = r8;
        r22 = r12;
        r23 = r10;
        goto L_0x0259;
    L_0x1075:
        r5 = r25;
        r10 = r23;
        goto L_0x08f0;
    L_0x107b:
        r8 = r6;
        goto L_0x05ad;
    L_0x107e:
        r11 = r5;
        goto L_0x0566;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.k.f$b.b(com.tencent.mm.plugin.appbrand.k.g):void");
    }
}

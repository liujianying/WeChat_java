package com.tencent.mm.plugin.game.wepkg.downloader;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.concurrent.Future;
import javax.net.ssl.SSLContext;

public final class c implements Runnable {
    f kdY;
    Future<?> kdZ;
    HttpURLConnection kea;
    private String keb;
    private String kec;
    private String ked;
    boolean kee;
    private boolean kef;
    private boolean keg = false;
    private String mContentType;
    private int mStatusCode;
    private int retCode = 0;

    public c(f fVar) {
        this.kdY = fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r15 = this;
        r14 = 2;
        r6 = -1;
        r13 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
        r7 = 1;
        r8 = 0;
        r0 = r15.kdY;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r15.kdY;
        r0 = r0.mUrl;
        if (r0 == 0) goto L_0x000a;
    L_0x0011:
        r0 = r15.kdY;
        r9 = r0.isR;
        r5 = r8;
    L_0x0016:
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r0 = r0.mUrl;	 Catch:{ Exception -> 0x0180 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0180 }
        r0 = r1.openConnection();	 Catch:{ Exception -> 0x0180 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0180 }
        r15.kea = r0;	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r2 = r2.keC;	 Catch:{ Exception -> 0x0180 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r2 = r2.keD;	 Catch:{ Exception -> 0x0180 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = 0;
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = "GET";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = 0;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = 1;
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r2 = "Accept-Encoding";
        r3 = "identity";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0180 }
        r0 = "http.agent";
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Exception -> 0x0180 }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ Exception -> 0x0180 }
        if (r2 != 0) goto L_0x0079;
    L_0x0071:
        r2 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r3 = "User-agent";
        r2.setRequestProperty(r3, r0);	 Catch:{ Exception -> 0x0180 }
    L_0x0079:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r0 = r0.keE;	 Catch:{ Exception -> 0x0180 }
        if (r0 == 0) goto L_0x0177;
    L_0x007f:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180 }
        r2 = com.tencent.mm.pluginsdk.g.a.d.a.Io(r0);	 Catch:{ Exception -> 0x0180 }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "%s: RangeOffset = %d";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0180 }
        r11 = 0;
        r12 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r12 = r12.kev;	 Catch:{ Exception -> 0x0180 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180 }
        r11 = 1;
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0180 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r10);	 Catch:{ Exception -> 0x0180 }
        r10 = 0;
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x0155;
    L_0x00a7:
        r0 = r8;
    L_0x00a8:
        r15.kef = r0;	 Catch:{ Exception -> 0x0180 }
    L_0x00aa:
        r0 = "https";
        r1 = r1.getProtocol();	 Catch:{ Exception -> 0x0180 }
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0180 }
        if (r0 == 0) goto L_0x00e8;
    L_0x00b7:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r2 = r0.keC;	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0180 }
        r1 = "TLSv1.2";
        r1 = Eb(r1);	 Catch:{ Exception -> 0x0180 }
        if (r1 != 0) goto L_0x00d5;
    L_0x00c8:
        r1 = "TLSv1";
        r1 = Eb(r1);	 Catch:{ Exception -> 0x0180 }
        if (r1 != 0) goto L_0x00d5;
    L_0x00d1:
        r1 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ Exception -> 0x02c6 }
    L_0x00d5:
        if (r1 == 0) goto L_0x01ec;
    L_0x00d7:
        r3 = 0;
        r4 = 0;
        r10 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x01eb }
        r10.<init>();	 Catch:{ Exception -> 0x01eb }
        r1.init(r3, r4, r10);	 Catch:{ Exception -> 0x01eb }
        r1 = r1.getSocketFactory();	 Catch:{ Exception -> 0x01eb }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x01eb }
    L_0x00e8:
        r15.aVr();	 Catch:{ Exception -> 0x0180 }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "handle responose retcode:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0180 }
        r3 = 0;
        r4 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0180 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        if (r0 != 0) goto L_0x0237;
    L_0x0104:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r0 = r0.keF;	 Catch:{ Exception -> 0x0180 }
        if (r0 == 0) goto L_0x028c;
    L_0x010a:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r10 = r0.keF;	 Catch:{ Exception -> 0x0180 }
        r0 = new com.tencent.mm.plugin.game.wepkg.downloader.g;	 Catch:{ Exception -> 0x0180 }
        r1 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r2 = 1;
        r3 = 0;
        r4 = r15.keg;	 Catch:{ Exception -> 0x0180 }
        if (r4 == 0) goto L_0x0234;
    L_0x0118:
        r4 = r7;
    L_0x0119:
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0180 }
        r10.a(r0);	 Catch:{ Exception -> 0x0180 }
        r0 = r15.kdY;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x012c:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x000a;
    L_0x0130:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x000a;
    L_0x0134:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.kdY;
        r1 = r15.kdY;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.keg = r8;
        goto L_0x000a;
    L_0x0155:
        r0 = r15.kea;	 Catch:{ Exception -> 0x0180 }
        r4 = "Range";
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0180 }
        r11 = "bytes=";
        r10.<init>(r11);	 Catch:{ Exception -> 0x0180 }
        r2 = r10.append(r2);	 Catch:{ Exception -> 0x0180 }
        r3 = "-";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0180 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0180 }
        r0.addRequestProperty(r4, r2);	 Catch:{ Exception -> 0x0180 }
        r0 = r7;
        goto L_0x00a8;
    L_0x0177:
        r0 = r15.kdY;	 Catch:{ Exception -> 0x0180 }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180 }
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(r0);	 Catch:{ Exception -> 0x0180 }
        goto L_0x00aa;
    L_0x0180:
        r0 = move-exception;
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r2 = "run exception : %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x01fe }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x01fe }
        r3[r4] = r0;	 Catch:{ all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ all -> 0x01fe }
        r0 = r15.kdY;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x01a1:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01c9;
    L_0x01a5:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x01a9:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.kdY;
        r1 = r15.kdY;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.keg = r8;
        r5 = r6;
    L_0x01c9:
        r5 = r5 + 1;
        if (r5 < r9) goto L_0x0016;
    L_0x01cd:
        r0 = r15.kdY;
        r0 = r0.keF;
        if (r0 == 0) goto L_0x000a;
    L_0x01d3:
        r0 = r15.kdY;
        r6 = r0.keF;
        r0 = new com.tencent.mm.plugin.game.wepkg.downloader.g;
        r1 = r15.kdY;
        r3 = r15.retCode;
        r2 = r15.keg;
        if (r2 == 0) goto L_0x02c3;
    L_0x01e1:
        r4 = r7;
    L_0x01e2:
        r2 = r14;
        r0.<init>(r1, r2, r3, r4, r5);
        r6.a(r0);
        goto L_0x000a;
    L_0x01eb:
        r1 = move-exception;
    L_0x01ec:
        r1 = new android.net.SSLSessionCache;	 Catch:{ Exception -> 0x0180 }
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x0180 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0180 }
        r1 = android.net.SSLCertificateSocketFactory.getDefault(r2, r1);	 Catch:{ Exception -> 0x0180 }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x0180 }
        goto L_0x00e8;
    L_0x01fe:
        r0 = move-exception;
        r1 = r15.kdY;
        r1 = r1.mUrl;
        r2 = "https";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0233;
    L_0x020c:
        r1 = r15.retCode;
        if (r1 != r13) goto L_0x0233;
    L_0x0210:
        r1 = r9 + -1;
        if (r5 < r1) goto L_0x0233;
    L_0x0214:
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r2 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r15.kdY;
        r2 = r15.kdY;
        r2 = r2.mUrl;
        r3 = "https";
        r4 = "http";
        r2 = r2.replaceFirst(r3, r4);
        r1.mUrl = r2;
        r15.retCode = r8;
        r15.keg = r8;
    L_0x0233:
        throw r0;
    L_0x0234:
        r4 = r8;
        goto L_0x0119;
    L_0x0237:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r1 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        if (r0 == r1) goto L_0x0255;
    L_0x023d:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r1 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        if (r0 == r1) goto L_0x0255;
    L_0x0243:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r1 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
        if (r0 == r1) goto L_0x0255;
    L_0x0249:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        if (r0 == r1) goto L_0x0255;
    L_0x024f:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180 }
        r1 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        if (r0 != r1) goto L_0x028c;
    L_0x0255:
        r0 = r15.kdY;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01cd;
    L_0x0262:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01cd;
    L_0x0266:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01cd;
    L_0x026a:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.kdY;
        r1 = r15.kdY;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.keg = r8;
        r5 = r6;
        goto L_0x01cd;
    L_0x028c:
        r0 = r15.kdY;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x0299:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01c9;
    L_0x029d:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x02a1:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.kdY;
        r1 = r15.kdY;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.keg = r8;
        r5 = r6;
        goto L_0x01c9;
    L_0x02c3:
        r4 = r8;
        goto L_0x01e2;
    L_0x02c6:
        r3 = move-exception;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.wepkg.downloader.c.run():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aVr() {
        /*
        r12 = this;
        r4 = 1;
        r3 = 0;
        r1 = 0;
        r0 = 0;
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r2.getResponseCode();	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.mStatusCode = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "%s: received status code = %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r7 = 0;
        r8 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = r8.kev;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6[r7] = r8;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r7 = 1;
        r8 = r12.mStatusCode;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6[r7] = r8;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.mStatusCode;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        switch(r2) {
            case 200: goto L_0x0039;
            case 206: goto L_0x0039;
            default: goto L_0x002d;
        };	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
    L_0x002d:
        r2 = r12.mStatusCode;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.retCode = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r1;
    L_0x0032:
        com.tencent.mm.pluginsdk.g.a.d.a.g(r2);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r0);
    L_0x0038:
        return;
    L_0x0039:
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = "Content-Type";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.mContentType = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2.getHeaderFields();	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = "Content-Range";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.keb = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = "Content-Length";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.kec = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = "bytes";
        r6 = "Accept-Ranges";
        r2 = r2.getHeaderField(r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r5.equals(r2);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r2 == 0) goto L_0x00c7;
    L_0x0071:
        r2 = r4;
    L_0x0072:
        r5 = r12.kef;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r5 == 0) goto L_0x00ff;
    L_0x0076:
        if (r2 != 0) goto L_0x00da;
    L_0x0078:
        r5 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r6 = "Header no Accept-Ranges, not support range";
        com.tencent.mm.sdk.platformtools.x.i(r5, r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r5.mFilePath;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r12.kec;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6 = Ed(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r2;
    L_0x008f:
        r12.keg = r5;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r8 = "%s: content-range = %s, content-length = %s, content-type = %s, isSupportRange = %b";
        r9 = 5;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 0;
        r11 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r11 = r11.kev;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 1;
        r11 = r12.keb;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 2;
        r11 = r12.kec;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 3;
        r11 = r12.mContentType;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 4;
        r11 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        com.tencent.mm.sdk.platformtools.x.i(r2, r8, r9);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = -1;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0110;
    L_0x00c0:
        r2 = 1010; // 0x3f2 float:1.415E-42 double:4.99E-321;
        r12.retCode = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r1;
        goto L_0x0032;
    L_0x00c7:
        r2 = r12.keb;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r2 == 0) goto L_0x00d8;
    L_0x00cb:
        r2 = r12.keb;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = "bytes";
        r2 = r2.startsWith(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r2 == 0) goto L_0x00d8;
    L_0x00d6:
        r2 = r4;
        goto L_0x0072;
    L_0x00d8:
        r2 = r3;
        goto L_0x0072;
    L_0x00da:
        r5 = r12.keb;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = Ec(r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6 = (long) r5;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x02b3;
    L_0x00e7:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "content-range in header is error, not support range";
        com.tencent.mm.sdk.platformtools.x.i(r2, r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r2.mFilePath;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(r2);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kec;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6 = Ed(r2);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r3;
        goto L_0x008f;
    L_0x00ff:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "local dont have download file. not support range";
        com.tencent.mm.sdk.platformtools.x.i(r2, r5);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kec;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6 = Ed(r2);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = r3;
        goto L_0x008f;
    L_0x0110:
        r2 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = r2.keA;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r10 = 0;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0147;
    L_0x011a:
        r2 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = r2.keA;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 == 0) goto L_0x0147;
    L_0x0122:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r3 = "ServerLength(%d) != HeaderLength(%d)";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = 0;
        r8 = r12.kdY;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = r8.keA;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r4[r5] = r8;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r5 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r4[r5] = r6;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        r12.retCode = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r1;
        goto L_0x0032;
    L_0x0147:
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r2.getContentEncoding();	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r12.ked = r2;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.kea;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r6 = r2.getInputStream();	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = r12.ked;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r2 != 0) goto L_0x01cd;
    L_0x015d:
        r2 = r12.ked;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r7 = "gzip";
        r2 = r2.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        if (r2 == 0) goto L_0x01cd;
    L_0x0168:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2.<init>(r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
    L_0x016d:
        r1 = r12.kdY;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r6 = r1.mFilePath;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r1 = r12.kdY;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r1 = r1.kev;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r7 = r12.kef;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        if (r7 == 0) goto L_0x01d8;
    L_0x0179:
        if (r5 == 0) goto L_0x01d8;
    L_0x017b:
        r7 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r8 = "%s: getOutputStream, filePath %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r10 = 0;
        r9[r10] = r1;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r10 = 1;
        r9[r10] = r6;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        com.tencent.mm.sdk.platformtools.x.d(r7, r8, r9);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r6);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        if (r7 == 0) goto L_0x01da;
    L_0x0193:
        r3 = new java.io.FileNotFoundException;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r4 = "%s filePath is null or nil";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r6 = 0;
        r5[r6] = r1;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        throw r3;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
    L_0x01a6:
        r1 = move-exception;
        r3 = r1;
        r4 = r0;
        r5 = r2;
    L_0x01aa:
        r0 = r12.kee;	 Catch:{ all -> 0x025f }
        if (r0 == 0) goto L_0x024f;
    L_0x01ae:
        r0 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r12.retCode = r0;	 Catch:{ all -> 0x025f }
    L_0x01b2:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "exception : %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x025f }
        r6 = 0;
        r3 = r3.getMessage();	 Catch:{ all -> 0x025f }
        r2[r6] = r3;	 Catch:{ all -> 0x025f }
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);	 Catch:{ all -> 0x025f }
        com.tencent.mm.pluginsdk.g.a.d.a.g(r5);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r4);
        goto L_0x0038;
    L_0x01cd:
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        r2.<init>(r6);	 Catch:{ Exception -> 0x01d3, all -> 0x029e }
        goto L_0x016d;
    L_0x01d3:
        r2 = move-exception;
        r3 = r2;
        r4 = r0;
        r5 = r1;
        goto L_0x01aa;
    L_0x01d8:
        r4 = r3;
        goto L_0x017b;
    L_0x01da:
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r7 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r7.<init>(r6, r4);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x01a6, all -> 0x02a3 }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "%s: append = %b, isSupportRange = %s";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r7 = 0;
        r8 = r12.kdY;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r8 = r8.kev;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r7 = 1;
        r8 = r12.kef;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r7 = 2;
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6[r7] = r5;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r6);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r0];	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r0 = r3;
    L_0x020c:
        r3 = 0;
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = r2.read(r4, r3, r5);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r5 = -1;
        if (r3 == r5) goto L_0x021c;
    L_0x0216:
        r5 = 0;
        r1.write(r4, r5, r3);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r0 = r0 + r3;
        goto L_0x020c;
    L_0x021c:
        r3 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "%s: read count = %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6 = 0;
        r7 = r12.kdY;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r7 = r7.mUrl;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r1.flush();	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r3 = "%s: download complete, flush and send complete status";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r5 = 0;
        r6 = r12.kdY;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r6 = r6.mUrl;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);	 Catch:{ Exception -> 0x02ad, all -> 0x02a8 }
        r0 = r1;
        goto L_0x0032;
    L_0x024f:
        r0 = com.tencent.mm.kernel.g.DF();	 Catch:{ all -> 0x025f }
        r0 = r0.Lg();	 Catch:{ all -> 0x025f }
        if (r0 != 0) goto L_0x0268;
    L_0x0259:
        r0 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r12.retCode = r0;	 Catch:{ all -> 0x025f }
        goto L_0x01b2;
    L_0x025f:
        r0 = move-exception;
        r3 = r0;
    L_0x0261:
        com.tencent.mm.pluginsdk.g.a.d.a.g(r5);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r4);
        throw r3;
    L_0x0268:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = r3 instanceof javax.net.ssl.SSLException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0274;
    L_0x026e:
        r0 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
    L_0x0270:
        r12.retCode = r0;	 Catch:{ all -> 0x025f }
        goto L_0x01b2;
    L_0x0274:
        r1 = r3 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x027b;
    L_0x0278:
        r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        goto L_0x0270;
    L_0x027b:
        r1 = r3 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0282;
    L_0x027f:
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        goto L_0x0270;
    L_0x0282:
        r1 = r3 instanceof java.net.ConnectException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0289;
    L_0x0286:
        r0 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        goto L_0x0270;
    L_0x0289:
        r1 = r3 instanceof java.net.SocketException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0290;
    L_0x028d:
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        goto L_0x0270;
    L_0x0290:
        r1 = r3 instanceof java.io.IOException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0297;
    L_0x0294:
        r0 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        goto L_0x0270;
    L_0x0297:
        r1 = r3 instanceof java.lang.InterruptedException;	 Catch:{ all -> 0x025f }
        if (r1 == 0) goto L_0x0270;
    L_0x029b:
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        goto L_0x0270;
    L_0x029e:
        r2 = move-exception;
        r3 = r2;
        r4 = r0;
        r5 = r1;
        goto L_0x0261;
    L_0x02a3:
        r1 = move-exception;
        r3 = r1;
        r4 = r0;
        r5 = r2;
        goto L_0x0261;
    L_0x02a8:
        r0 = move-exception;
        r3 = r0;
        r4 = r1;
        r5 = r2;
        goto L_0x0261;
    L_0x02ad:
        r0 = move-exception;
        r3 = r0;
        r4 = r1;
        r5 = r2;
        goto L_0x01aa;
    L_0x02b3:
        r5 = r2;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.wepkg.downloader.c.aVr():void");
    }

    private static SSLContext Eb(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static int Ec(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split != null && split.length == 2) {
                try {
                    return Integer.valueOf(split[1]).intValue();
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1;
    }

    private static long Ed(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return -1;
    }
}
